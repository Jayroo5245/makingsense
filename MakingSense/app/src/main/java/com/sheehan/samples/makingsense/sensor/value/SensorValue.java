package com.sheehan.samples.makingsense.sensor.value;

import android.hardware.SensorEvent;

import com.sheehan.samples.makingsense.sensor.utils.SensorTypeEnums;

import java.util.List;

/**
 * Created by izm520 on 9/23/16.
 */
public interface SensorValue {
    SensorTypeEnums getType();
    List<SensorEvent> getValue();
}

