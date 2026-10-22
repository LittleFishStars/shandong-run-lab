package com.zj.adlib;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class hh9 implements SynchronizationGuard.CriticalSection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransportContext f42126a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lh9 f16985a;

    public hh9(lh9 lh9Var, TransportContext transportContext) {
        this.f16985a = lh9Var;
        this.f42126a = transportContext;
    }

    public static SynchronizationGuard.CriticalSection b(lh9 lh9Var, TransportContext transportContext) {
        return new hh9(lh9Var, transportContext);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object a() {
        return this.f16985a.f17948a.T(this.f42126a);
    }
}
