package com.zj.adlib;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class ih9 implements SynchronizationGuard.CriticalSection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f42359a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TransportContext f17209a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BackendResponse f17210a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final lh9 f17211a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Iterable f17212a;

    public ih9(lh9 lh9Var, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        this.f17211a = lh9Var;
        this.f17210a = backendResponse;
        this.f17212a = iterable;
        this.f17209a = transportContext;
        this.f42359a = i;
    }

    public static SynchronizationGuard.CriticalSection b(lh9 lh9Var, BackendResponse backendResponse, Iterable iterable, TransportContext transportContext, int i) {
        return new ih9(lh9Var, backendResponse, iterable, transportContext, i);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object a() {
        return lh9.c(this.f17211a, this.f17210a, this.f17212a, this.f17209a, this.f42359a);
    }
}
