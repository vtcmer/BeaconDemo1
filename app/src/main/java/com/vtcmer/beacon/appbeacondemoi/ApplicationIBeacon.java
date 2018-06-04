package com.vtcmer.beacon.appbeacondemoi;

import android.app.Application;
import android.content.Context;

import com.vtcmer.beacon.appbeacondemoi.di.DaggerScannerBeaconComponent;
import com.vtcmer.beacon.appbeacondemoi.di.ScannerBeaconComponent;
import com.vtcmer.beacon.appbeacondemoi.di.ScannerBeaconModule;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.ScannerBeaconServiceCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.SelectBeaconItemCallBack;
import com.vtcmer.beacon.appbeacondemoi.ui.ScannerBeaconView;

/**
 * Created by vtcmer on 10/03/18.
 */

public class ApplicationIBeacon extends Aplication {



    public ScannerBeaconComponent getScannerBeaconComponent(Context context,
                                                            ScannerBeaconServiceCallback onScannerBeaconServiceCallback,
                                                            SelectBeaconItemCallBack onSelectBeaconItemCallBack,
                                                            ScannerBeaconView view){
        return DaggerScannerBeaconComponent
                .builder()
                .scannerBeaconModule(new ScannerBeaconModule(context,onScannerBeaconServiceCallback, onSelectBeaconItemCallBack, view))
                .build();
    }
}
