package com.alibaba.alibclinkpartner.smartlink.util;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ALSLLogUtil {
    public static boolean isLog = false;

    public static void d(String str, String str2, String str3) {
        if (isLog) {
            Log.i("alsl", "class = " + str + " === method: " + str2 + "\ndebugMsg = " + str3);
        }
    }

    public static void e(String str, String str2, String str3) {
        if (isLog) {
            Log.e("alsl", "class = " + str + " === method: " + str2 + "\nerrMsg = " + str3);
        }
    }

    public static void i(String str, String str2, String str3) {
        if (isLog) {
            Log.i("alsl", "class = " + str + " === method: " + str2 + "\ninfoMsg = " + str3);
        }
    }
}
