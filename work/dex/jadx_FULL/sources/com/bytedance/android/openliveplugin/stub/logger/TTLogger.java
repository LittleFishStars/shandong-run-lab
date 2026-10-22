package com.bytedance.android.openliveplugin.stub.logger;

import com.alibaba.android.arouter.utils.Consts;
import com.byazt.bog.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class TTLogger {
    private static boolean DEBUG = false;
    private static final String TAG = "TTLiveLogger";
    private static int sLevel = 4;

    public static void d(String str) {
        if (DEBUG) {
            d(TAG, str);
        }
    }

    public static void d(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 3) {
            a.tt(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (!(str2 == null && th == null) && sLevel <= 3) {
                a.tt(str, str2, th);
            }
        }
    }

    public static void d(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 3) {
            a.tt(str, formatMsgs(objArr));
        }
    }

    public static boolean debug() {
        return sLevel <= 3;
    }

    public static void e(String str) {
        if (DEBUG) {
            e(TAG, str);
        }
    }

    public static void e(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 6) {
            a.n(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (!(str2 == null && th == null) && sLevel <= 6) {
                a.n(str, str2, th);
            }
        }
    }

    public static void e(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 6) {
            a.c(str, formatMsgs(objArr));
        }
    }

    private static String formatMsgs(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            Object obj = objArr[i];
            sb.append(obj != null ? obj.toString() : " null ");
            sb.append(" ");
        }
        return sb.toString();
    }

    public static int getLogLevel() {
        return sLevel;
    }

    private static String getSimpleClassName(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf < 0 ? str : str.substring(iLastIndexOf + 1);
    }

    public static void i(String str) {
        if (DEBUG) {
            i(TAG, str);
        }
    }

    public static void i(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 4) {
            a.ve(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (!(str2 == null && th == null) && sLevel <= 4) {
                a.ve(str, str2, th);
            }
        }
    }

    public static void i(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 4) {
            a.c(str, formatMsgs(objArr));
        }
    }

    public static boolean isDebug() {
        return DEBUG;
    }

    public static void logDirect(String str, String str2) {
        if (str2 == null) {
            return;
        }
        if (str == null) {
            str = TAG;
        }
        a.ve(str, str2);
    }

    public static void openDebugMode() {
        DEBUG = true;
        setLogLevel(3);
    }

    public static void setLogLevel(int i) {
        sLevel = i;
    }

    public static void st(String str, int i) {
        try {
            throw new Exception();
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 1; i2 < Math.min(i, stackTrace.length); i2++) {
                if (i2 > 1) {
                    sb.append("\n");
                }
                sb.append(getSimpleClassName(stackTrace[i2].getClassName()));
                sb.append(Consts.DOT);
                sb.append(stackTrace[i2].getMethodName());
            }
            v(str, sb.toString());
        }
    }

    public static void v(String str) {
        v(TAG, str);
    }

    public static void v(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 2) {
            a.c(str, str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (!(str2 == null && th == null) && sLevel <= 2) {
                a.c(str, str2, th);
            }
        }
    }

    public static void v(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 2) {
            a.c(str, formatMsgs(objArr));
        }
    }

    public static void w(String str) {
        if (DEBUG) {
            w(TAG, str);
        }
    }

    public static void w(String str, String str2) {
        if (DEBUG && str2 != null && sLevel <= 5) {
            a.uj(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (DEBUG) {
            if (!(str2 == null && th == null) && sLevel <= 5) {
                a.uj(str, str2, th);
            }
        }
    }

    public static void w(String str, Object... objArr) {
        if (DEBUG && objArr != null && sLevel <= 5) {
            a.c(str, formatMsgs(objArr));
        }
    }
}
