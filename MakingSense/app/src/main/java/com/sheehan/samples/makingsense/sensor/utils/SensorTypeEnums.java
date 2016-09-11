package com.sheehan.samples.makingsense.sensor.utils;

import android.hardware.Sensor;

/**
 * Created by izm520 on 9/11/16.
 */
public enum SensorTypeEnums {
    
    ACCELEROMETER("Accelerometer", Sensor.TYPE_ACCELEROMETER),
    GYROSCOPE("Gyroscope", Sensor.TYPE_GYROSCOPE),
    GYROSCOPE_UNCALIBRATED("Gyroscope_Uncalibrated", Sensor.TYPE_GYROSCOPE_UNCALIBRATED),
    LINEAR_ACCELERATION("Linear_Acceleration", Sensor.TYPE_LINEAR_ACCELERATION),
    AMBIENT_TEMPERATURE("Ambient_Temperature", Sensor.TYPE_AMBIENT_TEMPERATURE),
    GRAVITY("Gravity", Sensor.TYPE_GRAVITY),
    MAGNETIC_FIELD("Magnetic_Field", Sensor.TYPE_MAGNETIC_FIELD),
    MAGNETIC_FIELD_UNCALIBRATED("Magnetic_Field_Uncalibrated", Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED),
    PRESSURE("Pressure", Sensor.TYPE_PRESSURE),
    PROXIMITY("Proximity", Sensor.TYPE_PROXIMITY),
    UNKNOWN("Unknown", -1),
    ;

    private String mName;
    private int mType;

    SensorTypeEnums(String name, int type){
        mName = name;
        mType = type;
    }

    public String getName(){
        return mName;
    }
    public int getType(){
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
