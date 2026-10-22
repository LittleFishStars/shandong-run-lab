package com.bwt.top.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import com.byazt.hv.TTDownloadField;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PackageUtil {
    private static String appVersion;
    private static String packageName;

    public static String getAppName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String getAppVersion(Context context) {
        if (appVersion == null && context != null) {
            try {
                appVersion = context.getPackageManager().getPackageInfo(getPackageName(context), 0).versionName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return appVersion;
    }

    public static String getPackageName(Context context) {
        if (packageName == null && context != null) {
            packageName = context.getPackageName();
        }
        return packageName;
    }

    public static String getProcessName(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        String str;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || runningAppProcesses.size() <= 0) {
                return null;
            }
            for (int i = 0; i < runningAppProcesses.size(); i++) {
                ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i);
                if (runningAppProcessInfo.pid == Process.myPid() && (str = runningAppProcessInfo.processName) != null) {
                    return str;
                }
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isMainProcess(Context context) {
        String packageName2 = getPackageName(context);
        return packageName2 != null && packageName2.equals(getProcessName(context));
    }

    public static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
