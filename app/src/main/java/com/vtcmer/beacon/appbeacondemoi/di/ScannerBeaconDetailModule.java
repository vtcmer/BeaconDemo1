package com.vtcmer.beacon.appbeacondemoi.di;

import android.content.Context;

import com.vtcmer.beacon.appbeacondemoi.api.RestApiIbeaconClient;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconDetailPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconInteractor;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconRepository;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconService;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.ScannerBeaconServiceCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.SelectBeaconItemCallBack;
import com.vtcmer.beacon.appbeacondemoi.scanner.impl.ScannerBeaconDetailPresenterImpl;
import com.vtcmer.beacon.appbeacondemoi.scanner.impl.ScannerBeaconInteractorImpl;
import com.vtcmer.beacon.appbeacondemoi.scanner.impl.ScannerBeaconPresenterImpl;
import com.vtcmer.beacon.appbeacondemoi.scanner.impl.ScannerBeaconRepositoryRest;
import com.vtcmer.beacon.appbeacondemoi.scanner.impl.ScannerBeaconServiceImpl;
import com.vtcmer.beacon.appbeacondemoi.ui.ScannerBeaconView;
import com.vtcmer.beacon.appbeacondemoi.ui.adapters.BeaconDetectedListAdapter;
import com.vtcmer.beacon.appbeacondemoi.ui.adapters.ScannerBeaconDetailView;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vtcmer on 10/03/18.
 */
@Module
public class ScannerBeaconDetailModule {

    private Context context;
    private ScannerBeaconDetailView view;

    public ScannerBeaconDetailModule(Context context, ScannerBeaconDetailView view) {
        this.context = context;
        this.view = view;
    }


    @Provides
    @Singleton
    ScannerBeaconDetailView provideScannerBeaconDetailView(){
        return this.view;
    }

    @Provides
    @Singleton
    ScannerBeaconDetailPresenter provideScannerBeaconDetailPresenter(final ScannerBeaconInteractor scannerBeaconInteractor, final ScannerBeaconDetailView view){
        return new ScannerBeaconDetailPresenterImpl(scannerBeaconInteractor,view);
    }



    @Provides
    @Singleton
    Context provideContext(){
        return this.context;
    }


}
