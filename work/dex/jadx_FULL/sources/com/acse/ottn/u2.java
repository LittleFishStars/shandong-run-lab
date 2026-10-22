package com.acse.ottn;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import com.alibaba.android.arouter.utils.Consts;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.aliyun.vod.log.core.AliyunLogCommon;
import java.io.ObjectStreamException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static u2 f23269a;

    public static u2 a() {
        if (f23269a == null) {
            synchronized (u2.class) {
                if (f23269a == null) {
                    f23269a = new u2();
                }
            }
        }
        return f23269a;
    }

    public static int b(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    public static boolean e(Context context) {
        return ((LocationManager) context.getSystemService(RequestParameters.SUBRESOURCE_LOCATION)).isProviderEnabled("gps");
    }

    public static boolean f(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null || activeNetworkInfo.getType() != 0) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean g(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public final Object c() throws ObjectStreamException {
        return f23269a;
    }

    public final String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return a(((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getIpAddress());
        } catch (Exception e) {
            h2.a("WifiManager", e.getMessage());
            return "";
        }
    }

    public String c(Context context) {
        if (context == null) {
            return "";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
            if (networkInfo != null && networkInfo.isConnected()) {
                return b();
            }
            if (networkInfo2 != null && networkInfo2.isConnected()) {
                return d(context);
            }
            return "";
        } catch (Exception unused) {
            h2.a("getIpAddress", "getIpAddress is null");
        }
    }

    public final String b() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
            return "";
        } catch (SocketException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return 1;
        }
        if (type != 0) {
            return 0;
        }
        int subtype = activeNetworkInfo.getSubtype();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        if (subtype == 13 && !telephonyManager.isNetworkRoaming()) {
            return 4;
        }
        if (subtype == 3 || subtype == 8) {
            return 3;
        }
        if (subtype == 5 && !telephonyManager.isNetworkRoaming()) {
            return 3;
        }
        if (subtype == 1 || subtype == 2 || subtype != 4) {
            return 2;
        }
        telephonyManager.isNetworkRoaming();
        return 2;
    }

    public final String a(int i) {
        return (i & 255) + Consts.DOT + ((i >> 8) & 255) + Consts.DOT + ((i >> 16) & 255) + Consts.DOT + ((i >> 24) & 255);
    }
}
