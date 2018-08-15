package com.vtcmer.beacon.appbeacondemoi.api.di;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.vtcmer.beacon.appbeacondemoi.api.RestApiIbeaconClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by vtcmer on 25/03/18.
 */
@Module
public class ApiRestIbeaconModule {


    private String urlBase;
    private Context context;

    public ApiRestIbeaconModule(String urlBase,Context context) {
        this.urlBase = urlBase;
        this.context = context;
    }



    @Provides
    @Singleton
    Cache provideHttpCache() {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(this.context.getCacheDir(), cacheSize);
        return cache;
    }


    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        return gsonBuilder.create();
    }


    @Provides
    @Singleton
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(this.urlBase)
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    RestApiIbeaconClient provideRestApiWeatherClient(final Retrofit retrofit){
        return new RestApiIbeaconClient(retrofit);
    }

}
