package com.ipd.dsp.internal.l0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f0.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f implements Runnable {
    public static final ExecutorService v = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.ipd.dsp.internal.g0.c.a("OkDownload Cancel Block", false));
    public static final String w = "DownloadChain";
    public final int f;

    @NonNull
    public final com.ipd.dsp.internal.f0.f g;

    @NonNull
    public final com.ipd.dsp.internal.h0.b h;

    @NonNull
    public final d i;
    public long n;
    public volatile com.ipd.dsp.internal.j0.a o;
    public long p;
    public volatile Thread q;

    @NonNull
    public final com.ipd.dsp.internal.h0.e s;
    public final List<com.ipd.dsp.internal.o0.c.a> j = new ArrayList();
    public final List<com.ipd.dsp.internal.o0.c.b> k = new ArrayList();
    public int l = 0;
    public int m = 0;
    public final AtomicBoolean t = new AtomicBoolean(false);
    public final Runnable u = new a();
    public final com.ipd.dsp.internal.k0.a r = h.j().b();

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.p();
        }
    }

    public f(int i, @NonNull com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull d dVar, @NonNull com.ipd.dsp.internal.h0.e eVar) {
        this.f = i;
        this.g = fVar;
        this.i = dVar;
        this.h = bVar;
        this.s = eVar;
    }

    public static f a(int i, com.ipd.dsp.internal.f0.f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull d dVar, @NonNull com.ipd.dsp.internal.h0.e eVar) {
        return new f(i, fVar, bVar, dVar, eVar);
    }

    public void b(long j) {
        this.n = j;
    }

    public int c() {
        return this.f;
    }

    @NonNull
    public d d() {
        return this.i;
    }

    @Nullable
    public synchronized com.ipd.dsp.internal.j0.a e() {
        return this.o;
    }

    @NonNull
    public synchronized com.ipd.dsp.internal.j0.a f() throws IOException {
        if (this.i.f()) {
            throw com.ipd.dsp.internal.m0.c.f;
        }
        if (this.o == null) {
            String strC = this.i.c();
            if (strC == null) {
                strC = this.h.j();
            }
            com.ipd.dsp.internal.g0.c.a(w, "create connection on url: " + strC);
            this.o = h.j().c().a(strC);
        }
        return this.o;
    }

    @NonNull
    public com.ipd.dsp.internal.h0.e g() {
        return this.s;
    }

    @NonNull
    public com.ipd.dsp.internal.h0.b h() {
        return this.h;
    }

    public com.ipd.dsp.internal.n0.d i() {
        return this.i.a();
    }

    public long j() {
        return this.n;
    }

    @NonNull
    public com.ipd.dsp.internal.f0.f k() {
        return this.g;
    }

    public boolean l() {
        return this.t.get();
    }

    public long m() throws IOException {
        if (this.m == this.k.size()) {
            this.m--;
        }
        return o();
    }

    public com.ipd.dsp.internal.j0.a.InterfaceC0886a n() throws IOException {
        if (this.i.f()) {
            throw com.ipd.dsp.internal.m0.c.f;
        }
        List<com.ipd.dsp.internal.o0.c.a> list = this.j;
        int i = this.l;
        this.l = i + 1;
        return list.get(i).a(this);
    }

    public long o() throws IOException {
        if (this.i.f()) {
            throw com.ipd.dsp.internal.m0.c.f;
        }
        List<com.ipd.dsp.internal.o0.c.b> list = this.k;
        int i = this.m;
        this.m = i + 1;
        return list.get(i).b(this);
    }

    public synchronized void p() {
        if (this.o != null) {
            this.o.a();
            com.ipd.dsp.internal.g0.c.a(w, "release connection " + this.o + " task[" + this.g.b() + "] block[" + this.f + "]");
        }
        this.o = null;
    }

    public void q() {
        v.execute(this.u);
    }

    public void r() {
        this.l = 1;
        p();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (l()) {
            throw new IllegalAccessError("The chain has been finished!");
        }
        this.q = Thread.currentThread();
        try {
            s();
        } catch (IOException unused) {
        } finally {
            this.t.set(true);
            q();
        }
    }

    public void s() throws IOException {
        com.ipd.dsp.internal.k0.a aVarB = h.j().b();
        com.ipd.dsp.internal.o0.d dVar = new com.ipd.dsp.internal.o0.d();
        com.ipd.dsp.internal.o0.a aVar = new com.ipd.dsp.internal.o0.a();
        this.j.add(dVar);
        this.j.add(aVar);
        this.j.add(new com.ipd.dsp.internal.p0.b());
        this.j.add(new com.ipd.dsp.internal.p0.a());
        this.l = 0;
        com.ipd.dsp.internal.j0.a.InterfaceC0886a interfaceC0886aN = n();
        if (this.i.f()) {
            throw com.ipd.dsp.internal.m0.c.f;
        }
        aVarB.a().fetchStart(this.g, this.f, j());
        com.ipd.dsp.internal.o0.b bVar = new com.ipd.dsp.internal.o0.b(this.f, interfaceC0886aN.c(), i(), this.g);
        this.k.add(dVar);
        this.k.add(aVar);
        this.k.add(bVar);
        this.m = 0;
        aVarB.a().fetchEnd(this.g, this.f, o());
    }

    public void a() {
        if (this.t.get() || this.q == null) {
            return;
        }
        this.q.interrupt();
    }

    public void b() {
        if (this.p == 0) {
            return;
        }
        this.r.a().fetchProgress(this.g, this.f, this.p);
        this.p = 0L;
    }

    public synchronized void a(@NonNull com.ipd.dsp.internal.j0.a aVar) {
        this.o = aVar;
    }

    public void a(String str) {
        this.i.a(str);
    }

    public void a(long j) {
        this.p += j;
    }
}
