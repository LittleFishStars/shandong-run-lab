package com.beizi.fusion;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class o3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f27574a;
    private final int b;
    private final AtomicInteger c = new AtomicInteger(0);

    public o3(int i) {
        this.b = i;
        this.f27574a = new Object[i];
    }

    public void a(int i, Object obj) {
        if (i < 0 || i >= this.b) {
            return;
        }
        synchronized (this) {
            Object[] objArr = this.f27574a;
            if (objArr[i] == null) {
                objArr[i] = obj;
                this.c.incrementAndGet();
            } else {
                objArr[i] = obj;
            }
        }
    }

    public int b() {
        return this.b;
    }

    public boolean a() {
        return this.c.get() == this.b;
    }

    public Object a(int i) {
        Object obj;
        if (i < 0 || i >= this.b) {
            return null;
        }
        synchronized (this) {
            obj = this.f27574a[i];
        }
        return obj;
    }
}
