package com.beizi.fusion;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class yk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f28071a;
    private final long b;
    private long c;
    private long d;
    private long e;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;
    private final Handler i = new a(Looper.getMainLooper());

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (yk.this) {
                yk ykVar = yk.this;
                if (ykVar.g) {
                    return;
                }
                if (ykVar.f) {
                    return;
                }
                long jElapsedRealtime = (ykVar.c + ykVar.e) - SystemClock.elapsedRealtime();
                long j = 0;
                if (jElapsedRealtime <= 0) {
                    yk ykVar2 = yk.this;
                    ykVar2.h = false;
                    ykVar2.e = 0L;
                    ykVar2.d();
                } else {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    yk.this.a(jElapsedRealtime);
                    long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime2;
                    long j2 = yk.this.b;
                    if (jElapsedRealtime < j2) {
                        long j3 = jElapsedRealtime - jElapsedRealtime3;
                        if (j3 >= 0) {
                            j = j3;
                        }
                    } else {
                        long j4 = j2 - jElapsedRealtime3;
                        while (j4 < 0) {
                            j4 += yk.this.b;
                        }
                        j = j4;
                    }
                    sendMessageDelayed(obtainMessage(1), j);
                }
            }
        }
    }

    public yk(long j, long j2) {
        this.f28071a = j;
        this.b = j2;
    }

    public final synchronized void a() {
        this.g = true;
        this.i.removeMessages(1);
        c();
    }

    public abstract void a(long j);

    public final boolean b() {
        return this.h;
    }

    public abstract void c();

    public abstract void d();

    public final synchronized void e() {
        if (this.h) {
            this.f = true;
            this.d = SystemClock.elapsedRealtime();
        }
    }

    public final synchronized void f() {
        if (this.f) {
            this.f = false;
            this.e = (SystemClock.elapsedRealtime() - this.d) + this.e;
            Handler handler = this.i;
            handler.sendMessage(handler.obtainMessage(1));
        }
    }

    public final synchronized yk g() {
        this.e = 0L;
        if (this.h) {
            return this;
        }
        this.g = false;
        this.h = true;
        if (this.f28071a <= 0) {
            this.h = false;
            d();
            return this;
        }
        this.c = SystemClock.elapsedRealtime() + this.f28071a;
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
