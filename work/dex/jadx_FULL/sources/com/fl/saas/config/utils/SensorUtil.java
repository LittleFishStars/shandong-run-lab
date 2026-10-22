package com.fl.saas.config.utils;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.zj.adlib.g58;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SensorUtil implements SensorEventListener {
    private static SensorUtil sInstance;
    private Sensor accelerometerSensor;
    private SensorManager sensorManager;

    private SensorUtil() {
    }

    public static SensorUtil getInstance() {
        if (sInstance == null) {
            synchronized (SensorUtil.class) {
                sInstance = new SensorUtil();
            }
        }
        return sInstance;
    }

    private void registerAccelerometer() {
        try {
            DeviceUtil.deviceHasAccelerometerSensor = false;
            if (this.sensorManager == null) {
                this.sensorManager = (SensorManager) DeviceUtil.getContext().getSystemService("sensor");
            }
            if (this.accelerometerSensor == null) {
                this.accelerometerSensor = this.sensorManager.getDefaultSensor(1);
            }
            this.sensorManager.registerListener(this, this.accelerometerSensor, 3);
            DeviceUtil.postUIDelayed(200L, new g58(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unRegisterAccelerometer() {
        try {
            SensorManager sensorManager = this.sensorManager;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                this.sensorManager = null;
                this.accelerometerSensor = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkSensorEnable() {
        registerAccelerometer();
        DeviceUtil.postUIDelayed(500L, new g58(this));
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        DeviceUtil.deviceHasAccelerometerSensor = true;
        unRegisterAccelerometer();
    }
}
