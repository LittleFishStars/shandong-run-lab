package com.byazt.vx;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 512})
public class d {
    public static String c;

    public static boolean c() {
        return com.byazt.eu.tt.tt() && com.byazt.omf.x.m().lr();
    }

    public static String tt() {
        if (TextUtils.isEmpty(c)) {
            c = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return c;
    }

    public static String c(String str) {
        try {
            if (!c()) {
                return str;
            }
            String strGt = com.byazt.bp.c.t().gt();
            if (TextUtils.isEmpty(strGt)) {
                return str;
            }
            com.byazt.eu.tt.c("TestHelperUtils", "AnyDoorId=" + strGt);
            return Uri.parse(str).buildUpon().appendQueryParameter(tt(), strGt).appendQueryParameter("aid", "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
