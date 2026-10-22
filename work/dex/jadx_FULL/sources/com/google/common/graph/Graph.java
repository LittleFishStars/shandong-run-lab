package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@DoNotMock("Use GraphBuilder to create a real instance")
@Beta
@ElementTypesAreNonnullByDefault
public interface Graph<N> extends BaseGraph<N> {
    @Override // com.google.common.graph.BaseGraph
    Set<EndpointPair<N>> c(N n);

    @Override // com.google.common.graph.BaseGraph
    int d(N n);

    @Override // com.google.common.graph.BaseGraph
    int e(N n);

    boolean equals(@CheckForNull Object obj);

    Set<N> f();

    boolean g();

    @Override // 
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    Set<N> b(N n);

    int hashCode();

    @Override // com.google.common.graph.BaseGraph
    Set<EndpointPair<N>> i();

    boolean j();

    @Override // com.google.common.graph.BaseGraph
    boolean k(N n, N n2);

    @Override // com.google.common.graph.BaseGraph
    boolean l(EndpointPair<N> endpointPair);

    @Override // 
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    Set<N> a(N n);

    ElementOrder<N> n();

    Set<N> o(N n);

    @Override // com.google.common.graph.BaseGraph
    int p(N n);

    @Override // com.google.common.graph.BaseGraph
    ElementOrder<N> s();
}
