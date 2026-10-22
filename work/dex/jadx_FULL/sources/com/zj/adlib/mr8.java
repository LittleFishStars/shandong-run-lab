package com.zj.adlib;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.huachenjie.common.step.StepCountListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class mr8 implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StepCountListener f18287a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float[] f18289a = new float[3];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18288a = false;
    public int K = 0;
    public int L = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18291b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f43372a = 0.0f;
    public float b = 0.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f18286a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f18290b = 0;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f18292c = 0;
    public float c = 0.0f;
    public float d = 0.0f;
    public float e = 2.0f;
    public int M = 250;

    public void a(float values) {
        float f = this.d;
        if (f == 0.0f) {
            this.d = values;
        } else if (b(values, f)) {
            this.f18290b = this.f18286a;
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f18292c = jCurrentTimeMillis;
            if (jCurrentTimeMillis - this.f18290b >= this.M && this.f43372a - this.b >= this.e) {
                this.f18286a = jCurrentTimeMillis;
                this.f18287a.a();
            }
        }
        this.d = values;
    }

    public boolean b(float newValue, float oldValue) {
        boolean z = this.f18288a;
        this.f18291b = z;
        if (newValue >= oldValue) {
            this.f18288a = true;
            this.K++;
        } else {
            this.L = this.K;
            this.K = 0;
            this.f18288a = false;
        }
        boolean z2 = this.f18288a;
        if (!z2 && z && (this.L >= 2 || oldValue >= 20.0f)) {
            this.f43372a = oldValue;
            return true;
        }
        if (!z && z2) {
            this.b = oldValue;
        }
        return false;
    }

    public void c(StepCountListener listener) {
        this.f18287a = listener;
    }

    public void d(int threadValue) {
        this.e = threadValue;
    }

    public void e(int timeInterval) {
        this.M = timeInterval;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        for (int i = 0; i < 3; i++) {
            this.f18289a[i] = event.values[i];
        }
        float[] fArr = this.f18289a;
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
        this.c = fSqrt;
        a(fSqrt);
    }
}
