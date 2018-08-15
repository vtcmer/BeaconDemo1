package com.vtcmer.beacon.appbeacondemoi.di;

import android.content.Context;

import com.vtcmer.beacon.appbeacondemoi.api.RestApiIbeaconClient;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconInteractor;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconRepository;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.ScannerBeaconServiceCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.SelectBeaconItemCallBack;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconService;
import com.vtcmer.beacon.appbeacondemoi.scanner.impl.ScannerBeaconInteractorImpl;
import com.vtcmer.beacon.appbeacondemoi.scanner.impl.ScannerBeaconPresenterImpl;
import com.vtcmer.beacon.appbeacondemoi.scanner.impl.ScannerBeaconRepositoryMock;
import com.vtcmer.beacon.appbeacondemoi.scanner.impl.ScannerBeaconRepositoryRest;
import com.vtcmer.beacon.appbeacondemoi.scanner.impl.ScannerBeaconServiceImpl;
import com.vtcmer.beacon.appbeacondemoi.ui.ScannerBeaconView;
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
    private ScannerBeaconServiceCallback onScannerBeaconServiceCallback;
    private SelectBeaconItemCallBack onSelectBeaconItemCallBack;
    private ScannerBeaconView view;

    public ScannerBeaconModule(Context context, ScannerBeaconServiceCallback onScannerBeaconServiceCallback,
                               SelectBeaconItemCallBack onSelectBeaconItemCallBack, ScannerBeaconView view) {
        this.context = context;
        this.onScannerBeaconServiceCallback = onScannerBeaconServiceCallback;
        this.onSelectBeaconItemCallBack = onSelectBeaconItemCallBack;
        this.view = view;
    }


    @Provides
    @Singleton
    ScannerBeaconView provideScannerBeaconView(){
        return this.view;
    }

    @Provides
    @Singleton
    ScannerBeaconPresenter provideScannerBeaconPresenter(final ScannerBeaconInteractor scannerBeaconInteractor, final ScannerBeaconView view){
        return new ScannerBeaconPresenterImpl(scannerBeaconInteractor,view);
    }



    @Provides
    @Singleton
    ScannerBeaconService provideScannerBeaconService(final Context context, final ScannerBeaconServiceCallback onScannerBeaconServiceCallback) {
        return new ScannerBeaconServiceImpl(context,onScannerBeaconServiceCallback);
    }

    @Provides
    @Singleton
    BeaconDetectedListAdapter provideBeaconDetectedListAdapter(final SelectBeaconItemCallBack onSelectBeaconItemCallBack, final Context context){
        return new BeaconDetectedListAdapter(onSelectBeaconItemCallBack, context);
    }

    @Provides
    @Singleton
    Context provideContext(){
        return this.context;
    }

    @Provides
    @Singleton
    ScannerBeaconServiceCallback provideOnScannerBeaconServiceCallback(){
        return this.onScannerBeaconServiceCallback;
    }

    @Provides
    @Singleton
    SelectBeaconItemCallBack provideOnselOnSelectBeaconItemCallBack(){
        return this.onSelectBeaconItemCallBack;
    }
}
