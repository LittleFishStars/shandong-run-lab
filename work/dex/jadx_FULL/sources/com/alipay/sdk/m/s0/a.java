package com.alipay.sdk.m.s0;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static String a(Context context) {
        b bVarB = c.b(context);
        return (bVarB == null || com.alipay.sdk.m.q0.f.b(bVarB.c())) ? "ffffffffffffffffffffffff" : bVarB.c();
    }

    public static String b(Context context) {
        String strD = d.a(context).d();
        return (strD == null || com.alipay.sdk.m.q0.f.b(strD)) ? "ffffffffffffffffffffffff" : strD;
    }

    @Deprecated
    public static String c(Context context) {
        return a(context);
    }

    @Deprecated
    public static String d(Context context) {
        return b(context);
    }
}
