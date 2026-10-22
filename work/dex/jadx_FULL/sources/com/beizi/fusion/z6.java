package com.beizi.fusion;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class z6 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q6 f28100a;

        /* JADX INFO: renamed from: com.beizi.fusion.z6$a$a, reason: collision with other inner class name */
        public static class C0339a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final a f28101a = new a();
        }

        private a() {
            this.f28100a = new q6();
        }

        public static a a() {
            return C0339a.f28101a;
        }

        public String b() {
            return this.f28100a.a();
        }
    }

    public static String a() {
        return Build.VERSION.RELEASE;
    }

    public static int b(Context context) {
        String strC = c(context);
        if (!TextUtils.isEmpty(strC)) {
            strC = strC.toUpperCase();
        }
        w6 w6Var = w6.COUNTRY_CHINA_TYPE;
        return w6Var.c().equals(strC) ? w6Var.b() : w6.COUNTRY_OTHER_TYPE.b();
    }

    public static String c(Context context) {
        Configuration configuration;
        Locale locale;
        if (context == null) {
            return "";
        }
        try {
            if (context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null) {
                return "";
            }
            LocaleList locales = configuration.getLocales();
            return (locales.isEmpty() || (locale = locales.get(0)) == null) ? "" : locale.getCountry();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getContentResolver() != null ? Settings.Global.getString(context.getContentResolver(), "device_name") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static int e(Context context) {
        return h(context) ? 101 : 100;
    }

    public static String f() {
        return Locale.getDefault().getLanguage();
    }

    public static String g() {
        return Build.MANUFACTURER;
    }

    public static boolean h(Context context) {
        Configuration configuration;
        if (context != null) {
            try {
                if (context.getResources() != null && (configuration = context.getResources().getConfiguration()) != null && (configuration.screenLayout & 15) >= 3) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static int i() {
        return 2;
    }

    public static String j() {
        TimeZone timeZone = TimeZone.getDefault();
        return timeZone != null ? timeZone.getDisplayName(true, 0) : "";
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static String a(Context context) {
        String simOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager != null && 5 == telephonyManager.getSimState() && (simOperator = telephonyManager.getSimOperator()) != null) {
                int iHashCode = simOperator.hashCode();
                if (iHashCode != 49679477) {
                    switch (iHashCode) {
                        case 49679470:
                            if (simOperator.equals("46000")) {
                                return "CMCC";
                            }
                            break;
                        case 49679471:
                            if (simOperator.equals("46001")) {
                                return "CUCC";
                            }
                            break;
                        case 49679472:
                            if (simOperator.equals("46002")) {
                                return "CMCC";
                            }
                            break;
                        case 49679473:
                            if (simOperator.equals("46003")) {
                                return "CTCC";
                            }
                            break;
                    }
                } else if (simOperator.equals("46007")) {
                    return "CMCC";
                }
            }
        } catch (Throwable unused) {
        }
        return RVScheduleType.UNKNOW;
    }

    public static String e() {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return "0";
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return String.valueOf(statFs.getBlockSizeLong() * statFs.getBlockCountLong());
        } catch (Throwable unused) {
            return "0";
        }
    }

    private static ActivityManager.MemoryInfo f(Context context) {
        ActivityManager activityManager;
        if (context == null || (activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)) == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static String g(Context context) {
        ActivityManager.MemoryInfo memoryInfoF = f(context);
        return memoryInfoF != null ? String.valueOf(memoryInfoF.totalMem) : "";
    }

    public static long d() {
        try {
            return Long.max(ro.a("ro.build.date.utc", -1L), Long.max(Environment.getRootDirectory().lastModified(), Build.TIME));
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String h() {
        return Build.MODEL;
    }

    public static String b() {
        return Build.BRAND;
    }

    public static String c() {
        return a.a().b();
    }
}
