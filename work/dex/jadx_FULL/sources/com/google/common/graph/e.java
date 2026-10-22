package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable(containerOf = {"N"})
@Beta
@ElementTypesAreNonnullByDefault
public class e<N> extends ForwardingGraph<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseGraph<N> f32095a;

    public static class a<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutableGraph<N> f32096a;

        public a(d<N> dVar) {
            this.f32096a = dVar.d().i(ElementOrder.g()).b();
        }

        @CanIgnoreReturnValue
        public a<N> a(N n) {
            this.f32096a.r(n);
            return this;
        }

        public e<N> b() {
            return e.T(this.f32096a);
        }

        @CanIgnoreReturnValue
        public a<N> c(EndpointPair<N> endpointPair) {
            this.f32096a.v(endpointPair);
            return this;
        }

        @CanIgnoreReturnValue
        public a<N> d(N n, N n2) {
            this.f32096a.O(n, n2);
            return this;
        }
    }

    public e(BaseGraph<N> baseGraph) {
        this.f32095a = baseGraph;
    }

    public static <N> GraphConnections<N, GraphConstants.Presence> S(Graph<N> graph, N n) {
        Function functionB = Functions.b(GraphConstants.Presence.EDGE_EXISTS);
        return graph.j() ? DirectedGraphConnections.s(n, graph.c(n), functionB) : p.k(Maps.j(graph.o(n), functionB));
    }

    public static <N> e<N> T(Graph<N> graph) {
        return graph instanceof e ? (e) graph : new e<>(new o(d.g(graph), V(graph), graph.i().size()));
    }

    @Deprecated
    public static <N> e<N> U(e<N> eVar) {
        return (e) com.google.common.base.i.E(eVar);
    }

    public static <N> ImmutableMap<N, GraphConnections<N, GraphConstants.Presence>> V(Graph<N> graph) {
        ImmutableMap.b bVarBuilder = ImmutableMap.builder();
        for (N n : graph.f()) {
            bVarBuilder.f(n, S(graph, n));
        }
        return bVarBuilder.a();
    }

    @Override // com.google.common.graph.ForwardingGraph
    public BaseGraph<N> R() {
        return this.f32095a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set c(Object obj) {
        return super.c(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int d(Object obj) {
        return super.d(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return super.e(obj);
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set f() {
        return super.f();
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    /* JADX INFO: renamed from: h */
    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b(obj);
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean k(Object obj, Object obj2) {
        return super.k(obj, obj2);
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean l(EndpointPair endpointPair) {
        return super.l(endpointPair);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    /* JADX INFO: renamed from: m */
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ ElementOrder n() {
        return super.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set o(Object obj) {
        return super.o(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int p(Object obj) {
        return super.p(obj);
    }

    @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public ElementOrder<N> s() {
        return ElementOrder.g();
    }
}
