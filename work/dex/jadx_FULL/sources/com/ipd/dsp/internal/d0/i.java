package com.ipd.dsp.internal.d0;

import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f38277a = 1.0d / Math.pow(10.0d, 6.0d);

    public static long a() {
        return SystemClock.elapsedRealtimeNanos();
    }

    public static double a(long j) {
        return (a() - j) * f38277a;
    }
}
