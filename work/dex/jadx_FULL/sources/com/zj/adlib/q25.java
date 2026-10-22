package com.zj.adlib;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class q25 {
    public static final int b = 32;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f44110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f18995a;

    public q25() {
        this(32);
    }

    public void a(long j) {
        int i = this.f44110a;
        long[] jArr = this.f18995a;
        if (i == jArr.length) {
            this.f18995a = Arrays.copyOf(jArr, i * 2);
        }
        long[] jArr2 = this.f18995a;
        int i2 = this.f44110a;
        this.f44110a = i2 + 1;
        jArr2[i2] = j;
    }

    public long b(int i) {
        if (i >= 0 && i < this.f44110a) {
            return this.f18995a[i];
        }
        throw new IndexOutOfBoundsException("Invalid index " + i + ", size is " + this.f44110a);
    }

    public int c() {
        return this.f44110a;
    }

    public long[] d() {
        return Arrays.copyOf(this.f18995a, this.f44110a);
    }

    public q25(int i) {
        this.f18995a = new long[i];
    }
}
