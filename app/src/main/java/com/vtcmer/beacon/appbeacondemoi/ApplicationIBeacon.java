package com.vtcmer.beacon.appbeacondemoi;

import android.app.Application;
import android.content.Context;

import com.vtcmer.beacon.appbeacondemoi.api.di.ApiRestIbeaconModule;
import com.vtcmer.beacon.appbeacondemoi.di.DaggerScannerBeaconComponent;
import com.vtcmer.beacon.appbeacondemoi.di.DaggerScannerBeaconDetailComponent;
import com.vtcmer.beacon.appbeacondemoi.di.ScannerBeaconComponent;
import com.vtcmer.beacon.appbeacondemoi.di.ScannerBeaconDetailComponent;
import com.vtcmer.beacon.appbeacondemoi.di.ScannerBeaconDetailModule;
import com.vtcmer.beacon.appbeacondemoi.di.ScannerBeaconModule;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.ScannerBeaconServiceCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.SelectBeaconItemCallBack;
import com.vtcmer.beacon.appbeacondemoi.ui.ScannerBeaconView;
import com.vtcmer.beacon.appbeacondemoi.ui.adapters.ScannerBeaconDetailView;

/**
 * Created by vtcmer on 10/03/18.
 */

public class ApplicationIBeacon extends Application {



    public ScannerBeaconComponent getScannerBeaconComponent(Context context,
                                                            ScannerBeaconServiceCallback onScannerBeaconServiceCallback,
                                                            SelectBeaconItemCallBack onSelectBeaconItemCallBack,
                                                            ScannerBeaconView view){
        return DaggerScannerBeaconComponent
                .builder()
                .apiRestIbeaconModule(new ApiRestIbeaconModule(BuildConfig.BEACON_API_HOST,context))
                .scannerBeaconModule(new ScannerBeaconModule(context,onScannerBeaconServiceCallback, onSelectBeaconItemCallBack, view))
                .build();
    }


    public ScannerBeaconDetailComponent getScannerBeaconDetailComponent(final Context context, final ScannerBeaconDetailView view){
        return DaggerScannerBeaconDetailComponent
                .builder()
                .apiRestIbeaconModule(new ApiRestIbeaconModule(BuildConfig.BEACON_API_HOST,context))
                .scannerBeaconDetailModule(new ScannerBeaconDetailModule(context,view))
                .build();
    }


}
