package com.zj.adlib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class iy5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42465a = -1;
    public static final int b = 0;
    public static final int c = 1;
    public static final int d = 2;

    public static int a(Context context) {
        if (((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")) != null && b(context)) {
            return c(context) ? 1 : 2;
        }
        return -1;
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        if (networkCapabilities != null) {
            return networkCapabilities.hasCapability(16);
        }
        return false;
    }

    public static boolean c(Context context) {
        NetworkCapabilities networkCapabilities;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork())) == null) {
            return false;
        }
        return networkCapabilities.hasTransport(1);
    }
}
