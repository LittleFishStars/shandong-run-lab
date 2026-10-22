package com.ipd.dsp.internal.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.ipd.dsp.internal.components.glide.load.ImageHeaderParser;
import com.ipd.dsp.internal.f.k;
import com.ipd.dsp.internal.f.l;
import com.ipd.dsp.internal.i.t;
import com.ipd.dsp.internal.i.v;
import com.ipd.dsp.internal.n.o;
import com.ipd.dsp.internal.n.p;
import com.ipd.dsp.internal.n.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f {
    public static final String k = "Animation";

    @Deprecated
    public static final String l = "Animation";
    public static final String m = "Bitmap";
    public static final String n = "BitmapDrawable";
    public static final String o = "legacy_prepend_all";
    public static final String p = "legacy_append";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f38191a;
    public final com.ipd.dsp.internal.y.a b;
    public final com.ipd.dsp.internal.y.e c;
    public final com.ipd.dsp.internal.y.f d;
    public final com.ipd.dsp.internal.components.glide.load.data.b e;
    public final com.ipd.dsp.internal.v.f f;
    public final com.ipd.dsp.internal.y.b g;
    public final com.ipd.dsp.internal.y.d h = new com.ipd.dsp.internal.y.d();
    public final com.ipd.dsp.internal.y.c i = new com.ipd.dsp.internal.y.c();
    public final Pools.Pool<List<Throwable>> j;

    public static class a extends RuntimeException {
        public a(@NonNull String str) {
            super(str);
        }
    }

    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    public static class c extends a {
        public c(@NonNull Object obj) {
            super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
        }

        public <M> c(@NonNull M m, @NonNull List<o<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public c(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    public static class d extends a {
        public d(@NonNull Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    public static class e extends a {
        public e(@NonNull Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public f() {
        Pools.Pool<List<Throwable>> poolB = com.ipd.dsp.internal.e0.a.b();
        this.j = poolB;
        this.f38191a = new q(poolB);
        this.b = new com.ipd.dsp.internal.y.a();
        this.c = new com.ipd.dsp.internal.y.e();
        this.d = new com.ipd.dsp.internal.y.f();
        this.e = new com.ipd.dsp.internal.components.glide.load.data.b();
        this.f = new com.ipd.dsp.internal.v.f();
        this.g = new com.ipd.dsp.internal.y.b();
        a(Arrays.asList("Animation", "Bitmap", "BitmapDrawable"));
    }

    @NonNull
    public <Data> f a(@NonNull Class<Data> cls, @NonNull com.ipd.dsp.internal.f.d<Data> dVar) {
        this.b.a(cls, dVar);
        return this;
    }

    @NonNull
    public <Data> f b(@NonNull Class<Data> cls, @NonNull com.ipd.dsp.internal.f.d<Data> dVar) {
        this.b.b(cls, dVar);
        return this;
    }

    @NonNull
    @Deprecated
    public <Data> f c(@NonNull Class<Data> cls, @NonNull com.ipd.dsp.internal.f.d<Data> dVar) {
        return a(cls, dVar);
    }

    @NonNull
    public <Data, TResource> f a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull k<Data, TResource> kVar) {
        a(p, cls, cls2, kVar);
        return this;
    }

    @NonNull
    public <Data, TResource> f b(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull k<Data, TResource> kVar) {
        b(o, cls, cls2, kVar);
        return this;
    }

    @NonNull
    @Deprecated
    public <TResource> f c(@NonNull Class<TResource> cls, @NonNull l<TResource> lVar) {
        return a((Class) cls, (l) lVar);
    }

    @NonNull
    public <Data, TResource> f a(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull k<Data, TResource> kVar) {
        this.c.a(str, kVar, cls, cls2);
        return this;
    }

    @NonNull
    public <Data, TResource> f b(@NonNull String str, @NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull k<Data, TResource> kVar) {
        this.c.b(str, kVar, cls, cls2);
        return this;
    }

    @NonNull
    public <Model, Data> f c(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<? extends Model, ? extends Data> pVar) {
        this.f38191a.c(cls, cls2, pVar);
        return this;
    }

    @NonNull
    public final f a(@NonNull List<String> list) {
        ArrayList arrayList = new ArrayList(list.size());
        arrayList.add(o);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        arrayList.add(p);
        this.c.a(arrayList);
        return this;
    }

    @NonNull
    public <TResource> f b(@NonNull Class<TResource> cls, @NonNull l<TResource> lVar) {
        this.d.b(cls, lVar);
        return this;
    }

    @NonNull
    public <Model, TResource, Transcode> List<Class<?>> c(@NonNull Class<Model> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        List<Class<?>> listA = this.h.a(cls, cls2, cls3);
        if (listA == null) {
            listA = new ArrayList<>();
            Iterator<Class<?>> it = this.f38191a.a((Class<?>) cls).iterator();
            while (it.hasNext()) {
                for (Class<?> cls4 : this.c.b(it.next(), cls2)) {
                    if (!this.f.b(cls4, cls3).isEmpty() && !listA.contains(cls4)) {
                        listA.add(cls4);
                    }
                }
            }
            this.h.a(cls, cls2, cls3, Collections.unmodifiableList(listA));
        }
        return listA;
    }

    @NonNull
    public <Model, Data> f b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<Model, Data> pVar) {
        this.f38191a.b(cls, cls2, pVar);
        return this;
    }

    @Nullable
    public <Data, TResource, Transcode> t<Data, TResource, Transcode> b(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        t<Data, TResource, Transcode> tVarA = this.i.a(cls, cls2, cls3);
        if (this.i.a(tVarA)) {
            return null;
        }
        if (tVarA != null) {
            return tVarA;
        }
        List<com.ipd.dsp.internal.i.i<Data, TResource, Transcode>> listA = a(cls, cls2, cls3);
        t<Data, TResource, Transcode> tVar = listA.isEmpty() ? null : new t<>(cls, cls2, cls3, listA, this.j);
        this.i.a(cls, cls2, cls3, tVar);
        return tVar;
    }

    @NonNull
    public <TResource> f a(@NonNull Class<TResource> cls, @NonNull l<TResource> lVar) {
        this.d.a(cls, lVar);
        return this;
    }

    @NonNull
    public f a(@NonNull com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<?> interfaceC0870a) {
        this.e.a(interfaceC0870a);
        return this;
    }

    @NonNull
    public <TResource, Transcode> f a(@NonNull Class<TResource> cls, @NonNull Class<Transcode> cls2, @NonNull com.ipd.dsp.internal.v.e<TResource, Transcode> eVar) {
        this.f.a(cls, cls2, eVar);
        return this;
    }

    @NonNull
    public f a(@NonNull ImageHeaderParser imageHeaderParser) {
        this.g.a(imageHeaderParser);
        return this;
    }

    public boolean b(@NonNull v<?> vVar) {
        return this.d.a(vVar.d()) != null;
    }

    @NonNull
    public <Model, Data> f a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull p<Model, Data> pVar) {
        this.f38191a.a(cls, cls2, pVar);
        return this;
    }

    @NonNull
    public <X> com.ipd.dsp.internal.components.glide.load.data.a<X> b(@NonNull X x) {
        return this.e.a(x);
    }

    @NonNull
    public final <Data, TResource, Transcode> List<com.ipd.dsp.internal.i.i<Data, TResource, Transcode>> a(@NonNull Class<Data> cls, @NonNull Class<TResource> cls2, @NonNull Class<Transcode> cls3) {
        ArrayList arrayList = new ArrayList();
        for (Class cls4 : this.c.b(cls, cls2)) {
            for (Class cls5 : this.f.b(cls4, cls3)) {
                arrayList.add(new com.ipd.dsp.internal.i.i(cls, cls4, cls5, this.c.a(cls, cls4), this.f.a(cls4, cls5), this.j));
            }
        }
        return arrayList;
    }

    @NonNull
    public <X> com.ipd.dsp.internal.f.d<X> c(@NonNull X x) throws e {
        com.ipd.dsp.internal.f.d<X> dVarA = this.b.a(x.getClass());
        if (dVarA != null) {
            return dVarA;
        }
        throw new e(x.getClass());
    }

    @NonNull
    public <X> l<X> a(@NonNull v<X> vVar) throws d {
        l<X> lVarA = this.d.a(vVar.d());
        if (lVarA != null) {
            return lVarA;
        }
        throw new d(vVar.d());
    }

    @NonNull
    public <Model> List<o<Model, ?>> a(@NonNull Model model) {
        return this.f38191a.b(model);
    }

    @NonNull
    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> listA = this.g.a();
        if (listA.isEmpty()) {
            throw new b();
        }
        return listA;
    }
}
