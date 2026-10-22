package com.beizi.fusion;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.beizi.fusion.tool.PackageUtil;
import com.byazt.hv.TTDownloadField;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.NetworkInterface;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class so {
    public static boolean a(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || str == null || str.isEmpty()) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static long b(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return packageInfo.firstInstallTime;
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static long c(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return packageInfo.lastUpdateTime;
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static void c(String str) {
    }

    public static String d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static float e(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float f(Context context) {
        return b(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public static int g(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public static float h(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static float i(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    public static int j(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public static int k(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String l(Context context) {
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            return packageInfo != null ? packageInfo.versionName : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean m(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable unused) {
        }
    }

    public static boolean n(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
        }
    }

    public static boolean o(Context context) {
        boolean zEquals;
        boolean z;
        int iIntValue;
        try {
            Object objInvoke = ActivityManager.class.getMethod(i2.a(qg.b(), "alE/Wd6TQF6QDt5MOuPgTJhj5qydYaJMv1s3ioRo108="), null).invoke((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY), null);
            if (!(objInvoke instanceof List)) {
                return true;
            }
            String str = context.getApplicationInfo().packageName;
            Iterator it = ((List) objInvoke).iterator();
            if (!it.hasNext()) {
                return true;
            }
            Object next = it.next();
            Class<?> cls = next.getClass();
            try {
                Field declaredField = cls.getDeclaredField(i2.a(qg.b(), "HmbXL1RJ0QhOMpVM8sDB4g=="));
                declaredField.setAccessible(true);
                Object obj = declaredField.get(next);
                zEquals = obj != null ? obj.equals(str) : true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
            try {
                Field declaredField2 = cls.getDeclaredField(i2.a(qg.b(), "Qw020bKiuI4Tpk03J/klVA=="));
                declaredField2.setAccessible(true);
                Object obj2 = declaredField2.get(next);
                z = !(obj2 instanceof Integer) || (iIntValue = ((Integer) obj2).intValue()) == 100 || iIntValue == 200;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return zEquals && z;
        } catch (Throwable th3) {
            th3.printStackTrace();
            return true;
        }
    }

    public static boolean p(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
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

    public static String b() {
        if (new File("/system/bin/su").exists() && b("/system/bin/su")) {
            return "yes";
        }
        return (new File("/system/xbin/su").exists() && b("/system/xbin/su")) ? "yes" : "no";
    }

    public static boolean c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ("tun0".equals(networkInterfaceNextElement.getName()) || "ppp0".equals(networkInterfaceNextElement.getName())) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean b(String str) {
        char cCharAt;
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec("ls -l " + str);
            String line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
            if (line != null && line.length() >= 4 && ((cCharAt = line.charAt(3)) == 's' || cCharAt == 'x')) {
                processExec.destroy();
                return true;
            }
        } catch (IOException unused) {
            if (processExec == null) {
                return false;
            }
        } finally {
            if (processExec != null) {
                processExec.destroy();
            }
        }
        return false;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static int b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static Long a(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            PackageInfo packageInfo = PackageUtil.getInstance().getPackageInfo(context);
            if (packageInfo != null) {
                return Long.valueOf(packageInfo.lastUpdateTime);
            }
        } catch (Exception unused) {
        }
        return 0L;
    }
}
