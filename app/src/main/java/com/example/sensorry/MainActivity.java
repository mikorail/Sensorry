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
    private Sensor sensorAccelero;
    private Sensor sensorTemp;
    private Sensor sensorHumi;
    private Sensor sensorGyro;
    private Sensor sensorGrav;
    private Sensor sensorPres;
    private Sensor sensorOrient;
    private TextView txSensorProximity;
    private TextView txSensorAccelero;
    private TextView txSensorTemp;
    private TextView txSensorHum;
    private TextView txSensorGyro;
    private TextView txSensorGravity;
    private TextView txSensorPressure;
    private TextView txSensorOrient;
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
        txSensorAccelero=(TextView)findViewById(R.id.sensor_acc);
        sensorAccelero=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if(sensorAccelero==null){
            Toast.makeText(this,"no Accelero Sensor",Toast.LENGTH_SHORT).show();
        }
        txSensorTemp=(TextView)findViewById(R.id.sensor_temp);
        sensorTemp=sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        if(sensorTemp==null){
            Toast.makeText(this,"no Temperature Sensor",Toast.LENGTH_SHORT).show();
        }
        txSensorHum=(TextView)findViewById(R.id.sensor_hum);
        sensorHumi=sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);
        if(sensorHumi==null){
            Toast.makeText(this,"no Temperature Sensor",Toast.LENGTH_SHORT).show();
        }
        txSensorGyro=(TextView)findViewById(R.id.sensor_gyro);
        sensorGyro=sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if(sensorGyro==null){
            Toast.makeText(this,"no Gyroscope Sensor",Toast.LENGTH_SHORT).show();
        }
        txSensorGravity=(TextView)findViewById(R.id.sensor_gravity);
        sensorGrav=sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        if(sensorGrav==null){
            Toast.makeText(this,"no Gravity Sensor",Toast.LENGTH_SHORT).show();
        }
        txSensorPressure=(TextView)findViewById(R.id.sensor_press);
        sensorPres=sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        if(sensorPres==null){
            Toast.makeText(this,"no Pressure Sensor",Toast.LENGTH_SHORT).show();
        }
        txSensorOrient=(TextView)findViewById(R.id.sensor_orient);
        sensorOrient=sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        if(sensorOrient==null){
            Toast.makeText(this,"no Orientation Sensor",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(sensorProximity!=null){
            sensorManager.registerListener(this,sensorProximity,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }if(sensorAccelero!=null){
            sensorManager.registerListener(this,sensorAccelero,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }if(sensorTemp!=null){
            sensorManager.registerListener(this,sensorTemp,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }if(sensorHumi!=null){
            sensorManager.registerListener(this,sensorHumi,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }if(sensorGrav!=null){
            sensorManager.registerListener(this,sensorGrav,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }if(sensorGyro!=null){
            sensorManager.registerListener(this,sensorGyro,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }if(sensorPres!=null){
            sensorManager.registerListener(this,sensorPres,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }if(sensorOrient!=null){
            sensorManager.registerListener(this,sensorOrient,
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
        }if(sensorType==Sensor.TYPE_ACCELEROMETER){
            txSensorAccelero.setText("Accelerometer Sensor :"+value);
        }if(sensorType==Sensor.TYPE_AMBIENT_TEMPERATURE){
            txSensorTemp.setText("Temperature Sensor :"+value);
        }if(sensorType==Sensor.TYPE_RELATIVE_HUMIDITY){
            txSensorHum.setText("Humidity Sensor :"+value);
        }if(sensorType==Sensor.TYPE_GYROSCOPE){
            txSensorGyro.setText("Gyro Sensor :"+value);
        }if(sensorType==Sensor.TYPE_GRAVITY){
            txSensorGravity.setText("Gravity Sensor :"+value);
        }if(sensorType==Sensor.TYPE_PRESSURE){
            txSensorPressure.setText("Pressure Sensor :"+value);
        }if(sensorType==Sensor.TYPE_ORIENTATION){
            txSensorOrient.setText("Orientation Sensor :"+value);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
