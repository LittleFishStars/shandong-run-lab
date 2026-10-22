package com.zj.adlib;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;
import com.king.zxing.camera.CameraManager;
import com.king.zxing.camera.FrontLightMode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public final class i50 implements SensorEventListener {
    public static final float c = 45.0f;
    public static final float d = 100.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f17148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Sensor f17149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CameraManager f17150a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f42284a = 45.0f;
    public float b = 100.0f;

    public i50(Context context) {
        this.f17148a = context;
    }

    public void a(float f) {
        this.b = f;
    }

    public void b(float f) {
        this.f42284a = f;
    }

    public void c(CameraManager cameraManager) {
        this.f17150a = cameraManager;
        if (FrontLightMode.readPref(PreferenceManager.getDefaultSharedPreferences(this.f17148a)) == FrontLightMode.AUTO) {
            SensorManager sensorManager = (SensorManager) this.f17148a.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f17149a = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void d() {
        if (this.f17149a != null) {
            ((SensorManager) this.f17148a.getSystemService("sensor")).unregisterListener(this);
            this.f17150a = null;
            this.f17149a = null;
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        CameraManager cameraManager = this.f17150a;
        if (cameraManager != null) {
            if (f <= this.f42284a) {
                cameraManager.k(true, f);
            } else if (f >= this.b) {
                cameraManager.k(false, f);
            }
        }
    }
}
