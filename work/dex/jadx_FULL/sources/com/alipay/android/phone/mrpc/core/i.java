package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class i implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ab f25326a;
    public final /* synthetic */ h b;

    public i(h hVar, ab abVar) {
        this.b = hVar;
        this.f25326a = abVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public String a() {
        return this.f25326a.a();
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public ad b() {
        return l.a(e());
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public ab c() {
        return this.f25326a;
    }

    @Override // com.alipay.android.phone.mrpc.core.g
    public boolean d() {
        return this.f25326a.c();
    }

    public Context e() {
        return this.b.f25325a.getApplicationContext();
    }
}
