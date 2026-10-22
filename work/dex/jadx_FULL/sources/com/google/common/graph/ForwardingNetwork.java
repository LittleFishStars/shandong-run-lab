package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    @Override // com.google.common.graph.Network
    public ElementOrder<E> A() {
        return T().A();
    }

    @Override // com.google.common.graph.Network
    public Set<E> B(N n) {
        return T().B(n);
    }

    @Override // com.google.common.graph.Network
    public boolean L() {
        return T().L();
    }

    @Override // com.google.common.graph.Network
    public Set<E> M(N n) {
        return T().M(n);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    @CheckForNull
    public E P(N n, N n2) {
        return T().P(n, n2);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> Q(E e) {
        return T().Q(e);
    }

    public abstract Network<N, E> T();

    @Override // com.google.common.graph.Network
    public Set<E> c(N n) {
        return T().c(n);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int d(N n) {
        return T().d(n);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int e(N n) {
        return T().e(n);
    }

    @Override // com.google.common.graph.Network
    public Set<N> f() {
        return T().f();
    }

    @Override // com.google.common.graph.Network
    public boolean g() {
        return T().g();
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: h */
    public Set<N> b(N n) {
        return T().b(n);
    }

    @Override // com.google.common.graph.Network
    public Set<E> i() {
        return T().i();
    }

    @Override // com.google.common.graph.Network
    public boolean j() {
        return T().j();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean k(N n, N n2) {
        return T().k(n, n2);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean l(EndpointPair<N> endpointPair) {
        return T().l(endpointPair);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: m */
    public Set<N> a(N n) {
        return T().a(n);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> n() {
        return T().n();
    }

    @Override // com.google.common.graph.Network
    public Set<N> o(N n) {
        return T().o(n);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int p(N n) {
        return T().p(n);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    @CheckForNull
    public E u(EndpointPair<N> endpointPair) {
        return T().u(endpointPair);
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> w(E e) {
        return T().w(e);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> x(N n, N n2) {
        return T().x(n, n2);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> z(EndpointPair<N> endpointPair) {
        return T().z(endpointPair);
    }
}
