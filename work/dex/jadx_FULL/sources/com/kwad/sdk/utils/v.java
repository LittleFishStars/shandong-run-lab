package com.kwad.sdk.utils;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class v {
    public static int a(long j, long j2, boolean z, int i) {
        com.kwad.sdk.core.d.c.d("DownloadProgressTransformUtil", "soFarBytes:" + j + " totalBytes:" + j2 + " isShowOptimizedProgress: " + z + " optimizeMethod: " + i);
        double dO = j2 > 0 ? (j * 100.0d) / j2 : AudioStats.AUDIO_AMPLITUDE_NONE;
        if (!z) {
            return (int) dO;
        }
        if (i == 1) {
            dO = n(dO);
        } else if (i == 2) {
            dO = o(dO);
        }
        return (int) dO;
    }

    private static double n(double d) {
        if (d <= 6.0d) {
            return d * 5.0d;
        }
        if (d <= 15.0d) {
            return ((d - 6.0d) * 2.0d) + 30.0d;
        }
        if (d <= 30.0d) {
            return d + 33.0d;
        }
        if (d < 100.0d) {
            return Math.min((((d - 30.0d) * 0.37d) / 0.7d) + 63.0d, 99.0d);
        }
        return 100.0d;
    }

    private static double o(double d) {
        return Math.sqrt(d) * 10.0d;
    }
}
