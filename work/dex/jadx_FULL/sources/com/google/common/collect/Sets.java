package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Sets {

    public static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final transient CartesianList<E> f31878a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final transient ImmutableList<ImmutableSet<E>> f6138a;

        public CartesianSet(ImmutableList<ImmutableSet<E>> immutableList, CartesianList<E> cartesianList) {
            this.f6138a = immutableList;
            this.f31878a = cartesianList;
        }

        public static <E> Set<List<E>> c(List<? extends Set<? extends E>> list) {
            ImmutableList.a aVar = new ImmutableList.a(list.size());
            Iterator<? extends Set<? extends E>> it = list.iterator();
            while (it.hasNext()) {
                ImmutableSet immutableSetCopyOf = ImmutableSet.copyOf((Collection) it.next());
                if (immutableSetCopyOf.isEmpty()) {
                    return ImmutableSet.of();
                }
                aVar.a(immutableSetCopyOf);
            }
            final ImmutableList<E> immutableListE = aVar.e();
            return new CartesianSet(immutableListE, new CartesianList(new ImmutableList<List<E>>() { // from class: com.google.common.collect.Sets.CartesianSet.1
                @Override // com.google.common.collect.ImmutableCollection
                public boolean isPartialView() {
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return immutableListE.size();
                }

                @Override // java.util.List
                public List<E> get(int i) {
                    return ((ImmutableSet) immutableListE.get(i)).asList();
                }
            }));
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (list.size() != this.f6138a.size()) {
                return false;
            }
            Iterator<E> it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!this.f6138a.get(i).contains(it.next())) {
                    return false;
                }
                i++;
            }
            return true;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return obj instanceof CartesianSet ? this.f6138a.equals(((CartesianSet) obj).f6138a) : super.equals(obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int i = 1;
            int size = size() - 1;
            for (int i2 = 0; i2 < this.f6138a.size(); i2++) {
                size = ~(~(size * 31));
            }
            UnmodifiableIterator<ImmutableSet<E>> it = this.f6138a.iterator();
            while (it.hasNext()) {
                ImmutableSet<E> next = it.next();
                i = ~(~((i * 31) + ((size() / next.size()) * next.hashCode())));
            }
            return ~(~(i + size));
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Collection<List<E>> delegate() {
            return this.f31878a;
        }
    }

    public static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return Sets.I(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) com.google.common.base.i.E(collection));
        }
    }

    public static abstract class SetView<E> extends AbstractSet<E> {
        public /* synthetic */ SetView(a aVar) {
            this();
        }

        @CanIgnoreReturnValue
        public <S extends Set<E>> S a(S s) {
            s.addAll(this);
            return s;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean add(@ParametricNullness E e) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public ImmutableSet<E> b() {
            return ImmutableSet.copyOf((Collection) this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public abstract UnmodifiableIterator<E> iterator();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public SetView() {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class a<E> extends SetView<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f31879a;
        public final /* synthetic */ Set b;

        /* JADX INFO: renamed from: com.google.common.collect.Sets$a$a, reason: collision with other inner class name */
        public class C0725a extends AbstractIterator<E> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Iterator<? extends E> f6139a;
            public final Iterator<? extends E> b;

            public C0725a() {
                this.f6139a = a.this.f31879a.iterator();
                this.b = a.this.b.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public E computeNext() {
                if (this.f6139a.hasNext()) {
                    return this.f6139a.next();
                }
                while (this.b.hasNext()) {
                    E next = this.b.next();
                    if (!a.this.f31879a.contains(next)) {
                        return next;
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.f31879a = set;
            this.b = set2;
        }

        @Override // com.google.common.collect.Sets.SetView
        public <S extends Set<E>> S a(S s) {
            s.addAll(this.f31879a);
            s.addAll(this.b);
            return s;
        }

        @Override // com.google.common.collect.Sets.SetView
        public ImmutableSet<E> b() {
            return new ImmutableSet.a().c(this.f31879a).c(this.b).e();
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: c */
        public UnmodifiableIterator<E> iterator() {
            return new C0725a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.f31879a.contains(obj) || this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f31879a.isEmpty() && this.b.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            int size = this.f31879a.size();
            Iterator<E> it = this.b.iterator();
            while (it.hasNext()) {
                if (!this.f31879a.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class b<E> extends SetView<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f31881a;
        public final /* synthetic */ Set b;

        public class a extends AbstractIterator<E> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Iterator<E> f6140a;

            public a() {
                this.f6140a = b.this.f31881a.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public E computeNext() {
                while (this.f6140a.hasNext()) {
                    E next = this.f6140a.next();
                    if (b.this.b.contains(next)) {
                        return next;
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Set set, Set set2) {
            super(null);
            this.f31881a = set;
            this.b = set2;
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: c */
        public UnmodifiableIterator<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.f31881a.contains(obj) && this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return this.f31881a.containsAll(collection) && this.b.containsAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return Collections.disjoint(this.b, this.f31881a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f31881a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (this.b.contains(it.next())) {
                    i++;
                }
            }
            return i;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class c<E> extends SetView<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f31883a;
        public final /* synthetic */ Set b;

        public class a extends AbstractIterator<E> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final Iterator<E> f6141a;

            public a() {
                this.f6141a = c.this.f31883a.iterator();
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public E computeNext() {
                while (this.f6141a.hasNext()) {
                    E next = this.f6141a.next();
                    if (!c.this.b.contains(next)) {
                        return next;
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Set set, Set set2) {
            super(null);
            this.f31883a = set;
            this.b = set2;
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: c */
        public UnmodifiableIterator<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.f31883a.contains(obj) && !this.b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.b.containsAll(this.f31883a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f31883a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!this.b.contains(it.next())) {
                    i++;
                }
            }
            return i;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class d<E> extends SetView<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Set f31885a;
        public final /* synthetic */ Set b;

        public class a extends AbstractIterator<E> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Iterator f6142a;
            public final /* synthetic */ Iterator b;

            public a(Iterator it, Iterator it2) {
                this.f6142a = it;
                this.b = it2;
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public E computeNext() {
                while (this.f6142a.hasNext()) {
                    E e = (E) this.f6142a.next();
                    if (!d.this.b.contains(e)) {
                        return e;
                    }
                }
                while (this.b.hasNext()) {
                    E e2 = (E) this.b.next();
                    if (!d.this.f31885a.contains(e2)) {
                        return e2;
                    }
                }
                return endOfData();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Set set, Set set2) {
            super(null);
            this.f31885a = set;
            this.b = set2;
        }

        @Override // com.google.common.collect.Sets.SetView, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* JADX INFO: renamed from: c */
        public UnmodifiableIterator<E> iterator() {
            return new a(this.f31885a.iterator(), this.b.iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.b.contains(obj) ^ this.f31885a.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this.f31885a.equals(this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Iterator<E> it = this.f31885a.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (!this.b.contains(it.next())) {
                    i++;
                }
            }
            Iterator<E> it2 = this.b.iterator();
            while (it2.hasNext()) {
                if (!this.f31885a.contains(it2.next())) {
                    i++;
                }
            }
            return i;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [E] */
    public class e<E> extends AbstractSet<Set<E>> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmutableMap f31887a;

        public class a extends AbstractIterator<Set<E>> {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final BitSet f6143a;

            /* JADX INFO: renamed from: com.google.common.collect.Sets$e$a$a, reason: collision with other inner class name */
            public class C0726a extends AbstractSet<E> {

                /* JADX INFO: renamed from: a, reason: collision with other field name */
                public final /* synthetic */ BitSet f6144a;

                /* JADX INFO: renamed from: com.google.common.collect.Sets$e$a$a$a, reason: collision with other inner class name */
                public class C0727a extends AbstractIterator<E> {
                    public int K = -1;

                    public C0727a() {
                    }

                    @Override // com.google.common.collect.AbstractIterator
                    @CheckForNull
                    public E computeNext() {
                        int iNextSetBit = C0726a.this.f6144a.nextSetBit(this.K + 1);
                        this.K = iNextSetBit;
                        return iNextSetBit == -1 ? endOfData() : e.this.f31887a.keySet().asList().get(this.K);
                    }
                }

                public C0726a(BitSet bitSet) {
                    this.f6144a = bitSet;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(@CheckForNull Object obj) {
                    Integer num = (Integer) e.this.f31887a.get(obj);
                    return num != null && this.f6144a.get(num.intValue());
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<E> iterator() {
                    return new C0727a();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return e.this.K;
                }
            }

            public a() {
                this.f6143a = new BitSet(e.this.f31887a.size());
            }

            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            public Set<E> computeNext() {
                if (this.f6143a.isEmpty()) {
                    this.f6143a.set(0, e.this.K);
                } else {
                    int iNextSetBit = this.f6143a.nextSetBit(0);
                    int iNextClearBit = this.f6143a.nextClearBit(iNextSetBit);
                    if (iNextClearBit == e.this.f31887a.size()) {
                        return endOfData();
                    }
                    int i = (iNextClearBit - iNextSetBit) - 1;
                    this.f6143a.set(0, i);
                    this.f6143a.clear(i, iNextClearBit);
                    this.f6143a.set(iNextClearBit);
                }
                return new C0726a((BitSet) this.f6143a.clone());
            }
        }

        public e(int i, ImmutableMap immutableMap) {
            this.K = i;
            this.f31887a = immutableMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            return set.size() == this.K && this.f31887a.keySet().containsAll(set);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return com.google.common.math.e.a(this.f31887a.size(), this.K);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String strValueOf = String.valueOf(this.f31887a.keySet());
            int i = this.K;
            StringBuilder sb = new StringBuilder(strValueOf.length() + 32);
            sb.append("Sets.combinations(");
            sb.append(strValueOf);
            sb.append(", ");
            sb.append(i);
            sb.append(")");
            return sb.toString();
        }
    }

    @GwtIncompatible
    public static class f<E> extends ForwardingNavigableSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final NavigableSet<E> f31891a;

        public f(NavigableSet<E> navigableSet) {
            this.f31891a = navigableSet;
        }

        public static <T> Ordering<T> c(Comparator<T> comparator) {
            return Ordering.from(comparator).reverse();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E ceiling(@ParametricNullness E e) {
            return this.f31891a.floor(e);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator = this.f31891a.comparator();
            return comparator == null ? Ordering.natural().reverse() : c(comparator);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return this.f31891a.iterator();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return this.f31891a;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        @ParametricNullness
        public E first() {
            return this.f31891a.last();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E floor(@ParametricNullness E e) {
            return this.f31891a.ceiling(e);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> headSet(@ParametricNullness E e, boolean z) {
            return this.f31891a.tailSet(e, z).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E higher(@ParametricNullness E e) {
            return this.f31891a.lower(e);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return this.f31891a.descendingIterator();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        @ParametricNullness
        public E last() {
            return this.f31891a.first();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E lower(@ParametricNullness E e) {
            return this.f31891a.higher(e);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            return this.f31891a.pollLast();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            return this.f31891a.pollFirst();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> subSet(@ParametricNullness E e, boolean z, @ParametricNullness E e2, boolean z2) {
            return this.f31891a.subSet(e2, z2, e, z).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public NavigableSet<E> tailSet(@ParametricNullness E e, boolean z) {
            return this.f31891a.headSet(e, z).descendingSet();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public Object[] toArray() {
            return standardToArray();
        }

        @Override // com.google.common.collect.ForwardingObject
        public String toString() {
            return standardToString();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> headSet(@ParametricNullness E e) {
            return standardHeadSet(e);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> subSet(@ParametricNullness E e, @ParametricNullness E e2) {
            return standardSubSet(e, e2);
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public SortedSet<E> tailSet(@ParametricNullness E e) {
            return standardTailSet(e);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            return (T[]) standardToArray(tArr);
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public NavigableSet<E> delegate() {
            return this.f31891a;
        }
    }

    @GwtIncompatible
    public static class g<E> extends i<E> implements NavigableSet<E> {
        public g(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
            super(navigableSet, predicate);
        }

        public NavigableSet<E> b() {
            return (NavigableSet) ((com.google.common.collect.b.a) this).f6197a;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(@ParametricNullness E e) {
            return (E) o.r(b().tailSet(e, true), ((com.google.common.collect.b.a) this).f31964a, null);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.x(b().descendingIterator(), ((com.google.common.collect.b.a) this).f31964a);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return Sets.h(b().descendingSet(), ((com.google.common.collect.b.a) this).f31964a);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(@ParametricNullness E e) {
            return (E) Iterators.A(b().headSet(e, true).descendingIterator(), ((com.google.common.collect.b.a) this).f31964a, null);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@ParametricNullness E e, boolean z) {
            return Sets.h(b().headSet(e, z), ((com.google.common.collect.b.a) this).f31964a);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(@ParametricNullness E e) {
            return (E) o.r(b().tailSet(e, false), ((com.google.common.collect.b.a) this).f31964a, null);
        }

        @Override // com.google.common.collect.Sets.i, java.util.SortedSet
        @ParametricNullness
        public E last() {
            return (E) Iterators.z(b().descendingIterator(), ((com.google.common.collect.b.a) this).f31964a);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(@ParametricNullness E e) {
            return (E) Iterators.A(b().headSet(e, false).descendingIterator(), ((com.google.common.collect.b.a) this).f31964a, null);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            return (E) o.I(b(), ((com.google.common.collect.b.a) this).f31964a);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            return (E) o.I(b().descendingSet(), ((com.google.common.collect.b.a) this).f31964a);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@ParametricNullness E e, boolean z, @ParametricNullness E e2, boolean z2) {
            return Sets.h(b().subSet(e, z, e2, z2), ((com.google.common.collect.b.a) this).f31964a);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@ParametricNullness E e, boolean z) {
            return Sets.h(b().tailSet(e, z), ((com.google.common.collect.b.a) this).f31964a);
        }
    }

    public static class h<E> extends com.google.common.collect.b.a<E> implements Set<E> {
        public h(Set<E> set, Predicate<? super E> predicate) {
            super(set, predicate);
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.k(this);
        }
    }

    public static class i<E> extends h<E> implements SortedSet<E> {
        public i(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
            super(sortedSet, predicate);
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super E> comparator() {
            return ((SortedSet) ((com.google.common.collect.b.a) this).f6197a).comparator();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public E first() {
            return (E) Iterators.z(((com.google.common.collect.b.a) this).f6197a.iterator(), ((com.google.common.collect.b.a) this).f31964a);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(@ParametricNullness E e) {
            return new i(((SortedSet) ((com.google.common.collect.b.a) this).f6197a).headSet(e), ((com.google.common.collect.b.a) this).f31964a);
        }

        @ParametricNullness
        public E last() {
            SortedSet sortedSetHeadSet = (SortedSet) ((com.google.common.collect.b.a) this).f6197a;
            while (true) {
                E e = (Object) sortedSetHeadSet.last();
                if (((com.google.common.collect.b.a) this).f31964a.apply(e)) {
                    return e;
                }
                sortedSetHeadSet = sortedSetHeadSet.headSet(e);
            }
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(@ParametricNullness E e, @ParametricNullness E e2) {
            return new i(((SortedSet) ((com.google.common.collect.b.a) this).f6197a).subSet(e, e2), ((com.google.common.collect.b.a) this).f31964a);
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(@ParametricNullness E e) {
            return new i(((SortedSet) ((com.google.common.collect.b.a) this).f6197a).tailSet(e), ((com.google.common.collect.b.a) this).f31964a);
        }
    }

    public static final class j<E> extends AbstractSet<Set<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<E, Integer> f31892a;

        public class a extends AbstractIndexedListIterator<Set<E>> {
            public a(int i) {
                super(i);
            }

            @Override // com.google.common.collect.AbstractIndexedListIterator
            public Set<E> get(int i) {
                return new k(j.this.f31892a, i);
            }
        }

        public j(Set<E> set) {
            com.google.common.base.i.k(set.size() <= 30, "Too many elements to create power set: %s > 30", set.size());
            this.f31892a = Maps.Q(set);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            return this.f31892a.keySet().containsAll((Set) obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return obj instanceof j ? this.f31892a.keySet().equals(((j) obj).f31892a.keySet()) : super.equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return this.f31892a.keySet().hashCode() << (this.f31892a.size() - 1);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Set<E>> iterator() {
            return new a(size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return 1 << this.f31892a.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String strValueOf = String.valueOf(this.f31892a);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 10);
            sb.append("powerSet(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static final class k<E> extends AbstractSet<E> {
        public final int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<E, Integer> f31894a;

        public class a extends UnmodifiableIterator<E> {
            public int K;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ImmutableList<E> f31895a;

            public a() {
                this.f31895a = k.this.f31894a.keySet().asList();
                this.K = k.this.K;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.K != 0;
            }

            @Override // java.util.Iterator
            public E next() {
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(this.K);
                if (iNumberOfTrailingZeros == 32) {
                    throw new NoSuchElementException();
                }
                this.K &= ~(1 << iNumberOfTrailingZeros);
                return this.f31895a.get(iNumberOfTrailingZeros);
            }
        }

        public k(ImmutableMap<E, Integer> immutableMap, int i) {
            this.f31894a = immutableMap;
            this.K = i;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            Integer num = this.f31894a.get(obj);
            if (num != null) {
                if (((1 << num.intValue()) & this.K) != 0) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Integer.bitCount(this.K);
        }
    }

    public static <E> LinkedHashSet<E> A() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> B(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet<>((Collection) iterable);
        }
        LinkedHashSet<E> linkedHashSetA = A();
        o.a(linkedHashSetA, iterable);
        return linkedHashSetA;
    }

    public static <E> LinkedHashSet<E> C(int i2) {
        return new LinkedHashSet<>(Maps.o(i2));
    }

    @Deprecated
    public static <E> Set<E> D(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E extends Comparable> TreeSet<E> E() {
        return new TreeSet<>();
    }

    public static <E extends Comparable> TreeSet<E> F(Iterable<? extends E> iterable) {
        TreeSet<E> treeSetE = E();
        o.a(treeSetE, iterable);
        return treeSetE;
    }

    public static <E> TreeSet<E> G(Comparator<? super E> comparator) {
        return new TreeSet<>((Comparator) com.google.common.base.i.E(comparator));
    }

    @GwtCompatible(serializable = false)
    public static <E> Set<Set<E>> H(Set<E> set) {
        return new j(set);
    }

    public static boolean I(Set<?> set, Collection<?> collection) {
        com.google.common.base.i.E(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).elementSet();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? J(set, collection.iterator()) : Iterators.V(set.iterator(), collection);
    }

    public static boolean J(Set<?> set, Iterator<?> it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    @GwtIncompatible
    public static <K extends Comparable<? super K>> NavigableSet<K> K(NavigableSet<K> navigableSet, Range<K> range) {
        if (navigableSet.comparator() != null && navigableSet.comparator() != Ordering.natural() && range.hasLowerBound() && range.hasUpperBound()) {
            com.google.common.base.i.e(navigableSet.comparator().compare(range.lowerEndpoint(), range.upperEndpoint()) <= 0, "set is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.hasLowerBound() && range.hasUpperBound()) {
            Comparable comparableLowerEndpoint = range.lowerEndpoint();
            BoundType boundTypeLowerBoundType = range.lowerBoundType();
            BoundType boundType = BoundType.CLOSED;
            return navigableSet.subSet(comparableLowerEndpoint, boundTypeLowerBoundType == boundType, range.upperEndpoint(), range.upperBoundType() == boundType);
        }
        if (range.hasLowerBound()) {
            return navigableSet.tailSet(range.lowerEndpoint(), range.lowerBoundType() == BoundType.CLOSED);
        }
        if (range.hasUpperBound()) {
            return navigableSet.headSet(range.upperEndpoint(), range.upperBoundType() == BoundType.CLOSED);
        }
        return (NavigableSet) com.google.common.base.i.E(navigableSet);
    }

    public static <E> SetView<E> L(Set<? extends E> set, Set<? extends E> set2) {
        com.google.common.base.i.F(set, "set1");
        com.google.common.base.i.F(set2, "set2");
        return new d(set, set2);
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> M(NavigableSet<E> navigableSet) {
        return Synchronized.q(navigableSet);
    }

    public static <E> SetView<E> N(Set<? extends E> set, Set<? extends E> set2) {
        com.google.common.base.i.F(set, "set1");
        com.google.common.base.i.F(set2, "set2");
        return new a(set, set2);
    }

    public static <E> NavigableSet<E> O(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    public static <B> Set<List<B>> a(List<? extends Set<? extends B>> list) {
        return CartesianSet.c(list);
    }

    @SafeVarargs
    public static <B> Set<List<B>> b(Set<? extends B>... setArr) {
        return a(Arrays.asList(setArr));
    }

    @Beta
    public static <E> Set<Set<E>> c(Set<E> set, int i2) {
        ImmutableMap immutableMapQ = Maps.Q(set);
        com.google.common.collect.a.b(i2, "size");
        com.google.common.base.i.m(i2 <= immutableMapQ.size(), "size (%s) must be <= set.size() (%s)", i2, immutableMapQ.size());
        if (i2 == 0) {
            return ImmutableSet.of(ImmutableSet.of());
        }
        return i2 == immutableMapQ.size() ? ImmutableSet.of(immutableMapQ.keySet()) : new e(i2, immutableMapQ);
    }

    public static <E extends Enum<E>> EnumSet<E> d(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        com.google.common.base.i.e(!collection.isEmpty(), "collection is empty; use the other version of this method");
        return o(collection, collection.iterator().next().getDeclaringClass());
    }

    public static <E extends Enum<E>> EnumSet<E> e(Collection<E> collection, Class<E> cls) {
        com.google.common.base.i.E(collection);
        return collection instanceof EnumSet ? EnumSet.complementOf((EnumSet) collection) : o(collection, cls);
    }

    public static <E> SetView<E> f(Set<E> set, Set<?> set2) {
        com.google.common.base.i.F(set, "set1");
        com.google.common.base.i.F(set2, "set2");
        return new c(set, set2);
    }

    public static boolean g(Set<?> set, @CheckForNull Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public static <E> NavigableSet<E> h(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        if (!(navigableSet instanceof h)) {
            return new g((NavigableSet) com.google.common.base.i.E(navigableSet), (Predicate) com.google.common.base.i.E(predicate));
        }
        h hVar = (h) navigableSet;
        return new g((NavigableSet) ((com.google.common.collect.b.a) hVar).f6197a, Predicates.d(((com.google.common.collect.b.a) hVar).f31964a, predicate));
    }

    public static <E> Set<E> i(Set<E> set, Predicate<? super E> predicate) {
        if (set instanceof SortedSet) {
            return j((SortedSet) set, predicate);
        }
        if (!(set instanceof h)) {
            return new h((Set) com.google.common.base.i.E(set), (Predicate) com.google.common.base.i.E(predicate));
        }
        h hVar = (h) set;
        return new h((Set) ((com.google.common.collect.b.a) hVar).f6197a, Predicates.d(((com.google.common.collect.b.a) hVar).f31964a, predicate));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> SortedSet<E> j(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        if (!(sortedSet instanceof h)) {
            return new i((SortedSet) com.google.common.base.i.E(sortedSet), (Predicate) com.google.common.base.i.E(predicate));
        }
        h hVar = (h) sortedSet;
        return new i((SortedSet) ((com.google.common.collect.b.a) hVar).f6197a, Predicates.d(((com.google.common.collect.b.a) hVar).f31964a, predicate));
    }

    public static int k(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i2 = ~(~(i2 + (next != null ? next.hashCode() : 0)));
        }
        return i2;
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> l(E e2, E... eArr) {
        return ImmutableEnumSet.asImmutable(EnumSet.of((Enum) e2, (Enum[]) eArr));
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> m(Iterable<E> iterable) {
        if (iterable instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet) iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return collection.isEmpty() ? ImmutableSet.of() : ImmutableEnumSet.asImmutable(EnumSet.copyOf(collection));
        }
        Iterator<E> it = iterable.iterator();
        if (!it.hasNext()) {
            return ImmutableSet.of();
        }
        EnumSet enumSetOf = EnumSet.of((Enum) it.next());
        Iterators.a(enumSetOf, it);
        return ImmutableEnumSet.asImmutable(enumSetOf);
    }

    public static <E> SetView<E> n(Set<E> set, Set<?> set2) {
        com.google.common.base.i.F(set, "set1");
        com.google.common.base.i.F(set2, "set2");
        return new b(set, set2);
    }

    public static <E extends Enum<E>> EnumSet<E> o(Collection<E> collection, Class<E> cls) {
        EnumSet<E> enumSetAllOf = EnumSet.allOf(cls);
        enumSetAllOf.removeAll(collection);
        return enumSetAllOf;
    }

    public static <E> Set<E> p() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> Set<E> q(Iterable<? extends E> iterable) {
        Set<E> setP = p();
        o.a(setP, iterable);
        return setP;
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> r() {
        return new CopyOnWriteArraySet<>();
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArraySet<E> s(Iterable<? extends E> iterable) {
        return new CopyOnWriteArraySet<>(iterable instanceof Collection ? (Collection) iterable : Lists.r(iterable));
    }

    public static <E extends Enum<E>> EnumSet<E> t(Iterable<E> iterable, Class<E> cls) {
        EnumSet<E> enumSetNoneOf = EnumSet.noneOf(cls);
        o.a(enumSetNoneOf, iterable);
        return enumSetNoneOf;
    }

    public static <E> HashSet<E> u() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> v(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? new HashSet<>((Collection) iterable) : w(iterable.iterator());
    }

    public static <E> HashSet<E> w(Iterator<? extends E> it) {
        HashSet<E> hashSetU = u();
        Iterators.a(hashSetU, it);
        return hashSetU;
    }

    public static <E> HashSet<E> x(E... eArr) {
        HashSet<E> hashSetY = y(eArr.length);
        Collections.addAll(hashSetY, eArr);
        return hashSetY;
    }

    public static <E> HashSet<E> y(int i2) {
        return new HashSet<>(Maps.o(i2));
    }

    public static <E> Set<E> z() {
        return Collections.newSetFromMap(Maps.b0());
    }

    public static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;
        private final NavigableSet<E> delegate;

        @CheckForNull
        private transient UnmodifiableNavigableSet<E> descendingSet;
        private final SortedSet<E> unmodifiableDelegate;

        public UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) com.google.common.base.i.E(navigableSet);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E ceiling(@ParametricNullness E e) {
            return this.delegate.ceiling(e);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return Iterators.f0(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.descendingSet;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = new UnmodifiableNavigableSet<>(this.delegate.descendingSet());
            this.descendingSet = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.descendingSet = this;
            return unmodifiableNavigableSet2;
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E floor(@ParametricNullness E e) {
            return this.delegate.floor(e);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(@ParametricNullness E e, boolean z) {
            return Sets.O(this.delegate.headSet(e, z));
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E higher(@ParametricNullness E e) {
            return this.delegate.higher(e);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E lower(@ParametricNullness E e) {
            return this.delegate.lower(e);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(@ParametricNullness E e, boolean z, @ParametricNullness E e2, boolean z2) {
            return Sets.O(this.delegate.subSet(e, z, e2, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(@ParametricNullness E e, boolean z) {
            return Sets.O(this.delegate.tailSet(e, z));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public SortedSet<E> delegate() {
            return this.unmodifiableDelegate;
        }
    }
}
