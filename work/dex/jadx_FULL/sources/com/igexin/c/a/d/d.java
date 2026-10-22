package com.igexin.c.a.d;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> f37841a;
    private final ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> b;
    private ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> c;

    public d() {
        ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f37841a = concurrentLinkedQueue;
        this.b = new ConcurrentLinkedQueue<>();
        this.c = concurrentLinkedQueue;
    }

    private synchronized Iterator<com.igexin.c.a.d.a.e> e() {
        return this.c.iterator();
    }

    public final synchronized void a() {
        this.c = this.f37841a;
    }

    public final synchronized void a(com.igexin.c.a.d.a.e eVar) {
        this.c.offer(eVar);
    }

    public final synchronized void b() {
        ConcurrentLinkedQueue<com.igexin.c.a.d.a.e> concurrentLinkedQueue = this.b;
        this.c = concurrentLinkedQueue;
        concurrentLinkedQueue.addAll(this.f37841a);
        this.f37841a.clear();
    }

    public final synchronized boolean c() {
        return this.c.isEmpty();
    }

    public final synchronized com.igexin.c.a.d.a.e d() {
        return this.c.poll();
    }
}
