package com.vtcmer.beacon.appbeacondemoi.scanner.impl;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconInteractor;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconRepository;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconDetailCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconImageCallback;

/**
 * Created by vtcmer on 11/03/18.
 */

public class ScannerBeaconInteractorImpl implements ScannerBeaconInteractor {

    private ScannerBeaconRepository scannerBeaconRepository;

    public ScannerBeaconInteractorImpl(ScannerBeaconRepository scannerBeaconRepository) {
        this.scannerBeaconRepository = scannerBeaconRepository;
    }

    @Override
    public void getDetail(String id, BeaconDetailCallback beaconDetailCallback) {
        this.scannerBeaconRepository.getIbeaconDetail(id,beaconDetailCallback);
    }

    @Override
    public void getIntro(AppIBeacon appIBeacon, BeaconDetailCallback beaconDetailCallback) {
        this.scannerBeaconRepository.getIbeaconIntro(appIBeacon,beaconDetailCallback);
    }

    @Override
    public void getImageDetail(String id, BeaconImageCallback beaconImageCallback) {
        this.scannerBeaconRepository.getIbeaconDetailImage(id,beaconImageCallback);
    }


}
