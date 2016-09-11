package com.sheehan.samples.makingsense.managers;

import android.hardware.Sensor;

/**
 * Created by izm520 on 8/21/16.
 */
public class SensorManagerImpl implements SensorManager{
    //https://developer.android.com/guide/topics/sensors/sensors_overview.html

    private static SensorManagerImpl sInstance;
    private static int mSensorTypeList[] = {Sensor.TYPE_ACCELEROMETER};
    private SensorManagerImpl(){}
    public static SensorManagerImpl getInstance(){
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

    }

    /**
     * disconnect
     */
    @Override
    public void disconnect() {

    }
}
