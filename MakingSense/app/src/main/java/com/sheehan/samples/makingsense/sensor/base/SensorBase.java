package com.sheehan.samples.makingsense.sensor.base;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import com.sheehan.samples.makingsense.sensor.utils.SensorTypeEnums;

/**
 * Created by izm520 on 9/11/16.
 */
public class SensorBase {

    private Sensor mSensor;
    private SensorTypeEnums mSensorTypeEnums;
    private SensorEventListener mSensorEventListener;
    private SensorManager mSensorManager;

    public SensorBase(final Context context, SensorTypeEnums sensorTypeEnums) {
        SensorManager sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        mSensor = sensorManager.getDefaultSensor(sensorTypeEnums.getType());
        mSensorTypeEnums = sensorTypeEnums;
    }

    public SensorTypeEnums getSensorType() {
        return mSensorTypeEnums;
    }

    public Sensor getAndroidSensor() {
        return mSensor;
    }

    public SensorManager getAndroidSensorManager(){
        return mSensorManager;
    }

    public int getDelay(){
        return mSensorTypeEnums.getDelay();
    }

    public void connect(SensorEventListener listener){
        SensorManager sensorManager = getAndroidSensorManager();
        sensorManager.registerListener(mSensorEventListener = listener,
                getAndroidSensor(),
                getDelay());
    }

    public void disconnect(){
        SensorManager sensorManager = getAndroidSensorManager();
        sensorManager.unregisterListener(mSensorEventListener);
        mSensorEventListener = null;
    }
}
