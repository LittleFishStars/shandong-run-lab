package com.zj.adlib;

import com.google.android.gms.tasks.OnTokenCanceledListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class iqd implements OnTokenCanceledListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z09 f42424a;

    public iqd(z09 z09Var) {
        this.f42424a = z09Var;
    }

    @Override // com.google.android.gms.tasks.OnTokenCanceledListener
    public final void onCanceled() {
        this.f42424a.f46154a.A();
    }
}
