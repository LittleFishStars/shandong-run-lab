package com.alibaba.ariver.v8worker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f24525a = new Object();
    boolean b;
    long c;
    long d;
    boolean e;
    private long f;

    public void a(long j) {
        synchronized (this.f24525a) {
            this.f = j;
        }
    }

    public long b() {
        long j;
        synchronized (this.f24525a) {
            j = this.c;
        }
        return j;
    }

    public boolean c() {
        boolean z;
        synchronized (this.f24525a) {
            z = this.c > 0 || this.f > 0;
        }
        return z;
    }

    public long d() {
        long j;
        synchronized (this.f24525a) {
            j = this.f;
        }
        return j;
    }

    @Override // java.lang.Runnable
    public abstract void run();

    public boolean a() {
        boolean z;
        synchronized (this.f24525a) {
            z = !this.b && this.c > 0;
            this.b = true;
        }
        return z;
    }
}
