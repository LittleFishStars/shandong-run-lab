package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@DoNotMock("Use NetworkBuilder to create a real instance")
@Beta
@ElementTypesAreNonnullByDefault
public interface Network<N, E> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    ElementOrder<E> A();

    Set<E> B(N n);

    boolean L();

    Set<E> M(N n);

    @CheckForNull
    E P(N n, N n2);

    Set<E> Q(E e);

    Set<E> c(N n);

    int d(N n);

    int e(N n);

    boolean equals(@CheckForNull Object obj);

    Set<N> f();

    boolean g();

    @Override // com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    Set<N> b(N n);

    int hashCode();

    Set<E> i();

    boolean j();

    boolean k(N n, N n2);

    boolean l(EndpointPair<N> endpointPair);

    @Override // com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    Set<N> a(N n);

    ElementOrder<N> n();

    Set<N> o(N n);

    int p(N n);

    Graph<N> t();

    @CheckForNull
    E u(EndpointPair<N> endpointPair);

    EndpointPair<N> w(E e);

    Set<E> x(N n, N n2);

    Set<E> z(EndpointPair<N> endpointPair);
}
