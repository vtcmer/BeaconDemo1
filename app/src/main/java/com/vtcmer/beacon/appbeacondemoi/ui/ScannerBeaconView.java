package com.vtcmer.beacon.appbeacondemoi.ui;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;

/**
 * Created by vtcmer on 11/03/18.
 */

public interface ScannerBeaconView {

    void showDetail(final AppIBeaconDetail detail);
    void showError(final String message);
    void showProgressBar();
    void hideProgressBar();
}
