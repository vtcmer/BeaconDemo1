package com.vtcmer.beacon.appbeacondemoi.scanner.impl;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconDetailPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconInteractor;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconDetailCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconImageCallback;
import com.vtcmer.beacon.appbeacondemoi.ui.ScannerBeaconView;
import com.vtcmer.beacon.appbeacondemoi.ui.adapters.ScannerBeaconDetailView;

/**
 * Created by vtcmer on 11/03/18.
 */

public class ScannerBeaconDetailPresenterImpl implements ScannerBeaconDetailPresenter {

    private ScannerBeaconInteractor scannerBeaconInteractor;
    private ScannerBeaconDetailView scannerBeaconDetailView;

    public ScannerBeaconDetailPresenterImpl(ScannerBeaconInteractor scannerBeaconInteractor, ScannerBeaconDetailView scannerBeaconDetailView) {
        this.scannerBeaconInteractor = scannerBeaconInteractor;
        this.scannerBeaconDetailView = scannerBeaconDetailView;
    }



    @Override
    public void getDetail(String id) {

        if (this.scannerBeaconDetailView != null){
            this.scannerBeaconDetailView.showProgressBar();
        }

        this.scannerBeaconInteractor.getDetail(id, new BeaconDetailCallback() {

            @Override
            public void onSuccess(AppIBeaconDetail appIBeaconDetail) {
                scannerBeaconDetailView.hideProgressBar();
                scannerBeaconDetailView.showDetail(appIBeaconDetail);

            }

            @Override
            public void onError(String message) {
                scannerBeaconDetailView.hideProgressBar();
                scannerBeaconDetailView.showError(message);
            }

        });
    }

    @Override
    public void geImageDetail(String id) {

        this.scannerBeaconInteractor.getImageDetail(id, new BeaconImageCallback() {
            @Override
            public void onImageDetailSuccess(byte[] data) {
                scannerBeaconDetailView.showImageDetail(data);
            }

            @Override
            public void onImageDetailSuccess(String message) {

            }
        });

    }

    @Override
    public void destroy() {
        this.scannerBeaconDetailView = null;
    }
}
