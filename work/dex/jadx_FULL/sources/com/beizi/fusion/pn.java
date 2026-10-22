package com.beizi.fusion;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.provider.Settings;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class pn {
    private static int a(Context context) {
        try {
            if (Settings.Global.getInt(context.getContentResolver(), "adb_enabled", -1) == 1) {
                return 0;
            }
            Method declaredMethod = Class.forName("com.huawei.android.os.SystemPropertiesEx").getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(null, "hw_sc.appswitch_interceptor", Boolean.FALSE)).booleanValue() ? 1 : 0;
        } catch (Throwable unused) {
            throw new IllegalArgumentException("HUAWEI: Can't check intent prompt status.");
        }
    }

    private static int b(Context context) {
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            Class cls = Integer.TYPE;
            Method declaredMethod = AppOpsManager.class.getDeclaredMethod("checkOpNoThrow", cls, cls, String.class);
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            if (applicationInfo != null) {
                return Integer.valueOf(declaredMethod.invoke(appOpsManager, 10049, Integer.valueOf(applicationInfo.uid), context.getPackageName()).toString()).intValue();
            }
            return -1;
        } catch (Throwable unused) {
            throw new IllegalArgumentException("Hyper: Can't check intent prompt status.");
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static int c(Context context) {
        try {
            String upperCase = Build.BRAND.toUpperCase();
            switch (upperCase.hashCode()) {
                case -1706170181:
                    if (upperCase.equals("XIAOMI")) {
                        return b(context);
                    }
                    return -1;
                case 2432928:
                    if (upperCase.equals("OPPO")) {
                        return e(context);
                    }
                    return -1;
                case 2634924:
                    if (upperCase.equals("VIVO")) {
                        return f(context);
                    }
                    return -1;
                case 68924490:
                    if (upperCase.equals("HONOR")) {
                        return d(context);
                    }
                    return -1;
                case 2141820391:
                    if (upperCase.equals("HUAWEI")) {
                        return a(context);
                    }
                    return -1;
                default:
                    return -1;
            }
        } catch (Throwable unused) {
        }
    }

    private static int d(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "application_auto_jump_switch", -1);
        } catch (Throwable unused) {
            throw new IllegalArgumentException("Magic: Can't check intent prompt status.");
        }
    }

    private static int e(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "app_start_confirm_rus_enable", -1);
        } catch (Throwable unused) {
            throw new IllegalArgumentException("OPPO: Can't check intent prompt status.");
        }
    }

    private static int f(Context context) {
        try {
            Intent intent = new Intent("com.vivo.appfilter.ACTION_APP_JUMP_PROMPT");
            intent.setPackage("com.vivo.appfilter");
            return !context.getPackageManager().queryIntentActivities(intent, 0).isEmpty() ? 1 : 0;
        } catch (Throwable unused) {
            throw new IllegalArgumentException("ViVO: Can't check intent prompt status.");
        }
    }
}
