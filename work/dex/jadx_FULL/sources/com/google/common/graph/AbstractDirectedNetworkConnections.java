package com.google.common.graph;

import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32043a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<E, N> f6257a;
    public final Map<E, N> b;

    public class a extends AbstractSet<E> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator<E> iterator() {
            return Iterators.f0((AbstractDirectedNetworkConnections.this.f32043a == 0 ? com.google.common.collect.o.f(AbstractDirectedNetworkConnections.this.f6257a.keySet(), AbstractDirectedNetworkConnections.this.b.keySet()) : Sets.N(AbstractDirectedNetworkConnections.this.f6257a.keySet(), AbstractDirectedNetworkConnections.this.b.keySet())).iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return AbstractDirectedNetworkConnections.this.f6257a.containsKey(obj) || AbstractDirectedNetworkConnections.this.b.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.math.e.t(AbstractDirectedNetworkConnections.this.f6257a.size(), AbstractDirectedNetworkConnections.this.b.size() - AbstractDirectedNetworkConnections.this.f32043a);
        }
    }

    public AbstractDirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i) {
        this.f6257a = (Map) com.google.common.base.i.E(map);
        this.b = (Map) com.google.common.base.i.E(map2);
        this.f32043a = Graphs.b(i);
        com.google.common.base.i.g0(i <= map.size() && i <= map2.size());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> b() {
        return Sets.N(a(), c());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N d(E e) {
        N n = this.b.get(e);
        Objects.requireNonNull(n);
        return n;
    }

    @Override // com.google.common.graph.NetworkConnections
    public N e(E e) {
        N nRemove = this.b.remove(e);
        Objects.requireNonNull(nRemove);
        return nRemove;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> f() {
        return Collections.unmodifiableSet(this.f6257a.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public void g(E e, N n) {
        com.google.common.base.i.E(e);
        com.google.common.base.i.E(n);
        com.google.common.base.i.g0(this.b.put(e, n) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void h(E e, N n, boolean z) {
        com.google.common.base.i.E(e);
        com.google.common.base.i.E(n);
        if (z) {
            int i = this.f32043a + 1;
            this.f32043a = i;
            Graphs.d(i);
        }
        com.google.common.base.i.g0(this.f6257a.put(e, n) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> i() {
        return Collections.unmodifiableSet(this.b.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N j(E e, boolean z) {
        if (z) {
            int i = this.f32043a - 1;
            this.f32043a = i;
            Graphs.b(i);
        }
        N nRemove = this.f6257a.remove(e);
        Objects.requireNonNull(nRemove);
        return nRemove;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> k() {
        return new a();
    }
}
