package com.zj.adlib;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class sv7 implements Factory<WorkScheduler> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Context> f44783a;
    public final Provider<EventStore> b;
    public final Provider<SchedulerConfig> c;
    public final Provider<Clock> d;

    public sv7(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        this.f44783a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
    }

    public static sv7 a(Provider<Context> provider, Provider<EventStore> provider2, Provider<SchedulerConfig> provider3, Provider<Clock> provider4) {
        return new sv7(provider, provider2, provider3, provider4);
    }

    public static WorkScheduler c(Context context, EventStore eventStore, SchedulerConfig schedulerConfig, Clock clock) {
        return (WorkScheduler) xw6.c(SchedulingModule.b(context, eventStore, schedulerConfig, clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public WorkScheduler get() {
        return c((Context) this.f44783a.get(), (EventStore) this.b.get(), (SchedulerConfig) this.c.get(), (Clock) this.d.get());
    }
}
