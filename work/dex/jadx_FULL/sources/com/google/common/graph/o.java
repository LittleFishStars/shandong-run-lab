package com.google.common.graph;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public class o<N, V> extends AbstractValueGraph<N, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f32110a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ElementOrder<N> f6294a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final h<N, GraphConnections<N, V>> f6295a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f6296a;
    public final boolean b;

    public class a extends IncidentEdgeSet<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GraphConnections f32111a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar, BaseGraph baseGraph, Object obj, GraphConnections graphConnections) {
            super(baseGraph, obj);
            this.f32111a = graphConnections;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<EndpointPair<N>> iterator() {
            return this.f32111a.e(((IncidentEdgeSet) this).f6275a);
        }
    }

    public o(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.f6258a.c(abstractGraphBuilder.f32045a.or(10).intValue()), 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public V C(N n, N n2, @CheckForNull V v) {
        return (V) U(com.google.common.base.i.E(n), com.google.common.base.i.E(n2), v);
    }

    @CheckForNull
    public V G(EndpointPair<N> endpointPair, @CheckForNull V v) {
        validateEndpoints(endpointPair);
        return U(endpointPair.d(), endpointPair.e(), v);
    }

    public final GraphConnections<N, V> S(N n) {
        GraphConnections<N, V> graphConnectionsF = this.f6295a.f(n);
        if (graphConnectionsF != null) {
            return graphConnectionsF;
        }
        com.google.common.base.i.E(n);
        String strValueOf = String.valueOf(n);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
        sb.append("Node ");
        sb.append(strValueOf);
        sb.append(" is not an element of this graph.");
        throw new IllegalArgumentException(sb.toString());
    }

    public final boolean T(@CheckForNull N n) {
        return this.f6295a.e(n);
    }

    @CheckForNull
    public final V U(N n, N n2, @CheckForNull V v) {
        GraphConnections<N, V> graphConnectionsF = this.f6295a.f(n);
        V vD = graphConnectionsF == null ? null : graphConnectionsF.d(n2);
        return vD == null ? v : vD;
    }

    public final boolean V(N n, N n2) {
        GraphConnections<N, V> graphConnectionsF = this.f6295a.f(n);
        return graphConnectionsF != null && graphConnectionsF.c().contains(n2);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> c(N n) {
        return new a(this, this, n, S(n));
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    public long edgeCount() {
        return this.f32110a;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> f() {
        return this.f6295a.k();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean g() {
        return this.b;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: h */
    public Set<N> b(N n) {
        return S(n).c();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean j() {
        return this.f6296a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean k(N n, N n2) {
        return V(com.google.common.base.i.E(n), com.google.common.base.i.E(n2));
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean l(EndpointPair<N> endpointPair) {
        com.google.common.base.i.E(endpointPair);
        return isOrderingCompatible(endpointPair) && V(endpointPair.d(), endpointPair.e());
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
    /* JADX INFO: renamed from: m */
    public Set<N> a(N n) {
        return S(n).a();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public ElementOrder<N> n() {
        return this.f6294a;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> o(N n) {
        return S(n).b();
    }

    public o(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j) {
        h<N, GraphConnections<N, V>> hVar;
        this.f6296a = abstractGraphBuilder.f6259a;
        this.b = abstractGraphBuilder.f6260b;
        this.f6294a = (ElementOrder<N>) abstractGraphBuilder.f6258a.a();
        if (map instanceof TreeMap) {
            hVar = new i<>(map);
        } else {
            hVar = new h<>(map);
        }
        this.f6295a = hVar;
        this.f32110a = Graphs.c(j);
    }
}
