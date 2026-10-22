package com.zj.adlib;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zact;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class u2c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zact f45052a;

    public u2c(zact zactVar) {
        this.f45052a = zactVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f45052a.zah.a(new ConnectionResult(4));
    }
}
