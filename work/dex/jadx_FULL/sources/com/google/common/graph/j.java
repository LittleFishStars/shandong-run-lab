package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public final class j<N, E> extends AbstractGraphBuilder<N> {
    public Optional<Integer> b;
    public ElementOrder<? super E> c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f6289c;

    public j(boolean z) {
        super(z);
        this.f6289c = false;
        this.c = ElementOrder.d();
        this.b = Optional.absent();
    }

    public static j<Object, Object> e() {
        return new j<>(true);
    }

    public static <N, E> j<N, E> i(Network<N, E> network) {
        return new j(network.j()).a(network.L()).b(network.g()).k(network.n()).f(network.A());
    }

    public static j<Object, Object> l() {
        return new j<>(false);
    }

    public j<N, E> a(boolean z) {
        this.f6289c = z;
        return this;
    }

    public j<N, E> b(boolean z) {
        ((AbstractGraphBuilder) this).f6260b = z;
        return this;
    }

    public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> c() {
        return new l(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <N1 extends N, E1 extends E> j<N1, E1> d() {
        return this;
    }

    public <E1 extends E> j<N, E1> f(ElementOrder<E1> elementOrder) {
        j<N, E1> jVar = (j<N, E1>) d();
        jVar.c = (ElementOrder) com.google.common.base.i.E(elementOrder);
        return jVar;
    }

    public j<N, E> g(int i) {
        this.b = Optional.of(Integer.valueOf(Graphs.b(i)));
        return this;
    }

    public j<N, E> h(int i) {
        ((AbstractGraphBuilder) this).f32045a = Optional.of(Integer.valueOf(Graphs.b(i)));
        return this;
    }

    public <N1 extends N, E1 extends E> f.d<N1, E1> j() {
        return new f.d<>(d());
    }

    public <N1 extends N> j<N1, E> k(ElementOrder<N1> elementOrder) {
        j<N1, E> jVar = (j<N1, E>) d();
        ((AbstractGraphBuilder) jVar).f6258a = (ElementOrder) com.google.common.base.i.E(elementOrder);
        return jVar;
    }
}
