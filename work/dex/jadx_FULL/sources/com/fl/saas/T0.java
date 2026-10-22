package com.fl.saas;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.fl.saas.adx.util.DeviceUtil;
import com.zj.adlib.zy8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class T0 implements SensorEventListener {
    private static T0 c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SensorManager f30087a;
    private Sensor b;

    private T0() {
    }

    public static T0 b() {
        if (c == null) {
            synchronized (T0.class) {
                c = new T0();
            }
        }
        return c;
    }

    private void c() {
        try {
            DeviceUtil.deviceHasAccelerometerSensor = false;
            if (this.f30087a == null) {
                this.f30087a = (SensorManager) DeviceUtil.getContext().getSystemService("sensor");
            }
            if (this.b == null) {
                this.b = this.f30087a.getDefaultSensor(1);
            }
            this.f30087a.registerListener(this, this.b, 3);
            DeviceUtil.postUIDelayed(200L, new zy8(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        try {
            SensorManager sensorManager = this.f30087a;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
                this.f30087a = null;
                this.b = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a() {
        c();
        DeviceUtil.postUIDelayed(500L, new zy8(this));
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        DeviceUtil.deviceHasAccelerometerSensor = true;
        d();
    }
}
