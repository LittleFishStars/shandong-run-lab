package com.zj.adlib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class k59 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f17584a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17585a = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<Runnable> f42745a = new ArrayList<>();

    public k59(Executor executor) {
        this.f17584a = (Executor) ax6.i(executor);
    }

    public synchronized void a(Runnable runnable) {
        if (this.f17585a) {
            this.f42745a.add(runnable);
        } else {
            this.f17584a.execute(runnable);
        }
    }

    public final void b() {
        Iterator<Runnable> it = this.f42745a.iterator();
        while (it.hasNext()) {
            this.f17584a.execute(it.next());
        }
        this.f42745a.clear();
    }

    public synchronized boolean c() {
        return this.f17585a;
    }

    public void d(Runnable runnable) {
        this.f42745a.remove(runnable);
    }

    public synchronized void e() {
        this.f17585a = true;
    }

    public synchronized void f() {
        this.f17585a = false;
        b();
    }
}
