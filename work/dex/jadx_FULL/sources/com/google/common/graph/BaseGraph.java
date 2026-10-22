package com.google.common.graph;

import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<EndpointPair<N>> c(N n);

    int d(N n);

    int e(N n);

    Set<N> f();

    boolean g();

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: h */
    Set<N> b(N n);

    Set<EndpointPair<N>> i();

    boolean j();

    boolean k(N n, N n2);

    boolean l(EndpointPair<N> endpointPair);

    @Override // com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: m */
    Set<N> a(N n);

    ElementOrder<N> n();

    Set<N> o(N n);

    int p(N n);

    ElementOrder<N> s();
}
