package com.aliyun.common.e;

import com.aliyun.common.utils.c;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicInteger f25572a;

    public a() {
        AtomicInteger atomicInteger = new AtomicInteger();
        this.f25572a = atomicInteger;
        atomicInteger.set(1);
    }

    public abstract void a();

    public final void b() {
        c.a(this.f25572a.incrementAndGet(), 1);
    }

    public final void c() {
        int iDecrementAndGet = this.f25572a.decrementAndGet();
        if (iDecrementAndGet == 0) {
            a();
        } else {
            c.a(iDecrementAndGet, 0);
        }
    }
}
