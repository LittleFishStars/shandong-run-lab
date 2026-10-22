package com.zj.adlib;

import androidx.annotation.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class g89 {
    public static final long d = Long.MAX_VALUE;
    public static final long e = 9223372036854775806L;
    public static final long f = 8589934592L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public long f41845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ThreadLocal<Long> f16724a = new ThreadLocal<>();

    @GuardedBy("this")
    public long b;

    @GuardedBy("this")
    public long c;

    public g89(long j) {
        g(j);
    }

    public static long f(long j) {
        return (j * 1000000) / 90000;
    }

    public static long i(long j) {
        return (j * 90000) / 1000000;
    }

    public static long j(long j) {
        return i(j) % f;
    }

    public synchronized long a(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.b == -9223372036854775807L) {
            long jLongValue = this.f41845a;
            if (jLongValue == 9223372036854775806L) {
                jLongValue = ((Long) sb0.g(this.f16724a.get())).longValue();
            }
            this.b = jLongValue - j;
            notifyAll();
        }
        this.c = j;
        return j + this.b;
    }

    public synchronized long b(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.c;
        if (j2 != -9223372036854775807L) {
            long jI = i(j2);
            long j3 = (4294967296L + jI) / f;
            long j4 = ((j3 - 1) * f) + j;
            j += j3 * f;
            if (Math.abs(j4 - jI) < Math.abs(j - jI)) {
                j = j4;
            }
        }
        return a(f(j));
    }

    public synchronized long c() {
        long j;
        j = this.f41845a;
        if (j == Long.MAX_VALUE || j == 9223372036854775806L) {
            j = -9223372036854775807L;
        }
        return j;
    }

    public synchronized long d() {
        long j;
        j = this.c;
        return j != -9223372036854775807L ? j + this.b : c();
    }

    public synchronized long e() {
        return this.b;
    }

    public synchronized void g(long j) {
        this.f41845a = j;
        this.b = j == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.c = -9223372036854775807L;
    }

    public synchronized void h(boolean z, long j) throws InterruptedException {
        sb0.i(this.f41845a == 9223372036854775806L);
        if (this.b != -9223372036854775807L) {
            return;
        }
        if (z) {
            this.f16724a.set(Long.valueOf(j));
        } else {
            while (this.b == -9223372036854775807L) {
                wait();
            }
        }
    }
}
