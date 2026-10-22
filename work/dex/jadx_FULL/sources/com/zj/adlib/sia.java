package com.zj.adlib;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.view.WindowManager;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class sia implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f44699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Context f19583a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Sensor f19584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SensorManager f19585a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Marker f19586a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f19587a;
    public Sensor b;
    public Sensor c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f19589a = new float[3];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public float[] f19590b = new float[3];

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public float[] f19591c = new float[3];
    public float[] d = new float[9];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19588a = true;

    public sia(Context context, IAMapDelegate iAMapDelegate) {
        this.f19583a = context.getApplicationContext();
        this.f19587a = iAMapDelegate;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.f19585a = sensorManager;
            if (sensorManager != null && j()) {
                this.f19584a = this.f19585a.getDefaultSensor(3);
            } else {
                this.b = this.f19585a.getDefaultSensor(1);
                this.c = this.f19585a.getDefaultSensor(2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static int c(Context context) {
        WindowManager windowManager;
        if (context == null || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return 0;
        }
        try {
            int rotation = windowManager.getDefaultDisplay().getRotation();
            if (rotation == 1) {
                return 90;
            }
            if (rotation != 2) {
                return rotation != 3 ? 0 : -90;
            }
            return 180;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public final float a(float f) {
        return g(f);
    }

    public final float b(float[] fArr, float[] fArr2) {
        if (!SensorManager.getRotationMatrix(this.d, null, fArr, fArr2)) {
            return 0.0f;
        }
        SensorManager.getOrientation(this.d, this.f19591c);
        float[] fArr3 = this.f19591c;
        fArr3[0] = (float) Math.toDegrees(fArr3[0]);
        return this.f19591c[0];
    }

    public final void d() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f19585a;
        if (sensorManager != null && (sensor2 = this.f19584a) != null) {
            sensorManager.registerListener(this, sensor2, 3);
        }
        SensorManager sensorManager2 = this.f19585a;
        if (sensorManager2 == null || (sensor = this.b) == null || this.c == null) {
            return;
        }
        sensorManager2.registerListener(this, sensor, 3);
        this.f19585a.registerListener(this, this.c, 3);
    }

    public final void e(Marker marker) {
        this.f19586a = marker;
    }

    public final void f(boolean z) {
        this.f19588a = z;
    }

    public final float g(float f) {
        float fC = (f + c(this.f19583a)) % 360.0f;
        if (fC > 180.0f) {
            fC -= 360.0f;
        } else if (fC < -180.0f) {
            fC += 360.0f;
        }
        if (Float.isNaN(fC)) {
            return 0.0f;
        }
        return fC;
    }

    public final void h() {
        Sensor sensor;
        Sensor sensor2;
        SensorManager sensorManager = this.f19585a;
        if (sensorManager != null && (sensor2 = this.f19584a) != null) {
            sensorManager.unregisterListener(this, sensor2);
        }
        SensorManager sensorManager2 = this.f19585a;
        if (sensorManager2 == null || (sensor = this.b) == null || this.c == null) {
            return;
        }
        sensorManager2.unregisterListener(this, sensor);
        this.f19585a.unregisterListener(this, this.c);
    }

    public final void i(float f) {
        Marker marker = this.f19586a;
        if (marker != null) {
            try {
                if (!this.f19588a) {
                    marker.setRotateAngle(360.0f - f);
                } else {
                    this.f19587a.moveCamera(kja.q(f));
                    this.f19586a.setRotateAngle(-f);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final boolean j() {
        SensorManager sensorManager = this.f19585a;
        if (sensorManager == null) {
            return false;
        }
        for (Sensor sensor : sensorManager.getSensorList(-1)) {
            int type = sensor.getType();
            sensor.getStringType();
            if (type == 3) {
                return true;
            }
        }
        return false;
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        try {
            if (this.f19587a.getGLMapEngine() == null || this.f19587a.getGLMapEngine().getAnimateionsCount() <= 0) {
                int type = sensorEvent.sensor.getType();
                if (type == 3) {
                    float f = sensorEvent.values[0];
                    float fA = a(f);
                    if (Math.abs(this.f44699a - f) < 3.0f) {
                        return;
                    }
                    this.f44699a = fA;
                    i(fA);
                    return;
                }
                if (type == 1) {
                    this.f19589a = (float[]) sensorEvent.values.clone();
                } else if (type == 2) {
                    this.f19590b = (float[]) sensorEvent.values.clone();
                }
                float fB = b(this.f19589a, this.f19590b);
                if (Math.abs(this.f44699a - fB) < 3.0f) {
                    return;
                }
                this.f44699a = fB;
                i(fB);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
