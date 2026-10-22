package com.kc.openset.ad.base.bridge.utils;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class GlobalConfigBridge {
    static {
        OSETSDKProtected.interface11(3788);
    }

    public static native boolean canReadInstalledPackages();

    public static native boolean canReadLocation();

    public static native boolean canUseMacAddress();

    public static native boolean canUseNetworkState();

    public static native boolean canUseOaid();

    public static native boolean canUsePhoneState();

    public static native boolean canUseSensor();

    public static native boolean canUseStoragePermission();

    public static native String getAndroidId();

    public static native List<String> getAppPackageInfoList();

    public static native String getIMEI();

    public static native String getMac();

    public static native String getOAID();

    public static native boolean isDebug();

    public static native boolean isOpenPersonalizedAd();

    public static native boolean isSafe(Activity activity);
}
