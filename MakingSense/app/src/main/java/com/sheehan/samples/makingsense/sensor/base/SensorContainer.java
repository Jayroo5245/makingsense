package com.sheehan.samples.makingsense.sensor.base;

import com.sheehan.samples.makingsense.sensor.value.SensorValue;

import java.util.List;

/**
 * Created by izm520 on 9/19/16.
 */
public class SensorContainer {
    List<SensorValue> mSensorValues;
    public SensorContainer(List<SensorValue> sensorValues){
        mSensorValues = sensorValues;
    }
    public List<SensorValue> getSensorValues(){
        return mSensorValues;
    }
}
