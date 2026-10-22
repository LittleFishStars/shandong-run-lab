package com.ipd.dsp.internal.k0;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.f0.f;
import com.ipd.dsp.internal.f0.h;
import com.ipd.dsp.internal.f0.k;
import com.ipd.dsp.internal.g0.c;
import com.ipd.dsp.internal.l0.e;
import java.io.File;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b {
    public static final String j = "DownloadDispatcher";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38386a;
    public final List<e> b;
    public final List<e> c;
    public final List<e> d;
    public final List<e> e;
    public final AtomicInteger f;

    @Nullable
    public volatile ExecutorService g;
    public final AtomicInteger h;
    public com.ipd.dsp.internal.h0.e i;

    public b() {
        this(new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList());
    }

    public void a(@NonNull com.ipd.dsp.internal.h0.e eVar) {
        this.i = eVar;
    }

    public synchronized ExecutorService b() {
        if (this.g == null) {
            this.g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkDownload Download", false));
        }
        return this.g;
    }

    public final synchronized void c(f fVar) {
        c.a(j, "enqueueLocked for single task: " + fVar);
        if (!f(fVar) && !g(fVar)) {
            int size = this.b.size();
            b(fVar);
            if (size != this.b.size()) {
                Collections.sort(this.b);
            }
        }
    }

    public void d(f fVar) {
        c.a(j, "execute: " + fVar);
        synchronized (this) {
            if (f(fVar)) {
                return;
            }
            if (g(fVar)) {
                return;
            }
            e eVarA = e.a(fVar, false, this.i);
            this.d.add(eVarA);
            c(eVarA);
        }
    }

    @Nullable
    public synchronized f e(f fVar) {
        c.a(j, "findSameTask: " + fVar.b());
        for (e eVar : this.b) {
            if (!eVar.g() && eVar.a(fVar)) {
                return eVar.g;
            }
        }
        for (e eVar2 : this.c) {
            if (!eVar2.g() && eVar2.a(fVar)) {
                return eVar2.g;
            }
        }
        for (e eVar3 : this.d) {
            if (!eVar3.g() && eVar3.a(fVar)) {
                return eVar3.g;
            }
        }
        return null;
    }

    public boolean f(@NonNull f fVar) {
        return a(fVar, (Collection<f>) null);
    }

    public final boolean g(@NonNull f fVar) {
        return a(fVar, (Collection<f>) null, (Collection<f>) null);
    }

    public synchronized boolean h(@NonNull f fVar) {
        f fVar2;
        File fileH;
        f fVar3;
        File fileH2;
        c.a(j, "is file conflict after run: " + fVar.b());
        File fileH3 = fVar.h();
        if (fileH3 == null) {
            return false;
        }
        for (e eVar : this.d) {
            if (!eVar.g() && (fVar3 = eVar.g) != fVar && (fileH2 = fVar3.h()) != null && fileH3.equals(fileH2)) {
                return true;
            }
        }
        for (e eVar2 : this.c) {
            if (!eVar2.g() && (fVar2 = eVar2.g) != fVar && (fileH = fVar2.h()) != null && fileH3.equals(fileH)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean i(f fVar) {
        c.a(j, "isPending: " + fVar.b());
        for (e eVar : this.b) {
            if (!eVar.g() && eVar.a(fVar)) {
                return true;
            }
        }
        return false;
    }

    public synchronized boolean j(f fVar) {
        c.a(j, "isRunning: " + fVar.b());
        for (e eVar : this.d) {
            if (!eVar.g() && eVar.a(fVar)) {
                return true;
            }
        }
        for (e eVar2 : this.c) {
            if (!eVar2.g() && eVar2.a(fVar)) {
                return true;
            }
        }
        return false;
    }

    public b(List<e> list, List<e> list2, List<e> list3, List<e> list4) {
        this.f38386a = 5;
        this.f = new AtomicInteger();
        this.h = new AtomicInteger();
        this.b = list;
        this.c = list2;
        this.d = list3;
        this.e = list4;
    }

    public void a(f[] fVarArr) {
        this.h.incrementAndGet();
        b(fVarArr);
        this.h.decrementAndGet();
    }

    public void a(f fVar) {
        this.h.incrementAndGet();
        c(fVar);
        this.h.decrementAndGet();
    }

    public final synchronized void b(f[] fVarArr) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        c.a(j, "start enqueueLocked for bunch task: " + fVarArr.length);
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, fVarArr);
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        int size = this.b.size();
        try {
            h.j().f().a();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int size2 = arrayList.size();
            int i = 0;
            while (i < size2) {
                Object obj = arrayList.get(i);
                i++;
                f fVar = (f) obj;
                if (!a(fVar, arrayList2) && !a(fVar, (Collection<f>) arrayList3, (Collection<f>) arrayList4)) {
                    b(fVar);
                }
            }
            h.j().b().a(arrayList2, arrayList3, arrayList4);
        } catch (UnknownHostException e) {
            h.j().b().a(new ArrayList(arrayList), e);
        }
        if (size != this.b.size()) {
            Collections.sort(this.b);
        }
        c.a(j, "end enqueueLocked for bunch task: " + fVarArr.length + " consume " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
    }

    public void c(e eVar) {
        eVar.run();
    }

    public void a() {
        this.h.incrementAndGet();
        ArrayList arrayList = new ArrayList();
        Iterator<e> it = this.b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().g);
        }
        Iterator<e> it2 = this.c.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().g);
        }
        Iterator<e> it3 = this.d.iterator();
        while (it3.hasNext()) {
            arrayList.add(it3.next().g);
        }
        if (!arrayList.isEmpty()) {
            b((com.ipd.dsp.internal.g0.a[]) arrayList.toArray(new f[arrayList.size()]));
        }
        this.h.decrementAndGet();
    }

    public final synchronized void c() {
        if (this.h.get() <= 0 && d() < this.f38386a && !this.b.isEmpty()) {
            Iterator<e> it = this.b.iterator();
            while (it.hasNext()) {
                e next = it.next();
                it.remove();
                f fVar = next.g;
                if (h(fVar)) {
                    h.j().b().a().taskEnd(fVar, com.ipd.dsp.internal.i0.a.FILE_BUSY, null);
                } else {
                    this.c.add(next);
                    b().execute(next);
                    if (d() >= this.f38386a) {
                        break;
                    }
                }
            }
        }
    }

    public final int d() {
        return this.c.size() - this.f.get();
    }

    public void a(com.ipd.dsp.internal.g0.a[] aVarArr) {
        this.h.incrementAndGet();
        b(aVarArr);
        this.h.decrementAndGet();
        c();
    }

    public boolean a(com.ipd.dsp.internal.g0.a aVar) {
        this.h.incrementAndGet();
        boolean zB = b(aVar);
        this.h.decrementAndGet();
        c();
        return zB;
    }

    public boolean a(int i) {
        this.h.incrementAndGet();
        boolean zB = b(f.c(i));
        this.h.decrementAndGet();
        c();
        return zB;
    }

    public final synchronized void b(f fVar) {
        e eVarA = e.a(fVar, true, this.i);
        if (d() < this.f38386a) {
            this.c.add(eVarA);
            b().execute(eVarA);
        } else {
            this.b.add(eVarA);
        }
    }

    public final synchronized void a(@NonNull com.ipd.dsp.internal.g0.a aVar, @NonNull List<e> list, @NonNull List<e> list2) {
        Iterator<e> it = this.b.iterator();
        while (it.hasNext()) {
            e next = it.next();
            f fVar = next.g;
            if (fVar == aVar || fVar.b() == aVar.b()) {
                if (!next.g() && !next.h()) {
                    it.remove();
                    list.add(next);
                    return;
                }
            }
        }
        for (e eVar : this.c) {
            f fVar2 = eVar.g;
            if (fVar2 == aVar || fVar2.b() == aVar.b()) {
                list.add(eVar);
                list2.add(eVar);
                return;
            }
        }
        for (e eVar2 : this.d) {
            f fVar3 = eVar2.g;
            if (fVar3 == aVar || fVar3.b() == aVar.b()) {
                list.add(eVar2);
                list2.add(eVar2);
                return;
            }
        }
    }

    public final synchronized void b(com.ipd.dsp.internal.g0.a[] aVarArr) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        c.a(j, "start cancel bunch task manually: " + aVarArr.length);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            for (com.ipd.dsp.internal.g0.a aVar : aVarArr) {
                a(aVar, arrayList, arrayList2);
            }
            a(arrayList, arrayList2);
            c.a(j, "finish cancel bunch task manually: " + aVarArr.length + " consume " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
        } catch (Throwable th) {
            a(arrayList, arrayList2);
            c.a(j, "finish cancel bunch task manually: " + aVarArr.length + " consume " + (SystemClock.uptimeMillis() - jUptimeMillis) + "ms");
            throw th;
        }
    }

    public final synchronized void a(@NonNull List<e> list, @NonNull List<e> list2) {
        c.a(j, "handle cancel calls, cancel calls: " + list2.size());
        if (!list2.isEmpty()) {
            for (e eVar : list2) {
                if (!eVar.c()) {
                    list.remove(eVar);
                }
            }
        }
        c.a(j, "handle cancel calls, callback cancel event: " + list.size());
        if (list.isEmpty()) {
            return;
        }
        if (list.size() <= 1) {
            h.j().b().a().taskEnd(list.get(0).g, com.ipd.dsp.internal.i0.a.CANCELED, null);
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<e> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().g);
        }
        h.j().b().a(arrayList);
    }

    public synchronized boolean b(com.ipd.dsp.internal.g0.a aVar) {
        c.a(j, "cancel manually: " + aVar.b());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        try {
            a(aVar, arrayList, arrayList2);
            a(arrayList, arrayList2);
            return arrayList.size() > 0 || arrayList2.size() > 0;
        } catch (Throwable th) {
            a(arrayList, arrayList2);
            throw th;
        }
    }

    public synchronized void b(e eVar) {
        c.a(j, "flying canceled: " + eVar.g.b());
        if (eVar.h) {
            this.f.incrementAndGet();
        }
    }

    public static void b(int i) {
        b bVarE = h.j().e();
        if (bVarE.getClass() == b.class) {
            bVarE.f38386a = Math.max(1, i);
            return;
        }
        throw new IllegalStateException("The current dispatcher is " + bVarE + " not DownloadDispatcher exactly!");
    }

    public synchronized void a(e eVar) {
        List<e> list;
        boolean z = eVar.h;
        if (this.e.contains(eVar)) {
            list = this.e;
        } else if (z) {
            list = this.c;
        } else {
            list = this.d;
        }
        if (list.remove(eVar)) {
            if (z && eVar.g()) {
                this.f.decrementAndGet();
            }
            if (z) {
                c();
                return;
            }
            return;
        }
        throw new AssertionError("Call wasn't in-flight!");
    }

    public final boolean a(@NonNull f fVar, @Nullable Collection<f> collection, @Nullable Collection<f> collection2) {
        return a(fVar, this.b, collection, collection2) || a(fVar, this.c, collection, collection2) || a(fVar, this.d, collection, collection2);
    }

    public boolean a(@NonNull f fVar, @Nullable Collection<f> collection) {
        if (!fVar.A() || !k.c(fVar)) {
            return false;
        }
        if (fVar.a() == null && !h.j().f().b(fVar)) {
            return false;
        }
        h.j().f().a(fVar, this.i);
        if (collection != null) {
            collection.add(fVar);
            return true;
        }
        h.j().b().a().taskEnd(fVar, com.ipd.dsp.internal.i0.a.COMPLETED, null);
        return true;
    }

    public boolean a(@NonNull f fVar, @NonNull Collection<e> collection, @Nullable Collection<f> collection2, @Nullable Collection<f> collection3) {
        a aVarB = h.j().b();
        Iterator<e> it = collection.iterator();
        while (it.hasNext()) {
            e next = it.next();
            if (!next.g()) {
                if (next.a(fVar)) {
                    if (!next.h()) {
                        if (collection2 != null) {
                            collection2.add(fVar);
                        } else {
                            aVarB.a().taskEnd(fVar, com.ipd.dsp.internal.i0.a.SAME_TASK_BUSY, null);
                        }
                        return true;
                    }
                    c.a(j, "task: " + fVar.b() + " is finishing, move it to finishing list");
                    this.e.add(next);
                    it.remove();
                    return false;
                }
                File fileD = next.d();
                File fileH = fVar.h();
                if (fileD != null && fileH != null && fileD.equals(fileH)) {
                    if (collection3 != null) {
                        collection3.add(fVar);
                    } else {
                        aVarB.a().taskEnd(fVar, com.ipd.dsp.internal.i0.a.FILE_BUSY, null);
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
