package com.zj.adlib;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class un5 implements Factory<tn5> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Provider<Context> f45185a;
    public final Provider<ux1> b;

    public un5(Provider<Context> provider, Provider<ux1> provider2) {
        this.f45185a = provider;
        this.b = provider2;
    }

    public static un5 a(Provider<Context> provider, Provider<ux1> provider2) {
        return new un5(provider, provider2);
    }

    public static tn5 c(Context context, Object obj) {
        return new tn5(context, (ux1) obj);
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public tn5 get() {
        return c((Context) this.f45185a.get(), this.b.get());
    }
}
