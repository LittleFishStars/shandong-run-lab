package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.zj.adlib.c49;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f28218a = "KEY_UDID";
    public static volatile String b;

    public c() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean A() {
        return (Resources.getSystem().getConfiguration().screenLayout & 15) >= 3;
    }

    public static String B(String str, String str2) {
        b = n(str, str2);
        i.c0().B(f28218a, b);
        return b;
    }

    @RequiresPermission("android.permission.CHANGE_WIFI_STATE")
    public static void C(boolean z) {
        WifiManager wifiManager = (WifiManager) Utils.a().getSystemService("wifi");
        if (wifiManager == null || z == wifiManager.isWifiEnabled()) {
            return;
        }
        wifiManager.setWifiEnabled(z);
    }

    public static String[] a() {
        return Build.SUPPORTED_ABIS;
    }

    @SuppressLint({"HardwareIds"})
    public static String b() {
        String string = Settings.Secure.getString(Utils.a().getContentResolver(), "android_id");
        return ("9774d56d682e549c".equals(string) || string == null) ? "" : string;
    }

    public static InetAddress c() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement.isUp()) {
                    Enumeration<InetAddress> inetAddresses = networkInterfaceNextElement.getInetAddresses();
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress inetAddressNextElement = inetAddresses.nextElement();
                        if (!inetAddressNextElement.isLoopbackAddress() && inetAddressNextElement.getHostAddress().indexOf(58) < 0) {
                            return inetAddressNextElement;
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequiresPermission(allOf = {com.kuaishou.weapon.p0.g.d, "android.permission.CHANGE_WIFI_STATE"})
    public static String d() {
        String strE = e(null);
        if (!TextUtils.isEmpty(strE) || t()) {
            return strE;
        }
        C(true);
        C(false);
        return e(null);
    }

    @RequiresPermission(allOf = {com.kuaishou.weapon.p0.g.d})
    public static String e(String... strArr) {
        String strH = h();
        if (v(strH, strArr)) {
            return strH;
        }
        String strG = g();
        if (v(strG, strArr)) {
            return strG;
        }
        String strI = i();
        if (v(strI, strArr)) {
            return strI;
        }
        String strF = f();
        return v(strF, strArr) ? strF : "";
    }

    public static String f() {
        String str;
        String str2;
        g.b bVarA = i.A("getprop wifi.interface", false);
        if (bVarA.f28230a != 0 || (str = bVarA.f1450a) == null) {
            return "02:00:00:00:00:00";
        }
        g.b bVarA2 = i.A("cat /sys/class/net/" + str + "/address", false);
        return (bVarA2.f28230a != 0 || (str2 = bVarA2.f1450a) == null || str2.length() <= 0) ? "02:00:00:00:00:00" : str2;
    }

    public static String g() {
        NetworkInterface byInetAddress;
        byte[] hardwareAddress;
        try {
            InetAddress inetAddressC = c();
            if (inetAddressC == null || (byInetAddress = NetworkInterface.getByInetAddress(inetAddressC)) == null || (hardwareAddress = byInetAddress.getHardwareAddress()) == null || hardwareAddress.length <= 0) {
                return "02:00:00:00:00:00";
            }
            StringBuilder sb = new StringBuilder();
            for (byte b2 : hardwareAddress) {
                sb.append(String.format("%02x:", Byte.valueOf(b2)));
            }
            return sb.substring(0, sb.length() - 1);
        } catch (Exception e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String h() {
        byte[] hardwareAddress;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterfaceNextElement = networkInterfaces.nextElement();
                if (networkInterfaceNextElement != null && networkInterfaceNextElement.getName().equalsIgnoreCase("wlan0") && (hardwareAddress = networkInterfaceNextElement.getHardwareAddress()) != null && hardwareAddress.length > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02x:", Byte.valueOf(b2)));
                    }
                    return sb.substring(0, sb.length() - 1);
                }
            }
            return "02:00:00:00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    @RequiresPermission(com.kuaishou.weapon.p0.g.d)
    public static String i() {
        WifiInfo connectionInfo;
        try {
            WifiManager wifiManager = (WifiManager) Utils.a().getApplicationContext().getSystemService("wifi");
            if (wifiManager == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return "02:00:00:00:00:00";
            }
            String macAddress = connectionInfo.getMacAddress();
            return !TextUtils.isEmpty(macAddress) ? macAddress : "02:00:00:00:00:00";
        } catch (Exception e) {
            e.printStackTrace();
            return "02:00:00:00:00:00";
        }
    }

    public static String j() {
        return Build.MANUFACTURER;
    }

    public static String k() {
        String str = Build.MODEL;
        return str != null ? str.trim().replaceAll("\\s*", "") : "";
    }

    public static int l() {
        return Build.VERSION.SDK_INT;
    }

    public static String m() {
        return Build.VERSION.RELEASE;
    }

    public static String n(String str, String str2) {
        if (str2.equals("")) {
            return str + UUID.randomUUID().toString().replace(c49.f40900a, "");
        }
        return str + UUID.nameUUIDFromBytes(str2.getBytes()).toString().replace(c49.f40900a, "");
    }

    public static String o() {
        return q("", true);
    }

    public static String p(String str) {
        return q(str, true);
    }

    public static String q(String str, boolean z) {
        if (!z) {
            return s(str);
        }
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    String strR = i.c0().r(f28218a, null);
                    if (strR == null) {
                        return s(str);
                    }
                    b = strR;
                    return b;
                }
            }
        }
        return b;
    }

    public static String r(boolean z) {
        return q("", z);
    }

    public static String s(String str) {
        try {
            String strB = b();
            if (!TextUtils.isEmpty(strB)) {
                return B(str + 2, strB);
            }
        } catch (Exception unused) {
        }
        return B(str + 9, "");
    }

    public static boolean t() {
        WifiManager wifiManager = (WifiManager) Utils.a().getSystemService("wifi");
        if (wifiManager == null) {
            return false;
        }
        return wifiManager.isWifiEnabled();
    }

    @RequiresApi(api = 17)
    public static boolean u() {
        return Settings.Secure.getInt(Utils.a().getContentResolver(), "adb_enabled", 0) > 0;
    }

    public static boolean v(String str, String... strArr) {
        if (TextUtils.isEmpty(str) || "02:00:00:00:00:00".equals(str)) {
            return false;
        }
        if (strArr != null && strArr.length != 0) {
            for (String str2 : strArr) {
                if (str2 != null && str2.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    @RequiresApi(api = 17)
    public static boolean w() {
        return Settings.Global.getInt(Utils.a().getContentResolver(), "development_settings_enabled", 0) > 0;
    }

    public static boolean x() {
        String[] strArr = {"/system/bin/", "/system/xbin/", "/sbin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/xbin/", "/data/local/bin/", "/data/local/", "/system/sbin/", "/usr/bin/", "/vendor/bin/"};
        for (int i = 0; i < 11; i++) {
            if (new File(strArr[i] + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0063  */
    public static boolean y() {
        boolean z;
        String networkOperatorName;
        String str = Build.FINGERPRINT;
        if (str.startsWith("generic") || str.toLowerCase().contains("vbox") || str.toLowerCase().contains("test-keys")) {
            z = true;
        } else {
            String str2 = Build.MODEL;
            if (str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion") || ((Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT))) {
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            return true;
        }
        TelephonyManager telephonyManager = (TelephonyManager) Utils.a().getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        if (telephonyManager == null || (networkOperatorName = telephonyManager.getNetworkOperatorName()) == null) {
            networkOperatorName = "";
        }
        if (networkOperatorName.toLowerCase().equals("android")) {
            return true;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse("tel:123456"));
        intent.setAction("android.intent.action.DIAL");
        return intent.resolveActivity(Utils.a().getPackageManager()) == null;
    }

    @RequiresPermission(allOf = {com.kuaishou.weapon.p0.g.d, com.kuaishou.weapon.p0.g.f40125a, "android.permission.CHANGE_WIFI_STATE"})
    public static boolean z(String str) {
        if (TextUtils.isEmpty(str) && str.length() < 33) {
            return false;
        }
        if (str.equals(b) || str.equals(i.c0().r(f28218a, null))) {
            return true;
        }
        int length = str.length() - 33;
        int i = length + 1;
        String strSubstring = str.substring(length, i);
        if (strSubstring.startsWith("1")) {
            String strD = d();
            if (strD.equals("")) {
                return false;
            }
            return str.substring(i).equals(n("", strD));
        }
        if (!strSubstring.startsWith("2")) {
            return false;
        }
        String strB = b();
        if (TextUtils.isEmpty(strB)) {
            return false;
        }
        return str.substring(i).equals(n("", strB));
    }
}
