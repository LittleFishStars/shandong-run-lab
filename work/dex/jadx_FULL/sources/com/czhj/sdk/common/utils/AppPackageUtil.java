package com.czhj.sdk.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.czhj.sdk.logger.SigmobLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class AppPackageUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f29430a;
    private static String b;
    private static PackageInfo c;
    private static String d;
    private static int e;
    private static int f;

    public static String getAppName(Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        try {
            if (context.getApplicationInfo() != null) {
                d = context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return d;
    }

    public static String getAppPackageName(Context context) {
        if (context == null) {
            return null;
        }
        if (!TextUtils.isEmpty(f29430a)) {
            return f29430a;
        }
        String packageName = context.getPackageName();
        f29430a = packageName;
        return packageName;
    }

    public static String getAppVersionFromContext(Context context) {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            PackageInfo packageInfo = getPackageInfo(context);
            if (packageInfo != null) {
                b = packageInfo.versionName;
            }
            return b;
        } catch (Throwable unused) {
            SigmobLog.d("Failed to retrieve PackageInfo#versionName.");
            return null;
        }
    }

    public static int getHWID(Context context) {
        int i = e;
        if (i != 0) {
            return i;
        }
        if (RomUtils.isHuawei()) {
            try {
                e = getPackageVersionCode(context, "com.huawei.hwid");
            } catch (Throwable unused) {
            }
        } else {
            e = -1;
        }
        return e;
    }

    public static int getOsMarket(Context context) {
        int packageVersionCode;
        int i = f;
        if (i != 0) {
            return i;
        }
        RomUtils.RomInfo romInfo = RomUtils.getRomInfo();
        if (romInfo != null) {
            String osMarket = romInfo.getOsMarket();
            if (!TextUtils.isEmpty(osMarket) && (packageVersionCode = getPackageVersionCode(context, osMarket)) != -1) {
                f = packageVersionCode;
            }
        }
        return f;
    }

    public static PackageInfo getPackageInfo(Context context) {
        if (c == null) {
            PackageManager packageManager = getPackageManager(context);
            String appPackageName = getAppPackageName(context);
            if (packageManager == null || appPackageName == null) {
                return null;
            }
            try {
                c = packageManager.getPackageInfo(appPackageName, 0);
            } catch (Throwable unused) {
            }
        }
        return c;
    }

    public static PackageManager getPackageManager(Context context) {
        if (context == null) {
            return null;
        }
        return context.getPackageManager();
    }

    public static int getPackageVersionCode(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return -1;
            }
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return -1;
        }
    }
}
