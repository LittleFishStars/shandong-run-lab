package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;

    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableList<E> asList;

    public static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        public Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public static class a<E> extends ImmutableCollection.ArrayBasedBuilder<E> {

        @VisibleForTesting
        @CheckForNull
        public Object[] b;
        public int c;

        public a() {
            super(4);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a<E> g(E e) {
            com.google.common.base.i.E(e);
            if (this.b != null && ImmutableSet.chooseTableSize(super.b) <= this.b.length) {
                n(e);
                return this;
            }
            this.b = null;
            super.g(e);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public a<E> b(E... eArr) {
            if (this.b != null) {
                for (E e : eArr) {
                    g(e);
                }
            } else {
                super.b(eArr);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public a<E> c(Iterable<? extends E> iterable) {
            com.google.common.base.i.E(iterable);
            if (this.b != null) {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    g(it.next());
                }
            } else {
                super.c(iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<E> d(Iterator<? extends E> it) {
            com.google.common.base.i.E(it);
            while (it.hasNext()) {
                g(it.next());
            }
            return this;
        }

        public final void n(E e) {
            Objects.requireNonNull(this.b);
            int length = this.b.length - 1;
            int iHashCode = e.hashCode();
            int iC = m.c(iHashCode);
            while (true) {
                int i = iC & length;
                Object[] objArr = this.b;
                Object obj = objArr[i];
                if (obj == null) {
                    objArr[i] = e;
                    this.c += iHashCode;
                    super.g(e);
                    return;
                } else if (obj.equals(e)) {
                    return;
                } else {
                    iC = i + 1;
                }
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public ImmutableSet<E> e() {
            ImmutableSet<E> immutableSetConstruct;
            int i = super.b;
            if (i == 0) {
                return ImmutableSet.of();
            }
            if (i == 1) {
                Object obj = ((ImmutableCollection.ArrayBasedBuilder) this).f6059a[0];
                Objects.requireNonNull(obj);
                return ImmutableSet.of(obj);
            }
            if (this.b == null || ImmutableSet.chooseTableSize(i) != this.b.length) {
                immutableSetConstruct = ImmutableSet.construct(super.b, ((ImmutableCollection.ArrayBasedBuilder) this).f6059a);
                super.b = immutableSetConstruct.size();
            } else {
                Object[] objArrCopyOf = ImmutableSet.shouldTrim(super.b, ((ImmutableCollection.ArrayBasedBuilder) this).f6059a.length) ? Arrays.copyOf(((ImmutableCollection.ArrayBasedBuilder) this).f6059a, super.b) : ((ImmutableCollection.ArrayBasedBuilder) this).f6059a;
                int i2 = this.c;
                Object[] objArr = this.b;
                immutableSetConstruct = new RegularImmutableSet<>(objArrCopyOf, i2, objArr, objArr.length - 1, super.b);
            }
            ((ImmutableCollection.ArrayBasedBuilder) this).f31721a = true;
            this.b = null;
            return immutableSetConstruct;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CanIgnoreReturnValue
        public a<E> p(a<E> aVar) {
            if (this.b != null) {
                for (int i = 0; i < ((ImmutableCollection.ArrayBasedBuilder) aVar).b; i++) {
                    Object obj = ((ImmutableCollection.ArrayBasedBuilder) aVar).f6059a[i];
                    Objects.requireNonNull(obj);
                    g(obj);
                }
            } else {
                h(((ImmutableCollection.ArrayBasedBuilder) aVar).f6059a, ((ImmutableCollection.ArrayBasedBuilder) aVar).b);
            }
            return this;
        }

        public a(int i) {
            super(i);
            this.b = new Object[ImmutableSet.chooseTableSize(i)];
        }
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    @Beta
    public static <E> a<E> builderWithExpectedSize(int i) {
        com.google.common.collect.a.b(i, "expectedSize");
        return new a<>(i);
    }

    @VisibleForTesting
    static int chooseTableSize(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= CUTOFF) {
            com.google.common.base.i.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * DESIRED_LOAD_FACTOR < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> construct(int i, Object... objArr) {
        if (i == 0) {
            return of();
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return of(obj);
        }
        int iChooseTableSize = chooseTableSize(i);
        Object[] objArr2 = new Object[iChooseTableSize];
        int i2 = iChooseTableSize - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object objA = r.a(objArr[i5], i5);
            int iHashCode = objA.hashCode();
            int iC = m.c(iHashCode);
            while (true) {
                int i6 = iC & i2;
                Object obj2 = objArr2[i6];
                if (obj2 == null) {
                    objArr[i4] = objA;
                    objArr2[i6] = objA;
                    i3 += iHashCode;
                    i4++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iC++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new SingletonImmutableSet(obj3);
        }
        if (chooseTableSize(i4) < iChooseTableSize / 2) {
            return construct(i4, objArr);
        }
        if (shouldTrim(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new RegularImmutableSet(objArr, i3, objArr2, i2, i4);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldTrim(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> immutableListCreateAsList = createAsList();
        this.asList = immutableListCreateAsList;
        return immutableListCreateAsList;
    }

    public ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.g(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.k(this);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e) {
        return new SingletonImmutableSet(e);
    }

    public static <E> ImmutableSet<E> of(E e, E e2) {
        return construct(2, e, e2);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3) {
        return construct(3, e, e2, e3);
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4) {
        return construct(4, e, e2, e3, e4);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5) {
        return construct(5, e, e2, e3, e4, e5);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        com.google.common.base.i.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new a().g(next).d(it).e();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return construct(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
