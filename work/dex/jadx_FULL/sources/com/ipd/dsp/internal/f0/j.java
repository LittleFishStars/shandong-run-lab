package com.ipd.dsp.internal.f0;

import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f38304a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;

    public synchronized void a(long j) {
        if (this.f38304a == 0) {
            long jL = l();
            this.f38304a = jL;
            this.d = jL;
        }
        this.b += j;
        this.f += j;
    }

    public synchronized void b() {
        this.e = l();
    }

    public synchronized void c() {
        long jL = l();
        long j = this.b;
        long jMax = Math.max(1L, jL - this.f38304a);
        this.b = 0L;
        this.f38304a = jL;
        this.c = (long) ((j / jMax) * 1000.0f);
    }

    public synchronized long d() {
        long jL = l() - this.f38304a;
        if (jL < 1000) {
            long j = this.c;
            if (j != 0) {
                return j;
            }
        }
        if (this.c == 0 && jL < 500) {
            return 0L;
        }
        return f();
    }

    public synchronized long e() {
        long jL;
        jL = this.e;
        if (jL == 0) {
            jL = l();
        }
        return (long) ((this.f / Math.max(1L, jL - this.d)) * 1000.0f);
    }

    public long f() {
        c();
        return this.c;
    }

    public synchronized long g() {
        return l() - this.f38304a;
    }

    public String h() {
        return a(f(), false);
    }

    public String i() {
        return a(f(), true);
    }

    public String j() {
        return i();
    }

    public String k() {
        return a(this.c, true);
    }

    public long l() {
        return SystemClock.uptimeMillis();
    }

    public synchronized void m() {
        this.f38304a = 0L;
        this.b = 0L;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
    }

    public String n() {
        return a(d(), true);
    }

    public String o() {
        return a(e(), true);
    }

    public String a() {
        return o();
    }

    public static String a(long j, boolean z) {
        return com.ipd.dsp.internal.g0.c.a(j, z) + "/s";
    }
}
