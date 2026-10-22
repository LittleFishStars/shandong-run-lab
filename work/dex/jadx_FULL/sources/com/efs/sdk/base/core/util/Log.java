package com.efs.sdk.base.core.util;

import com.efs.sdk.base.core.controller.ControllerCenter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Log {
    public static void d(String str) {
        d("efs.base", str, null);
    }

    public static void e(String str) {
        e("efs.base", str, null);
    }

    public static void i(String str) {
        i("efs.base", str, null);
    }

    public static void v(String str) {
        v("efs.base", str, null);
    }

    public static void w(String str) {
        w("efs.base", str, null);
    }

    public static void d(String str, String str2) {
        d(str, str2, null);
    }

    public static void e(String str, String str2) {
        e(str, str2, null);
    }

    public static void i(String str, String str2) {
        i(str, str2, null);
    }

    public static void v(String str, String str2) {
        v(str, str2, null);
    }

    public static void w(String str, String str2) {
        w(str, str2, null);
    }

    public static void d(String str, Throwable th) {
        d("efs.base", str, th);
    }

    public static void e(String str, Throwable th) {
        e("efs.base", str, th);
    }

    public static void i(String str, Throwable th) {
        i("efs.base", str, th);
    }

    public static void v(String str, Throwable th) {
        v("efs.base", str, th);
    }

    public static void w(String str, Throwable th) {
        w("efs.base", str, th);
    }

    public static void d(String str, String str2, Throwable th) {
        if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
            if (th == null) {
                android.util.Log.d(str, str2);
            } else {
                android.util.Log.d(str, str2, th);
            }
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
            if (th == null) {
                android.util.Log.e(str, str2);
            } else {
                android.util.Log.e(str, str2, th);
            }
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
            if (th == null) {
                android.util.Log.i(str, str2);
            } else {
                android.util.Log.i(str, str2, th);
            }
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
            if (th == null) {
                android.util.Log.v(str, str2);
            } else {
                android.util.Log.v(str, str2, th);
            }
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (ControllerCenter.getGlobalEnvStruct().isDebug()) {
            if (th == null) {
                android.util.Log.w(str, str2);
            } else {
                android.util.Log.w(str, str2, th);
            }
        }
    }
}
