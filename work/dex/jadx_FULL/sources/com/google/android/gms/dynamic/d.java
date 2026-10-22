package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d implements zah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f31322a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ LayoutInflater f5717a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ViewGroup f5718a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ FrameLayout f5719a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ DeferredLifecycleHelper f5720a;

    public d(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f5720a = deferredLifecycleHelper;
        this.f5719a = frameLayout;
        this.f5717a = layoutInflater;
        this.f5718a = viewGroup;
        this.f31322a = bundle;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void a(LifecycleDelegate lifecycleDelegate) {
        this.f5719a.removeAllViews();
        this.f5719a.addView(this.f5720a.f5710a.onCreateView(this.f5717a, this.f5718a, this.f31322a));
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 2;
    }
}
