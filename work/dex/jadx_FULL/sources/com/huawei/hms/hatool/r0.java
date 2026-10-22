package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f37583a = {1, 6, 7, 9};
    private static final int[] b = {0, 2, 3, 4, 5};
    private static final Map<Integer, String> c = new a();

    public static class a extends HashMap<Integer, String> {
        public a() {
            put(1, NetworkUtil.NETWORK_TYPE_2G);
            put(2, NetworkUtil.NETWORK_TYPE_2G);
            put(4, NetworkUtil.NETWORK_TYPE_2G);
            put(7, NetworkUtil.NETWORK_TYPE_2G);
            put(11, NetworkUtil.NETWORK_TYPE_2G);
            put(3, NetworkUtil.NETWORK_TYPE_3G);
            put(8, NetworkUtil.NETWORK_TYPE_3G);
            put(9, NetworkUtil.NETWORK_TYPE_3G);
            put(10, NetworkUtil.NETWORK_TYPE_3G);
            put(15, NetworkUtil.NETWORK_TYPE_3G);
            put(5, NetworkUtil.NETWORK_TYPE_3G);
            put(6, NetworkUtil.NETWORK_TYPE_3G);
            put(12, NetworkUtil.NETWORK_TYPE_3G);
            put(14, NetworkUtil.NETWORK_TYPE_3G);
            put(13, NetworkUtil.NETWORK_TYPE_4G);
            if (Build.VERSION.SDK_INT >= 29) {
                put(20, "5G");
            }
        }
    }

    @SuppressLint({"MissingPermission"})
    private static NetworkInfo a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                return connectivityManager.getActiveNetworkInfo();
            }
            return null;
        } catch (Throwable th) {
            v.b("hmsSdk", "cannot get network state, ensure permission android.permission.ACCESS_NETWORK_STATE in the manifest: " + th.getMessage());
            return null;
        }
    }

    private static String a(int i) {
        Map<Integer, String> map = c;
        String str = map.containsKey(Integer.valueOf(i)) ? map.get(Integer.valueOf(i)) : "unknown";
        if (!"unknown".equals(str)) {
            return str;
        }
        if (i != 16) {
            return i != 17 ? "unknown" : NetworkUtil.NETWORK_TYPE_3G;
        }
        return NetworkUtil.NETWORK_TYPE_2G;
    }

    private static boolean a(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(b, networkInfo.getType()) == -1) ? false : true;
    }

    public static String b(Context context) {
        if (context == null) {
            return "unknown";
        }
        try {
            NetworkInfo networkInfoA = a(context);
            if (!b(networkInfoA)) {
                return "none";
            }
            if (c(networkInfoA)) {
                return NetworkUtil.NETWORK_TYPE_WIFI;
            }
            if (a(networkInfoA)) {
                return a(networkInfoA.getSubtype());
            }
            return "unknown";
        } catch (Throwable unused) {
        }
    }

    private static boolean b(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isConnected();
    }

    private static boolean c(NetworkInfo networkInfo) {
        return (networkInfo == null || Arrays.binarySearch(f37583a, networkInfo.getType()) == -1) ? false : true;
    }
}
