package com.kc.openset.pine.manager;

import android.hardware.SensorEventListener;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class SensorConfigBean {
    private Object object;
    private SensorEventListener originalSensorEventListener;
    private PineUtils.SsSensorEventListener ssSensorEventListener;

    static {
        OSETSDKProtected.interface11(4609);
    }

    public native Object getObject();

    public native SensorEventListener getOriginalSensorEventListener();

    public native PineUtils.SsSensorEventListener getSsSensorEventListener();

    public native void setObject(Object obj);

    public native void setOriginalSensorEventListener(SensorEventListener sensorEventListener);

    public native void setSsSensorEventListener(PineUtils.SsSensorEventListener ssSensorEventListener);
}
