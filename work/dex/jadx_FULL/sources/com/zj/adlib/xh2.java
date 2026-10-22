package com.zj.adlib;

import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class xh2 implements SynchronizationGuard.CriticalSection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventInternal f45823a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TransportContext f20663a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zh2 f20664a;

    public xh2(zh2 zh2Var, TransportContext transportContext, EventInternal eventInternal) {
        this.f20664a = zh2Var;
        this.f20663a = transportContext;
        this.f45823a = eventInternal;
    }

    public static SynchronizationGuard.CriticalSection b(zh2 zh2Var, TransportContext transportContext, EventInternal eventInternal) {
        return new xh2(zh2Var, transportContext, eventInternal);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object a() {
        return zh2.b(this.f20664a, this.f20663a, this.f45823a);
    }
}
