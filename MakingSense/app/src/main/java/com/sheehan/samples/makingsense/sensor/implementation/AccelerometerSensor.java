package com.sheehan.samples.makingsense.sensor.implementation;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import com.sheehan.samples.makingsense.MakingSenseApplication;
import com.sheehan.samples.makingsense.sensor.base.SensorBase;
import com.sheehan.samples.makingsense.sensor.base.SensorClass;
import com.sheehan.samples.makingsense.sensor.utils.SensorTypeEnums;
import com.sheehan.samples.makingsense.sensor.value.AccelerometerValue;
import com.sheehan.samples.makingsense.sensor.value.SensorValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by izm520 on 9/11/16.
 */
public class AccelerometerSensor extends SensorBase implements SensorClass, SensorEventListener{
    private static AccelerometerSensor sInstance;
    private AccelerometerSensor(Context context){
        super(context, SensorTypeEnums.ACCELEROMETER);
    }

    public static SensorClass getSensor() {
        if(sInstance == null){
            sInstance = new AccelerometerSensor(MakingSenseApplication.getInstance());
        }
        return sInstance;
    }

    @Override
    public void connect(){
        super.connect(this);
    }

    @Override
    public void disconnect(){
        super.disconnect();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        mSensorQueue.add(event);
    }

    @Override
    public SensorValue pop() {
        List<SensorEvent> list = new ArrayList<>(mSensorQueue);
        SensorValue sensorValue = new AccelerometerValue(list);
        mSensorQueue.clear();
        return sensorValue;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //TODO
    }
}
