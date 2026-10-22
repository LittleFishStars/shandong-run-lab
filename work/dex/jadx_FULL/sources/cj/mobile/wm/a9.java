package cj.mobile.wm;

import android.annotation.TargetApi;
import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class a9 {
    public static final double dexa = 1.0d / Math.pow(10.0d, 6.0d);

    public static double dexa(long j) {
        return (dexa() - j) * dexa;
    }

    @TargetApi(17)
    public static long dexa() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
