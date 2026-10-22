package cn.hzjizhun.admin.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.aliyun.vod.log.core.AliyunLogCommon;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NetWorkUtil {
    private static final String NETWORK_2G = "2G";
    private static final String NETWORK_3G = "3G";
    private static final String NETWORK_4G = "4G";
    private static final String NETWORK_5G = "5G";
    public static final String NETWORK_OTHER = "UNKNOWN";
    private static final String NETWORK_WIFI = "WIFI";

    @SuppressLint({"MissingPermission"})
    public static String getCurrentNetType(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isAvailable()) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null && (state = networkInfo.getState()) != null && (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING)) {
                    return "WIFI";
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
                if (telephonyManager == null) {
                    return "UNKNOWN";
                }
                int networkType = telephonyManager.getNetworkType();
                if (networkType == 19) {
                    return "4G";
                }
                if (networkType == 20) {
                    return NETWORK_5G;
                }
                switch (networkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        return "UNKNOWN";
                }
            }
            return "UNKNOWN";
        } catch (Throwable th) {
            th.printStackTrace();
            return "UNKNOWN";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isWifi(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager == null ? null : connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
