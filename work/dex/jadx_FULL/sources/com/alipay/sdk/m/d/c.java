package com.alipay.sdk.m.d;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements com.alipay.sdk.m.c.b {
    public static final int d = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.alipay.sdk.m.w0.b f25425a;
    public boolean b = false;
    public boolean c = false;

    @Override // com.alipay.sdk.m.c.b
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.b) {
            com.alipay.sdk.m.w0.b bVar = new com.alipay.sdk.m.w0.b();
            this.f25425a = bVar;
            this.c = bVar.a(context, (com.alipay.sdk.m.w0.b.InterfaceC0211b<String>) null) == 1;
            this.b = true;
        }
        com.alipay.sdk.m.e.a.b("getOAID", "isSupported", Boolean.valueOf(this.c));
        if (this.c && this.f25425a.e()) {
            return this.f25425a.b();
        }
        return null;
    }
}
