package com.aliyun.svideosdk.a.d;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f25607a = false;
    private long b = 0;
    private long c = 0;
    private volatile int d = 0;
    private volatile long e = 0;
    private volatile long f = 0;
    private volatile int g = 0;
    private volatile float h = 0.0f;
    private long i = 0;

    @Override // com.aliyun.svideosdk.a.d.a
    public synchronized void a() {
        if (this.f25607a) {
            this.e = (long) ((this.b * 1.0f) / this.g);
            this.h = (this.g * 1000.0f) / (System.currentTimeMillis() - this.i);
            this.f25607a = false;
        }
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public synchronized void b() {
        if (this.f25607a) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
            this.b += jCurrentTimeMillis;
            this.g++;
            if (jCurrentTimeMillis >= 80) {
                this.d++;
            }
            if (jCurrentTimeMillis > this.f) {
                this.f = jCurrentTimeMillis;
            }
        }
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public synchronized void c() {
        if (this.f25607a) {
            this.c = System.currentTimeMillis();
        }
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public long d() {
        return this.e;
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public int e() {
        return this.d;
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public synchronized void f() {
        if (!this.f25607a) {
            this.h = 0.0f;
            this.i = System.currentTimeMillis();
            this.b = 0L;
            this.f = 0L;
            this.e = 0L;
            this.g = 0;
            this.d = 0;
            this.f25607a = true;
        }
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public float g() {
        return this.h;
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public long h() {
        return this.f;
    }

    @Override // com.aliyun.svideosdk.a.d.a
    public int i() {
        return this.g;
    }
}
