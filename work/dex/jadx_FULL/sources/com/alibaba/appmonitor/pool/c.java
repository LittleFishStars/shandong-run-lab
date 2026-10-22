package com.alibaba.appmonitor.pool;

import com.alibaba.appmonitor.pool.b;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c<T extends b> {
    private static AtomicLong c = new AtomicLong(0);
    private static AtomicLong d = new AtomicLong(0);
    private final int P = 20;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private AtomicLong f677a = new AtomicLong(0);
    private AtomicLong b = new AtomicLong(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConcurrentLinkedQueue<T> f23808a = new ConcurrentLinkedQueue<>();

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    private Set<Integer> f678d = new HashSet();

    public T a() {
        c.getAndIncrement();
        this.f677a.getAndIncrement();
        T tPoll = this.f23808a.poll();
        if (tPoll != null) {
            this.f678d.remove(Integer.valueOf(System.identityHashCode(tPoll)));
            this.b.getAndIncrement();
            d.getAndIncrement();
        }
        return tPoll;
    }

    public void a(T t) {
        t.clean();
        if (this.f23808a.size() < 20) {
            synchronized (this.f678d) {
                int iIdentityHashCode = System.identityHashCode(t);
                if (!this.f678d.contains(Integer.valueOf(iIdentityHashCode))) {
                    this.f678d.add(Integer.valueOf(iIdentityHashCode));
                    this.f23808a.offer(t);
                }
            }
        }
    }
}
