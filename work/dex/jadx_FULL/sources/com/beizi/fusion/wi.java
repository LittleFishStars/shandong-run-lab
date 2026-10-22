package com.beizi.fusion;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class wi {
    /* JADX WARN: Code duplicated, block: B:11:0x0024  */
    public static int a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return v6.CONNECT_TYPE_UNKNOWN.b();
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                if (zk.b(context, "android.permission.ACCESS_NETWORK_STATE")) {
                    activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                } else {
                    activeNetworkInfo = null;
                }
            } catch (Throwable unused) {
            }
        } else {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null) {
            return v6.CONNECT_TYPE_UNKNOWN.b();
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return v6.CONNECT_TYPE_WIFI.b();
        }
        if (type != 0) {
            return v6.CONNECT_TYPE_UNKNOWN.b();
        }
        int subtype = activeNetworkInfo.getSubtype();
        String subtypeName = activeNetworkInfo.getSubtypeName();
        switch (subtype) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return v6.CONNECT_TYPE_2G.b();
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return v6.CONNECT_TYPE_3G.b();
            case 13:
            case 18:
                return v6.CONNECT_TYPE_4G.b();
            case 19:
            default:
                return ("TD-SCDMA".equalsIgnoreCase(subtypeName) || "WCDMA".equalsIgnoreCase(subtypeName) || "CDMA2000".equalsIgnoreCase(subtypeName)) ? v6.CONNECT_TYPE_3G.b() : v6.CONNECT_TYPE_UNKNOWN.b();
            case 20:
                return v6.CONNECT_TYPE_5G.b();
        }
    }

    public static boolean b(Context context) {
        if (zk.b(context, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null && networkCapabilities.hasTransport(1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                ArrayList list = Collections.list(networkInterfaces);
                int size = list.size();
                int i = 0;
                while (i < size) {
                    Object obj = list.get(i);
                    i++;
                    String name = ((NetworkInterface) obj).getName();
                    if ("tun0".equals(name) || "ppp0".equals(name)) {
                        return true;
                    }
                }
            }
        } catch (SocketException e) {
            om.a(e);
        }
        return false;
    }
}
