package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.Rect;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.system.Os;
import android.system.StructStat;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import android.view.accessibility.AccessibilityManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import com.kwad.sdk.service.ServiceProvider;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class bt {
    private static String bqQ = null;
    private static String bqR = "";
    private static boolean bqS = false;
    private static String bqT = "";
    private static String bqU = "";
    private static int bqV = 0;
    private static boolean bqW = false;
    private static int bqX = 0;
    private static boolean bqY = false;
    private static String brd;
    private static String bre;
    private static int brm;
    private static long brn;
    private static final String[] bqZ = {"", ""};
    private static String bra = "";
    private static String brb = "";
    private static String brc = "";
    private static int brf = -1;
    private static boolean brg = false;
    private static boolean brh = false;
    private static boolean bri = false;
    private static boolean brj = false;
    private static boolean brk = false;
    private static boolean brl = false;
    private static String bro = "";
    private static String brp = "";
    public static String brq = "";
    private static final List<String> brr = Arrays.asList("a5f5faddde9e9f02", "8e17f7422b35fbea", "b88c3c236923d9d9", "cb36bf76cca443d0", "5d4e49ed381836c5", "cffa38e9136f93e9", "62bd2daa59ea0173", "b7aad49a2d5bc5d9", "f2138912c5e5dd5c", "330a1e81a2bf9f31", "59c0f432ccbef844", "521376155e535f39", "aa5ec6ce14abd680", "5522a09bb500d82f", "6dfe4a96800edfb4", "ecc9a2dded8cdf72", "399f868043955b11", "34dc327c00dbff94", "d1b4e3862c309f8b", "68bdbf71f863ccac", "01558dd995085a35", "351174200a06da52", "fa0988506c76ff4b", "8eb8ef823312c61a", "a72e81be65c4638b", "416d15a015c8f324", "474086ea2d737519", "befdddf908c8d749", "780ee58a6f57aab6", "cfe86fa07cae3601", "704ff4d1534f0ff4", "9298b9e9bbd7cdea", "7b634c42f236c6e8", "11eacf22b9ceab7d", "2941a4f39eec5864", "87d134dc5ba45550", "fdd2313bb1750eb9", "6560ef232d8424bb", "5d876286e1064482", "f66fefb916f4962d", "7baf82d0ac49f596", "57748921d8d88ed4", "120cd57f1a50b8f5", "e164f9610ddd9fc8", "6256f0e8da6389de", "bcb22df712476416", "714fa9aff63f7adb", "cb8252e4da7cf610", "e18f649aa80e140c", "966790a9db5ea8d8", "e1769e681af901dd", "d23f2574a60964a4", "d717e6298d3c9cb2", "f5ea5e8ba730864e", "a8a0a223d1a42232", "6675a4f231f5c8db", "3edb7c2103e5c75a", "8ce6a9a216b326c4", "af606153eb3be0a7", "7ae255c3d760c920", "e50e94c40048c5fd", "55009bca30f9dc4c", "c37566487909214a", "891b74f7e534d14a", "726e190aae663525", "df473127d30fb669", "bfbcc646d92dfd48", "a4a1954c44751936", "da4a44a3d7c4d8be", "5ff5bca4a775dd30", "14917461e1917c53", "14ce20d0a80955fa", "a56a63de4d3f3d39", "f780246adc7bd556", "3495a541aea0da72", "f7f205ce47fed2a5", "f52db3f434279c3a", "dca17088c97dee5e", "dd53a8b3a2a4ccc0", "52e07629290d45e4", "cda522b0f8f50d9a", "b85a1c8bcd51d82c", "e344a00cd3f5e93a", "fa59d8a66d7bdd88", "68fb1f1393a216e8", "4c30ab1fb10af181", "b1376e0578099143", "88752f72d8d305fd", "fddf20078d27bf3c", "dab2120bffa2be8c", "c7c8dde481793471", "e4b1bdbcabfc284d");

    public static String B(@Nullable Context context, boolean z) {
        if (be.usePhoneStateDisable() && !TextUtils.isEmpty(be.getDevImei())) {
            return be.getDevImei();
        }
        String strEu = eu(context);
        return (TextUtils.isEmpty(strEu) && !z && TextUtils.isEmpty(com.kwad.sdk.core.e.a.getAppOAID(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FJ() : strEu;
    }

    private static long WE() throws Throwable {
        BufferedReader bufferedReader;
        Throwable th;
        String line;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                        return 0L;
                    }
                } catch (Exception unused) {
                    bufferedReader2 = bufferedReader;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader2);
                    return 0L;
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                    throw th;
                }
            } while (!line.contains("MemTotal"));
            long jLongValue = Long.valueOf(line.split("\\s+")[1]).longValue() << 10;
            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
            return jLongValue;
        } catch (Exception unused2) {
        } catch (Throwable th3) {
            bufferedReader = null;
            th = th3;
        }
    }

    public static long WG() {
        return com.kwad.sdk.crash.utils.h.L(Environment.getDataDirectory());
    }

    public static long WH() {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(1024L)) {
            return 0L;
        }
        return com.kwad.sdk.crash.utils.h.K(Environment.getDataDirectory());
    }

    public static long WI() {
        try {
            long jFreeMemory = Runtime.getRuntime().freeMemory();
            if (jFreeMemory > 0) {
                return jFreeMemory;
            }
            return 0L;
        } catch (Throwable unused) {
        }
    }

    public static int WJ() {
        int i = brm;
        if (i > 0) {
            return i;
        }
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        brm = iAvailableProcessors;
        return iAvailableProcessors;
    }

    public static String WK() {
        return Build.MODEL;
    }

    public static synchronized long WL() {
        long j;
        j = (!be.usePhoneStateDisable() || (TextUtils.isEmpty(be.getDevImei()) && be.getDevImeis() == null)) ? 0L : 1L;
        if (be.readLocationDisable() && be.Wf() != null) {
            j |= 64;
        }
        if (be.usePhoneStateDisable() && !TextUtils.isEmpty(be.getDevAndroidId())) {
            j |= 2;
        }
        if (be.useMacAddressDisable() && !TextUtils.isEmpty(be.getDevMacAddress())) {
            j |= 4;
        }
        if (be.useOaidDisable() && !TextUtils.isEmpty(be.getDevOaid())) {
            j |= 2048;
        }
        if (be.readInstalledPackagesDisable() && be.getDevInstalledPackages() != null) {
            j |= 16;
        }
        return j;
    }

    public static String WM() {
        return Build.BRAND;
    }

    public static String WN() {
        return Build.CPU_ABI;
    }

    public static synchronized long WO() {
        return SystemClock.elapsedRealtime() / 1000;
    }

    public static synchronized long WP() {
        return Build.TIME;
    }

    public static synchronized String WQ() {
        return Build.FINGERPRINT;
    }

    public static synchronized String WR() {
        if (!TextUtils.isEmpty(bqQ)) {
            return bqQ;
        }
        String radioVersion = Build.getRadioVersion();
        bqQ = radioVersion;
        return radioVersion;
    }

    public static synchronized String WS() {
        return bd.getName();
    }

    public static synchronized String WT() {
        return bd.getVersion();
    }

    public static String WU() {
        return Build.MANUFACTURER;
    }

    public static int WV() {
        if (brf == -1) {
            brf = eB(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext()) ? 4 : 3;
        }
        return brf;
    }

    public static String WW() {
        if (TextUtils.isEmpty(bre)) {
            try {
                bre = System.getProperty("os.arch");
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
            }
        }
        return bre;
    }

    public static int WX() {
        return Build.VERSION.SDK_INT;
    }

    public static String WY() {
        if (be.useNetworkStateDisable() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(8L)) {
            return "";
        }
        if (TextUtils.isEmpty(brq)) {
            return brq;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if ((inetAddressNextElement instanceof Inet4Address) && !inetAddressNextElement.isLoopbackAddress()) {
                        String hostAddress = inetAddressNextElement.getHostAddress();
                        brq = hostAddress;
                        return hostAddress;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    private static String WZ() {
        String strI = ai.i("ksadsdk_pref", "random_android_id", "");
        if (!TextUtils.isEmpty(strI)) {
            return strI;
        }
        String strXa = Xa();
        if (TextUtils.isEmpty(strXa)) {
            return "";
        }
        ip(strXa);
        ai.a("ksadsdk_pref", "random_android_id", strXa, true);
        return strXa;
    }

    private static String Xa() {
        try {
            return a(Long.toHexString(new Random(System.currentTimeMillis()).nextLong()), 16, '0');
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String Xb() {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return null;
        }
        String strI = ai.i("ksadsdk_pref", "android_id", null);
        ai.j(strI, "ksadsdk_pref", "android_id");
        return strI;
    }

    private static String a(String str, int i, char c) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() + str.length() < 16) {
            sb.append('0');
        }
        sb.append(str);
        return sb.toString();
    }

    public static String cF(boolean z) {
        com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
        if (fVar == null) {
            return "";
        }
        Context context = fVar.getContext();
        String appOAID = com.kwad.sdk.core.e.a.getAppOAID(context);
        return (TextUtils.isEmpty(appOAID) && !z && TextUtils.isEmpty(eu(context))) ? ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FK() : appOAID;
    }

    public static int checkSelfPermission(@NonNull Context context, @NonNull String str) {
        return context.checkPermission(str, Process.myPid(), Process.myUid());
    }

    @SuppressLint({"HardwareIds"})
    public static String dP(Context context) {
        if (!TextUtils.isEmpty(brc) || context == null || brj) {
            return brc;
        }
        if (be.usePhoneStateDisable()) {
            return be.getDevAndroidId();
        }
        if (!t.UG()) {
            return brc;
        }
        try {
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            brc = string;
            if (!io(string)) {
                brc = "";
            }
        } catch (Exception unused) {
        }
        if (TextUtils.isEmpty(brc)) {
            brj = true;
        }
        return brc;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String dT(Context context) {
        if (context != null) {
            if (!brh && TextUtils.isEmpty(bra) && SystemUtil.eo(context) && !be.usePhoneStateDisable() && t.UN()) {
                try {
                    bra = ((TelephonyManager) context.getApplicationContext().getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSubscriberId();
                } catch (Exception unused) {
                }
                brh = TextUtils.isEmpty(bra);
                return bra;
            }
        }
        return bra;
    }

    public static synchronized int eA(Context context) {
        try {
        } catch (Exception unused) {
            return -1;
        }
        return ((AudioManager) context.getSystemService("audio")).getRingerMode();
    }

    private static boolean eB(Context context) {
        return (context == null || context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }

    @SuppressLint({"HardwareIds"})
    public static synchronized String eC(@Nullable Context context) {
        if (TextUtils.isEmpty(bqR) && context != null && !bqS) {
            if (be.useMacAddressDisable()) {
                String devMacAddress = be.getDevMacAddress();
                bqR = devMacAddress;
                return devMacAddress;
            }
            if (!t.UH()) {
                return bqR;
            }
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo();
                if (connectionInfo != null) {
                    bqR = connectionInfo.getMacAddress();
                }
                if (im(bqR)) {
                    for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                        if (networkInterface != null && "wlan0".equals(networkInterface.getName())) {
                            byte[] hardwareAddress = networkInterface.getHardwareAddress();
                            if (hardwareAddress != null && hardwareAddress.length != 0) {
                                StringBuilder sb = new StringBuilder();
                                for (byte b : hardwareAddress) {
                                    sb.append(String.format("%02X:", Byte.valueOf(b)));
                                }
                                if (sb.length() > 0) {
                                    sb.deleteCharAt(sb.length() - 1);
                                }
                                bqR = sb.toString();
                                break;
                            }
                            break;
                            break;
                        }
                    }
                }
                if (im(bqR)) {
                    bqR = com.kwad.sdk.crash.utils.h.c(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream());
                }
                if (!im(bqR)) {
                    bqR = bqR.toUpperCase(Locale.US);
                }
            } catch (Exception unused) {
                bqS = true;
            }
            bqS = im(bqR);
            return bqR;
        }
        return bqR;
    }

    @Nullable
    public static List<String> eD(@NonNull Context context) {
        String[] list;
        if (!d.cM(context) && eE(context)) {
            File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data");
            if (!file.exists() || !file.isDirectory() || (list = file.list()) == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                if (!TextUtils.isEmpty(str) && !str.startsWith(Consts.DOT)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return new ArrayList();
    }

    public static boolean eE(@NonNull Context context) {
        try {
            return (context.getApplicationInfo().targetSdkVersion < 30 || Build.VERSION.SDK_INT < 30) && context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        } catch (Throwable unused) {
        }
    }

    public static Pair<Boolean, Boolean> eF(Context context) {
        boolean z;
        boolean z2 = false;
        try {
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            accessibilityManager.getEnabledAccessibilityServiceList(16);
            boolean zIsEnabled = accessibilityManager.isEnabled();
            try {
                z2 = accessibilityManager.getEnabledAccessibilityServiceList(16).isEmpty() ? false : true;
                return new Pair<>(Boolean.valueOf(zIsEnabled), Boolean.valueOf(z2));
            } catch (Throwable th) {
                th = th;
                z = z2;
                z2 = zIsEnabled;
                com.kwad.sdk.core.d.c.printStackTrace(th);
                return new Pair<>(Boolean.valueOf(z2), Boolean.valueOf(z));
            }
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    public static long ep(Context context) {
        if (context == null || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(1024L)) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return memoryInfo.availMem;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static int es(Context context) {
        if (((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(512L)) {
            return 0;
        }
        try {
            return ((BatteryManager) context.getApplicationContext().getSystemService("batterymanager")).getIntProperty(4);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static long et(Context context) throws Throwable {
        long j = brn;
        if (j > 0) {
            return j;
        }
        if (context == null) {
            return 0L;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long jWE = memoryInfo.totalMem;
            if (jWE <= 0) {
                jWE = WE();
            }
            brn = jWE;
            return jWE;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    private static synchronized String eu(@Nullable Context context) {
        boolean zEo;
        if (be.usePhoneStateDisable() && !TextUtils.isEmpty(be.getDevImei())) {
            return be.getDevImei();
        }
        if (brg) {
            return bqT;
        }
        if (TextUtils.isEmpty(bqT) && context != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                return bqT;
            }
            if (be.usePhoneStateDisable()) {
                return bqT;
            }
            if (!t.UM()) {
                return bqT;
            }
            try {
                zEo = SystemUtil.eo(context);
                if (zEo) {
                    try {
                        String deviceId = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getDeviceId();
                        bqT = deviceId;
                        if (TextUtils.isEmpty(deviceId)) {
                            brg = true;
                        }
                    } catch (Exception e) {
                        e = e;
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                        if (zEo) {
                            brg = true;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zEo = false;
            }
            return bqT;
        }
        return bqT;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String ev(@Nullable Context context) {
        boolean zEo;
        if (brl) {
            return bqU;
        }
        if (TextUtils.isEmpty(bqU) && context != null) {
            if (be.usePhoneStateDisable()) {
                return bqU;
            }
            if (!t.UL()) {
                return brc;
            }
            try {
                zEo = SystemUtil.eo(context);
                if (zEo) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
                        if (telephonyManager != null) {
                            String meid = telephonyManager.getMeid();
                            bqU = meid;
                            if (TextUtils.isEmpty(meid)) {
                                brl = true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        com.kwad.sdk.core.d.c.printStackTrace(e);
                        if (zEo) {
                            brl = true;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                zEo = false;
            }
            return bqU;
        }
        return bqU;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static synchronized String[] ew(@Nullable Context context) {
        if (be.usePhoneStateDisable() && be.getDevImeis() != null) {
            return be.getDevImeis();
        }
        if (brk) {
            return bqZ;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return bqZ;
        }
        String[] strArr = bqZ;
        boolean z = false;
        if (TextUtils.isEmpty(strArr[0]) && TextUtils.isEmpty(strArr[1]) && context != null) {
            if (be.usePhoneStateDisable()) {
                return strArr;
            }
            if (!t.UM()) {
                return strArr;
            }
            try {
                boolean zEo = SystemUtil.eo(context);
                if (zEo) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
                        if (telephonyManager != null) {
                            int iMin = Math.min(ex(context), 2);
                            for (int i = 0; i < iMin; i++) {
                                bqZ[i] = telephonyManager.getImei(i);
                            }
                            String[] strArr2 = bqZ;
                            if (TextUtils.isEmpty(strArr2[0]) && TextUtils.isEmpty(strArr2[1])) {
                                brk = true;
                            }
                        }
                    } catch (Exception e) {
                        e = e;
                        z = zEo;
                        com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                        if (z) {
                            brk = true;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
            }
            return bqZ;
        }
        return strArr;
    }

    public static synchronized int ex(Context context) {
        if (bqW || bqV > 0 || context == null || be.usePhoneStateDisable()) {
            return bqV;
        }
        try {
            bqV = ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getPhoneCount();
        } catch (Exception unused) {
        }
        int i = bqV;
        bqW = i == 0;
        return i;
    }

    @SuppressLint({"MissingPermission"})
    public static int ey(Context context) {
        if (context == null || bqX > 0 || bqY || !SystemUtil.eo(context) || be.usePhoneStateDisable()) {
            return bqX;
        }
        try {
            bqX = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
        } catch (Throwable unused) {
        }
        int i = bqX;
        bqY = i != 0;
        return i;
    }

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public static String ez(Context context) {
        if (!TextUtils.isEmpty(brb) || context == null) {
            return brb;
        }
        if (!bri && !be.usePhoneStateDisable() && t.UO()) {
            try {
                if (SystemUtil.eo(context)) {
                    brb = ((TelephonyManager) context.getApplicationContext().getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSimSerialNumber();
                }
            } catch (Exception e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
                brb = null;
            }
            if (TextUtils.isEmpty(brb)) {
                bri = true;
            }
            String str = TextUtils.isEmpty(brb) ? "" : brb;
            brb = str;
            return str;
        }
        return brb;
    }

    public static String getDeviceId() {
        try {
            if (!TextUtils.isEmpty(brd)) {
                return brd;
            }
            String strXb = Xb();
            if (!TextUtils.isEmpty(strXb)) {
                String str = "ANDROID_" + strXb;
                brd = str;
                return str;
            }
            String strDP = dP(((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext());
            if (!TextUtils.isEmpty(strDP) && !in(strDP) && io(strDP)) {
                String str2 = "ANDROID_" + strDP;
                brd = str2;
                return str2;
            }
            String strWZ = WZ();
            if (!TextUtils.isEmpty(strWZ)) {
                String str3 = "ANDROID_" + strWZ;
                brd = str3;
                return str3;
            }
            return "ANDROID_";
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    public static String getLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public static String getLocale() {
        Locale locale = LocaleList.getDefault().get(0);
        if (locale == null) {
            locale = Locale.CHINESE;
        }
        return String.valueOf(locale);
    }

    public static String getOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getScreenHeight(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.heightPixels;
            }
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            Rect bounds = currentWindowMetrics.getBounds();
            Insets insets = currentWindowMetrics.getWindowInsets().getInsets(WindowInsets.Type.systemBars());
            return (bounds.height() - insets.top) - insets.bottom;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int getScreenWidth(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (Build.VERSION.SDK_INT < 35) {
                windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                return displayMetrics.widthPixels;
            }
            WindowMetrics currentWindowMetrics = windowManager.getCurrentWindowMetrics();
            Rect bounds = currentWindowMetrics.getBounds();
            Insets insets = currentWindowMetrics.getWindowInsets().getInsets(WindowInsets.Type.systemBars());
            return (bounds.width() - insets.left) - insets.right;
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean im(String str) {
        return TextUtils.isEmpty(str) || str.equals("02:00:00:00:00:00");
    }

    private static boolean in(String str) {
        return brr.contains(str.toLowerCase(Locale.US));
    }

    private static boolean io(String str) {
        for (int i = 0; i < str.length(); i++) {
            try {
                if (str.charAt(i) != '0') {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static void ip(String str) {
        if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).getContext() == null) {
            return;
        }
        ai.a("ksadsdk_pref", "android_id", str, true);
    }

    public static String iq(String str) {
        String strValueOf;
        if (!TextUtils.isEmpty(brp) || TextUtils.isEmpty(str)) {
            return brp;
        }
        int i = Build.VERSION.SDK_INT;
        try {
            StructStat structStatStat = Os.stat(str);
            if (structStatStat == null) {
                return brp;
            }
            String strValueOf2 = "";
            if (i >= 27) {
                if (structStatStat.st_atim == null) {
                    strValueOf = "";
                } else {
                    strValueOf2 = String.valueOf(structStatStat.st_atim.tv_sec);
                    strValueOf = String.valueOf(structStatStat.st_atim.tv_nsec);
                }
                brp = strValueOf2 + Consts.DOT + strValueOf;
            } else {
                long j = structStatStat.st_atime;
                if (j != 0) {
                    strValueOf2 = String.valueOf(j);
                }
                brp = strValueOf2;
            }
            return brp;
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }
}
