package com.aliyun.common.d;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static float f25571a = 1.0f / 1000000;

    public static float a(long j) {
        return j * f25571a;
    }

    public static long a(float f) {
        return (long) (f / 1000.0f);
    }

    private static long a(float f, TimeUnit timeUnit) {
        return (long) (timeUnit.toMicros(1L) * f);
    }

    public static long b(float f) {
        return (long) (f * 1000.0f);
    }

    public static long c(float f) {
        return a(f, TimeUnit.SECONDS);
    }
}
