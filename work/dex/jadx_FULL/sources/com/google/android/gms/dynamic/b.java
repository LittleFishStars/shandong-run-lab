package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements zah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f31320a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Bundle f5714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ DeferredLifecycleHelper f5715a;
    public final /* synthetic */ Bundle b;

    public b(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f5715a = deferredLifecycleHelper;
        this.f31320a = activity;
        this.f5714a = bundle;
        this.b = bundle2;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f5715a.f5710a.a(this.f31320a, this.f5714a, this.b);
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 0;
    }
}
