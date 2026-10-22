package com.baidu.mapapi;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.baidu.mapsdkplatform.comapi.util.SysUpdateObservable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class NetworkUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f26480a = false;
    private static a b;
    private static ConnectivityManager c;

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo = null;
        if (context == null) {
            return null;
        }
        c = (ConnectivityManager) context.getSystemService("connectivity");
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                NetworkRequest networkRequestBuild = new NetworkRequest.Builder().build();
                if (c != null && !f26480a) {
                    a aVar = new a(context);
                    b = aVar;
                    c.registerNetworkCallback(networkRequestBuild, aVar);
                    f26480a = true;
                }
            } else {
                activeNetworkInfo = c.getActiveNetworkInfo();
            }
        } catch (Exception unused) {
        }
        return activeNetworkInfo;
    }

    public static String getCurrentNetMode(Context context) {
        NetworkCapabilities networkCapabilities;
        if (context == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        int i = 0;
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() != 1) {
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
                                i = 5;
                                break;
                            case 5:
                            case 6:
                            case 7:
                            case 12:
                                i = 7;
                                break;
                            case 8:
                                i = 8;
                                break;
                            case 11:
                                i = 2;
                                break;
                            case 13:
                                i = 4;
                                break;
                            case 14:
                                i = 10;
                                break;
                        }
                    } else {
                        return Integer.toString(0);
                    }
                } else {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
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
            } else {
                i = 1;
            }
        }
        return Integer.toString(i);
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

    public static boolean isWifiConnected(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return false;
        }
        try {
            return 1 == networkInfo.getType() && networkInfo.isConnected();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void unregisterNetworkCallback() {
        ConnectivityManager connectivityManager;
        a aVar;
        if (Build.VERSION.SDK_INT < 29 || (connectivityManager = c) == null || (aVar = b) == null || !f26480a) {
            return;
        }
        connectivityManager.unregisterNetworkCallback(aVar);
        f26480a = false;
    }

    public static void updateNetworkProxy(Context context) {
        SysUpdateObservable.getInstance().updateNetworkProxy(context);
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && 1 == activeNetworkInfo.getType() && activeNetworkInfo.isConnected();
        } catch (Exception unused) {
            return false;
        }
    }
}
