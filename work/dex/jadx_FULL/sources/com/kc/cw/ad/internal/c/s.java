package com.kc.cw.ad.internal.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.kc.cw.ad.utils.OctUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class s {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static void a(Context context) {
        int iB;
        int iB2;
        com.kc.cw.ad.a.g.c cVar;
        if (context != null) {
            r rVarA = r.a();
            try {
                byte b = -1;
                if (com.kc.cw.ad.internal.q.a().d > 1) {
                    iB = o.b(context, "net", -1);
                    iB2 = o.b(context, "isp", -1);
                } else {
                    iB = -1;
                    iB2 = -1;
                }
                if (iB == -1) {
                    com.kc.cw.ad.a.g.d dVarC = c(context);
                    rVarA.f38953a = dVarC;
                    o.a(context, "net", Integer.valueOf(dVarC.a()));
                } else {
                    rVarA.f38953a = com.kc.cw.ad.a.g.d.a(iB);
                }
                if (iB2 == -1 && com.kc.cw.ad.internal.q.a().h) {
                    String strA = OctUtil.a().a(context, 1001);
                    if (TextUtils.isEmpty(strA)) {
                        cVar = com.kc.cw.ad.a.g.c.ISP_UNKNOWN;
                    } else {
                        int iHashCode = strA.hashCode();
                        if (iHashCode != 49679477) {
                            switch (iHashCode) {
                                case 49679470:
                                    if (strA.equals("46000")) {
                                        b = 0;
                                    }
                                    break;
                                case 49679471:
                                    if (strA.equals("46001")) {
                                        b = 3;
                                    }
                                    break;
                                case 49679472:
                                    if (strA.equals("46002")) {
                                        b = 1;
                                    }
                                    break;
                                case 49679473:
                                    if (strA.equals("46003")) {
                                        b = 4;
                                    }
                                    break;
                            }
                        } else if (strA.equals("46007")) {
                            b = 2;
                        }
                        if (b == 0 || b == 1 || b == 2) {
                            cVar = com.kc.cw.ad.a.g.c.ISP_CN_MOBILE;
                        } else if (b != 3) {
                            cVar = b != 4 ? com.kc.cw.ad.a.g.c.ISP_OTHER : com.kc.cw.ad.a.g.c.ISP_CN_TEL;
                        } else {
                            cVar = com.kc.cw.ad.a.g.c.ISP_CN_UNICOM;
                        }
                    }
                    rVarA.b = cVar;
                    o.a(context, "isp", Integer.valueOf(rVarA.b.a()));
                } else {
                    rVarA.b = com.kc.cw.ad.a.g.c.a(iB2);
                }
            } catch (Throwable th) {
                com.kc.cw.ad.d.b.f.a("OctopusAd", "A Throwable Caught", th);
            }
            rVarA.c = "0.0.0.0";
        }
    }

    public static String b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception unused) {
            return "";
        }
    }

    private static com.kc.cw.ad.a.g.d c(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        NetworkInfo networkInfo = connectivityManager != null ? connectivityManager.getNetworkInfo(1) : null;
        if (networkInfo != null && networkInfo.isConnected()) {
            return com.kc.cw.ad.a.g.d.NET_WIFI;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return com.kc.cw.ad.a.g.d.NET_2G;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return com.kc.cw.ad.a.g.d.NET_3G;
                    case 13:
                        return com.kc.cw.ad.a.g.d.NET_4G;
                    default:
                        return com.kc.cw.ad.a.g.d.NET_OTHER;
                }
            }
        } catch (Exception e) {
            com.kc.cw.ad.d.b.f.a("OctopusAd", "An Exception Caught", e);
        }
        return com.kc.cw.ad.a.g.d.NET_UNKNOWN;
    }
}
