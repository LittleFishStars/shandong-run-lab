package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class fk {
    public static String a(Context context) {
        String strB;
        if (context == null) {
            return "";
        }
        return ((s3.a() == null || (!s3.b() && s3.a().d())) && (strB = pm.b(context, "__HONOROAID__")) != null) ? strB : "";
    }

    public static String b(Context context) {
        String strB;
        if (context == null) {
            return "";
        }
        String strA = s3.a() != null ? s3.a().a() : null;
        if (TextUtils.isEmpty(strA)) {
            return ((s3.a() == null || (!s3.b() && s3.a().d())) && (strB = pm.b(context, "__OAID__")) != null) ? strB : "";
        }
        return strA;
    }
}
