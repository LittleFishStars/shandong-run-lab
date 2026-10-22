package com.ipd.dsp.internal.l0;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f0.h;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e extends com.ipd.dsp.internal.g0.b implements Comparable<e> {
    public static final ExecutorService o = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), com.ipd.dsp.internal.g0.c.a("OkDownload Block", false));
    public static final String p = "DownloadCall";
    public static final int q = 1;
    public final com.ipd.dsp.internal.f0.f g;
    public final boolean h;

    @NonNull
    public final ArrayList<f> i;

    @Nullable
    public volatile d j;
    public volatile boolean k;
    public volatile boolean l;
    public volatile Thread m;

    @NonNull
    public final com.ipd.dsp.internal.h0.e n;

    public e(com.ipd.dsp.internal.f0.f fVar, boolean z, @NonNull com.ipd.dsp.internal.h0.e eVar) {
        this(fVar, z, new ArrayList(), eVar);
    }

    public static e a(com.ipd.dsp.internal.f0.f fVar, boolean z, @NonNull com.ipd.dsp.internal.h0.e eVar) {
        return new e(fVar, z, eVar);
    }

    @Override // com.ipd.dsp.internal.g0.b
    public void a(InterruptedException interruptedException) {
    }

    @Override // com.ipd.dsp.internal.g0.b
    public void b() {
        h.j().e().a(this);
        com.ipd.dsp.internal.g0.c.a(p, "call is finished " + this.g.b());
    }

    public boolean c() {
        synchronized (this) {
            if (this.k) {
                return false;
            }
            if (this.l) {
                return false;
            }
            this.k = true;
            long jUptimeMillis = SystemClock.uptimeMillis();
            h.j().e().b(this);
            d dVar = this.j;
            if (dVar != null) {
                dVar.m();
            }
            Object[] array = this.i.toArray();
            if (array != null && array.length != 0) {
                for (Object obj : array) {
                    if (obj instanceof f) {
                        ((f) obj).a();
                    }
                }
            } else if (this.m != null) {
                com.ipd.dsp.internal.g0.c.a(p, "interrupt thread with cancel operation because of chains are not running " + this.g.b());
                this.m.interrupt();
            }
            if (dVar != null) {
                dVar.a().b();
            }
            com.ipd.dsp.internal.g0.c.a(p, "cancel task " + this.g.b() + " consume: " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
            return true;
        }
    }

    @Nullable
    public File d() {
        return this.g.h();
    }

    public int e() {
        return this.g.p();
    }

    public final void f() {
        this.n.b(this.g.b());
        h.j().b().a().taskStart(this.g);
    }

    public boolean g() {
        return this.k;
    }

    public boolean h() {
        return this.l;
    }

    public e(com.ipd.dsp.internal.f0.f fVar, boolean z, @NonNull ArrayList<f> arrayList, @NonNull com.ipd.dsp.internal.h0.e eVar) {
        super("download call: " + fVar.b());
        this.g = fVar;
        this.h = z;
        this.i = arrayList;
        this.n = eVar;
    }

    @Override // com.ipd.dsp.internal.g0.b
    public void a() throws InterruptedException {
        com.ipd.dsp.internal.i0.a aVar;
        IOException iOExceptionB;
        boolean z;
        this.m = Thread.currentThread();
        h hVarJ = h.j();
        com.ipd.dsp.internal.n0.e eVarI = hVarJ.i();
        f();
        int i = 0;
        do {
            if (this.g.e().length() <= 0) {
                this.j = new d.a(new IOException("unexpected url: " + this.g.e()));
                break;
            }
            if (this.k) {
                break;
            }
            try {
                com.ipd.dsp.internal.h0.b bVarB = this.n.get(this.g.b());
                if (bVarB == null) {
                    bVarB = this.n.b(this.g);
                }
                c(bVarB);
                if (this.k) {
                    break;
                }
                d dVarA = a(bVarB);
                this.j = dVarA;
                b bVarB2 = b(bVarB);
                try {
                    bVarB2.a();
                    dVarA.a(this.g.r());
                    eVarI.a().c(this.g.h().getAbsolutePath());
                    h.j().f().a(this.g, bVarB, bVarB2.e());
                    try {
                        if (bVarB2.g()) {
                            a aVarA = a(bVarB, bVarB2.e());
                            aVarA.a();
                            if (aVarA.c()) {
                                com.ipd.dsp.internal.g0.c.a(p, "breakpoint invalid: download from beginning because of local check is dirty " + this.g.b() + " " + aVarA);
                                eVarI.a(this.g);
                                a(bVarB, bVarB2, aVarA.b());
                            } else {
                                hVarJ.b().a().downloadFromBreakpoint(this.g, bVarB);
                            }
                        } else {
                            com.ipd.dsp.internal.g0.c.a(p, "breakpoint invalid: download from beginning because of remote check not resumable " + this.g.b() + " " + bVarB2);
                            eVarI.a(this.g);
                            a(bVarB, bVarB2, bVarB2.d());
                        }
                        a(dVarA, bVarB);
                        if (this.k) {
                            break;
                        }
                        if (dVarA.h()) {
                            int i2 = i + 1;
                            if (i < 1) {
                                this.n.remove(this.g.b());
                                i = i2;
                                z = true;
                            } else {
                                i = i2;
                                z = false;
                            }
                        } else {
                            z = false;
                        }
                    } catch (IOException e) {
                        dVarA.e(e);
                    }
                } catch (IOException e2) {
                    dVarA.a(e2);
                }
            } catch (IOException e3) {
                this.j = new d.a(e3);
            }
        } while (z);
        this.l = true;
        this.i.clear();
        d dVar = this.j;
        if (this.k || dVar == null) {
            return;
        }
        if (dVar.i() || dVar.j() || dVar.h()) {
            aVar = com.ipd.dsp.internal.i0.a.ERROR;
            iOExceptionB = dVar.b();
        } else {
            iOExceptionB = null;
            if (dVar.e()) {
                aVar = com.ipd.dsp.internal.i0.a.FILE_BUSY;
            } else if (dVar.g()) {
                aVar = com.ipd.dsp.internal.i0.a.PRE_ALLOCATE_FAILED;
                iOExceptionB = dVar.b();
            } else {
                aVar = com.ipd.dsp.internal.i0.a.COMPLETED;
            }
        }
        a(dVar, aVar, iOExceptionB);
    }

    @NonNull
    public b b(@NonNull com.ipd.dsp.internal.h0.b bVar) {
        return new b(this.g, bVar);
    }

    public void c(@NonNull com.ipd.dsp.internal.h0.b bVar) {
        com.ipd.dsp.internal.f0.f.c.a(this.g, bVar);
    }

    public final void a(d dVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
        if (aVar != com.ipd.dsp.internal.i0.a.CANCELED) {
            synchronized (this) {
                if (this.k) {
                    return;
                }
                this.l = true;
                this.n.a(this.g.b(), aVar, exc);
                if (aVar == com.ipd.dsp.internal.i0.a.COMPLETED) {
                    this.n.d(this.g.b());
                    h.j().i().a(dVar.a(), this.g);
                }
                h.j().b().a().taskEnd(this.g, aVar, exc);
                return;
            }
        }
        throw new IllegalAccessError("can't recognize cancelled on here");
    }

    public d a(@NonNull com.ipd.dsp.internal.h0.b bVar) {
        return new d(h.j().i().a(this.g, bVar, this.n));
    }

    public void a(d dVar, com.ipd.dsp.internal.h0.b bVar) throws InterruptedException {
        int iB = bVar.b();
        ArrayList arrayList = new ArrayList(bVar.b());
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < iB; i++) {
            com.ipd.dsp.internal.h0.a aVarB = bVar.b(i);
            if (!com.ipd.dsp.internal.g0.c.a(aVarB.c(), aVarB.b())) {
                com.ipd.dsp.internal.g0.c.a(aVarB);
                f fVarA = f.a(i, this.g, bVar, dVar, this.n);
                arrayList.add(fVarA);
                arrayList2.add(Integer.valueOf(fVarA.c()));
            }
        }
        if (this.k) {
            return;
        }
        dVar.a().a(arrayList2);
        a(arrayList);
    }

    public void a(List<f> list) throws InterruptedException {
        ArrayList arrayList = new ArrayList(list.size());
        int i = 0;
        try {
            Iterator<f> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            this.i.addAll(list);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                Future future = (Future) obj;
                if (!future.isDone()) {
                    try {
                        future.get();
                    } catch (CancellationException | ExecutionException unused) {
                    }
                }
            }
            this.i.removeAll(list);
        } catch (Throwable th) {
            try {
                int size2 = arrayList.size();
                while (i < size2) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    ((Future) obj2).cancel(true);
                }
                throw th;
            } catch (Throwable th2) {
                this.i.removeAll(list);
                throw th2;
            }
        }
    }

    @NonNull
    public a a(@NonNull com.ipd.dsp.internal.h0.b bVar, long j) {
        return new a(this.g, bVar, j);
    }

    public void a(@NonNull com.ipd.dsp.internal.h0.b bVar, @NonNull b bVar2, @NonNull com.ipd.dsp.internal.i0.b bVar3) {
        com.ipd.dsp.internal.g0.c.a(this.g, bVar, bVar2.e(), bVar2.f());
        h.j().b().a().downloadFromBeginning(this.g, bVar, bVar3);
    }

    public Future<?> a(f fVar) {
        return o.submit(fVar);
    }

    public boolean a(@NonNull com.ipd.dsp.internal.f0.f fVar) {
        return this.g.equals(fVar);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull e eVar) {
        return eVar.e() - e();
    }
}
