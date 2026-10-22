package com.alibaba.analytics.core.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.x;
import com.alibaba.analytics.a.y;
import com.alibaba.analytics.core.d;
import com.alibaba.ariver.kernel.common.network.NetworkUtil;
import com.igexin.sdk.PushConsts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f23781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static C0136b f651a;
    private static String[] d = {"Unknown", "Unknown"};
    private static boolean L = false;
    private static boolean M = false;
    private static boolean N = false;

    public static class a implements Runnable {
        private Context b;

        private a() {
        }

        public a a(Context context) {
            this.b = context;
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.b;
            if (context == null) {
                return;
            }
            b.i(context);
            com.alibaba.analytics.core.e.a.e(this.b);
            y.k(this.b);
        }
    }

    /* JADX INFO: renamed from: com.alibaba.analytics.core.e.b$b, reason: collision with other inner class name */
    public static class C0136b extends BroadcastReceiver {
        private C0136b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            x.a().submit(b.f23781a.a(context));
        }
    }

    static {
        f651a = new C0136b();
        f23781a = new a();
    }

    private static String a(int i) {
        if (i == 20) {
            return NetworkUtil.NETWORK_TYPE_4G;
        }
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return NetworkUtil.NETWORK_TYPE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return NetworkUtil.NETWORK_TYPE_3G;
            case 13:
                return NetworkUtil.NETWORK_TYPE_4G;
            default:
                return "Unknown";
        }
    }

    private static boolean b(int i) {
        return i > 4900 && i < 5900;
    }

    public static void g(Context context) {
        if (context == null) {
            return;
        }
        context.registerReceiver(f651a, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
        try {
            com.alibaba.analytics.core.e.a.c(context);
        } catch (Exception unused) {
        }
        x.a().submit(f23781a.a(context));
    }

    public static String getAccess(Context context) {
        try {
            return m131a(context)[0];
        } catch (Exception unused) {
            return "Unknown";
        }
    }

    public static String getAccsssSubType(Context context) {
        try {
            String[] strArrM131a = m131a(context);
            if (strArrM131a[0].equals(com.efs.sdk.base.core.util.NetworkUtil.MOBILE_NETWORK)) {
                return strArrM131a[1];
            }
            return strArrM131a[1].equals("5G") ? "5G" : "Unknown";
        } catch (Exception unused) {
        }
    }

    public static void h(Context context) {
        C0136b c0136b;
        if (context == null || (c0136b = f651a) == null) {
            return;
        }
        context.unregisterReceiver(c0136b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void i(Context context) {
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                String[] strArr = d;
                strArr[0] = "Unknown";
                strArr[1] = "Unknown";
                return;
            }
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                String[] strArr2 = d;
                strArr2[0] = "Unknown";
                strArr2[1] = "Unknown";
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                String[] strArr3 = d;
                strArr3[0] = "Unknown";
                strArr3[1] = "Unknown";
            } else if (1 == activeNetworkInfo.getType()) {
                d[0] = com.efs.sdk.base.core.util.NetworkUtil.WIFI;
                if (a(context)) {
                    d[1] = "5G";
                } else {
                    d[1] = "Unknown";
                }
            } else if (activeNetworkInfo.getType() == 0) {
                String[] strArr4 = d;
                strArr4[0] = com.efs.sdk.base.core.util.NetworkUtil.MOBILE_NETWORK;
                strArr4[1] = activeNetworkInfo.getSubtypeName();
            }
            if (!L) {
                L = true;
            }
        } catch (Exception e) {
            j.d(NetworkUtil.TAG, e);
        }
    }

    public static boolean isConnectInternet(Context context) {
        if (context == null) {
            return true;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
                return true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    public static String v() {
        NetworkInfo activeNetworkInfo;
        Context context = d.a().getContext();
        if (context == null) {
            return "Unknown";
        }
        try {
            if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0 && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.isConnected()) {
                if (activeNetworkInfo.getType() == 1) {
                    return com.efs.sdk.base.core.util.NetworkUtil.WIFI;
                }
                if (activeNetworkInfo.getType() == 0) {
                    return a(activeNetworkInfo.getSubtype());
                }
            }
        } catch (Throwable unused) {
        }
        return "Unknown";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String[] m131a(Context context) {
        if (!L) {
            i(context);
        }
        return d;
    }

    private static boolean a(Context context) {
        WifiInfo connectionInfo;
        if (context == null || (connectionInfo = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo()) == null) {
            return false;
        }
        return b(connectionInfo.getFrequency());
    }
}
