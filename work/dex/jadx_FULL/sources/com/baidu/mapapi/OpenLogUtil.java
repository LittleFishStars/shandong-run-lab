package com.baidu.mapapi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class OpenLogUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ModuleName f26481a = null;
    private static boolean b = true;
    private static boolean c = false;
    private static String d;

    public static String getMapLogFilePath() {
        return d;
    }

    public static boolean isMapLogEnable() {
        return c;
    }

    public static boolean isNativeLogAnalysisEnable() {
        return b;
    }

    public static void setMapLogEnable(boolean z) {
        c = z;
    }

    public static void setMapLogFilePath(String str) {
        d = str;
    }

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        f26481a = moduleName;
        com.baidu.mapsdkplatform.comjni.tools.a.a(z, moduleName.ordinal());
    }

    public static void setNativeLogAnalysisEnable(boolean z) {
        b = z;
    }
}
