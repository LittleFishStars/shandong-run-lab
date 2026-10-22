package com.google.common.graph;

import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public class n<N, E> extends AbstractNetwork<N, E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ElementOrder<N> f32109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final h<N, NetworkConnections<N, E>> f6290a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f6291a;
    public final ElementOrder<E> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final h<E, N> f6292b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f6293b;
    public final boolean c;

    public n(j<? super N, ? super E> jVar) {
        this(jVar, ((AbstractGraphBuilder) jVar).f6258a.c(((AbstractGraphBuilder) jVar).f32045a.or(10).intValue()), jVar.c.c(jVar.b.or(20).intValue()));
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> A() {
        return this.b;
    }

    @Override // com.google.common.graph.Network
    public Set<E> B(N n) {
        return T(n).i();
    }

    @Override // com.google.common.graph.Network
    public boolean L() {
        return this.f6293b;
    }

    @Override // com.google.common.graph.Network
    public Set<E> M(N n) {
        return T(n).f();
    }

    public final NetworkConnections<N, E> T(N n) {
        NetworkConnections<N, E> networkConnectionsF = this.f6290a.f(n);
        if (networkConnectionsF != null) {
            return networkConnectionsF;
        }
        com.google.common.base.i.E(n);
        throw new IllegalArgumentException(String.format(GraphConstants.f6271a, n));
    }

    public final N U(E e) {
        N nF = this.f6292b.f(e);
        if (nF != null) {
            return nF;
        }
        com.google.common.base.i.E(e);
        throw new IllegalArgumentException(String.format(GraphConstants.f6272b, e));
    }

    public final boolean V(E e) {
        return this.f6292b.e(e);
    }

    public final boolean W(N n) {
        return this.f6290a.e(n);
    }

    @Override // com.google.common.graph.Network
    public Set<E> c(N n) {
        return T(n).k();
    }

    @Override // com.google.common.graph.Network
    public Set<N> f() {
        return this.f6290a.k();
    }

    @Override // com.google.common.graph.Network
    public boolean g() {
        return this.c;
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: h */
    public Set<N> b(N n) {
        return T(n).c();
    }

    @Override // com.google.common.graph.Network
    public Set<E> i() {
        return this.f6292b.k();
    }

    @Override // com.google.common.graph.Network
    public boolean j() {
        return this.f6291a;
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: m */
    public Set<N> a(N n) {
        return T(n).a();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> n() {
        return this.f32109a;
    }

    @Override // com.google.common.graph.Network
    public Set<N> o(N n) {
        return T(n).b();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> w(E e) {
        N nU = U(e);
        NetworkConnections<N, E> networkConnectionsF = this.f6290a.f(nU);
        Objects.requireNonNull(networkConnectionsF);
        return EndpointPair.g(this, nU, networkConnectionsF.d(e));
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> x(N n, N n2) {
        NetworkConnections<N, E> networkConnectionsT = T(n);
        if (!this.c && n == n2) {
            return ImmutableSet.of();
        }
        com.google.common.base.i.u(W(n2), GraphConstants.f6271a, n2);
        return networkConnectionsT.l(n2);
    }

    public n(j<? super N, ? super E> jVar, Map<N, NetworkConnections<N, E>> map, Map<E, N> map2) {
        h<N, NetworkConnections<N, E>> hVar;
        this.f6291a = ((AbstractGraphBuilder) jVar).f6259a;
        this.f6293b = jVar.f6289c;
        this.c = ((AbstractGraphBuilder) jVar).f6260b;
        this.f32109a = (ElementOrder<N>) ((AbstractGraphBuilder) jVar).f6258a.a();
        this.b = (ElementOrder<E>) jVar.c.a();
        if (map instanceof TreeMap) {
            hVar = new i<>(map);
        } else {
            hVar = new h<>(map);
        }
        this.f6290a = hVar;
        this.f6292b = new h<>(map2);
    }
}
