package com.vtcmer.beacon.appbeacondemoi.scanner.callback;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;

/**
 * Created by vtcmer on 11/03/18.
 */

public interface BeaconDetailCallback {

    /**
     * Devuelve la información del beacon
     * @param appIBeaconDetail
     */
    void onSuccess(final AppIBeaconDetail appIBeaconDetail);

    /**
     * Error en la recuperación de detalle
     * @param message
     */
    void onError(final String message);
}
