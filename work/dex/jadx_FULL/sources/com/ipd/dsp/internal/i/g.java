package com.ipd.dsp.internal.i;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class g<Transcode> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.ipd.dsp.internal.n.o.a<?>> f38327a = new ArrayList();
    public final List<com.ipd.dsp.internal.f.f> b = new ArrayList();
    public com.ipd.dsp.internal.components.glide.c c;
    public Object d;
    public int e;
    public int f;
    public Class<?> g;
    public h.e h;
    public com.ipd.dsp.internal.f.i i;
    public Map<Class<?>, com.ipd.dsp.internal.f.m<?>> j;
    public Class<Transcode> k;
    public boolean l;
    public boolean m;
    public com.ipd.dsp.internal.f.f n;
    public com.ipd.dsp.internal.b.e o;
    public j p;
    public boolean q;
    public boolean r;

    /* JADX WARN: Multi-variable type inference failed */
    public <R> void a(com.ipd.dsp.internal.components.glide.c cVar, Object obj, com.ipd.dsp.internal.f.f fVar, int i, int i2, j jVar, Class<?> cls, Class<R> cls2, com.ipd.dsp.internal.b.e eVar, com.ipd.dsp.internal.f.i iVar, Map<Class<?>, com.ipd.dsp.internal.f.m<?>> map, boolean z, boolean z2, h.e eVar2) {
        this.c = cVar;
        this.d = obj;
        this.n = fVar;
        this.e = i;
        this.f = i2;
        this.p = jVar;
        this.g = cls;
        this.h = eVar2;
        this.k = cls2;
        this.o = eVar;
        this.i = iVar;
        this.j = map;
        this.q = z;
        this.r = z2;
    }

    public com.ipd.dsp.internal.j.b b() {
        return this.c.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean c(Class<?> cls) {
        return a((Class) cls) != null;
    }

    public com.ipd.dsp.internal.k.a d() {
        return this.h.a();
    }

    public j e() {
        return this.p;
    }

    public int f() {
        return this.f;
    }

    public List<com.ipd.dsp.internal.n.o.a<?>> g() {
        if (!this.l) {
            this.l = true;
            this.f38327a.clear();
            List listA = this.c.f().a(this.d);
            int size = listA.size();
            for (int i = 0; i < size; i++) {
                com.ipd.dsp.internal.n.o.a<?> aVarA = ((com.ipd.dsp.internal.n.o) listA.get(i)).a(this.d, this.e, this.f, this.i);
                if (aVarA != null) {
                    this.f38327a.add(aVarA);
                }
            }
        }
        return this.f38327a;
    }

    public Class<?> h() {
        return this.d.getClass();
    }

    public com.ipd.dsp.internal.f.i i() {
        return this.i;
    }

    public com.ipd.dsp.internal.b.e j() {
        return this.o;
    }

    public List<Class<?>> k() {
        return this.c.f().c(this.d.getClass(), this.g, this.k);
    }

    public com.ipd.dsp.internal.f.f l() {
        return this.n;
    }

    public Class<?> m() {
        return this.k;
    }

    public int n() {
        return this.e;
    }

    public boolean o() {
        return this.r;
    }

    public <Z> com.ipd.dsp.internal.f.m<Z> b(Class<Z> cls) {
        com.ipd.dsp.internal.f.m<Z> mVar = (com.ipd.dsp.internal.f.m) this.j.get(cls);
        if (mVar == null) {
            for (Map.Entry<Class<?>, com.ipd.dsp.internal.f.m<?>> entry : this.j.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    mVar = (com.ipd.dsp.internal.f.m) entry.getValue();
                    break;
                }
            }
        }
        if (mVar != null) {
            return mVar;
        }
        if (!this.j.isEmpty() || !this.q) {
            return com.ipd.dsp.internal.p.c.a();
        }
        throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
    }

    public List<com.ipd.dsp.internal.f.f> c() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List<com.ipd.dsp.internal.n.o.a<?>> listG = g();
            int size = listG.size();
            for (int i = 0; i < size; i++) {
                com.ipd.dsp.internal.n.o.a<?> aVar = listG.get(i);
                if (!this.b.contains(aVar.f38436a)) {
                    this.b.add(aVar.f38436a);
                }
                for (int i2 = 0; i2 < aVar.b.size(); i2++) {
                    if (!this.b.contains(aVar.b.get(i2))) {
                        this.b.add(aVar.b.get(i2));
                    }
                }
            }
        }
        return this.b;
    }

    public boolean b(v<?> vVar) {
        return this.c.f().b(vVar);
    }

    public <X> com.ipd.dsp.internal.f.d<X> b(X x) throws com.ipd.dsp.internal.b.f.e {
        return this.c.f().c(x);
    }

    public void a() {
        this.c = null;
        this.d = null;
        this.n = null;
        this.g = null;
        this.k = null;
        this.i = null;
        this.o = null;
        this.j = null;
        this.p = null;
        this.f38327a.clear();
        this.l = false;
        this.b.clear();
        this.m = false;
    }

    public <T> com.ipd.dsp.internal.components.glide.load.data.a<T> a(T t) {
        return this.c.f().b(t);
    }

    public <Data> t<Data, ?, Transcode> a(Class<Data> cls) {
        return this.c.f().b(cls, this.g, this.k);
    }

    public <Z> com.ipd.dsp.internal.f.l<Z> a(v<Z> vVar) {
        return this.c.f().a((v) vVar);
    }

    public List<com.ipd.dsp.internal.n.o<File, ?>> a(File file) throws com.ipd.dsp.internal.b.f.c {
        return this.c.f().a(file);
    }

    public boolean a(com.ipd.dsp.internal.f.f fVar) {
        List<com.ipd.dsp.internal.n.o.a<?>> listG = g();
        int size = listG.size();
        for (int i = 0; i < size; i++) {
            if (listG.get(i).f38436a.equals(fVar)) {
                return true;
            }
        }
        return false;
    }
}
