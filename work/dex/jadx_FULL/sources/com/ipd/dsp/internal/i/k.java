package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.ipd.dsp.Dsp;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class k implements m, com.ipd.dsp.internal.k.j.a, p.a {
    public static final String i = "Engine";
    public static final int j = 150;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f38334a;
    public final o b;
    public final com.ipd.dsp.internal.k.j c;
    public final b d;
    public final y e;
    public final c f;
    public final a g;
    public final com.ipd.dsp.internal.i.a h;

    @VisibleForTesting
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h.e f38335a;
        public final Pools.Pool<h<?>> b = com.ipd.dsp.internal.e0.a.b(150, new C0885a());
        public int c;

        /* JADX INFO: renamed from: com.ipd.dsp.internal.i.k$a$a, reason: collision with other inner class name */
        public class C0885a implements com.ipd.dsp.internal.e0.a.d<h<?>> {
            public C0885a() {
            }

            @Override // com.ipd.dsp.internal.e0.a.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public h<?> a() {
                a aVar = a.this;
                return new h<>(aVar.f38335a, aVar.b);
            }
        }

        public a(h.e eVar) {
            this.f38335a = eVar;
        }

        public <R> h<R> a(com.ipd.dsp.internal.components.glide.c cVar, Object obj, n nVar, com.ipd.dsp.internal.f.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, com.ipd.dsp.internal.b.e eVar, j jVar, Map<Class<?>, com.ipd.dsp.internal.f.m<?>> map, boolean z, boolean z2, boolean z3, com.ipd.dsp.internal.f.i iVar, h.b<R> bVar) {
            h hVar = (h) com.ipd.dsp.internal.d0.m.a(this.b.acquire());
            int i3 = this.c;
            this.c = i3 + 1;
            return hVar.a(cVar, obj, nVar, fVar, i, i2, cls, cls2, eVar, jVar, map, z, z2, z3, iVar, bVar, i3);
        }
    }

    public static class c implements h.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ipd.dsp.internal.k.a.InterfaceC0888a f38339a;
        public volatile com.ipd.dsp.internal.k.a b;

        public c(com.ipd.dsp.internal.k.a.InterfaceC0888a interfaceC0888a) {
            this.f38339a = interfaceC0888a;
        }

        @Override // com.ipd.dsp.internal.i.h.e
        public com.ipd.dsp.internal.k.a a() {
            if (this.b == null) {
                synchronized (this) {
                    if (this.b == null) {
                        this.b = this.f38339a.build();
                    }
                    if (this.b == null) {
                        this.b = new com.ipd.dsp.internal.k.b();
                    }
                }
            }
            return this.b;
        }

        @VisibleForTesting
        public synchronized void b() {
            if (this.b == null) {
                return;
            }
            this.b.clear();
        }
    }

    public class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l<?> f38340a;
        public final com.ipd.dsp.internal.z.j b;

        public d(com.ipd.dsp.internal.z.j jVar, l<?> lVar) {
            this.b = jVar;
            this.f38340a = lVar;
        }

        public void a() {
            synchronized (k.this) {
                this.f38340a.c(this.b);
            }
        }
    }

    public k(com.ipd.dsp.internal.k.j jVar, com.ipd.dsp.internal.k.a.InterfaceC0888a interfaceC0888a, com.ipd.dsp.internal.l.a aVar, com.ipd.dsp.internal.l.a aVar2, com.ipd.dsp.internal.l.a aVar3, com.ipd.dsp.internal.l.a aVar4, boolean z) {
        this(jVar, interfaceC0888a, aVar, aVar2, aVar3, aVar4, null, null, null, null, null, null, z);
    }

    public <R> d a(com.ipd.dsp.internal.components.glide.c cVar, Object obj, com.ipd.dsp.internal.f.f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.ipd.dsp.internal.b.e eVar, j jVar, Map<Class<?>, com.ipd.dsp.internal.f.m<?>> map, boolean z, boolean z2, com.ipd.dsp.internal.f.i iVar, boolean z3, boolean z4, boolean z5, boolean z6, com.ipd.dsp.internal.z.j jVar2, Executor executor) {
        long jA = Dsp.isDebugLogEnable() ? com.ipd.dsp.internal.d0.i.a() : 0L;
        n nVarA = this.b.a(obj, fVar, i2, i3, map, cls, cls2, iVar);
        synchronized (this) {
            p<?> pVarA = a(nVarA, z3, jA);
            if (pVarA == null) {
                return a(cVar, obj, fVar, i2, i3, cls, cls2, eVar, jVar, map, z, z2, iVar, z3, z4, z5, z6, jVar2, executor, nVarA, jA);
            }
            jVar2.a(pVarA, com.ipd.dsp.internal.f.a.MEMORY_CACHE, false);
            return null;
        }
    }

    @Nullable
    public final p<?> b(com.ipd.dsp.internal.f.f fVar) {
        p<?> pVarB = this.h.b(fVar);
        if (pVarB != null) {
            pVarB.a();
        }
        return pVarB;
    }

    public final p<?> c(com.ipd.dsp.internal.f.f fVar) {
        p<?> pVarA = a(fVar);
        if (pVarA != null) {
            pVarA.a();
            this.h.a(fVar, pVarA);
        }
        return pVarA;
    }

    @VisibleForTesting
    public k(com.ipd.dsp.internal.k.j jVar, com.ipd.dsp.internal.k.a.InterfaceC0888a interfaceC0888a, com.ipd.dsp.internal.l.a aVar, com.ipd.dsp.internal.l.a aVar2, com.ipd.dsp.internal.l.a aVar3, com.ipd.dsp.internal.l.a aVar4, s sVar, o oVar, com.ipd.dsp.internal.i.a aVar5, b bVar, a aVar6, y yVar, boolean z) {
        this.c = jVar;
        c cVar = new c(interfaceC0888a);
        this.f = cVar;
        com.ipd.dsp.internal.i.a aVar7 = aVar5 == null ? new com.ipd.dsp.internal.i.a(z) : aVar5;
        this.h = aVar7;
        aVar7.a(this);
        this.b = oVar == null ? new o() : oVar;
        this.f38334a = sVar == null ? new s() : sVar;
        this.d = bVar == null ? new b(aVar, aVar2, aVar3, aVar4, this, this) : bVar;
        this.g = aVar6 == null ? new a(cVar) : aVar6;
        this.e = yVar == null ? new y() : yVar;
        jVar.a(this);
    }

    public void b(v<?> vVar) {
        if (vVar instanceof p) {
            ((p) vVar).g();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ipd.dsp.internal.l.a f38337a;
        public final com.ipd.dsp.internal.l.a b;
        public final com.ipd.dsp.internal.l.a c;
        public final com.ipd.dsp.internal.l.a d;
        public final m e;
        public final p.a f;
        public final Pools.Pool<l<?>> g = com.ipd.dsp.internal.e0.a.b(150, new a());

        public class a implements com.ipd.dsp.internal.e0.a.d<l<?>> {
            public a() {
            }

            @Override // com.ipd.dsp.internal.e0.a.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public l<?> a() {
                b bVar = b.this;
                return new l<>(bVar.f38337a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
            }
        }

        public b(com.ipd.dsp.internal.l.a aVar, com.ipd.dsp.internal.l.a aVar2, com.ipd.dsp.internal.l.a aVar3, com.ipd.dsp.internal.l.a aVar4, m mVar, p.a aVar5) {
            this.f38337a = aVar;
            this.b = aVar2;
            this.c = aVar3;
            this.d = aVar4;
            this.e = mVar;
            this.f = aVar5;
        }

        @VisibleForTesting
        public void a() {
            com.ipd.dsp.internal.d0.f.a(this.f38337a);
            com.ipd.dsp.internal.d0.f.a(this.b);
            com.ipd.dsp.internal.d0.f.a(this.c);
            com.ipd.dsp.internal.d0.f.a(this.d);
        }

        public <R> l<R> a(com.ipd.dsp.internal.f.f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((l) com.ipd.dsp.internal.d0.m.a(this.g.acquire())).a(fVar, z, z2, z3, z4);
        }
    }

    @VisibleForTesting
    public void b() {
        this.d.a();
        this.f.b();
        this.h.b();
    }

    public final <R> d a(com.ipd.dsp.internal.components.glide.c cVar, Object obj, com.ipd.dsp.internal.f.f fVar, int i2, int i3, Class<?> cls, Class<R> cls2, com.ipd.dsp.internal.b.e eVar, j jVar, Map<Class<?>, com.ipd.dsp.internal.f.m<?>> map, boolean z, boolean z2, com.ipd.dsp.internal.f.i iVar, boolean z3, boolean z4, boolean z5, boolean z6, com.ipd.dsp.internal.z.j jVar2, Executor executor, n nVar, long j2) {
        l<?> lVarA = this.f38334a.a(nVar, z6);
        if (lVarA != null) {
            lVarA.a(jVar2, executor);
            if (Dsp.isDebugLogEnable()) {
                a("Added to existing load", j2, nVar);
            }
            return new d(jVar2, lVarA);
        }
        l<R> lVarA2 = this.d.a(nVar, z3, z4, z5, z6);
        h<R> hVarA = this.g.a(cVar, obj, nVar, fVar, i2, i3, cls, cls2, eVar, jVar, map, z, z2, z6, iVar, lVarA2);
        this.f38334a.a((com.ipd.dsp.internal.f.f) nVar, (l<?>) lVarA2);
        lVarA2.a(jVar2, executor);
        lVarA2.b(hVarA);
        if (Dsp.isDebugLogEnable()) {
            a("Started new load", j2, nVar);
        }
        return new d(jVar2, lVarA2);
    }

    @Nullable
    public final p<?> a(n nVar, boolean z, long j2) {
        if (!z) {
            return null;
        }
        p<?> pVarB = b(nVar);
        if (pVarB != null) {
            if (Dsp.isDebugLogEnable()) {
                a("Loaded resource from active resources", j2, nVar);
            }
            return pVarB;
        }
        p<?> pVarC = c(nVar);
        if (pVarC == null) {
            return null;
        }
        if (Dsp.isDebugLogEnable()) {
            a("Loaded resource from cache", j2, nVar);
        }
        return pVarC;
    }

    public static void a(String str, long j2, com.ipd.dsp.internal.f.f fVar) {
        com.ipd.dsp.internal.c2.k.e(i, str + " in " + com.ipd.dsp.internal.d0.i.a(j2) + "ms, key: " + fVar);
    }

    public final p<?> a(com.ipd.dsp.internal.f.f fVar) {
        v<?> vVarA = this.c.a(fVar);
        if (vVarA == null) {
            return null;
        }
        if (vVarA instanceof p) {
            return (p) vVarA;
        }
        return new p<>(vVarA, true, true, fVar, this);
    }

    @Override // com.ipd.dsp.internal.i.m
    public synchronized void a(l<?> lVar, com.ipd.dsp.internal.f.f fVar, p<?> pVar) {
        if (pVar != null) {
            if (pVar.f()) {
                this.h.a(fVar, pVar);
            }
        }
        this.f38334a.b(fVar, lVar);
    }

    @Override // com.ipd.dsp.internal.i.m
    public synchronized void a(l<?> lVar, com.ipd.dsp.internal.f.f fVar) {
        this.f38334a.b(fVar, lVar);
    }

    @Override // com.ipd.dsp.internal.k.j.a
    public void a(@NonNull v<?> vVar) {
        this.e.a(vVar, true);
    }

    @Override // com.ipd.dsp.internal.i.p.a
    public void a(com.ipd.dsp.internal.f.f fVar, p<?> pVar) {
        this.h.a(fVar);
        if (pVar.f()) {
            this.c.a(fVar, pVar);
        } else {
            this.e.a(pVar, false);
        }
    }

    public void a() {
        this.f.a().clear();
    }
}
