package com.ipd.dsp.internal.v0;

import com.ipd.dsp.Dsp;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class j {
    public static final String i = "ProxyCache";
    public static final int j = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f38568a;
    public final com.ipd.dsp.internal.v0.a b;
    public volatile Thread f;
    public volatile boolean g;
    public final Object c = new Object();
    public final Object d = new Object();
    public volatile int h = -1;
    public final AtomicInteger e = new AtomicInteger();

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.e();
        }
    }

    public j(m mVar, com.ipd.dsp.internal.v0.a aVar) {
        this.f38568a = (m) i.a(mVar);
        this.b = (com.ipd.dsp.internal.v0.a) i.a(aVar);
    }

    public void a(int i2) {
    }

    public void b(long j2, long j3) {
        int i2 = j3 == 0 ? 100 : (int) ((j2 / j3) * 100.0f);
        boolean z = i2 != this.h;
        if (j3 >= 0 && z) {
            a(i2);
        }
        this.h = i2;
    }

    public final boolean c() {
        return Thread.currentThread().isInterrupted() || this.g;
    }

    public final void d() {
        this.h = 100;
        a(this.h);
    }

    public final void e() {
        long length = -1;
        long jAvailable = 0;
        try {
            jAvailable = this.b.available();
            this.f38568a.a(jAvailable);
            length = this.f38568a.length();
            byte[] bArr = new byte[8192];
            while (true) {
                int i2 = this.f38568a.read(bArr);
                if (i2 == -1) {
                    h();
                    d();
                    b();
                    a(jAvailable, length);
                    return;
                }
                synchronized (this.d) {
                    if (c()) {
                        b();
                        a(jAvailable, length);
                        return;
                    }
                    this.b.a(bArr, i2);
                }
                jAvailable += (long) i2;
                a(jAvailable, length);
            }
        } catch (Throwable th) {
            try {
                this.e.incrementAndGet();
                a(th);
            } finally {
                b();
                a(jAvailable, length);
            }
        }
    }

    public final synchronized void f() {
        boolean z = (this.f == null || this.f.getState() == Thread.State.TERMINATED) ? false : true;
        if (this.g || this.b.b() || z) {
            return;
        }
        this.f = new Thread(new b(), "Source reader for " + this.f38568a);
        this.f.start();
    }

    public void g() {
        synchronized (this.d) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(i, "Shutdown proxy for " + this.f38568a);
            }
            try {
                this.g = true;
                if (this.f != null) {
                    this.f.interrupt();
                }
                this.b.close();
            } catch (k e) {
                a(e);
            }
        }
    }

    public final void h() throws k {
        synchronized (this.d) {
            if (!c() && this.b.available() == this.f38568a.length()) {
                this.b.a();
            }
        }
    }

    public final void i() throws k {
        synchronized (this.c) {
            try {
                try {
                    this.c.wait(1000L);
                } catch (InterruptedException e) {
                    throw new k("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public int a(byte[] bArr, long j2, int i2) throws k {
        l.a(bArr, j2, i2);
        while (!this.b.b() && this.b.available() < ((long) i2) + j2 && !this.g) {
            f();
            i();
            a();
        }
        int iA = this.b.a(bArr, j2, i2);
        if (this.b.b() && this.h != 100) {
            this.h = 100;
            a(100);
        }
        return iA;
    }

    public final void b() {
        try {
            this.f38568a.close();
        } catch (k e) {
            a(new k("Error closing source " + this.f38568a, e));
        }
    }

    public final void a() throws k {
        int i2 = this.e.get();
        if (i2 < 1) {
            return;
        }
        this.e.set(0);
        throw new k("Error reading source " + i2 + " times");
    }

    public final void a(long j2, long j3) {
        b(j2, j3);
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    public final void a(Throwable th) {
        if (th instanceof g) {
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(i, "ProxyCache is interrupted");
            }
        } else if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.b(i, "ProxyCache error", th);
        }
    }
}
