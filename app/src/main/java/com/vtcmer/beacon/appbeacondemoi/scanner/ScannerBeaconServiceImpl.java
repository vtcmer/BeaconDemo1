package com.vtcmer.beacon.appbeacondemoi.scanner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.RemoteException;
import android.util.Log;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vtcmer on 8/03/18.
 */

@SuppressLint("LongLogTag")
public class ScannerBeaconServiceImpl implements ScannerBeaconService, BeaconConsumer, RangeNotifier {

    private static final String TAG = "ScannerBeaconServiceImpl";

    private static final String ALL_BEACONS_REGION = "AllBeaconsRegion";

    private Context context;
    private OnScannerBeaconServiceCallback onScannerBeaconServiceCallback;

    private BeaconManager mBeaconManager;

    // Representa el criterio de campos con los que buscar beacons
    private Region mRegion;

    public ScannerBeaconServiceImpl(final Context context, final OnScannerBeaconServiceCallback onScannerBeaconServiceCallback){
        this.context = context;
        this.onScannerBeaconServiceCallback = onScannerBeaconServiceCallback;

        mBeaconManager = BeaconManager.getInstanceForApplication(this.context);
        // En este ejemplo vamos a usar el protocolo Eddystone, así que tenemos que definirlo aquí
        mBeaconManager.getBeaconParsers().add(new BeaconParser().
                setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));

        ArrayList<Identifier> identifiers = new ArrayList<>();

        mRegion = new Region(ALL_BEACONS_REGION, identifiers);

    }


    @Override
    public void startScan(){
        mBeaconManager.setForegroundScanPeriod(6000l);
        mBeaconManager.bind(this);
    }


    @Override
    public void stopScan(){

        try {
            mBeaconManager.stopMonitoringBeaconsInRegion(mRegion);

        } catch (RemoteException e) {
            Log.d(TAG, "Se ha producido una excepción al parar de buscar beacons " + e.getMessage(),e);
        }

        mBeaconManager.removeAllRangeNotifiers();

        // Desenlazar servicio de beacons
        mBeaconManager.unbind(this);


    }

    @Override
    public void onDestroyScanner(){
        mBeaconManager.removeAllRangeNotifiers();
        mBeaconManager.unbind(this);
    }


    @Override
    public void onBeaconServiceConnect() {

        try {
            // Empezar a buscar los beacons que encajen con el el objeto Región pasado, incluyendo
            // actualizaciones en la distancia estimada
            mBeaconManager.startRangingBeaconsInRegion(mRegion);

        } catch (RemoteException e) {
            Log.d(TAG, "Se ha producido una excepción al empezar a buscar beacons " + e.getMessage(),e);
        }

        mBeaconManager.addRangeNotifier(this);

    }

    @Override
    public Context getApplicationContext() {
        return context;
    }

    @Override
    public void unbindService(ServiceConnection serviceConnection) {
        this.context.unbindService(serviceConnection);
    }

    @Override
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return this.context.bindService(intent,serviceConnection,i);
    }



    @Override
    public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {

        if (beacons.size() > 0) {
            List<AppIBeacon> appIBeaconList = new ArrayList<AppIBeacon>();
            for (Beacon beacon: beacons){

                AppIBeacon iBeacon = new AppIBeacon();
                iBeacon.setUuid(beacon.getId1().toString());
                iBeacon.setMajor(beacon.getId2().toInt());
                iBeacon.setMinor(beacon.getId3().toInt());
                iBeacon.setDistance(beacon.getDistance());
                appIBeaconList.add(iBeacon);


                Log.d(TAG, iBeacon.toString());
            }

            Collections.sort(appIBeaconList, new Comparator<AppIBeacon>() {
                @Override
                public int compare(AppIBeacon b1, AppIBeacon b2) {

                    if (b1.getDistance() > b2.getDistance()){
                        return 1;
                    } else {
                        return -1;
                    }
                    
                }
            });

            onScannerBeaconServiceCallback.onBeaconsFound(appIBeaconList);
        }
    }


}
