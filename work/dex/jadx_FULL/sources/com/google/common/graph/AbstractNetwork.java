package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public abstract class AbstractNetwork<N, E> implements Network<N, E> {

    public class a extends AbstractGraph<N> {

        /* JADX INFO: renamed from: com.google.common.graph.AbstractNetwork$a$a, reason: collision with other inner class name */
        public class C0742a extends AbstractSet<EndpointPair<N>> {

            /* JADX INFO: renamed from: com.google.common.graph.AbstractNetwork$a$a$a, reason: collision with other inner class name */
            public class C0743a implements Function<E, EndpointPair<N>> {
                public C0743a() {
                }

                @Override // com.google.common.base.Function
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public EndpointPair<N> apply(E e) {
                    return AbstractNetwork.this.w(e);
                }
            }

            public C0742a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                return a.this.isOrderingCompatible(endpointPair) && a.this.f().contains(endpointPair.d()) && a.this.b(endpointPair.d()).contains(endpointPair.e());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<EndpointPair<N>> iterator() {
                return Iterators.c0(AbstractNetwork.this.i().iterator(), new C0743a());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractNetwork.this.i().size();
            }
        }

        public a() {
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> f() {
            return AbstractNetwork.this.f();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean g() {
            return AbstractNetwork.this.g();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: h */
        public Set<N> b(N n) {
            return AbstractNetwork.this.b(n);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> i() {
            return AbstractNetwork.this.L() ? super.i() : new C0742a();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean j() {
            return AbstractNetwork.this.j();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction, com.google.common.graph.Graph
        /* JADX INFO: renamed from: m */
        public Set<N> a(N n) {
            return AbstractNetwork.this.a(n);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public ElementOrder<N> n() {
            return AbstractNetwork.this.n();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> o(N n) {
            return AbstractNetwork.this.o(n);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public ElementOrder<N> s() {
            return ElementOrder.i();
        }
    }

    public class b implements Predicate<E> {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f6261a;
        public final /* synthetic */ Object b;

        public b(Object obj, Object obj2) {
            this.f6261a = obj;
            this.b = obj2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Predicate
        public boolean apply(E e) {
            return AbstractNetwork.this.w(e).a(this.f6261a).equals(this.b);
        }
    }

    public class c implements Function<E, EndpointPair<N>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Network f32050a;

        public c(Network network) {
            this.f32050a = network;
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public EndpointPair<N> apply(E e) {
            return this.f32050a.w(e);
        }
    }

    public static <N, E> Map<E, EndpointPair<N>> S(Network<N, E> network) {
        return Maps.j(network.i(), new c(network));
    }

    @Override // com.google.common.graph.Network
    @CheckForNull
    public E P(N n, N n2) {
        Set<E> setX = x(n, n2);
        int size = setX.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return setX.iterator().next();
        }
        throw new IllegalArgumentException(String.format(GraphConstants.f6274d, n, n2));
    }

    @Override // com.google.common.graph.Network
    public Set<E> Q(E e) {
        EndpointPair<N> endpointPairW = w(e);
        return Sets.f(Sets.N(c(endpointPairW.d()), c(endpointPairW.e())), ImmutableSet.of((Object) e));
    }

    public final Predicate<E> R(N n, N n2) {
        return new b(n, n2);
    }

    @Override // com.google.common.graph.Network
    public int d(N n) {
        return j() ? B(n).size() : e(n);
    }

    @Override // com.google.common.graph.Network
    public int e(N n) {
        return j() ? com.google.common.math.e.t(M(n).size(), B(n).size()) : com.google.common.math.e.t(c(n).size(), x(n, n).size());
    }

    @Override // com.google.common.graph.Network
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        return j() == network.j() && f().equals(network.f()) && S(this).equals(S(network));
    }

    @Override // com.google.common.graph.Network
    public final int hashCode() {
        return S(this).hashCode();
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.b() || !j();
    }

    @Override // com.google.common.graph.Network
    public boolean k(N n, N n2) {
        com.google.common.base.i.E(n);
        com.google.common.base.i.E(n2);
        return f().contains(n) && b(n).contains(n2);
    }

    @Override // com.google.common.graph.Network
    public boolean l(EndpointPair<N> endpointPair) {
        com.google.common.base.i.E(endpointPair);
        if (isOrderingCompatible(endpointPair)) {
            return k(endpointPair.d(), endpointPair.e());
        }
        return false;
    }

    @Override // com.google.common.graph.Network
    public int p(N n) {
        return j() ? M(n).size() : e(n);
    }

    @Override // com.google.common.graph.Network
    public Graph<N> t() {
        return new a();
    }

    public String toString() {
        boolean zJ = j();
        boolean zL = L();
        boolean zG = g();
        String strValueOf = String.valueOf(f());
        String strValueOf2 = String.valueOf(S(this));
        StringBuilder sb = new StringBuilder(strValueOf.length() + 87 + strValueOf2.length());
        sb.append("isDirected: ");
        sb.append(zJ);
        sb.append(", allowsParallelEdges: ");
        sb.append(zL);
        sb.append(", allowsSelfLoops: ");
        sb.append(zG);
        sb.append(", nodes: ");
        sb.append(strValueOf);
        sb.append(", edges: ");
        sb.append(strValueOf2);
        return sb.toString();
    }

    @Override // com.google.common.graph.Network
    @CheckForNull
    public E u(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return P(endpointPair.d(), endpointPair.e());
    }

    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        com.google.common.base.i.E(endpointPair);
        com.google.common.base.i.e(isOrderingCompatible(endpointPair), GraphConstants.i);
    }

    @Override // com.google.common.graph.Network
    public Set<E> x(N n, N n2) {
        Set<E> setB = B(n);
        Set<E> setM = M(n2);
        return setB.size() <= setM.size() ? Collections.unmodifiableSet(Sets.i(setB, R(n, n2))) : Collections.unmodifiableSet(Sets.i(setM, R(n2, n)));
    }

    @Override // com.google.common.graph.Network
    public Set<E> z(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return x(endpointPair.d(), endpointPair.e());
    }
}
