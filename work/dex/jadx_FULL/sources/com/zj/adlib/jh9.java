package com.zj.adlib;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final /* synthetic */ class jh9 implements SynchronizationGuard.CriticalSection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventStore f42587a;

    public jh9(EventStore eventStore) {
        this.f42587a = eventStore;
    }

    public static SynchronizationGuard.CriticalSection b(EventStore eventStore) {
        return new jh9(eventStore);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    public Object a() {
        return Integer.valueOf(this.f42587a.O());
    }
}
