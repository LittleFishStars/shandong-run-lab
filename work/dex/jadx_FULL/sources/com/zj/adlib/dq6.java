package com.zj.adlib;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.acse.ottn.p3;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.i;
import com.hjq.permissions.Permission;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class dq6 {
    public dq6() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(@NonNull String str) {
        Utils.a().startActivity(i.N(str));
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"HardwareIds"})
    public static String b() {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        TelephonyManager telephonyManagerM = m();
        String deviceId = telephonyManagerM.getDeviceId();
        if (!TextUtils.isEmpty(deviceId)) {
            return deviceId;
        }
        String imei = telephonyManagerM.getImei();
        if (!TextUtils.isEmpty(imei)) {
            return imei;
        }
        String meid = telephonyManagerM.getMeid();
        return TextUtils.isEmpty(meid) ? "" : meid;
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    public static String c() {
        return e(true);
    }

    @RequiresPermission(Permission.CALL_PHONE)
    public static void call(@NonNull String str) {
        Utils.a().startActivity(i.L(str));
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"HardwareIds"})
    public static String d() {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                m().getSubscriberId();
            } catch (SecurityException e) {
                e.printStackTrace();
                return "";
            }
        }
        return m().getSubscriberId();
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"HardwareIds"})
    public static String e(boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            return "";
        }
        TelephonyManager telephonyManagerM = m();
        return z ? g(telephonyManagerM.getImei(0), telephonyManagerM.getImei(1)) : g(telephonyManagerM.getMeid(0), telephonyManagerM.getMeid(1));
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    public static String f() {
        return e(false);
    }

    public static String g(String str, String str2) {
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

    public static int h() {
        return m().getPhoneType();
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"HardwareIds"})
    public static String i() {
        if (Build.VERSION.SDK_INT < 29) {
            return Build.getSerial();
        }
        try {
            return Build.getSerial();
        } catch (SecurityException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String j() {
        String simOperator = m().getSimOperator();
        if (simOperator == null) {
            return "";
        }
        switch (simOperator) {
            case "46000":
            case "46002":
            case "46007":
            case "46020":
                return "中国移动";
            case "46001":
            case "46006":
            case "46009":
                return "中国联通";
            case "46003":
            case "46005":
            case "46011":
                return "中国电信";
            default:
                return simOperator;
        }
    }

    public static String k() {
        return m().getSimOperatorName();
    }

    public static String l(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return "";
        }
    }

    public static TelephonyManager m() {
        return (TelephonyManager) Utils.a().getSystemService(AliyunLogCommon.TERMINAL_TYPE);
    }

    public static boolean n() {
        return m().getPhoneType() != 0;
    }

    public static boolean o() {
        return m().getSimState() == 5;
    }

    public static void p(@NonNull String str, String str2) {
        Utils.a().startActivity(i.b0(str, str2));
    }
}
