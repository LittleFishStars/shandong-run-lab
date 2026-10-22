package com.ipd.dsp.internal.c2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class n {
    public static final int h = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f38228a;
    public final long b;
    public long c;
    public long f;
    public boolean d = false;
    public volatile boolean e = false;

    @SuppressLint({"HandlerLeak"})
    public final Handler g = new a();

    public class a extends Handler {
        public a() {
        }

        public final long a(long j, long j2) {
            if (j < n.this.b) {
                long j3 = j - j2;
                if (j3 < 0) {
                    return 0L;
                }
                return j3;
            }
            long j4 = n.this.b - j2;
            while (j4 < 0) {
                j4 += n.this.b;
            }
            return j4;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            synchronized (n.this) {
                if (n.this.d) {
                    return;
                }
                if (n.this.e) {
                    return;
                }
                long jElapsedRealtime = n.this.c - SystemClock.elapsedRealtime();
                if (jElapsedRealtime <= 0) {
                    n.this.c();
                } else {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    n.this.b(jElapsedRealtime);
                    sendMessageDelayed(obtainMessage(1), a(jElapsedRealtime, SystemClock.elapsedRealtime() - jElapsedRealtime2));
                }
            }
        }
    }

    public n(long j, long j2) {
        this.f38228a = j;
        this.b = j2;
    }

    public abstract void a(long j);

    public abstract void c();

    public final synchronized void e() {
        if (this.f > 0) {
            this.c = (SystemClock.elapsedRealtime() + this.f) - this.b;
        }
        this.e = false;
        Handler handler = this.g;
        handler.sendMessage(handler.obtainMessage(1));
    }

    public final synchronized n f() {
        this.d = false;
        if (this.f38228a <= 0) {
            c();
            return this;
        }
        this.c = SystemClock.elapsedRealtime() + this.f38228a;
        Handler handler = this.g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }

    public final synchronized boolean b() {
        return this.e || this.d;
    }

    public final void d() {
        this.e = true;
    }

    public final synchronized void a() {
        this.d = true;
        this.g.removeMessages(1);
    }

    public final void b(long j) {
        this.f = j;
        a(j);
    }
}
