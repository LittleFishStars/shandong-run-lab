package com.alipay.sdk.m.d;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h implements com.alipay.sdk.m.c.b {
    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zC = com.alipay.sdk.m.u0.e.c(context);
        com.alipay.sdk.m.e.a.b("getOAID", "isSupported", Boolean.valueOf(zC));
        if (zC) {
            return com.alipay.sdk.m.u0.e.a(context);
        }
        return null;
    }
}
