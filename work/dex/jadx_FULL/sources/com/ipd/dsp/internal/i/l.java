package com.ipd.dsp.internal.i;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class l<R> implements h.b<R>, com.ipd.dsp.internal.e0.a.f {
    public static final c E = new c();
    public p<?> A;
    public h<R> B;
    public volatile boolean C;
    public boolean D;
    public final e f;
    public final com.ipd.dsp.internal.e0.c g;
    public final p.a h;
    public final Pools.Pool<l<?>> i;
    public final c j;
    public final m k;
    public final com.ipd.dsp.internal.l.a l;
    public final com.ipd.dsp.internal.l.a m;
    public final com.ipd.dsp.internal.l.a n;
    public final com.ipd.dsp.internal.l.a o;
    public final AtomicInteger p;
    public com.ipd.dsp.internal.f.f q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public v<?> v;
    public com.ipd.dsp.internal.f.a w;
    public boolean x;
    public q y;
    public boolean z;

    public class a implements Runnable {
        public final com.ipd.dsp.internal.z.j f;

        public a(com.ipd.dsp.internal.z.j jVar) {
            this.f = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f.c()) {
                synchronized (l.this) {
                    if (l.this.f.a(this.f)) {
                        l.this.a(this.f);
                    }
                    l.this.c();
                }
            }
        }
    }

    public class b implements Runnable {
        public final com.ipd.dsp.internal.z.j f;

        public b(com.ipd.dsp.internal.z.j jVar) {
            this.f = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this.f.c()) {
                synchronized (l.this) {
                    if (l.this.f.a(this.f)) {
                        l.this.A.a();
                        l.this.b(this.f);
                        l.this.c(this.f);
                    }
                    l.this.c();
                }
            }
        }
    }

    @VisibleForTesting
    public static class c {
        public <R> p<R> a(v<R> vVar, boolean z, com.ipd.dsp.internal.f.f fVar, p.a aVar) {
            return new p<>(vVar, z, true, fVar, aVar);
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ipd.dsp.internal.z.j f38341a;
        public final Executor b;

        public d(com.ipd.dsp.internal.z.j jVar, Executor executor) {
            this.f38341a = jVar;
            this.b = executor;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f38341a.equals(((d) obj).f38341a);
            }
            return false;
        }

        public int hashCode() {
            return this.f38341a.hashCode();
        }
    }

    public static final class e implements Iterable<d> {
        public final List<d> f;

        public e() {
            this(new ArrayList(2));
        }

        public static d b(com.ipd.dsp.internal.z.j jVar) {
            return new d(jVar, com.ipd.dsp.internal.d0.f.a());
        }

        public void a(com.ipd.dsp.internal.z.j jVar, Executor executor) {
            this.f.add(new d(jVar, executor));
        }

        public void c(com.ipd.dsp.internal.z.j jVar) {
            this.f.remove(b(jVar));
        }

        public void clear() {
            this.f.clear();
        }

        public boolean isEmpty() {
            return this.f.isEmpty();
        }

        @Override // java.lang.Iterable
        @NonNull
        public Iterator<d> iterator() {
            return this.f.iterator();
        }

        public int size() {
            return this.f.size();
        }

        public e(List<d> list) {
            this.f = list;
        }

        public boolean a(com.ipd.dsp.internal.z.j jVar) {
            return this.f.contains(b(jVar));
        }

        public e a() {
            return new e(new ArrayList(this.f));
        }
    }

    public l(com.ipd.dsp.internal.l.a aVar, com.ipd.dsp.internal.l.a aVar2, com.ipd.dsp.internal.l.a aVar3, com.ipd.dsp.internal.l.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, pool, E);
    }

    private synchronized void j() {
        if (this.q == null) {
            throw new IllegalArgumentException();
        }
        this.f.clear();
        this.q = null;
        this.A = null;
        this.v = null;
        this.z = false;
        this.C = false;
        this.x = false;
        this.D = false;
        this.B.a(false);
        this.B = null;
        this.y = null;
        this.w = null;
        this.i.release(this);
    }

    @VisibleForTesting
    public synchronized l<R> a(com.ipd.dsp.internal.f.f fVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.q = fVar;
        this.r = z;
        this.s = z2;
        this.t = z3;
        this.u = z4;
        return this;
    }

    public synchronized void b(h<R> hVar) {
        this.B = hVar;
        (hVar.n() ? this.l : d()).execute(hVar);
    }

    public synchronized void c(com.ipd.dsp.internal.z.j jVar) {
        this.g.b();
        this.f.c(jVar);
        if (this.f.isEmpty()) {
            a();
            if (!this.x && !this.z) {
                return;
            }
            if (this.p.get() == 0) {
                j();
            }
        }
    }

    public final com.ipd.dsp.internal.l.a d() {
        if (this.s) {
            return this.n;
        }
        return this.t ? this.o : this.m;
    }

    public synchronized boolean e() {
        return this.C;
    }

    public final boolean f() {
        return this.z || this.x || this.C;
    }

    public void g() {
        synchronized (this) {
            this.g.b();
            if (this.C) {
                j();
                return;
            }
            if (this.f.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            if (this.z) {
                throw new IllegalStateException("Already failed once");
            }
            this.z = true;
            com.ipd.dsp.internal.f.f fVar = this.q;
            e eVarA = this.f.a();
            a(eVarA.size() + 1);
            this.k.a(this, fVar, null);
            for (d dVar : eVarA) {
                dVar.b.execute(new a(dVar.f38341a));
            }
            c();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void h() {
        synchronized (this) {
            this.g.b();
            if (this.C) {
                this.v.e();
                j();
                return;
            }
            if (this.f.isEmpty()) {
                throw new IllegalStateException("Received a resource without any callbacks to notify");
            }
            if (this.x) {
                throw new IllegalStateException("Already have resource");
            }
            this.A = this.j.a(this.v, this.r, this.q, this.h);
            this.x = true;
            e eVarA = this.f.a();
            a(eVarA.size() + 1);
            this.k.a(this, this.q, this.A);
            for (d dVar : eVarA) {
                dVar.b.execute(new b(dVar.f38341a));
            }
            c();
        }
    }

    public boolean i() {
        return this.u;
    }

    @VisibleForTesting
    public l(com.ipd.dsp.internal.l.a aVar, com.ipd.dsp.internal.l.a aVar2, com.ipd.dsp.internal.l.a aVar3, com.ipd.dsp.internal.l.a aVar4, m mVar, p.a aVar5, Pools.Pool<l<?>> pool, c cVar) {
        this.f = new e();
        this.g = com.ipd.dsp.internal.e0.c.a();
        this.p = new AtomicInteger();
        this.l = aVar;
        this.m = aVar2;
        this.n = aVar3;
        this.o = aVar4;
        this.k = mVar;
        this.h = aVar5;
        this.i = pool;
        this.j = cVar;
    }

    @GuardedBy("this")
    public void b(com.ipd.dsp.internal.z.j jVar) {
        try {
            jVar.a(this.A, this.w, this.D);
        } catch (Throwable th) {
            throw new com.ipd.dsp.internal.i.b(th);
        }
    }

    public synchronized void a(com.ipd.dsp.internal.z.j jVar, Executor executor) {
        this.g.b();
        this.f.a(jVar, executor);
        if (this.x) {
            a(1);
            executor.execute(new b(jVar));
        } else if (this.z) {
            a(1);
            executor.execute(new a(jVar));
        } else {
            com.ipd.dsp.internal.d0.m.a(!this.C, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    @Override // com.ipd.dsp.internal.e0.a.f
    @NonNull
    public com.ipd.dsp.internal.e0.c b() {
        return this.g;
    }

    public void c() {
        p<?> pVar;
        synchronized (this) {
            this.g.b();
            com.ipd.dsp.internal.d0.m.a(f(), "Not yet complete!");
            int iDecrementAndGet = this.p.decrementAndGet();
            com.ipd.dsp.internal.d0.m.a(iDecrementAndGet >= 0, "Can't decrement below 0");
            if (iDecrementAndGet == 0) {
                pVar = this.A;
                j();
            } else {
                pVar = null;
            }
        }
        if (pVar != null) {
            pVar.g();
        }
    }

    @GuardedBy("this")
    public void a(com.ipd.dsp.internal.z.j jVar) {
        try {
            jVar.a(this.y);
        } catch (Throwable th) {
            throw new com.ipd.dsp.internal.i.b(th);
        }
    }

    public void a() {
        if (f()) {
            return;
        }
        this.C = true;
        this.B.c();
        this.k.a(this, this.q);
    }

    public synchronized void a(int i) {
        p<?> pVar;
        com.ipd.dsp.internal.d0.m.a(f(), "Not yet complete!");
        if (this.p.getAndAdd(i) != 0 || (pVar = this.A) == null) {
            return;
        }
        pVar.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ipd.dsp.internal.i.h.b
    public void a(v<R> vVar, com.ipd.dsp.internal.f.a aVar, boolean z) {
        synchronized (this) {
            this.v = vVar;
            this.w = aVar;
            this.D = z;
        }
        h();
    }

    @Override // com.ipd.dsp.internal.i.h.b
    public void a(q qVar) {
        synchronized (this) {
            this.y = qVar;
        }
        g();
    }

    @Override // com.ipd.dsp.internal.i.h.b
    public void a(h<?> hVar) {
        d().execute(hVar);
    }
}
