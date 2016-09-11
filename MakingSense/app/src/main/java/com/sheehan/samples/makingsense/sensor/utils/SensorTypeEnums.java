package com.sheehan.samples.makingsense.sensor.utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.sheehan.samples.makingsense.sensor.base.SensorClass;
import com.sheehan.samples.makingsense.sensor.implementation.GyroscopeSensor;

/**
 * Created by izm520 on 9/11/16.
 */
public enum SensorTypeEnums {

    ACCELEROMETER("Accelerometer", Sensor.TYPE_ACCELEROMETER, SensorManager.SENSOR_DELAY_FASTEST),
    GYROSCOPE("Gyroscope", Sensor.TYPE_GYROSCOPE, SensorManager.SENSOR_DELAY_FASTEST),
    GYROSCOPE_UNCALIBRATED("Gyroscope_Uncalibrated", Sensor.TYPE_GYROSCOPE_UNCALIBRATED, SensorManager.SENSOR_DELAY_FASTEST),
    LINEAR_ACCELERATION("Linear_Acceleration", Sensor.TYPE_LINEAR_ACCELERATION, SensorManager.SENSOR_DELAY_FASTEST),
    AMBIENT_TEMPERATURE("Ambient_Temperature", Sensor.TYPE_AMBIENT_TEMPERATURE, SensorManager.SENSOR_DELAY_FASTEST),
    GRAVITY("Gravity", Sensor.TYPE_GRAVITY, SensorManager.SENSOR_DELAY_FASTEST),
    MAGNETIC_FIELD("Magnetic_Field", Sensor.TYPE_MAGNETIC_FIELD, SensorManager.SENSOR_DELAY_FASTEST),
    MAGNETIC_FIELD_UNCALIBRATED("Magnetic_Field_Uncalibrated", Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED, SensorManager.SENSOR_DELAY_FASTEST),
    PRESSURE("Pressure", Sensor.TYPE_PRESSURE, SensorManager.SENSOR_DELAY_FASTEST),
    PROXIMITY("Proximity", Sensor.TYPE_PROXIMITY, SensorManager.SENSOR_DELAY_FASTEST),
    UNKNOWN("Unknown", -1, SensorManager.SENSOR_DELAY_NORMAL),
    ;

    private String mName;
    private int mType;
    private int mDelay;

    SensorTypeEnums(String name, int type, int delay){
        mName = name;
        mType = type;
        mDelay = delay;
    }

    public String getName(){
        return mName;
    }
    public int getType(){
        return mType;
    }
    public int getDelay(){
        return mType;
    }
    private static SensorTypeEnums getSensor(int sensorType) {
        for (SensorTypeEnums s : SensorTypeEnums.values()) {
            if (s.getType() == sensorType) {
                return s;
            }
        }
        return null;
    }
}
