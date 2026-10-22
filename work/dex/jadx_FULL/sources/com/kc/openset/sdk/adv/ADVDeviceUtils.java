package com.kc.openset.sdk.adv;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.WebSettings;
import androidx.core.content.ContextCompat;
import com.acse.ottn.p3;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.kc.openset.config.c;
import com.kc.openset.util.ContextUtils;
import com.kc.openset.util.LocationUtils;
import com.kc.openset.util.b0;
import com.kc.openset.util.c0;
import com.kc.openset.util.h0;
import com.kc.openset.util.j;
import com.kc.openset.util.m;
import com.kc.openset.util.r;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class ADVDeviceUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f39810a = null;
    private static String b = null;
    public static String c = "";
    public static int d = 0;
    public static int e = 0;
    public static String f = "";
    public static String g = "";
    public static String h = "";
    public static String i = "";

    public static float A() {
        try {
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            String str = "";
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            return Float.parseFloat(str);
        } catch (IOException unused) {
            return 0.0f;
        }
    }

    public static long B() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            String line = bufferedReader.readLine();
            String[] strArrSplit = line.split("\\s+");
            for (String str : strArrSplit) {
                Log.i("ADVDeviceUtils", line + ", " + str + "\t");
            }
            long jLongValue = new Long(((long) Integer.valueOf(strArrSplit[1]).intValue()) * 1024).longValue();
            try {
                bufferedReader.close();
                return jLongValue;
            } catch (IOException unused) {
                return jLongValue;
            }
        } catch (IOException unused2) {
            return 0L;
        }
    }

    public static String C() {
        return Build.MODEL;
    }

    public static String D() {
        return b0.l();
    }

    public static String E() {
        String strD = D();
        return TextUtils.isEmpty(strD) ? "" : b(strD);
    }

    public static int F() {
        return 1;
    }

    public static String G() {
        return Build.VERSION.RELEASE;
    }

    public static int H() {
        return Build.VERSION.SDK_INT;
    }

    public static String I() {
        return Build.VERSION.RELEASE;
    }

    public static String J() {
        if (!TextUtils.isEmpty(h)) {
            return h;
        }
        String serial = "";
        if (!c.f()) {
            return "";
        }
        try {
            serial = Build.VERSION.SDK_INT >= 28 ? Build.getSerial() : Build.SERIAL;
        } catch (Exception unused) {
        }
        h = serial;
        return serial;
    }

    public static String K() {
        return c0.a();
    }

    public static String L() {
        String string;
        StringBuilder sb;
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        try {
            StructStat structStatStat = Os.stat("/data/data");
            if (Build.VERSION.SDK_INT >= 27) {
                StructTimespec structTimespec = structStatStat.st_atim;
                sb = new StringBuilder();
                sb.append(structTimespec.tv_sec);
                sb.append(Consts.DOT);
                sb.append(structTimespec.tv_nsec);
            } else {
                sb = new StringBuilder();
                sb.append(structStatStat.st_atime);
                sb.append(".0");
            }
            string = sb.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            string = "";
        }
        b = string;
        return string;
    }

    public static String M() {
        try {
            return WebSettings.getDefaultUserAgent(ContextUtils.getContext());
        } catch (Exception unused) {
            return System.getProperty("http.agent");
        }
    }

    public static String N() {
        return b0.m();
    }

    public static String a() {
        return b0.a();
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (packageInfo == null) {
                return null;
            }
            return String.valueOf(packageInfo.versionName);
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    private static String a(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    private static String a(String str, String str2) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (zIsEmpty && zIsEmpty2) {
            return "";
        }
        if (zIsEmpty || zIsEmpty2) {
            return !zIsEmpty ? str : str2;
        }
        return str.compareTo(str2) <= 0 ? str : str2;
    }

    public static boolean a(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static int b(Context context) {
        return r.a(context);
    }

    public static String b() {
        String strA = a();
        return TextUtils.isEmpty(strA) ? "" : b(strA);
    }

    private static String b(String str) {
        return h0.a(str);
    }

    public static int c(Context context) {
        int intExtra;
        int intExtra2;
        if (context == null) {
            return -1;
        }
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            intExtra2 = intentRegisterReceiver.getIntExtra(com.alibaba.ariver.permission.b.b, -1);
            intExtra = intentRegisterReceiver.getIntExtra("scale", -1);
        } else {
            intExtra = -1;
            intExtra2 = -1;
        }
        if (intExtra2 == -1 || intExtra == -1) {
            return -1;
        }
        return (int) ((intExtra2 / intExtra) * 100.0f);
    }

    public static long c() {
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        if ("mounted".equals(Environment.getExternalStorageState())) {
            absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        if (TextUtils.isEmpty(absolutePath)) {
            return 0L;
        }
        StatFs statFs = new StatFs(absolutePath);
        return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }

    public static int d(Context context) {
        if (context == null) {
            return 0;
        }
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", 1) : 1;
        if (intExtra == 2) {
            return 2;
        }
        if (intExtra != 4) {
            return intExtra != 5 ? 0 : 3;
        }
        return 1;
    }

    public static String d() {
        if (!TextUtils.isEmpty(f39810a)) {
            return f39810a;
        }
        String strTrim = "";
        try {
            File file = new File("/proc/sys/kernel/random/boot_id");
            if (file.exists()) {
                FileInputStream fileInputStream = null;
                try {
                    try {
                        FileInputStream fileInputStream2 = new FileInputStream(file);
                        try {
                            strTrim = new BufferedReader(new InputStreamReader(fileInputStream2)).readLine().trim();
                            try {
                                strTrim = strTrim.substring(0, 36);
                            } catch (Throwable unused) {
                            }
                            fileInputStream2.close();
                        } catch (IOException unused2) {
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            f39810a = strTrim;
                            return strTrim;
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e2) {
                                    e2.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                } catch (IOException unused3) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
        f39810a = strTrim;
        return strTrim;
    }

    public static long e() {
        return (System.currentTimeMillis() - SystemClock.elapsedRealtime()) / 1000;
    }

    public static String e(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:70:0x00d4  */
    /* JADX WARN: Failed to clean up code after switch over string restore
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v3 int, still in use, count: 3, list:
      (r0v3 int) from 0x0029: IF  (r0v3 int) != (49679502 int)  -> B:14:0x002b A[HIDDEN]
      (r0v3 int) from 0x002e: IF  (r0v3 int) != (49679506 int)  -> B:16:0x0030 A[HIDDEN]
      (r0v3 int) from 0x0033: IF  (r0v3 int) != (49679532 int)  -> B:18:0x0035 A[HIDDEN]
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
    	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:226)
    	at jadx.core.utils.InsnRemover.remove(InsnRemover.java:215)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.replaceWithMergedSwitch(SwitchOverStringVisitor.java:355)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:111)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:72)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:140)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:47)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:66)
     */
    public static int f(Context context) {
        String simOperator;
        byte b2;
        int i2 = e;
        if (i2 != 0) {
            return i2;
        }
        if (!c.f() || context == null || (simOperator = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimOperator()) == null) {
            return 0;
        }
        if (iHashCode != 49679502) {
            if (iHashCode != 49679506) {
                if (iHashCode != 49679532) {
                    switch (simOperator) {
                        case "46000":
                            b2 = 0;
                            break;
                        case "46001":
                            b2 = 1;
                            break;
                        case "46002":
                            b2 = 2;
                            break;
                        case "46003":
                            b2 = 3;
                            break;
                        case "46004":
                            b2 = 4;
                            break;
                        case "46005":
                            b2 = 5;
                            break;
                        case "46006":
                            b2 = 6;
                            break;
                        case "46007":
                            b2 = 7;
                            break;
                        case "46008":
                            b2 = 8;
                            break;
                        case "46009":
                            b2 = 9;
                            break;
                        default:
                            b2 = -1;
                            break;
                    }
                } else if (simOperator.equals("46020")) {
                    b2 = 12;
                } else {
                    b2 = -1;
                }
            } else if (simOperator.equals("46015")) {
                b2 = 11;
            } else {
                b2 = -1;
            }
        } else if (simOperator.equals("46011")) {
            b2 = 10;
        } else {
            b2 = -1;
        }
        switch (b2) {
            case 0:
            case 2:
            case 4:
            case 7:
            case 8:
            case 12:
                e = 1;
                return 1;
            case 1:
            case 6:
            case 9:
                e = 3;
                return 3;
            case 3:
            case 5:
            case 10:
                e = 2;
                return 2;
            case 11:
                e = 4;
                return 4;
            default:
                return 0;
        }
    }

    public static String f() {
        return Build.BRAND;
    }

    public static int g(Context context) {
        int i2 = d;
        if (i2 != 0) {
            return i2;
        }
        if (!c.d() || context == null) {
            return 0;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    if (type != 1) {
                        return 0;
                    }
                    d = 1;
                    return 1;
                }
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        d = 2;
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        d = 3;
                        return 3;
                    case 13:
                    case 18:
                        d = 4;
                        return 4;
                    case 16:
                    case 19:
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                            return 0;
                        }
                        d = 3;
                        return 3;
                    case 20:
                        d = 5;
                        return 5;
                }
            }
        } catch (Exception unused) {
        }
        return 0;
    }

    public static long g() {
        return Build.TIME;
    }

    public static float h() {
        return A();
    }

    public static float h(Context context) {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int i() {
        return Runtime.getRuntime().availableProcessors();
    }

    public static String i(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return Settings.Global.getString(context.getContentResolver(), "device_name");
        } catch (Throwable unused) {
            return e(context);
        }
    }

    public static long j() {
        String absolutePath = Environment.getDataDirectory().getAbsolutePath();
        if ("mounted".equals(Environment.getExternalStorageState())) {
            absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        if (TextUtils.isEmpty(absolutePath)) {
            return 0L;
        }
        StatFs statFs = new StatFs(absolutePath);
        return statFs.getBlockSizeLong() * statFs.getBlockCountLong();
    }

    public static String j(Context context) {
        return b(i(context));
    }

    public static int k() {
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }

    public static String k(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 0);
            return packageInfo == null ? "" : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    public static b.f l() {
        return new b.f.a().a(1).a(LocationUtils.f39943a).b(LocationUtils.b).a();
    }

    public static String l(Context context) {
        if (!TextUtils.isEmpty(g)) {
            return g;
        }
        if (!c.f() || context == null || !a(context, "android.permission.READ_PHONE_STATE")) {
            return "";
        }
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSubscriberId();
            g = subscriberId;
            return subscriberId;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String m() {
        return Build.HARDWARE;
    }

    public static String m(Context context) {
        if (!TextUtils.isEmpty(i)) {
            return i;
        }
        if (!c.f()) {
            return "";
        }
        if (context == null) {
            return null;
        }
        if (!a(context, "android.permission.READ_PHONE_STATE") || Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        try {
            TelephonyManager telephonyManagerS = s(context);
            String strA = a(telephonyManagerS.getMeid(0), telephonyManagerS.getMeid(1));
            i = strA;
            return strA;
        } catch (Exception unused) {
            return "";
        }
    }

    public static int n(Context context) {
        if (context == null) {
            return 0;
        }
        int i2 = context.getResources().getConfiguration().orientation;
        if (i2 == 2) {
            return 2;
        }
        return i2 == 1 ? 1 : 0;
    }

    public static String n() {
        return Build.MODEL;
    }

    public static float o(Context context) {
        if (context == null) {
            return 0.0f;
        }
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (float) Math.sqrt(Math.pow(point.x / displayMetrics.xdpi, 2.0d) + Math.pow(point.y / displayMetrics.ydpi, 2.0d));
    }

    public static String o() {
        return b0.j();
    }

    public static int p(Context context) {
        if (context == null) {
            return 0;
        }
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point.y;
    }

    public static String p() {
        String strO = o();
        return TextUtils.isEmpty(strO) ? "" : b(strO);
    }

    public static int q(Context context) {
        if (context == null) {
            return 0;
        }
        Point point = new Point();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealSize(point);
        return point.x;
    }

    public static List<String> q() {
        return j.a();
    }

    public static String r() {
        return c.w();
    }

    public static String r(Context context) {
        if (!TextUtils.isEmpty(f)) {
            return f;
        }
        if (!c.c() || context == null) {
            return "";
        }
        try {
            String ssid = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getSSID();
            if (ssid != null) {
                ssid = ssid.replace("\"", "");
            }
            f = ssid;
            return ssid;
        } catch (Exception unused) {
            return "";
        }
    }

    private static TelephonyManager s(Context context) {
        return (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
    }

    public static String s() {
        return "";
    }

    public static String t() {
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        if (!c.d()) {
            return "";
        }
        String strA = m.a(ContextUtils.getContext());
        c = strA;
        return strA;
    }

    public static String u() {
        return Locale.getDefault().getLanguage();
    }

    public static int v() {
        return TimeZone.getDefault().getRawOffset() / 1000;
    }

    public static String w() {
        return TimeZone.getDefault().getID();
    }

    public static String x() {
        return b0.k();
    }

    public static String y() {
        String strX = x();
        return TextUtils.isEmpty(strX) ? "" : b(strX);
    }

    public static String z() {
        return Build.MANUFACTURER;
    }
}
