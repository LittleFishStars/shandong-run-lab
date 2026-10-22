package com.kc.openset.plugin.opt;

import android.content.Context;
import android.text.TextUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class NexusSdk {
    private static boolean isInit = false;

    static {
        try {
            if (graterThanV25()) {
                System.loadLibrary("nexus-kit");
                isInit = true;
            } else {
                isInit = false;
            }
        } catch (Throwable unused) {
            isInit = false;
        }
    }

    public static String activateRealSession(Context context, String str, String str2) {
        try {
            return !isInit ? "" : activateSession(context, str, str2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static native String activateSession(Context context, String str, String str2) throws Throwable;

    public static String buildRealSessionId(Context context, String str, String str2) {
        try {
            return !isInit ? "" : buildSessionId(context, str, "", str2);
        } catch (Throwable unused) {
            return "";
        }
    }

    private static native String buildSessionId(Context context, String str, String str2, String str3) throws Throwable;

    public static boolean checkActivateResult(String str) {
        return "AS_200".equals(str);
    }

    public static boolean checkSessionId(String str) {
        return (TextUtils.isEmpty(str) || str.startsWith("BSI_")) ? false : true;
    }

    public static String getRealVersion() {
        try {
            return !isInit ? "" : getVersion();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static native String getVersion();

    private static boolean graterThanV25() {
        return true;
    }
}
