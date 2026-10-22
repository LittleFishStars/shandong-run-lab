package com.google.android.gms.dynamic;

import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements zah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f31321a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ DeferredLifecycleHelper f5716a;

    public c(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.f5716a = deferredLifecycleHelper;
        this.f31321a = bundle;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f5716a.f5710a.onCreate(this.f31321a);
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 1;
    }
}
