package com.ipd.dsp.internal.j;

import androidx.annotation.Nullable;
import com.ipd.dsp.internal.j.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h<K extends m, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<K, V> f38351a = new a<>();
    public final Map<K, a<K, V>> b = new HashMap();

    public static class a<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K f38352a;
        public List<V> b;
        public a<K, V> c;
        public a<K, V> d;

        public a() {
            this(null);
        }

        @Nullable
        public V a() {
            int iB = b();
            if (iB > 0) {
                return this.b.remove(iB - 1);
            }
            return null;
        }

        public int b() {
            List<V> list = this.b;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        public a(K k) {
            this.d = this;
            this.c = this;
            this.f38352a = k;
        }

        public void a(V v) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            this.b.add(v);
        }
    }

    public static <K, V> void c(a<K, V> aVar) {
        a<K, V> aVar2 = aVar.d;
        aVar2.c = aVar.c;
        aVar.c.d = aVar2;
    }

    public static <K, V> void d(a<K, V> aVar) {
        aVar.c.d = aVar;
        aVar.d.c = aVar;
    }

    public void a(K k, V v) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            b(aVar);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        aVar.a(v);
    }

    public final void b(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f38351a;
        aVar.d = aVar2.d;
        aVar.c = aVar2;
        d(aVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GroupedLinkedMap( ");
        a aVar = this.f38351a.c;
        boolean z = false;
        while (!aVar.equals(this.f38351a)) {
            sb.append('{');
            sb.append(aVar.f38352a);
            sb.append(com.google.common.net.c.b);
            sb.append(aVar.b());
            sb.append("}, ");
            aVar = aVar.c;
            z = true;
        }
        if (z) {
            sb.delete(sb.length() - 2, sb.length());
        }
        sb.append(" )");
        return sb.toString();
    }

    @Nullable
    public V a(K k) {
        a<K, V> aVar = this.b.get(k);
        if (aVar == null) {
            aVar = new a<>(k);
            this.b.put(k, aVar);
        } else {
            k.a();
        }
        a(aVar);
        return aVar.a();
    }

    @Nullable
    public V a() {
        for (a aVar = this.f38351a.d; !aVar.equals(this.f38351a); aVar = aVar.d) {
            V v = (V) aVar.a();
            if (v != null) {
                return v;
            }
            c(aVar);
            this.b.remove(aVar.f38352a);
            ((m) aVar.f38352a).a();
        }
        return null;
    }

    public final void a(a<K, V> aVar) {
        c(aVar);
        a<K, V> aVar2 = this.f38351a;
        aVar.d = aVar2;
        aVar.c = aVar2.c;
        d(aVar);
    }
}
