package com.zj.adlib;

import com.amap.api.col.p0003l.ip;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class p6b extends ip {
    public static int c = 10000000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f43916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f18797a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18798a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f18799b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f18800b;

    public p6b(boolean z, ip ipVar, long j, int i) {
        super(ipVar);
        this.f18800b = false;
        this.f18798a = z;
        this.f43916a = 600000;
        this.f18799b = j;
        this.b = i;
    }

    @Override // com.amap.api.col.p0003l.ip
    public final int a() {
        return 320000;
    }

    @Override // com.amap.api.col.p0003l.ip
    public final boolean c() {
        if (this.f18800b && this.f18799b <= this.b) {
            return true;
        }
        if (!this.f18798a || this.f18799b >= this.b) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f18797a < this.f43916a) {
            return false;
        }
        this.f18797a = jCurrentTimeMillis;
        return true;
    }

    public final void e(int i) {
        if (i <= 0) {
            return;
        }
        this.f18799b += (long) i;
    }

    public final void f(boolean z) {
        this.f18800b = z;
    }

    public final long g() {
        return this.f18799b;
    }
}
