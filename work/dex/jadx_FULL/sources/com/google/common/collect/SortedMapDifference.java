package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.SortedMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface SortedMapDifference<K, V> extends MapDifference<K, V> {
    @Override // 
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    SortedMap<K, V> b();

    @Override // 
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    SortedMap<K, V> c();

    @Override // 
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    SortedMap<K, MapDifference.ValueDifference<V>> a();

    @Override // 
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    SortedMap<K, V> d();
}
