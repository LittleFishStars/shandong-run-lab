package com.google.common.graph;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class a<N, E> extends AbstractDirectedNetworkConnections<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient Reference<Multiset<N>> f32092a;

    @CheckForNull
    @LazyInit
    public transient Reference<Multiset<N>> b;

    /* JADX INFO: renamed from: com.google.common.graph.a$a, reason: collision with other inner class name */
    public class C0748a extends MultiEdgesConnecting<E> {
        public final /* synthetic */ Object b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0748a(Map map, Object obj, Object obj2) {
            super(map, obj);
            this.b = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return a.this.s().count(this.b);
        }
    }

    public a(Map<E, N> map, Map<E, N> map2, int i) {
        super(map, map2, i);
    }

    @CheckForNull
    public static <T> T o(@CheckForNull Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static <N, E> a<N, E> p() {
        return new a<>(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    public static <N, E> a<N, E> q(Map<E, N> map, Map<E, N> map2, int i) {
        return new a<>(ImmutableMap.copyOf((Map) map), ImmutableMap.copyOf((Map) map2), i);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> a() {
        return Collections.unmodifiableSet(r().elementSet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> c() {
        return Collections.unmodifiableSet(s().elementSet());
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N e(E e) {
        N n = (N) super.e(e);
        Multiset multiset = (Multiset) o(this.b);
        if (multiset != null) {
            com.google.common.base.i.g0(multiset.remove(n));
        }
        return n;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void g(E e, N n) {
        super.g(e, n);
        Multiset multiset = (Multiset) o(this.b);
        if (multiset != null) {
            com.google.common.base.i.g0(multiset.add(n));
        }
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void h(E e, N n, boolean z) {
        super.h(e, n, z);
        Multiset multiset = (Multiset) o(this.f32092a);
        if (multiset != null) {
            com.google.common.base.i.g0(multiset.add(n));
        }
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N j(E e, boolean z) {
        N n = (N) super.j(e, z);
        Multiset multiset = (Multiset) o(this.f32092a);
        if (multiset != null) {
            com.google.common.base.i.g0(multiset.remove(n));
        }
        return n;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> l(N n) {
        return new C0748a(super.b, n, n);
    }

    public final Multiset<N> r() {
        Multiset<N> multiset = (Multiset) o(this.f32092a);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetCreate = HashMultiset.create(((AbstractDirectedNetworkConnections) this).f6257a.values());
        this.f32092a = new SoftReference(hashMultisetCreate);
        return hashMultisetCreate;
    }

    public final Multiset<N> s() {
        Multiset<N> multiset = (Multiset) o(this.b);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetCreate = HashMultiset.create(super.b.values());
        this.b = new SoftReference(hashMultisetCreate);
        return hashMultisetCreate;
    }
}
