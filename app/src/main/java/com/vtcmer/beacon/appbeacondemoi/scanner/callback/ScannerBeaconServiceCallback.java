package com.vtcmer.beacon.appbeacondemoi.scanner.callback;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;

import org.altbeacon.beacon.Beacon;

import java.util.Collection;
import java.util.List;

/**
 * Created by vtcmer on 8/03/18.
 */

public interface ScannerBeaconServiceCallback {


    void onBeaconsFound(final Collection<Beacon> beacons);


}
