package com.google.android.exoplayer2.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import androidx.annotation.BinderThread;
import com.zj.adlib.em3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class OrientationListener implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Display f31186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5365a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Listener[] f5367a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f5366a = new float[16];
    public final float[] b = new float[16];
    public final float[] c = new float[16];
    public final float[] d = new float[3];

    public interface Listener {
        void onOrientationChange(float[] fArr, float f);
    }

    public OrientationListener(Display display, Listener... listenerArr) {
        this.f31186a = display;
        this.f5367a = listenerArr;
    }

    public static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public final float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.b);
        SensorManager.getOrientation(this.b, this.d);
        return this.d[2];
    }

    public final void b(float[] fArr, float f) {
        for (Listener listener : this.f5367a) {
            listener.onOrientationChange(fArr, f);
        }
    }

    public final void c(float[] fArr) {
        if (!this.f5365a) {
            em3.a(this.c, fArr);
            this.f5365a = true;
        }
        float[] fArr2 = this.b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.b, 0, this.c, 0);
    }

    public final void d(float[] fArr, int i) {
        if (i != 0) {
            int i2 = 129;
            int i3 = 1;
            if (i == 1) {
                i3 = 129;
                i2 = 2;
            } else if (i == 2) {
                i3 = 130;
            } else {
                if (i != 3) {
                    throw new IllegalStateException();
                }
                i2 = 130;
            }
            float[] fArr2 = this.b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.b, i2, i3, fArr);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    @BinderThread
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f5366a, sensorEvent.values);
        d(this.f5366a, this.f31186a.getRotation());
        float fA = a(this.f5366a);
        e(this.f5366a);
        c(this.f5366a);
        b(this.f5366a, fA);
    }
}
