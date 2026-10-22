package com.zj.adlib;

import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzd;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mec implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f43284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zzd f18183a;
    public final /* synthetic */ String f;

    public mec(zzd zzdVar, LifecycleCallback lifecycleCallback, String str) {
        this.f18183a = zzdVar;
        this.f43284a = lifecycleCallback;
        this.f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzd zzdVar = this.f18183a;
        if (zzdVar.zzc > 0) {
            this.f43284a.e(zzdVar.zzd != null ? zzdVar.zzd.getBundle(this.f) : null);
        }
        if (this.f18183a.zzc >= 2) {
            this.f43284a.i();
        }
        if (this.f18183a.zzc >= 3) {
            this.f43284a.g();
        }
        if (this.f18183a.zzc >= 4) {
            this.f43284a.j();
        }
        if (this.f18183a.zzc >= 5) {
            this.f43284a.f();
        }
    }
}
