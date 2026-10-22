package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public abstract class FluentIterable<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Optional<Iterable<E>> f31706a;

    public class a extends FluentIterable<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f31707a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f31707a = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f31707a.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> extends FluentIterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f31708a;

        public b(Iterable iterable) {
            this.f31708a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.i(Iterators.c0(this.f31708a.iterator(), o.S()));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class c<T> extends FluentIterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable[] f31709a;

        public class a extends AbstractIndexedListIterator<Iterator<? extends T>> {
            public a(int i) {
                super(i);
            }

            @Override // com.google.common.collect.AbstractIndexedListIterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Iterator<? extends T> get(int i) {
                return c.this.f31709a[i].iterator();
            }
        }

        public c(Iterable[] iterableArr) {
            this.f31709a = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.i(new a(this.f31709a.length));
        }
    }

    public static class d<E> implements Function<Iterable<E>, FluentIterable<E>> {
        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public FluentIterable<E> apply(Iterable<E> iterable) {
            return FluentIterable.x(iterable);
        }
    }

    public FluentIterable() {
        this.f31706a = Optional.absent();
    }

    @Beta
    public static <E> FluentIterable<E> G() {
        return x(Collections.emptyList());
    }

    @Beta
    public static <E> FluentIterable<E> I(@ParametricNullness E e, E... eArr) {
        return x(Lists.c(e, eArr));
    }

    @Beta
    public static <T> FluentIterable<T> e(Iterable<? extends Iterable<? extends T>> iterable) {
        com.google.common.base.i.E(iterable);
        return new b(iterable);
    }

    @Beta
    public static <T> FluentIterable<T> f(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return j(iterable, iterable2);
    }

    @Beta
    public static <T> FluentIterable<T> g(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return j(iterable, iterable2, iterable3);
    }

    @Beta
    public static <T> FluentIterable<T> h(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return j(iterable, iterable2, iterable3, iterable4);
    }

    @Beta
    public static <T> FluentIterable<T> i(Iterable<? extends T>... iterableArr) {
        return j((Iterable[]) Arrays.copyOf(iterableArr, iterableArr.length));
    }

    public static <T> FluentIterable<T> j(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            com.google.common.base.i.E(iterable);
        }
        return new c(iterableArr);
    }

    @InlineMe(replacement = "checkNotNull(iterable)", staticImports = {"com.google.common.base.Preconditions.checkNotNull"})
    @Deprecated
    public static <E> FluentIterable<E> w(FluentIterable<E> fluentIterable) {
        return (FluentIterable) com.google.common.base.i.E(fluentIterable);
    }

    public static <E> FluentIterable<E> x(Iterable<E> iterable) {
        return iterable instanceof FluentIterable ? (FluentIterable) iterable : new a(iterable, iterable);
    }

    @Beta
    public static <E> FluentIterable<E> z(E[] eArr) {
        return x(Arrays.asList(eArr));
    }

    public final Iterable<E> A() {
        return this.f31706a.or(this);
    }

    public final <K> ImmutableListMultimap<K, E> B(Function<? super E, K> function) {
        return Multimaps.r(A(), function);
    }

    @Beta
    public final String C(com.google.common.base.d dVar) {
        return dVar.k(this);
    }

    public final Optional<E> D() {
        E next;
        Iterable<E> iterableA = A();
        if (iterableA instanceof List) {
            List list = (List) iterableA;
            return list.isEmpty() ? Optional.absent() : Optional.of(list.get(list.size() - 1));
        }
        Iterator<E> it = iterableA.iterator();
        if (!it.hasNext()) {
            return Optional.absent();
        }
        if (iterableA instanceof SortedSet) {
            return Optional.of(((SortedSet) iterableA).last());
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return Optional.of(next);
    }

    public final FluentIterable<E> E(int i) {
        return x(o.D(A(), i));
    }

    public final FluentIterable<E> J(int i) {
        return x(o.N(A(), i));
    }

    @GwtIncompatible
    public final E[] K(Class<E> cls) {
        return (E[]) o.Q(A(), cls);
    }

    public final ImmutableList<E> L() {
        return ImmutableList.copyOf(A());
    }

    public final <V> ImmutableMap<E, V> M(Function<? super E, V> function) {
        return Maps.u0(A(), function);
    }

    public final ImmutableMultiset<E> N() {
        return ImmutableMultiset.copyOf(A());
    }

    public final ImmutableSet<E> O() {
        return ImmutableSet.copyOf(A());
    }

    public final ImmutableList<E> P(Comparator<? super E> comparator) {
        return Ordering.from(comparator).immutableSortedCopy(A());
    }

    public final ImmutableSortedSet<E> Q(Comparator<? super E> comparator) {
        return ImmutableSortedSet.copyOf(comparator, A());
    }

    public final <T> FluentIterable<T> T(Function<? super E, T> function) {
        return x(o.U(A(), function));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> FluentIterable<T> U(Function<? super E, ? extends Iterable<? extends T>> function) {
        return e(T(function));
    }

    public final <K> ImmutableMap<K, E> V(Function<? super E, K> function) {
        return Maps.E0(A(), function);
    }

    public final boolean a(Predicate<? super E> predicate) {
        return o.b(A(), predicate);
    }

    public final boolean b(Predicate<? super E> predicate) {
        return o.c(A(), predicate);
    }

    @Beta
    public final FluentIterable<E> c(Iterable<? extends E> iterable) {
        return f(A(), iterable);
    }

    public final boolean contains(@CheckForNull Object obj) {
        return o.k(A(), obj);
    }

    @Beta
    public final FluentIterable<E> d(E... eArr) {
        return f(A(), Arrays.asList(eArr));
    }

    @ParametricNullness
    public final E get(int i) {
        return (E) o.t(A(), i);
    }

    public final boolean isEmpty() {
        return !A().iterator().hasNext();
    }

    @CanIgnoreReturnValue
    public final <C extends Collection<? super E>> C m(C c2) {
        com.google.common.base.i.E(c2);
        Iterable<E> iterableA = A();
        if (iterableA instanceof Collection) {
            c2.addAll((Collection) iterableA);
        } else {
            Iterator<E> it = iterableA.iterator();
            while (it.hasNext()) {
                c2.add(it.next());
            }
        }
        return c2;
    }

    public final FluentIterable<E> n() {
        return x(o.l(A()));
    }

    public final FluentIterable<E> o(Predicate<? super E> predicate) {
        return x(o.o(A(), predicate));
    }

    @GwtIncompatible
    public final <T> FluentIterable<T> q(Class<T> cls) {
        return x(o.p(A(), cls));
    }

    public final int size() {
        return o.M(A());
    }

    public final Optional<E> t() {
        Iterator<E> it = A().iterator();
        return it.hasNext() ? Optional.of(it.next()) : Optional.absent();
    }

    public String toString() {
        return o.T(A());
    }

    public final Optional<E> u(Predicate<? super E> predicate) {
        return o.V(A(), predicate);
    }

    public FluentIterable(Iterable<E> iterable) {
        this.f31706a = Optional.of(iterable);
    }
}
