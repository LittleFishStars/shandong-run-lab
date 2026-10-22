package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public interface MutableNetwork<N, E> extends Network<N, E> {
    @CanIgnoreReturnValue
    boolean H(EndpointPair<N> endpointPair, E e);

    @CanIgnoreReturnValue
    boolean J(E e);

    @CanIgnoreReturnValue
    boolean K(N n, N n2, E e);

    @CanIgnoreReturnValue
    boolean q(N n);

    @CanIgnoreReturnValue
    boolean r(N n);
}
