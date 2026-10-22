package com.google.common.graph;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class l<N, E> extends n<N, E> implements MutableNetwork<N, E> {
    public l(j<? super N, ? super E> jVar) {
        super(jVar);
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean H(EndpointPair<N> endpointPair, E e) {
        validateEndpoints(endpointPair);
        return K(endpointPair.d(), endpointPair.e(), e);
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean J(E e) {
        com.google.common.base.i.F(e, "edge");
        N nF = ((n) this).f6292b.f(e);
        boolean z = false;
        if (nF == null) {
            return false;
        }
        NetworkConnections<N, E> networkConnectionsF = ((n) this).f6290a.f(nF);
        Objects.requireNonNull(networkConnectionsF);
        NetworkConnections<N, E> networkConnections = networkConnectionsF;
        N nD = networkConnections.d(e);
        NetworkConnections<N, E> networkConnectionsF2 = ((n) this).f6290a.f(nD);
        Objects.requireNonNull(networkConnectionsF2);
        NetworkConnections<N, E> networkConnections2 = networkConnectionsF2;
        networkConnections.e(e);
        if (g() && nF.equals(nD)) {
            z = true;
        }
        networkConnections2.j(e, z);
        ((n) this).f6292b.j(e);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean K(N n, N n2, E e) {
        com.google.common.base.i.F(n, "nodeU");
        com.google.common.base.i.F(n2, "nodeV");
        com.google.common.base.i.F(e, "edge");
        if (V(e)) {
            EndpointPair<N> endpointPairW = w(e);
            EndpointPair endpointPairG = EndpointPair.g(this, n, n2);
            com.google.common.base.i.z(endpointPairW.equals(endpointPairG), GraphConstants.f6273c, e, endpointPairW, endpointPairG);
            return false;
        }
        NetworkConnections<N, E> networkConnectionsF = ((n) this).f6290a.f(n);
        if (!L()) {
            com.google.common.base.i.y(networkConnectionsF == null || !networkConnectionsF.c().contains(n2), GraphConstants.e, n, n2);
        }
        boolean zEquals = n.equals(n2);
        if (!g()) {
            com.google.common.base.i.u(!zEquals, GraphConstants.f, n);
        }
        if (networkConnectionsF == null) {
            networkConnectionsF = X(n);
        }
        networkConnectionsF.g(e, n2);
        NetworkConnections<N, E> networkConnectionsF2 = ((n) this).f6290a.f(n2);
        if (networkConnectionsF2 == null) {
            networkConnectionsF2 = X(n2);
        }
        networkConnectionsF2.h(e, n, zEquals);
        ((n) this).f6292b.i(e, n);
        return true;
    }

    @CanIgnoreReturnValue
    public final NetworkConnections<N, E> X(N n) {
        NetworkConnections<N, E> networkConnectionsY = Y();
        com.google.common.base.i.g0(((n) this).f6290a.i(n, networkConnectionsY) == null);
        return networkConnectionsY;
    }

    public final NetworkConnections<N, E> Y() {
        if (j()) {
            return L() ? a.p() : b.n();
        }
        return L() ? q.p() : r.m();
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean q(N n) {
        com.google.common.base.i.F(n, "node");
        NetworkConnections<N, E> networkConnectionsF = ((n) this).f6290a.f(n);
        if (networkConnectionsF == null) {
            return false;
        }
        UnmodifiableIterator<E> it = ImmutableList.copyOf((Collection) networkConnectionsF.k()).iterator();
        while (it.hasNext()) {
            J(it.next());
        }
        ((n) this).f6290a.j(n);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean r(N n) {
        com.google.common.base.i.F(n, "node");
        if (W(n)) {
            return false;
        }
        X(n);
        return true;
    }
}
