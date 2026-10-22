package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class u {
    public static void a() {
    }

    public static <T> T[] b(Object[] objArr, int i, int i2, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i, i2, tArr.getClass());
    }

    public static <T> T[] c(T[] tArr, int i) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
    }

    public static <K, V> Map<K, V> d(int i) {
        return CompactHashMap.createWithExpectedSize(i);
    }

    public static <E> Set<E> e(int i) {
        return CompactHashSet.createWithExpectedSize(i);
    }

    public static <K, V> Map<K, V> f(int i) {
        return CompactLinkedHashMap.createWithExpectedSize(i);
    }

    public static <E> Set<E> g(int i) {
        return CompactLinkedHashSet.createWithExpectedSize(i);
    }

    public static <E> Set<E> h() {
        return CompactHashSet.create();
    }

    public static <K, V> Map<K, V> i() {
        return CompactHashMap.create();
    }

    public static int j(int i) {
        return i;
    }

    public static int k(int i) {
        return i;
    }

    public static MapMaker l(MapMaker mapMaker) {
        return mapMaker.l();
    }
}
