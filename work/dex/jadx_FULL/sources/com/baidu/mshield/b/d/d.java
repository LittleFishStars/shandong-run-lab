package com.baidu.mshield.b.d;

import android.annotation.SuppressLint;
import android.net.TrafficStats;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d {
    @SuppressLint({"NewApi"})
    public static void a() {
        try {
            TrafficStats.clearThreadStatsTag();
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
    }

    @SuppressLint({"NewApi"})
    public static void b() {
        try {
            TrafficStats.setThreadStatsTag(155648);
        } catch (Throwable th) {
            com.baidu.mshield.b.c.a.a(th);
        }
    }
}
