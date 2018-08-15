package com.vtcmer.beacon.appbeacondemoi.scanner.api;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;

/**
 * Created by vtcmer on 11/03/18.
 */

public interface ScannerBeaconPresenter {


    /**
     * Recuperación del beacon
     * @param appIBeacon
     */
    void getIntro(final AppIBeacon appIBeacon);


    /**
     * Eliminación del presentardor
     */
    void destroy();
}
