package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable(containerOf = {"N", "V"})
@Beta
@ElementTypesAreNonnullByDefault
public final class g<N, V> extends o<N, V> {

    public class a implements Function<N, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueGraph f32101a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f6286a;

        public a(ValueGraph valueGraph, Object obj) {
            this.f32101a = valueGraph;
            this.f6286a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Function
        public V apply(N n) {
            V v = (V) this.f32101a.C(this.f6286a, n, null);
            Objects.requireNonNull(v);
            return v;
        }
    }

    public static class b<N, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutableValueGraph<N, V> f32102a;

        public b(s<N, V> sVar) {
            this.f32102a = sVar.d().i(ElementOrder.g()).b();
        }

        @CanIgnoreReturnValue
        public b<N, V> a(N n) {
            this.f32102a.r(n);
            return this;
        }

        public g<N, V> b() {
            return g.Z(this.f32102a);
        }

        @CanIgnoreReturnValue
        public b<N, V> c(EndpointPair<N> endpointPair, V v) {
            this.f32102a.y(endpointPair, v);
            return this;
        }

        @CanIgnoreReturnValue
        public b<N, V> d(N n, N n2, V v) {
            this.f32102a.I(n, n2, v);
            return this;
        }
    }

    public g(ValueGraph<N, V> valueGraph) {
        super(s.g(valueGraph), a0(valueGraph), valueGraph.i().size());
    }

    public static <N, V> GraphConnections<N, V> X(ValueGraph<N, V> valueGraph, N n) {
        a aVar = new a(valueGraph, n);
        return valueGraph.j() ? DirectedGraphConnections.s(n, valueGraph.c(n), aVar) : p.k(Maps.j(valueGraph.o(n), aVar));
    }

    @Deprecated
    public static <N, V> g<N, V> Y(g<N, V> gVar) {
        return (g) com.google.common.base.i.E(gVar);
    }

    public static <N, V> g<N, V> Z(ValueGraph<N, V> valueGraph) {
        return valueGraph instanceof g ? (g) valueGraph : new g<>(valueGraph);
    }

    public static <N, V> ImmutableMap<N, GraphConnections<N, V>> a0(ValueGraph<N, V> valueGraph) {
        ImmutableMap.b bVarBuilder = ImmutableMap.builder();
        for (N n : valueGraph.f()) {
            bVarBuilder.f(n, X(valueGraph, n));
        }
        return bVarBuilder.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.o, com.google.common.graph.ValueGraph
    @CheckForNull
    public /* bridge */ /* synthetic */ Object C(Object obj, Object obj2, @CheckForNull Object obj3) {
        return super.C(obj, obj2, obj3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.o, com.google.common.graph.ValueGraph
    @CheckForNull
    public /* bridge */ /* synthetic */ Object G(EndpointPair endpointPair, @CheckForNull Object obj) {
        return super.G(endpointPair, obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
    /* JADX INFO: renamed from: W, reason: merged with bridge method [inline-methods] */
    public e<N> t() {
        return new e<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.o, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set c(Object obj) {
        return super.c(obj);
    }

    @Override // com.google.common.graph.o, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set f() {
        return super.f();
    }

    @Override // com.google.common.graph.o, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.o, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    /* JADX INFO: renamed from: h */
    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b(obj);
    }

    @Override // com.google.common.graph.o, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.o, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean k(Object obj, Object obj2) {
        return super.k(obj, obj2);
    }

    @Override // com.google.common.graph.o, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean l(EndpointPair endpointPair) {
        return super.l(endpointPair);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.o, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    /* JADX INFO: renamed from: m */
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    @Override // com.google.common.graph.o, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ ElementOrder n() {
        return super.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.o, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set o(Object obj) {
        return super.o(obj);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public ElementOrder<N> s() {
        return ElementOrder.g();
    }
}
