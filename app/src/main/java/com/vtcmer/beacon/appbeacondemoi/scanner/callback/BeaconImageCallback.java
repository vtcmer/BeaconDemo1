package com.vtcmer.beacon.appbeacondemoi.scanner.callback;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;

/**
 * Created by vtcmer on 11/03/18.
 */

public interface BeaconImageCallback {

    /**
     * Devuelve el array de bytes de la imagen
     * @param data
     */
    void onImageDetailSuccess(final byte[] data);

    /**
     * Error en la recuperación de detalle
     * @param message
     */
    void onImageDetailSuccess(final String message);
}
