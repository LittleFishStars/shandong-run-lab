package com.gyf.immersionbar;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.p3;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class OSUtils {
    private static final String KEY_DISPLAY = "ro.build.display.id";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";
    private static final String KEY_MIUI_VERSION_NAME = "ro.miui.ui.version.name";

    public static String getEMUIVersion() {
        return isEMUI() ? getSystemProperty("ro.build.version.emui") : "";
    }

    private static String getFlymeOSFlag() {
        return getSystemProperty(KEY_DISPLAY);
    }

    public static String getFlymeOSVersion() {
        return isFlymeOS() ? getSystemProperty(KEY_DISPLAY) : "";
    }

    public static String getMIUIVersion() {
        return isMIUI() ? getSystemProperty("ro.miui.ui.version.name") : "";
    }

    @SuppressLint({"PrivateApi"})
    private static String getSystemProperty(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, str, "");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static boolean isColorOs() {
        return !TextUtils.isEmpty(getSystemProperty(com.blankj.utilcode.util.e.d));
    }

    public static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.build.version.emui"));
    }

    public static boolean isEMUI3_0() {
        return getEMUIVersion().contains("EmotionUI_3.0");
    }

    public static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        return "EmotionUI 3".equals(eMUIVersion) || eMUIVersion.contains("EmotionUI_3.1");
    }

    public static boolean isEMUI3_x() {
        return isEMUI3_0() || isEMUI3_1();
    }

    public static boolean isFlymeOS() {
        return getFlymeOSFlag().toLowerCase().contains("flyme");
    }

    public static boolean isFlymeOS4Later() {
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            return (flymeOSVersion.toLowerCase().contains("os") ? Integer.parseInt(flymeOSVersion.substring(9, 10)) : Integer.parseInt(flymeOSVersion.substring(6, 7))) >= 4;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isFlymeOS5() {
        String flymeOSVersion = getFlymeOSVersion();
        if (flymeOSVersion.isEmpty()) {
            return false;
        }
        try {
            return (flymeOSVersion.toLowerCase().contains("os") ? Integer.parseInt(flymeOSVersion.substring(9, 10)) : Integer.parseInt(flymeOSVersion.substring(6, 7))) == 5;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isFuntouchOrOriginOs() {
        return !TextUtils.isEmpty(getSystemProperty("ro.vivo.os.version"));
    }

    public static boolean isHuaWei() {
        return Build.MANUFACTURER.toLowerCase().contains(AssistUtils.BRAND_HW);
    }

    public static boolean isLenovo() {
        return Build.MANUFACTURER.toLowerCase().contains("lenovo");
    }

    public static boolean isMIUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.miui.ui.version.name"));
    }

    public static boolean isMIUI6Later() {
        String mIUIVersion = getMIUIVersion();
        if (mIUIVersion.isEmpty()) {
            return false;
        }
        try {
            return Integer.parseInt(mIUIVersion.substring(1)) >= 6;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean isMeizu() {
        return Build.MANUFACTURER.toLowerCase().contains(AssistUtils.BRAND_MZ);
    }

    public static boolean isOppo() {
        return Build.MANUFACTURER.toLowerCase().contains("oppo");
    }

    public static boolean isSamsung() {
        return Build.MANUFACTURER.toLowerCase().contains("samsung");
    }

    public static boolean isVivo() {
        return Build.MANUFACTURER.toLowerCase().contains("vivo");
    }

    public static boolean isXiaoMi() {
        return Build.MANUFACTURER.toLowerCase().contains("xiaomi");
    }
}
