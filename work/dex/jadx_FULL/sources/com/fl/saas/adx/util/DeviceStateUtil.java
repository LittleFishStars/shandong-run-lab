package com.fl.saas.adx.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.ProxyInfo;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DeviceStateUtil {
    private static boolean checkSimCardAlternative(Context context) {
        String networkOperatorName;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            return (telephonyManager == null || (networkOperatorName = telephonyManager.getNetworkOperatorName()) == null || networkOperatorName.trim().isEmpty()) ? false : true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean hasSimCard(Context context) {
        TelephonyManager telephonyManager;
        if (context == null || (telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService(AliyunLogCommon.TERMINAL_TYPE)) == null) {
            return false;
        }
        try {
            int simState = telephonyManager.getSimState();
            return simState == 5 || simState != 1;
        } catch (Exception unused) {
            return checkSimCardAlternative(context);
        }
    }

    public static boolean isDebug() {
        return false;
    }

    public static boolean isDeveloperOptionsEnabled(Context context) {
        try {
            return Settings.Global.getInt(context.getApplicationContext().getContentResolver(), "development_settings_enabled", 0) == 1;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static boolean isDeviceRooted() {
        String[] strArr = {"/system/bin/su", "/system/xbin/su", "/system/app/Superuser.apk", "/system/etc/init.d/"};
        for (int i = 0; i < 4; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNetworkProxyEnabled(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        ProxyInfo defaultProxy = (connectivityManager == null || connectivityManager.getActiveNetwork() == null) ? null : connectivityManager.getDefaultProxy();
        return (defaultProxy == null || defaultProxy.getHost() == null) ? false : true;
    }

    public static boolean isVPNConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        for (Network network : connectivityManager.getAllNetworks()) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
            if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                return true;
            }
        }
        return false;
    }
}
