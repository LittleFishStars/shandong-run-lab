package com.beizi.fusion;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class z1 {
    private static String a(Context context) {
        StringBuilder sb = new StringBuilder();
        String strB = z6.b();
        String strH = z6.h();
        String strE = z6.e();
        String strA = z6.a();
        long jD = z6.d();
        String strC = z6.c();
        sb.append(strB);
        sb.append(strH);
        sb.append(strE);
        sb.append(strA);
        sb.append(jD);
        sb.append(strC);
        sb.append(System.currentTimeMillis());
        String strA2 = qh.a(sb.toString());
        r5.b(context, r5.a(), "scopeID", strA2);
        return strA2;
    }

    public static String b(Context context) {
        String strA = r5.a(context, r5.a(), "scopeID", (String) null);
        return TextUtils.isEmpty(strA) ? a(context) : strA;
    }
}
