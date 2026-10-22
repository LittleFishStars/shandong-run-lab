package com.baidu.platform.comapi.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.kuaishou.weapon.p0.g;
import com.zj.adlib.u15;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NetworkUtil {
    public static final int NETYPE_2G = 2;
    public static final int NETYPE_3G = 3;
    public static final int NETYPE_4G = 4;
    public static final int NETYPE_4G_UNKNOWN = 10;
    public static final int NETYPE_MOBILE_3G = 8;
    public static final int NETYPE_MOBILE_UNICOM_2G = 6;
    public static final int NETYPE_NOCON = -1;
    public static final int NETYPE_TELECOM_2G = 5;
    public static final int NETYPE_TELECOM_3G = 7;
    public static final int NETYPE_UNICOM_3G = 9;
    public static final int NETYPE_UNKNOWN = 0;
    public static final int NETYPE_WIFI = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f26794a = null;
    private static NetworkCallbackImpl b = null;
    public static String mProxyHost = "";
    public static int mProxyPort = 0;
    public static boolean mUseProxy = false;

    @SuppressLint({"NewApi"})
    private static String a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities == null) {
            return "mobile";
        }
        boolean zHasTransport = networkCapabilities.hasTransport(1);
        boolean zHasTransport2 = networkCapabilities.hasTransport(0);
        boolean zHasTransport3 = networkCapabilities.hasTransport(3);
        boolean zHasTransport4 = networkCapabilities.hasTransport(6);
        boolean zHasTransport5 = networkCapabilities.hasTransport(4);
        boolean zHasTransport6 = networkCapabilities.hasTransport(5);
        if (zHasTransport) {
            return com.alibaba.ariver.kernel.common.network.NetworkUtil.NETWORK_TYPE_WIFI;
        }
        if (zHasTransport2) {
            return "CELLULAR";
        }
        if (zHasTransport3) {
            return "ETHERNET";
        }
        if (zHasTransport4) {
            return "LoWPAN";
        }
        if (zHasTransport5) {
            return "VPN";
        }
        return zHasTransport6 ? "WifiAware" : "mobile";
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        ConnectivityManager connectivityManager;
        if (context != null && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            try {
                return connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static NetworkInfo[] getAllNetworkInfo(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000e A[PHI: r2
      0x000e: PHI (r2v2 int) = (r2v0 int), (r2v1 int) binds: [B:5:0x000c, B:23:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    public static String getCurrentNetMode(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        int i = -1;
        if (activeNetworkInfo != null) {
            int type = activeNetworkInfo.getType();
            int i2 = 1;
            if (type != 1) {
                i2 = 5;
                if (type == 0 || type == 3 || type == 4 || type == 5) {
                    if (Build.VERSION.SDK_INT <= 29) {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
                        if (telephonyManager != null) {
                            switch (telephonyManager.getNetworkType()) {
                                case 1:
                                case 2:
                                    i = 6;
                                    break;
                                case 3:
                                case 9:
                                case 10:
                                case 15:
                                    i = 9;
                                    break;
                                case 4:
                                    i = i2;
                                    break;
                                case 5:
                                case 6:
                                case 12:
                                    i = 7;
                                    break;
                                case 7:
                                case 11:
                                case 16:
                                    i = 2;
                                    break;
                                case 8:
                                case 17:
                                    i = 8;
                                    break;
                                case 13:
                                case 18:
                                    i = 4;
                                    break;
                                case 14:
                                    i = 3;
                                    break;
                                default:
                                    i = 0;
                                    break;
                            }
                        }
                    } else {
                        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                        return connectivityManager == null ? "mobile" : a(connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork()));
                    }
                }
            } else {
                i = i2;
            }
        }
        return Integer.toString(i);
    }

    public static String getNetworkOperatorInfo(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        if (telephonyManager != null) {
            String networkOperator = telephonyManager.getNetworkOperator();
            if (!TextUtils.isEmpty(networkOperator)) {
                try {
                    StringBuilder sb = new StringBuilder(networkOperator);
                    sb.insert(3, u15.f19942b);
                    return sb.toString();
                } catch (Exception unused) {
                }
            }
        }
        return "";
    }

    public static int getNetworkOperatorType(Context context) {
        String networkOperatorInfo = getNetworkOperatorInfo(context);
        if (TextUtils.isEmpty(networkOperatorInfo)) {
            return -1;
        }
        if (networkOperatorInfo.startsWith("460:00") || networkOperatorInfo.startsWith("460:02")) {
            return 0;
        }
        if (networkOperatorInfo.startsWith("460:01")) {
            return 1;
        }
        return networkOperatorInfo.startsWith("460:03") ? 2 : -1;
    }

    public static boolean initConnectState() {
        return true;
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            if (isWifiConnected(context)) {
                return true;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && 1 == activeNetworkInfo.getType() && activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isWifiState(Context context) {
        int wifiState;
        if (context == null) {
            return false;
        }
        try {
            wifiState = context.checkSelfPermission(g.d) == 0 ? ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getWifiState() : 1;
        } catch (Exception unused) {
        }
        return wifiState == 3;
    }

    @SuppressLint({"NewApi"})
    public static void registerNetwork(Context context) {
        if (context == null) {
            return;
        }
        f26794a = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
        if (f26794a != null) {
            NetworkCallbackImpl networkCallbackImpl = new NetworkCallbackImpl();
            b = networkCallbackImpl;
            f26794a.registerNetworkCallback(networkRequestBuild, networkCallbackImpl);
        }
    }

    public static void unregisterNetworkCallback() {
        ConnectivityManager connectivityManager;
        NetworkCallbackImpl networkCallbackImpl;
        if (Build.VERSION.SDK_INT < 29 || (connectivityManager = f26794a) == null || (networkCallbackImpl = b) == null) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(networkCallbackImpl);
    }

    public static void updateNetworkProxy(Context context) {
    }
}
