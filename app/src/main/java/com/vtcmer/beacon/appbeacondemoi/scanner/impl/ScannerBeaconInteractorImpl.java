package com.vtcmer.beacon.appbeacondemoi.scanner.impl;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconInteractor;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconRepository;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconDetailCallback;

/**
 * Created by vtcmer on 11/03/18.
 */

public class ScannerBeaconInteractorImpl implements ScannerBeaconInteractor {

    private ScannerBeaconRepository scannerBeaconRepository;

    public ScannerBeaconInteractorImpl(ScannerBeaconRepository scannerBeaconRepository) {
        this.scannerBeaconRepository = scannerBeaconRepository;
    }

    @Override
    public void getDetail(AppIBeacon appIBeacon, BeaconDetailCallback beaconDetailCallback) {
        this.scannerBeaconRepository.getDetail(appIBeacon,beaconDetailCallback);
    }
}
