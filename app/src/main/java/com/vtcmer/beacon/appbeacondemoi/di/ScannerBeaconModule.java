package com.vtcmer.beacon.appbeacondemoi.di;

import android.content.Context;

import com.vtcmer.beacon.appbeacondemoi.scanner.OnScannerBeaconServiceCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.OnSelectBeaconItemCallBack;
import com.vtcmer.beacon.appbeacondemoi.scanner.ScannerBeaconService;
import com.vtcmer.beacon.appbeacondemoi.scanner.ScannerBeaconServiceImpl;
import com.vtcmer.beacon.appbeacondemoi.ui.adapters.BeaconDetectedListAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vtcmer on 10/03/18.
 */
@Module
public class ScannerBeaconModule {

    private Context context;
    private OnScannerBeaconServiceCallback onScannerBeaconServiceCallback;
    private OnSelectBeaconItemCallBack onSelectBeaconItemCallBack;

    public ScannerBeaconModule(Context context, OnScannerBeaconServiceCallback onScannerBeaconServiceCallback, OnSelectBeaconItemCallBack onSelectBeaconItemCallBack) {
        this.context = context;
        this.onScannerBeaconServiceCallback = onScannerBeaconServiceCallback;
        this.onSelectBeaconItemCallBack = onSelectBeaconItemCallBack;
    }

    @Provides
    @Singleton
    ScannerBeaconService provideScannerBeaconService(final Context context, final OnScannerBeaconServiceCallback onScannerBeaconServiceCallback) {
        return new ScannerBeaconServiceImpl(context,onScannerBeaconServiceCallback);
    }

    @Provides
    @Singleton
    BeaconDetectedListAdapter provideBeaconDetectedListAdapter(final OnSelectBeaconItemCallBack onSelectBeaconItemCallBack, final Context context){
        return new BeaconDetectedListAdapter(onSelectBeaconItemCallBack, context);
    }

    @Provides
    @Singleton
    Context provideContext(){
        return this.context;
    }

    @Provides
    @Singleton
    OnScannerBeaconServiceCallback provideOnScannerBeaconServiceCallback(){
        return this.onScannerBeaconServiceCallback;
    }

    @Provides
    @Singleton
    OnSelectBeaconItemCallBack provideOnselOnSelectBeaconItemCallBack(){
        return this.onSelectBeaconItemCallBack;
    }
}
