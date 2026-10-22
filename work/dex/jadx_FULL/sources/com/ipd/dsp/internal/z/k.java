package com.ipd.dsp.internal.z;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.a0.o;
import com.ipd.dsp.internal.a0.p;
import com.ipd.dsp.internal.i.q;
import com.ipd.dsp.internal.i.v;
import com.zj.adlib.bv9;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class k<R> implements e, o, j {
    public static final String E = "GlideRequest";
    public static final String F = "Glide";

    @GuardedBy("requestLock")
    public int A;

    @GuardedBy("requestLock")
    public int B;

    @GuardedBy("requestLock")
    public boolean C;

    @Nullable
    public RuntimeException D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38616a;

    @Nullable
    public final String b;
    public final com.ipd.dsp.internal.e0.c c;
    public final Object d;

    @Nullable
    public final h<R> e;
    public final f f;
    public final Context g;
    public final com.ipd.dsp.internal.components.glide.c h;

    @Nullable
    public final Object i;
    public final Class<R> j;
    public final com.ipd.dsp.internal.z.a<?> k;
    public final int l;
    public final int m;
    public final com.ipd.dsp.internal.b.e n;
    public final p<R> o;

    @Nullable
    public final List<h<R>> p;
    public final com.ipd.dsp.internal.b0.g<? super R> q;
    public final Executor r;

    @GuardedBy("requestLock")
    public v<R> s;

    @GuardedBy("requestLock")
    public com.ipd.dsp.internal.i.k.d t;

    @GuardedBy("requestLock")
    public long u;
    public volatile com.ipd.dsp.internal.i.k v;

    @GuardedBy("requestLock")
    public a w;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable x;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable y;

    @Nullable
    @GuardedBy("requestLock")
    public Drawable z;

    public enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public k(Context context, com.ipd.dsp.internal.components.glide.c cVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, com.ipd.dsp.internal.z.a<?> aVar, int i, int i2, com.ipd.dsp.internal.b.e eVar, p<R> pVar, @Nullable h<R> hVar, @Nullable List<h<R>> list, f fVar, com.ipd.dsp.internal.i.k kVar, com.ipd.dsp.internal.b0.g<? super R> gVar, Executor executor) {
        this.b = Dsp.isDebugLogEnable() ? String.valueOf(super.hashCode()) : null;
        this.c = com.ipd.dsp.internal.e0.c.a();
        this.d = obj;
        this.g = context;
        this.h = cVar;
        this.i = obj2;
        this.j = cls;
        this.k = aVar;
        this.l = i;
        this.m = i2;
        this.n = eVar;
        this.o = pVar;
        this.e = hVar;
        this.p = list;
        this.f = fVar;
        this.v = kVar;
        this.q = gVar;
        this.r = executor;
        this.w = a.PENDING;
        if (this.D == null && cVar.e().b(com.ipd.dsp.internal.components.glide.b.d.class)) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    public static <R> k<R> a(Context context, com.ipd.dsp.internal.components.glide.c cVar, Object obj, Object obj2, Class<R> cls, com.ipd.dsp.internal.z.a<?> aVar, int i, int i2, com.ipd.dsp.internal.b.e eVar, p<R> pVar, h<R> hVar, @Nullable List<h<R>> list, f fVar, com.ipd.dsp.internal.i.k kVar, com.ipd.dsp.internal.b0.g<? super R> gVar, Executor executor) {
        return new k<>(context, cVar, obj, obj2, cls, aVar, i, i2, eVar, pVar, hVar, list, fVar, kVar, gVar, executor);
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean b() {
        boolean z;
        synchronized (this.d) {
            z = this.w == a.CLEARED;
        }
        return z;
    }

    @Override // com.ipd.dsp.internal.z.j
    public Object c() {
        this.c.b();
        return this.d;
    }

    @Override // com.ipd.dsp.internal.z.e
    public void clear() {
        synchronized (this.d) {
            f();
            this.c.b();
            a aVar = this.w;
            a aVar2 = a.CLEARED;
            if (aVar == aVar2) {
                return;
            }
            j();
            v<R> vVar = this.s;
            if (vVar != null) {
                this.s = null;
            } else {
                vVar = null;
            }
            if (g()) {
                this.o.onLoadCleared(m());
            }
            com.ipd.dsp.internal.e0.b.a(E, this.f38616a);
            this.w = aVar2;
            if (vVar != null) {
                this.v.b((v<?>) vVar);
            }
        }
    }

    @Override // com.ipd.dsp.internal.z.e
    public void d() {
        synchronized (this.d) {
            f();
            this.c.b();
            this.u = com.ipd.dsp.internal.d0.i.a();
            Object obj = this.i;
            if (obj == null) {
                if (com.ipd.dsp.internal.d0.o.b(this.l, this.m)) {
                    this.A = this.l;
                    this.B = this.m;
                }
                a(new q("Received null model"), l() == null);
                return;
            }
            a aVar = this.w;
            a aVar2 = a.RUNNING;
            if (aVar == aVar2) {
                throw new IllegalArgumentException("Cannot restart a running request");
            }
            if (aVar == a.COMPLETE) {
                a(this.s, com.ipd.dsp.internal.f.a.MEMORY_CACHE, false);
                return;
            }
            a(obj);
            this.f38616a = com.ipd.dsp.internal.e0.b.b(E);
            a aVar3 = a.WAITING_FOR_SIZE;
            this.w = aVar3;
            if (com.ipd.dsp.internal.d0.o.b(this.l, this.m)) {
                a(this.l, this.m);
            } else {
                this.o.getSize(this);
            }
            a aVar4 = this.w;
            if ((aVar4 == aVar2 || aVar4 == aVar3) && h()) {
                this.o.onLoadStarted(m());
            }
            if (Dsp.isDebugLogEnable()) {
                a("finished run method in " + com.ipd.dsp.internal.d0.i.a(this.u));
            }
        }
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean e() {
        boolean z;
        synchronized (this.d) {
            z = this.w == a.COMPLETE;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final void f() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    public final boolean g() {
        f fVar = this.f;
        return fVar == null || fVar.b(this);
    }

    @GuardedBy("requestLock")
    public final boolean h() {
        f fVar = this.f;
        return fVar == null || fVar.e(this);
    }

    @GuardedBy("requestLock")
    public final boolean i() {
        f fVar = this.f;
        return fVar == null || fVar.d(this);
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean isRunning() {
        boolean z;
        synchronized (this.d) {
            a aVar = this.w;
            z = aVar == a.RUNNING || aVar == a.WAITING_FOR_SIZE;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final void j() {
        f();
        this.c.b();
        this.o.removeCallback(this);
        com.ipd.dsp.internal.i.k.d dVar = this.t;
        if (dVar != null) {
            dVar.a();
            this.t = null;
        }
    }

    @GuardedBy("requestLock")
    public final Drawable k() {
        if (this.x == null) {
            Drawable drawableK = this.k.k();
            this.x = drawableK;
            if (drawableK == null && this.k.j() > 0) {
                this.x = a(this.k.j());
            }
        }
        return this.x;
    }

    @GuardedBy("requestLock")
    public final Drawable l() {
        if (this.z == null) {
            Drawable drawableL = this.k.l();
            this.z = drawableL;
            if (drawableL == null && this.k.m() > 0) {
                this.z = a(this.k.m());
            }
        }
        return this.z;
    }

    @GuardedBy("requestLock")
    public final Drawable m() {
        if (this.y == null) {
            Drawable drawableR = this.k.r();
            this.y = drawableR;
            if (drawableR == null && this.k.s() > 0) {
                this.y = a(this.k.s());
            }
        }
        return this.y;
    }

    @GuardedBy("requestLock")
    public final boolean n() {
        f fVar = this.f;
        return fVar == null || !fVar.getRoot().a();
    }

    @GuardedBy("requestLock")
    public final void o() {
        f fVar = this.f;
        if (fVar != null) {
            fVar.a(this);
        }
    }

    @GuardedBy("requestLock")
    public final void p() {
        f fVar = this.f;
        if (fVar != null) {
            fVar.f(this);
        }
    }

    @Override // com.ipd.dsp.internal.z.e
    public void pause() {
        synchronized (this.d) {
            if (isRunning()) {
                clear();
            }
        }
    }

    @GuardedBy("requestLock")
    public final void q() {
        if (h()) {
            Drawable drawableL = this.i == null ? l() : null;
            if (drawableL == null) {
                drawableL = k();
            }
            if (drawableL == null) {
                drawableL = m();
            }
            this.o.onLoadFailed(drawableL);
        }
    }

    public String toString() {
        Object obj;
        Class<R> cls;
        synchronized (this.d) {
            obj = this.i;
            cls = this.j;
        }
        return super.toString() + "[model=" + obj + ", transcodeClass=" + cls + "]";
    }

    public final void a(Object obj) {
        List<h<R>> list = this.p;
        if (list == null) {
            return;
        }
        for (h<R> hVar : list) {
            if (hVar instanceof c) {
                ((c) hVar).a(obj);
            }
        }
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean c(e eVar) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        com.ipd.dsp.internal.z.a<?> aVar;
        com.ipd.dsp.internal.b.e eVar2;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        com.ipd.dsp.internal.z.a<?> aVar2;
        com.ipd.dsp.internal.b.e eVar3;
        int size2;
        if (!(eVar instanceof k)) {
            return false;
        }
        synchronized (this.d) {
            i = this.l;
            i2 = this.m;
            obj = this.i;
            cls = this.j;
            aVar = this.k;
            eVar2 = this.n;
            List<h<R>> list = this.p;
            size = list != null ? list.size() : 0;
        }
        k kVar = (k) eVar;
        synchronized (kVar.d) {
            i3 = kVar.l;
            i4 = kVar.m;
            obj2 = kVar.i;
            cls2 = kVar.j;
            aVar2 = kVar.k;
            eVar3 = kVar.n;
            List<h<R>> list2 = kVar.p;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i == i3 && i2 == i4 && com.ipd.dsp.internal.d0.o.a(obj, obj2) && cls.equals(cls2) && com.ipd.dsp.internal.d0.o.a(aVar, aVar2) && eVar2 == eVar3 && size == size2;
    }

    @Override // com.ipd.dsp.internal.z.e
    public boolean a() {
        boolean z;
        synchronized (this.d) {
            z = this.w == a.COMPLETE;
        }
        return z;
    }

    @GuardedBy("requestLock")
    public final Drawable a(@DrawableRes int i) {
        return com.ipd.dsp.internal.s.c.a(this.g, i, this.k.x() != null ? this.k.x() : this.g.getTheme());
    }

    @Override // com.ipd.dsp.internal.a0.o
    public void a(int i, int i2) throws Throwable {
        Object obj;
        this.c.b();
        Object obj2 = this.d;
        synchronized (obj2) {
            try {
                try {
                    if (Dsp.isDebugLogEnable()) {
                        a("Got onSizeReady in " + com.ipd.dsp.internal.d0.i.a(this.u));
                    }
                    if (this.w == a.WAITING_FOR_SIZE) {
                        a aVar = a.RUNNING;
                        this.w = aVar;
                        float fW = this.k.w();
                        this.A = a(i, fW);
                        this.B = a(i2, fW);
                        if (Dsp.isDebugLogEnable()) {
                            a("finished setup for calling load in " + com.ipd.dsp.internal.d0.i.a(this.u));
                        }
                        obj = obj2;
                        try {
                            this.t = this.v.a(this.h, this.i, this.k.v(), this.A, this.B, this.k.u(), this.j, this.n, this.k.i(), this.k.y(), this.k.J(), this.k.G(), this.k.o(), this.k.E(), this.k.A(), this.k.z(), this.k.n(), this, this.r);
                            if (this.w != aVar) {
                                this.t = null;
                            }
                            if (Dsp.isDebugLogEnable()) {
                                a("finished onSizeReady in " + com.ipd.dsp.internal.d0.i.a(this.u));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    public static int a(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.ipd.dsp.internal.z.k, com.ipd.dsp.internal.z.k<R>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v2, types: [com.ipd.dsp.internal.z.k] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Type inference failed for: r8v8 */
    @Override // com.ipd.dsp.internal.z.j
    public void a(v<?> vVar, com.ipd.dsp.internal.f.a aVar, boolean z) throws Throwable {
        ?? r7;
        Throwable th;
        this.c.b();
        v<?> vVar2 = null;
        try {
            synchronized (this.d) {
                try {
                    this.t = null;
                    if (vVar == null) {
                        a(new q("Expected to receive a Resource<R> with an object of " + this.j + " inside, but instead got null."));
                        return;
                    }
                    Object obj = vVar.get();
                    try {
                        if (obj != null && this.j.isAssignableFrom(obj.getClass())) {
                            if (!i()) {
                                this.s = null;
                                this.w = a.COMPLETE;
                                com.ipd.dsp.internal.e0.b.a(E, this.f38616a);
                                this.v.b(vVar);
                                return;
                            }
                            a(vVar, obj, aVar, z);
                            return;
                        }
                        this.s = null;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Expected to receive an object of ");
                        sb.append(this.j);
                        sb.append(" but instead got ");
                        sb.append(obj != null ? obj.getClass() : "");
                        sb.append(bv9.b);
                        sb.append(obj);
                        sb.append("} inside Resource{");
                        sb.append(vVar);
                        sb.append("}.");
                        sb.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
                        a(new q(sb.toString()));
                        this.v.b(vVar);
                    } catch (Throwable th2) {
                        th = th2;
                        vVar2 = vVar;
                        r7 = this;
                        while (true) {
                            try {
                                try {
                                    throw th;
                                } catch (Throwable th3) {
                                    th = th3;
                                    if (vVar2 != null) {
                                        r7.v.b(vVar2);
                                    }
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                r7 = r7;
                            }
                            th = th4;
                            r7 = r7;
                        }
                    }
                } catch (Throwable th5) {
                    th = th5;
                    r7 = this;
                }
            }
        } catch (Throwable th6) {
            th = th6;
            r7 = this;
        }
    }

    @GuardedBy("requestLock")
    public final void a(v<R> vVar, R r, com.ipd.dsp.internal.f.a aVar, boolean z) {
        boolean zA;
        boolean zN = n();
        this.w = a.COMPLETE;
        this.s = vVar;
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.a("Glide", "Finished loading " + r.getClass().getSimpleName() + " from " + aVar + " for " + this.i + " with size [" + this.A + "x" + this.B + "] in " + com.ipd.dsp.internal.d0.i.a(this.u) + " ms");
        }
        p();
        boolean z2 = true;
        this.C = true;
        try {
            List<h<R>> list = this.p;
            if (list != null) {
                zA = false;
                for (h<R> hVar : list) {
                    boolean zOnResourceReady = zA | hVar.onResourceReady(r, this.i, this.o, aVar, zN);
                    zA = hVar instanceof c ? zOnResourceReady | ((c) hVar).a(r, this.i, this.o, aVar, zN, z) : zOnResourceReady;
                }
            } else {
                zA = false;
            }
            h<R> hVar2 = this.e;
            if (hVar2 == null || !hVar2.onResourceReady(r, this.i, this.o, aVar, zN)) {
                z2 = false;
            }
            if (!(zA | z2)) {
                this.o.onResourceReady(r, this.q.a(aVar, zN));
            }
            this.C = false;
            com.ipd.dsp.internal.e0.b.a(E, this.f38616a);
        } catch (Throwable th) {
            this.C = false;
            throw th;
        }
    }

    @Override // com.ipd.dsp.internal.z.j
    public void a(q qVar) {
        a(qVar, true);
    }

    public final void a(q qVar, boolean z) {
        boolean zOnLoadFailed;
        this.c.b();
        synchronized (this.d) {
            qVar.a(this.D);
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e("Glide", "Load failed for [" + this.i + "] with dimensions [" + this.A + "x" + this.B + "]", qVar);
                if (!z) {
                    qVar.a("Glide");
                }
            }
            this.t = null;
            this.w = a.FAILED;
            o();
            boolean z2 = true;
            this.C = true;
            try {
                List<h<R>> list = this.p;
                if (list != null) {
                    Iterator<h<R>> it = list.iterator();
                    zOnLoadFailed = false;
                    while (it.hasNext()) {
                        zOnLoadFailed |= it.next().onLoadFailed(qVar, this.i, this.o, n());
                    }
                } else {
                    zOnLoadFailed = false;
                }
                h<R> hVar = this.e;
                if (hVar == null || !hVar.onLoadFailed(qVar, this.i, this.o, n())) {
                    z2 = false;
                }
                if (!(zOnLoadFailed | z2)) {
                    q();
                }
                this.C = false;
                com.ipd.dsp.internal.e0.b.a(E, this.f38616a);
            } catch (Throwable th) {
                this.C = false;
                throw th;
            }
        }
    }

    public final void a(String str) {
        com.ipd.dsp.internal.c2.k.e(E, str + " this: " + this.b);
    }
}
