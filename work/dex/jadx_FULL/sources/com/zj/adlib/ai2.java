package com.zj.adlib;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ai2 implements Factory<zh2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Executor> f40536a;
    public final Provider<BackendRegistry> b;
    public final Provider<WorkScheduler> c;
    public final Provider<EventStore> d;
    public final Provider<SynchronizationGuard> e;

    public ai2(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        this.f40536a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static ai2 a(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        return new ai2(provider, provider2, provider3, provider4, provider5);
    }

    public static zh2 c(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new zh2(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public zh2 get() {
        return c((Executor) this.f40536a.get(), (BackendRegistry) this.b.get(), (WorkScheduler) this.c.get(), (EventStore) this.d.get(), (SynchronizationGuard) this.e.get());
    }
}
