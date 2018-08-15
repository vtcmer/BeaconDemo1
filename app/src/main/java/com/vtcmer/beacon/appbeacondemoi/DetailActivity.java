package com.vtcmer.beacon.appbeacondemoi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.vtcmer.beacon.appbeacondemoi.di.ScannerBeaconDetailComponent;
import com.vtcmer.beacon.appbeacondemoi.model.AppIBeaconDetail;
import com.vtcmer.beacon.appbeacondemoi.scanner.api.ScannerBeaconDetailPresenter;
import com.vtcmer.beacon.appbeacondemoi.scanner.common.ImageLoader;
import com.vtcmer.beacon.appbeacondemoi.scanner.common.impl.ImageLoaderGlide;
import com.vtcmer.beacon.appbeacondemoi.ui.adapters.ScannerBeaconDetailView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements ScannerBeaconDetailView {

    protected static final String TAG = "DetailActivity";
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.ubicacion)
    TextView ubicacion;
    @BindView(R.id.detail)
    TextView detail;


    private ScannerBeaconDetailPresenter scannerBeaconDetailPresenter;
    private ImageLoader imageLoader;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        this.setupInjection();

        Bundle bundle = getIntent().getExtras();
        String id = bundle.getString("ID");

        this.scannerBeaconDetailPresenter.getDetail(id);
    }

    private void setupInjection() {

        ApplicationIBeacon applicationIBeacon = (ApplicationIBeacon) this.getApplication();
        ScannerBeaconDetailComponent component = applicationIBeacon.getScannerBeaconDetailComponent(this, this);

        this.scannerBeaconDetailPresenter = component.getScannerBeaconDetailPresenter();
        this.imageLoader = new ImageLoaderGlide(this);
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void hideProgressBar() {

    }

    @Override
    public void showDetail(AppIBeaconDetail detail) {
        this.populateView(detail);
        this.scannerBeaconDetailPresenter.geImageDetail(detail.getImageId());
        //String url = BuildConfig.BEACON_API_HOST + "api/beacon/image/" + detail.getImageId();
        //this.imageLoader.load(this.image, url);
    }

    @Override
    public void showImageDetail(byte[] image) {
        Bitmap bmp = BitmapFactory.decodeByteArray(image, 0, image.length);
        this.image.setImageBitmap(bmp);

    }

    private void populateView(final AppIBeaconDetail detail) {
        this.ubicacion.setText(detail.getName());
        this.detail.setText(detail.getDetail());
    }


}
