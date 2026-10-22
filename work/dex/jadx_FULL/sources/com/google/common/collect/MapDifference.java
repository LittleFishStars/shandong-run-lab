package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@DoNotMock("Use Maps.difference")
@ElementTypesAreNonnullByDefault
public interface MapDifference<K, V> {

    @DoNotMock("Use Maps.difference")
    public interface ValueDifference<V> {
        @ParametricNullness
        V a();

        @ParametricNullness
        V b();

        boolean equals(@CheckForNull Object obj);

        int hashCode();
    }

    Map<K, ValueDifference<V>> a();

    Map<K, V> b();

    Map<K, V> c();

    Map<K, V> d();

    boolean equals(@CheckForNull Object obj);

    int hashCode();

    boolean i();
}
