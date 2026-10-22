package com.kc.cw.ad.d.b;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import com.byazt.hv.TTDownloadField;
import com.kc.cw.ad.internal.c.o;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.utils.OctUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static List<String> f38809a;

    public static long a() {
        try {
            ActivityManager activityManager = (ActivityManager) q.a().l().getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 500000000L;
        }
    }

    public static long a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return 0L;
        }
    }

    public static String a(Context context, String str) {
        try {
            PackageInfo packageInfoB = b(context, str);
            if (packageInfoB == null) {
                return null;
            }
            return String.valueOf(packageInfoB.versionCode);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static void a(Context context, boolean z) {
        try {
            if (f38809a == null) {
                f38809a = new ArrayList();
                if (context == null) {
                    return;
                }
                if (!z) {
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");
                    Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 0).iterator();
                    while (it.hasNext()) {
                        f38809a.add(it.next().activityInfo.packageName);
                    }
                    return;
                }
                String strA = OctUtil.a().a(context, 1002);
                if (TextUtils.isEmpty(strA)) {
                    return;
                }
                try {
                    JSONArray jSONArray = new JSONArray(new String(a(Base64.decode(strA, 0), "Ots0kza9lq")));
                    for (int i = 0; i < jSONArray.length(); i++) {
                        f38809a.add(jSONArray.getString(i));
                    }
                } catch (Exception e) {
                    f.a("OctopusAd", "An Exception Caught", e);
                }
            }
        } catch (Throwable th) {
            f.a("OctopusAd", "An Exception Caught", th);
        }
    }

    public static boolean a(Context context, String str, boolean z) {
        List<String> list;
        a(context, z);
        if (TextUtils.isEmpty(str) || (list = f38809a) == null) {
            return false;
        }
        return list.contains(str);
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File("data/data/" + str).exists();
    }

    public static byte[] a(byte[] bArr, String str) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = (byte) (bArr[i] ^ str.charAt(i % str.length()));
        }
        return bArr2;
    }

    public static PackageInfo b(Context context, String str) {
        if (TextUtils.isEmpty(str) || context == null) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                return packageManager.getPackageInfo(str, 128);
            }
            return null;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return null;
        }
    }

    public static String b() {
        if (new File("/system/bin/su").exists() && c("/system/bin/su")) {
            return "yes";
        }
        return (new File("/system/xbin/su").exists() && c("/system/xbin/su")) ? "yes" : "no";
    }

    public static String b(Context context) {
        String strB = o.b(context, "codeList");
        return strB == null ? "" : strB;
    }

    public static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static long c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            return 0L;
        }
    }

    public static String c() {
        try {
            if (!Environment.getExternalStorageState().equals("mounted")) {
                return null;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            return (statFs.getBlockCount() * blockSize) + "";
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
            return null;
        }
    }

    public static boolean c(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (context == null || str == null || str.isEmpty()) {
            return false;
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            applicationInfo = null;
        }
        return applicationInfo != null;
    }

    private static boolean c(String str) {
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
            } catch (Exception e) {
                f.a("OctopusAd", "An Exception Caught", e);
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

    public static long d() {
        return System.currentTimeMillis() / 1000;
    }

    public static String d(Context context) {
        return context.getPackageName();
    }

    public static boolean d(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        List<String> list = f38809a;
        if (list != null && !list.isEmpty()) {
            return f38809a.contains(str);
        }
        if (a(str)) {
            return true;
        }
        return c(context, str);
    }

    public static String e() {
        if (!f()) {
            return null;
        }
        return h() + i();
    }

    public static String e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String f(Context context) {
        String strB = o.b(context, "__GROUPVERSION__");
        return strB == null ? "" : strB;
    }

    public static boolean f() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("bbk") || str.toLowerCase().startsWith("vivo");
    }

    public static int g(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean g() {
        String str;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if ("tun0".equals(networkInterfaceNextElement.getName()) || "ppp0".equals(networkInterfaceNextElement.getName())) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e = e;
            str = "An Exception Caught";
            f.a("OctopusAd", str, e);
            return false;
        } catch (Throwable th) {
            e = th;
            str = "A Throwable Caught";
            f.a("OctopusAd", str, e);
            return false;
        }
    }

    private static String h() throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.vivo.os.name").getInputStream()), 1024);
            try {
                String line = bufferedReader2.readLine();
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (Exception e) {
                    f.a("OctopusAd", "An Exception Caught", e);
                }
                return line;
            } catch (Exception unused) {
                bufferedReader = bufferedReader2;
                if (bufferedReader == null) {
                    return "";
                }
                try {
                    bufferedReader.close();
                    return "";
                } catch (Exception e2) {
                    f.a("OctopusAd", "An Exception Caught", e2);
                    return "";
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                        f.a("OctopusAd", "An Exception Caught", e3);
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String h(Context context) {
        String str;
        try {
            str = (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
            str = "";
        }
        return TextUtils.isEmpty(str) ? d(context) : str;
    }

    private static String i() throws Throwable {
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ro.vivo.os.version").getInputStream()), 1024);
            try {
                String line = bufferedReader2.readLine();
                bufferedReader2.close();
                try {
                    bufferedReader2.close();
                } catch (Exception e) {
                    f.a("OctopusAd", "An Exception Caught", e);
                }
                return line;
            } catch (Exception unused) {
                bufferedReader = bufferedReader2;
                if (bufferedReader == null) {
                    return "";
                }
                try {
                    bufferedReader.close();
                    return "";
                } catch (Exception e2) {
                    f.a("OctopusAd", "An Exception Caught", e2);
                    return "";
                }
            } catch (Throwable th) {
                th = th;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e3) {
                        f.a("OctopusAd", "An Exception Caught", e3);
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String i(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem + "";
        } catch (Throwable th) {
            f.a("OctopusAd", "A Throwable Caught", th);
            return null;
        }
    }

    public static String j(Context context) {
        String strA = a(context, "com.huawei.appmarket");
        return strA == null ? "" : strA;
    }

    public static String k(Context context) {
        String strA = a(context, "com.huawei.hwid");
        return strA == null ? "" : strA;
    }

    public static String l(Context context) {
        if (!f()) {
            return null;
        }
        String strA = a(context, "com.bbk.appstore");
        return strA == null ? "" : strA;
    }

    public static String m(Context context) {
        if (!f()) {
            return null;
        }
        String strA = a(context, "com.vivo.browser");
        return strA == null ? "" : strA;
    }

    public static String n(Context context) {
        if (!f()) {
            return null;
        }
        String strA = a(context, "com.kaixinkan.ugc.video.atom");
        return strA == null ? "" : strA;
    }

    public static String o(Context context) {
        if (!f()) {
            return null;
        }
        String strA = a(context, "com.vivo.minigamecenter");
        return strA == null ? "" : strA;
    }

    public static String p(Context context) {
        if (!f()) {
            return null;
        }
        String strA = a(context, "com.android.bbkmusic");
        return strA == null ? "" : strA;
    }

    public static boolean q(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
    }
}
