package com.sheehan.samples.makingsense.sensor.base;

import android.content.Context;
import android.hardware.SensorEventListener;

/**
 * Created by izm520 on 9/11/16.
 */
public interface SensorClass {

    void connect(SensorEventListener listener);
    void disconnect();
}
