package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {

    @GwtIncompatible
    private static final long serialVersionUID = 0;
    transient s<E> backingMap;
    transient long size;

    public abstract class Itr<T> implements Iterator<T> {
        public int K;
        public int L = -1;
        public int M;

        public Itr() {
            this.K = AbstractMapBasedMultiset.this.backingMap.f();
            this.M = AbstractMapBasedMultiset.this.backingMap.f6227b;
        }

        public final void a() {
            if (AbstractMapBasedMultiset.this.backingMap.f6227b != this.M) {
                throw new ConcurrentModificationException();
            }
        }

        @ParametricNullness
        public abstract T b(int i);

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.K >= 0;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T tB = b(this.K);
            int i = this.K;
            this.L = i;
            this.K = AbstractMapBasedMultiset.this.backingMap.t(i);
            return tB;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            com.google.common.collect.a.e(this.L != -1);
            AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
            abstractMapBasedMultiset.size -= (long) abstractMapBasedMultiset.backingMap.y(this.L);
            this.K = AbstractMapBasedMultiset.this.backingMap.u(this.K, this.L);
            this.L = -1;
            this.M = AbstractMapBasedMultiset.this.backingMap.f6227b;
        }
    }

    public class a extends AbstractMapBasedMultiset<E>.Itr<E> {
        public a() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
        @ParametricNullness
        public E b(int i) {
            return AbstractMapBasedMultiset.this.backingMap.j(i);
        }
    }

    public class b extends AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>> {
        public b() {
            super();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultiset.Itr
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Multiset.Entry<E> b(int i) {
            return AbstractMapBasedMultiset.this.backingMap.h(i);
        }
    }

    public AbstractMapBasedMultiset(int i) {
        this.backingMap = newBackingMap(i);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        int iH = w.h(objectInputStream);
        this.backingMap = newBackingMap(3);
        w.g(this, objectInputStream, iH);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        w.k(this, objectOutputStream);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int add(@ParametricNullness E e, int i) {
        if (i == 0) {
            return count(e);
        }
        com.google.common.base.i.k(i > 0, "occurrences cannot be negative: %s", i);
        int iN = this.backingMap.n(e);
        if (iN == -1) {
            this.backingMap.v(e, i);
            this.size += (long) i;
            return 0;
        }
        int iL = this.backingMap.l(iN);
        long j = i;
        long j2 = ((long) iL) + j;
        com.google.common.base.i.p(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.backingMap.C(iN, (int) j2);
        this.size += j;
        return iL;
    }

    public void addTo(Multiset<? super E> multiset) {
        com.google.common.base.i.E(multiset);
        int iF = this.backingMap.f();
        while (iF >= 0) {
            multiset.add(this.backingMap.j(iF), this.backingMap.l(iF));
            iF = this.backingMap.t(iF);
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.backingMap.a();
        this.size = 0L;
    }

    @Override // com.google.common.collect.Multiset
    public final int count(@CheckForNull Object obj) {
        return this.backingMap.g(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final int distinctElements() {
        return this.backingMap.D();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator<E> elementIterator() {
        return new a();
    }

    @Override // com.google.common.collect.AbstractMultiset
    public final Iterator<Multiset.Entry<E>> entryIterator() {
        return new b();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public final Iterator<E> iterator() {
        return Multisets.n(this);
    }

    public abstract s<E> newBackingMap(int i);

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int remove(@CheckForNull Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        com.google.common.base.i.k(i > 0, "occurrences cannot be negative: %s", i);
        int iN = this.backingMap.n(obj);
        if (iN == -1) {
            return 0;
        }
        int iL = this.backingMap.l(iN);
        if (iL > i) {
            this.backingMap.C(iN, iL - i);
        } else {
            this.backingMap.y(iN);
            i = iL;
        }
        this.size -= (long) i;
        return iL;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public final int setCount(@ParametricNullness E e, int i) {
        com.google.common.collect.a.b(i, "count");
        s<E> sVar = this.backingMap;
        int iW = i == 0 ? sVar.w(e) : sVar.v(e, i);
        this.size += (long) (i - iW);
        return iW;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public final int size() {
        return Ints.x(this.size);
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public final boolean setCount(@ParametricNullness E e, int i, int i2) {
        com.google.common.collect.a.b(i, "oldCount");
        com.google.common.collect.a.b(i2, "newCount");
        int iN = this.backingMap.n(e);
        if (iN == -1) {
            if (i != 0) {
                return false;
            }
            if (i2 > 0) {
                this.backingMap.v(e, i2);
                this.size += (long) i2;
            }
            return true;
        }
        if (this.backingMap.l(iN) != i) {
            return false;
        }
        if (i2 == 0) {
            this.backingMap.y(iN);
            this.size -= (long) i;
        } else {
            this.backingMap.C(iN, i2);
            this.size += (long) (i2 - i);
        }
        return true;
    }
}
