package com.sheehan.samples.makingsense;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.sheehan.samples.makingsense.managers.SensorManager;
import com.sheehan.samples.makingsense.managers.SensorManagerImpl;

/**
 * Created by izm520 on 8/21/16.
 */
public class MakingSenseApplication extends Application {
    private static MakingSenseApplication sInstance;
    private SensorManager mSensorManager;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mSensorManager = new SensorManagerImpl();
        Stetho.initializeWithDefaults(this);
    }

    public static MakingSenseApplication getInstance() {
        return sInstance;
    }
    public SensorManager getSensorManager() {
        return mSensorManager;
    }
}
