package com.ipd.dsp.internal.n0;

import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c {
    public static final String c = "FileLock";
    public static final long d = TimeUnit.MILLISECONDS.toNanos(100);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Map<String, AtomicInteger> f38461a;

    @NonNull
    public final Map<String, Thread> b;

    public c(@NonNull Map<String, AtomicInteger> map, @NonNull Map<String, Thread> map2) {
        this.f38461a = map;
        this.b = map2;
    }

    public void a(@NonNull String str) {
        AtomicInteger atomicInteger;
        Thread thread;
        synchronized (this.f38461a) {
            atomicInteger = this.f38461a.get(str);
        }
        if (atomicInteger == null || atomicInteger.decrementAndGet() != 0) {
            return;
        }
        com.ipd.dsp.internal.g0.c.a(c, "decreaseLock decrease lock-count to 0 " + str);
        synchronized (this.b) {
            thread = this.b.get(str);
            if (thread != null) {
                this.b.remove(str);
            }
        }
        if (thread != null) {
            com.ipd.dsp.internal.g0.c.a(c, "decreaseLock " + str + " unpark locked thread " + atomicInteger);
            a(thread);
        }
        synchronized (this.f38461a) {
            this.f38461a.remove(str);
        }
    }

    public void b(@NonNull String str) {
        AtomicInteger atomicInteger;
        synchronized (this.f38461a) {
            atomicInteger = this.f38461a.get(str);
        }
        if (atomicInteger == null) {
            atomicInteger = new AtomicInteger(0);
            synchronized (this.f38461a) {
                this.f38461a.put(str, atomicInteger);
            }
        }
        com.ipd.dsp.internal.g0.c.a(c, "increaseLock increase lock-count to " + atomicInteger.incrementAndGet() + str);
    }

    public void c(@NonNull String str) {
        AtomicInteger atomicInteger;
        synchronized (this.f38461a) {
            atomicInteger = this.f38461a.get(str);
        }
        if (atomicInteger == null || atomicInteger.get() <= 0) {
            return;
        }
        synchronized (this.b) {
            this.b.put(str, Thread.currentThread());
        }
        com.ipd.dsp.internal.g0.c.a(c, "waitForRelease start " + str);
        while (!a(atomicInteger)) {
            a();
        }
        com.ipd.dsp.internal.g0.c.a(c, "waitForRelease finish " + str);
    }

    public c() {
        this(new HashMap(), new HashMap());
    }

    public boolean a(AtomicInteger atomicInteger) {
        return atomicInteger.get() <= 0;
    }

    public void a() {
        LockSupport.park(Long.valueOf(d));
    }

    public void a(@NonNull Thread thread) {
        LockSupport.unpark(thread);
    }
}
