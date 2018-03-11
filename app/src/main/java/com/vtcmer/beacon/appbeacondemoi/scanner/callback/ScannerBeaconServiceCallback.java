package com.vtcmer.beacon.appbeacondemoi.scanner.callback;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;

import java.util.List;

/**
 * Created by vtcmer on 8/03/18.
 */

public interface ScannerBeaconServiceCallback {

    void onBeaconFound(final AppIBeacon iBeacon);
    void onBeaconsFound(final List<AppIBeacon> iBeacons);
    void cleanAllBeacons();

}
