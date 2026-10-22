package com.facebook.imagepipeline.cache;

import com.android.internal.util.Predicate;
import com.zj.adlib.rm1;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface MemoryCache<K, V> {
    @Nullable
    rm1<V> b(K k);

    int c(Predicate<K> predicate);

    @Nullable
    rm1<V> e(K k, rm1<V> rm1Var);

    boolean f(Predicate<K> predicate);
}
