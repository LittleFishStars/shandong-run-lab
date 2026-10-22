package com.zj.adlib;

import com.airbnb.lottie.LottieLogger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class g25 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static LottieLogger f41803a = new d25();

    public static void a(String str) {
        f41803a.debug(str);
    }

    public static void b(String str, Throwable th) {
        f41803a.debug(str, th);
    }

    public static void c(String str, Throwable th) {
        f41803a.error(str, th);
    }

    public static void d(LottieLogger lottieLogger) {
        f41803a = lottieLogger;
    }

    public static void e(String str) {
        f41803a.a(str);
    }

    public static void f(String str, Throwable th) {
        f41803a.b(str, th);
    }
}
