package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class p<E> extends AbstractQueue<E> {
    public static final int N = 1431655765;
    public static final int O = -1431655766;
    public static final int P = 11;

    @VisibleForTesting
    public final int K;
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p<E>.c f32002a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Object[] f6213a;
    public final p<E>.c b;

    @Beta
    public static final class b<B> {
        public static final int c = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f32003a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Comparator<B> f6214a;
        public int b;

        public <T extends B> p<T> c() {
            return d(Collections.emptySet());
        }

        public <T extends B> p<T> d(Iterable<? extends T> iterable) {
            p<T> pVar = new p<>(this, p.t(this.f32003a, this.b, iterable));
            Iterator<? extends T> it = iterable.iterator();
            while (it.hasNext()) {
                pVar.offer(it.next());
            }
            return pVar;
        }

        @CanIgnoreReturnValue
        public b<B> e(int i) {
            com.google.common.base.i.d(i >= 0);
            this.f32003a = i;
            return this;
        }

        @CanIgnoreReturnValue
        public b<B> f(int i) {
            com.google.common.base.i.d(i > 0);
            this.b = i;
            return this;
        }

        public final <T extends B> Ordering<T> g() {
            return Ordering.from(this.f6214a);
        }

        public b(Comparator<B> comparator) {
            this.f32003a = -1;
            this.b = Integer.MAX_VALUE;
            this.f6214a = (Comparator) com.google.common.base.i.E(comparator);
        }
    }

    public class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Ordering<E> f32004a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Weak
        public p<E>.c f6215a;

        public c(Ordering<E> ordering) {
            this.f32004a = ordering;
        }

        public void b(int i, E e) {
            c cVar;
            int iF = f(i, e);
            if (iF == i) {
                iF = i;
                cVar = this;
            } else {
                cVar = this.f6215a;
            }
            cVar.c(iF, e);
        }

        @CanIgnoreReturnValue
        public int c(int i, E e) {
            while (i > 2) {
                int iK = k(i);
                Object objI = p.this.i(iK);
                if (this.f32004a.compare((E) objI, e) <= 0) {
                    break;
                }
                p.this.f6213a[i] = objI;
                i = iK;
            }
            p.this.f6213a[i] = e;
            return i;
        }

        public int d(int i, int i2) {
            return this.f32004a.compare((E) p.this.i(i), (E) p.this.i(i2));
        }

        public int e(int i, E e) {
            int i2 = i(i);
            if (i2 <= 0 || this.f32004a.compare((E) p.this.i(i2), e) >= 0) {
                return f(i, e);
            }
            p.this.f6213a[i] = p.this.i(i2);
            p.this.f6213a[i2] = e;
            return i2;
        }

        public int f(int i, E e) {
            int iN;
            if (i == 0) {
                p.this.f6213a[0] = e;
                return 0;
            }
            int iM = m(i);
            Object objI = p.this.i(iM);
            if (iM != 0 && (iN = n(m(iM))) != iM && l(iN) >= p.this.L) {
                Object objI2 = p.this.i(iN);
                if (this.f32004a.compare((E) objI2, (E) objI) < 0) {
                    iM = iN;
                    objI = objI2;
                }
            }
            if (this.f32004a.compare((E) objI, e) >= 0) {
                p.this.f6213a[i] = e;
                return i;
            }
            p.this.f6213a[i] = objI;
            p.this.f6213a[iM] = e;
            return iM;
        }

        public int g(int i) {
            while (true) {
                int iJ = j(i);
                if (iJ <= 0) {
                    return i;
                }
                p.this.f6213a[i] = p.this.i(iJ);
                i = iJ;
            }
        }

        public int h(int i, int i2) {
            if (i >= p.this.L) {
                return -1;
            }
            com.google.common.base.i.g0(i > 0);
            int iMin = Math.min(i, p.this.L - i2) + i2;
            for (int i3 = i + 1; i3 < iMin; i3++) {
                if (d(i3, i) < 0) {
                    i = i3;
                }
            }
            return i;
        }

        public int i(int i) {
            return h(l(i), 2);
        }

        public int j(int i) {
            int iL = l(i);
            if (iL < 0) {
                return -1;
            }
            return h(l(iL), 4);
        }

        public final int k(int i) {
            return m(m(i));
        }

        public final int l(int i) {
            return (i * 2) + 1;
        }

        public final int m(int i) {
            return (i - 1) / 2;
        }

        public final int n(int i) {
            return (i * 2) + 2;
        }

        public int o(E e) {
            int iN;
            int iM = m(p.this.L);
            if (iM != 0 && (iN = n(m(iM))) != iM && l(iN) >= p.this.L) {
                Object objI = p.this.i(iN);
                if (this.f32004a.compare((E) objI, e) < 0) {
                    p.this.f6213a[iN] = e;
                    p.this.f6213a[p.this.L] = objI;
                    return iN;
                }
            }
            return p.this.L;
        }

        @CheckForNull
        public d<E> p(int i, int i2, E e) {
            int iE = e(i2, e);
            if (iE == i2) {
                return null;
            }
            Object objI = iE < i ? p.this.i(i) : p.this.i(m(i));
            if (this.f6215a.c(iE, e) < i) {
                return new d<>(e, objI);
            }
            return null;
        }

        public final boolean q(int i) {
            if (l(i) < p.this.L && d(i, l(i)) > 0) {
                return false;
            }
            if (n(i) < p.this.L && d(i, n(i)) > 0) {
                return false;
            }
            if (i <= 0 || d(i, m(i)) <= 0) {
                return i <= 2 || d(k(i), i) <= 0;
            }
            return false;
        }
    }

    public static class d<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final E f32005a;
        public final E b;

        public d(E e, E e2) {
            this.f32005a = e;
            this.b = e2;
        }
    }

    public class e implements Iterator<E> {
        public int K;
        public int L;
        public int M;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public E f6217a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public List<E> f6218a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @CheckForNull
        public Queue<E> f6219a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f6220a;

        public e() {
            this.K = -1;
            this.L = -1;
            this.M = p.this.M;
        }

        public final void a() {
            if (p.this.M != this.M) {
                throw new ConcurrentModificationException();
            }
        }

        public final boolean b(Iterable<E> iterable, E e) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void c(int i) {
            if (this.L < i) {
                if (this.f6218a != null) {
                    while (i < p.this.size() && b(this.f6218a, p.this.i(i))) {
                        i++;
                    }
                }
                this.L = i;
            }
        }

        public final boolean d(Object obj) {
            for (int i = 0; i < p.this.L; i++) {
                if (p.this.f6213a[i] == obj) {
                    p.this.B(i);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            c(this.K + 1);
            if (this.L < p.this.size()) {
                return true;
            }
            Queue<E> queue = this.f6219a;
            return (queue == null || queue.isEmpty()) ? false : true;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            c(this.K + 1);
            if (this.L < p.this.size()) {
                int i = this.L;
                this.K = i;
                this.f6220a = true;
                return (E) p.this.i(i);
            }
            if (this.f6219a != null) {
                this.K = p.this.size();
                E ePoll = this.f6219a.poll();
                this.f6217a = ePoll;
                if (ePoll != null) {
                    this.f6220a = true;
                    return ePoll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            com.google.common.collect.a.e(this.f6220a);
            a();
            this.f6220a = false;
            this.M++;
            if (this.K >= p.this.size()) {
                E e = this.f6217a;
                Objects.requireNonNull(e);
                com.google.common.base.i.g0(d(e));
                this.f6217a = null;
                return;
            }
            d<E> dVarB = p.this.B(this.K);
            if (dVarB != null) {
                if (this.f6219a == null || this.f6218a == null) {
                    this.f6219a = new ArrayDeque();
                    this.f6218a = new ArrayList(3);
                }
                if (!b(this.f6218a, dVarB.f32005a)) {
                    this.f6219a.add(dVarB.f32005a);
                }
                if (!b(this.f6219a, dVarB.b)) {
                    this.f6218a.add(dVarB.b);
                }
            }
            this.K--;
            this.L--;
        }
    }

    public static int e(int i, int i2) {
        return Math.min(i - 1, i2) + 1;
    }

    public static <E extends Comparable<E>> p<E> g() {
        return new b(Ordering.natural()).c();
    }

    public static <E extends Comparable<E>> p<E> h(Iterable<? extends E> iterable) {
        return new b(Ordering.natural()).d(iterable);
    }

    public static b<Comparable> j(int i) {
        return new b(Ordering.natural()).e(i);
    }

    @VisibleForTesting
    public static int t(int i, int i2, Iterable<?> iterable) {
        if (i == -1) {
            i = 11;
        }
        if (iterable instanceof Collection) {
            i = Math.max(i, ((Collection) iterable).size());
        }
        return e(i, i2);
    }

    @VisibleForTesting
    public static boolean u(int i) {
        int i2 = ~(~(i + 1));
        com.google.common.base.i.h0(i2 > 0, "negative index");
        return (1431655765 & i2) > (i2 & O);
    }

    public static b<Comparable> x(int i) {
        return new b(Ordering.natural()).f(i);
    }

    public static <B> b<B> z(Comparator<B> comparator) {
        return new b<>(comparator);
    }

    public final E A(int i) {
        E eI = i(i);
        B(i);
        return eI;
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    @CheckForNull
    public d<E> B(int i) {
        com.google.common.base.i.d0(i, this.L);
        this.M++;
        int i2 = this.L - 1;
        this.L = i2;
        if (i2 == i) {
            this.f6213a[i2] = null;
            return null;
        }
        E eI = i(i2);
        int iO = q(this.L).o(eI);
        if (iO == i) {
            this.f6213a[this.L] = null;
            return null;
        }
        E eI2 = i(this.L);
        this.f6213a[this.L] = null;
        d<E> dVarM = m(i, eI2);
        if (iO < i) {
            return dVarM == null ? new d<>(eI, eI2) : new d<>(eI, dVarM.b);
        }
        return dVarM;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e2) {
        offer(e2);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            offer(it.next());
            z = true;
        }
        return z;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i = 0; i < this.L; i++) {
            this.f6213a[i] = null;
        }
        this.L = 0;
    }

    public Comparator<? super E> comparator() {
        return this.f32002a.f32004a;
    }

    public final int d() {
        int length = this.f6213a.length;
        return e(length < 64 ? (length + 1) * 2 : com.google.common.math.e.d(length / 2, 3), this.K);
    }

    @VisibleForTesting
    public int f() {
        return this.f6213a.length;
    }

    public E i(int i) {
        E e2 = (E) this.f6213a[i];
        Objects.requireNonNull(e2);
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new e();
    }

    @CheckForNull
    public final d<E> m(int i, E e2) {
        p<E>.c cVarQ = q(i);
        int iG = cVarQ.g(i);
        int iC = cVarQ.c(iG, e2);
        if (iC == iG) {
            return cVarQ.p(i, iG, e2);
        }
        if (iC < i) {
            return new d<>(e2, i(i));
        }
        return null;
    }

    public final int n() {
        int i = this.L;
        if (i != 1) {
            return (i == 2 || this.b.d(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    public final void o() {
        if (this.L > this.f6213a.length) {
            Object[] objArr = new Object[d()];
            Object[] objArr2 = this.f6213a;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f6213a = objArr;
        }
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e2) {
        com.google.common.base.i.E(e2);
        this.M++;
        int i = this.L;
        this.L = i + 1;
        o();
        q(i).b(i, e2);
        return this.L <= this.K || pollLast() != e2;
    }

    @Override // java.util.Queue
    @CheckForNull
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return i(0);
    }

    @CheckForNull
    public E peekFirst() {
        return peek();
    }

    @CheckForNull
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return i(n());
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    @CheckForNull
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return A(0);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return A(n());
    }

    public final p<E>.c q(int i) {
        return u(i) ? this.f32002a : this.b;
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return A(n());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.L;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i = this.L;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f6213a, 0, objArr, 0, i);
        return objArr;
    }

    @VisibleForTesting
    public boolean w() {
        for (int i = 1; i < this.L; i++) {
            if (!q(i).q(i)) {
                return false;
            }
        }
        return true;
    }

    public p(b<? super E> bVar, int i) {
        Ordering orderingG = bVar.g();
        p<E>.c cVar = new c(orderingG);
        this.f32002a = cVar;
        p<E>.c cVar2 = new c(orderingG.reverse());
        this.b = cVar2;
        cVar.f6215a = cVar2;
        cVar2.f6215a = cVar;
        this.K = bVar.b;
        this.f6213a = new Object[i];
    }
}
