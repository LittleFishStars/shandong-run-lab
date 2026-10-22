package com.ipd.dsp.internal.h0;

import androidx.annotation.IntRange;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @IntRange(from = 0)
    public final long f38315a;

    @IntRange(from = 0)
    public final long b;
    public final AtomicLong c;

    public a(long j, long j2) {
        this(j, j2, 0L);
    }

    public void a(@IntRange(from = 1) long j) {
        this.c.addAndGet(j);
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.c.get();
    }

    public long d() {
        return this.f38315a + this.c.get();
    }

    public long e() {
        return (this.f38315a + this.b) - 1;
    }

    public long f() {
        return this.f38315a;
    }

    public void g() {
        this.c.set(0L);
    }

    public String toString() {
        return "[" + this.f38315a + ", " + e() + ")-current:" + this.c;
    }

    public a(long j, long j2, @IntRange(from = 0) long j3) {
        if (j < 0 || ((j2 < 0 && j2 != -1) || j3 < 0)) {
            throw new IllegalArgumentException();
        }
        this.f38315a = j;
        this.b = j2;
        this.c = new AtomicLong(j3);
    }

    public a a() {
        return new a(this.f38315a, this.b, this.c.get());
    }
}
