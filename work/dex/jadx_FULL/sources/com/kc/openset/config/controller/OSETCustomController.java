package com.kc.openset.config.controller;

import android.location.Location;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class OSETCustomController {
    static {
        OSETSDKProtected.interface11(4399);
    }

    public native boolean canReadInstalledPackages();

    public native boolean canReadLocation();

    public native boolean canUseMacAddress();

    public native boolean canUseNetworkState();

    public native boolean canUseOaid();

    public native boolean canUsePersonalizedAd();

    public native boolean canUsePhoneState();

    public native boolean canUseSensor();

    public native boolean canUseStoragePermission();

    public native String getAndroidId();

    public native String getImei();

    public native List<String> getInstalledPackages();

    public native Location getLocation();

    public native String getMacAddress();

    public native String getOaid();
}
