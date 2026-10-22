package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@DoNotMock
@Beta
@ElementTypesAreNonnullByDefault
public final class d<N> extends AbstractGraphBuilder<N> {
    public d(boolean z) {
        super(z);
    }

    public static d<Object> e() {
        return new d<>(true);
    }

    public static <N> d<N> g(Graph<N> graph) {
        return new d(graph.j()).a(graph.g()).j(graph.n()).i(graph.s());
    }

    public static d<Object> k() {
        return new d<>(false);
    }

    public d<N> a(boolean z) {
        ((AbstractGraphBuilder) this).f6260b = z;
        return this;
    }

    public <N1 extends N> MutableGraph<N1> b() {
        return new k(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N> d<N1> c() {
        return this;
    }

    public d<N> d() {
        d<N> dVar = new d<>(((AbstractGraphBuilder) this).f6259a);
        ((AbstractGraphBuilder) dVar).f6260b = ((AbstractGraphBuilder) this).f6260b;
        ((AbstractGraphBuilder) dVar).f6258a = ((AbstractGraphBuilder) this).f6258a;
        ((AbstractGraphBuilder) dVar).f32045a = ((AbstractGraphBuilder) this).f32045a;
        ((AbstractGraphBuilder) dVar).b = ((AbstractGraphBuilder) this).b;
        return dVar;
    }

    public d<N> f(int i) {
        ((AbstractGraphBuilder) this).f32045a = Optional.of(Integer.valueOf(Graphs.b(i)));
        return this;
    }

    public <N1 extends N> e.a<N1> h() {
        return new e.a<>(c());
    }

    public <N1 extends N> d<N1> i(ElementOrder<N1> elementOrder) {
        com.google.common.base.i.u(elementOrder.h() == ElementOrder.Type.UNORDERED || elementOrder.h() == ElementOrder.Type.STABLE, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", elementOrder);
        d<N1> dVarC = c();
        ((AbstractGraphBuilder) dVarC).b = (ElementOrder) com.google.common.base.i.E(elementOrder);
        return dVarC;
    }

    public <N1 extends N> d<N1> j(ElementOrder<N1> elementOrder) {
        d<N1> dVarC = c();
        ((AbstractGraphBuilder) dVarC).f6258a = (ElementOrder) com.google.common.base.i.E(elementOrder);
        return dVarC;
    }
}
