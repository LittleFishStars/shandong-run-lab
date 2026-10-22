package com.zj.adlib;

import javax.inject.Provider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class rh8<T> implements Provider<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ boolean f44456a = false;
    public static final Object b = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile Object f19322a = b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile Provider<T> f19323a;

    public rh8(Provider<T> provider) {
        this.f19323a = provider;
    }

    public static <P extends Provider<T>, T> Provider<T> a(P p) {
        return ((p instanceof rh8) || (p instanceof op2)) ? p : new rh8((Provider) xw6.b(p));
    }

    public T get() {
        T t = (T) this.f19322a;
        if (t != b) {
            return t;
        }
        Provider<T> provider = this.f19323a;
        if (provider == null) {
            return (T) this.f19322a;
        }
        T t2 = (T) provider.get();
        this.f19322a = t2;
        this.f19323a = null;
        return t2;
    }
}
