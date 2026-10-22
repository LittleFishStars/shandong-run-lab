package com.huawei.secure.android.common.ssl.util;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37749a = "SecurityComp10200303: ";

    public static void a(String str, String str2) {
    }

    public static void a(String str, String str2, Throwable th) {
        Log.e(a(str), str2, th);
    }

    public static void b(String str, String str2) {
        Log.e(a(str), str2);
    }

    public static void c(String str, String str2) {
        Log.i(a(str), str2);
    }

    public static void d(String str, String str2) {
        Log.v(a(str), str2);
    }

    public static void e(String str, String str2) {
        Log.w(a(str), str2);
    }

    private static String a(String str) {
        return f37749a + str;
    }
}
