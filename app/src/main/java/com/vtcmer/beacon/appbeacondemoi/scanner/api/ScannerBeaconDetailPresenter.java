package com.vtcmer.beacon.appbeacondemoi.scanner.api;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;

/**
 * Created by vtcmer on 11/03/18.
 */

public interface ScannerBeaconDetailPresenter {


    /**
     * Recupera información del beacon
     * @param id
     */
    void getDetail(final String id);

    /**
     * Recupera la imagen del detalle
     * @param id
     */
    void geImageDetail(final String id);

    /**
     * Eliminación del presentardor
     */
    void destroy();
}
