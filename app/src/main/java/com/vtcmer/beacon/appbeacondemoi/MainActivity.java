package com.vtcmer.beacon.appbeacondemoi;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.Identifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.ArrayList;
import java.util.Collection;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
implements BeaconConsumer, RangeNotifier{

    protected static final String TAG = "RangingActivity";
    private static final String ALL_BEACONS_REGION = "AllBeaconsRegion";
    @BindView(R.id.data)
    TextView data;

    private BeaconManager mBeaconManager;

    // Representa el criterio de campos con los que buscar beacons
    private Region mRegion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mBeaconManager = BeaconManager.getInstanceForApplication(this);
        // En este ejemplo vamos a usar el protocolo Eddystone, así que tenemos que definirlo aquí
        mBeaconManager.getBeaconParsers().add(new BeaconParser().
                setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));

        ArrayList<Identifier> identifiers = new ArrayList<>();

        mRegion = new Region(ALL_BEACONS_REGION, identifiers);



    }


    @OnClick(R.id.start)
    public void onStartViewClicked() {
        data.setText("Start");
        // Bindea esta actividad al BeaconService
        // Fijar un periodo de escaneo
        mBeaconManager.setForegroundScanPeriod(6000l);
        mBeaconManager.bind(this);
    }

    @OnClick(R.id.stop)
    public void onStopViewClicked() {
        data.setText("Stop");
        try {
            mBeaconManager.stopMonitoringBeaconsInRegion(mRegion);

        } catch (RemoteException e) {
            Log.d(TAG, "Se ha producido una excepción al parar de buscar beacons " + e.getMessage());
        }

        mBeaconManager.removeAllRangeNotifiers();

        // Desenlazar servicio de beacons
        mBeaconManager.unbind(this);

    }

    @Override
    public void onBeaconServiceConnect() {

        try {
            // Empezar a buscar los beacons que encajen con el el objeto Región pasado, incluyendo
            // actualizaciones en la distancia estimada
            mBeaconManager.startRangingBeaconsInRegion(mRegion);

        } catch (RemoteException e) {
            Log.d(TAG, "Se ha producido una excepción al empezar a buscar beacons " + e.getMessage());
        }

        mBeaconManager.addRangeNotifier(this);

    }

    @Override
    public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
        if (beacons.size() > 0) {
           // Log.i(TAG, "El primer beacon detectado se encuentra a una distancia de "+beacons.iterator().next().getDistance()+" metros.");
            for (Beacon beacon: beacons){
                StringBuffer str = new StringBuffer("El Beacon: ");
                str.append(beacon.getServiceUuid()).append(" ");
                str.append(" uuid "+beacon.getId1()).append(" ");
                str.append(" Major "+beacon.getId2()).append(" ");
                str.append(" Minor "+beacon.getId3()).append(" ");
                str.append(" Distancia "+ String.valueOf(beacon.getDistance())).append(" ");
              //  data.setText(str.toString());
                Log.d(TAG, str.toString());
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBeaconManager.removeAllRangeNotifiers();
        mBeaconManager.unbind(this);
    }

}
