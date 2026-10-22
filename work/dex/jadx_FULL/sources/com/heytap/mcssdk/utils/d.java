package com.heytap.mcssdk.utils;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f32626a = "mcssdk---";
    private static String b = "MCS";
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = true;
    private static boolean f = true;
    private static boolean g = true;
    private static String h = "-->";
    private static boolean i = true;

    public static String a() {
        return b;
    }

    public static void a(Exception exc) {
        if (!g || exc == null) {
            return;
        }
        Log.e(f32626a, exc.getMessage());
    }

    public static void a(String str) {
        if (c && i) {
            Log.v(f32626a, b + h + str);
        }
    }

    public static void a(String str, String str2) {
        if (c && i) {
            Log.v(str, b + h + str2);
        }
    }

    public static void a(String str, Throwable th) {
        if (g) {
            Log.e(str, th.toString());
        }
    }

    public static void a(boolean z) {
        c = z;
    }

    public static void b(String str) {
        if (e && i) {
            Log.d(f32626a, b + h + str);
        }
    }

    public static void b(String str, String str2) {
        if (e && i) {
            Log.d(str, b + h + str2);
        }
    }

    public static void b(boolean z) {
        e = z;
    }

    public static boolean b() {
        return c;
    }

    public static void c(String str) {
        if (d && i) {
            Log.i(f32626a, b + h + str);
        }
    }

    public static void c(String str, String str2) {
        if (d && i) {
            Log.i(str, b + h + str2);
        }
    }

    public static void c(boolean z) {
        d = z;
    }

    public static boolean c() {
        return e;
    }

    public static void d(String str) {
        if (f && i) {
            Log.w(f32626a, b + h + str);
        }
    }

    public static void d(String str, String str2) {
        if (f && i) {
            Log.w(str, b + h + str2);
        }
    }

    public static void d(boolean z) {
        f = z;
    }

    public static boolean d() {
        return d;
    }

    public static void e(String str) {
        if (g && i) {
            Log.e(f32626a, b + h + str);
        }
    }

    public static void e(String str, String str2) {
        if (g && i) {
            Log.e(str, b + h + str2);
        }
    }

    public static void e(boolean z) {
        g = z;
    }

    public static boolean e() {
        return f;
    }

    public static void f(String str) {
        b = str;
    }

    public static void f(boolean z) {
        i = z;
        boolean z2 = z;
        c = z2;
        e = z2;
        d = z2;
        f = z2;
        g = z2;
    }

    public static boolean f() {
        return g;
    }

    public static void g(String str) {
        h = str;
    }

    public static boolean g() {
        return i;
    }

    public static String h() {
        return h;
    }
}
