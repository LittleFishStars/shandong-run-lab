package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class u<Z> implements v<Z>, com.ipd.dsp.internal.e0.a.f {
    public static final Pools.Pool<u<?>> j = com.ipd.dsp.internal.e0.a.b(20, new a());
    public final com.ipd.dsp.internal.e0.c f = com.ipd.dsp.internal.e0.c.a();
    public v<Z> g;
    public boolean h;
    public boolean i;

    public class a implements com.ipd.dsp.internal.e0.a.d<u<?>> {
        @Override // com.ipd.dsp.internal.e0.a.d
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public u<?> a() {
            return new u<>();
        }
    }

    @NonNull
    public static <Z> u<Z> b(v<Z> vVar) {
        u<Z> uVar = (u) com.ipd.dsp.internal.d0.m.a(j.acquire());
        uVar.a(vVar);
        return uVar;
    }

    public final void a(v<Z> vVar) {
        this.i = false;
        this.h = true;
        this.g = vVar;
    }

    @Override // com.ipd.dsp.internal.i.v
    public int c() {
        return this.g.c();
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public Class<Z> d() {
        return this.g.d();
    }

    @Override // com.ipd.dsp.internal.i.v
    public synchronized void e() {
        this.f.b();
        this.i = true;
        if (this.h) {
            return;
        }
        this.g.e();
        a();
    }

    public synchronized void f() {
        this.f.b();
        if (!this.h) {
            throw new IllegalStateException("Already unlocked");
        }
        this.h = false;
        if (this.i) {
            e();
        }
    }

    @Override // com.ipd.dsp.internal.i.v
    @NonNull
    public Z get() {
        return this.g.get();
    }

    @Override // com.ipd.dsp.internal.e0.a.f
    @NonNull
    public com.ipd.dsp.internal.e0.c b() {
        return this.f;
    }

    private void a() {
        this.g = null;
        j.release(this);
    }
}
