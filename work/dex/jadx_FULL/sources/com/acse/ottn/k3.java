package com.acse.ottn;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class k3<T, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23072a;
    public final Class<V> b;

    public k3(Class<V> cls, String str) {
        this.f23072a = str;
        this.b = cls;
    }

    public static <T, V> k3<T, V> a(Class<T> cls, Class<V> cls2, String str) {
        return new p3(cls, cls2, str);
    }

    public abstract V a(T t);

    public Class<V> b() {
        return this.b;
    }

    public boolean c() {
        return false;
    }

    public void a(T t, V v) {
        throw new UnsupportedOperationException("Property " + a() + " is read-only");
    }

    public String a() {
        return this.f23072a;
    }
}
