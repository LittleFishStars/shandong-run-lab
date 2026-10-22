package com.aliyun.common;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlivcBase {
    static {
        try {
            System.loadLibrary("all_in_one");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static native void nativeSetEnabledStat(boolean z);

    private static native void nativeSetIntegrationWay(String str);

    public static void setEnabledStat(boolean z) {
        nativeSetEnabledStat(z);
    }

    public static void setIntegrationWay(String str) {
        nativeSetIntegrationWay(str);
    }
}
