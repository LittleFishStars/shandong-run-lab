package com.baidu.lbsapi.auth;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f26304a = false;
    private static String b = "BaiduApiAuth";

    public static String a() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return stackTraceElement.getFileName() + "[" + stackTraceElement.getLineNumber() + "]";
    }

    public static void a(String str) {
        if (!f26304a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.d(b, a() + com.alipay.sdk.m.y.l.b + str);
    }

    public static void b(String str) {
        if (Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.i(b, str);
    }

    public static void c(String str) {
        if (!f26304a || Thread.currentThread().getStackTrace().length == 0) {
            return;
        }
        Log.e(b, a() + com.alipay.sdk.m.y.l.b + str);
    }
}
