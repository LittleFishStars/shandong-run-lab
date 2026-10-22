package com.zj.adlib;

import com.google.android.exoplayer2.util.Clock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ps1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Clock f44050a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18922a;

    public ps1() {
        this(Clock.f31152a);
    }

    public synchronized void a() throws InterruptedException {
        while (!this.f18922a) {
            wait();
        }
    }

    public synchronized boolean b(long j) throws InterruptedException {
        try {
            if (j <= 0) {
                return this.f18922a;
            }
            long jElapsedRealtime = this.f44050a.elapsedRealtime();
            long j2 = j + jElapsedRealtime;
            if (j2 < jElapsedRealtime) {
                a();
            } else {
                while (!this.f18922a && jElapsedRealtime < j2) {
                    wait(j2 - jElapsedRealtime);
                    jElapsedRealtime = this.f44050a.elapsedRealtime();
                }
            }
            return this.f18922a;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void c() {
        boolean z = false;
        while (!this.f18922a) {
            try {
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean d() {
        boolean z;
        z = this.f18922a;
        this.f18922a = false;
        return z;
    }

    public synchronized boolean e() {
        return this.f18922a;
    }

    public synchronized boolean f() {
        if (this.f18922a) {
            return false;
        }
        this.f18922a = true;
        notifyAll();
        return true;
    }

    public ps1(Clock clock) {
        this.f44050a = clock;
    }
}
