package com.zj.adlib;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class x68 {
    public static <E> CopyOnWriteArraySet<E> a() {
        return new CopyOnWriteArraySet<>();
    }

    public static <E> HashSet<E> b() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> c(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? new HashSet<>((Collection) iterable) : d(iterable.iterator());
    }

    public static <E> HashSet<E> d(Iterator<? extends E> it) {
        HashSet<E> hashSetB = b();
        while (it.hasNext()) {
            hashSetB.add(it.next());
        }
        return hashSetB;
    }

    public static <E> HashSet<E> e(E... eArr) {
        HashSet<E> hashSetF = f(eArr.length);
        Collections.addAll(hashSetF, eArr);
        return hashSetF;
    }

    public static <E> HashSet<E> f(int i) {
        return new HashSet<>(i);
    }

    public static <E> Set<E> g() {
        return i(new IdentityHashMap());
    }

    public static <E> LinkedHashSet<E> h() {
        return new LinkedHashSet<>();
    }

    public static <E> Set<E> i(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }
}
