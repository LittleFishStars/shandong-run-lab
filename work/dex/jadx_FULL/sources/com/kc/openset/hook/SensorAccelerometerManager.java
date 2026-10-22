package com.kc.openset.hook;

import android.util.LruCache;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class SensorAccelerometerManager {
    private static final String TAG = OSETSDKProtected.getString2(1766);
    private static final LruCache<String, AdSensorConfigBean> mAdSensorConfigBeanLruCache;
    private static List<SensitivityBean> mSensitivityBeanList;

    static {
        OSETSDKProtected.interface11(4449);
        mAdSensorConfigBeanLruCache = new LruCache<>(10000);
    }

    public static native AdSensorConfigBean getAdSensorConfigBean();

    public static native void initData(List<SensitivityBean> list);

    public static native boolean isTriggered(double d);

    public static native void removeSensorAccelerometerConfig(String str, AdType adType, String str2);

    public static native boolean setSensorAccelerometerConfig(String str, AdType adType, String str2, boolean z);

    public static native boolean setSensorAccelerometerConfig(String str, AdType adType, String str2, boolean z, Object obj, boolean z2, AdSensorConfigBean.OnFlowFinishedListener onFlowFinishedListener);
}
