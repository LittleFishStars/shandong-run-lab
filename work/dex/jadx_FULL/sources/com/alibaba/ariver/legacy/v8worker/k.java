package com.alibaba.ariver.legacy.v8worker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f24323a = new Object();
    boolean b;
    long c;
    long d;
    boolean e;
    private long f;

    public void a(long j) {
        synchronized (this.f24323a) {
            this.f = j;
        }
    }

    public long b() {
        long j;
        synchronized (this.f24323a) {
            j = this.c;
        }
        return j;
    }

    public boolean c() {
        boolean z;
        synchronized (this.f24323a) {
            z = this.c > 0 || this.f > 0;
        }
        return z;
    }

    public long d() {
        long j;
        synchronized (this.f24323a) {
            j = this.f;
        }
        return j;
    }

    @Override // java.lang.Runnable
    public abstract void run();

    public boolean a() {
        boolean z;
        synchronized (this.f24323a) {
            z = !this.b && this.c > 0;
            this.b = true;
        }
        return z;
    }
}
