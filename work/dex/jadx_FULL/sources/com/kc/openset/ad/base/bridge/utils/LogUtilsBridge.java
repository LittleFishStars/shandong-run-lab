package com.kc.openset.ad.base.bridge.utils;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class LogUtilsBridge {
    static {
        OSETSDKProtected.interface11(3790);
    }

    public static native void d(String str, String str2);

    public static native void debugD(String str, String str2);

    public static native void e(String str, String str2);

    public static native String getStackTraceString(Throwable th);

    public static native void i(String str, String str2);

    public static native void v(String str, String str2);

    public static native void w(String str, String str2);

    public static native void w(String str, String str2, Throwable th);

    public static native void writeD(String str, String str2);

    public static native void writeE(String str, String str2);

    public static native void writeI(String str, String str2);

    public static native void writeV(String str, String str2);

    public static native void writeW(String str, String str2);

    public static native void writeW(String str, String str2, Throwable th);
}
