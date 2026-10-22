package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface ISensorManagerProxy {
    @Deprecated
    SensorManager checkAndObtainSensorManager(Context context);

    Sensor getDefaultSensor(Context context, int i);

    boolean registerListener(Context context, SensorEventListener sensorEventListener, Sensor sensor, int i);

    void unregisterListener(SensorEventListener sensorEventListener);
}
