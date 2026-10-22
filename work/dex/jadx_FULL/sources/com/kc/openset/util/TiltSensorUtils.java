package com.kc.openset.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class TiltSensorUtils implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile TiltSensorUtils f39965a;
    private SensorManager b;
    private Sensor c;
    private Sensor d;
    private float[] e;
    private float[] f;
    private boolean g;
    private float h;
    private float i;
    private float j;
    private long k;
    private int l;
    private int m;
    private int n;
    private int s;
    private boolean o = false;
    private float p = 0.0f;
    private float q = 0.0f;
    private float r = 0.0f;
    private boolean t = false;
    private long u = 0;
    private final LinkedHashMap<OnTiltListener, Boolean> v = new LinkedHashMap<>();
    private boolean w = false;
    private boolean x = false;

    @Keep
    public interface OnTiltListener {
        void onTilt(int i, int i2, int i3, long j, boolean z);
    }

    static {
        OSETSDKProtected.interface11(4993);
    }

    public TiltSensorUtils(Context context, int i) {
        this.g = true;
        LogUtils.writeD(OSETSDKProtected.getString2(3268), OSETSDKProtected.getString2(3257) + i);
        if (!com.kc.openset.config.c.g() || i == 0) {
            this.g = false;
            return;
        }
        this.s = i;
        SensorManager sensorManager = (SensorManager) context.getSystemService(OSETSDKProtected.getString2(3259));
        this.b = sensorManager;
        this.c = sensorManager.getDefaultSensor(1);
        this.d = this.b.getDefaultSensor(2);
    }

    private native int a(float f, float f2);

    private native int a(int i);

    private native OnTiltListener a();

    public static native TiltSensorUtils a(Context context, int i);

    private native void a(int i, int i2, int i3, long j, boolean z);

    public static native boolean a(int i, int i2, int i3, int i4);

    private native void b();

    private native void e();

    public native void a(OnTiltListener onTiltListener);

    public native void b(OnTiltListener onTiltListener);

    public native void c();

    public native void c(OnTiltListener onTiltListener);

    public native void d();

    public native void f();

    @Override // android.hardware.SensorEventListener
    public native void onAccuracyChanged(Sensor sensor, int i);

    @Override // android.hardware.SensorEventListener
    public native void onSensorChanged(SensorEvent sensorEvent);
}
