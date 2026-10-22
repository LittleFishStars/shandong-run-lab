package com.google.common.graph;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseGraph<N> f32073a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Iterator<N> f6268a;

    @CheckForNull
    public N b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Iterator<N> f6269b;

    public static final class b<N> extends EndpointPairIterator<N> {
        public b(BaseGraph<N> baseGraph) {
            super(baseGraph);
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public EndpointPair<N> computeNext() {
            while (!((EndpointPairIterator) this).f6269b.hasNext()) {
                if (!b()) {
                    return endOfData();
                }
            }
            N n = ((EndpointPairIterator) this).b;
            Objects.requireNonNull(n);
            return EndpointPair.h(n, ((EndpointPairIterator) this).f6269b.next());
        }
    }

    public static final class c<N> extends EndpointPairIterator<N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public Set<N> f32074a;

        public c(BaseGraph<N> baseGraph) {
            super(baseGraph);
            this.f32074a = Sets.y(baseGraph.f().size() + 1);
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public EndpointPair<N> computeNext() {
            do {
                Objects.requireNonNull(this.f32074a);
                while (((EndpointPairIterator) this).f6269b.hasNext()) {
                    N next = ((EndpointPairIterator) this).f6269b.next();
                    if (!this.f32074a.contains(next)) {
                        N n = ((EndpointPairIterator) this).b;
                        Objects.requireNonNull(n);
                        return EndpointPair.m(n, next);
                    }
                }
                this.f32074a.add(((EndpointPairIterator) this).b);
            } while (b());
            this.f32074a = null;
            return endOfData();
        }
    }

    public static <N> EndpointPairIterator<N> c(BaseGraph<N> baseGraph) {
        return baseGraph.j() ? new b(baseGraph) : new c(baseGraph);
    }

    public final boolean b() {
        com.google.common.base.i.g0(!this.f6269b.hasNext());
        if (!this.f6268a.hasNext()) {
            return false;
        }
        N next = this.f6268a.next();
        this.b = next;
        this.f6269b = this.f32073a.b(next).iterator();
        return true;
    }

    public EndpointPairIterator(BaseGraph<N> baseGraph) {
        this.b = null;
        this.f6269b = ImmutableSet.of().iterator();
        this.f32073a = baseGraph;
        this.f6268a = baseGraph.f().iterator();
    }
}
