package com.sheehan.samples.makingsense.sensor.value;

import com.sheehan.samples.makingsense.sensor.utils.SensorTypeEnums;

/**
 * Created by izm520 on 9/23/16.
 */
public interface SensorValue {
    SensorTypeEnums getType();
    Object getValue();
}
