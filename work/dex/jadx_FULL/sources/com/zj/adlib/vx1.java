package com.zj.adlib;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class vx1 implements Factory<ux1> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Context> f45478a;
    public final Provider<Clock> b;
    public final Provider<Clock> c;

    public vx1(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        this.f45478a = provider;
        this.b = provider2;
        this.c = provider3;
    }

    public static vx1 a(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        return new vx1(provider, provider2, provider3);
    }

    public static ux1 c(Context context, Clock clock, Clock clock2) {
        return new ux1(context, clock, clock2);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ux1 get() {
        return c((Context) this.f45478a.get(), (Clock) this.b.get(), (Clock) this.c.get());
    }
}
