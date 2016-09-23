package com.sheehan.samples.makingsense.managers;

import android.hardware.SensorEventListener;

import com.sheehan.samples.makingsense.sensor.base.SensorContainer;

/**
 * Created by jsheehan on 9/11/16.
 */
public interface SensorManager {
    void connect();
    void disconnect();
    boolean isConnected();
    SensorContainer pop();
}
