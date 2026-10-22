package com.kc.dw.platform.ad_adapter.splash;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShakeUtil f39546a;

    public c(ShakeUtil shakeUtil) {
        this.f39546a = shakeUtil;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        SensorManager sensorManager;
        SensorEventListener sensorEventListener;
        Sensor sensor;
        try {
            if (this.f39546a.c == null && com.kc.dw.base.a.getContext() != null) {
                this.f39546a.c = (SensorManager) com.kc.dw.base.a.getContext().getSystemService("sensor");
            }
            ShakeUtil shakeUtil = this.f39546a;
            SensorManager sensorManager2 = shakeUtil.c;
            if (sensorManager2 != null) {
                int i = shakeUtil.f39541a;
                if (i == 2 || i == 6) {
                    if (shakeUtil.k == null) {
                        shakeUtil.k = sensorManager2.getDefaultSensor(4);
                    }
                    ShakeUtil shakeUtil2 = this.f39546a;
                    sensorManager = shakeUtil2.c;
                    sensorEventListener = shakeUtil2.n;
                    sensor = shakeUtil2.k;
                } else if (i == 1 || i == 4) {
                    if (shakeUtil.l == null) {
                        shakeUtil.l = sensorManager2.getDefaultSensor(9);
                    }
                    ShakeUtil shakeUtil3 = this.f39546a;
                    if (shakeUtil3.m == null) {
                        shakeUtil3.m = shakeUtil3.c.getDefaultSensor(1);
                    }
                    ShakeUtil shakeUtil4 = this.f39546a;
                    if (shakeUtil4.k == null) {
                        shakeUtil4.k = shakeUtil4.c.getDefaultSensor(4);
                    }
                    ShakeUtil shakeUtil5 = this.f39546a;
                    shakeUtil5.c.registerListener(shakeUtil5.n, shakeUtil5.l, 1);
                    ShakeUtil shakeUtil6 = this.f39546a;
                    shakeUtil6.c.registerListener(shakeUtil6.n, shakeUtil6.k, 2);
                    ShakeUtil shakeUtil7 = this.f39546a;
                    sensorManager = shakeUtil7.c;
                    sensorEventListener = shakeUtil7.n;
                    sensor = shakeUtil7.m;
                } else {
                    if (i != 3 && i != 5 && i != 7 && i != 8) {
                        return;
                    }
                    if (shakeUtil.k == null) {
                        shakeUtil.k = sensorManager2.getDefaultSensor(4);
                    }
                    ShakeUtil shakeUtil8 = this.f39546a;
                    shakeUtil8.c.registerListener(shakeUtil8.n, shakeUtil8.k, 2);
                    ShakeUtil shakeUtil9 = this.f39546a;
                    if (shakeUtil9.l == null) {
                        shakeUtil9.l = shakeUtil9.c.getDefaultSensor(9);
                    }
                    ShakeUtil shakeUtil10 = this.f39546a;
                    shakeUtil10.c.registerListener(shakeUtil10.n, shakeUtil10.l, 1);
                    ShakeUtil shakeUtil11 = this.f39546a;
                    if (shakeUtil11.m == null) {
                        shakeUtil11.m = shakeUtil11.c.getDefaultSensor(1);
                    }
                    ShakeUtil shakeUtil12 = this.f39546a;
                    sensorManager = shakeUtil12.c;
                    sensorEventListener = shakeUtil12.n;
                    sensor = shakeUtil12.m;
                }
                sensorManager.registerListener(sensorEventListener, sensor, 2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
