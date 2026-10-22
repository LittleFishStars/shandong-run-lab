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
public final class q<N, E> extends AbstractUndirectedNetworkConnections<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    public transient Reference<Multiset<N>> f32115a;

    public class a extends MultiEdgesConnecting<E> {
        public final /* synthetic */ Object b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Map map, Object obj, Object obj2) {
            super(map, obj);
            this.b = obj2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return q.this.n().count(this.b);
        }
    }

    public q(Map<E, N> map) {
        super(map);
    }

    @CheckForNull
    public static <T> T o(@CheckForNull Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    public static <N, E> q<N, E> p() {
        return new q<>(new HashMap(2, 1.0f));
    }

    public static <N, E> q<N, E> q(Map<E, N> map) {
        return new q<>(ImmutableMap.copyOf((Map) map));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> b() {
        return Collections.unmodifiableSet(n().elementSet());
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N e(E e) {
        N n = (N) super.e(e);
        Multiset multiset = (Multiset) o(this.f32115a);
        if (multiset != null) {
            com.google.common.base.i.g0(multiset.remove(n));
        }
        return n;
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void g(E e, N n) {
        super.g(e, n);
        Multiset multiset = (Multiset) o(this.f32115a);
        if (multiset != null) {
            com.google.common.base.i.g0(multiset.add(n));
        }
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void h(E e, N n, boolean z) {
        if (z) {
            return;
        }
        g(e, n);
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    @CheckForNull
    public N j(E e, boolean z) {
        if (z) {
            return null;
        }
        return e(e);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> l(N n) {
        return new a(super.f32051a, n, n);
    }

    public final Multiset<N> n() {
        Multiset<N> multiset = (Multiset) o(this.f32115a);
        if (multiset != null) {
            return multiset;
        }
        HashMultiset hashMultisetCreate = HashMultiset.create(super.f32051a.values());
        this.f32115a = new SoftReference(hashMultisetCreate);
        return hashMultisetCreate;
    }
}
