package com.ipd.dsp.internal.j;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class j implements com.ipd.dsp.internal.j.b {
    public static final int h = 4194304;

    @VisibleForTesting
    public static final int i = 8;
    public static final int j = 2;
    public final h<a, Object> b;
    public final b c;
    public final Map<Class<?>, NavigableMap<Integer, Integer>> d;
    public final Map<Class<?>, com.ipd.dsp.internal.j.a<?>> e;
    public final int f;
    public int g;

    public static final class b extends d<a> {
        @Override // com.ipd.dsp.internal.j.d
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this);
        }

        public a a(int i, Class<?> cls) {
            a aVarB = b();
            aVarB.a(i, cls);
            return aVarB;
        }
    }

    @VisibleForTesting
    public j() {
        this.b = new h<>();
        this.c = new b();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = 4194304;
    }

    @Override // com.ipd.dsp.internal.j.b
    @Deprecated
    public <T> void a(T t, Class<T> cls) {
        put(t);
    }

    @Override // com.ipd.dsp.internal.j.b
    public synchronized <T> T b(int i2, Class<T> cls) {
        Integer numCeilingKey;
        numCeilingKey = b((Class<?>) cls).ceilingKey(Integer.valueOf(i2));
        return (T) a(a(i2, numCeilingKey) ? this.c.a(numCeilingKey.intValue(), cls) : this.c.a(i2, cls), (Class) cls);
    }

    public final void c(int i2, Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMapB = b(cls);
        Integer num = navigableMapB.get(Integer.valueOf(i2));
        if (num != null) {
            if (num.intValue() == 1) {
                navigableMapB.remove(Integer.valueOf(i2));
                return;
            } else {
                navigableMapB.put(Integer.valueOf(i2), Integer.valueOf(num.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + i2 + ", this: " + this);
    }

    public final boolean d() {
        int i2 = this.g;
        return i2 == 0 || this.f / i2 >= 2;
    }

    @Override // com.ipd.dsp.internal.j.b
    public synchronized <T> void put(T t) {
        Class<?> cls = t.getClass();
        com.ipd.dsp.internal.j.a<T> aVarA = a((Class) cls);
        int iA = aVarA.a(t);
        int iB = aVarA.b() * iA;
        if (b(iB)) {
            a aVarA2 = this.c.a(iA, cls);
            this.b.a(aVarA2, t);
            NavigableMap<Integer, Integer> navigableMapB = b(cls);
            Integer num = navigableMapB.get(Integer.valueOf(aVarA2.b));
            Integer numValueOf = Integer.valueOf(aVarA2.b);
            int iIntValue = 1;
            if (num != null) {
                iIntValue = 1 + num.intValue();
            }
            navigableMapB.put(numValueOf, Integer.valueOf(iIntValue));
            this.g += iB;
            b();
        }
    }

    @Override // com.ipd.dsp.internal.j.b
    public synchronized void trimMemory(int i2) {
        try {
            if (i2 >= 40) {
                a();
            } else if (i2 >= 20 || i2 == 15) {
                a(this.f / 2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f38354a;
        public int b;
        public Class<?> c;

        public a(b bVar) {
            this.f38354a = bVar;
        }

        public void a(int i, Class<?> cls) {
            this.b = i;
            this.c = cls;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.b == aVar.b && this.c == aVar.c) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int i = this.b * 31;
            Class<?> cls = this.c;
            return i + (cls != null ? cls.hashCode() : 0);
        }

        public String toString() {
            return "Key{size=" + this.b + "array=" + this.c + '}';
        }

        @Override // com.ipd.dsp.internal.j.m
        public void a() {
            this.f38354a.a(this);
        }
    }

    @Override // com.ipd.dsp.internal.j.b
    public synchronized <T> T a(int i2, Class<T> cls) {
        return (T) a(this.c.a(i2, cls), (Class) cls);
    }

    public final <T> T a(a aVar, Class<T> cls) {
        com.ipd.dsp.internal.j.a<T> aVarA = a((Class) cls);
        T t = (T) a(aVar);
        if (t != null) {
            this.g -= aVarA.a(t) * aVarA.b();
            c(aVarA.a(t), cls);
        }
        if (t != null) {
            return t;
        }
        if (Dsp.isDebugLogEnable()) {
            com.ipd.dsp.internal.c2.k.e(aVarA.a(), "Allocated " + aVar.b + " bytes");
        }
        return aVarA.newArray(aVar.b);
    }

    public final boolean b(int i2) {
        return i2 <= this.f / 2;
    }

    public j(int i2) {
        this.b = new h<>();
        this.c = new b();
        this.d = new HashMap();
        this.e = new HashMap();
        this.f = i2;
    }

    public final void b() {
        a(this.f);
    }

    public int c() {
        int iIntValue = 0;
        for (Class<?> cls : this.d.keySet()) {
            for (Integer num : this.d.get(cls).keySet()) {
                iIntValue += num.intValue() * this.d.get(cls).get(num).intValue() * a((Class) cls).b();
            }
        }
        return iIntValue;
    }

    public final NavigableMap<Integer, Integer> b(Class<?> cls) {
        NavigableMap<Integer, Integer> navigableMap = this.d.get(cls);
        if (navigableMap != null) {
            return navigableMap;
        }
        TreeMap treeMap = new TreeMap();
        this.d.put(cls, treeMap);
        return treeMap;
    }

    @Nullable
    public final <T> T a(a aVar) {
        return (T) this.b.a(aVar);
    }

    public final boolean a(int i2, Integer num) {
        if (num != null) {
            return d() || num.intValue() <= i2 * 8;
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.j.b
    public synchronized void a() {
        a(0);
    }

    public final void a(int i2) {
        while (this.g > i2) {
            Object objA = this.b.a();
            com.ipd.dsp.internal.d0.m.a(objA);
            com.ipd.dsp.internal.j.a aVarA = a(objA);
            this.g -= aVarA.a(objA) * aVarA.b();
            c(aVarA.a(objA), objA.getClass());
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.e(aVarA.a(), "evicted: " + aVarA.a(objA));
            }
        }
    }

    public final <T> com.ipd.dsp.internal.j.a<T> a(T t) {
        return a((Class) t.getClass());
    }

    public final <T> com.ipd.dsp.internal.j.a<T> a(Class<T> cls) {
        com.ipd.dsp.internal.j.a<T> gVar;
        com.ipd.dsp.internal.j.a<T> aVar = (com.ipd.dsp.internal.j.a) this.e.get(cls);
        if (aVar != null) {
            return aVar;
        }
        if (cls.equals(int[].class)) {
            gVar = new i();
        } else if (cls.equals(byte[].class)) {
            gVar = new g();
        } else {
            throw new IllegalArgumentException("No array pool found for: " + cls.getSimpleName());
        }
        this.e.put(cls, gVar);
        return gVar;
    }
}
