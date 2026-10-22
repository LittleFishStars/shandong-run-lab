package com.zj.adlib;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class kh9 implements SynchronizationGuard.CriticalSection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42821a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TransportContext f17681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lh9 f17682a;

    public kh9(lh9 lh9Var, TransportContext transportContext, int i) {
        this.f17682a = lh9Var;
        this.f17681a = transportContext;
        this.f42821a = i;
    }

    public static SynchronizationGuard.CriticalSection b(lh9 lh9Var, TransportContext transportContext, int i) {
        return new kh9(lh9Var, transportContext, i);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object a() {
        return lh9.d(this.f17682a, this.f17681a, this.f42821a);
    }
}
