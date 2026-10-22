package com.zj.adlib;

import com.google.android.gms.common.api.internal.zact;
import com.google.android.gms.signin.internal.zak;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class v2c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zact f45278a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zak f20170a;

    public v2c(zact zactVar, zak zakVar) {
        this.f45278a = zactVar;
        this.f20170a = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zact.zad(this.f45278a, this.f20170a);
    }
}
