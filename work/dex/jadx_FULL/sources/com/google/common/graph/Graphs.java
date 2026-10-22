package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public final class Graphs {

    public enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    public static class a<N> extends ForwardingGraph<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Graph<N> f32076a;

        /* JADX INFO: renamed from: com.google.common.graph.Graphs$a$a, reason: collision with other inner class name */
        public class C0746a extends IncidentEdgeSet<N> {

            /* JADX INFO: renamed from: com.google.common.graph.Graphs$a$a$a, reason: collision with other inner class name */
            public class C0747a implements Function<EndpointPair<N>, EndpointPair<N>> {
                public C0747a() {
                }

                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public EndpointPair<N> apply(EndpointPair<N> endpointPair) {
                    return EndpointPair.f(a.this.R(), endpointPair.e(), endpointPair.d());
                }
            }

            public C0746a(BaseGraph baseGraph, Object obj) {
                super(baseGraph, obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<EndpointPair<N>> iterator() {
                return Iterators.c0(a.this.R().c(((IncidentEdgeSet) this).f6275a).iterator(), new C0747a());
            }
        }

        public a(Graph<N> graph) {
            this.f32076a = graph;
        }

        @Override // com.google.common.graph.ForwardingGraph
        /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
        public Graph<N> R() {
            return this.f32076a;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> c(N n) {
            return new C0746a(this, n);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int d(N n) {
            return R().p(n);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: h */
        public Set<N> b(N n) {
            return R().a(n);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean k(N n, N n2) {
            return R().k(n2, n);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean l(EndpointPair<N> endpointPair) {
            return R().l(Graphs.q(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: m */
        public Set<N> a(N n) {
            return R().b(n);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int p(N n) {
            return R().d(n);
        }
    }

    public static class b<N, E> extends ForwardingNetwork<N, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Network<N, E> f32079a;

        public b(Network<N, E> network) {
            this.f32079a = network;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> B(N n) {
            return T().M(n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> M(N n) {
            return T().B(n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        @CheckForNull
        public E P(N n, N n2) {
            return T().P(n2, n);
        }

        @Override // com.google.common.graph.ForwardingNetwork
        public Network<N, E> T() {
            return this.f32079a;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int d(N n) {
            return T().p(n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: h */
        public Set<N> b(N n) {
            return T().a(n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean k(N n, N n2) {
            return T().k(n2, n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean l(EndpointPair<N> endpointPair) {
            return T().l(Graphs.q(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: m */
        public Set<N> a(N n) {
            return T().b(n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int p(N n) {
            return T().d(n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        @CheckForNull
        public E u(EndpointPair<N> endpointPair) {
            return T().u(Graphs.q(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public EndpointPair<N> w(E e) {
            EndpointPair<N> endpointPairW = T().w(e);
            return EndpointPair.g(this.f32079a, endpointPairW.e(), endpointPairW.d());
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> x(N n, N n2) {
            return T().x(n2, n);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> z(EndpointPair<N> endpointPair) {
            return T().z(Graphs.q(endpointPair));
        }
    }

    public static class c<N, V> extends ForwardingValueGraph<N, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ValueGraph<N, V> f32080a;

        public c(ValueGraph<N, V> valueGraph) {
            this.f32080a = valueGraph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @CheckForNull
        public V C(N n, N n2, @CheckForNull V v) {
            return S().C(n2, n, v);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @CheckForNull
        public V G(EndpointPair<N> endpointPair, @CheckForNull V v) {
            return S().G(Graphs.q(endpointPair), v);
        }

        @Override // com.google.common.graph.ForwardingValueGraph
        public ValueGraph<N, V> S() {
            return this.f32080a;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int d(N n) {
            return S().p(n);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: h */
        public Set<N> b(N n) {
            return S().a(n);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean k(N n, N n2) {
            return S().k(n2, n);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean l(EndpointPair<N> endpointPair) {
            return S().l(Graphs.q(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: m */
        public Set<N> a(N n) {
            return S().b(n);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int p(N n) {
            return S().d(n);
        }
    }

    public static boolean a(Graph<?> graph, Object obj, @CheckForNull Object obj2) {
        return graph.j() || !com.google.common.base.g.a(obj2, obj);
    }

    @CanIgnoreReturnValue
    public static int b(int i) {
        com.google.common.base.i.k(i >= 0, "Not true that %s is non-negative.", i);
        return i;
    }

    @CanIgnoreReturnValue
    public static long c(long j) {
        com.google.common.base.i.p(j >= 0, "Not true that %s is non-negative.", j);
        return j;
    }

    @CanIgnoreReturnValue
    public static int d(int i) {
        com.google.common.base.i.k(i > 0, "Not true that %s is positive.", i);
        return i;
    }

    @CanIgnoreReturnValue
    public static long e(long j) {
        com.google.common.base.i.p(j > 0, "Not true that %s is positive.", j);
        return j;
    }

    public static <N> MutableGraph<N> f(Graph<N> graph) {
        MutableGraph<N> mutableGraph = (MutableGraph<N>) d.g(graph).f(graph.f().size()).b();
        Iterator<N> it = graph.f().iterator();
        while (it.hasNext()) {
            mutableGraph.r(it.next());
        }
        for (EndpointPair<N> endpointPair : graph.i()) {
            mutableGraph.O(endpointPair.d(), endpointPair.e());
        }
        return mutableGraph;
    }

    public static <N, E> MutableNetwork<N, E> g(Network<N, E> network) {
        MutableNetwork<N, E> mutableNetwork = (MutableNetwork<N, E>) j.i(network).h(network.f().size()).g(network.i().size()).c();
        Iterator<N> it = network.f().iterator();
        while (it.hasNext()) {
            mutableNetwork.r(it.next());
        }
        for (E e : network.i()) {
            EndpointPair<N> endpointPairW = network.w(e);
            mutableNetwork.K(endpointPairW.d(), endpointPairW.e(), e);
        }
        return mutableNetwork;
    }

    public static <N, V> MutableValueGraph<N, V> h(ValueGraph<N, V> valueGraph) {
        MutableValueGraph<N, V> mutableValueGraph = (MutableValueGraph<N, V>) s.g(valueGraph).f(valueGraph.f().size()).b();
        Iterator<N> it = valueGraph.f().iterator();
        while (it.hasNext()) {
            mutableValueGraph.r(it.next());
        }
        for (EndpointPair<N> endpointPair : valueGraph.i()) {
            N nD = endpointPair.d();
            N nE = endpointPair.e();
            V vC = valueGraph.C(endpointPair.d(), endpointPair.e(), null);
            Objects.requireNonNull(vC);
            mutableValueGraph.I(nD, nE, vC);
        }
        return mutableValueGraph;
    }

    public static <N> boolean i(Graph<N> graph) {
        int size = graph.i().size();
        if (size == 0) {
            return false;
        }
        if (!graph.j() && size >= graph.f().size()) {
            return true;
        }
        HashMap mapA0 = Maps.a0(graph.f().size());
        Iterator<N> it = graph.f().iterator();
        while (it.hasNext()) {
            if (o(graph, mapA0, it.next(), null)) {
                return true;
            }
        }
        return false;
    }

    public static boolean j(Network<?, ?> network) {
        if (network.j() || !network.L() || network.i().size() <= network.t().i().size()) {
            return i(network.t());
        }
        return true;
    }

    public static <N> MutableGraph<N> k(Graph<N> graph, Iterable<? extends N> iterable) {
        k kVar = iterable instanceof Collection ? (MutableGraph<N>) d.g(graph).f(((Collection) iterable).size()).b() : (MutableGraph<N>) d.g(graph).b();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            kVar.r(it.next());
        }
        for (N n : kVar.f()) {
            for (N n2 : graph.b(n)) {
                if (kVar.f().contains(n2)) {
                    kVar.O(n, n2);
                }
            }
        }
        return kVar;
    }

    public static <N, E> MutableNetwork<N, E> l(Network<N, E> network, Iterable<? extends N> iterable) {
        l lVar = iterable instanceof Collection ? (MutableNetwork<N, E>) j.i(network).h(((Collection) iterable).size()).c() : (MutableNetwork<N, E>) j.i(network).c();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            lVar.r(it.next());
        }
        for (E e : lVar.f()) {
            for (E e2 : network.B(e)) {
                N nA = network.w(e2).a(e);
                if (lVar.f().contains(nA)) {
                    lVar.K(e, nA, e2);
                }
            }
        }
        return lVar;
    }

    public static <N, V> MutableValueGraph<N, V> m(ValueGraph<N, V> valueGraph, Iterable<? extends N> iterable) {
        m mVar = iterable instanceof Collection ? (MutableValueGraph<N, V>) s.g(valueGraph).f(((Collection) iterable).size()).b() : (MutableValueGraph<N, V>) s.g(valueGraph).b();
        Iterator<? extends N> it = iterable.iterator();
        while (it.hasNext()) {
            mVar.r(it.next());
        }
        for (N n : mVar.f()) {
            for (N n2 : valueGraph.b(n)) {
                if (mVar.f().contains(n2)) {
                    V vC = valueGraph.C(n, n2, null);
                    Objects.requireNonNull(vC);
                    mVar.I(n, n2, vC);
                }
            }
        }
        return mVar;
    }

    public static <N> Set<N> n(Graph<N> graph, N n) {
        com.google.common.base.i.u(graph.f().contains(n), GraphConstants.f6271a, n);
        return ImmutableSet.copyOf(Traverser.g(graph).b(n));
    }

    public static <N> boolean o(Graph<N> graph, Map<Object, NodeVisitState> map, N n, @CheckForNull N n2) {
        NodeVisitState nodeVisitState = map.get(n);
        if (nodeVisitState == NodeVisitState.COMPLETE) {
            return false;
        }
        NodeVisitState nodeVisitState2 = NodeVisitState.PENDING;
        if (nodeVisitState == nodeVisitState2) {
            return true;
        }
        map.put(n, nodeVisitState2);
        for (N n3 : graph.b(n)) {
            if (a(graph, n3, n2) && o(graph, map, n3, n)) {
                return true;
            }
        }
        map.put(n, NodeVisitState.COMPLETE);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Graph<N> p(Graph<N> graph) {
        k kVarB = d.g(graph).a(true).b();
        if (graph.j()) {
            for (N n : graph.f()) {
                Iterator it = n(graph, n).iterator();
                while (it.hasNext()) {
                    kVarB.O(n, it.next());
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N n2 : graph.f()) {
                if (!hashSet.contains(n2)) {
                    Set setN = n(graph, n2);
                    hashSet.addAll(setN);
                    int i = 1;
                    for (Object obj : setN) {
                        int i2 = i + 1;
                        Iterator it2 = com.google.common.collect.o.D(setN, i).iterator();
                        while (it2.hasNext()) {
                            kVarB.O(obj, it2.next());
                        }
                        i = i2;
                    }
                }
            }
        }
        return kVarB;
    }

    public static <N> EndpointPair<N> q(EndpointPair<N> endpointPair) {
        return endpointPair.b() ? EndpointPair.h(endpointPair.j(), endpointPair.i()) : endpointPair;
    }

    public static <N> Graph<N> r(Graph<N> graph) {
        if (graph.j()) {
            return graph instanceof a ? ((a) graph).f32076a : new a(graph);
        }
        return graph;
    }

    public static <N, E> Network<N, E> s(Network<N, E> network) {
        if (network.j()) {
            return network instanceof b ? ((b) network).f32079a : new b(network);
        }
        return network;
    }

    public static <N, V> ValueGraph<N, V> t(ValueGraph<N, V> valueGraph) {
        if (valueGraph.j()) {
            return valueGraph instanceof c ? ((c) valueGraph).f32080a : new c(valueGraph);
        }
        return valueGraph;
    }
}
