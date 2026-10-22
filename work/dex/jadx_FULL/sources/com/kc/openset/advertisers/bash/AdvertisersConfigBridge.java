package com.kc.openset.advertisers.bash;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class AdvertisersConfigBridge {
    static {
        OSETSDKProtected.interface11(4243);
    }

    public static native void addOriginalInitConfigBeanList(OriginalInitConfigBeanBridge originalInitConfigBeanBridge);

    public static native void addOriginalLoadConfigBeanList(OriginalLoadConfigBeanBridge originalLoadConfigBeanBridge);

    public static native void addOriginalVideoContentConfigBeanList(OriginalVideoContentConfigBeanBridge originalVideoContentConfigBeanBridge);

    public static native void initFail(String str);

    public static native void initSuccess(String str);

    public static native void startFail(String str);

    public static native void startInit(String str);

    public static native void startSuccess(String str);

    public static native void starting(String str);
}
