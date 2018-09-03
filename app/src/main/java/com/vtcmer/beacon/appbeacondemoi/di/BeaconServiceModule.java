package com.vtcmer.beacon.appbeacondemoi.di;

import android.content.Context;

import com.vtcmer.beacon.appbeacondemoi.api.RestApiIbeaconClient;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconInteractor;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconRepository;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconService;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.ScannerBeaconServiceCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.SelectBeaconItemCallBack;
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
public class BeaconServiceModule {



    public BeaconServiceModule() {}


    @Provides
    @Singleton
    ScannerBeaconInteractor provideScannerBeaconInteractor(final ScannerBeaconRepository scannerBeaconRepository){
        return new ScannerBeaconInteractorImpl(scannerBeaconRepository);
    }

    @Provides
    @Singleton
    ScannerBeaconRepository provideScannerBeaconRepository(RestApiIbeaconClient restApiIbeaconClient){
        //return new ScannerBeaconRepositoryRest(restApiIbeaconClient);
        return new ScannerBeaconRepositoryMock();
    }


}
