package com.bwt.top.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.bwt.top.AdSdk;
import com.bwt.top.DeviceParamsController;
import com.kuaishou.weapon.p0.g;
import com.zj.adlib.hja;
import java.net.NetworkInterface;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class DeviceUtil {
    private static final String DEFAULT_MAC = "02:00:00:00:00:00";
    private static final String USER_AGENT = "user_agent";
    private static String defaultUAStr = "";

    @SuppressLint({"HardwareIds"})
    public static String getAndroidId(Context context) {
        try {
            DeviceParamsController deviceController = AdSdk.getInstance().getDeviceController();
            if (deviceController != null && !deviceController.isCanUsePhoneState()) {
                String androidId = deviceController.getAndroidId();
                if (!TextUtils.isEmpty(androidId)) {
                    return androidId;
                }
            }
            String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            return TextUtils.isEmpty(string) ? Settings.System.getString(context.getContentResolver(), "android_id") : string;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getDefaultUAString(Context context) {
        try {
            String strD = hja.c().d("user_agent");
            defaultUAStr = strD;
            if (TextUtils.isEmpty(strD)) {
                String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                defaultUAStr = defaultUserAgent;
                if (!TextUtils.isEmpty(defaultUserAgent)) {
                    String packageName = PackageUtil.getPackageName(context);
                    if (!TextUtils.isEmpty(packageName) && defaultUAStr.contains(packageName)) {
                        defaultUAStr = defaultUAStr.replaceAll(packageName, "");
                    }
                }
                hja.c().b("user_agent", defaultUAStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
            defaultUAStr = "";
        }
        return defaultUAStr;
    }

    @SuppressLint({"MissingPermission"})
    public static String getImei(Context context) {
        TelephonyManager telephonyManager;
        String imei;
        try {
            DeviceParamsController deviceController = AdSdk.getInstance().getDeviceController();
            if (deviceController != null && !deviceController.isCanUsePhoneState()) {
                return deviceController.getImei();
            }
            if (Build.VERSION.SDK_INT < 29 && PermissionUtil.check(context, "android.permission.READ_PHONE_STATE") && (telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)) != null) {
                try {
                    imei = telephonyManager.getImei();
                } catch (Exception e) {
                    e.printStackTrace();
                    imei = null;
                }
                if (!TextUtils.isEmpty(imei)) {
                    return imei;
                }
                try {
                    return telephonyManager.getDeviceId();
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return imei;
                }
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }

    @SuppressLint({"MissingPermission", "HardwareIds"})
    public static String getImsi(Context context) {
        try {
            DeviceParamsController deviceController = AdSdk.getInstance().getDeviceController();
            return (deviceController == null || deviceController.isCanUsePhoneState()) ? ((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getSubscriberId() : deviceController.getImsi();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String getMacAddress(Context context) {
        DeviceParamsController deviceController = AdSdk.getInstance().getDeviceController();
        return (deviceController == null || deviceController.isCanUseWifiState()) ? getMacAddressAboveVersionM() : deviceController.getMacAddress();
    }

    private static String getMacAddressAboveVersionM() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if ("wlan0".equalsIgnoreCase(networkInterface.getName())) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return DEFAULT_MAC;
        } catch (Exception e) {
            e.printStackTrace();
            return DEFAULT_MAC;
        }
    }

    private static String getMacAddressBelowVersionM(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        try {
            if (!PermissionUtil.check(context, g.d) || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
                return DEFAULT_MAC;
            }
            String macAddress = connectionInfo.getMacAddress();
            return TextUtils.isEmpty(macAddress) ? DEFAULT_MAC : macAddress;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DEFAULT_MAC;
    }

    public static String getMcid(Context context) {
        try {
            String oaid = AdSdk.getInstance().getOAID();
            if (TextUtils.isEmpty(oaid)) {
                oaid = OAIDUtil.getOaid(context);
            }
            if (!TextUtils.isEmpty(oaid)) {
                return MD5Util.getMDStr(oaid);
            }
            String androidId = getAndroidId(context);
            if (!TextUtils.isEmpty(androidId)) {
                return MD5Util.getMDStr(androidId);
            }
            return "";
        } catch (Exception unused) {
        }
    }
}
