package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class d {
    public static <T> boolean a(Iterable<? extends T> iterable, Comparator<T> comparator) {
        com.google.common.base.i.E(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T> boolean b(Iterable<? extends T> iterable, Comparator<T> comparator) {
        com.google.common.base.i.E(comparator);
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (comparator.compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T, S extends T> Comparator<Iterable<S>> c(Comparator<T> comparator) {
        return new LexicographicalOrdering((Comparator) com.google.common.base.i.E(comparator));
    }

    @Beta
    public static <T extends Comparable<? super T>> T d(T t, T t2) {
        return t.compareTo(t2) >= 0 ? t : t2;
    }

    @ParametricNullness
    @Beta
    public static <T> T e(@ParametricNullness T t, @ParametricNullness T t2, Comparator<T> comparator) {
        return comparator.compare(t, t2) >= 0 ? t : t2;
    }

    @Beta
    public static <T extends Comparable<? super T>> T f(T t, T t2) {
        return t.compareTo(t2) <= 0 ? t : t2;
    }

    @ParametricNullness
    @Beta
    public static <T> T g(@ParametricNullness T t, @ParametricNullness T t2, Comparator<T> comparator) {
        return comparator.compare(t, t2) <= 0 ? t : t2;
    }
}
