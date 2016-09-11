package com.sheehan.samples.makingsense.sensor.implementation;

import android.content.Context;

import com.sheehan.samples.makingsense.MakingSenseApplication;
import com.sheehan.samples.makingsense.sensor.base.SensorBase;
import com.sheehan.samples.makingsense.sensor.base.SensorClass;
import com.sheehan.samples.makingsense.sensor.utils.SensorTypeEnums;

/**
 * Created by izm520 on 9/11/16.
 */
public class AccelerometerSensor extends SensorBase implements SensorClass{
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

    public void connect(){

    }
}
