package com.sheehan.samples.makingsense.managers;

/**
 * Created by izm520 on 8/21/16.
 */
public class SensorManager {
    private static SensorManager sInstance;
    private SensorManager(){}
    public static SensorManager getInstance(){
        if(sInstance == null){
            sInstance = new SensorManager();
        }
        return sInstance;
    }
}
