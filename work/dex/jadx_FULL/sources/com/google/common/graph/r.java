package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class r<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    public r(Map<E, N> map) {
        super(map);
    }

    public static <N, E> r<N, E> m() {
        return new r<>(HashBiMap.create(2));
    }

    public static <N, E> r<N, E> n(Map<E, N> map) {
        return new r<>(ImmutableBiMap.copyOf((Map) map));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> b() {
        return Collections.unmodifiableSet(((BiMap) this.f32051a).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> l(N n) {
        return new c(((BiMap) this.f32051a).inverse(), n);
    }
}
