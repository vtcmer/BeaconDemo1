package com.vtcmer.beacon.appbeacondemoi.scanner.common.impl;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.vtcmer.beacon.appbeacondemoi.scanner.common.ImageLoader;

/**
 * Created by vtcmer on 30/03/18.
 */

public class ImageLoaderGlide implements ImageLoader {

    private RequestManager glideRequestManager;

    public ImageLoaderGlide(Context context){
        this.glideRequestManager = Glide.with(context);
    }


    @Override
    public void load(ImageView imageView, String URL) {
        this.glideRequestManager.load(URL).into(imageView);
    }
}
