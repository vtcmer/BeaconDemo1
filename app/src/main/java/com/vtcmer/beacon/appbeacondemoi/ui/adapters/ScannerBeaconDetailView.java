package com.vtcmer.beacon.appbeacondemoi.ui.adapters;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;
import com.vtcmer.beacon.appbeacondemoi.ui.BaseView;

/**
 * Created by vtcmer on 11/03/18.
 */

public interface ScannerBeaconDetailView extends BaseView{

    void showDetail(final AppIBeaconDetail detail);
    void showImageDetail(final byte[] image);


}
