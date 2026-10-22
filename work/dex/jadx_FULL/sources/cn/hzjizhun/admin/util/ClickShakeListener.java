package cn.hzjizhun.admin.util;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import cn.hzjizhun.admin.JZAdSdk;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ClickShakeListener implements SensorEventListener {
    private static final int SPEED_SHRESHOLD = 3000;
    private static final int UPTATE_INTERVAL_TIME = 70;
    private boolean isStart;
    private long lastUpdateTime;
    private float lastX;
    private float lastY;
    private float lastZ;
    private Context mContext;
    private volatile double mSpeed;
    private Sensor sensor;
    private SensorManager sensorManager;
    private int mAcceleratio = -1;
    private boolean mIsPreClick = false;

    private ClickShakeListener(Context context) {
        this.mContext = context;
    }

    public static ClickShakeListener getInstance() {
        return new ClickShakeListener(JZAdSdk.getInstance().getContext());
    }

    public boolean isClick(int i) {
        if (i == -1) {
            return false;
        }
        if (!this.mIsPreClick) {
            this.mAcceleratio = -1;
            return this.mSpeed > ((double) i);
        }
        this.mIsPreClick = false;
        this.mAcceleratio = -1;
        return true;
    }

    public boolean isPreviewClick() {
        if (this.mAcceleratio == -1) {
            return false;
        }
        return this.mIsPreClick || this.mSpeed > ((double) this.mAcceleratio);
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
        this.mIsPreClick = isPreviewClick();
    }

    public void setAcceleratio(int i) {
        this.mAcceleratio = i;
    }

    public void start() {
        Context context;
        if (this.isStart || (context = this.mContext) == null) {
            return;
        }
        this.isStart = true;
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.sensorManager = sensorManager;
            if (sensorManager != null) {
                this.sensor = sensorManager.getDefaultSensor(1);
            }
            Sensor sensor = this.sensor;
            if (sensor != null) {
                this.sensorManager.registerListener(this, sensor, 1);
            }
        } catch (Throwable unused) {
        }
    }

    public void stop() {
        try {
            SensorManager sensorManager = this.sensorManager;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this);
            }
        } catch (Throwable unused) {
        }
    }
}
