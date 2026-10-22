package com.google.common.graph;

import com.google.common.annotations.Beta;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public interface ValueGraph<N, V> extends BaseGraph<N> {
    @CheckForNull
    V C(N n, N n2, @CheckForNull V v);

    @CheckForNull
    V G(EndpointPair<N> endpointPair, @CheckForNull V v);

    @Override // com.google.common.graph.BaseGraph
    Set<EndpointPair<N>> c(N n);

    @Override // com.google.common.graph.BaseGraph
    int d(N n);

    @Override // com.google.common.graph.BaseGraph
    int e(N n);

    boolean equals(@CheckForNull Object obj);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    Set<N> f();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    boolean g();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: h */
    Set<N> b(N n);

    int hashCode();

    @Override // com.google.common.graph.BaseGraph
    Set<EndpointPair<N>> i();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    boolean j();

    @Override // com.google.common.graph.BaseGraph
    boolean k(N n, N n2);

    @Override // com.google.common.graph.BaseGraph
    boolean l(EndpointPair<N> endpointPair);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: m */
    Set<N> a(N n);

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    ElementOrder<N> n();

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    Set<N> o(N n);

    @Override // com.google.common.graph.BaseGraph
    int p(N n);

    @Override // com.google.common.graph.BaseGraph
    ElementOrder<N> s();

    Graph<N> t();
}
