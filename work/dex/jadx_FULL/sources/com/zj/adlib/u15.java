package com.zj.adlib;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
public class u15 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f45046a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f19940a = "ZXingLite";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f19941a = true;
    public static final int b = 1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f19942b = ":";
    public static final int c = 2;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final String f19943c = "|";
    public static final int d = 3;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f19944d = "%s.%s(L:%d)";
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;

    public u15() {
        throw new AssertionError();
    }

    public static void A(String str, Throwable th) {
        if (!f19941a || f45046a > 5) {
            return;
        }
        Log.w(h(), String.valueOf(str), th);
    }

    public static void B(Throwable th) {
        if (!f19941a || f45046a > 5) {
            return;
        }
        Log.w(h(), k(th));
    }

    public static void C(String str) {
        if (!f19941a || f45046a > 7) {
            return;
        }
        Log.wtf(h(), String.valueOf(str));
    }

    public static void D(String str, Throwable th) {
        if (!f19941a || f45046a > 7) {
            return;
        }
        Log.wtf(h(), String.valueOf(str), th);
    }

    public static void E(Throwable th) {
        if (!f19941a || f45046a > 7) {
            return;
        }
        Log.wtf(h(), k(th));
    }

    public static void a(String str) {
        if (!f19941a || f45046a > 3) {
            return;
        }
        Log.d(h(), String.valueOf(str));
    }

    public static void b(String str, Throwable th) {
        if (!f19941a || f45046a > 3) {
            return;
        }
        Log.d(h(), String.valueOf(str), th);
    }

    public static void c(Throwable th) {
        if (!f19941a || f45046a > 3) {
            return;
        }
        Log.d(h(), k(th));
    }

    public static void d(String str) {
        if (!f19941a || f45046a > 6) {
            return;
        }
        Log.e(h(), String.valueOf(str));
    }

    public static void e(String str, Throwable th) {
        if (!f19941a || f45046a > 6) {
            return;
        }
        Log.e(h(), String.valueOf(str), th);
    }

    public static void f(Throwable th) {
        if (!f19941a || f45046a > 6) {
            return;
        }
        Log.e(h(), k(th));
    }

    public static String g(StackTraceElement stackTraceElement) {
        String className = stackTraceElement.getClassName();
        return f19940a + "|" + String.format(f19944d, className.substring(className.lastIndexOf(Consts.DOT) + 1), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber()));
    }

    public static String h() {
        return g(j(5));
    }

    public static int i() {
        return f45046a;
    }

    public static StackTraceElement j(int i) {
        return Thread.currentThread().getStackTrace()[i];
    }

    public static String k(Throwable th) {
        return Log.getStackTraceString(th);
    }

    public static void l(String str) {
        if (!f19941a || f45046a > 4) {
            return;
        }
        Log.i(h(), String.valueOf(str));
    }

    public static void m(String str, Throwable th) {
        if (!f19941a || f45046a > 4) {
            return;
        }
        Log.i(h(), String.valueOf(str), th);
    }

    public static void n(Throwable th) {
        if (!f19941a || f45046a > 4) {
            return;
        }
        Log.i(h(), k(th));
    }

    public static boolean o() {
        return f19941a;
    }

    public static void p(Object obj) {
        if (!f19941a || f45046a > 1) {
            return;
        }
        System.out.print(obj);
    }

    public static void q(String str) {
        if (!f19941a || f45046a > 1) {
            return;
        }
        System.out.print(str);
    }

    public static void r(String str) {
        if (!f19941a || f45046a > 1) {
            return;
        }
        System.out.printf(str, new Object[0]);
    }

    public static void s(Object obj) {
        if (!f19941a || f45046a > 1) {
            return;
        }
        System.out.println(obj);
    }

    public static void t(String str) {
        if (!f19941a || f45046a > 1) {
            return;
        }
        System.out.println(str);
    }

    public static void u(int i) {
        f45046a = i;
    }

    public static void v(boolean z) {
        f19941a = z;
    }

    public static void w(String str) {
        if (!f19941a || f45046a > 2) {
            return;
        }
        Log.v(h(), String.valueOf(str));
    }

    public static void x(String str, Throwable th) {
        if (!f19941a || f45046a > 2) {
            return;
        }
        Log.v(h(), String.valueOf(str), th);
    }

    public static void y(Throwable th) {
        if (!f19941a || f45046a > 2) {
            return;
        }
        Log.v(h(), k(th));
    }

    public static void z(String str) {
        if (!f19941a || f45046a > 5) {
            return;
        }
        Log.w(h(), String.valueOf(str));
    }
}
