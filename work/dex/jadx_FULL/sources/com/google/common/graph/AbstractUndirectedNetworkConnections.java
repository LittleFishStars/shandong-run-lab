package com.google.common.graph;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<E, N> f32051a;

    public AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.f32051a = (Map) com.google.common.base.i.E(map);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> a() {
        return b();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> c() {
        return b();
    }

    @Override // com.google.common.graph.NetworkConnections
    public N d(E e) {
        N n = this.f32051a.get(e);
        Objects.requireNonNull(n);
        return n;
    }

    @Override // com.google.common.graph.NetworkConnections
    public N e(E e) {
        N nRemove = this.f32051a.remove(e);
        Objects.requireNonNull(nRemove);
        return nRemove;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> f() {
        return k();
    }

    @Override // com.google.common.graph.NetworkConnections
    public void g(E e, N n) {
        com.google.common.base.i.g0(this.f32051a.put(e, n) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void h(E e, N n, boolean z) {
        if (z) {
            return;
        }
        g(e, n);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> i() {
        return k();
    }

    @Override // com.google.common.graph.NetworkConnections
    @CheckForNull
    public N j(E e, boolean z) {
        if (z) {
            return null;
        }
        return e(e);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> k() {
        return Collections.unmodifiableSet(this.f32051a.keySet());
    }
}
