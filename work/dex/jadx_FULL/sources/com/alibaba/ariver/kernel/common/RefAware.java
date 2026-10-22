package com.alibaba.ariver.kernel.common;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RefAware<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f24230a = new AtomicInteger(0);
    private final T b;

    public RefAware(T t) {
        this.b = t;
    }

    public boolean decrementRef() {
        return this.f24230a.get() == 0 || this.f24230a.decrementAndGet() == 0;
    }

    public T get() {
        return this.b;
    }

    public void incrementRef() {
        this.f24230a.incrementAndGet();
    }
}
