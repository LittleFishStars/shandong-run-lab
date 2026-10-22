package com.beizi.fusion;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class xk {
    public static String a(Context context, String str) {
        int i;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (i = packageInfo.versionCode) == 0) ? "" : String.valueOf(i);
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static String b(Context context, String str) {
        String str2;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
                if (packageInfo != null && (str2 = packageInfo.versionName) != null) {
                    return str2;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return "";
    }

    public static String c(Context context) {
        PackageManager packageManager;
        if (context == null || (packageManager = context.getPackageManager()) == null) {
            return "";
        }
        try {
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0)).toString();
        } catch (PackageManager.NameNotFoundException e) {
            om.a(e);
            return "";
        }
    }

    public static String d(Context context) {
        return e(context);
    }

    public static String e(Context context) {
        PackageInfo packageInfoA = a.a().a(context);
        return packageInfoA != null ? packageInfoA.versionName : "";
    }

    public static long b(Context context) {
        PackageInfo packageInfoA = a.a().a(context);
        if (packageInfoA != null) {
            return packageInfoA.lastUpdateTime;
        }
        return 0L;
    }

    public static long a(Context context) {
        PackageInfo packageInfoA = a.a().a(context);
        if (packageInfoA != null) {
            return packageInfoA.firstInstallTime;
        }
        return 0L;
    }

    public static boolean c(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && packageManager.getPackageInfo(str, 0) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return false;
    }

    public static class a {
        private static volatile a b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private volatile PackageInfo f28036a;

        private a() {
        }

        public static a a() {
            if (b == null) {
                synchronized (a.class) {
                    if (b == null) {
                        b = new a();
                    }
                }
            }
            return b;
        }

        public PackageInfo a(Context context) {
            if (this.f28036a == null) {
                synchronized (a.class) {
                    if (this.f28036a == null) {
                        try {
                            this.f28036a = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                        } catch (PackageManager.NameNotFoundException unused) {
                            this.f28036a = null;
                        }
                    }
                }
            }
            return this.f28036a;
        }
    }
}
