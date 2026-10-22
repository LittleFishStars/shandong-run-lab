package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable(containerOf = {"N"})
@Beta
@ElementTypesAreNonnullByDefault
public abstract class EndpointPair<N> implements Iterable<N> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N f32072a;
    public final N b;

    public static final class b<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean b() {
            return true;
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (b() != endpointPair.b()) {
                return false;
            }
            return i().equals(endpointPair.i()) && j().equals(endpointPair.j());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return com.google.common.base.g.b(i(), j());
        }

        @Override // com.google.common.graph.EndpointPair
        public N i() {
            return d();
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N j() {
            return e();
        }

        public String toString() {
            String strValueOf = String.valueOf(i());
            String strValueOf2 = String.valueOf(j());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 6 + strValueOf2.length());
            sb.append("<");
            sb.append(strValueOf);
            sb.append(" -> ");
            sb.append(strValueOf2);
            sb.append(">");
            return sb.toString();
        }

        public b(N n, N n2) {
            super(n, n2);
        }
    }

    public static final class c<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean b() {
            return false;
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (b() != endpointPair.b()) {
                return false;
            }
            if (d().equals(endpointPair.d())) {
                return e().equals(endpointPair.e());
            }
            return d().equals(endpointPair.e()) && e().equals(endpointPair.d());
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return d().hashCode() + e().hashCode();
        }

        @Override // com.google.common.graph.EndpointPair
        public N i() {
            throw new UnsupportedOperationException(GraphConstants.g);
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N j() {
            throw new UnsupportedOperationException(GraphConstants.g);
        }

        public String toString() {
            String strValueOf = String.valueOf(d());
            String strValueOf2 = String.valueOf(e());
            StringBuilder sb = new StringBuilder(strValueOf.length() + 4 + strValueOf2.length());
            sb.append("[");
            sb.append(strValueOf);
            sb.append(", ");
            sb.append(strValueOf2);
            sb.append("]");
            return sb.toString();
        }

        public c(N n, N n2) {
            super(n, n2);
        }
    }

    public static <N> EndpointPair<N> f(Graph<?> graph, N n, N n2) {
        return graph.j() ? h(n, n2) : m(n, n2);
    }

    public static <N> EndpointPair<N> g(Network<?, ?> network, N n, N n2) {
        return network.j() ? h(n, n2) : m(n, n2);
    }

    public static <N> EndpointPair<N> h(N n, N n2) {
        return new b(n, n2);
    }

    public static <N> EndpointPair<N> m(N n, N n2) {
        return new c(n2, n);
    }

    public final N a(N n) {
        if (n.equals(this.f32072a)) {
            return this.b;
        }
        if (n.equals(this.b)) {
            return this.f32072a;
        }
        String strValueOf = String.valueOf(this);
        String strValueOf2 = String.valueOf(n);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 36 + strValueOf2.length());
        sb.append("EndpointPair ");
        sb.append(strValueOf);
        sb.append(" does not contain node ");
        sb.append(strValueOf2);
        throw new IllegalArgumentException(sb.toString());
    }

    public abstract boolean b();

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.B(this.f32072a, this.b);
    }

    public final N d() {
        return this.f32072a;
    }

    public final N e() {
        return this.b;
    }

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract N i();

    public abstract N j();

    public EndpointPair(N n, N n2) {
        this.f32072a = (N) com.google.common.base.i.E(n);
        this.b = (N) com.google.common.base.i.E(n2);
    }
}
