package com.sheehan.samples.makingsense.managers;

import android.content.Context;
import android.graphics.LightingColorFilter;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;

import com.sheehan.samples.makingsense.sensor.base.SensorClass;
import com.sheehan.samples.makingsense.sensor.implementation.AccelerometerSensor;
import com.sheehan.samples.makingsense.sensor.implementation.GyroscopeSensor;
import com.sheehan.samples.makingsense.sensor.utils.SensorTypeEnums;

import java.util.List;

/**
 * Created by izm520 on 8/21/16.
 */
public class SensorManagerImpl implements SensorManager{
    private boolean isConnected;
    //https://developer.android.com/guide/topics/sensors/sensors_overview.html
    public SensorManagerImpl(){}

    /**
     * connect
     */
    @Override
    public void connect() {
        isConnected = true;
        SensorTypeEnums[] sensorTypeEnumsList = SensorTypeEnums.values();
        for(SensorTypeEnums sensorTypeEnum: sensorTypeEnumsList){
            //Setup all the sensor types
            SensorClass sensorClass = getSensor(sensorTypeEnum);
            if(sensorClass != null){
                sensorClass.connect();
            }
        }
    }

    /**
     * disconnect
     */
    @Override
    public void disconnect() {
        SensorTypeEnums[] sensorTypeEnumsList = SensorTypeEnums.values();
        for(SensorTypeEnums sensorTypeEnum: sensorTypeEnumsList){
            //Setup all the sensor types
            SensorClass sensorClass = getSensor(sensorTypeEnum);
            if(sensorClass != null){
                sensorClass.disconnect();
            }
        }
        isConnected = false;
    }

    private static SensorClass getSensor(SensorTypeEnums sensorTypeEnum) {
        switch (sensorTypeEnum) {
            case ACCELEROMETER:
                return AccelerometerSensor.getSensor();
            case GYROSCOPE:
                return GyroscopeSensor.getSensor();
            default:
                return null;
        }
    }

    public boolean isConnected(){
        return isConnected;
    }
}
