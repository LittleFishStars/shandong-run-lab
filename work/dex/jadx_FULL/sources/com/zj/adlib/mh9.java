package com.zj.adlib;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class mh9 implements Factory<lh9> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Context> f43301a;
    public final Provider<BackendRegistry> b;
    public final Provider<EventStore> c;
    public final Provider<WorkScheduler> d;
    public final Provider<Executor> e;
    public final Provider<SynchronizationGuard> f;
    public final Provider<Clock> g;

    public mh9(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7) {
        this.f43301a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
        this.f = provider6;
        this.g = provider7;
    }

    public static mh9 a(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7) {
        return new mh9(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static lh9 c(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock) {
        return new lh9(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public lh9 get() {
        return c((Context) this.f43301a.get(), (BackendRegistry) this.b.get(), (EventStore) this.c.get(), (WorkScheduler) this.d.get(), (Executor) this.e.get(), (SynchronizationGuard) this.f.get(), (Clock) this.g.get());
    }
}
