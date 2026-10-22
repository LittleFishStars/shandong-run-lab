package com.zj.adlib;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.Factory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jb4<T> implements Factory<T>, Lazy<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final jb4<Object> f42548a = new jb4<>(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final T f17351a;

    public jb4(T t) {
        this.f17351a = t;
    }

    public static <T> Factory<T> a(T t) {
        return new jb4(xw6.c(t, "instance cannot be null"));
    }

    public static <T> Factory<T> b(T t) {
        return t == null ? c() : new jb4(t);
    }

    public static <T> jb4<T> c() {
        return (jb4<T>) f42548a;
    }

    @Override // com.google.android.datatransport.runtime.dagger.Lazy
    public T get() {
        return this.f17351a;
    }
}
