package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class cw0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f41052a = b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f15895a = 1024;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static bw0 f15896a = null;
    public static final int b = 384;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final long f15897b = 1048576;

    public static bw0 a() {
        if (f15896a == null) {
            f15896a = new bw0(384, f41052a);
        }
        return f15896a;
    }

    public static int b() {
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        return ((long) iMin) > 16777216 ? (iMin / 4) * 3 : iMin / 2;
    }
}
