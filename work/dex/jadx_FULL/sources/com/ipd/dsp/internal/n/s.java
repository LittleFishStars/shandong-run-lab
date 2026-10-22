package com.ipd.dsp.internal.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class s {
    public static final c e = new c();
    public static final o<Object, Object> f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b<?, ?>> f38441a;
    public final c b;
    public final Set<b<?, ?>> c;
    public final Pools.Pool<List<Throwable>> d;

    public static class a implements o<Object, Object> {
        @Override // com.ipd.dsp.internal.n.o
        @Nullable
        public o.a<Object> a(@NonNull Object obj, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
            return null;
        }

        @Override // com.ipd.dsp.internal.n.o
        public boolean a(@NonNull Object obj) {
            return false;
        }
    }

    public static class b<Model, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<Model> f38442a;
        public final Class<Data> b;
        public final p<? extends Model, ? extends Data> c;

        public b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
            this.f38442a = cls;
            this.b = cls2;
            this.c = pVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.b.isAssignableFrom(cls2);
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f38442a.isAssignableFrom(cls);
        }
    }

    public static class c {
        @NonNull
        public <Model, Data> r<Model, Data> a(@NonNull List<o<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new r<>(list, pool);
        }
    }

    public s(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, e);
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        a(cls, cls2, pVar, true);
    }

    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        a(cls, cls2, pVar, false);
    }

    @NonNull
    public synchronized <Model, Data> List<p<? extends Model, ? extends Data>> c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        List<p<? extends Model, ? extends Data>> listB;
        listB = b(cls, cls2);
        a(cls, cls2, pVar);
        return listB;
    }

    @VisibleForTesting
    public s(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull c cVar) {
        this.f38441a = new ArrayList();
        this.c = new HashSet();
        this.d = pool;
        this.b = cVar;
    }

    public final <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar, boolean z) {
        b<?, ?> bVar = new b<>(cls, cls2, pVar);
        List<b<?, ?>> list = this.f38441a;
        list.add(z ? list.size() : 0, bVar);
    }

    @NonNull
    public synchronized <Model, Data> List<p<? extends Model, ? extends Data>> b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it = this.f38441a.iterator();
        while (it.hasNext()) {
            b<?, ?> next = it.next();
            if (next.a(cls, cls2)) {
                it.remove();
                arrayList.add(b(next));
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <Model> List<o<Model, ?>> a(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f38441a) {
                if (!this.c.contains(bVar) && bVar.a(cls)) {
                    this.c.add(bVar);
                    arrayList.add(a(bVar));
                    this.c.remove(bVar);
                }
            }
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
        return arrayList;
    }

    @NonNull
    public synchronized List<Class<?>> b(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f38441a) {
            if (!arrayList.contains(bVar.b) && bVar.a(cls)) {
                arrayList.add(bVar.b);
            }
        }
        return arrayList;
    }

    @NonNull
    public final <Model, Data> p<Model, Data> b(@NonNull b<?, ?> bVar) {
        return (p<Model, Data>) bVar.c;
    }

    @NonNull
    public synchronized <Model, Data> o<Model, Data> a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (b<?, ?> bVar : this.f38441a) {
                if (this.c.contains(bVar)) {
                    z = true;
                } else if (bVar.a(cls, cls2)) {
                    this.c.add(bVar);
                    arrayList.add(a(bVar));
                    this.c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.b.a(arrayList, this.d);
            }
            if (arrayList.size() == 1) {
                return (o) arrayList.get(0);
            }
            if (z) {
                return a();
            }
            throw new com.ipd.dsp.internal.b.f.c((Class<?>) cls, (Class<?>) cls2);
        } catch (Throwable th) {
            this.c.clear();
            throw th;
        }
    }

    @NonNull
    public final <Model, Data> o<Model, Data> a(@NonNull b<?, ?> bVar) {
        return (o) com.ipd.dsp.internal.d0.m.a(bVar.c.a(this));
    }

    @NonNull
    public static <Model, Data> o<Model, Data> a() {
        return (o<Model, Data>) f;
    }
}
