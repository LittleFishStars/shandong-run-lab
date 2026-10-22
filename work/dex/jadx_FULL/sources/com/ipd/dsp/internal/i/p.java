package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class p<Z> implements v<Z> {
    public final boolean f;
    public final boolean g;
    public final v<Z> h;
    public final a i;
    public final com.ipd.dsp.internal.f.f j;
    public int k;
    public boolean l;

    public interface a {
        void a(com.ipd.dsp.internal.f.f fVar, p<?> pVar);
    }

    public p(v<Z> vVar, boolean z, boolean z2, com.ipd.dsp.internal.f.f fVar, a aVar) {
        this.h = (v) com.ipd.dsp.internal.d0.m.a(vVar);
        this.f = z;
        this.g = z2;
        this.j = fVar;
        this.i = (a) com.ipd.dsp.internal.d0.m.a(aVar);
    }

    public synchronized void a() {
        if (this.l) {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
        this.k++;
    }

    public v<Z> b() {
        return this.h;
    }

    @Override // com.ipd.dsp.internal.i.v
    public int c() {
        return this.h.c();
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public Class<Z> d() {
        return this.h.d();
    }

    @Override // com.ipd.dsp.internal.i.v
    public synchronized void e() {
        if (this.k > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        }
        if (this.l) {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
        this.l = true;
        if (this.g) {
            this.h.e();
        }
    }

    public boolean f() {
        return this.f;
    }

    public void g() {
        boolean z;
        synchronized (this) {
            int i = this.k;
            if (i <= 0) {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
            z = true;
            int i2 = i - 1;
            this.k = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            this.i.a(this.j, this);
        }
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public Z get() {
        return this.h.get();
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f + ", listener=" + this.i + ", key=" + this.j + ", acquired=" + this.k + ", isRecycled=" + this.l + ", resource=" + this.h + '}';
    }
}
