package com.sheehan.samples.makingsense.managers;

import android.hardware.SensorEventListener;

/**
 * Created by jsheehan on 9/11/16.
 */
public interface SensorManager {
    void connect(SensorEventListener listener);
    void disconnect();
}
