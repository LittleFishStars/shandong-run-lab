package com.zj.adlib;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class rv7 implements Factory<SchedulerConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Clock> f44543a;

    public rv7(Provider<Clock> provider) {
        this.f44543a = provider;
    }

    public static SchedulerConfig a(Clock clock) {
        return (SchedulerConfig) xw6.c(SchedulingConfigModule.a(clock), "Cannot return null from a non-@Nullable @Provides method");
    }

    public static rv7 b(Provider<Clock> provider) {
        return new rv7(provider);
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public SchedulerConfig get() {
        return a((Clock) this.f44543a.get());
    }
}
