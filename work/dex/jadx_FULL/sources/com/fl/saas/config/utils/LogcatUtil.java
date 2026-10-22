package com.fl.saas.config.utils;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class LogcatUtil {
    private static final String APP_TAG = "YdSdk-LogcatUtil";
    public static boolean isDebug = true;

    public static void d(String str) {
        if (isDebug()) {
            Log.d(APP_TAG, getMsgFormat(str));
        }
    }

    public static void d(String str, String str2) {
        if (!isDebug() || str == null || str.isEmpty() || str2 == null || str2.isEmpty()) {
            return;
        }
        String msgFormat = getMsgFormat(str2);
        if (msgFormat.length() > 3072) {
            while (msgFormat.length() > 3072) {
                String strSubstring = msgFormat.substring(0, 3072);
                msgFormat = msgFormat.replace(strSubstring, "");
                Log.d(str, strSubstring);
            }
        }
        Log.d(str, msgFormat);
    }

    public static void e(String str) {
        if (isDebug()) {
            Log.e(APP_TAG, getMsgFormat(str));
        }
    }

    public static void e(String str, String str2) {
        if (isDebug()) {
            Log.e(str, getMsgFormat(str2));
        }
    }

    private static String getFunctionName() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(LogcatUtil.class.getName())) {
                return "[ Thread:" + Thread.currentThread().getName() + ", at " + stackTraceElement.getClassName() + Consts.DOT + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + u15.f19942b + stackTraceElement.getLineNumber() + ") ]";
            }
        }
        return null;
    }

    private static String getMsgFormat(String str) {
        return str + " ;" + getFunctionName();
    }

    public static void i(String str) {
        if (isDebug()) {
            Log.i(APP_TAG, getMsgFormat(str));
        }
    }

    public static void i(String str, String str2) {
        if (isDebug()) {
            Log.i(str, getMsgFormat(str2));
        }
    }

    private static boolean isDebug() {
        return isDebug;
    }

    public static void v(String str) {
        if (isDebug()) {
            Log.v(APP_TAG, getMsgFormat(str));
        }
    }

    public static void v(String str, String str2) {
        if (isDebug()) {
            Log.v(str, getMsgFormat(str2));
        }
    }

    public static void w(String str) {
        if (isDebug()) {
            Log.w(APP_TAG, getMsgFormat(str));
        }
    }

    public static void w(String str, String str2) {
        if (isDebug()) {
            Log.w(str, getMsgFormat(str2));
        }
    }
}
