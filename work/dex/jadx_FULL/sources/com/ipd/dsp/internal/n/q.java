package com.ipd.dsp.internal.n;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f38437a;
    public final a b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, C0904a<?>> f38438a = new HashMap();

        /* JADX INFO: renamed from: com.ipd.dsp.internal.n.q$a$a, reason: collision with other inner class name */
        public static class C0904a<Model> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List<o<Model, ?>> f38439a;

            public C0904a(List<o<Model, ?>> list) {
                this.f38439a = list;
            }
        }

        public void a() {
            this.f38438a.clear();
        }

        public <Model> void a(Class<Model> cls, List<o<Model, ?>> list) {
            if (this.f38438a.put(cls, new C0904a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }

        @Nullable
        public <Model> List<o<Model, ?>> a(Class<Model> cls) {
            C0904a<?> c0904a = this.f38438a.get(cls);
            if (c0904a == null) {
                return null;
            }
            return (List<o<Model, ?>>) c0904a.f38439a;
        }
    }

    public q(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new s(pool));
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        this.f38437a.a(cls, cls2, pVar);
        this.b.a();
    }

    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        this.f38437a.b(cls, cls2, pVar);
        this.b.a();
    }

    public synchronized <Model, Data> void c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        a((List) this.f38437a.c(cls, cls2, pVar));
        this.b.a();
    }

    public q(@NonNull s sVar) {
        this.b = new a();
        this.f38437a = sVar;
    }

    public final <Model, Data> void a(@NonNull List<p<? extends Model, ? extends Data>> list) {
        Iterator<p<? extends Model, ? extends Data>> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        a((List) this.f38437a.b(cls, cls2));
        this.b.a();
    }

    public synchronized <Model, Data> o<Model, Data> a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.f38437a.a(cls, cls2);
    }

    @NonNull
    public <A> List<o<A, ?>> b(@NonNull A a2) {
        List<o<A, ?>> listB = b((Class) a(a2));
        if (!listB.isEmpty()) {
            int size = listB.size();
            List<o<A, ?>> arrayList = Collections.EMPTY_LIST;
            boolean z = true;
            for (int i = 0; i < size; i++) {
                o<A, ?> oVar = listB.get(i);
                if (oVar.a(a2)) {
                    if (z) {
                        arrayList = new ArrayList<>(size - i);
                        z = false;
                    }
                    arrayList.add(oVar);
                }
            }
            if (arrayList.isEmpty()) {
                throw new com.ipd.dsp.internal.b.f.c(a2, listB);
            }
            return arrayList;
        }
        throw new com.ipd.dsp.internal.b.f.c(a2);
    }

    @NonNull
    public synchronized List<Class<?>> a(@NonNull Class<?> cls) {
        return this.f38437a.b(cls);
    }

    @NonNull
    public static <A> Class<A> a(@NonNull A a2) {
        return (Class<A>) a2.getClass();
    }

    @NonNull
    public final synchronized <A> List<o<A, ?>> b(@NonNull Class<A> cls) {
        List<o<A, ?>> listA = this.b.a(cls);
        if (listA != null) {
            return listA;
        }
        List<o<A, ?>> listUnmodifiableList = Collections.unmodifiableList(this.f38437a.a(cls));
        this.b.a(cls, listUnmodifiableList);
        return listUnmodifiableList;
    }
}
