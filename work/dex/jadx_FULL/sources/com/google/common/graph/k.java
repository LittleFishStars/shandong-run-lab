package com.google.common.graph;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class k<N> extends ForwardingGraph<N> implements MutableGraph<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableValueGraph<N, GraphConstants.Presence> f32108a;

    public k(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.f32108a = new m(abstractGraphBuilder);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean F(N n, N n2) {
        return this.f32108a.E(n, n2) != null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean N(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return F(endpointPair.d(), endpointPair.e());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean O(N n, N n2) {
        return this.f32108a.I(n, n2, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    @Override // com.google.common.graph.ForwardingGraph
    public BaseGraph<N> R() {
        return this.f32108a;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean q(N n) {
        return this.f32108a.q(n);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean r(N n) {
        return this.f32108a.r(n);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean v(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return O(endpointPair.d(), endpointPair.e());
    }
}
