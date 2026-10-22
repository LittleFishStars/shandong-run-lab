package com.ipd.dsp.internal.n0;

import android.net.Uri;
import android.os.StatFs;
import android.os.SystemClock;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f0.f;
import com.ipd.dsp.internal.f0.h;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d {
    public static final String y = "MultiPointOutputStream";
    public static final ExecutorService z = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.ipd.dsp.internal.g0.c.a("OkDownload file io", false));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<com.ipd.dsp.internal.n0.a> f38462a;
    public final SparseArray<AtomicLong> b;
    public final AtomicLong c;
    public final AtomicLong d;
    public boolean e;
    public final int f;
    public final int g;
    public final int h;
    public final com.ipd.dsp.internal.h0.b i;
    public final f j;
    public final com.ipd.dsp.internal.h0.e k;
    public final boolean l;
    public final boolean m;
    public volatile Future n;
    public volatile Thread o;
    public final SparseArray<Thread> p;

    @NonNull
    public final Runnable q;
    public String r;
    public IOException s;

    @NonNull
    public ArrayList<Integer> t;
    public List<Integer> u;
    public final c v;
    public c w;
    public volatile boolean x;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.m();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a();
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f38463a;
        public List<Integer> b = new ArrayList();
        public List<Integer> c = new ArrayList();

        public boolean a() {
            return this.f38463a || this.c.size() > 0;
        }
    }

    public d(@NonNull f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull com.ipd.dsp.internal.h0.e eVar, @Nullable Runnable runnable) {
        this.f38462a = new SparseArray<>();
        this.b = new SparseArray<>();
        this.c = new AtomicLong();
        this.d = new AtomicLong();
        this.e = false;
        this.p = new SparseArray<>();
        this.v = new c();
        this.w = new c();
        this.x = true;
        this.j = fVar;
        this.f = fVar.j();
        this.g = fVar.v();
        this.h = fVar.u();
        this.i = bVar;
        this.k = eVar;
        this.l = h.j().h().a();
        this.m = h.j().i().b(fVar);
        this.t = new ArrayList<>();
        if (runnable == null) {
            this.q = new a();
        } else {
            this.q = runnable;
        }
        File fileH = fVar.h();
        if (fileH != null) {
            this.r = fileH.getAbsolutePath();
        }
    }

    public synchronized void a(int i, byte[] bArr, int i2) throws IOException {
        if (this.e) {
            return;
        }
        e(i).write(bArr, 0, i2);
        long j = i2;
        this.c.addAndGet(j);
        this.b.get(i).addAndGet(j);
        f();
    }

    public void b() {
        z.execute(new b());
    }

    public void c(int i) throws IOException {
        this.t.add(Integer.valueOf(i));
        try {
            IOException iOException = this.s;
            if (iOException != null) {
                throw iOException;
            }
            if (this.n != null && !this.n.isDone()) {
                AtomicLong atomicLong = this.b.get(i);
                if (atomicLong != null && atomicLong.get() > 0) {
                    a(this.v);
                    a(this.v.f38463a, i);
                }
            } else if (this.n == null) {
                com.ipd.dsp.internal.g0.c.a(y, "OutputStream done but no need to ensure sync, because the sync job not run yet. task[" + this.j.b() + "] block[" + i + "]");
            } else {
                com.ipd.dsp.internal.g0.c.a(y, "OutputStream done but no need to ensure sync, because the syncFuture.isDone[" + this.n.isDone() + "] task[" + this.j.b() + "] block[" + i + "]");
            }
            b(i);
        } catch (Throwable th) {
            b(i);
            throw th;
        }
    }

    public void d(int i) throws IOException {
        com.ipd.dsp.internal.h0.a aVarB = this.i.b(i);
        if (com.ipd.dsp.internal.g0.c.a(aVarB.c(), aVarB.b())) {
            return;
        }
        throw new IOException("The current offset on block-info isn't update correct, " + aVarB.c() + " != " + aVarB.b() + " on " + i);
    }

    public long e() {
        return ((long) this.h) - (j() - this.d.get());
    }

    public void f() throws IOException {
        IOException iOException = this.s;
        if (iOException != null) {
            throw iOException;
        }
        if (this.n == null) {
            synchronized (this.q) {
                if (this.n == null) {
                    this.n = c();
                }
            }
        }
    }

    public final void g() {
        if (this.r != null || this.j.h() == null) {
            return;
        }
        this.r = this.j.h().getAbsolutePath();
    }

    public boolean h() {
        return this.c.get() < ((long) this.g);
    }

    public boolean i() {
        return this.o != null;
    }

    public long j() {
        return SystemClock.uptimeMillis();
    }

    public void k() {
        LockSupport.park();
    }

    public void l() throws IOException {
        int i;
        com.ipd.dsp.internal.g0.c.a(y, "OutputStream start flush looper task[" + this.j.b() + "] with syncBufferIntervalMills[" + this.h + "] syncBufferSize[" + this.g + "]");
        this.o = Thread.currentThread();
        long jE = (long) this.h;
        d();
        while (true) {
            a(jE);
            a(this.w);
            if (this.w.a()) {
                com.ipd.dsp.internal.g0.c.a(y, "runSync state change isNoMoreStream[" + this.w.f38463a + "] newNoMoreStreamBlockList[" + this.w.c + "]");
                if (this.c.get() > 0) {
                    d();
                }
                for (Integer num : this.w.c) {
                    Thread thread = this.p.get(num.intValue());
                    this.p.remove(num.intValue());
                    if (thread != null) {
                        a(thread);
                    }
                }
                if (this.w.f38463a) {
                    break;
                }
            } else {
                if (h()) {
                    i = this.h;
                } else {
                    jE = e();
                    if (jE <= 0) {
                        d();
                        i = this.h;
                    }
                }
                jE = i;
            }
        }
        int size = this.p.size();
        for (int i2 = 0; i2 < size; i2++) {
            Thread threadValueAt = this.p.valueAt(i2);
            if (threadValueAt != null) {
                a(threadValueAt);
            }
        }
        this.p.clear();
        com.ipd.dsp.internal.g0.c.a(y, "OutputStream stop flush looper task[" + this.j.b() + "]");
    }

    public void m() {
        try {
            l();
        } catch (IOException e) {
            this.s = e;
            com.ipd.dsp.internal.g0.c.c(y, "Sync to breakpoint-store for task[" + this.j.b() + "] failed with cause: " + e);
        }
    }

    public synchronized void b(int i) throws IOException {
        com.ipd.dsp.internal.n0.a aVar = this.f38462a.get(i);
        if (aVar != null) {
            aVar.close();
            this.f38462a.remove(i);
            com.ipd.dsp.internal.g0.c.a(y, "OutputStream close task[" + this.j.b() + "] block[" + i + "]");
        }
    }

    public synchronized com.ipd.dsp.internal.n0.a e(int i) throws IOException {
        Uri uriX;
        com.ipd.dsp.internal.n0.a aVar = this.f38462a.get(i);
        if (aVar != null) {
            return aVar;
        }
        boolean zD = com.ipd.dsp.internal.g0.c.d(this.j.x());
        if (zD) {
            File fileH = this.j.h();
            if (fileH != null) {
                File fileC = this.j.c();
                if (!fileC.exists() && !fileC.mkdirs()) {
                    throw new IOException("Create parent folder failed!");
                }
                if (fileH.createNewFile()) {
                    com.ipd.dsp.internal.g0.c.a(y, "Create new file: " + fileH.getName());
                }
                uriX = Uri.fromFile(fileH);
            } else {
                throw new FileNotFoundException("Filename is not ready!");
            }
        } else {
            uriX = this.j.x();
        }
        com.ipd.dsp.internal.n0.a aVarA = h.j().h().a(h.j().d(), uriX, this.f);
        if (this.l) {
            long jD = this.i.b(i).d();
            if (jD > 0) {
                aVarA.b(jD);
                com.ipd.dsp.internal.g0.c.a(y, "Create output stream write from (" + this.j.b() + ") block(" + i + ") " + jD);
            }
        }
        if (this.x) {
            this.k.c(this.j.b());
        }
        if (!this.i.k() && this.x && this.m) {
            long jH = this.i.h();
            if (zD) {
                File fileH2 = this.j.h();
                long length = jH - fileH2.length();
                if (length > 0) {
                    a(new StatFs(fileH2.getAbsolutePath()), length);
                    aVarA.a(jH);
                }
            } else {
                aVarA.a(jH);
            }
        }
        synchronized (this.b) {
            this.f38462a.put(i, aVarA);
            this.b.put(i, new AtomicLong());
        }
        this.x = false;
        return aVarA;
    }

    public void d() throws IOException {
        int size;
        long j;
        synchronized (this.b) {
            size = this.b.size();
        }
        SparseArray sparseArray = new SparseArray(size);
        int i = 0;
        while (true) {
            j = 0;
            if (i >= size) {
                break;
            }
            try {
                int iKeyAt = this.f38462a.keyAt(i);
                long j2 = this.b.get(iKeyAt).get();
                if (j2 > 0) {
                    sparseArray.put(iKeyAt, Long.valueOf(j2));
                    this.f38462a.get(iKeyAt).a();
                }
                i++;
            } catch (IOException e) {
                com.ipd.dsp.internal.g0.c.c(y, "OutputStream flush and sync data to filesystem failed " + e);
                return;
            }
        }
        int size2 = sparseArray.size();
        for (int i2 = 0; i2 < size2; i2++) {
            int iKeyAt2 = sparseArray.keyAt(i2);
            long jLongValue = ((Long) sparseArray.valueAt(i2)).longValue();
            this.k.a(this.i, iKeyAt2, jLongValue);
            j += jLongValue;
            this.b.get(iKeyAt2).addAndGet(-jLongValue);
            com.ipd.dsp.internal.g0.c.a(y, "OutputStream sync success (" + this.j.b() + ") block(" + iKeyAt2 + ")  syncLength(" + jLongValue + ") currentOffset(" + this.i.b(iKeyAt2).c() + ")");
        }
        this.c.addAndGet(-j);
        this.d.set(SystemClock.uptimeMillis());
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00cd A[Catch: all -> 0x016f, TRY_LEAVE, TryCatch #5 {, blocks: (B:3:0x0001, B:6:0x0006, B:11:0x000d, B:16:0x0021, B:17:0x0027, B:19:0x002d, B:20:0x0033, B:23:0x003c, B:24:0x0069, B:38:0x00c1, B:39:0x00c7, B:41:0x00cd, B:42:0x00d3, B:45:0x00dc, B:46:0x0109, B:50:0x0119, B:51:0x011f, B:53:0x0125, B:54:0x012b, B:57:0x0134, B:58:0x0161, B:59:0x016e, B:13:0x0015, B:27:0x0078, B:29:0x007c, B:31:0x0084, B:34:0x009c, B:36:0x00af, B:37:0x00c0, B:33:0x0099), top: B:72:0x0001, inners: #0, #1, #2, #4 }] */
    public synchronized void a() {
        List<Integer> list = this.u;
        if (list != null && !this.e) {
            this.e = true;
            this.t.addAll(list);
            try {
                if (this.c.get() <= 0) {
                    for (Integer num : this.u) {
                        try {
                            b(num.intValue());
                        } catch (IOException e) {
                            com.ipd.dsp.internal.g0.c.a(y, "OutputStream close failed task[" + this.j.b() + "] block[" + num + "]" + e);
                        }
                    }
                    this.k.a(this.j.b(), com.ipd.dsp.internal.i0.a.CANCELED, (Exception) null);
                    return;
                }
                if (this.n != null && !this.n.isDone()) {
                    g();
                    h.j().i().a().b(this.r);
                    try {
                        a(true, -1);
                        h.j().i().a().a(this.r);
                        while (r1.hasNext()) {
                            b(num.intValue());
                        }
                        this.k.a(this.j.b(), com.ipd.dsp.internal.i0.a.CANCELED, (Exception) null);
                        return;
                    } catch (Throwable th) {
                        h.j().i().a().a(this.r);
                        throw th;
                    }
                }
                for (Integer num2 : this.u) {
                    try {
                        b(num2.intValue());
                    } catch (IOException e2) {
                        com.ipd.dsp.internal.g0.c.a(y, "OutputStream close failed task[" + this.j.b() + "] block[" + num2 + "]" + e2);
                    }
                }
                this.k.a(this.j.b(), com.ipd.dsp.internal.i0.a.CANCELED, (Exception) null);
                return;
            } catch (Throwable th2) {
                for (Integer num3 : this.u) {
                    try {
                        b(num3.intValue());
                    } catch (IOException e3) {
                        com.ipd.dsp.internal.g0.c.a(y, "OutputStream close failed task[" + this.j.b() + "] block[" + num3 + "]" + e3);
                    }
                }
                this.k.a(this.j.b(), com.ipd.dsp.internal.i0.a.CANCELED, (Exception) null);
                throw th2;
            }
            throw th;
        }
    }

    public Future c() {
        return z.submit(this.q);
    }

    public d(@NonNull f fVar, @NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull com.ipd.dsp.internal.h0.e eVar) {
        this(fVar, bVar, eVar, null);
    }

    public void a(boolean z2, int i) {
        if (this.n == null || this.n.isDone()) {
            return;
        }
        if (!z2) {
            this.p.put(i, Thread.currentThread());
        }
        if (this.o != null) {
            a(this.o);
        } else {
            while (!i()) {
                a(25L);
            }
            a(this.o);
        }
        if (z2) {
            a(this.o);
            try {
                this.n.get();
                return;
            } catch (InterruptedException | ExecutionException unused) {
                return;
            }
        }
        k();
    }

    public void a(long j) {
        LockSupport.parkNanos(TimeUnit.MILLISECONDS.toNanos(j));
    }

    public void a(Thread thread) {
        LockSupport.unpark(thread);
    }

    public void a(c cVar) {
        cVar.c.clear();
        int size = new HashSet((List) this.t.clone()).size();
        if (size != this.u.size()) {
            com.ipd.dsp.internal.g0.c.a(y, "task[" + this.j.b() + "] current need fetching block count " + this.u.size() + " is not equal to no more stream block count " + size);
            cVar.f38463a = false;
        } else {
            com.ipd.dsp.internal.g0.c.a(y, "task[" + this.j.b() + "] current need fetching block count " + this.u.size() + " is equal to no more stream block count " + size);
            cVar.f38463a = true;
        }
        SparseArray<com.ipd.dsp.internal.n0.a> sparseArrayClone = this.f38462a.clone();
        int size2 = sparseArrayClone.size();
        for (int i = 0; i < size2; i++) {
            int iKeyAt = sparseArrayClone.keyAt(i);
            if (this.t.contains(Integer.valueOf(iKeyAt)) && !cVar.b.contains(Integer.valueOf(iKeyAt))) {
                cVar.b.add(Integer.valueOf(iKeyAt));
                cVar.c.add(Integer.valueOf(iKeyAt));
            }
        }
    }

    public void a(List<Integer> list) {
        this.u = list;
    }

    public void a(int i) {
        this.t.add(Integer.valueOf(i));
    }

    public void a(StatFs statFs, long j) throws com.ipd.dsp.internal.m0.e {
        long jA = com.ipd.dsp.internal.g0.c.a(statFs);
        if (jA < j) {
            throw new com.ipd.dsp.internal.m0.e(j, jA);
        }
    }
}
