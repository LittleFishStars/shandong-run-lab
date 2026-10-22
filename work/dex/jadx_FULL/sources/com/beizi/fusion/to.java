package com.beizi.fusion;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import com.beizi.fusion.tool.PackageUtil;
import com.byazt.hv.TTDownloadField;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class to {
    public static String a(Context context, String str) {
        try {
            int i = context.getPackageManager().getPackageInfo(str, 0).versionCode;
            return i != 0 ? String.valueOf(i) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().widthPixels);
    }

    public static String d(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager != null ? String.valueOf(packageManager.getPackageInfo("com.huawei.appmarket", 0).versionCode) : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static long e(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
            return 0L;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static String f(Context context) {
        return context.getResources().getConfiguration().orientation == 2 ? "2" : "1";
    }

    public static int g(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int h(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int i(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int j(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (int) ((f2 / f) + 0.5f);
    }

    public static String k(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem + "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String c() {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return "";
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            return (statFs.getBlockCount() * blockSize) + "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    private static boolean a(String str) {
        char cCharAt;
        Process processExec = null;
        try {
            try {
                processExec = Runtime.getRuntime().exec("ls -l " + str);
                String line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
                if (line != null && line.length() >= 4 && ((cCharAt = line.charAt(3)) == 's' || cCharAt == 'x')) {
                    processExec.destroy();
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
                if (processExec == null) {
                    return false;
                }
            }
            processExec.destroy();
            return false;
        } catch (Throwable th) {
            if (processExec != null) {
                processExec.destroy();
            }
            throw th;
        }
    }

    public static String b(Context context) {
        return String.valueOf(context.getResources().getDisplayMetrics().heightPixels);
    }

    public static String b() {
        if (new File("/system/bin/su").exists() && a("/system/bin/su")) {
            return "yes";
        }
        return (new File("/system/xbin/su").exists() && a("/system/xbin/su")) ? "yes" : "no";
    }

    public static long a() {
        Long lValueOf = 0L;
        switch (Calendar.getInstance().get(7)) {
            case 1:
            case 2:
            case 4:
            case 6:
                lValueOf = Long.valueOf(System.currentTimeMillis() / 1000);
                break;
            case 3:
            case 5:
            case 7:
                lValueOf = Long.valueOf(System.currentTimeMillis());
                break;
        }
        return lValueOf.longValue();
    }

    public static String a(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        return string != null ? string : "";
    }
}
