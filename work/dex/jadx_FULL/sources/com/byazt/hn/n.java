package com.byazt.hn;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 25, 46})
public final class n {
    public static HandlerThread c;
    public static Handler tt;
    public volatile int da;
    public long i;
    public volatile int sl;
    public final uj ve;
    public volatile boolean x;
    public a uj = new a();
    public a n = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f28615a = new a();
    public final Object sp = new Object();
    public final Runnable t = new Runnable() { // from class: com.byazt.hn.n.1
        @Override // java.lang.Runnable
        public void run() {
            float f;
            if (n.this.x) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                if (n.this.i == 0) {
                    f = 0.016f;
                } else {
                    f = (jUptimeMillis - n.this.i) / 1000.0f;
                    if (f > 0.033333335f) {
                        f = 0.033333335f;
                    }
                }
                n.this.i = jUptimeMillis;
                n.this.ve.c(n.this.da, n.this.sl);
                n.this.ve.update(f);
                n.this.ve.c(n.this.uj);
                synchronized (n.this.sp) {
                    a aVar = n.this.n;
                    n nVar = n.this;
                    nVar.n = nVar.uj;
                    n.this.uj = aVar;
                }
                if (n.this.x) {
                    n.x().postDelayed(this, 16L);
                }
            }
        }
    };

    public n(tt ttVar) {
        this.ve = new uj(ttVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized Handler x() {
        if (c == null) {
            HandlerThread handlerThread = new HandlerThread("ugen-particle-physics", 10);
            c = handlerThread;
            handlerThread.start();
            tt = new Handler(c.getLooper());
        }
        return tt;
    }

    public void a() {
        n();
        synchronized (this.sp) {
            this.uj = new a();
            this.n = new a();
            this.f28615a = new a();
        }
    }

    public void n() {
        this.x = false;
        x().removeCallbacks(this.t);
    }

    public void uj() {
        if (this.x) {
            return;
        }
        this.x = true;
        this.i = 0L;
        x().post(this.t);
    }

    public tt.uj[] ve() {
        return this.ve.c();
    }

    public tt tt() {
        return this.ve.tt();
    }

    public void c(int i, int i2) {
        this.da = i;
        this.sl = i2;
    }

    public a c() {
        a aVar;
        synchronized (this.sp) {
            a aVar2 = this.f28615a;
            aVar = this.n;
            this.f28615a = aVar;
            this.n = aVar2;
        }
        return aVar;
    }
}
