package com.google.android.gms.dynamic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e implements zah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeferredLifecycleHelper f31323a;

    public e(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f31323a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f31323a.f5710a.onStart();
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 4;
    }
}
