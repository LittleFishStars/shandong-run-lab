package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class m<N, V> extends o<N, V> implements MutableValueGraph<N, V> {
    public final ElementOrder<N> b;

    public m(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
        this.b = (ElementOrder<N>) abstractGraphBuilder.b.a();
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    @CheckForNull
    public V D(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return E(endpointPair.d(), endpointPair.e());
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    @CheckForNull
    public V E(N n, N n2) {
        com.google.common.base.i.F(n, "nodeU");
        com.google.common.base.i.F(n2, "nodeV");
        GraphConnections<N, V> graphConnectionsF = ((o) this).f6295a.f(n);
        GraphConnections<N, V> graphConnectionsF2 = ((o) this).f6295a.f(n2);
        if (graphConnectionsF == null || graphConnectionsF2 == null) {
            return null;
        }
        V vG = graphConnectionsF.g(n2);
        if (vG != null) {
            graphConnectionsF2.f(n);
            long j = ((o) this).f32110a - 1;
            ((o) this).f32110a = j;
            Graphs.c(j);
        }
        return vG;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    @CheckForNull
    public V I(N n, N n2, V v) {
        com.google.common.base.i.F(n, "nodeU");
        com.google.common.base.i.F(n2, "nodeV");
        com.google.common.base.i.F(v, "value");
        if (!g()) {
            com.google.common.base.i.u(!n.equals(n2), GraphConstants.f, n);
        }
        GraphConnections<N, V> graphConnectionsF = ((o) this).f6295a.f(n);
        if (graphConnectionsF == null) {
            graphConnectionsF = W(n);
        }
        V vH = graphConnectionsF.h(n2, v);
        GraphConnections<N, V> graphConnectionsF2 = ((o) this).f6295a.f(n2);
        if (graphConnectionsF2 == null) {
            graphConnectionsF2 = W(n2);
        }
        graphConnectionsF2.i(n, v);
        if (vH == null) {
            long j = ((o) this).f32110a + 1;
            ((o) this).f32110a = j;
            Graphs.e(j);
        }
        return vH;
    }

    @CanIgnoreReturnValue
    public final GraphConnections<N, V> W(N n) {
        GraphConnections<N, V> graphConnectionsX = X();
        com.google.common.base.i.g0(((o) this).f6295a.i(n, graphConnectionsX) == null);
        return graphConnectionsX;
    }

    public final GraphConnections<N, V> X() {
        return j() ? DirectedGraphConnections.r(this.b) : p.j(this.b);
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean q(N n) {
        com.google.common.base.i.F(n, "node");
        GraphConnections<N, V> graphConnectionsF = ((o) this).f6295a.f(n);
        if (graphConnectionsF == null) {
            return false;
        }
        if (g() && graphConnectionsF.g(n) != null) {
            graphConnectionsF.f(n);
            ((o) this).f32110a--;
        }
        Iterator<N> it = graphConnectionsF.c().iterator();
        while (it.hasNext()) {
            GraphConnections<N, V> graphConnectionsH = ((o) this).f6295a.h(it.next());
            Objects.requireNonNull(graphConnectionsH);
            graphConnectionsH.f(n);
            ((o) this).f32110a--;
        }
        if (j()) {
            Iterator<N> it2 = graphConnectionsF.a().iterator();
            while (it2.hasNext()) {
                GraphConnections<N, V> graphConnectionsH2 = ((o) this).f6295a.h(it2.next());
                Objects.requireNonNull(graphConnectionsH2);
                com.google.common.base.i.g0(graphConnectionsH2.g(n) != null);
                ((o) this).f32110a--;
            }
        }
        ((o) this).f6295a.j(n);
        Graphs.c(((o) this).f32110a);
        return true;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean r(N n) {
        com.google.common.base.i.F(n, "node");
        if (T(n)) {
            return false;
        }
        W(n);
        return true;
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public ElementOrder<N> s() {
        return this.b;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    @CheckForNull
    public V y(EndpointPair<N> endpointPair, V v) {
        validateEndpoints(endpointPair);
        return I(endpointPair.d(), endpointPair.e(), v);
    }
}
