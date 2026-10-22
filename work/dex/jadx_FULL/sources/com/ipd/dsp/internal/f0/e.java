package com.ipd.dsp.internal.f0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e extends com.ipd.dsp.internal.q0.b implements Runnable {
    public static final Executor l = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 30, TimeUnit.SECONDS, new SynchronousQueue(), com.ipd.dsp.internal.g0.c.a("OkDownload DynamicSerial", false));
    public static final int m = 0;
    public static final String n = "DownloadSerialQueue";
    public volatile boolean f;
    public volatile boolean g;
    public volatile boolean h;
    public volatile f i;
    public final ArrayList<f> j;

    @NonNull
    public com.ipd.dsp.internal.q0.f k;

    public e() {
        this(null);
    }

    public void a(c cVar) {
        this.k = new com.ipd.dsp.internal.q0.f.a().a(this).a(cVar).a();
    }

    public int b() {
        if (this.i != null) {
            return this.i.b();
        }
        return 0;
    }

    public synchronized void c() {
        if (this.h) {
            com.ipd.dsp.internal.g0.c.c(n, "require pause this queue(remain " + this.j.size() + "), butit has already been paused");
            return;
        }
        this.h = true;
        if (this.i != null) {
            this.i.f();
            this.j.add(0, this.i);
            this.i = null;
        }
    }

    public synchronized void d() {
        if (!this.h) {
            com.ipd.dsp.internal.g0.c.c(n, "require resume this queue(remain " + this.j.size() + "), but it is still running");
            return;
        }
        this.h = false;
        if (this.j.isEmpty() || this.g) {
            return;
        }
        this.g = true;
        f();
    }

    public synchronized f[] e() {
        f[] fVarArr;
        this.f = true;
        if (this.i != null) {
            this.i.f();
        }
        fVarArr = new f[this.j.size()];
        this.j.toArray(fVarArr);
        this.j.clear();
        return fVarArr;
    }

    public void f() {
        l.execute(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        f fVarRemove;
        while (!this.f) {
            synchronized (this) {
                if (!this.j.isEmpty() && !this.h) {
                    fVarRemove = this.j.remove(0);
                }
                this.i = null;
                this.g = false;
                return;
            }
            fVarRemove.b(this.k);
        }
    }

    @Override // com.ipd.dsp.internal.f0.c
    public synchronized void taskEnd(@NonNull f fVar, @NonNull com.ipd.dsp.internal.i0.a aVar, @Nullable Exception exc) {
        if (aVar == com.ipd.dsp.internal.i0.a.CANCELED || fVar != this.i) {
            return;
        }
        this.i = null;
    }

    @Override // com.ipd.dsp.internal.f0.c
    public void taskStart(@NonNull f fVar) {
        this.i = fVar;
    }

    public e(c cVar, ArrayList<f> arrayList) {
        this.f = false;
        this.g = false;
        this.h = false;
        this.k = new com.ipd.dsp.internal.q0.f.a().a(this).a(cVar).a();
        this.j = arrayList;
    }

    public synchronized void a(f fVar) {
        this.j.add(fVar);
        Collections.sort(this.j);
        if (this.h || this.g) {
            return;
        }
        this.g = true;
        f();
    }

    public int a() {
        return this.j.size();
    }

    public e(c cVar) {
        this(cVar, new ArrayList());
    }
}
