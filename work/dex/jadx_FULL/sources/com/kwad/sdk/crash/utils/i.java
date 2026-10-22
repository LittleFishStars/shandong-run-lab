package com.kwad.sdk.crash.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class i {
    private static SimpleDateFormat bgs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String aT(long j) {
        return j <= 0 ? "unknown" : bgs.format(new Date(j));
    }
}
