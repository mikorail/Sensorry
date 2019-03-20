package com.example.sensorry;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> sensorList=sensorManager.getSensorList(Sensor.TYPE_ALL);

        StringBuilder sensortext =  new StringBuilder();
        for(Sensor sensor:sensorList){
            sensortext.append(sensor.getName())
                    .append(System.getProperty("line.separator"));
        }
        TextView sensorTextView=(TextView)findViewById(R.id.sensor_list);
        sensorTextView.setText(sensortext);
    }
}
