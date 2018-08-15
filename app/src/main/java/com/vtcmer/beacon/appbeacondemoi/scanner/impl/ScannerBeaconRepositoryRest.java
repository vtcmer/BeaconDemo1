package com.vtcmer.beacon.appbeacondemoi.scanner.impl;

import android.util.Base64;

import com.vtcmer.beacon.appbeacondemoi.api.RestApiBeaconData;
import com.vtcmer.beacon.appbeacondemoi.api.RestApiIbeaconClient;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconCriteria;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconRepository;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconDetailCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.callback.BeaconImageCallback;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by vtcmer on 25/03/18.
 */

public class ScannerBeaconRepositoryRest implements ScannerBeaconRepository {

    private RestApiIbeaconClient restApiIbeaconClient;

    public ScannerBeaconRepositoryRest(RestApiIbeaconClient restApiIbeaconClient) {
        this.restApiIbeaconClient = restApiIbeaconClient;
    }

    @Override
    @Deprecated
    public void getDetail(AppIBeacon appIBeacon, BeaconDetailCallback beaconDetailCallback) {



    }

    @Override
    public void getIbeaconIntro(final AppIBeacon appIBeacon, final BeaconDetailCallback beaconDetailCallback) {

        RestApiBeaconData apiBeaconData = this.restApiIbeaconClient.getRestApiBeaconData();

        apiBeaconData.getIbeaconIntro(appIBeacon.getUuid(),appIBeacon.getMajor(),appIBeacon.getMinor())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends AppIBeaconDetail>>() {
                    @Override
                    public Observable<? extends AppIBeaconDetail> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<AppIBeaconDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println();

                    }

                    @Override
                    public void onNext(AppIBeaconDetail appIBeaconDetail) {
                        appIBeaconDetail.setDistance(appIBeacon.getDistance());
                        beaconDetailCallback.onSuccess(appIBeaconDetail);

                    }
                });
    }







    @Override
    public void getIbeaconDetail(String id, final BeaconDetailCallback beaconDetailCallback) {

        RestApiBeaconData apiBeaconData = this.restApiIbeaconClient.getRestApiBeaconData();

        apiBeaconData.getIbeaconDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends AppIBeaconDetail>>() {
                    @Override
                    public Observable<? extends AppIBeaconDetail> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<AppIBeaconDetail>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {


                    }

                    @Override
                    public void onNext(AppIBeaconDetail appIBeaconDetail) {
                        beaconDetailCallback.onSuccess(appIBeaconDetail);

                    }
                });

    }

    @Override
    public void getIbeaconDetailImage(String id, final BeaconImageCallback beaconImageCallback) {

        RestApiBeaconData apiBeaconData = this.restApiIbeaconClient.getRestApiBeaconData();

        apiBeaconData.getIbeaconImageDetail(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onErrorResumeNext(new Func1<Throwable, Observable<? extends String>>() {
                    @Override
                    public Observable<? extends String> call(Throwable throwable) {
                        return Observable.error(throwable);
                    }
                })
                .subscribe(new Subscriber<String>(){

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println();
                    }

                    @Override
                    public void onNext(String s) {
                        byte[] data = Base64.decode(s, Base64.DEFAULT);
                        beaconImageCallback.onImageDetailSuccess(data);
                    }
                });

    }


}
