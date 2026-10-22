package com.google.common.collect;

import com.aliyun.vod.common.utils.FileUtils;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class b {

    public static class a<E> extends AbstractCollection<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Predicate<? super E> f31964a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Collection<E> f6197a;

        public a(Collection<E> collection, Predicate<? super E> predicate) {
            this.f6197a = collection;
            this.f31964a = predicate;
        }

        public a<E> a(Predicate<? super E> predicate) {
            return new a<>(this.f6197a, Predicates.d(this.f31964a, predicate));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(@ParametricNullness E e) {
            com.google.common.base.i.d(this.f31964a.apply(e));
            return this.f6197a.add(e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                com.google.common.base.i.d(this.f31964a.apply(it.next()));
            }
            return this.f6197a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            o.J(this.f6197a, this.f31964a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (b.j(this.f6197a, obj)) {
                return this.f31964a.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return b.b(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !o.c(this.f6197a, this.f31964a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.x(this.f6197a.iterator(), this.f31964a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            return contains(obj) && this.f6197a.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it = this.f6197a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f31964a.apply(next) && collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it = this.f6197a.iterator();
            boolean z = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f31964a.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> it = this.f6197a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.f31964a.apply(it.next())) {
                    i++;
                }
            }
            return i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.s(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Lists.s(iterator()).toArray(tArr);
        }
    }

    /* JADX INFO: renamed from: com.google.common.collect.b$b, reason: collision with other inner class name */
    public static final class C0736b<E> extends AbstractCollection<List<E>> {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableList<E> f31965a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Comparator<? super E> f6198a;

        public C0736b(Iterable<E> iterable, Comparator<? super E> comparator) {
            ImmutableList<E> immutableListSortedCopyOf = ImmutableList.sortedCopyOf(comparator, iterable);
            this.f31965a = immutableListSortedCopyOf;
            this.f6198a = comparator;
            this.K = a(immutableListSortedCopyOf, comparator);
        }

        public static <E> int a(List<E> list, Comparator<? super E> comparator) {
            int i = 1;
            int iU = 1;
            int i2 = 1;
            while (i < list.size()) {
                if (comparator.compare(list.get(i - 1), list.get(i)) < 0) {
                    iU = com.google.common.math.e.u(iU, com.google.common.math.e.a(i, i2));
                    if (iU == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    i2 = 0;
                }
                i++;
                i2++;
            }
            return com.google.common.math.e.u(iU, com.google.common.math.e.a(i, i2));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return b.e(this.f31965a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new c(this.f31965a, this.f6198a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.K;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String strValueOf = String.valueOf(this.f31965a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 30);
            sb.append("orderedPermutationCollection(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class c<E> extends AbstractIterator<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparator<? super E> f31966a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public List<E> f6199a;

        public c(List<E> list, Comparator<? super E> comparator) {
            this.f6199a = Lists.r(list);
            this.f31966a = comparator;
        }

        public void b() {
            int iC = c();
            if (iC == -1) {
                this.f6199a = null;
                return;
            }
            Objects.requireNonNull(this.f6199a);
            Collections.swap(this.f6199a, iC, d(iC));
            Collections.reverse(this.f6199a.subList(iC + 1, this.f6199a.size()));
        }

        public int c() {
            Objects.requireNonNull(this.f6199a);
            for (int size = this.f6199a.size() - 2; size >= 0; size--) {
                if (this.f31966a.compare(this.f6199a.get(size), this.f6199a.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        public int d(int i) {
            Objects.requireNonNull(this.f6199a);
            E e = this.f6199a.get(i);
            for (int size = this.f6199a.size() - 1; size > i; size--) {
                if (this.f31966a.compare(e, this.f6199a.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public List<E> computeNext() {
            List<E> list = this.f6199a;
            if (list == null) {
                return endOfData();
            }
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) list);
            b();
            return immutableListCopyOf;
        }
    }

    public static final class d<E> extends AbstractCollection<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableList<E> f31967a;

        public d(ImmutableList<E> immutableList) {
            this.f31967a = immutableList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return b.e(this.f31967a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new e(this.f31967a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return com.google.common.math.e.h(this.f31967a.size());
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String strValueOf = String.valueOf(this.f31967a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 14);
            sb.append("permutations(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static class e<E> extends AbstractIterator<List<E>> {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<E> f31968a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f6200a;
        public final int[] b;

        public e(List<E> list) {
            this.f31968a = new ArrayList(list);
            int size = list.size();
            int[] iArr = new int[size];
            this.f6200a = iArr;
            int[] iArr2 = new int[size];
            this.b = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 1);
            this.K = Integer.MAX_VALUE;
        }

        public void b() {
            int size = this.f31968a.size() - 1;
            this.K = size;
            if (size == -1) {
                return;
            }
            int i = 0;
            while (true) {
                int[] iArr = this.f6200a;
                int i2 = this.K;
                int i3 = iArr[i2];
                int i4 = this.b[i2] + i3;
                if (i4 < 0) {
                    c();
                } else if (i4 != i2 + 1) {
                    Collections.swap(this.f31968a, (i2 - i3) + i, (i2 - i4) + i);
                    this.f6200a[this.K] = i4;
                    return;
                } else {
                    if (i2 == 0) {
                        return;
                    }
                    i++;
                    c();
                }
            }
        }

        public void c() {
            int[] iArr = this.b;
            int i = this.K;
            iArr[i] = -iArr[i];
            this.K = i - 1;
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public List<E> computeNext() {
            if (this.K <= 0) {
                return endOfData();
            }
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.f31968a);
            b();
            return immutableListCopyOf;
        }
    }

    public static class f<F, T> extends AbstractCollection<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Function<? super F, ? extends T> f31969a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Collection<F> f6201a;

        public f(Collection<F> collection, Function<? super F, ? extends T> function) {
            this.f6201a = (Collection) com.google.common.base.i.E(collection);
            this.f31969a = (Function) com.google.common.base.i.E(function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f6201a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f6201a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.c0(this.f6201a.iterator(), this.f31969a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f6201a.size();
        }
    }

    public static boolean b(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <E> s<E> c(Collection<E> collection) {
        s<E> sVar = new s<>();
        for (E e2 : collection) {
            sVar.v(e2, sVar.g(e2) + 1);
        }
        return sVar;
    }

    public static <E> Collection<E> d(Collection<E> collection, Predicate<? super E> predicate) {
        return collection instanceof a ? ((a) collection).a(predicate) : new a((Collection) com.google.common.base.i.E(collection), (Predicate) com.google.common.base.i.E(predicate));
    }

    public static boolean e(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        s sVarC = c(list);
        s sVarC2 = c(list2);
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (sVarC.l(i) != sVarC2.g(sVarC.j(i))) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder f(int i) {
        com.google.common.collect.a.b(i, "size");
        return new StringBuilder((int) Math.min(((long) i) * 8, FileUtils.ONE_GB));
    }

    @Beta
    public static <E extends Comparable<? super E>> Collection<List<E>> g(Iterable<E> iterable) {
        return h(iterable, Ordering.natural());
    }

    @Beta
    public static <E> Collection<List<E>> h(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new C0736b(iterable, comparator);
    }

    @Beta
    public static <E> Collection<List<E>> i(Collection<E> collection) {
        return new d(ImmutableList.copyOf((Collection) collection));
    }

    public static boolean j(Collection<?> collection, @CheckForNull Object obj) {
        com.google.common.base.i.E(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean k(Collection<?> collection, @CheckForNull Object obj) {
        com.google.common.base.i.E(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static String l(Collection<?> collection) {
        StringBuilder sbF = f(collection.size());
        sbF.append('[');
        boolean z = true;
        for (Object obj : collection) {
            if (!z) {
                sbF.append(", ");
            }
            if (obj == collection) {
                sbF.append("(this Collection)");
            } else {
                sbF.append(obj);
            }
            z = false;
        }
        sbF.append(']');
        return sbF.toString();
    }

    public static <F, T> Collection<T> m(Collection<F> collection, Function<? super F, T> function) {
        return new f(collection, function);
    }
}
