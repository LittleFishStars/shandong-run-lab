package com.efs.sdk.memleaksdk.monitor.shark;

import android.app.Application;
import android.content.SharedPreferences;
import com.ali.auth.third.login.LoginConstants;
import com.efs.sdk.memleaksdk.monitor.UMonitor;
import com.google.android.exoplayer2.extractor.flv.c;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static SharedPreferences f29874a;
    private static String b;

    public static void a(Application application) {
        f29874a = application.getSharedPreferences("u_monitor", 0);
        b = UMUtils.getAppVersionName(UMonitor.getContext()) + LoginConstants.UNDER_LINE;
    }

    public static void b() {
        SharedPreferences sharedPreferences = f29874a;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putInt(b + c.f2766e, sharedPreferences.getInt(b + c.f2766e, 0) + 1).apply();
    }

    public static long c() {
        SharedPreferences sharedPreferences = f29874a;
        if (sharedPreferences == null) {
            return 0L;
        }
        long j = sharedPreferences.getLong(b + "first_analysis_time", 0L);
        if (j != 0) {
            return j;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        a(jCurrentTimeMillis);
        return jCurrentTimeMillis;
    }

    public static int a() {
        SharedPreferences sharedPreferences = f29874a;
        if (sharedPreferences == null) {
            return 0;
        }
        return sharedPreferences.getInt(b + c.f2766e, 0);
    }

    public static void a(long j) {
        SharedPreferences sharedPreferences = f29874a;
        if (sharedPreferences == null) {
            return;
        }
        if (sharedPreferences.contains(b + "first_analysis_time")) {
            return;
        }
        sharedPreferences.edit().putLong(b + "first_analysis_time", j).apply();
    }
}
