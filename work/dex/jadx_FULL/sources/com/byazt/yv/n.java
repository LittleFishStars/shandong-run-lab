package com.byazt.yv;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.aliyun.vod.log.core.AliyunLogCommon;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 499, 46})
public class n {
    public static String c(Context context) {
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferencesTt = com.byazt.nys.tt.tt(context, "applog_net_cache.dat", 0);
        if (System.currentTimeMillis() - sharedPreferencesTt.getLong("start_mills", 0L) < com.heytap.mcssdk.constant.a.h) {
            String string = sharedPreferencesTt.getString("access", null);
            if (!TextUtils.isEmpty(string)) {
                return string;
            }
        }
        String strTt = tt(context);
        SharedPreferences.Editor editorEdit = sharedPreferencesTt.edit();
        if (!TextUtils.isEmpty(strTt)) {
            editorEdit.putString("access", strTt);
        }
        editorEdit.putLong("start_mills", System.currentTimeMillis());
        editorEdit.apply();
        return strTt;
    }

    private static String tt(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (SecurityException e) {
            da.tt(e);
            activeNetworkInfo = null;
        } catch (Throwable unused) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (1 == type) {
            return "wifi";
        }
        if (type != 0) {
            return null;
        }
        switch (((TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE)).getNetworkType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2g";
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
                return "3g";
            case 13:
            case 18:
            case 19:
                return "4g";
            default:
                return "mobile";
        }
    }
}
