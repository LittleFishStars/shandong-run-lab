package com.amap.api.location;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class CoordUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f26088a = false;

    public static native int convertToGcj(double[] dArr, double[] dArr2);

    public static boolean isLoadedSo() {
        return f26088a;
    }

    public static void setLoadedSo(boolean z) {
        f26088a = z;
    }
}
