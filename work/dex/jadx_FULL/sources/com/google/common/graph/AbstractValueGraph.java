package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public abstract class AbstractValueGraph<N, V> extends AbstractBaseGraph<N> implements ValueGraph<N, V> {

    public class a extends AbstractGraph<N> {
        public a() {
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int d(N n) {
            return AbstractValueGraph.this.d(n);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int e(N n) {
            return AbstractValueGraph.this.e(n);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> f() {
            return AbstractValueGraph.this.f();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean g() {
            return AbstractValueGraph.this.g();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: h */
        public Set<N> b(N n) {
            return AbstractValueGraph.this.b(n);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> i() {
            return AbstractValueGraph.this.i();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean j() {
            return AbstractValueGraph.this.j();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: m */
        public Set<N> a(N n) {
            return AbstractValueGraph.this.a(n);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public ElementOrder<N> n() {
            return AbstractValueGraph.this.n();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> o(N n) {
            return AbstractValueGraph.this.o(n);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int p(N n) {
            return AbstractValueGraph.this.p(n);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public ElementOrder<N> s() {
            return AbstractValueGraph.this.s();
        }
    }

    public class b implements Function<EndpointPair<N>, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ValueGraph f32053a;

        public b(ValueGraph valueGraph) {
            this.f32053a = valueGraph;
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public V apply(EndpointPair<N> endpointPair) {
            V v = (V) this.f32053a.C(endpointPair.d(), endpointPair.e(), null);
            Objects.requireNonNull(v);
            return v;
        }
    }

    public static <N, V> Map<EndpointPair<N>, V> R(ValueGraph<N, V> valueGraph) {
        return Maps.j(valueGraph.i(), new b(valueGraph));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set c(Object obj) {
        return super.c(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int d(Object obj) {
        return super.d(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int e(Object obj) {
        return super.e(obj);
    }

    @Override // com.google.common.graph.ValueGraph
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueGraph)) {
            return false;
        }
        ValueGraph valueGraph = (ValueGraph) obj;
        return j() == valueGraph.j() && f().equals(valueGraph.f()) && R(this).equals(R(valueGraph));
    }

    @Override // com.google.common.graph.ValueGraph
    public final int hashCode() {
        return R(this).hashCode();
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ Set i() {
        return super.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean k(Object obj, Object obj2) {
        return super.k(obj, obj2);
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean l(EndpointPair endpointPair) {
        return super.l(endpointPair);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ int p(Object obj) {
        return super.p(obj);
    }

    @Override // com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ ElementOrder s() {
        return super.s();
    }

    @Override // com.google.common.graph.ValueGraph
    public Graph<N> t() {
        return new a();
    }

    public String toString() {
        boolean zJ = j();
        boolean zG = g();
        String strValueOf = String.valueOf(f());
        String strValueOf2 = String.valueOf(R(this));
        StringBuilder sb = new StringBuilder(strValueOf.length() + 59 + strValueOf2.length());
        sb.append("isDirected: ");
        sb.append(zJ);
        sb.append(", allowsSelfLoops: ");
        sb.append(zG);
        sb.append(", nodes: ");
        sb.append(strValueOf);
        sb.append(", edges: ");
        sb.append(strValueOf2);
        return sb.toString();
    }
}
