package com.sheehan.samples.makingsense.sensor.base;

import android.content.Context;
import android.hardware.SensorEventListener;

import com.sheehan.samples.makingsense.sensor.value.SensorValue;

import java.util.List;

/**
 * Created by izm520 on 9/11/16.
 */
public interface SensorClass {
    void connect();
    void disconnect();
    SensorValue pop();
}
