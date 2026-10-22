package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public interface MutableGraph<N> extends Graph<N> {
    @CanIgnoreReturnValue
    boolean F(N n, N n2);

    @CanIgnoreReturnValue
    boolean N(EndpointPair<N> endpointPair);

    @CanIgnoreReturnValue
    boolean O(N n, N n2);

    @CanIgnoreReturnValue
    boolean q(N n);

    @CanIgnoreReturnValue
    boolean r(N n);

    @CanIgnoreReturnValue
    boolean v(EndpointPair<N> endpointPair);
}
