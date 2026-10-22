package com.alipay.android.phone.mrpc.core;

import android.content.Context;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h extends x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f25325a;

    public h(Context context) {
        this.f25325a = context;
    }

    private g a(ab abVar) {
        return new i(this, abVar);
    }

    @Override // com.alipay.android.phone.mrpc.core.x
    public <T> T a(Class<T> cls, ab abVar) {
        return (T) new y(a(abVar)).a(cls);
    }
}
