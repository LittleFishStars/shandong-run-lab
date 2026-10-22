package com.kc.cw.ad.internal.d;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final r f38973a;
    private final com.kc.cw.ad.internal.d.a b;
    private volatile Thread f;
    private volatile boolean g;
    private final Object c = new Object();
    private final Object d = new Object();
    private volatile int h = -1;
    private final AtomicInteger e = new AtomicInteger();

    @Keep
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final o f38974a;

        private a(o oVar) {
            this.f38974a = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f38974a.e();
        }
    }

    public o(r rVar, com.kc.cw.ad.internal.d.a aVar) {
        this.f38973a = (r) n.a(rVar);
        this.b = (com.kc.cw.ad.internal.d.a) n.a(aVar);
    }

    private void b() throws p {
        int i = this.e.get();
        if (i < 1) {
            return;
        }
        this.e.set(0);
        throw new p("Error reading source " + i + " times");
    }

    private void b(long j, long j2) {
        a(j, j2);
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    private void c() throws p {
        synchronized (this) {
            boolean z = (this.f == null || this.f.getState() == Thread.State.TERMINATED) ? false : true;
            if (!this.g && !this.b.d() && !z) {
                this.f = new Thread(new a(), "Source reader for " + this.f38973a);
                this.f.start();
            }
        }
    }

    private void d() throws p {
        synchronized (this.c) {
            try {
                try {
                    this.c.wait(1000L);
                } catch (InterruptedException e) {
                    throw new p("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        r2 = r2 + ((long) r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void e() {
        long jA = -1;
        long jA2 = 0;
        try {
            jA2 = this.b.a();
            this.f38973a.a(jA2);
            jA = this.f38973a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int iA = this.f38973a.a(bArr);
                if (iA == -1) {
                    g();
                    f();
                    break;
                } else {
                    synchronized (this.d) {
                        if (!h()) {
                            this.b.a(bArr, iA);
                        }
                    }
                    break;
                }
                b(jA2, jA);
            }
        } catch (Throwable th) {
            try {
                this.e.incrementAndGet();
                a(th);
            } finally {
                i();
                b(jA2, jA);
            }
        }
    }

    private void f() {
        this.h = 100;
        a(this.h);
    }

    private void g() throws p {
        synchronized (this.d) {
            if (!h() && this.b.a() == this.f38973a.a()) {
                this.b.c();
            }
        }
    }

    private boolean h() {
        return Thread.currentThread().isInterrupted() || this.g;
    }

    private void i() {
        try {
            this.f38973a.b();
        } catch (p e) {
            a(new p("Error closing source " + this.f38973a, e));
        }
    }

    public int a(byte[] bArr, long j, int i) throws p {
        q.a(bArr, j, i);
        while (!this.b.d() && this.b.a() < ((long) i) + j && !this.g) {
            c();
            d();
            b();
        }
        int iA = this.b.a(bArr, j, i);
        a(this.h);
        if (this.b.d() && this.h != 100) {
            this.h = 100;
            a(100);
        }
        return iA;
    }

    public void a() {
        synchronized (this.d) {
            com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.s, "Shutdown proxy for " + this.f38973a);
            try {
                this.g = true;
                if (this.f != null) {
                    this.f.interrupt();
                }
                this.b.b();
            } catch (p e) {
                a(e);
            }
        }
    }

    public void a(int i) {
    }

    public void a(long j, long j2) {
        int i = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.h;
        if ((j2 >= 0) && z) {
            a(i);
        }
        this.h = i;
    }

    public final void a(Throwable th) {
        if (th instanceof l) {
            com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.s, "ProxyCache is interrupted");
        } else {
            com.kc.cw.ad.internal.c.f.b(com.kc.cw.ad.internal.c.f.s, "ProxyCache error", th);
        }
    }
}
