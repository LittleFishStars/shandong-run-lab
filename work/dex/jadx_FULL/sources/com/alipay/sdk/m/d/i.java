package com.alipay.sdk.m.d;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i implements com.alipay.sdk.m.c.b {
    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zA = com.alipay.sdk.m.o0.b.a();
        com.alipay.sdk.m.e.a.b("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return com.alipay.sdk.m.o0.b.b(context);
        }
        return null;
    }
}
