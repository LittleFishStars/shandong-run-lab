package com.kwad.sdk.api.loader;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
final class i {
    static String aIf = "autoRevert";

    public static boolean N(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return false;
        }
        if (!TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        String[] strArrSplit = str.split("\\.");
        String[] strArrSplit2 = str2.split("\\.");
        for (int i = 0; i < strArrSplit.length && i < strArrSplit2.length; i++) {
            try {
                int i2 = Integer.parseInt(strArrSplit[i]) - Integer.parseInt(strArrSplit2[i]);
                if (i2 > 0) {
                    return true;
                }
                if (i2 < 0) {
                    return false;
                }
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return strArrSplit.length > strArrSplit2.length;
    }

    public static String bo(Context context) {
        return getVersion(context, "curversion");
    }

    public static String bp(Context context) {
        return getVersion(context, "newversion");
    }

    public static String bq(Context context) {
        return getVersion(context, "apiversion");
    }

    private static void d(Context context, String str, String str2) {
        b.c(context, str, str2);
    }

    private static String getVersion(Context context, String str) {
        return b.b(context, str, "");
    }

    public static void s(Context context, String str) {
        d(context, "curversion", str);
    }

    public static void t(Context context, String str) {
        d(context, "newversion", str);
    }

    public static void u(Context context, String str) {
        d(context, "apiversion", str);
    }
}
