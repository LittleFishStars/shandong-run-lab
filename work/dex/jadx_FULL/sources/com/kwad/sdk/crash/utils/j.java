package com.kwad.sdk.crash.utils;

import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class j {
    public static String aU(long j) {
        String strValueOf;
        String strValueOf2;
        long j2 = j / 60000;
        long j3 = (j - (60000 * j2)) / 1000;
        if (j2 < 10) {
            strValueOf = "0" + j2;
        } else {
            strValueOf = String.valueOf(j2);
        }
        if (j3 < 10) {
            strValueOf2 = "0" + j3;
        } else {
            strValueOf2 = String.valueOf(j3);
        }
        return strValueOf + u15.f19942b + strValueOf2;
    }
}
