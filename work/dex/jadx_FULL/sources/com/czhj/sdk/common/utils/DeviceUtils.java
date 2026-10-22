package com.czhj.sdk.common.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.os.Build;
import android.os.IBinder;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.acse.ottn.p3;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.byazt.hv.TTDownloadField;
import com.czhj.sdk.logger.SigmobLog;
import com.igexin.sdk.PushConsts;
import com.kuaishou.weapon.p0.g;
import com.zj.adlib.u15;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DeviceUtils {
    private static String A = null;
    private static Display B = null;
    private static final int b = 31457280;
    private static final String c = "getSimState";
    private static final String d = "getImei";
    private static final String e = "getLine1Number";
    private static final int f = 31457280;
    private static final int g = 104857600;
    private static final int h = -1;
    private static String i;
    private static String k;
    private static String l;
    private static volatile String m;
    private static String n;
    private static boolean p;
    private static long q;
    private static long r;
    private static long s;
    private static long t;
    private static Network v;
    private static long w;
    private static String x;
    private static String y;
    private static String z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String[] f29431a = {"/system/lib/libdroid4x.so", "/system/bin/mount.vboxsf", "/system/lib/vboxguest.ko", "/etc/mumu-configs", "/system/lib/vboxsf.ko", "/system/lib/vboxvideo.ko", "/data/.bluestacks.prop", "/system/bin/microvirt-vbox-sf", "/system/lib/tboxsf.ko", "/system/bin/androVM-vbox-sf", "/system/bin/microvirtd", "/system/bin/windroyed", "/system/lib/libdroid4x.so"};
    private static int j = 0;
    private static NetworkType o = NetworkType.UNKNOWN;
    private static final ArrayList<Network> u = new ArrayList<>();

    public static class NetBroadcastReceiver extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE)) {
                DeviceUtils.updateNetworkType(context);
            }
        }
    }

    public enum NetworkType {
        UNKNOWN(0),
        ETHERNET(101),
        WIFI(100),
        MOBILE(1),
        MOBILE_2G(2),
        MOBILE_3G(3),
        MOBILE_4G(4),
        MOBILE_5G(5);

        private final int mId;

        NetworkType(int i) {
            this.mId = i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static NetworkType b(Context context, int i) {
            if (i != 0) {
                if (i == 1) {
                    return WIFI;
                }
                if (i != 2 && i != 3 && i != 4 && i != 5) {
                    return i != 9 ? UNKNOWN : ETHERNET;
                }
            }
            return DeviceUtils.getDataNetworkType(context);
        }

        public int getId() {
            return this.mId;
        }

        @Override // java.lang.Enum
        public String toString() {
            return Integer.toString(this.mId);
        }
    }

    private static boolean a(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    private static boolean a(Context context) {
        return context.checkCallingOrSelfPermission(g.f40125a) == 0;
    }

    private static boolean a(String str) {
        char cCharAt;
        Process processExec = null;
        try {
            processExec = Runtime.getRuntime().exec("ls -l " + str);
            String line = new BufferedReader(new InputStreamReader(processExec.getInputStream())).readLine();
            if (line != null && line.length() >= 4 && ((cCharAt = line.charAt(3)) == 's' || cCharAt == 'x')) {
                processExec.destroy();
                return true;
            }
        } catch (Throwable unused) {
            if (processExec == null) {
                return false;
            }
        }
        processExec.destroy();
        return false;
    }

    public static long diskCacheSizeBytes(File file, long j2) {
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            j2 = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 50;
        } catch (IllegalArgumentException unused) {
            SigmobLog.d("Unable to calculate 2% of available disk space, defaulting to minimum");
        }
        return Math.max(Math.min(j2, com.ipd.dsp.internal.l0.g.g), 31457280L);
    }

    public static NetworkType getActiveNetworkType() {
        return o;
    }

    public static synchronized String getAndroidId(Context context) {
        if (m == null && context != null) {
            try {
                m = Settings.Secure.getString(context.getContentResolver(), "android_id");
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
                m = "";
            }
        }
        return m;
    }

    public static String getApkSha1OrMd5(Context context, String str) {
        Signature[] signatureArr;
        Signature signature;
        String str2;
        String str3;
        String strSubstring = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.equals("SHA1") && (str3 = x) != null) {
            return str3;
        }
        if (str.equals("MD5") && (str2 = y) != null) {
            return str2;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            if (packageInfo != null && (signatureArr = packageInfo.signatures) != null && signatureArr.length > 0 && (signature = signatureArr[0]) != null) {
                byte[] bArrDigest = MessageDigest.getInstance(str).digest(signature.toByteArray());
                StringBuilder sb = new StringBuilder();
                for (byte b2 : bArrDigest) {
                    sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                    sb.append(u15.f19942b);
                }
                strSubstring = sb.substring(0, sb.length() - 1);
                if (str.equals("SHA1")) {
                    x = strSubstring;
                } else if (str.equals("MD5")) {
                    y = strSubstring;
                }
            }
        } catch (Exception e2) {
            SigmobLog.e(e2.getMessage());
        }
        return strSubstring;
    }

    @SuppressLint({"PrivateApi"})
    public static int getAppLaunchCount(Context context, String str) {
        try {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
            SigmobLog.d("getAppLaunchCount==" + str);
            if (launchIntentForPackage == null) {
                return 0;
            }
            ComponentName component = launchIntentForPackage.getComponent();
            SigmobLog.d("getAppLaunchCount==" + str);
            Object objInvoke = Class.forName("com.android.internal.app.IUsageStats$Stub").getMethod("asInterface", IBinder.class).invoke(null, Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "usagestats"));
            if (objInvoke == null) {
                return 0;
            }
            Object objInvoke2 = objInvoke.getClass().getMethod("getPkgUsageStats", ComponentName.class).invoke(objInvoke, component);
            SigmobLog.d("getAppLaunchCount==" + str);
            if (objInvoke2 == null) {
                return 0;
            }
            Class<?> cls = Class.forName("com.android.internal.os.PkgUsageStats");
            SigmobLog.d("getAppLaunchCount==" + str);
            return cls.getDeclaredField("launchCount").getInt(objInvoke2);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static float getBatteryLevel(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (batteryManager == null) {
            return 0.0f;
        }
        return batteryManager.getIntProperty(4) / 100.0f;
    }

    public static boolean getBatterySaveEnable(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        return batteryManager != null && batteryManager.getIntProperty(4) < 16;
    }

    public static int getBatteryState(Context context) {
        BatteryManager batteryManager = (BatteryManager) context.getSystemService("batterymanager");
        if (batteryManager == null) {
            return 0;
        }
        int intProperty = batteryManager.getIntProperty(6);
        if (intProperty == 2) {
            return 2;
        }
        if (intProperty == 3 || intProperty == 4) {
            return 1;
        }
        return intProperty != 5 ? 0 : 3;
    }

    public static String getBlueToothName(Context context) {
        if (TextUtils.isEmpty(n)) {
            try {
                n = Settings.Secure.getString(context.getContentResolver(), "bluetooth_name");
            } catch (Throwable th) {
                SigmobLog.e(th.getMessage());
            }
        }
        return n;
    }

    public static long getBootSystemTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    public static String getCPUInfo() {
        try {
            return Build.SUPPORTED_ABIS[0];
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public static String getCell_ip() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return "0.0.0.0";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "0.0.0.0";
        }
    }

    public static ConnectivityManager getConnectivityManager(Context context) {
        if (context == null) {
            return null;
        }
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    @SuppressLint({"MissingPermission"})
    public static NetworkType getDataNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        SigmobLog.d("getDataNetworkType ");
        TelephonyManager telephonyManager = getTelephonyManager(context);
        int dataNetworkType = telephonyManager != null ? telephonyManager.getDataNetworkType() : 0;
        ConnectivityManager connectivityManager = getConnectivityManager(context);
        if (dataNetworkType == 0 && connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
            dataNetworkType = activeNetworkInfo.getSubtype();
        }
        SigmobLog.d("getDataNetworkType " + dataNetworkType);
        if (dataNetworkType == 20) {
            return NetworkType.MOBILE_5G;
        }
        switch (dataNetworkType) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return NetworkType.MOBILE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return NetworkType.MOBILE_3G;
            case 13:
                return NetworkType.MOBILE_4G;
            default:
                return NetworkType.MOBILE;
        }
    }

    public static float getDensityDpi(Context context) {
        try {
            return getRealMetrics(context).densityDpi;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return 0.0f;
        }
    }

    public static String getDeviceBrand() {
        return Build.BRAND;
    }

    public static String getDeviceDispaly() {
        return Build.DISPLAY;
    }

    public static Locale getDeviceLocale(Context context) {
        try {
            return context.getResources().getConfiguration().locale;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public static String getDeviceManufacturer() {
        return Build.MANUFACTURER;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceName(Context context) {
        try {
            return Settings.Global.getString(context.getContentResolver(), "device_name");
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public static int getDeviceOSLevel() {
        return Build.VERSION.SDK_INT;
    }

    public static String getDeviceOsVersion() {
        return Build.VERSION.RELEASE;
    }

    public static int getDeviceScreenHeightDip(Context context) {
        if (context == null) {
            return 0;
        }
        return Dips.screenHeightAsIntDips(context);
    }

    public static int getDeviceScreenRealHeightDip(Context context) {
        if (context == null) {
            return 0;
        }
        return Dips.pixelsToIntDips(getRealMetrics(context).heightPixels, context);
    }

    public static int getDeviceScreenRealWidthDip(Context context) {
        if (context == null) {
            return 0;
        }
        return Dips.pixelsToIntDips(getRealMetrics(context).widthPixels, context);
    }

    public static int getDeviceScreenWidthDip(Context context) {
        return Dips.screenWidthAsIntDips(context);
    }

    public static String getDeviceSerial() {
        return Build.SERIAL;
    }

    public static String getDeviceType(Context context) {
        return isTablet(context) ? "pad" : AliyunLogCommon.TERMINAL_TYPE;
    }

    public static Display getDisplay(Context context) {
        if (B == null) {
            WindowManager windowManager = (WindowManager) context.getSystemService("window");
            if (windowManager == null) {
                return null;
            }
            B = windowManager.getDefaultDisplay();
        }
        return B;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        try {
            return context.getResources().getDisplayMetrics();
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return null;
        }
    }

    public static String getNetworkOperator(Context context) {
        String str = A;
        if (str != null) {
            return str;
        }
        TelephonyManager telephonyManager = getTelephonyManager(context);
        if (telephonyManager != null) {
            A = (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) ? telephonyManager.getSimOperator() : telephonyManager.getNetworkOperator();
            if (A == null) {
                A = "";
            }
        }
        return A;
    }

    public static String getNetworkOperatorForUrl(Context context) {
        return getNetworkOperator(context);
    }

    public static String getNetworkOperatorName(Context context) {
        String str = z;
        if (str != null) {
            return str;
        }
        TelephonyManager telephonyManager = getTelephonyManager(context);
        if (telephonyManager != null) {
            z = (telephonyManager.getPhoneType() == 2 && telephonyManager.getSimState() == 5) ? telephonyManager.getSimOperatorName() : telephonyManager.getNetworkOperatorName();
            if (z == null) {
                z = "";
            }
        }
        return z;
    }

    public static int getOrientationInt(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static String getProperty(String str) {
        try {
            Object objInvoke = Class.forName("android.os.SystemProperties").getMethod(p3.f, String.class).invoke(null, str);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static DisplayMetrics getRealMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display display = getDisplay(context);
        if (display == null) {
            return context.getResources().getDisplayMetrics();
        }
        display.getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    public static String getRotation(Context context) {
        Display display = getDisplay(context);
        if (display == null) {
            return "0";
        }
        int rotation = display.getRotation();
        if (rotation == 1) {
            return "90";
        }
        if (rotation != 2) {
            return rotation != 3 ? "0" : "270";
        }
        return "180";
    }

    public static String getSDCardPath(Context context) {
        for (StorageVolume storageVolume : ((StorageManager) context.getSystemService("storage")).getStorageVolumes()) {
            if (storageVolume.isRemovable()) {
                try {
                    return (String) storageVolume.getClass().getMethod("getPath", new Class[0]).invoke(storageVolume, new Object[0]);
                } catch (Exception e2) {
                    SigmobLog.e(e2.getMessage());
                }
            }
        }
        return null;
    }

    public static long getSysteTotalMemorySize(Context context) {
        long j2 = w;
        if (j2 > 0) {
            return j2;
        }
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager == null) {
                return 0L;
            }
            activityManager.getMemoryInfo(memoryInfo);
            long j3 = memoryInfo.totalMem;
            w = j3;
            return j3;
        } catch (Throwable th) {
            SigmobLog.e(th.getMessage());
            return 0L;
        }
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (isCanUsePhoneState(context)) {
                return (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static WindowManager getWindowManger(Context context) {
        return (WindowManager) context.getSystemService("window");
    }

    public static boolean isCanRetryIMEI() {
        boolean z2 = System.currentTimeMillis() - q > 30000;
        if (z2) {
            q = System.currentTimeMillis();
        }
        SigmobLog.d("isCanRetryIMEI status " + z2);
        return z2;
    }

    public static boolean isCanRetryLocation() {
        boolean z2 = System.currentTimeMillis() - s > 36000;
        if (z2) {
            s = System.currentTimeMillis();
        }
        SigmobLog.d("isCanRetryLocation status " + z2);
        return z2;
    }

    public static boolean isCanRetryWIFI() {
        boolean z2 = System.currentTimeMillis() - t > 30000;
        if (z2) {
            t = System.currentTimeMillis();
        }
        SigmobLog.d("isCanRetryWIFI status " + z2);
        return z2;
    }

    public static boolean isCanUseLocation(Context context) {
        boolean z2 = context.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 || context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
        SigmobLog.d("isCanUseLocation status " + z2);
        return z2;
    }

    public static boolean isCanUsePhoneState(Context context) {
        return context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0;
    }

    public static boolean isCanUseWriteExternal(Context context) {
        boolean z2 = context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
        SigmobLog.d("isCanUseWriteExternal status " + z2);
        return z2;
    }

    public static boolean isEmulator() {
        int i2 = j;
        if (i2 > 0) {
            return i2 > 3;
        }
        try {
            String property = getProperty("gsm.version.baseband");
            if (TextUtils.isEmpty(property) || property.contains("1.0.0.0")) {
                j++;
            }
            String property2 = getProperty("ro.build.flavor");
            if (TextUtils.isEmpty(property2)) {
                j++;
            } else if (property2.contains("vbox") || property2.contains("sdk_gphone")) {
                j += 10;
            }
            String property3 = getProperty("ro.product.board");
            if (TextUtils.isEmpty(property3)) {
                j++;
            } else if (property3.contains("android") || property3.contains("goldfish")) {
                j += 10;
            }
            String property4 = getProperty("ro.board.platform");
            if (TextUtils.isEmpty(property4) || property4.contains("android")) {
                j++;
            }
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || str.contains("android")) {
                j++;
            }
            String property5 = getProperty("ro.hardware");
            if (property5 == null) {
                j++;
            } else if (property5.toLowerCase().contains("ttvm") || property5.toLowerCase().contains("nox")) {
                j += 10;
            }
            for (String str2 : f29431a) {
                if (new File(str2).exists()) {
                    SigmobLog.e("find emulator " + str2);
                    j = j + 10;
                }
            }
        } catch (Throwable unused) {
        }
        return j > 3;
    }

    public static boolean isNetworkConnected() {
        return p;
    }

    public static boolean isNetworkValid(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(4) || networkCapabilities.hasCapability(16);
    }

    public static boolean isRoot() {
        return (new File("/system/bin/su").exists() && a("/system/bin/su")) || (new File("/system/xbin/su").exists() && a("/system/xbin/su"));
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static int memoryCacheSizeBytes(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
        if (activityManager == null) {
            return 0;
        }
        long memoryClass = activityManager.getMemoryClass();
        try {
            if (a(context.getApplicationInfo().flags, ApplicationInfo.class.getDeclaredField("FLAG_LARGE_HEAP").getInt(null))) {
                memoryClass = ((Integer) new ReflectionUtil.MethodBuilder(activityManager, "getLargeMemoryClass").execute()).intValue();
            }
        } catch (Throwable unused) {
            SigmobLog.d("Unable to reflectively determine large heap size.");
        }
        return (int) Math.min(31457280L, (memoryClass / 8) * 1024 * 1024);
    }

    @SuppressLint({"MissingPermission"})
    public static void registerNetworkChange(final Context context) {
        ConnectivityManager connectivityManager = getConnectivityManager(context);
        if (connectivityManager == null) {
            return;
        }
        connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback() { // from class: com.czhj.sdk.common.utils.DeviceUtils.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                SigmobLog.d("updateNetworkType registerNetworkCallback onAvailable " + network.hashCode());
                super.onAvailable(network);
                DeviceUtils.u.add(network);
                DeviceUtils.updateNetworkType(context);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                super.onCapabilitiesChanged(network, networkCapabilities);
                DeviceUtils.updateNetworkType(context);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                SigmobLog.d("updateNetworkType registerNetworkCallback onLost" + network.hashCode());
                super.onLost(network);
                NetworkType unused = DeviceUtils.o = NetworkType.UNKNOWN;
                boolean unused2 = DeviceUtils.p = false;
                try {
                    Network unused3 = DeviceUtils.v = network;
                    DeviceUtils.u.remove(network);
                    DeviceUtils.updateNetworkType(context);
                } catch (Throwable unused4) {
                }
            }
        });
    }

    public static void registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z2) {
        if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, z2 ? 2 : 4);
        }
    }

    public static void resetRetryIMEI() {
        q = 0L;
    }

    @SuppressLint({"MissingPermission"})
    public static void updateNetworkType(Context context) {
        NetworkCapabilities networkCapabilities;
        try {
            if (a(context)) {
                Network activeNetwork = getConnectivityManager(context).getActiveNetwork();
                if (activeNetwork == null || activeNetwork == v) {
                    NetworkCapabilities networkCapabilities2 = null;
                    for (int size = u.size() - 1; size >= 0; size--) {
                        networkCapabilities2 = getConnectivityManager(context).getNetworkCapabilities(u.get(size));
                        if (networkCapabilities2 != null) {
                            break;
                        }
                    }
                    networkCapabilities = networkCapabilities2;
                } else {
                    networkCapabilities = getConnectivityManager(context).getNetworkCapabilities(activeNetwork);
                }
                if (networkCapabilities != null) {
                    p = isNetworkValid(networkCapabilities);
                    o = (networkCapabilities.hasCapability(12) && networkCapabilities.hasTransport(1)) ? NetworkType.WIFI : (networkCapabilities.hasCapability(12) && networkCapabilities.hasTransport(0)) ? getDataNetworkType(context) : NetworkType.UNKNOWN;
                }
            }
        } catch (Exception unused) {
        }
    }
}
