package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ImmutableList<List<E>> f31686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final transient int[] f6049a;

    public CartesianList(ImmutableList<List<E>> immutableList) {
        this.f31686a = immutableList;
        int[] iArr = new int[immutableList.size() + 1];
        iArr[immutableList.size()] = 1;
        try {
            for (int size = immutableList.size() - 1; size >= 0; size--) {
                iArr[size] = com.google.common.math.e.d(iArr[size + 1], immutableList.get(size).size());
            }
            this.f6049a = iArr;
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    public static <E> List<List<E>> c(List<? extends List<? extends E>> list) {
        ImmutableList.a aVar = new ImmutableList.a(list.size());
        Iterator<? extends List<? extends E>> it = list.iterator();
        while (it.hasNext()) {
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) it.next());
            if (immutableListCopyOf.isEmpty()) {
                return ImmutableList.of();
            }
            aVar.a(immutableListCopyOf);
        }
        return new CartesianList(aVar.e());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() != this.f31686a.size()) {
            return false;
        }
        Iterator<E> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (!this.f31686a.get(i).contains(it.next())) {
                return false;
            }
            i++;
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ImmutableList<E> get(final int i) {
        com.google.common.base.i.C(i, size());
        return new ImmutableList<E>() { // from class: com.google.common.collect.CartesianList.1
            @Override // java.util.List
            public E get(int i2) {
                com.google.common.base.i.C(i2, size());
                return (E) ((List) CartesianList.this.f31686a.get(i2)).get(CartesianList.this.e(i, i2));
            }

            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return CartesianList.this.f31686a.size();
            }
        };
    }

    public final int e(int i, int i2) {
        return (i / this.f6049a[i2 + 1]) % this.f31686a.get(i2).size();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.f31686a.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            int iNextIndex = listIterator.nextIndex();
            int iIndexOf = this.f31686a.get(iNextIndex).indexOf(listIterator.next());
            if (iIndexOf == -1) {
                return -1;
            }
            i += iIndexOf * this.f6049a[iNextIndex + 1];
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.f31686a.size()) {
            return -1;
        }
        ListIterator<E> listIterator = list.listIterator();
        int i = 0;
        while (listIterator.hasNext()) {
            int iNextIndex = listIterator.nextIndex();
            int iLastIndexOf = this.f31686a.get(iNextIndex).lastIndexOf(listIterator.next());
            if (iLastIndexOf == -1) {
                return -1;
            }
            i += iLastIndexOf * this.f6049a[iNextIndex + 1];
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6049a[0];
    }
}
