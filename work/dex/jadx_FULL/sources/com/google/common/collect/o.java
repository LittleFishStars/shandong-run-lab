package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class o {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements Function<Iterable<? extends T>, Iterator<? extends T>> {
        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Iterator<? extends T> apply(Iterable<? extends T> iterable) {
            return iterable.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> extends FluentIterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f31991a;

        public b(Iterable iterable) {
            this.f31991a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.r(this.f31991a);
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return String.valueOf(this.f31991a.toString()).concat(" (cycled)");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class c<T> extends FluentIterable<List<T>> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f31992a;

        public c(Iterable iterable, int i) {
            this.f31992a = iterable;
            this.K = i;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return Iterators.Q(this.f31992a.iterator(), this.K);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> extends FluentIterable<List<T>> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f31993a;

        public d(Iterable iterable, int i) {
            this.f31993a = iterable;
            this.K = i;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return Iterators.P(this.f31993a.iterator(), this.K);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class e<T> extends FluentIterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Predicate f31994a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Iterable f6209a;

        public e(Iterable iterable, Predicate predicate) {
            this.f6209a = iterable;
            this.f31994a = predicate;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.x(this.f6209a.iterator(), this.f31994a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class f<T> extends FluentIterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function f31995a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Iterable f6210a;

        public f(Iterable iterable, Function function) {
            this.f6210a = iterable;
            this.f31995a = function;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.c0(this.f6210a.iterator(), this.f31995a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class g<T> extends FluentIterable<T> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f31996a;

        public class a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f31997a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public boolean f6211a = true;

            public a(g gVar, Iterator it) {
                this.f31997a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f31997a.hasNext();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public T next() {
                T t = (T) this.f31997a.next();
                this.f6211a = false;
                return t;
            }

            @Override // java.util.Iterator
            public void remove() {
                com.google.common.collect.a.e(!this.f6211a);
                this.f31997a.remove();
            }
        }

        public g(Iterable iterable, int i) {
            this.f31996a = iterable;
            this.K = i;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f31996a;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.K), list.size()).iterator();
            }
            Iterator<T> it = iterable.iterator();
            Iterators.b(it, this.K);
            return new a(this, it);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class h<T> extends FluentIterable<T> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f31998a;

        public h(Iterable iterable, int i) {
            this.f31998a = iterable;
            this.K = i;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.N(this.f31998a.iterator(), this.K);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class i<T> extends FluentIterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f31999a;

        public i(Iterable iterable) {
            this.f31999a = iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f31999a;
            return iterable instanceof Queue ? new com.google.common.collect.e((Queue) iterable) : Iterators.p(iterable.iterator());
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return "Iterables.consumingIterable(...)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class j<T> extends FluentIterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f32000a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Comparator f6212a;

        public j(Iterable iterable, Comparator comparator) {
            this.f32000a = iterable;
            this.f6212a = comparator;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.O(o.U(this.f32000a, o.S()), this.f6212a);
        }
    }

    public static final class k<T> extends FluentIterable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterable<? extends T> f32001a;

        public /* synthetic */ k(Iterable iterable, b bVar) {
            this(iterable);
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.f0(this.f32001a.iterator());
        }

        @Override // com.google.common.collect.FluentIterable
        public String toString() {
            return this.f32001a.toString();
        }

        public k(Iterable<? extends T> iterable) {
            this.f32001a = iterable;
        }
    }

    @ParametricNullness
    public static <T> T A(Iterable<? extends T> iterable, @ParametricNullness T t) {
        return (T) Iterators.L(iterable.iterator(), t);
    }

    public static <T> int B(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.M(iterable.iterator(), predicate);
    }

    public static boolean C(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> D(Iterable<T> iterable, int i2) {
        com.google.common.base.i.E(iterable);
        com.google.common.base.i.e(i2 >= 0, "limit is negative");
        return new h(iterable, i2);
    }

    @Beta
    public static <T> Iterable<T> E(Iterable<? extends Iterable<? extends T>> iterable, Comparator<? super T> comparator) {
        com.google.common.base.i.F(iterable, "iterables");
        com.google.common.base.i.F(comparator, "comparator");
        return new k(new j(iterable, comparator), null);
    }

    public static <T> Iterable<List<T>> F(Iterable<T> iterable, int i2) {
        com.google.common.base.i.E(iterable);
        com.google.common.base.i.d(i2 > 0);
        return new d(iterable, i2);
    }

    public static <T> Iterable<List<T>> G(Iterable<T> iterable, int i2) {
        com.google.common.base.i.E(iterable);
        com.google.common.base.i.d(i2 > 0);
        return new c(iterable, i2);
    }

    @CanIgnoreReturnValue
    public static boolean H(Iterable<?> iterable, Collection<?> collection) {
        return iterable instanceof Collection ? ((Collection) iterable).removeAll((Collection) com.google.common.base.i.E(collection)) : Iterators.V(iterable.iterator(), collection);
    }

    @CheckForNull
    public static <T> T I(Iterable<T> iterable, Predicate<? super T> predicate) {
        com.google.common.base.i.E(predicate);
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    @CanIgnoreReturnValue
    public static <T> boolean J(Iterable<T> iterable, Predicate<? super T> predicate) {
        return ((iterable instanceof RandomAccess) && (iterable instanceof List)) ? K((List) iterable, (Predicate) com.google.common.base.i.E(predicate)) : Iterators.W(iterable.iterator(), predicate);
    }

    public static <T> boolean K(List<T> list, Predicate<? super T> predicate) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < list.size()) {
            T t = list.get(i2);
            if (!predicate.apply(t)) {
                if (i2 > i3) {
                    try {
                        list.set(i3, t);
                    } catch (IllegalArgumentException unused) {
                        O(list, predicate, i3, i2);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        O(list, predicate, i3, i2);
                        return true;
                    }
                }
                i3++;
            }
            i2++;
        }
        list.subList(i3, list.size()).clear();
        return i2 != i3;
    }

    @CanIgnoreReturnValue
    public static boolean L(Iterable<?> iterable, Collection<?> collection) {
        return iterable instanceof Collection ? ((Collection) iterable).retainAll((Collection) com.google.common.base.i.E(collection)) : Iterators.X(iterable.iterator(), collection);
    }

    public static int M(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : Iterators.Z(iterable.iterator());
    }

    public static <T> Iterable<T> N(Iterable<T> iterable, int i2) {
        com.google.common.base.i.E(iterable);
        com.google.common.base.i.e(i2 >= 0, "number to skip cannot be negative");
        return new g(iterable, i2);
    }

    public static <T> void O(List<T> list, Predicate<? super T> predicate, int i2, int i3) {
        for (int size = list.size() - 1; size > i3; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            list.remove(i4);
        }
    }

    public static Object[] P(Iterable<?> iterable) {
        return d(iterable).toArray();
    }

    @GwtIncompatible
    public static <T> T[] Q(Iterable<? extends T> iterable, Class<T> cls) {
        return (T[]) R(iterable, r.i(cls, 0));
    }

    public static <T> T[] R(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) d(iterable).toArray(tArr);
    }

    public static <T> Function<Iterable<? extends T>, Iterator<? extends T>> S() {
        return new a();
    }

    public static String T(Iterable<?> iterable) {
        return Iterators.b0(iterable.iterator());
    }

    public static <F, T> Iterable<T> U(Iterable<F> iterable, Function<? super F, ? extends T> function) {
        com.google.common.base.i.E(iterable);
        com.google.common.base.i.E(function);
        return new f(iterable, function);
    }

    public static <T> Optional<T> V(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.d0(iterable.iterator(), predicate);
    }

    @Deprecated
    public static <E> Iterable<E> W(ImmutableCollection<E> immutableCollection) {
        return (Iterable) com.google.common.base.i.E(immutableCollection);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Iterable<T> X(Iterable<? extends T> iterable) {
        com.google.common.base.i.E(iterable);
        return ((iterable instanceof k) || (iterable instanceof ImmutableCollection)) ? iterable : new k(iterable, null);
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        return iterable instanceof Collection ? collection.addAll((Collection) iterable) : Iterators.a(collection, ((Iterable) com.google.common.base.i.E(iterable)).iterator());
    }

    public static <T> boolean b(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.c(iterable.iterator(), predicate);
    }

    public static <T> boolean c(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.d(iterable.iterator(), predicate);
    }

    public static <E> Collection<E> d(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.s(iterable.iterator());
    }

    public static <T> Iterable<T> e(Iterable<? extends Iterable<? extends T>> iterable) {
        return FluentIterable.e(iterable);
    }

    public static <T> Iterable<T> f(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return FluentIterable.f(iterable, iterable2);
    }

    public static <T> Iterable<T> g(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return FluentIterable.g(iterable, iterable2, iterable3);
    }

    public static <T> Iterable<T> h(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return FluentIterable.h(iterable, iterable2, iterable3, iterable4);
    }

    @SafeVarargs
    public static <T> Iterable<T> i(Iterable<? extends T>... iterableArr) {
        return FluentIterable.i(iterableArr);
    }

    public static <T> Iterable<T> j(Iterable<T> iterable) {
        com.google.common.base.i.E(iterable);
        return new i(iterable);
    }

    public static boolean k(Iterable<? extends Object> iterable, @CheckForNull Object obj) {
        return iterable instanceof Collection ? com.google.common.collect.b.j((Collection) iterable, obj) : Iterators.q(iterable.iterator(), obj);
    }

    public static <T> Iterable<T> l(Iterable<T> iterable) {
        com.google.common.base.i.E(iterable);
        return new b(iterable);
    }

    @SafeVarargs
    public static <T> Iterable<T> m(T... tArr) {
        return l(Lists.t(tArr));
    }

    public static boolean n(Iterable<?> iterable, Iterable<?> iterable2) {
        if ((iterable instanceof Collection) && (iterable2 instanceof Collection) && ((Collection) iterable).size() != ((Collection) iterable2).size()) {
            return false;
        }
        return Iterators.t(iterable.iterator(), iterable2.iterator());
    }

    public static <T> Iterable<T> o(Iterable<T> iterable, Predicate<? super T> predicate) {
        com.google.common.base.i.E(iterable);
        com.google.common.base.i.E(predicate);
        return new e(iterable, predicate);
    }

    @GwtIncompatible
    public static <T> Iterable<T> p(Iterable<?> iterable, Class<T> cls) {
        com.google.common.base.i.E(iterable);
        com.google.common.base.i.E(cls);
        return o(iterable, Predicates.o(cls));
    }

    @ParametricNullness
    public static <T> T q(Iterable<T> iterable, Predicate<? super T> predicate) {
        return (T) Iterators.z(iterable.iterator(), predicate);
    }

    @CheckForNull
    public static <T> T r(Iterable<? extends T> iterable, Predicate<? super T> predicate, @CheckForNull T t) {
        return (T) Iterators.A(iterable.iterator(), predicate, t);
    }

    public static int s(Iterable<?> iterable, @CheckForNull Object obj) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).count(obj);
        }
        return iterable instanceof Set ? ((Set) iterable).contains(obj) ? 1 : 0 : Iterators.E(iterable.iterator(), obj);
    }

    @ParametricNullness
    public static <T> T t(Iterable<T> iterable, int i2) {
        com.google.common.base.i.E(iterable);
        return iterable instanceof List ? (T) ((List) iterable).get(i2) : (T) Iterators.F(iterable.iterator(), i2);
    }

    @ParametricNullness
    public static <T> T u(Iterable<? extends T> iterable, int i2, @ParametricNullness T t) {
        com.google.common.base.i.E(iterable);
        Iterators.g(i2);
        if (iterable instanceof List) {
            List listF = Lists.f(iterable);
            return i2 < listF.size() ? (T) listF.get(i2) : t;
        }
        Iterator<? extends T> it = iterable.iterator();
        Iterators.b(it, i2);
        return (T) Iterators.J(it, t);
    }

    @ParametricNullness
    public static <T> T v(Iterable<? extends T> iterable, @ParametricNullness T t) {
        return (T) Iterators.J(iterable.iterator(), t);
    }

    @ParametricNullness
    public static <T> T w(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) Iterators.H(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) y(list);
    }

    @ParametricNullness
    public static <T> T x(Iterable<? extends T> iterable, @ParametricNullness T t) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                return (T) y(Lists.f(iterable));
            }
        }
        return (T) Iterators.I(iterable.iterator(), t);
    }

    @ParametricNullness
    public static <T> T y(List<T> list) {
        return list.get(list.size() - 1);
    }

    @ParametricNullness
    public static <T> T z(Iterable<T> iterable) {
        return (T) Iterators.K(iterable.iterator());
    }
}
