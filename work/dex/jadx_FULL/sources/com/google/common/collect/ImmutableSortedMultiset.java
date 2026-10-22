package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {

    @CheckForNull
    @LazyInit
    transient ImmutableSortedMultiset<E> descendingMultiset;

    public static final class SerializedForm<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        public SerializedForm(SortedMultiset<E> sortedMultiset) {
            this.comparator = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i = 0;
            for (Multiset.Entry<E> entry : sortedMultiset.entrySet()) {
                this.elements[i] = entry.getElement();
                this.counts[i] = entry.getCount();
                i++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            a aVar = new a(this.comparator);
            for (int i = 0; i < length; i++) {
                aVar.k(this.elements[i], this.counts[i]);
            }
            return aVar.e();
        }
    }

    public static class a<E> extends ImmutableMultiset.b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparator<? super E> f31741a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int[] f6073a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @VisibleForTesting
        public E[] f6074a;
        public int b;
        public boolean c;

        public a(Comparator<? super E> comparator) {
            super(true);
            this.f31741a = (Comparator) com.google.common.base.i.E(comparator);
            this.f6074a = (E[]) new Object[4];
            this.f6073a = new int[4];
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public a<E> g(E e) {
            return k(e, 1);
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a<E> b(E... eArr) {
            for (E e : eArr) {
                g(e);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a<E> c(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                for (Multiset.Entry<E> entry : ((Multiset) iterable).entrySet()) {
                    k(entry.getElement(), entry.getCount());
                }
            } else {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    g(it.next());
                }
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a<E> d(Iterator<? extends E> it) {
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public a<E> k(E e, int i) {
            com.google.common.base.i.E(e);
            com.google.common.collect.a.b(i, "occurrences");
            if (i == 0) {
                return this;
            }
            w();
            E[] eArr = this.f6074a;
            int i2 = this.b;
            eArr[i2] = e;
            this.f6073a[i2] = i;
            this.b = i2 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMultiset<E> e() {
            v();
            int i = this.b;
            if (i == 0) {
                return ImmutableSortedMultiset.emptyMultiset(this.f31741a);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.construct(this.f31741a, i, this.f6074a);
            long[] jArr = new long[this.b + 1];
            int i2 = 0;
            while (i2 < this.b) {
                int i3 = i2 + 1;
                jArr[i3] = jArr[i2] + ((long) this.f6073a[i2]);
                i2 = i3;
            }
            this.c = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.b);
        }

        public final void u(boolean z) {
            int i = this.b;
            if (i == 0) {
                return;
            }
            Object[] objArr = (E[]) Arrays.copyOf(this.f6074a, i);
            Arrays.sort(objArr, this.f31741a);
            int i2 = 1;
            for (int i3 = 1; i3 < objArr.length; i3++) {
                if (this.f31741a.compare((Object) objArr[i2 - 1], (Object) objArr[i3]) < 0) {
                    objArr[i2] = objArr[i3];
                    i2++;
                }
            }
            Arrays.fill(objArr, i2, this.b, (Object) null);
            if (z) {
                int i4 = i2 * 4;
                int i5 = this.b;
                if (i4 > i5 * 3) {
                    objArr = (E[]) Arrays.copyOf(objArr, com.google.common.math.e.t(i5, (i5 / 2) + 1));
                }
            }
            int[] iArr = new int[objArr.length];
            for (int i6 = 0; i6 < this.b; i6++) {
                int iBinarySearch = Arrays.binarySearch(objArr, 0, i2, this.f6074a[i6], this.f31741a);
                int i7 = this.f6073a[i6];
                if (i7 >= 0) {
                    iArr[iBinarySearch] = iArr[iBinarySearch] + i7;
                } else {
                    iArr[iBinarySearch] = ~i7;
                }
            }
            this.f6074a = (E[]) objArr;
            this.f6073a = iArr;
            this.b = i2;
        }

        public final void v() {
            u(false);
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = this.b;
                if (i >= i3) {
                    Arrays.fill(this.f6074a, i2, i3, (Object) null);
                    Arrays.fill(this.f6073a, i2, this.b, 0);
                    this.b = i2;
                    return;
                }
                int[] iArr = this.f6073a;
                int i4 = iArr[i];
                if (i4 > 0) {
                    E[] eArr = this.f6074a;
                    eArr[i2] = eArr[i];
                    iArr[i2] = i4;
                    i2++;
                }
                i++;
            }
        }

        public final void w() {
            int i = this.b;
            E[] eArr = this.f6074a;
            if (i == eArr.length) {
                u(true);
            } else if (this.c) {
                this.f6074a = (E[]) Arrays.copyOf(eArr, eArr.length);
            }
            this.c = false;
        }

        @Override // com.google.common.collect.ImmutableMultiset.b
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public a<E> m(E e, int i) {
            com.google.common.base.i.E(e);
            com.google.common.collect.a.b(i, "count");
            w();
            E[] eArr = this.f6074a;
            int i2 = this.b;
            eArr[i2] = e;
            this.f6073a[i2] = ~i;
            this.b = i2 + 1;
            return this;
        }
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(Ordering.natural(), Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        return copyOfSortedEntries(sortedMultiset.comparator(), Lists.r(sortedMultiset.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> copyOfSortedEntries(Comparator<? super E> comparator, Collection<Multiset.Entry<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.a aVar = new ImmutableList.a(collection.size());
        long[] jArr = new long[collection.size() + 1];
        int i = 0;
        for (Multiset.Entry<E> entry : collection) {
            aVar.a(entry.getElement());
            int i2 = i + 1;
            jArr[i2] = jArr[i] + ((long) entry.getCount());
            i = i2;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(aVar.e(), comparator), jArr, 0, collection.size());
    }

    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        return Ordering.natural().equals(comparator) ? (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET : new RegularImmutableSortedMultiset(comparator);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(Ordering.natural());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) RegularImmutableSortedMultiset.NATURAL_EMPTY_MULTISET;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(Ordering.natural().reverse());
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType);

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType);

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(comparable), new long[]{0, 1}, 0, 1);
    }

    @Override // com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultisetEmptyMultiset = this.descendingMultiset;
        if (immutableSortedMultisetEmptyMultiset == null) {
            immutableSortedMultisetEmptyMultiset = isEmpty() ? emptyMultiset(Ordering.from(comparator()).reverse()) : new DescendingImmutableSortedMultiset<>(this);
            this.descendingMultiset = immutableSortedMultisetEmptyMultiset;
        }
        return immutableSortedMultisetEmptyMultiset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        com.google.common.base.i.y(comparator().compare(e, e2) <= 0, "Expected lowerBound <= upperBound but %s > %s", e, e2);
        return tailMultiset((Object) e, boundType).headMultiset((Object) e2, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        com.google.common.base.i.E(comparator);
        return new a(comparator).d(it).e();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.isPartialView() ? copyOfSortedEntries(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        return new a(comparator).c(iterable).e();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList arrayListU = Lists.u(comparableArr.length + 6);
        Collections.addAll(arrayListU, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(arrayListU, comparableArr);
        return copyOf(Ordering.natural(), arrayListU);
    }
}
