package cj.mobile.wm;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class de {
    public static NetworkInfo dexa(Context context) {
        String str;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            str = "getActiveNetworkInfo: ConnectivityManager is null";
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                return activeNetworkInfo;
            }
            str = "getActiveNetworkInfo: no active NetworkInfo.";
        }
        Log.e("DeviceUtils", str);
        return null;
    }

    public static AssetManager dexb(Context context) {
        if (context != null) {
            return context.getApplicationContext().getAssets();
        }
        return null;
    }

    public static int dexc(Context context) {
        return !dexg(context) ? 1 : 0;
    }

    public static int dexd(Context context) {
        NetworkInfo networkInfoDexa = dexa(context);
        if (networkInfoDexa != null && networkInfoDexa.isAvailable()) {
            int type = networkInfoDexa.getType();
            if (type != 1) {
                if (type == 0) {
                    int subtype = networkInfoDexa.getSubtype();
                    String subtypeName = networkInfoDexa.getSubtypeName();
                    switch (subtype) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                        case 16:
                            return 4;
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
                            return 5;
                        case 13:
                            return 6;
                        default:
                            if (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) {
                                return 5;
                            }
                            break;
                    }
                }
            } else {
                return 2;
            }
        }
        return 0;
    }

    public static int dexe(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int dexf(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static boolean dexg(Context context) {
        return (context.getResources() == null || context.getResources().getConfiguration() == null || (context.getResources().getConfiguration().screenLayout & 15) < 3) ? false : true;
    }
}
