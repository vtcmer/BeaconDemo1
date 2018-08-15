package com.vtcmer.beacon.appbeacondemoi.api;

import retrofit2.Retrofit;

/**
 * Created by vtcmer on 25/03/18.
 */

public class RestApiIbeaconClient {

    Retrofit retrofit;

    public RestApiIbeaconClient(Retrofit retrofit) {
        this.retrofit = retrofit;
    }

    public RestApiBeaconData getRestApiBeaconData(){
        RestApiBeaconData apiIbeaconData = this.retrofit.create(RestApiBeaconData.class);
        return apiIbeaconData;
    }
}
