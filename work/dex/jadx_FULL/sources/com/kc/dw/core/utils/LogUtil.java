package com.kc.dw.core.utils;

import android.util.Log;
import com.ali.auth.third.login.LoginConstants;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class LogUtil {
    public static final String TAG = "SSDSdk";

    public static void d(String str, String str2) {
        if (com.kc.dw.base.a.adConfig() != null && com.kc.dw.base.a.adConfig().enableDebug()) {
            Log.d(getTag(str), "" + str2);
        }
    }

    public static void dev(String str, String str2) {
    }

    public static void dev(String str, Throwable th) {
    }

    public static void e(String str, String str2) {
        Log.e(getTag(str), "" + str2);
    }

    public static void e(String str, String str2, Throwable th) {
        Log.e(getTag(str), "" + str2, th);
    }

    public static String getTag(String str) {
        StringBuffer stringBuffer = new StringBuffer(TAG);
        stringBuffer.append(LoginConstants.UNDER_LINE);
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static void i(String str, String str2) {
        if (com.kc.dw.base.a.adConfig() != null && com.kc.dw.base.a.adConfig().enableDebug()) {
            Log.i(getTag(str), "" + str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (com.kc.dw.base.a.adConfig() != null && com.kc.dw.base.a.adConfig().enableDebug()) {
            Log.i(getTag(str), "" + str2, th);
        }
    }

    public static void w(String str, String str2) {
        Log.w(getTag(str), "" + str2);
    }
}
