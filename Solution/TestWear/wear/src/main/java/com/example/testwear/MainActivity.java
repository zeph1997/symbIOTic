package com.example.testwear;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends WearableActivity {

    private TextView hearrateText;
    private SensorManager mSensorMg;
    private Sensor mHeartSensor;
    private Button testBtn;
    private ProgressBar heartRateBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hearrateText = (TextView) findViewById(R.id.hearrateText);
        testBtn = (Button) findViewById(R.id.testButton);
        heartRateBar = (ProgressBar) findViewById(R.id.heartRatePb);
        hearrateText.setText("220");

        mSensorMg = (SensorManager) getSystemService(SENSOR_SERVICE);
        mHeartSensor = mSensorMg.getDefaultSensor(Sensor.TYPE_HEART_RATE);

        heartRateBar.setProgress(220);
        // Enables Always-on
        setAmbientEnabled();

        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Hello",Toast.LENGTH_SHORT).show();
            }
        });

    }

    protected void onResume() {
        super.onResume();
        mSensorMg.registerListener(mSensorListener, mHeartSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorMg.unregisterListener(mSensorListener);
    }

    private SensorEventListener mSensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            final SensorEvent event = sensorEvent;
            hearrateText.setText(Float.toString(event.values[0]));
            heartRateBar.setProgress((int) event.values[0]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };


}
