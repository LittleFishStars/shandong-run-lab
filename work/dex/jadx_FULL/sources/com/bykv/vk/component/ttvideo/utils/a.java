package com.bykv.vk.component.ttvideo.utils;

import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f29294a = 1;
    private int b = 2;
    private int c = 2;
    private int d = 0;
    private long e = 0;

    public void a() {
        this.d = 0;
        if (this.c == this.f29294a) {
            this.e = SystemClock.elapsedRealtime();
        }
    }

    public int b() {
        if (this.c == this.f29294a) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            int i = (int) (jElapsedRealtime - this.e);
            if (i >= 0) {
                this.d += i;
            }
            this.e = jElapsedRealtime;
        }
        return this.d;
    }

    public void c() {
        this.c = this.b;
        this.d = 0;
        this.e = 0L;
    }

    public void d() {
        if (this.c == this.b) {
            this.c = this.f29294a;
            this.e = SystemClock.elapsedRealtime();
        }
    }

    public void e() {
        if (this.c == this.f29294a) {
            this.c = this.b;
            int iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - this.e);
            if (iElapsedRealtime >= 0) {
                this.d += iElapsedRealtime;
            }
        }
    }
}
