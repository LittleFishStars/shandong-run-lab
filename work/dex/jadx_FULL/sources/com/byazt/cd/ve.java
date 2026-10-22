package com.byazt.cd;

import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 43, 54})
public final class ve {
    public static float c(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (Throwable th) {
            m.c(th);
            return f;
        }
    }

    public static int c(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return (int) Float.parseFloat(str);
        } catch (Throwable th) {
            m.c(th);
            return i;
        }
    }

    public static long c(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (Throwable th) {
            m.c(th);
            return j;
        }
    }

    public static double c(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (Throwable th) {
            m.c(th);
            return d;
        }
    }

    public static boolean c(String str, boolean z) {
        if (str == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(str);
        } catch (Throwable th) {
            m.c(th);
            return z;
        }
    }
}
