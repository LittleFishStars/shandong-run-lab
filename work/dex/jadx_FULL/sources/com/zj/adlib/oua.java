package com.zj.adlib;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.hzjizhun.admin.base.ad.RcSdk;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.efs.sdk.base.core.util.NetworkUtil;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class oua {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static oua f43837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static String f18731a;

    public static int a(Context context) {
        boolean zHasCapability;
        if (context == null) {
            return 1;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return 1;
            }
            boolean zHasTransport = false;
            try {
                zHasCapability = networkCapabilities.hasCapability(12);
            } catch (Throwable unused) {
                zHasCapability = false;
            }
            if (!zHasCapability) {
                return 1;
            }
            try {
                zHasTransport = networkCapabilities.hasTransport(1);
            } catch (Throwable unused2) {
            }
            if (zHasTransport) {
                return 2;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
            if (telephonyManager == null) {
                return 1;
            }
            int dataNetworkType = telephonyManager.getDataNetworkType();
            if (dataNetworkType != 19) {
                if (dataNetworkType == 20) {
                    return 6;
                }
                switch (dataNetworkType) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 3;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 4;
                    case 13:
                        break;
                    default:
                        return 1;
                }
            }
            return 5;
        } catch (Throwable unused3) {
            return 1;
        }
    }

    public static String b() {
        String str;
        try {
            if (!TextUtils.isEmpty(f18731a)) {
                return f18731a;
            }
            if (f43837a == null) {
                synchronized (oua.class) {
                    if (f43837a == null) {
                        f43837a = new oua();
                    }
                }
            }
            oua ouaVar = f43837a;
            Context contextE = RcSdk.e();
            ouaVar.getClass();
            switch (a(contextE)) {
                case 1:
                    str = "unknown";
                    break;
                case 2:
                    str = "wifi";
                    break;
                case 3:
                    str = "2g";
                    break;
                case 4:
                    str = "3g";
                    break;
                case 5:
                    str = "4g";
                    break;
                case 6:
                    str = NetworkUtil.NETWORK_CLASS_5G;
                    break;
                default:
                    throw null;
            }
            f18731a = str;
            return str;
        } catch (Throwable th) {
            th.getMessage();
            return "";
        }
    }
}
