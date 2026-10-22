package com.byazt.mg;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.aliyun.vod.log.core.AliyunLogCommon;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 42})
public final class i {

    /* JADX INFO: renamed from: com.byazt.mg.i$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 203})
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.jz.tt.EnumC0445tt.values().length];
            c = iArr;
            try {
                iArr[com.byazt.jz.tt.EnumC0445tt.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.jz.tt.EnumC0445tt.MOBILE_2G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                c[com.byazt.jz.tt.EnumC0445tt.MOBILE_3G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                c[com.byazt.jz.tt.EnumC0445tt.MOBILE_4G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                c[com.byazt.jz.tt.EnumC0445tt.MOBILE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String c(Context context) {
        return c(ve(context));
    }

    public static boolean tt(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) ? false : true;
        } catch (Exception unused) {
        }
    }

    private static com.byazt.jz.tt.EnumC0445tt ve(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return com.byazt.jz.tt.EnumC0445tt.NONE;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (1 == type) {
                    return com.byazt.jz.tt.EnumC0445tt.WIFI;
                }
                if (type != 0) {
                    return com.byazt.jz.tt.EnumC0445tt.MOBILE;
                }
                switch (((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getNetworkType()) {
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return com.byazt.jz.tt.EnumC0445tt.MOBILE_3G;
                    case 4:
                    case 7:
                    case 11:
                    default:
                        return com.byazt.jz.tt.EnumC0445tt.MOBILE;
                    case 13:
                        return com.byazt.jz.tt.EnumC0445tt.MOBILE_4G;
                }
            }
            return com.byazt.jz.tt.EnumC0445tt.NONE;
        } catch (Throwable unused) {
            return com.byazt.jz.tt.EnumC0445tt.MOBILE;
        }
    }

    public static String c(com.byazt.jz.tt.EnumC0445tt enumC0445tt) {
        try {
            int i = AnonymousClass1.c[enumC0445tt.ordinal()];
            if (i == 1) {
                return "wifi";
            }
            if (i == 2) {
                return "2g";
            }
            if (i == 3) {
                return "3g";
            }
            if (i != 4) {
                return i != 5 ? "" : "mobile";
            }
            return "4g";
        } catch (Exception unused) {
            return "";
        }
    }
}
