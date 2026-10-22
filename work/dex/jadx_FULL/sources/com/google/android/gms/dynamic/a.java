package com.google.android.gms.dynamic;

import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements OnDelegateCreatedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DeferredLifecycleHelper f31319a;

    public a(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f31319a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.OnDelegateCreatedListener
    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f31319a.f5710a = lifecycleDelegate;
        Iterator it = this.f31319a.f5712a.iterator();
        while (it.hasNext()) {
            ((zah) it.next()).a(this.f31319a.f5710a);
        }
        this.f31319a.f5712a.clear();
        this.f31319a.f31317a = null;
    }
}
