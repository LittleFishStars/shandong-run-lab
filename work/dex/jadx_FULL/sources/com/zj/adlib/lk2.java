package com.zj.adlib;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class lk2<T> implements Factory<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Provider<T> f43088a;

    public static <T> void b(Provider<T> provider, Provider<T> provider2) {
        xw6.b(provider2);
        lk2 lk2Var = (lk2) provider;
        if (lk2Var.f43088a != null) {
            throw new IllegalStateException();
        }
        lk2Var.f43088a = provider2;
    }

    public Provider<T> a() {
        return (Provider) xw6.b(this.f43088a);
    }

    @Deprecated
    public void c(Provider<T> provider) {
        b(this, provider);
    }

    public T get() {
        Provider<T> provider = this.f43088a;
        if (provider != null) {
            return (T) provider.get();
        }
        throw new IllegalStateException();
    }
}
