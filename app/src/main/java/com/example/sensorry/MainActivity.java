package com.example.sensorry;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor sensorProximity;
    private TextView txSensorProximity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList=sensorManager.getSensorList(Sensor.TYPE_ALL);

        StringBuilder sensoTtext =  new StringBuilder();
        for(Sensor sensor:sensorList){
            sensoTtext.append(sensor.getName())
                    .append(System.getProperty("line.separator"));
        }
        TextView sensorTextView=(TextView)findViewById(R.id.sensor_list);
        sensorTextView.setText(sensoTtext);

        txSensorProximity=(TextView)findViewById(R.id.sensor_prox);
        sensorProximity=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(sensorProximity==null){
            Toast.makeText(this,"no Proximity Sensor",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(sensorProximity!=null){
            sensorManager.registerListener(this,sensorProximity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int sensorType=sensorEvent.sensor.getType();
        float value= sensorEvent.values[0];
        if(sensorType==Sensor.TYPE_PROXIMITY){
            txSensorProximity.setText("Proximity Sensor :"+value);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
