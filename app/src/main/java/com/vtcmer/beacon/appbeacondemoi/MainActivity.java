package com.vtcmer.beacon.appbeacondemoi;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.vtcmer.beacon.appbeacondemoi.di.ScannerBeaconComponent;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.ScannerBeaconServiceCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.SelectBeaconItemCallBack;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconService;
import com.vtcmer.beacon.appbeacondemoi.ui.ScannerBeaconView;
import com.vtcmer.beacon.appbeacondemoi.ui.adapters.BeaconDetectedListAdapter;

import org.altbeacon.beacon.Beacon;

import java.util.Collection;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements ScannerBeaconServiceCallback, SelectBeaconItemCallBack, ScannerBeaconView {

    protected static final String TAG = "MainActivity";
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.btnAction)
    FloatingActionButton btnAction;
    @BindView(R.id.container)
    CoordinatorLayout container;


    private ScannerBeaconService scannerBeaconService;
    private BeaconDetectedListAdapter adapter;
    private ScannerBeaconPresenter scannerBeaconPresenter;

    boolean isScanning = false;


    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void setupInjection(){
        ApplicationIBeacon applicationIBeacon = (ApplicationIBeacon) this.getApplication();

        ScannerBeaconComponent scannerBeaconComponent = applicationIBeacon.getScannerBeaconComponent(this,this,this, this);

        this.scannerBeaconService = scannerBeaconComponent.getScannerBeaconService();
        this.adapter = scannerBeaconComponent.getBeaconDetectedListAdapter();
        this.scannerBeaconPresenter = scannerBeaconComponent.getScannerBeaconPresenter();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibeacons_list);
        ButterKnife.bind(this);

        this.isScanning = false;
        this.setupInjection();
        setupRecyclerView();


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.scannerBeaconService.onDestroyScanner();
    }

    @Override
    public void onBeaconsFound(final Collection<Beacon> beacons) {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    adapter.clean();
                    for (Beacon beacon: beacons){

                        AppIBeacon iBeacon = new AppIBeacon();
                        iBeacon.setUuid(beacon.getId1().toString());
                        iBeacon.setMajor(beacon.getId2().toInt());
                        iBeacon.setMinor(beacon.getId3().toInt());
                        iBeacon.setDistance(beacon.getDistance());
                        scannerBeaconPresenter.getIntro(iBeacon);
                    }


                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
    }



    @Override
    public void showIntro(AppIBeaconDetail detail) {
        adapter.addIBeaconItem(detail);
    }




    @OnClick(R.id.btnAction)
    public void onViewClicked() {
        if (isScanning){
            this.scannerBeaconService.stopScan();
            isScanning = false;
            this.btnAction.setImageDrawable(ContextCompat.getDrawable(this, android.R.drawable.ic_menu_mylocation));
            this.adapter.clean();
        }else{
            this.scannerBeaconService.startScan();
            isScanning = true;
            this.btnAction.setImageDrawable(ContextCompat.getDrawable(this, android.R.drawable.ic_delete));
        }

    }

    @Override
    public void onSelectItem(AppIBeacon appIBeacon) {
       // this.scannerBeaconPresenter.getDetail(appIBeacon.getId());

        Intent intent = new Intent(this, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("ID", appIBeacon.getId());
        intent.putExtras(bundle);
        startActivity(intent);

    }





    @Override
    public void showError(String message) {
        Log.i(TAG,"Error: "+message);
    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }
}
