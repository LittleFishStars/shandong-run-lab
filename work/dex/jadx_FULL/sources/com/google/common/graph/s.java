package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public final class s<N, V> extends AbstractGraphBuilder<N> {
    public s(boolean z) {
        super(z);
    }

    public static s<Object, Object> e() {
        return new s<>(true);
    }

    public static <N, V> s<N, V> g(ValueGraph<N, V> valueGraph) {
        return new s(valueGraph.j()).a(valueGraph.g()).j(valueGraph.n()).i(valueGraph.s());
    }

    public static s<Object, Object> k() {
        return new s<>(false);
    }

    public s<N, V> a(boolean z) {
        ((AbstractGraphBuilder) this).f6260b = z;
        return this;
    }

    public <N1 extends N, V1 extends V> MutableValueGraph<N1, V1> b() {
        return new m(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N, V1 extends V> s<N1, V1> c() {
        return this;
    }

    public s<N, V> d() {
        s<N, V> sVar = new s<>(((AbstractGraphBuilder) this).f6259a);
        ((AbstractGraphBuilder) sVar).f6260b = ((AbstractGraphBuilder) this).f6260b;
        ((AbstractGraphBuilder) sVar).f6258a = ((AbstractGraphBuilder) this).f6258a;
        ((AbstractGraphBuilder) sVar).f32045a = ((AbstractGraphBuilder) this).f32045a;
        ((AbstractGraphBuilder) sVar).b = ((AbstractGraphBuilder) this).b;
        return sVar;
    }

    public s<N, V> f(int i) {
        ((AbstractGraphBuilder) this).f32045a = Optional.of(Integer.valueOf(Graphs.b(i)));
        return this;
    }

    public <N1 extends N, V1 extends V> g.b<N1, V1> h() {
        return new g.b<>(c());
    }

    public <N1 extends N> s<N1, V> i(ElementOrder<N1> elementOrder) {
        com.google.common.base.i.u(elementOrder.h() == ElementOrder.Type.UNORDERED || elementOrder.h() == ElementOrder.Type.STABLE, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", elementOrder);
        s<N1, V> sVar = (s<N1, V>) c();
        ((AbstractGraphBuilder) sVar).b = (ElementOrder) com.google.common.base.i.E(elementOrder);
        return sVar;
    }

    public <N1 extends N> s<N1, V> j(ElementOrder<N1> elementOrder) {
        s<N1, V> sVar = (s<N1, V>) c();
        ((AbstractGraphBuilder) sVar).f6258a = (ElementOrder) com.google.common.base.i.E(elementOrder);
        return sVar;
    }
}
