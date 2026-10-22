package com.huawei.hms.common.data;

import com.facebook.common.internal.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class FreezableUtils {
    public static <T, E extends Freezable<T>> ArrayList<T> freeze(ArrayList<E> arrayList) {
        return freezeIterable(arrayList);
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeIterable(Iterable<E> iterable) {
        ImmutableList immutableList = (ArrayList<T>) new ArrayList();
        if (iterable == null) {
            return immutableList;
        }
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            immutableList.add(it.next().freeze());
        }
        return immutableList;
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freeze(E[] eArr) {
        return freezeIterable(Arrays.asList(eArr));
    }
}
