package com.alibaba.ariver.commonability.core;

import com.alibaba.ariver.kernel.common.RVProxy;
import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationHandler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected SoftReference<T> f23940a = new SoftReference<>(null);
    protected Class<T> b;

    public c() {
    }

    public Class<T> a() {
        return this.b;
    }

    public T b() {
        return a(false);
    }

    public T a(Class<T> cls, boolean z) {
        T t = this.f23940a.get();
        if (t != null && (!z || !(t instanceof InvocationHandler))) {
            return t;
        }
        T t2 = (T) RVProxy.get(cls, z);
        if (t2 != null) {
            this.f23940a = new SoftReference<>(t2);
        }
        return t2;
    }

    public c(Class<T> cls) {
        this.b = cls;
    }

    public T a(boolean z) {
        Class<T> clsA = a();
        if (clsA == null) {
            return null;
        }
        return a(clsA, z);
    }
}
