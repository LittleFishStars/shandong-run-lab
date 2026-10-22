package com.efs.sdk.base.core.util;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class PackageUtil {
    public static String getAppVersionCode(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
        } catch (Throwable th) {
            Log.w("efs.util.pkg", "get version name error", th);
            return "unknown";
        }
    }

    public static String getAppVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            Log.w("efs.util.pkg", "get version name error", th);
            return "unknown";
        }
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }
}
