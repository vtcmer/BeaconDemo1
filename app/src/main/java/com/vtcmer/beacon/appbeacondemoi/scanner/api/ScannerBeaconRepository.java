package com.vtcmer.beacon.appbeacondemoi.scanner.api;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconCriteria;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconDetailCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconImageCallback;

import java.util.List;

/**
 * Created by vtcmer on 11/03/18.
 */

public interface ScannerBeaconRepository {

    /**
     * Recuperación de la información de beacon
     * @param appIBeacon
     * @param beaconDetailCallback
     */
    @Deprecated
    void getDetail(final AppIBeacon appIBeacon, final BeaconDetailCallback beaconDetailCallback);


    void getIbeaconIntro(final AppIBeacon appIBeacon, final BeaconDetailCallback beaconDetailCallback);
    void getIbeaconDetail(final String id, final BeaconDetailCallback beaconDetailCallback);

    void getIbeaconDetailImage(final String id, final BeaconImageCallback beaconImageCallback);

}
