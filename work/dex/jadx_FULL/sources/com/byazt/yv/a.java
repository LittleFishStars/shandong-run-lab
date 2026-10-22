package com.byazt.yv;

import android.telephony.TelephonyManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 499, 34})
public class a {
    public static String c(TelephonyManager telephonyManager) throws SecurityException {
        if (da.tt) {
            da.c("SensitiveUtils gDI c", null);
        }
        return telephonyManager.getDeviceId();
    }
}
