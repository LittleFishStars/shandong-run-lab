package com.beizi.fusion;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.aliyun.vod.log.core.AliyunLogCommon;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class a7 {
    public static String a() {
        try {
            return Build.VERSION.SDK_INT + "(" + Build.VERSION.RELEASE + ")";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int b(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null) {
            return 5;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return 4;
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
                            return 6;
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
                            return 1;
                        case 13:
                        case 18:
                            return 2;
                        case 19:
                        default:
                            return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000")) ? 1 : 5;
                        case 20:
                            return 3;
                    }
                    th.printStackTrace();
                    return 5;
                }
            }
            return 5;
        } catch (Throwable th) {
            th.printStackTrace();
            return 5;
        }
    }

    public static int c(Context context) {
        return b(context);
    }

    public static int d(Context context) {
        String simOperator;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (5 == telephonyManager.getSimState() && (simOperator = telephonyManager.getSimOperator()) != null) {
                if (!simOperator.equals("46000") && !simOperator.equals("46002") && !simOperator.equals("46007")) {
                    if (simOperator.equals("46001")) {
                        return 2;
                    }
                    if (simOperator.equals("46003")) {
                        return 3;
                    }
                }
                return 1;
            }
            return 0;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static String c() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(Context context) {
        try {
            return ((TelephonyManager) context.getApplicationContext().getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getPhoneType() != 0 ? "1" : "2";
        } catch (Throwable unused) {
            int i = context.getResources().getConfiguration().screenLayout & 15;
            return (i == 4 || i == 3) ? "2" : "1";
        }
    }

    public static String b() {
        try {
            return Build.BRAND;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String d() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
