package com.ipd.dsp.internal.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class r<Model, Data> implements o<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<o<Model, Data>> f38440a;
    public final Pools.Pool<List<Throwable>> b;

    public r(@NonNull List<o<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f38440a = list;
        this.b = pool;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<Data> a(@NonNull Model model, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        o.a<Data> aVarA;
        int size = this.f38440a.size();
        ArrayList arrayList = new ArrayList(size);
        com.ipd.dsp.internal.f.f fVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            o<Model, Data> oVar = this.f38440a.get(i3);
            if (oVar.a(model) && (aVarA = oVar.a(model, i, i2, iVar)) != null) {
                fVar = aVarA.f38436a;
                arrayList.add(aVarA.c);
            }
        }
        if (arrayList.isEmpty() || fVar == null) {
            return null;
        }
        return new o.a<>(fVar, new a(arrayList, this.b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f38440a.toArray()) + '}';
    }

    public static class a<Data> implements com.ipd.dsp.internal.g.d<Data>, com.ipd.dsp.internal.g.d.a<Data> {
        public final List<com.ipd.dsp.internal.g.d<Data>> f;
        public final Pools.Pool<List<Throwable>> g;
        public int h;
        public com.ipd.dsp.internal.b.e i;
        public com.ipd.dsp.internal.g.d.a<? super Data> j;

        @Nullable
        public List<Throwable> k;
        public boolean l;

        public a(@NonNull List<com.ipd.dsp.internal.g.d<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.g = pool;
            com.ipd.dsp.internal.d0.m.a(list);
            this.f = list;
            this.h = 0;
        }

        @Override // com.ipd.dsp.internal.g.d
        public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull com.ipd.dsp.internal.g.d.a<? super Data> aVar) {
            this.i = eVar;
            this.j = aVar;
            this.k = this.g.acquire();
            this.f.get(this.h).a(eVar, this);
            if (this.l) {
                cancel();
            }
        }

        @Override // com.ipd.dsp.internal.g.d
        public void b() {
            List<Throwable> list = this.k;
            if (list != null) {
                this.g.release(list);
            }
            this.k = null;
            Iterator<com.ipd.dsp.internal.g.d<Data>> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }

        @Override // com.ipd.dsp.internal.g.d
        @NonNull
        public com.ipd.dsp.internal.f.a c() {
            return this.f.get(0).c();
        }

        @Override // com.ipd.dsp.internal.g.d
        public void cancel() {
            this.l = true;
            Iterator<com.ipd.dsp.internal.g.d<Data>> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().cancel();
            }
        }

        public final void d() {
            if (this.l) {
                return;
            }
            if (this.h < this.f.size() - 1) {
                this.h++;
                a(this.i, this.j);
            } else {
                com.ipd.dsp.internal.d0.m.a(this.k);
                this.j.onLoadFailed(new com.ipd.dsp.internal.i.q("Fetch failed", new ArrayList(this.k)));
            }
        }

        @Override // com.ipd.dsp.internal.g.d.a
        public void onLoadFailed(@NonNull Exception exc) {
            ((List) com.ipd.dsp.internal.d0.m.a(this.k)).add(exc);
            d();
        }

        @Override // com.ipd.dsp.internal.g.d
        @NonNull
        public Class<Data> a() {
            return this.f.get(0).a();
        }

        @Override // com.ipd.dsp.internal.g.d.a
        public void a(@Nullable Data data) {
            if (data != null) {
                this.j.a(data);
            } else {
                d();
            }
        }
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Model model) {
        Iterator<o<Model, Data>> it = this.f38440a.iterator();
        while (it.hasNext()) {
            if (it.next().a(model)) {
                return true;
            }
        }
        return false;
    }
}
