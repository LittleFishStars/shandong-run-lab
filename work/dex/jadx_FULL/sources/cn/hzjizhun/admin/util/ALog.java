package cn.hzjizhun.admin.util;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ALog {
    private static String TAG = "JZAdSdk----";
    public static final String TAG_INIT = "init===";
    public static boolean isLog = false;

    public static void d(String str, String str2) {
        if (isLog) {
            Log.d(TAG + str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (isLog) {
            Log.e(TAG + str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (isLog) {
            Log.i(TAG + str, str2);
        }
    }

    public static void innerD(String str, String str2) {
    }

    public static void innerE(String str, String str2) {
    }

    public static void openLog() {
        isLog = true;
    }

    public static void v(String str, String str2) {
        if (isLog) {
            Log.v(TAG + str, str2);
        }
    }

    public static void d(String str) {
        d("", str);
    }

    public static void e(String str) {
        if (isLog) {
            Log.e(TAG, str);
        }
    }
}
