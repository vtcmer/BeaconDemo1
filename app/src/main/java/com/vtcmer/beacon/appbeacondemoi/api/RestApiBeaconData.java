package com.vtcmer.beacon.appbeacondemoi.api;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconCriteria;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by vtcmer on 25/03/18.
 */

public interface RestApiBeaconData {

    @POST("/api/beacons")
    Observable<List<AppIBeaconDetail>> findIbeaconsByCriteria(@Body List<AppIBeaconCriteria> criteria);

    @GET("api/beacon/{id}")
    Observable<AppIBeaconDetail> getIbeaconDetail(@Path("id") String id);

    @GET("api/beacon/{uuid}/{major}/{minor}")
    Observable<AppIBeaconDetail> getIbeaconIntro(@Path("uuid") String uuid, @Path("major") Integer major, @Path("minor") Integer minor);



    @GET("api/beacon/image/st/{id}")
    Observable<String> getIbeaconImageDetail(@Path("id") String id);

}
