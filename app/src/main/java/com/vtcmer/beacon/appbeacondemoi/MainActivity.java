package com.vtcmer.beacon.appbeacondemoi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.vtcmer.beacon.appbeacondemoi.model.AppIBeacon;
import com.vtcmer.beacon.appbeacondemoi.scanner.OnScannerBeaconServiceCallback;
import com.vtcmer.beacon.appbeacondemoi.scanner.ScannerBeaconService;
import com.vtcmer.beacon.appbeacondemoi.scanner.ScannerBeaconServiceImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements OnScannerBeaconServiceCallback {

    protected static final String TAG = "RangingActivity";
    @BindView(R.id.uuid)
    EditText uuid;
    @BindView(R.id.major)
    EditText major;
    @BindView(R.id.minor)
    EditText minor;
    @BindView(R.id.distance)
    EditText distance;
    @BindView(R.id.start)
    Button start;
    @BindView(R.id.stop)
    Button stop;


    private ScannerBeaconService scannerBeaconService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        this.scannerBeaconService = new ScannerBeaconServiceImpl(this.getApplicationContext(), this);

        stop.setEnabled(false);
        stop.setAlpha(.5f);

    }


    @OnClick(R.id.start)
    public void onStartViewClicked() {

        start.setEnabled(false);
        start.setAlpha(.5f);
        stop.setEnabled(true);
        stop.setAlpha(1);

        this.scannerBeaconService.startScan();
    }

    @OnClick(R.id.stop)
    public void onStopViewClicked() {
        this.scannerBeaconService.stopScan();
        stop.setEnabled(false);
        stop.setAlpha(.5f);
        start.setEnabled(true);
        start.setAlpha(1);
        this.clean();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.scannerBeaconService.onDestroyScanner();
    }

    @Override
    public void onBeaconFound(final AppIBeacon iBeacon) {
        runOnUiThread(new Runnable() {
            public void run() {
                try {
                    // showToastMessage(str.toString());
                    //data.setText(info);
                    renderBeacon(iBeacon);
                } catch (Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            }
        });
    }

    private void renderBeacon(final AppIBeacon iBeacon) {

        uuid.setText(iBeacon.getUuid());
        major.setText(String.valueOf(iBeacon.getMajor()));
        minor.setText(String.valueOf(iBeacon.getMinor()));
        distance.setText(String.valueOf(iBeacon.getDistance()));

    }

    private void clean() {
        uuid.setText("");
        major.setText("");
        minor.setText("");
        distance.setText("");
    }
}
