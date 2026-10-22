package com.acse.ottn;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.acse.ottn.util.HelpShopAppUtil;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class p4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f23132a = "harmony";

    public static String a() {
        if (n3.a() == null) {
            return "";
        }
        String strE = n3.a().e("getDeviceBoard");
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String lowerCase = Build.BOARD.toLowerCase();
        n3.a().b("getDeviceBoard", lowerCase);
        return lowerCase;
    }

    public static int b(Context context) {
        int iC = n3.a().c("getDeviceHeight");
        if (iC != 0) {
            return iC;
        }
        int i = context.getResources().getDisplayMetrics().heightPixels;
        n3.a().a("getDeviceHeight", i);
        return i;
    }

    public static int c(Context context) {
        if (context == null) {
            return 0;
        }
        int iC = n3.a().c("getDeviceWidth");
        if (iC != 0) {
            return iC;
        }
        int i = context.getResources().getDisplayMetrics().widthPixels;
        n3.a().a("getDeviceWidth", i);
        return i;
    }

    public static String d() {
        if (n3.a() == null) {
            return "";
        }
        String strE = n3.a().e("getDeviceDevice");
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String lowerCase = Build.DEVICE.toLowerCase();
        n3.a().b("getDeviceDevice", lowerCase);
        return lowerCase;
    }

    public static String e() {
        return Build.DISPLAY.toLowerCase();
    }

    public static String f() {
        if (n3.a() == null) {
            return "";
        }
        String strE = n3.a().e("getDeviceFubgerprint");
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String lowerCase = Build.FINGERPRINT.toLowerCase();
        n3.a().b("getDeviceFubgerprint", lowerCase);
        return lowerCase;
    }

    public static String g() {
        if (n3.a() == null) {
            return "";
        }
        String strE = n3.a().e("getDeviceHardware");
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String lowerCase = Build.HARDWARE.toLowerCase();
        n3.a().b("getDeviceHardware", lowerCase);
        return lowerCase;
    }

    public static String h() {
        if (n3.a() == null) {
            return "";
        }
        String strE = n3.a().e("getDeviceHost");
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String lowerCase = Build.HOST.toLowerCase();
        n3.a().b("getDeviceHost", lowerCase);
        return lowerCase;
    }

    public static String i() {
        String strE = n3.a().e("getDeviceManufacturer");
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        n3.a().b("getDeviceManufacturer", lowerCase);
        return lowerCase;
    }

    public static String j() {
        return Build.PRODUCT.toLowerCase();
    }

    public static int k() {
        int iC = n3.a().c("getDeviceSDK");
        if (iC != 0) {
            return iC;
        }
        int i = Build.VERSION.SDK_INT;
        n3.a().a("getDeviceSDK", i);
        return i;
    }

    public static String l() {
        String strE = n3.a().e("getDeviceSerial");
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String lowerCase = Build.SERIAL.toLowerCase();
        n3.a().b("getDeviceSerial", lowerCase);
        return lowerCase;
    }

    public static String m() {
        h2.a("wangjie", "Local:" + Locale.GERMAN);
        h2.a("wangjie", "Local:" + Locale.ENGLISH);
        h2.a("wangjie", "Local:" + Locale.US);
        h2.a("wangjie", "Local:" + Locale.CHINESE);
        h2.a("wangjie", "Local:" + Locale.TAIWAN);
        h2.a("wangjie", "Local:" + Locale.FRANCE);
        h2.a("wangjie", "Local:" + Locale.FRENCH);
        h2.a("wangjie", "Local:" + Locale.GERMANY);
        h2.a("wangjie", "Local:" + Locale.ITALIAN);
        h2.a("wangjie", "Local:" + Locale.JAPAN);
        h2.a("wangjie", "Local:" + Locale.JAPANESE);
        return Locale.getAvailableLocales().toString();
    }

    public static String n() {
        String strE = n3.a().e("getDeviceUser");
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String lowerCase = Build.USER.toLowerCase();
        n3.a().b("getDeviceUser", lowerCase);
        return lowerCase;
    }

    public static String o() {
        String strE = n3.a().e("getMobileId");
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String lowerCase = Build.ID.toLowerCase();
        n3.a().b("getMobileId", lowerCase);
        return lowerCase;
    }

    public static String p() {
        if (n3.a() == null) {
            return "";
        }
        String strE = n3.a().e("getSystemModel");
        if (!TextUtils.isEmpty(strE)) {
            return strE;
        }
        String lowerCase = Build.MODEL.toLowerCase();
        n3.a().b("getSystemModel", lowerCase);
        return lowerCase;
    }

    public static String q() {
        return Build.VERSION.RELEASE.toLowerCase();
    }

    public static String r() {
        String str = "0";
        if (HelpShopAppUtil.getContext() == null) {
            return "0";
        }
        String strA = s0.d().a();
        if (strA.equals(n3.a().e("app_version_time"))) {
            return n3.a().a("app_version_code", "0");
        }
        n3.a().a("app_version_code", "0");
        try {
            PackageInfo packageInfo = HelpShopAppUtil.getContext().getPackageManager().getPackageInfo(HelpShopAppUtil.getContext().getPackageName(), 0);
            str = packageInfo.versionCode + "";
            n3.a().b("appName", packageInfo.packageName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        n3.a().b("app_version_time", strA);
        n3.a().b("app_version_code", str);
        return str;
    }

    public static String s() {
        return Build.VERSION.INCREMENTAL;
    }

    public static boolean t() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            Method method = cls.getMethod("getOsBrand", new Class[0]);
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null || classLoader.getParent() != null) {
                return false;
            }
            return f23132a.equals(method.invoke(cls, new Object[0]));
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean e(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0;
    }

    public static String b() {
        return Build.BRAND.toLowerCase();
    }

    public static String c() {
        return Locale.getDefault().getLanguage().toLowerCase();
    }

    public static String a(Context context) {
        return "\n\n2. 设备宽度:\n\t\t" + c(context) + "\n\n3. 设备高度:\n\t\t" + b(context) + "\n\n10. 系统默认语言:\n\t\t" + c() + "\n\n11. 硬件序列号(设备名):\n\t\t" + l() + "\n\n12. 手机型号:\n\t\t" + p() + "\n\n13. 生产厂商:\n\t\t" + i() + "\n\n14. 手机Fingerprint标识:\n\t\t" + f() + "\n\n15. Android 版本:\n\t\t" + q() + "\n\n16. Android SDK版本:\n\t\t" + k() + "\n\n17. 安全patch 时间:\n\t\t" + Build.VERSION.SECURITY_PATCH + "\n\n19. 版本类型:\n\t\t" + Build.TYPE + "\n\n20. 用户名:\n\t\t" + n() + "\n\n21. 产品名:\n\t\t" + j() + "\n\n22. ID:\n\t\t" + o() + "\n\n23. 显示ID:\n\t\t" + e() + "\n\n24. 硬件名:\n\t\t" + g() + "\n\n25. 产品名:\n\t\t" + d() + "\n\n26. Bootloader:\n\t\t" + Build.BOOTLOADER + "\n\n27. 主板名:\n\t\t" + a() + "\n\n28. CodeName:\n\t\t" + Build.VERSION.CODENAME;
    }

    public static boolean d(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) != 0;
    }
}
