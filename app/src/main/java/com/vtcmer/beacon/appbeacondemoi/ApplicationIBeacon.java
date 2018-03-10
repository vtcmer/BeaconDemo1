package com.vtcmer.beacon.appbeacondemoi;

import android.app.Application;
import android.content.Context;

import com.vtcmer.beacon.appbeacondemoi.di.DaggerScannerBeaconComponent;
import com.vtcmer.beacon.appbeacondemoi.di.ScannerBeaconComponent;
import com.vtcmer.beacon.appbeacondemoi.di.ScannerBeaconModule;
import com.vtcmer.beacon.appbeacondemoi.scanner.OnScannerBeaconServiceCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.OnSelectBeaconItemCallBack;

/**
 * Created by vtcmer on 10/03/18.
 */

public class ApplicationIBeacon extends Application {



    public ScannerBeaconComponent getScannerBeaconComponent(Context context, OnScannerBeaconServiceCallback onScannerBeaconServiceCallback, OnSelectBeaconItemCallBack onSelectBeaconItemCallBack){
        return DaggerScannerBeaconComponent
                .builder()
                .scannerBeaconModule(new ScannerBeaconModule(context,onScannerBeaconServiceCallback, onSelectBeaconItemCallBack))
                .build();
    }
}
