package com.vtcmer.beacon.appbeacondemoi.scanner.api;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;

/**
 * Created by vtcmer on 11/03/18.
 */

public interface ScannerBeaconPresenter {

    /**
     * Recuperación de la información del detalle de beacon
     * @param appIBeacon
     */
    void getDetail(final AppIBeacon appIBeacon);

    /**
     * Eliminación del presentardor
     */
    void destroy();
}
