package cn.hzjizhun.admin.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.byazt.hv.TTDownloadField;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PackageUtil {
    private static String appName;
    private static String appVersion;
    private static String packageName;

    public static String getAppName(Context context) {
        if (context != null && TextUtils.isEmpty(appName)) {
            try {
                appName = String.valueOf(context.getPackageManager().getApplicationLabel(context.getApplicationInfo()));
            } catch (Throwable unused) {
            }
        }
        return appName;
    }

    public static String getAppVersion(Context context) {
        if (TextUtils.isEmpty(appVersion) && context != null) {
            try {
                appVersion = context.getPackageManager().getPackageInfo(getPackageName(context), 0).versionName;
            } catch (Throwable unused) {
            }
        }
        return appVersion;
    }

    public static String getPackageName(Context context) {
        try {
            if (TextUtils.isEmpty(packageName) && context != null) {
                packageName = context.getPackageName();
            }
        } catch (Throwable unused) {
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
        } catch (Throwable th) {
            th.printStackTrace();
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
