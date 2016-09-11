package com.sheehan.samples.makingsense.managers;

import android.content.Context;
import android.graphics.LightingColorFilter;
import android.hardware.Sensor;

import com.sheehan.samples.makingsense.sensor.base.SensorClass;
import com.sheehan.samples.makingsense.sensor.implementation.AccelerometerSensor;
import com.sheehan.samples.makingsense.sensor.implementation.GyroscopeSensor;
import com.sheehan.samples.makingsense.sensor.utils.SensorTypeEnums;

import java.util.List;

/**
 * Created by izm520 on 8/21/16.
 */
public class SensorManagerImpl implements SensorManager{
    //https://developer.android.com/guide/topics/sensors/sensors_overview.html

    private static SensorManagerImpl sInstance;
    private SensorManagerImpl(){}
    public static SensorManager getInstance(){
        if(sInstance == null){
            sInstance = new SensorManagerImpl();
        }
        return sInstance;
    }

    /**
     * connect
     */
    @Override
    public void connect() {
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
}
