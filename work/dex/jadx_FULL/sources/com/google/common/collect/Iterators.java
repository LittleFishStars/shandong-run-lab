package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.zj.adlib.dv9;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Iterators {

    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.a.e(false);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends UnmodifiableIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Enumeration f31744a;

        public a(Enumeration enumeration) {
            this.f31744a = enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31744a.hasMoreElements();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            return (T) this.f31744a.nextElement();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements Enumeration<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f31745a;

        public b(Iterator it) {
            this.f31745a = it;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f31745a.hasNext();
        }

        @Override // java.util.Enumeration
        @ParametricNullness
        public T nextElement() {
            return (T) this.f31745a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class c<T> extends UnmodifiableIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f31746a;

        public c(Iterator it) {
            this.f31746a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31746a.hasNext();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            return (T) this.f31746a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f31747a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Iterator<T> f6076a = Iterators.w();

        public d(Iterable iterable) {
            this.f31747a = iterable;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6076a.hasNext() || this.f31747a.iterator().hasNext();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (!this.f6076a.hasNext()) {
                Iterator<T> it = this.f31747a.iterator();
                this.f6076a = it;
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
            }
            return this.f6076a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f6076a.remove();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    public class e<I> extends UnmodifiableIterator<I> {
        public int K = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator[] f31748a;

        public e(Iterator[] itArr) {
            this.f31748a = itArr;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TI; */
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Iterator next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator it = this.f31748a[this.K];
            Objects.requireNonNull(it);
            Iterator it2 = it;
            Iterator[] itArr = this.f31748a;
            int i = this.K;
            itArr[i] = null;
            this.K = i + 1;
            return it2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.K < this.f31748a.length;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class f<T> extends UnmodifiableIterator<List<T>> {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f31749a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f6077a;

        public f(Iterator it, int i, boolean z) {
            this.f31749a = it;
            this.K = i;
            this.f6077a = z;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object[] objArr = new Object[this.K];
            int i = 0;
            while (i < this.K && this.f31749a.hasNext()) {
                objArr[i] = this.f31749a.next();
                i++;
            }
            for (int i2 = i; i2 < this.K; i2++) {
                objArr[i2] = null;
            }
            List<T> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
            return (this.f6077a || i == this.K) ? listUnmodifiableList : listUnmodifiableList.subList(0, i);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31749a.hasNext();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class g<T> extends AbstractIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Predicate f31750a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Iterator f6078a;

        public g(Iterator it, Predicate predicate) {
            this.f6078a = it;
            this.f31750a = predicate;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        public T computeNext() {
            while (this.f6078a.hasNext()) {
                T t = (T) this.f6078a.next();
                if (this.f31750a.apply(t)) {
                    return t;
                }
            }
            return endOfData();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    public class h<F, T> extends TransformedIterator<F, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function f31751a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Iterator it, Function function) {
            super(it);
            this.f31751a = function;
        }

        @Override // com.google.common.collect.TransformedIterator
        @ParametricNullness
        public T a(@ParametricNullness F f) {
            return (T) this.f31751a.apply(f);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class i<T> implements Iterator<T> {
        public int K;
        public final /* synthetic */ int L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f31752a;

        public i(int i, Iterator it) {
            this.L = i;
            this.f31752a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.K < this.L && this.f31752a.hasNext();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.K++;
            return (T) this.f31752a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f31752a.remove();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class j<T> extends UnmodifiableIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f31753a;

        public j(Iterator it) {
            this.f31753a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f31753a.hasNext();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            T t = (T) this.f31753a.next();
            this.f31753a.remove();
            return t;
        }

        public String toString() {
            return "Iterators.consumingIterator(...)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class k<T> extends UnmodifiableIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f31754a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f6079a;

        public k(Object obj) {
            this.f31754a = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f6079a;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (this.f6079a) {
                throw new NoSuchElementException();
            }
            this.f6079a = true;
            return (T) this.f31754a;
        }
    }

    public static final class l<T> extends AbstractIndexedListIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final UnmodifiableListIterator<Object> f31755a = new l(new Object[0], 0, 0, 0);
        public final int M;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final T[] f6080a;

        public l(T[] tArr, int i, int i2, int i3) {
            super(i2, i3);
            this.f6080a = tArr;
            this.M = i;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        @ParametricNullness
        public T get(int i) {
            return this.f6080a[this.M + i];
        }
    }

    public static class m<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public Deque<Iterator<? extends Iterator<? extends T>>> f31756a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public Iterator<? extends T> f6081a;
        public Iterator<? extends T> b = Iterators.u();

        @CheckForNull
        public Iterator<? extends Iterator<? extends T>> c;

        public m(Iterator<? extends Iterator<? extends T>> it) {
            this.c = (Iterator) com.google.common.base.i.E(it);
        }

        @CheckForNull
        public final Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.c;
                if (it != null && it.hasNext()) {
                    return this.c;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f31756a;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.c = this.f31756a.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) com.google.common.base.i.E(this.b)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> itA = a();
                this.c = itA;
                if (itA == null) {
                    return false;
                }
                Iterator<? extends T> next = itA.next();
                this.b = next;
                if (next instanceof m) {
                    m mVar = (m) next;
                    this.b = mVar.b;
                    if (this.f31756a == null) {
                        this.f31756a = new ArrayDeque();
                    }
                    this.f31756a.addFirst(this.c);
                    if (mVar.f31756a != null) {
                        while (!mVar.f31756a.isEmpty()) {
                            this.f31756a.addFirst(mVar.f31756a.removeLast());
                        }
                    }
                    this.c = mVar.c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends T> it = this.b;
            this.f6081a = it;
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator<? extends T> it = this.f6081a;
            if (it == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            it.remove();
            this.f6081a = null;
        }
    }

    public static class n<T> extends UnmodifiableIterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<PeekingIterator<T>> f31757a;

        public class a implements Comparator<PeekingIterator<T>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Comparator f31758a;

            public a(n nVar, Comparator comparator) {
                this.f31758a = comparator;
            }

            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(PeekingIterator<T> peekingIterator, PeekingIterator<T> peekingIterator2) {
                return this.f31758a.compare(peekingIterator.peek(), peekingIterator2.peek());
            }
        }

        public n(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.f31757a = new PriorityQueue(2, new a(this, comparator));
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f31757a.add(Iterators.T(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f31757a.isEmpty();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            PeekingIterator<T> peekingIteratorRemove = this.f31757a.remove();
            T next = peekingIteratorRemove.next();
            if (peekingIteratorRemove.hasNext()) {
                this.f31757a.add(peekingIteratorRemove);
            }
            return next;
        }
    }

    public static class o<E> implements PeekingIterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public E f31759a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Iterator<? extends E> f6082a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f6083a;

        public o(Iterator<? extends E> it) {
            this.f6082a = (Iterator) com.google.common.base.i.E(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6083a || this.f6082a.hasNext();
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        @ParametricNullness
        public E next() {
            if (!this.f6083a) {
                return this.f6082a.next();
            }
            E e = (E) q.a(this.f31759a);
            this.f6083a = false;
            this.f31759a = null;
            return e;
        }

        @Override // com.google.common.collect.PeekingIterator
        @ParametricNullness
        public E peek() {
            if (!this.f6083a) {
                this.f31759a = this.f6082a.next();
                this.f6083a = true;
            }
            return (E) q.a(this.f31759a);
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public void remove() {
            com.google.common.base.i.h0(!this.f6083a, "Can't remove after you've peeked at next");
            this.f6082a.remove();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @CheckForNull
    public static <T> T A(Iterator<? extends T> it, Predicate<? super T> predicate, @CheckForNull T t) {
        com.google.common.base.i.E(it);
        com.google.common.base.i.E(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return t;
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> B(T... tArr) {
        return C(tArr, 0, tArr.length, 0);
    }

    public static <T> UnmodifiableListIterator<T> C(T[] tArr, int i2, int i3, int i4) {
        com.google.common.base.i.d(i3 >= 0);
        com.google.common.base.i.f0(i2, i2 + i3, tArr.length);
        com.google.common.base.i.d0(i4, i3);
        return i3 == 0 ? v() : new l(tArr, i2, i3, i4);
    }

    public static <T> UnmodifiableIterator<T> D(Enumeration<T> enumeration) {
        com.google.common.base.i.E(enumeration);
        return new a(enumeration);
    }

    public static int E(Iterator<?> it, @CheckForNull Object obj) {
        int i2 = 0;
        while (q(it, obj)) {
            i2++;
        }
        return i2;
    }

    @ParametricNullness
    public static <T> T F(Iterator<T> it, int i2) {
        g(i2);
        int iB = b(it, i2);
        if (it.hasNext()) {
            return it.next();
        }
        StringBuilder sb = new StringBuilder(91);
        sb.append("position (");
        sb.append(i2);
        sb.append(") must be less than the number of elements that remained (");
        sb.append(iB);
        sb.append(")");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    @ParametricNullness
    public static <T> T G(Iterator<? extends T> it, int i2, @ParametricNullness T t) {
        g(i2);
        b(it, i2);
        return (T) J(it, t);
    }

    @ParametricNullness
    public static <T> T H(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    @ParametricNullness
    public static <T> T I(Iterator<? extends T> it, @ParametricNullness T t) {
        return it.hasNext() ? (T) H(it) : t;
    }

    @ParametricNullness
    public static <T> T J(Iterator<? extends T> it, @ParametricNullness T t) {
        return it.hasNext() ? it.next() : t;
    }

    @ParametricNullness
    public static <T> T K(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i2 = 0; i2 < 4 && it.hasNext(); i2++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append(dv9.b);
        throw new IllegalArgumentException(sb.toString());
    }

    @ParametricNullness
    public static <T> T L(Iterator<? extends T> it, @ParametricNullness T t) {
        return it.hasNext() ? (T) K(it) : t;
    }

    public static <T> int M(Iterator<T> it, Predicate<? super T> predicate) {
        com.google.common.base.i.F(predicate, "predicate");
        int i2 = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static <T> Iterator<T> N(Iterator<T> it, int i2) {
        com.google.common.base.i.E(it);
        com.google.common.base.i.e(i2 >= 0, "limit is negative");
        return new i(i2, it);
    }

    @Beta
    public static <T> UnmodifiableIterator<T> O(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        com.google.common.base.i.F(iterable, "iterators");
        com.google.common.base.i.F(comparator, "comparator");
        return new n(iterable, comparator);
    }

    public static <T> UnmodifiableIterator<List<T>> P(Iterator<T> it, int i2) {
        return R(it, i2, true);
    }

    public static <T> UnmodifiableIterator<List<T>> Q(Iterator<T> it, int i2) {
        return R(it, i2, false);
    }

    public static <T> UnmodifiableIterator<List<T>> R(Iterator<T> it, int i2, boolean z) {
        com.google.common.base.i.E(it);
        com.google.common.base.i.d(i2 > 0);
        return new f(it, i2, z);
    }

    @Deprecated
    public static <T> PeekingIterator<T> S(PeekingIterator<T> peekingIterator) {
        return (PeekingIterator) com.google.common.base.i.E(peekingIterator);
    }

    public static <T> PeekingIterator<T> T(Iterator<? extends T> it) {
        return it instanceof o ? (o) it : new o(it);
    }

    @CheckForNull
    public static <T> T U(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    @CanIgnoreReturnValue
    public static boolean V(Iterator<?> it, Collection<?> collection) {
        com.google.common.base.i.E(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static <T> boolean W(Iterator<T> it, Predicate<? super T> predicate) {
        com.google.common.base.i.E(predicate);
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean X(Iterator<?> it, Collection<?> collection) {
        com.google.common.base.i.E(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> UnmodifiableIterator<T> Y(@ParametricNullness T t) {
        return new k(t);
    }

    public static int Z(Iterator<?> it) {
        long j2 = 0;
        while (it.hasNext()) {
            it.next();
            j2++;
        }
        return Ints.x(j2);
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        com.google.common.base.i.E(collection);
        com.google.common.base.i.E(it);
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= collection.add(it.next());
        }
        return zAdd;
    }

    @GwtIncompatible
    public static <T> T[] a0(Iterator<? extends T> it, Class<T> cls) {
        return (T[]) com.google.common.collect.o.Q(Lists.s(it), cls);
    }

    @CanIgnoreReturnValue
    public static int b(Iterator<?> it, int i2) {
        com.google.common.base.i.E(it);
        int i3 = 0;
        com.google.common.base.i.e(i2 >= 0, "numberToAdvance must be nonnegative");
        while (i3 < i2 && it.hasNext()) {
            it.next();
            i3++;
        }
        return i3;
    }

    public static String b0(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z = true;
        while (it.hasNext()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(it.next());
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public static <T> boolean c(Iterator<T> it, Predicate<? super T> predicate) {
        com.google.common.base.i.E(predicate);
        while (it.hasNext()) {
            if (!predicate.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <F, T> Iterator<T> c0(Iterator<F> it, Function<? super F, ? extends T> function) {
        com.google.common.base.i.E(function);
        return new h(it, function);
    }

    public static <T> boolean d(Iterator<T> it, Predicate<? super T> predicate) {
        return M(it, predicate) != -1;
    }

    public static <T> Optional<T> d0(Iterator<T> it, Predicate<? super T> predicate) {
        com.google.common.base.i.E(it);
        com.google.common.base.i.E(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return Optional.of(next);
            }
        }
        return Optional.absent();
    }

    public static <T> Enumeration<T> e(Iterator<T> it) {
        com.google.common.base.i.E(it);
        return new b(it);
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> e0(UnmodifiableIterator<T> unmodifiableIterator) {
        return (UnmodifiableIterator) com.google.common.base.i.E(unmodifiableIterator);
    }

    public static <T> ListIterator<T> f(Iterator<T> it) {
        return (ListIterator) it;
    }

    public static <T> UnmodifiableIterator<T> f0(Iterator<? extends T> it) {
        com.google.common.base.i.E(it);
        return it instanceof UnmodifiableIterator ? (UnmodifiableIterator) it : new c(it);
    }

    public static void g(int i2) {
        if (i2 >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("position (");
        sb.append(i2);
        sb.append(") must not be negative");
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public static void h(Iterator<?> it) {
        com.google.common.base.i.E(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> i(Iterator<? extends Iterator<? extends T>> it) {
        return new m(it);
    }

    public static <T> Iterator<T> j(Iterator<? extends T> it, Iterator<? extends T> it2) {
        com.google.common.base.i.E(it);
        com.google.common.base.i.E(it2);
        return i(o(it, it2));
    }

    public static <T> Iterator<T> k(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3) {
        com.google.common.base.i.E(it);
        com.google.common.base.i.E(it2);
        com.google.common.base.i.E(it3);
        return i(o(it, it2, it3));
    }

    public static <T> Iterator<T> l(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4) {
        com.google.common.base.i.E(it);
        com.google.common.base.i.E(it2);
        com.google.common.base.i.E(it3);
        com.google.common.base.i.E(it4);
        return i(o(it, it2, it3, it4));
    }

    public static <T> Iterator<T> m(Iterator<? extends T>... itArr) {
        return n((Iterator[]) Arrays.copyOf(itArr, itArr.length));
    }

    public static <T> Iterator<T> n(Iterator<? extends T>... itArr) {
        for (Iterator it : (Iterator[]) com.google.common.base.i.E(itArr)) {
            com.google.common.base.i.E(it);
        }
        return i(o(itArr));
    }

    public static <I extends Iterator<?>> Iterator<I> o(I... iArr) {
        return new e(iArr);
    }

    public static <T> Iterator<T> p(Iterator<T> it) {
        com.google.common.base.i.E(it);
        return new j(it);
    }

    public static boolean q(Iterator<?> it, @CheckForNull Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterator<T> r(Iterable<T> iterable) {
        com.google.common.base.i.E(iterable);
        return new d(iterable);
    }

    @SafeVarargs
    public static <T> Iterator<T> s(T... tArr) {
        return r(Lists.t(tArr));
    }

    public static boolean t(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !com.google.common.base.g.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static <T> UnmodifiableIterator<T> u() {
        return v();
    }

    public static <T> UnmodifiableListIterator<T> v() {
        return (UnmodifiableListIterator<T>) l.f31755a;
    }

    public static <T> Iterator<T> w() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> UnmodifiableIterator<T> x(Iterator<T> it, Predicate<? super T> predicate) {
        com.google.common.base.i.E(it);
        com.google.common.base.i.E(predicate);
        return new g(it, predicate);
    }

    @GwtIncompatible
    public static <T> UnmodifiableIterator<T> y(Iterator<?> it, Class<T> cls) {
        return x(it, Predicates.o(cls));
    }

    @ParametricNullness
    public static <T> T z(Iterator<T> it, Predicate<? super T> predicate) {
        com.google.common.base.i.E(it);
        com.google.common.base.i.E(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }
}
