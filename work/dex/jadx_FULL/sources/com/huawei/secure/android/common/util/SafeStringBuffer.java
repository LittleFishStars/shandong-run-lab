package com.huawei.secure.android.common.util;

import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SafeStringBuffer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f37762a = "SafeStringBuffer";
    private static final String b = "";

    public static String substring(StringBuffer stringBuffer, int i) {
        if (stringBuffer != null && stringBuffer.length() >= i && i >= 0) {
            try {
                return stringBuffer.substring(i);
            } catch (Exception e) {
                Log.e(f37762a, "substring exception: " + e.getMessage());
            }
        }
        return "";
    }

    public static String substring(StringBuffer stringBuffer, int i, int i2) {
        if (stringBuffer != null && i >= 0 && i2 <= stringBuffer.length() && i2 >= i) {
            try {
                return stringBuffer.substring(i, i2);
            } catch (Exception e) {
                Log.e(f37762a, "substring: " + e.getMessage());
            }
        }
        return "";
    }
}
