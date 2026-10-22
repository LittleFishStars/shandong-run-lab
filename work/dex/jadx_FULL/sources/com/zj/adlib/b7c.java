package com.zj.adlib;

import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.zzb;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b7c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LifecycleCallback f40693a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zzb f15460a;
    public final /* synthetic */ String f;

    public b7c(zzb zzbVar, LifecycleCallback lifecycleCallback, String str) {
        this.f15460a = zzbVar;
        this.f40693a = lifecycleCallback;
        this.f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzb zzbVar = this.f15460a;
        if (zzbVar.K > 0) {
            this.f40693a.e(zzbVar.f5618a != null ? zzbVar.f5618a.getBundle(this.f) : null);
        }
        if (this.f15460a.K >= 2) {
            this.f40693a.i();
        }
        if (this.f15460a.K >= 3) {
            this.f40693a.g();
        }
        if (this.f15460a.K >= 4) {
            this.f40693a.j();
        }
        if (this.f15460a.K >= 5) {
            this.f40693a.f();
        }
    }
}
