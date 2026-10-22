package com.byazt.pct;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 124, 42})
public final class i {
    public static boolean c;

    public static void c(boolean z) {
        c = z;
    }

    public static void tt(String str) {
        if (c) {
            com.byazt.nr.m.tt("JsBridge2", str);
        }
    }

    public static void c(String str) {
        if (c) {
            com.byazt.nr.m.c("JsBridge2", str);
        }
    }

    public static void tt(String str, Throwable th) {
        if (c) {
            com.byazt.nr.m.ve("JsBridge2", str, th);
            com.byazt.nr.m.uj("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void c(String str, Throwable th) {
        if (c) {
            com.byazt.nr.m.tt("JsBridge2", str, th);
            com.byazt.nr.m.tt("JsBridge2", "Stacktrace: " + Log.getStackTraceString(th));
        }
    }

    public static void c(RuntimeException runtimeException) {
        if (c) {
            throw runtimeException;
        }
    }
}
