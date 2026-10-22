package com.efs.sdk.base.core.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class NetworkUtil {
    public static final String MOBILE_NETWORK = "2G/3G";
    public static final String NETWORK_CLASS_2G = "2g";
    public static final String NETWORK_CLASS_3G = "3g";
    public static final String NETWORK_CLASS_4G = "4g";
    public static final String NETWORK_CLASS_5G = "5g";
    public static final String NETWORK_CLASS_DENIED = "denied";
    public static final String NETWORK_CLASS_DISCONNECTED = "disconnected";
    public static final String NETWORK_CLASS_UNKNOWN = "unknown";
    public static final String NETWORK_TYPE_WIFI = "wifi";
    public static final String UNKNOW = "";
    public static final String WIFI = "Wi-Fi";

    public static boolean checkPermission(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            return ((Integer) Class.forName("android.content.Context").getMethod("checkSelfPermission", String.class).invoke(context, str)).intValue() == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                Log.w("efs.base", "get CONNECTIVITY_SERVICE is null");
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if ((activeNetworkInfo != null && activeNetworkInfo.isConnected()) || (allNetworkInfo = connectivityManager.getAllNetworkInfo()) == null) {
                return activeNetworkInfo;
            }
            for (int i = 0; i < allNetworkInfo.length; i++) {
                NetworkInfo networkInfo = allNetworkInfo[i];
                if (networkInfo != null && networkInfo.isConnected()) {
                    return allNetworkInfo[i];
                }
            }
            return activeNetworkInfo;
        } catch (Throwable th) {
            Log.e("efs.base", "get network info error", th);
            return null;
        }
    }

    public static String[] getNetworkAccessMode(Context context) {
        String[] strArr = {"", ""};
        if (context == null) {
            return strArr;
        }
        try {
            if (!checkPermission(context, "android.permission.ACCESS_NETWORK_STATE")) {
                strArr[0] = "";
                return strArr;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                strArr[0] = "";
                return strArr;
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = WIFI;
                return strArr;
            }
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            if (networkInfo2 != null && networkInfo2.getState() == NetworkInfo.State.CONNECTED) {
                strArr[0] = MOBILE_NETWORK;
                strArr[1] = networkInfo2.getSubtypeName();
            }
            return strArr;
        } catch (Throwable unused) {
        }
    }

    public static String getNetworkType(Context context) {
        if (isRejectAccessNetworkState(context)) {
            return NETWORK_CLASS_DENIED;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        if (activeNetworkInfo == null) {
            return NETWORK_CLASS_DISCONNECTED;
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        int subtype = activeNetworkInfo.getSubtype();
        if (subtype == 20) {
            return NETWORK_CLASS_5G;
        }
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return "2g";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return "3g";
            case 13:
                return "4g";
            default:
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (TextUtils.isEmpty(subtypeName)) {
                    return "unknown";
                }
                return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? "3g" : subtypeName;
        }
    }

    public static int getNetworkTypeUmeng(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (checkPermission(context, "android.permission.READ_PHONE_STATE")) {
                return telephonyManager.getNetworkType();
            }
            return 0;
        } catch (Exception unused) {
            return -100;
        }
    }

    public static boolean hasAccessNetworkState(Context context) {
        try {
            return context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0;
        } catch (Throwable unused) {
        }
    }

    public static boolean isConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public static boolean isRejectAccessNetworkState(Context context) {
        return !hasAccessNetworkState(context);
    }

    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo;
        return !isRejectAccessNetworkState(context) && (activeNetworkInfo = getActiveNetworkInfo(context)) != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }
}
