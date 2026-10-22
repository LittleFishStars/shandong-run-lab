package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class p<N, V> implements GraphConnections<N, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<N, V> f32112a;

    public class a implements Function<N, EndpointPair<N>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f32113a;

        public a(p pVar, Object obj) {
            this.f32113a = obj;
        }

        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public EndpointPair<N> apply(N n) {
            return EndpointPair.m(this.f32113a, n);
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f32114a;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            f32114a = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32114a[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public p(Map<N, V> map) {
        this.f32112a = (Map) com.google.common.base.i.E(map);
    }

    public static <N, V> p<N, V> j(ElementOrder<N> elementOrder) {
        int i = b.f32114a[elementOrder.h().ordinal()];
        if (i == 1) {
            return new p<>(new HashMap(2, 1.0f));
        }
        if (i == 2) {
            return new p<>(new LinkedHashMap(2, 1.0f));
        }
        throw new AssertionError(elementOrder.h());
    }

    public static <N, V> p<N, V> k(Map<N, V> map) {
        return new p<>(ImmutableMap.copyOf((Map) map));
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> a() {
        return b();
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> b() {
        return Collections.unmodifiableSet(this.f32112a.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> c() {
        return b();
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V d(N n) {
        return this.f32112a.get(n);
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator<EndpointPair<N>> e(N n) {
        return Iterators.c0(this.f32112a.keySet().iterator(), new a(this, n));
    }

    @Override // com.google.common.graph.GraphConnections
    public void f(N n) {
        g(n);
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V g(N n) {
        return this.f32112a.remove(n);
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V h(N n, V v) {
        return this.f32112a.put(n, v);
    }

    @Override // com.google.common.graph.GraphConnections
    public void i(N n, V v) {
        h(n, v);
    }
}
