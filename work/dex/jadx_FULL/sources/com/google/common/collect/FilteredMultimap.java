package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
interface FilteredMultimap<K, V> extends Multimap<K, V> {
    Multimap<K, V> f();

    Predicate<? super Map.Entry<K, V>> i();
}
