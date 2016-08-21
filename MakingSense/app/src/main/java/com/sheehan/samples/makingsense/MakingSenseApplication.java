package com.sheehan.samples.makingsense;

import android.app.Application;

/**
 * Created by izm520 on 8/21/16.
 */
public class MakingSenseApplication extends Application {
    private static MakingSenseApplication sInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static MakingSenseApplication getInstance() {
        return sInstance;
    }
}
