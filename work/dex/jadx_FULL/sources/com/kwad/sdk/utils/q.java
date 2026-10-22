package com.kwad.sdk.utils;

import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class q {
    public static long boL;
    public static long sLaunchTime;

    public static long UD() {
        return boL - sLaunchTime;
    }

    public static String a(StackTraceElement stackTraceElement) {
        return stackTraceElement.getClassName() + Consts.DOT + stackTraceElement.getMethodName();
    }

    public static void setInitStartTime(long j) {
        boL = j;
    }

    public static void setLaunchTime(long j) {
        sLaunchTime = j;
    }
}
