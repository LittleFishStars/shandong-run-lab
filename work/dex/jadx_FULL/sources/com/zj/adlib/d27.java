package com.zj.adlib;

import com.google.android.datatransport.runtime.dagger.Lazy;
import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d27<T> implements Provider<Lazy<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f41094a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Provider<T> f15917a;

    public d27(Provider<T> provider) {
        this.f15917a = provider;
    }

    public static <T> Provider<Lazy<T>> a(Provider<T> provider) {
        return new d27((Provider) xw6.b(provider));
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Lazy<T> get() {
        return op2.a(this.f15917a);
    }
}
