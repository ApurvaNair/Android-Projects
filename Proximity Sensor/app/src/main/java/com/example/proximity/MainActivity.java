package com.example.proximity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    SensorManager sensorManager= null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        if(sensorManager!=null){
            Sensor proxisensor=sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
            if(proxisensor != null){
                sensorManager.registerListener(this,proxisensor,SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
        else{
            Toast.makeText(this, "Sensor service not detected", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType()==Sensor.TYPE_PROXIMITY){
            TextView txt=findViewById(R.id.textView1);
            txt.setText("Values: "+event.values[0]);

            if(event.values[0]>0){
                Toast.makeText(this, "Object is far", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(this, "Object is near", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
    
}

