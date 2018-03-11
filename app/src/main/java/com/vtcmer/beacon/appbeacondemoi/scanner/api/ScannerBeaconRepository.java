package com.vtcmer.beacon.appbeacondemoi.scanner.api;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconDetailCallback;

/**
 * Created by vtcmer on 11/03/18.
 */

public interface ScannerBeaconRepository {

    /**
     * Recuperación de la información de beacon
     * @param appIBeacon
     * @param beaconDetailCallback
     */
    void getDetail(final AppIBeacon appIBeacon, final BeaconDetailCallback beaconDetailCallback);
}
