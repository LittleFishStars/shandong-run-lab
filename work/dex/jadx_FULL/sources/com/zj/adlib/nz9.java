package com.zj.adlib;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class nz9 implements Factory<mz9> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Executor> f43634a;
    public final Provider<EventStore> b;
    public final Provider<WorkScheduler> c;
    public final Provider<SynchronizationGuard> d;

    public nz9(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        this.f43634a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static nz9 a(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        return new nz9(provider, provider2, provider3, provider4);
    }

    public static mz9 c(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new mz9(executor, eventStore, workScheduler, synchronizationGuard);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public mz9 get() {
        return c((Executor) this.f43634a.get(), (EventStore) this.b.get(), (WorkScheduler) this.c.get(), (SynchronizationGuard) this.d.get());
    }
}
