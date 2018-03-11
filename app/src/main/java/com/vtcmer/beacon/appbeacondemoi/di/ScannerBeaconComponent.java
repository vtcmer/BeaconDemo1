package com.vtcmer.beacon.appbeacondemoi.di;

import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconService;
import com.vtcmer.beacon.appbeacondemoi.ui.adapters.BeaconDetectedListAdapter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vtcmer on 10/03/18.
 */
@Singleton
@Component(modules = {ScannerBeaconModule.class})
public interface ScannerBeaconComponent {

    ScannerBeaconPresenter getScannerBeaconPresenter();
    ScannerBeaconService getScannerBeaconService();
    BeaconDetectedListAdapter getBeaconDetectedListAdapter();

}
