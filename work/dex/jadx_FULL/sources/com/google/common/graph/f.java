package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Immutable(containerOf = {"N", "E"})
@Beta
@ElementTypesAreNonnullByDefault
public final class f<N, E> extends n<N, E> {

    public class a implements Function<E, N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Network f32097a;

        public a(Network network) {
            this.f32097a = network;
        }

        @Override // com.google.common.base.Function
        public N apply(E e) {
            return this.f32097a.w(e).i();
        }
    }

    public class b implements Function<E, N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Network f32098a;

        public b(Network network) {
            this.f32098a = network;
        }

        @Override // com.google.common.base.Function
        public N apply(E e) {
            return this.f32098a.w(e).j();
        }
    }

    public class c implements Function<E, N> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Network f32099a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f6285a;

        public c(Network network, Object obj) {
            this.f32099a = network;
            this.f6285a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Function
        public N apply(E e) {
            return (N) this.f32099a.w(e).a(this.f6285a);
        }
    }

    public static class d<N, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutableNetwork<N, E> f32100a;

        public d(j<N, E> jVar) {
            this.f32100a = (MutableNetwork<N, E>) jVar.c();
        }

        @CanIgnoreReturnValue
        public d<N, E> a(EndpointPair<N> endpointPair, E e) {
            this.f32100a.H(endpointPair, e);
            return this;
        }

        @CanIgnoreReturnValue
        public d<N, E> b(N n, N n2, E e) {
            this.f32100a.K(n, n2, e);
            return this;
        }

        @CanIgnoreReturnValue
        public d<N, E> c(N n) {
            this.f32100a.r(n);
            return this;
        }

        public f<N, E> d() {
            return f.b0(this.f32100a);
        }
    }

    public f(Network<N, E> network) {
        super(j.i(network), d0(network), c0(network));
    }

    public static <N, E> Function<E, N> X(Network<N, E> network, N n) {
        return new c(network, n);
    }

    public static <N, E> NetworkConnections<N, E> Z(Network<N, E> network, N n) {
        if (!network.j()) {
            Map mapJ = Maps.j(network.c(n), X(network, n));
            return network.L() ? q.q(mapJ) : r.n(mapJ);
        }
        Map mapJ2 = Maps.j(network.M(n), e0(network));
        Map mapJ3 = Maps.j(network.B(n), f0(network));
        int size = network.x(n, n).size();
        return network.L() ? com.google.common.graph.a.q(mapJ2, mapJ3, size) : com.google.common.graph.b.o(mapJ2, mapJ3, size);
    }

    @Deprecated
    public static <N, E> f<N, E> a0(f<N, E> fVar) {
        return (f) com.google.common.base.i.E(fVar);
    }

    public static <N, E> f<N, E> b0(Network<N, E> network) {
        return network instanceof f ? (f) network : new f<>(network);
    }

    public static <N, E> Map<E, N> c0(Network<N, E> network) {
        ImmutableMap.b bVarBuilder = ImmutableMap.builder();
        for (E e : network.i()) {
            bVarBuilder.f(e, network.w(e).d());
        }
        return bVarBuilder.a();
    }

    public static <N, E> Map<N, NetworkConnections<N, E>> d0(Network<N, E> network) {
        ImmutableMap.b bVarBuilder = ImmutableMap.builder();
        for (N n : network.f()) {
            bVarBuilder.f(n, Z(network, n));
        }
        return bVarBuilder.a();
    }

    public static <N, E> Function<E, N> e0(Network<N, E> network) {
        return new a(network);
    }

    public static <N, E> Function<E, N> f0(Network<N, E> network) {
        return new b(network);
    }

    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder A() {
        return super.A();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set B(Object obj) {
        return super.B(obj);
    }

    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean L() {
        return super.L();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set M(Object obj) {
        return super.M(obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    /* JADX INFO: renamed from: Y, reason: merged with bridge method [inline-methods] */
    public e<N> t() {
        return new e<>(super.t());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set c(Object obj) {
        return super.c(obj);
    }

    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set f() {
        return super.f();
    }

    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.Network
    /* JADX INFO: renamed from: h */
    public /* bridge */ /* synthetic */ Set b(Object obj) {
        return super.b(obj);
    }

    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set i() {
        return super.i();
    }

    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.Network
    /* JADX INFO: renamed from: m */
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder n() {
        return super.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set o(Object obj) {
        return super.o(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ EndpointPair w(Object obj) {
        return super.w(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.n, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set x(Object obj, Object obj2) {
        return super.x(obj, obj2);
    }
}
