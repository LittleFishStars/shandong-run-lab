package com.autonavi.aps.amapapi.utils;

import java.util.Calendar;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c {
    public static long a(long j, long j2, int i) {
        if (i <= 0) {
            return j;
        }
        try {
            return Math.abs(j - j2) > ((long) i) * 31536000000L ? a(j, j2) : j;
        } catch (Throwable unused) {
            return j;
        }
    }

    private static long b(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static long a(long j, long j2) {
        long jB = b(j2) + a(j);
        long jAbs = Math.abs(jB - j2);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(jB));
        int i = calendar.get(11);
        if (i == 23 && jAbs >= 82800000) {
            jB -= 86400000;
        }
        return (i != 0 || jAbs < 82800000) ? jB : jB + 86400000;
    }

    private static long a(long j) {
        return j - b(j);
    }
}
