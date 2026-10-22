package com.byazt.hr;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 29, 34})
public class a {
    public static long c(long j) {
        Date date = new Date();
        Date date2 = (j >= 3600000 || date.getMinutes() <= 30) ? new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 0, 0) : new Date(date.getYear(), date.getMonth(), date.getDate(), date.getHours(), 30, 0);
        return c(date2.getTime(), j);
    }

    public static String tt(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }

    private static long c(long j, long j2) {
        Date date = new Date(j2 + j);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long time = date.getTime();
        com.byazt.eu.tt.c("TTMediationSDK_IntervalEffectiveTime", "old time " + j + " new time = " + simpleDateFormat.format(date) + " 毫秒 = " + time);
        return time;
    }
}
