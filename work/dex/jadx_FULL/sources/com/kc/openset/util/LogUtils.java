package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class LogUtils {
    static {
        OSETSDKProtected.interface11(4938);
    }

    public static native void d(String str, String str2);

    public static native void debugD(String str, String str2);

    public static native void e(String str, String str2);

    public static native String getStackTraceString(Throwable th);

    public static native void i(String str, String str2);

    public static native void init();

    public static native void sentInit();

    public static native void setIsApkDebug(boolean z);

    public static native void v(String str, String str2);

    public static native void w(String str, String str2);

    public static native void w(String str, String str2, Throwable th);

    public static native void writeD(String str, String str2);

    public static native void writeE(String str, String str2);

    public static native void writeE(String str, Throwable th);

    public static native void writeI(String str, String str2);

    public static native void writeV(String str, String str2);

    public static native void writeW(String str, String str2);

    public static native void writeW(String str, String str2, Throwable th);
}
