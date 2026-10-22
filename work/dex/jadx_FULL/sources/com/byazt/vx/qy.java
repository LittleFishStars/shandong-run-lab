package com.byazt.vx;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 110})
public class qy {
    private static int c(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 2;
        if (i != 2) {
            i2 = 3;
            if (i != 3) {
                if (i == 4) {
                    return 1;
                }
                if (i == 5) {
                    return 4;
                }
                if (i != 6) {
                    return i;
                }
                return 5;
            }
        }
        return i2;
    }

    public static String c() {
        return ((com.byazt.dna.ve) com.byazt.ut.uj.getService("embed_applog")).getDid();
    }

    public static int tt() {
        return c(com.byazt.bp.c.t().qy().ve() ? com.byazt.aas.qy.c() : 0);
    }

    private static String tt(int i) {
        if (i == 0) {
            return "unknown";
        }
        if (i == 2) {
            return "2g";
        }
        if (i == 3) {
            return "3g";
        }
        if (i == 4) {
            return "wifi";
        }
        if (i != 5) {
            return i != 6 ? "mobile" : NetworkUtil.NETWORK_CLASS_5G;
        }
        return "4g";
    }

    public static String ve() {
        return tt(com.byazt.bp.c.t().qy().ve() ? com.byazt.aas.qy.c() : 0);
    }

    public static boolean c(Context context) {
        NetworkInfo[] allNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
                for (NetworkInfo networkInfo : allNetworkInfo) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED || networkInfo.getState() == NetworkInfo.State.CONNECTING) {
                        return true;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean tt(Context context) {
        return com.byazt.nr.rh.ve(context) == 3;
    }

    public static boolean ve(Context context) {
        return com.byazt.nr.rh.ve(context) == 2;
    }
}
