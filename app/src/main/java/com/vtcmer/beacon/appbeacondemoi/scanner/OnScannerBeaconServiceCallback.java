package com.vtcmer.beacon.appbeacondemoi.scanner;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;

import java.util.List;

/**
 * Created by vtcmer on 8/03/18.
 */

public interface OnScannerBeaconServiceCallback {

    void onBeaconFound(final AppIBeacon iBeacon);
    void onBeaconsFound(final List<AppIBeacon> iBeacons);
    void cleanAllBeacons();

}
