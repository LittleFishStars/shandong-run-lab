package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class si0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f44695a;

    public static boolean a() {
        if (System.currentTimeMillis() - f44695a <= 400) {
            return true;
        }
        f44695a = System.currentTimeMillis();
        return false;
    }

    public static boolean b() {
        return !a();
    }
}
