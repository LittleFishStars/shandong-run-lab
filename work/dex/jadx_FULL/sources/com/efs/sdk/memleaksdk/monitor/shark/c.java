package com.efs.sdk.memleaksdk.monitor.shark;

import android.os.Handler;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class c<C> extends b<C> implements Callable<a> {
    private volatile boolean b = true;
    private final Runnable c = new Runnable() { // from class: com.efs.sdk.memleaksdk.monitor.internal.c.1
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (c.this.call() == a.Terminate || c.this.b) {
                    return;
                }
                Handler handlerA = d.a();
                handlerA.removeCallbacks(this);
                handlerA.postDelayed(this, c.this.b());
            } catch (Throwable unused) {
            }
        }
    };

    public enum a {
        Continue,
        Terminate
    }

    public long b() {
        return 1000L;
    }

    public void c() {
        this.b = true;
        d.a().removeCallbacks(this.c);
    }

    public void a(long j) {
        Handler handlerA = d.a();
        handlerA.removeCallbacks(this.c);
        handlerA.postDelayed(this.c, j);
        this.b = false;
    }
}
