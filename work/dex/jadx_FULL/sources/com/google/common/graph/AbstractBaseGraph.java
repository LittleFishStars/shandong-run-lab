package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {

    public class a extends AbstractSet<EndpointPair<N>> {
        public a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator<EndpointPair<N>> iterator() {
            return EndpointPairIterator.c(AbstractBaseGraph.this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair<?> endpointPair = (EndpointPair) obj;
            return AbstractBaseGraph.this.isOrderingCompatible(endpointPair) && AbstractBaseGraph.this.f().contains(endpointPair.d()) && AbstractBaseGraph.this.b(endpointPair.d()).contains(endpointPair.e());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Ints.x(AbstractBaseGraph.this.edgeCount());
        }
    }

    public class b extends IncidentEdgeSet<N> {

        public class a implements Function<N, EndpointPair<N>> {
            public a() {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public EndpointPair<N> apply(N n) {
                return EndpointPair.h(n, ((IncidentEdgeSet) b.this).f6275a);
            }
        }

        /* JADX INFO: renamed from: com.google.common.graph.AbstractBaseGraph$b$b, reason: collision with other inner class name */
        public class C0741b implements Function<N, EndpointPair<N>> {
            public C0741b() {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public EndpointPair<N> apply(N n) {
                return EndpointPair.h(((IncidentEdgeSet) b.this).f6275a, n);
            }
        }

        public class c implements Function<N, EndpointPair<N>> {
            public c() {
            }

            @Override // com.google.common.base.Function
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public EndpointPair<N> apply(N n) {
                return EndpointPair.m(((IncidentEdgeSet) b.this).f6275a, n);
            }
        }

        public b(AbstractBaseGraph abstractBaseGraph, BaseGraph baseGraph, Object obj) {
            super(baseGraph, obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public UnmodifiableIterator<EndpointPair<N>> iterator() {
            return ((IncidentEdgeSet) this).f32081a.j() ? Iterators.f0(Iterators.j(Iterators.c0(((IncidentEdgeSet) this).f32081a.a(((IncidentEdgeSet) this).f6275a).iterator(), new a()), Iterators.c0(Sets.f(((IncidentEdgeSet) this).f32081a.b(((IncidentEdgeSet) this).f6275a), ImmutableSet.of(((IncidentEdgeSet) this).f6275a)).iterator(), new C0741b()))) : Iterators.f0(Iterators.c0(((IncidentEdgeSet) this).f32081a.o(((IncidentEdgeSet) this).f6275a).iterator(), new c()));
        }
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> c(N n) {
        com.google.common.base.i.E(n);
        com.google.common.base.i.u(f().contains(n), GraphConstants.f6271a, n);
        return new b(this, this, n);
    }

    @Override // com.google.common.graph.BaseGraph
    public int d(N n) {
        return j() ? b(n).size() : e(n);
    }

    @Override // com.google.common.graph.BaseGraph
    public int e(N n) {
        if (j()) {
            return com.google.common.math.e.t(a(n).size(), b(n).size());
        }
        Set<N> setO = o(n);
        return com.google.common.math.e.t(setO.size(), (g() && setO.contains(n)) ? 1 : 0);
    }

    public long edgeCount() {
        Iterator<N> it = f().iterator();
        long jE = 0;
        while (it.hasNext()) {
            jE += (long) e(it.next());
        }
        com.google.common.base.i.g0((1 & jE) == 0);
        return jE >>> 1;
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> i() {
        return new a();
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.b() || !j();
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean k(N n, N n2) {
        com.google.common.base.i.E(n);
        com.google.common.base.i.E(n2);
        return f().contains(n) && b(n).contains(n2);
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean l(EndpointPair<N> endpointPair) {
        com.google.common.base.i.E(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nD = endpointPair.d();
        return f().contains(nD) && b(nD).contains(endpointPair.e());
    }

    @Override // com.google.common.graph.BaseGraph
    public int p(N n) {
        return j() ? a(n).size() : e(n);
    }

    @Override // com.google.common.graph.BaseGraph
    public ElementOrder<N> s() {
        return ElementOrder.i();
    }

    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        com.google.common.base.i.E(endpointPair);
        com.google.common.base.i.e(isOrderingCompatible(endpointPair), GraphConstants.i);
    }
}
