package com.beizi.fusion;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class sp {
    public static l7 a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return l7.NET_OTHER;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return l7.NET_WIFI;
                }
                if (type == 0) {
                    int subtype = activeNetworkInfo.getSubtype();
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return l7.NET_2G;
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
                            return l7.NET_3G;
                        case 13:
                        case 18:
                            return l7.NET_4G;
                        case 19:
                        default:
                            if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                                return l7.NET_OTHER;
                            }
                            return l7.NET_3G;
                        case 20:
                            return l7.NET_5G;
                    }
                }
            }
            return l7.NET_OTHER;
        } catch (Throwable th) {
            th.printStackTrace();
            return l7.NET_OTHER;
        }
    }
}
