package com.vtcmer.beacon.appbeacondemoi.scanner.api;

/**
 * Created by vtcmer on 8/03/18.
 */

public interface ScannerBeaconService {

    void startScan();
    void stopScan();
    void onDestroyScanner();
}
