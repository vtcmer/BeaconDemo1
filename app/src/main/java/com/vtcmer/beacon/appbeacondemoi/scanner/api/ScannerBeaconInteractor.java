package com.vtcmer.beacon.appbeacondemoi.scanner.api;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconDetailCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconImageCallback;

/**
 * Created by vtcmer on 11/03/18.
 */

public interface ScannerBeaconInteractor {

    void getDetail(final String id, final BeaconDetailCallback beaconDetailCallback);

    /**
     * Recuperación de la información de beacon
     * @param appIBeacon
     * @param beaconDetailCallback
     */
    void getIntro(final AppIBeacon appIBeacon, final BeaconDetailCallback beaconDetailCallback);


    /**
     * Recupera la imagen del detalle
     * @param id
     * @param beaconImageCallback
     */
    void getImageDetail(final String id, final BeaconImageCallback beaconImageCallback);
}
