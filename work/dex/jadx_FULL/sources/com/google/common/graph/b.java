package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class b<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    public b(Map<E, N> map, Map<E, N> map2, int i) {
        super(map, map2, i);
    }

    public static <N, E> b<N, E> n() {
        return new b<>(HashBiMap.create(2), HashBiMap.create(2), 0);
    }

    public static <N, E> b<N, E> o(Map<E, N> map, Map<E, N> map2, int i) {
        return new b<>(ImmutableBiMap.copyOf((Map) map), ImmutableBiMap.copyOf((Map) map2), i);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> a() {
        return Collections.unmodifiableSet(((BiMap) ((AbstractDirectedNetworkConnections) this).f6257a).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> c() {
        return Collections.unmodifiableSet(((BiMap) this.b).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> l(N n) {
        return new c(((BiMap) this.b).inverse(), n);
    }
}
