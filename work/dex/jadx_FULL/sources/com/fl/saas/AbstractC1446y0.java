package com.fl.saas;

import com.fl.saas.adx.util.LogcatUtil;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: com.fl.saas.y0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class AbstractC1446y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final V0 f30212a;
    private final InterfaceC1427p b;
    private volatile Thread f;
    private volatile boolean g;
    private final Object c = new Object();
    private final Object d = new Object();
    private volatile int h = -1;
    private final AtomicInteger e = new AtomicInteger();

    /* JADX INFO: renamed from: com.fl.saas.y0$b */
    public class b implements Runnable {
        private b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC1446y0.this.e();
        }
    }

    public AbstractC1446y0(V0 v0, InterfaceC1427p interfaceC1427p) {
        this.f30212a = (V0) AbstractC1442w0.a(v0);
        this.b = (InterfaceC1427p) AbstractC1442w0.a(interfaceC1427p);
    }

    private void b() {
        try {
            this.f30212a.close();
        } catch (C1448z0 e) {
            a(new C1448z0("Error closing source " + this.f30212a, e));
        }
    }

    private boolean c() {
        return Thread.currentThread().isInterrupted() || this.g;
    }

    private void d() {
        this.h = 100;
        a(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        long jA = -1;
        long jB = 0;
        try {
            jB = this.b.b();
            this.f30212a.a(jB);
            jA = this.f30212a.a();
            byte[] bArr = new byte[8192];
            while (true) {
                int iA = this.f30212a.a(bArr);
                if (iA == -1) {
                    h();
                    d();
                    break;
                }
                synchronized (this.d) {
                    if (c()) {
                        b();
                        a(jB, jA);
                        return;
                    }
                    this.b.a(bArr, iA);
                }
                jB += (long) iA;
                a(jB, jA);
            }
        } catch (Throwable th) {
            try {
                this.e.incrementAndGet();
                a(th);
            } finally {
                b();
                a(jB, jA);
            }
        }
    }

    private synchronized void f() {
        boolean z = (this.f == null || this.f.getState() == Thread.State.TERMINATED) ? false : true;
        if (!this.g && !this.b.c() && !z) {
            this.f = new Thread(new b(), "Source reader for " + this.f30212a);
            this.f.start();
        }
    }

    private void h() {
        synchronized (this.d) {
            if (!c() && this.b.b() == this.f30212a.a()) {
                this.b.a();
            }
        }
    }

    private void i() {
        synchronized (this.c) {
            try {
                try {
                    this.c.wait(1000L);
                } catch (InterruptedException e) {
                    throw new C1448z0("Waiting source data is interrupted!", e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void a(int i);

    public void g() {
        synchronized (this.d) {
            LogcatUtil.d("Shutdown proxy for " + this.f30212a);
            try {
                this.g = true;
                if (this.f != null) {
                    this.f.interrupt();
                }
                this.b.close();
            } catch (C1448z0 e) {
                a(e);
            }
        }
    }

    private void a() throws C1448z0 {
        int i = this.e.get();
        if (i < 1) {
            return;
        }
        this.e.set(0);
        throw new C1448z0("Error reading source " + i + " times");
    }

    public void b(long j, long j2) {
        int i = j2 == 0 ? 100 : (int) ((j / j2) * 100.0f);
        boolean z = i != this.h;
        if (j2 >= 0 && z) {
            a(i);
        }
        this.h = i;
    }

    private void a(long j, long j2) {
        b(j, j2);
        synchronized (this.c) {
            this.c.notifyAll();
        }
    }

    public final void a(Throwable th) {
        if (th instanceof C1400b0) {
            LogcatUtil.d("ProxyCache is interrupted");
            return;
        }
        LogcatUtil.e("ProxyCache error" + th.getMessage());
    }

    public int a(byte[] bArr, long j, int i) throws C1448z0 {
        A0.a(bArr, j, i);
        while (!this.b.c() && this.b.b() < ((long) i) + j && !this.g) {
            f();
            i();
            a();
        }
        int iA = this.b.a(bArr, j, i);
        if (this.b.c() && this.h != 100) {
            this.h = 100;
            a(100);
        }
        return iA;
    }
}
