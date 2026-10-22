package com.zj.adlib;

import androidx.annotation.NonNull;
import com.facebook.common.internal.ImmutableList;
import com.google.android.gms.common.data.Freezable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class nn3 {
    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> a(@NonNull ArrayList<E> arrayList) {
        ImmutableList immutableList = (ArrayList<T>) new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            immutableList.add(arrayList.get(i).freeze());
        }
        return immutableList;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> b(@NonNull E[] eArr) {
        ImmutableList immutableList = (ArrayList<T>) new ArrayList(eArr.length);
        for (E e : eArr) {
            immutableList.add(e.freeze());
        }
        return immutableList;
    }

    @NonNull
    public static <T, E extends Freezable<T>> ArrayList<T> c(@NonNull Iterable<E> iterable) {
        ImmutableList immutableList = (ArrayList<T>) new ArrayList();
        Iterator<E> it = iterable.iterator();
        while (it.hasNext()) {
            immutableList.add(it.next().freeze());
        }
        return immutableList;
    }
}
