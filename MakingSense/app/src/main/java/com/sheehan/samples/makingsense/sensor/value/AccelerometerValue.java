package com.sheehan.samples.makingsense.sensor.value;

import android.hardware.SensorEvent;

import com.sheehan.samples.makingsense.sensor.utils.SensorTypeEnums;

import java.util.List;

/**
 * Created by izm520 on 9/23/16.
 */
public class AccelerometerValue implements SensorValue {
    private List<SensorEvent> mSensorEventList;
    public AccelerometerValue(List<SensorEvent> sensorEventList){
        mSensorEventList = sensorEventList;
    }
    @Override
    public SensorTypeEnums getType() {
        return SensorTypeEnums.ACCELEROMETER;
    }

    @Override
    public Object getValue() {
        return mSensorEventList;
    }
}
