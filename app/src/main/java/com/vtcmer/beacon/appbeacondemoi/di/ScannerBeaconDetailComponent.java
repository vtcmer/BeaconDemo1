package com.vtcmer.beacon.appbeacondemoi.di;

import com.vtcmer.beacon.appbeacondemoi.api.di.ApiRestIbeaconModule;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconDetailPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconService;
import com.vtcmer.beacon.appbeacondemoi.ui.adapters.BeaconDetectedListAdapter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vtcmer on 10/03/18.
 */
@Singleton
@Component(modules = {ScannerBeaconDetailModule.class,BeaconServiceModule.class, ApiRestIbeaconModule.class})
public interface ScannerBeaconDetailComponent {

    ScannerBeaconDetailPresenter getScannerBeaconDetailPresenter();


}
