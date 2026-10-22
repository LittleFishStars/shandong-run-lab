package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
interface GraphConnections<N, V> {
    Set<N> a();

    Set<N> b();

    Set<N> c();

    @CheckForNull
    V d(N n);

    Iterator<EndpointPair<N>> e(N n);

    void f(N n);

    @CanIgnoreReturnValue
    @CheckForNull
    V g(N n);

    @CanIgnoreReturnValue
    @CheckForNull
    V h(N n, V v);

    void i(N n, V v);
}
