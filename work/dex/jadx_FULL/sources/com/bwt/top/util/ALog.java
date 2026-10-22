package com.bwt.top.util;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ALog {
    private static String TAG = "AdSdk----";
    private static boolean isLog = false;

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

    public static void openLog() {
        isLog = true;
    }

    public static void v(String str, String str2) {
        if (isLog) {
            Log.v(TAG + str, str2);
        }
    }
}
