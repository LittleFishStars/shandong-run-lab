package com.google.common.graph;

import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public class h<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public volatile transient Map.Entry<K, V> f32103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<K, V> f6287a;

    public class a extends AbstractSet<K> {

        /* JADX INFO: renamed from: com.google.common.graph.h$a$a, reason: collision with other inner class name */
        public class C0749a extends UnmodifiableIterator<K> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6288a;

            public C0749a(Iterator it) {
                this.f6288a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f6288a.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry entry = (Map.Entry) this.f6288a.next();
                h.this.f32103a = entry;
                return (K) entry.getKey();
            }
        }

        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator<K> iterator() {
            return new C0749a(h.this.f6287a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return h.this.e(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return h.this.f6287a.size();
        }
    }

    public h(Map<K, V> map) {
        this.f6287a = (Map) com.google.common.base.i.E(map);
    }

    public final void c() {
        d();
        this.f6287a.clear();
    }

    public void d() {
        this.f32103a = null;
    }

    public final boolean e(@CheckForNull Object obj) {
        return g(obj) != null || this.f6287a.containsKey(obj);
    }

    @CheckForNull
    public V f(Object obj) {
        com.google.common.base.i.E(obj);
        V vG = g(obj);
        return vG == null ? h(obj) : vG;
    }

    @CheckForNull
    public V g(@CheckForNull Object obj) {
        Map.Entry<K, V> entry = this.f32103a;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    @CheckForNull
    public final V h(Object obj) {
        com.google.common.base.i.E(obj);
        return this.f6287a.get(obj);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public final V i(K k, V v) {
        com.google.common.base.i.E(k);
        com.google.common.base.i.E(v);
        d();
        return this.f6287a.put(k, v);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public final V j(Object obj) {
        com.google.common.base.i.E(obj);
        d();
        return this.f6287a.remove(obj);
    }

    public final Set<K> k() {
        return new a();
    }
}
