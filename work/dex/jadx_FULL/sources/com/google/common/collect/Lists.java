package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Lists {

    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        final E first;
        final E[] rest;

        public OnePlusArrayList(@ParametricNullness E e, E[] eArr) {
            this.first = e;
            this.rest = (E[]) ((Object[]) com.google.common.base.i.E(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E get(int i) {
            com.google.common.base.i.C(i, size());
            return i == 0 ? this.first : this.rest[i - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.e.t(this.rest.length, 1);
        }
    }

    public static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        public StringAsImmutableList(String str) {
            this.string = str;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        @Override // java.util.List
        public Character get(int i) {
            com.google.common.base.i.C(i, size());
            return Character.valueOf(this.string.charAt(i));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int i, int i2) {
            com.google.common.base.i.f0(i, i2, size());
            return Lists.g(this.string.substring(i, i2));
        }
    }

    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        public class a extends TransformedListIterator<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.TransformedIterator
            public T a(F f) {
                return TransformingRandomAccessList.this.function.apply(f);
            }
        }

        public TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) com.google.common.base.i.E(list);
            this.function = (Function) com.google.common.base.i.E(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T get(int i) {
            return this.function.apply(this.fromList.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new a(this.fromList.listIterator(i));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            return this.function.apply(this.fromList.remove(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        public class a extends TransformedListIterator<F, T> {
            public a(ListIterator listIterator) {
                super(listIterator);
            }

            @Override // com.google.common.collect.TransformedIterator
            @ParametricNullness
            public T a(@ParametricNullness F f) {
                return TransformingSequentialList.this.function.apply(f);
            }
        }

        public TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) com.google.common.base.i.E(list);
            this.function = (Function) com.google.common.base.i.E(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new a(this.fromList.listIterator(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    public static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        final E first;
        final E[] rest;

        @ParametricNullness
        final E second;

        public TwoPlusArrayList(@ParametricNullness E e, @ParametricNullness E e2, E[] eArr) {
            this.first = e;
            this.second = e2;
            this.rest = (E[]) ((Object[]) com.google.common.base.i.E(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E get(int i) {
            if (i == 0) {
                return this.first;
            }
            if (i == 1) {
                return this.second;
            }
            com.google.common.base.i.C(i, size());
            return this.rest[i - 2];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.e.t(this.rest.length, 2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class a<E> extends f<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final long f31775a = 0;

        public a(List list) {
            super(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i) {
            return this.f31777a.listIterator(i);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class b<E> extends c<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final long f31776a = 0;

        public b(List list) {
            super(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i) {
            return this.f31777a.listIterator(i);
        }
    }

    public static class c<E> extends AbstractList<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<E> f31777a;

        public c(List<E> list) {
            this.f31777a = (List) com.google.common.base.i.E(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, @ParametricNullness E e) {
            this.f31777a.add(i, e);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            return this.f31777a.addAll(i, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return this.f31777a.contains(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E get(int i) {
            return this.f31777a.get(i);
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E remove(int i) {
            return this.f31777a.remove(i);
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E set(int i, @ParametricNullness E e) {
            return this.f31777a.set(i, e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f31777a.size();
        }
    }

    public static final class d extends AbstractList<Character> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CharSequence f31778a;

        public d(CharSequence charSequence) {
            this.f31778a = charSequence;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character get(int i) {
            com.google.common.base.i.C(i, size());
            return Character.valueOf(this.f31778a.charAt(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f31778a.length();
        }
    }

    public static class e<T> extends AbstractList<List<T>> {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f31779a;

        public e(List<T> list, int i) {
            this.f31779a = list;
            this.K = i;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> get(int i) {
            com.google.common.base.i.C(i, size());
            int i2 = this.K;
            int i3 = i * i2;
            return this.f31779a.subList(i3, Math.min(i2 + i3, this.f31779a.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f31779a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return com.google.common.math.e.g(this.f31779a.size(), this.K, RoundingMode.CEILING);
        }
    }

    public static class f<E> extends c<E> implements RandomAccess {
        public f(List<E> list) {
            super(list);
        }
    }

    public static class g<T> extends e<T> implements RandomAccess {
        public g(List<T> list, int i) {
            super(list, i);
        }
    }

    public static class h<T> extends i<T> implements RandomAccess {
        public h(List<T> list) {
            super(list);
        }
    }

    public static class i<T> extends AbstractList<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f31780a;

        public class a implements ListIterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ ListIterator f6099a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public boolean f6100a;

            public a(ListIterator listIterator) {
                this.f6099a = listIterator;
            }

            @Override // java.util.ListIterator
            public void add(@ParametricNullness T t) {
                this.f6099a.add(t);
                this.f6099a.previous();
                this.f6100a = false;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f6099a.hasPrevious();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f6099a.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            @ParametricNullness
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.f6100a = true;
                return (T) this.f6099a.previous();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return i.this.d(this.f6099a.nextIndex());
            }

            @Override // java.util.ListIterator
            @ParametricNullness
            public T previous() {
                if (!hasPrevious()) {
                    throw new NoSuchElementException();
                }
                this.f6100a = true;
                return (T) this.f6099a.next();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return nextIndex() - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                com.google.common.collect.a.e(this.f6100a);
                this.f6099a.remove();
                this.f6100a = false;
            }

            @Override // java.util.ListIterator
            public void set(@ParametricNullness T t) {
                com.google.common.base.i.g0(this.f6100a);
                this.f6099a.set(t);
            }
        }

        public i(List<T> list) {
            this.f31780a = (List) com.google.common.base.i.E(list);
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, @ParametricNullness T t) {
            this.f31780a.add(d(i), t);
        }

        public List<T> b() {
            return this.f31780a;
        }

        public final int c(int i) {
            int size = size();
            com.google.common.base.i.C(i, size);
            return (size - 1) - i;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f31780a.clear();
        }

        public final int d(int i) {
            int size = size();
            com.google.common.base.i.d0(i, size);
            return size - i;
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T get(int i) {
            return this.f31780a.get(c(i));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new a(this.f31780a.listIterator(d(i)));
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T remove(int i) {
            return this.f31780a.remove(c(i));
        }

        @Override // java.util.AbstractList
        public void removeRange(int i, int i2) {
            subList(i, i2).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T set(int i, @ParametricNullness T t) {
            return this.f31780a.set(c(i), t);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f31780a.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int i, int i2) {
            com.google.common.base.i.f0(i, i2, size());
            return Lists.B(this.f31780a.subList(d(i2), d(i)));
        }
    }

    public static <T> List<List<T>> A(List<T> list, int i2) {
        com.google.common.base.i.E(list);
        com.google.common.base.i.d(i2 > 0);
        return list instanceof RandomAccess ? new g(list, i2) : new e(list, i2);
    }

    public static <T> List<T> B(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof i) {
            return ((i) list).b();
        }
        return list instanceof RandomAccess ? new h(list) : new i(list);
    }

    public static <E> List<E> C(List<E> list, int i2, int i3) {
        return (list instanceof RandomAccess ? new a(list) : new b(list)).subList(i2, i3);
    }

    public static <F, T> List<T> D(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }

    public static <E> boolean a(List<E> list, int i2, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = list.listIterator(i2);
        Iterator<? extends E> it = iterable.iterator();
        boolean z = false;
        while (it.hasNext()) {
            listIterator.add(it.next());
            z = true;
        }
        return z;
    }

    public static <E> List<E> b(@ParametricNullness E e2, @ParametricNullness E e3, E[] eArr) {
        return new TwoPlusArrayList(e2, e3, eArr);
    }

    public static <E> List<E> c(@ParametricNullness E e2, E[] eArr) {
        return new OnePlusArrayList(e2, eArr);
    }

    public static <B> List<List<B>> d(List<? extends List<? extends B>> list) {
        return CartesianList.c(list);
    }

    @SafeVarargs
    public static <B> List<List<B>> e(List<? extends B>... listArr) {
        return d(Arrays.asList(listArr));
    }

    public static <T> List<T> f(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static ImmutableList<Character> g(String str) {
        return new StringAsImmutableList((String) com.google.common.base.i.E(str));
    }

    @Beta
    public static List<Character> h(CharSequence charSequence) {
        return new d((CharSequence) com.google.common.base.i.E(charSequence));
    }

    @VisibleForTesting
    public static int i(int i2) {
        com.google.common.collect.a.b(i2, "arraySize");
        return Ints.x(((long) i2) + 5 + ((long) (i2 / 10)));
    }

    public static boolean j(List<?> list, @CheckForNull Object obj) {
        if (obj == com.google.common.base.i.E(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.t(list.iterator(), list2.iterator());
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!com.google.common.base.g.a(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    public static int k(List<?> list) {
        Iterator<?> it = list.iterator();
        int i2 = 1;
        while (it.hasNext()) {
            Object next = it.next();
            i2 = ~(~((i2 * 31) + (next == null ? 0 : next.hashCode())));
        }
        return i2;
    }

    public static int l(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return m(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (com.google.common.base.g.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public static int m(List<?> list, @CheckForNull Object obj) {
        int size = list.size();
        int i2 = 0;
        if (obj == null) {
            while (i2 < size) {
                if (list.get(i2) == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        while (i2 < size) {
            if (obj.equals(list.get(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int n(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return o(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (com.google.common.base.g.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    public static int o(List<?> list, @CheckForNull Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ListIterator<E> p(List<E> list, int i2) {
        return new c(list).listIterator(i2);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> q() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> r(Iterable<? extends E> iterable) {
        com.google.common.base.i.E(iterable);
        return iterable instanceof Collection ? new ArrayList<>((Collection) iterable) : s(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> s(Iterator<? extends E> it) {
        ArrayList<E> arrayListQ = q();
        Iterators.a(arrayListQ, it);
        return arrayListQ;
    }

    @SafeVarargs
    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> t(E... eArr) {
        com.google.common.base.i.E(eArr);
        ArrayList<E> arrayList = new ArrayList<>(i(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> u(int i2) {
        com.google.common.collect.a.b(i2, "initialArraySize");
        return new ArrayList<>(i2);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> v(int i2) {
        return new ArrayList<>(i(i2));
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> w() {
        return new CopyOnWriteArrayList<>();
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> x(Iterable<? extends E> iterable) {
        return new CopyOnWriteArrayList<>(iterable instanceof Collection ? (Collection) iterable : r(iterable));
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> y() {
        return new LinkedList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> z(Iterable<? extends E> iterable) {
        LinkedList<E> linkedListY = y();
        o.a(linkedListY, iterable);
        return linkedListY;
    }
}
