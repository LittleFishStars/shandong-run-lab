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
public class ShakeItUtils implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ShakeItUtils f39964a;
    private SensorManager b;
    private Sensor c;
    private boolean f;
    private int h;
    private long d = 0;
    private long e = 0;
    private boolean g = false;
    private float i = 0.0f;
    private float j = 0.0f;
    private float k = 0.0f;
    private long l = 0;
    private final LinkedHashMap<OnShakeListener, Boolean> m = new LinkedHashMap<>();

    @Keep
    public interface OnShakeListener {
        void onShake(int i, int i2, int i3);
    }

    static {
        OSETSDKProtected.interface11(4984);
    }

    public ShakeItUtils(Context context, int i) {
        this.f = true;
        LogUtils.writeD(OSETSDKProtected.getString2(3258), OSETSDKProtected.getString2(3257) + i);
        if (!com.kc.openset.config.c.g() || i == 0) {
            this.f = false;
            return;
        }
        this.h = i;
        SensorManager sensorManager = (SensorManager) context.getSystemService(OSETSDKProtected.getString2(3259));
        this.b = sensorManager;
        this.c = sensorManager.getDefaultSensor(1);
    }

    public static native ShakeItUtils a(Context context, int i);

    private native void a(float f, float f2, float f3);

    private native boolean a();

    private native OnShakeListener b();

    private native void d();

    public native void a(OnShakeListener onShakeListener);

    public native void b(OnShakeListener onShakeListener);

    public native void c();

    public native void c(OnShakeListener onShakeListener);

    public native void e();

    @Override // android.hardware.SensorEventListener
    public native void onAccuracyChanged(Sensor sensor, int i);

    @Override // android.hardware.SensorEventListener
    public native void onSensorChanged(SensorEvent sensorEvent);
}
