package com.zj.adlib;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.h;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hc9 implements Factory<h> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Clock> f42098a;
    public final Provider<Clock> b;
    public final Provider<Scheduler> c;
    public final Provider<lh9> d;
    public final Provider<mz9> e;

    public hc9(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<lh9> provider4, Provider<mz9> provider5) {
        this.f42098a = provider;
        this.b = provider2;
        this.c = provider3;
        this.d = provider4;
        this.e = provider5;
    }

    public static hc9 a(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<lh9> provider4, Provider<mz9> provider5) {
        return new hc9(provider, provider2, provider3, provider4, provider5);
    }

    public static h c(Clock clock, Clock clock2, Scheduler scheduler, lh9 lh9Var, mz9 mz9Var) {
        return new h(clock, clock2, scheduler, lh9Var, mz9Var);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h get() {
        return c((Clock) this.f42098a.get(), (Clock) this.b.get(), (Scheduler) this.c.get(), (lh9) this.d.get(), (mz9) this.e.get());
    }
}
