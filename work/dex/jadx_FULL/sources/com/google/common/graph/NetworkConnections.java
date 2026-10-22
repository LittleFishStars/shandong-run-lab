package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
interface NetworkConnections<N, E> {
    Set<N> a();

    Set<N> b();

    Set<N> c();

    N d(E e);

    @CanIgnoreReturnValue
    N e(E e);

    Set<E> f();

    void g(E e, N n);

    void h(E e, N n, boolean z);

    Set<E> i();

    @CanIgnoreReturnValue
    @CheckForNull
    N j(E e, boolean z);

    Set<E> k();

    Set<E> l(N n);
}
