package com.ipd.dsp.internal.i;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.ipd.dsp.Dsp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h<R> implements com.ipd.dsp.internal.i.f.a, Runnable, Comparable<h<?>>, com.ipd.dsp.internal.e0.a.f {
    public static final String L = "DecodeJob";
    public Object A;
    public Thread B;
    public com.ipd.dsp.internal.f.f C;
    public com.ipd.dsp.internal.f.f D;
    public Object E;
    public com.ipd.dsp.internal.f.a F;
    public com.ipd.dsp.internal.g.d<?> G;
    public volatile com.ipd.dsp.internal.i.f H;
    public volatile boolean I;
    public volatile boolean J;
    public boolean K;
    public final e i;
    public final Pools.Pool<h<?>> j;
    public com.ipd.dsp.internal.components.glide.c m;
    public com.ipd.dsp.internal.f.f n;
    public com.ipd.dsp.internal.b.e o;
    public n p;
    public int q;
    public int r;
    public j s;
    public com.ipd.dsp.internal.f.i t;
    public b<R> u;
    public int v;
    public EnumC0884h w;
    public g x;
    public long y;
    public boolean z;
    public final com.ipd.dsp.internal.i.g<R> f = new com.ipd.dsp.internal.i.g<>();
    public final List<Throwable> g = new ArrayList();
    public final com.ipd.dsp.internal.e0.c h = com.ipd.dsp.internal.e0.c.a();
    public final d<?> k = new d<>();
    public final f l = new f();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38328a;
        public static final /* synthetic */ int[] b;
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.ipd.dsp.internal.f.c.values().length];
            c = iArr;
            try {
                iArr[com.ipd.dsp.internal.f.c.SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.ipd.dsp.internal.f.c.TRANSFORMED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[EnumC0884h.values().length];
            b = iArr2;
            try {
                iArr2[EnumC0884h.RESOURCE_CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[EnumC0884h.DATA_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                b[EnumC0884h.SOURCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                b[EnumC0884h.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                b[EnumC0884h.INITIALIZE.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[g.values().length];
            f38328a = iArr3;
            try {
                iArr3[g.INITIALIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f38328a[g.SWITCH_TO_SOURCE_SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f38328a[g.DECODE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public interface b<R> {
        void a(h<?> hVar);

        void a(q qVar);

        void a(v<R> vVar, com.ipd.dsp.internal.f.a aVar, boolean z);
    }

    public final class c<Z> implements i.a<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ipd.dsp.internal.f.a f38329a;

        public c(com.ipd.dsp.internal.f.a aVar) {
            this.f38329a = aVar;
        }

        @Override // com.ipd.dsp.internal.i.i.a
        @NonNull
        public v<Z> a(@NonNull v<Z> vVar) {
            return h.this.a(this.f38329a, vVar);
        }
    }

    public interface e {
        com.ipd.dsp.internal.k.a a();
    }

    public enum g {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.i.h$h, reason: collision with other inner class name */
    public enum EnumC0884h {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public h(e eVar, Pools.Pool<h<?>> pool) {
        this.i = eVar;
        this.j = pool;
    }

    public h<R> a(com.ipd.dsp.internal.components.glide.c cVar, Object obj, n nVar, com.ipd.dsp.internal.f.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, com.ipd.dsp.internal.b.e eVar, j jVar, Map<Class<?>, com.ipd.dsp.internal.f.m<?>> map, boolean z, boolean z2, boolean z3, com.ipd.dsp.internal.f.i iVar, b<R> bVar, int i3) {
        this.f.a(cVar, obj, fVar, i, i2, jVar, cls, cls2, eVar, iVar, map, z, z2, this.i);
        this.m = cVar;
        this.n = fVar;
        this.o = eVar;
        this.p = nVar;
        this.q = i;
        this.r = i2;
        this.s = jVar;
        this.z = z3;
        this.t = iVar;
        this.u = bVar;
        this.v = i3;
        this.x = g.INITIALIZE;
        this.A = obj;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(v<R> vVar, com.ipd.dsp.internal.f.a aVar, boolean z) {
        u uVar;
        com.ipd.dsp.internal.e0.b.a("DecodeJob.notifyEncodeAndRelease");
        try {
            if (vVar instanceof r) {
                ((r) vVar).a();
            }
            if (this.k.b()) {
                vVar = u.b(vVar);
                uVar = vVar;
            } else {
                uVar = 0;
            }
            a(vVar, aVar, z);
            this.w = EnumC0884h.ENCODE;
            try {
                if (this.k.b()) {
                    this.k.a(this.i, this.t);
                }
                if (uVar != 0) {
                    uVar.f();
                }
                h();
                com.ipd.dsp.internal.e0.b.a();
            } catch (Throwable th) {
                if (uVar != 0) {
                    uVar.f();
                }
                throw th;
            }
        } catch (Throwable th2) {
            com.ipd.dsp.internal.e0.b.a();
            throw th2;
        }
    }

    public void c() {
        this.J = true;
        com.ipd.dsp.internal.i.f fVar = this.H;
        if (fVar != null) {
            fVar.cancel();
        }
    }

    public final void d() {
        v<R> vVarA;
        if (Dsp.isDebugLogEnable()) {
            a("Retrieved data", this.y, "data: " + this.E + ", cache key: " + this.C + ", fetcher: " + this.G);
        }
        try {
            vVarA = a(this.G, this.E, this.F);
        } catch (q e2) {
            e2.a(this.D, this.F);
            this.g.add(e2);
            vVarA = null;
        }
        if (vVarA != null) {
            b(vVarA, this.F, this.K);
        } else {
            k();
        }
    }

    public final com.ipd.dsp.internal.i.f e() {
        int i = a.b[this.w.ordinal()];
        if (i == 1) {
            return new w(this.f, this);
        }
        if (i == 2) {
            return new com.ipd.dsp.internal.i.c(this.f, this);
        }
        if (i == 3) {
            return new z(this.f, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.w);
    }

    public final int f() {
        return this.o.ordinal();
    }

    public final void g() {
        m();
        this.u.a(new q("Failed to load resource", new ArrayList(this.g)));
        i();
    }

    public final void h() {
        if (this.l.a()) {
            j();
        }
    }

    public final void i() {
        if (this.l.b()) {
            j();
        }
    }

    public final void j() {
        this.l.c();
        this.k.a();
        this.f.a();
        this.I = false;
        this.m = null;
        this.n = null;
        this.t = null;
        this.o = null;
        this.p = null;
        this.u = null;
        this.w = null;
        this.H = null;
        this.B = null;
        this.C = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.y = 0L;
        this.J = false;
        this.A = null;
        this.g.clear();
        this.j.release(this);
    }

    public final void k() {
        this.B = Thread.currentThread();
        this.y = com.ipd.dsp.internal.d0.i.a();
        boolean zB = false;
        while (!this.J && this.H != null && !(zB = this.H.b())) {
            this.w = a(this.w);
            this.H = e();
            if (this.w == EnumC0884h.SOURCE) {
                a(g.SWITCH_TO_SOURCE_SERVICE);
                return;
            }
        }
        if ((this.w == EnumC0884h.FINISHED || this.J) && !zB) {
            g();
        }
    }

    public final void l() {
        int i = a.f38328a[this.x.ordinal()];
        if (i == 1) {
            this.w = a(EnumC0884h.INITIALIZE);
            this.H = e();
            k();
        } else if (i == 2) {
            k();
        } else {
            if (i == 3) {
                d();
                return;
            }
            throw new IllegalStateException("Unrecognized run reason: " + this.x);
        }
    }

    public final void m() {
        Throwable th;
        this.h.b();
        if (!this.I) {
            this.I = true;
            return;
        }
        if (this.g.isEmpty()) {
            th = null;
        } else {
            List<Throwable> list = this.g;
            th = list.get(list.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    public boolean n() {
        EnumC0884h enumC0884hA = a(EnumC0884h.INITIALIZE);
        return enumC0884hA == EnumC0884h.RESOURCE_CACHE || enumC0884hA == EnumC0884h.DATA_CACHE;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ipd.dsp.internal.e0.b.a("DecodeJob#run(reason=%s, model=%s)", this.x, this.A);
        com.ipd.dsp.internal.g.d<?> dVar = this.G;
        try {
            try {
                try {
                    if (this.J) {
                        g();
                        if (dVar != null) {
                            dVar.b();
                        }
                        com.ipd.dsp.internal.e0.b.a();
                        return;
                    }
                    l();
                    if (dVar != null) {
                        dVar.b();
                    }
                    com.ipd.dsp.internal.e0.b.a();
                } catch (Throwable th) {
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.a(L, "DecodeJob threw unexpectedly, isCancelled: " + this.J + ", stage: " + this.w, th);
                    }
                    if (this.w != EnumC0884h.ENCODE) {
                        this.g.add(th);
                        g();
                    }
                    if (!this.J) {
                        throw th;
                    }
                    throw th;
                }
            } catch (com.ipd.dsp.internal.i.b e2) {
                throw e2;
            }
        } catch (Throwable th2) {
            if (dVar != null) {
                dVar.b();
            }
            com.ipd.dsp.internal.e0.b.a();
            throw th2;
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f38331a;
        public boolean b;
        public boolean c;

        public synchronized boolean a() {
            this.b = true;
            return a(false);
        }

        public synchronized boolean b(boolean z) {
            this.f38331a = true;
            return a(z);
        }

        public synchronized void c() {
            this.b = false;
            this.f38331a = false;
            this.c = false;
        }

        public final boolean a(boolean z) {
            return (this.c || z || this.b) && this.f38331a;
        }

        public synchronized boolean b() {
            this.c = true;
            return a(false);
        }
    }

    public static class d<Z> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.ipd.dsp.internal.f.f f38330a;
        public com.ipd.dsp.internal.f.l<Z> b;
        public u<Z> c;

        /* JADX WARN: Multi-variable type inference failed */
        public <X> void a(com.ipd.dsp.internal.f.f fVar, com.ipd.dsp.internal.f.l<X> lVar, u<X> uVar) {
            this.f38330a = fVar;
            this.b = lVar;
            this.c = uVar;
        }

        public boolean b() {
            return this.c != null;
        }

        public void a(e eVar, com.ipd.dsp.internal.f.i iVar) {
            com.ipd.dsp.internal.e0.b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.f38330a, new com.ipd.dsp.internal.i.e(this.b, this.c, iVar));
            } finally {
                this.c.f();
                com.ipd.dsp.internal.e0.b.a();
            }
        }

        public void a() {
            this.f38330a = null;
            this.b = null;
            this.c = null;
        }
    }

    public void a(boolean z) {
        if (this.l.b(z)) {
            j();
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(@NonNull h<?> hVar) {
        int iF = f() - hVar.f();
        return iF == 0 ? this.v - hVar.v : iF;
    }

    @Override // com.ipd.dsp.internal.e0.a.f
    @NonNull
    public com.ipd.dsp.internal.e0.c b() {
        return this.h;
    }

    public final void a(v<R> vVar, com.ipd.dsp.internal.f.a aVar, boolean z) {
        m();
        this.u.a(vVar, aVar, z);
    }

    public final EnumC0884h a(EnumC0884h enumC0884h) {
        int i = a.b[enumC0884h.ordinal()];
        if (i == 1) {
            if (this.s.a()) {
                return EnumC0884h.DATA_CACHE;
            }
            return a(EnumC0884h.DATA_CACHE);
        }
        if (i == 2) {
            return this.z ? EnumC0884h.FINISHED : EnumC0884h.SOURCE;
        }
        if (i == 3 || i == 4) {
            return EnumC0884h.FINISHED;
        }
        if (i == 5) {
            if (this.s.b()) {
                return EnumC0884h.RESOURCE_CACHE;
            }
            return a(EnumC0884h.RESOURCE_CACHE);
        }
        throw new IllegalArgumentException("Unrecognized stage: " + enumC0884h);
    }

    public final void a(g gVar) {
        this.x = gVar;
        this.u.a((h<?>) this);
    }

    @Override // com.ipd.dsp.internal.i.f.a
    public void a() {
        a(g.SWITCH_TO_SOURCE_SERVICE);
    }

    @Override // com.ipd.dsp.internal.i.f.a
    public void a(com.ipd.dsp.internal.f.f fVar, Object obj, com.ipd.dsp.internal.g.d<?> dVar, com.ipd.dsp.internal.f.a aVar, com.ipd.dsp.internal.f.f fVar2) {
        this.C = fVar;
        this.E = obj;
        this.G = dVar;
        this.F = aVar;
        this.D = fVar2;
        this.K = fVar != this.f.c().get(0);
        if (Thread.currentThread() != this.B) {
            a(g.DECODE_DATA);
            return;
        }
        com.ipd.dsp.internal.e0.b.a("DecodeJob.decodeFromRetrievedData");
        try {
            d();
        } finally {
            com.ipd.dsp.internal.e0.b.a();
        }
    }

    @Override // com.ipd.dsp.internal.i.f.a
    public void a(com.ipd.dsp.internal.f.f fVar, Exception exc, com.ipd.dsp.internal.g.d<?> dVar, com.ipd.dsp.internal.f.a aVar) {
        dVar.b();
        q qVar = new q("Fetching data failed", exc);
        qVar.a(fVar, aVar, dVar.a());
        this.g.add(qVar);
        if (Thread.currentThread() != this.B) {
            a(g.SWITCH_TO_SOURCE_SERVICE);
        } else {
            k();
        }
    }

    public final <Data> v<R> a(com.ipd.dsp.internal.g.d<?> dVar, Data data, com.ipd.dsp.internal.f.a aVar) throws q {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long jA = com.ipd.dsp.internal.d0.i.a();
            v<R> vVarA = a(data, aVar);
            if (Dsp.isDebugLogEnable()) {
                a("Decoded result " + vVarA, jA);
            }
            return vVarA;
        } finally {
            dVar.b();
        }
    }

    public final <Data> v<R> a(Data data, com.ipd.dsp.internal.f.a aVar) throws q {
        return a(data, aVar, this.f.a((Class) data.getClass()));
    }

    @NonNull
    public final com.ipd.dsp.internal.f.i a(com.ipd.dsp.internal.f.a aVar) {
        com.ipd.dsp.internal.f.i iVar = this.t;
        boolean z = aVar == com.ipd.dsp.internal.f.a.RESOURCE_DISK_CACHE || this.f.o();
        com.ipd.dsp.internal.f.h<Boolean> hVar = com.ipd.dsp.internal.q.r.k;
        Boolean bool = (Boolean) iVar.a(hVar);
        if (bool != null && (!bool.booleanValue() || z)) {
            return iVar;
        }
        com.ipd.dsp.internal.f.i iVar2 = new com.ipd.dsp.internal.f.i();
        iVar2.a(this.t);
        iVar2.a(hVar, Boolean.valueOf(z));
        return iVar2;
    }

    public final <Data, ResourceType> v<R> a(Data data, com.ipd.dsp.internal.f.a aVar, t<Data, ResourceType, R> tVar) throws q {
        com.ipd.dsp.internal.f.i iVarA = a(aVar);
        com.ipd.dsp.internal.components.glide.load.data.a<Data> aVarB = this.m.f().b(data);
        try {
            return tVar.a(aVarB, iVarA, this.q, this.r, new c(aVar));
        } finally {
            aVarB.b();
        }
    }

    public final void a(String str, long j) {
        a(str, j, (String) null);
    }

    public final void a(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.ipd.dsp.internal.d0.i.a(j));
        sb.append(", load key: ");
        sb.append(this.p);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        com.ipd.dsp.internal.c2.k.e(L, sb.toString());
    }

    @NonNull
    public <Z> v<Z> a(com.ipd.dsp.internal.f.a aVar, @NonNull v<Z> vVar) {
        v<Z> vVarA;
        com.ipd.dsp.internal.f.m<Z> mVar;
        com.ipd.dsp.internal.f.c cVarA;
        com.ipd.dsp.internal.f.f dVar;
        Class<?> cls = vVar.get().getClass();
        com.ipd.dsp.internal.f.l<Z> lVarA = null;
        if (aVar != com.ipd.dsp.internal.f.a.RESOURCE_DISK_CACHE) {
            com.ipd.dsp.internal.f.m<Z> mVarB = this.f.b((Class) cls);
            mVar = mVarB;
            vVarA = mVarB.a(this.m, vVar, this.q, this.r);
        } else {
            vVarA = vVar;
            mVar = null;
        }
        if (!vVar.equals(vVarA)) {
            vVar.e();
        }
        if (this.f.b((v<?>) vVarA)) {
            lVarA = this.f.a((v) vVarA);
            cVarA = lVarA.a(this.t);
        } else {
            cVarA = com.ipd.dsp.internal.f.c.NONE;
        }
        com.ipd.dsp.internal.f.l lVar = lVarA;
        if (!this.s.a(!this.f.a(this.C), aVar, cVarA)) {
            return vVarA;
        }
        if (lVar != null) {
            int i = a.c[cVarA.ordinal()];
            if (i == 1) {
                dVar = new com.ipd.dsp.internal.i.d(this.C, this.n);
            } else if (i == 2) {
                dVar = new x(this.f.b(), this.C, this.n, this.q, this.r, mVar, cls, this.t);
            } else {
                throw new IllegalArgumentException("Unknown strategy: " + cVarA);
            }
            u uVarB = u.b(vVarA);
            this.k.a(dVar, lVar, uVarB);
            return uVarB;
        }
        throw new com.ipd.dsp.internal.b.f.d(vVarA.get().getClass());
    }
}
