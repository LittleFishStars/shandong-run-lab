package com.google.android.gms.dynamic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f implements zah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeferredLifecycleHelper f31324a;

    public f(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f31324a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f31324a.f5710a.onResume();
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 5;
    }
}
