package com.vtcmer.beacon.appbeacondemoi.scanner.impl;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconInteractor;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconDetailCallback;
import com.vtcmer.beacon.appbeacondemoi.ui.ScannerBeaconView;

/**
 * Created by vtcmer on 11/03/18.
 */

public class ScannerBeaconPresenterImpl implements ScannerBeaconPresenter {

    private ScannerBeaconInteractor scannerBeaconInteractor;
    private ScannerBeaconView scannerBeaconView;

    public ScannerBeaconPresenterImpl(ScannerBeaconInteractor scannerBeaconInteractor, ScannerBeaconView scannerBeaconView) {
        this.scannerBeaconInteractor = scannerBeaconInteractor;
        this.scannerBeaconView = scannerBeaconView;
    }

    @Override
    public void getIntro(AppIBeacon appIBeacon) {

        if (this.scannerBeaconView != null){
            this.scannerBeaconView.showProgressBar();
        }

        this.scannerBeaconInteractor.getIntro(appIBeacon, new BeaconDetailCallback() {

            @Override
            public void onSuccess(AppIBeaconDetail appIBeaconDetail) {
                scannerBeaconView.hideProgressBar();
                scannerBeaconView.showIntro(appIBeaconDetail);

            }

            @Override
            public void onError(String message) {
                scannerBeaconView.hideProgressBar();
                scannerBeaconView.showError(message);
            }

        });

    }



    @Override
    public void destroy() {
        this.scannerBeaconView = null;
    }
}
