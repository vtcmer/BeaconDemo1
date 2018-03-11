package com.vtcmer.beacon.appbeacondemoi.scanner.impl;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconRepository;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconDetailCallback;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vtcmer on 11/03/18.
 */

public class ScannerBeaconRepositoryMock implements ScannerBeaconRepository {

    private Map<String,AppIBeaconDetail> iBeaconData = new HashMap<String,AppIBeaconDetail>();

    public ScannerBeaconRepositoryMock() {

        this.loadMockData();
    }

    @Override
    public void getDetail(AppIBeacon appIBeacon, BeaconDetailCallback beaconDetailCallback) {


        AppIBeaconDetail detail = this.getDetail(appIBeacon);
        if (detail != null) {
            beaconDetailCallback.onSuccess(detail);
        }else{
            beaconDetailCallback.onError(appIBeacon.toString()+" not found");
        }

    }


    /**
     * Recuperación de la información del detalle
     * @param appIBeacon
     * @return
     */
    private AppIBeaconDetail getDetail(AppIBeacon appIBeacon){

        AppIBeaconDetail detail = this.iBeaconData.get(appIBeacon.toString());
        if (detail != null) {
            detail.setUuid(appIBeacon.getUuid());
            detail.setMajor(appIBeacon.getMajor());
            detail.setMinor(appIBeacon.getMinor());
            detail.setDistance(appIBeacon.getDistance());
        }
        return detail;
    }

    private void loadMockData(){

        AppIBeaconDetail detail = new AppIBeaconDetail();
        detail.setDescription("Baliza 1");
        this.iBeaconData.put("ApplicationIBeacon{uuid='a9700f07-c339-42d7-bf04-ecab1522d12c', major=20, minor=1}",detail);

        detail = new AppIBeaconDetail();
        detail.setDescription("Baliza HI");
        this.iBeaconData.put("ApplicationIBeacon{uuid='fda50693-a4e2-4fb1-afcf-c6eb07647825', major=10001, minor=12544}",detail);
    }
}
