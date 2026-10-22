package com.bwt.top.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.bwt.top.AdSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ClickShakeListener implements SensorEventListener {
    private static final int SPEED_SHRESHOLD = 3000;
    private static final int UPTATE_INTERVAL_TIME = 70;
    private static ClickShakeListener mListener;
    private boolean isStart;
    private long lastUpdateTime;
    private float lastX;
    private float lastY;
    private float lastZ;
    private Context mContext;
    private volatile double mSpeed;
    private Sensor sensor;
    private SensorManager sensorManager;

    private ClickShakeListener(Context context) {
        this.mContext = context;
        start();
    }

    public static ClickShakeListener getInstance() {
        if (mListener == null) {
            synchronized (ClickShakeListener.class) {
                if (mListener == null) {
                    mListener = new ClickShakeListener(AdSdk.getInstance().getContext());
                }
            }
        }
        return mListener;
    }

    public boolean isClick(int i) {
        return i != -1 && this.mSpeed > ((double) i);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - this.lastUpdateTime;
        if (j < 70) {
            return;
        }
        this.lastUpdateTime = jCurrentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = f - this.lastX;
        float f5 = f2 - this.lastY;
        float f6 = f3 - this.lastZ;
        this.lastX = f;
        this.lastY = f2;
        this.lastZ = f3;
        this.mSpeed = (Math.sqrt(((f4 * f4) + (f5 * f5)) + (f6 * f6)) / j) * 10000.0d;
    }

    public void start() {
        Context context;
        if (this.isStart || (context = this.mContext) == null) {
            return;
        }
        this.isStart = true;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.sensorManager = sensorManager;
        if (sensorManager != null) {
            this.sensor = sensorManager.getDefaultSensor(1);
        }
        Sensor sensor = this.sensor;
        if (sensor != null) {
            this.sensorManager.registerListener(this, sensor, 1);
        }
    }

    public void stop() {
        this.sensorManager.unregisterListener(this);
    }
}
