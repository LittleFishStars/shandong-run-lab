package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    @CanIgnoreReturnValue
    @CheckForNull
    V D(EndpointPair<N> endpointPair);

    @CanIgnoreReturnValue
    @CheckForNull
    V E(N n, N n2);

    @CanIgnoreReturnValue
    @CheckForNull
    V I(N n, N n2, V v);

    @CanIgnoreReturnValue
    boolean q(N n);

    @CanIgnoreReturnValue
    boolean r(N n);

    @CanIgnoreReturnValue
    @CheckForNull
    V y(EndpointPair<N> endpointPair, V v);
}
