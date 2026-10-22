package com.ipd.dsp.internal.c2;

import android.annotation.SuppressLint;
import android.util.Log;
import com.ipd.dsp.Dsp;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38227a = Dsp.class.getSimpleName();

    public static void a(String str, String str2) {
        a("d", str, str2);
    }

    public static void b(String str, String str2) {
        a("e", str, str2);
    }

    public static void c(String str, String str2, Throwable th) {
        a("i", str, str2, th);
    }

    public static void d(String str, String str2, Throwable th) {
        a("v", str, str2, th);
    }

    public static void e(String str, String str2) {
        a("v", str, str2);
    }

    public static void f(String str, String str2) {
        a("w", str, str2);
    }

    public static void a(String str, String str2, Throwable th) {
        a("d", str, str2, th);
    }

    public static void b(String str, String str2, Throwable th) {
        a("e", str, str2, th);
    }

    public static String c(String str, String str2) {
        return "[" + str + "]:" + str2;
    }

    public static void d(String str, String str2) {
        a("i", str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        a("w", str, str2, th);
    }

    public static void a(String str, Throwable th) {
        a("w", str, null, th);
    }

    @SuppressLint({"PrivateApi"})
    public static void a(String str, String str2, String str3) {
        try {
            Class.forName("android.util.Log").getDeclaredMethod(str, String.class, String.class).invoke(null, f38227a, c(str2, str3));
        } catch (Throwable th) {
            Log.w("Dsp", th);
        }
    }

    @SuppressLint({"PrivateApi"})
    public static void a(String str, String str2, String str3, Throwable th) {
        try {
            Class.forName("android.util.Log").getDeclaredMethod(str, String.class, String.class, Throwable.class).invoke(null, f38227a, c(str2, str3), th);
        } catch (Throwable unused) {
            Log.w("Dsp", th);
        }
    }
}
