package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.zj.adlib.at8;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class Striped<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f32392a = 1024;
    public static final int b = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Supplier<ReadWriteLock> f6568a = new e();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Supplier<ReadWriteLock> f6569b = new f();

    public static class PaddedLock extends ReentrantLock {
        long unused1;
        long unused2;
        long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    public static class PaddedSemaphore extends Semaphore {
        long unused1;
        long unused2;
        long unused3;

        public PaddedSemaphore(int i) {
            super(i, false);
        }
    }

    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        public final int c;

        public PowerOfTwoStriped(int i) {
            super(null);
            com.google.common.base.i.e(i > 0, "Stripes must be positive");
            this.c = i > 1073741824 ? -1 : Striped.d(i) - 1;
        }

        @Override // com.google.common.util.concurrent.Striped
        public final L f(Object obj) {
            return g(h(obj));
        }

        @Override // com.google.common.util.concurrent.Striped
        public final int h(Object obj) {
            return Striped.q(obj.hashCode()) & this.c;
        }
    }

    public class a implements Supplier<Lock> {
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Lock get() {
            return new PaddedLock();
        }
    }

    public class b implements Supplier<Lock> {
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Lock get() {
            return new ReentrantLock(false);
        }
    }

    public class c implements Supplier<Semaphore> {
        public final /* synthetic */ int K;

        public c(int i) {
            this.K = i;
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Semaphore get() {
            return new PaddedSemaphore(this.K);
        }
    }

    public class d implements Supplier<Semaphore> {
        public final /* synthetic */ int K;

        public d(int i) {
            this.K = i;
        }

        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Semaphore get() {
            return new Semaphore(this.K, false);
        }
    }

    public class e implements Supplier<ReadWriteLock> {
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadWriteLock get() {
            return new ReentrantReadWriteLock();
        }
    }

    public class f implements Supplier<ReadWriteLock> {
        @Override // com.google.common.base.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ReadWriteLock get() {
            return new l();
        }
    }

    public static class g<L> extends PowerOfTwoStriped<L> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object[] f32393a;

        public /* synthetic */ g(int i, Supplier supplier, a aVar) {
            this(i, supplier);
        }

        @Override // com.google.common.util.concurrent.Striped
        public L g(int i) {
            return (L) this.f32393a[i];
        }

        @Override // com.google.common.util.concurrent.Striped
        public int p() {
            return this.f32393a.length;
        }

        public g(int i, Supplier<L> supplier) {
            super(i);
            int i2 = 0;
            com.google.common.base.i.e(i <= 1073741824, "Stripes must be <= 2^30)");
            this.f32393a = new Object[this.c + 1];
            while (true) {
                Object[] objArr = this.f32393a;
                if (i2 >= objArr.length) {
                    return;
                }
                objArr[i2] = supplier.get();
                i2++;
            }
        }
    }

    @VisibleForTesting
    public static class h<L> extends PowerOfTwoStriped<L> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentMap<Integer, L> f32394a;
        public final Supplier<L> c;
        public final int d;

        public h(int i, Supplier<L> supplier) {
            super(i);
            int i2 = super.c;
            this.d = i2 == -1 ? Integer.MAX_VALUE : i2 + 1;
            this.c = supplier;
            this.f32394a = new MapMaker().m().i();
        }

        @Override // com.google.common.util.concurrent.Striped
        public L g(int i) {
            if (this.d != Integer.MAX_VALUE) {
                com.google.common.base.i.C(i, p());
            }
            L l = this.f32394a.get(Integer.valueOf(i));
            if (l != null) {
                return l;
            }
            L l2 = this.c.get();
            return (L) com.google.common.base.e.a(this.f32394a.putIfAbsent(Integer.valueOf(i), l2), l2);
        }

        @Override // com.google.common.util.concurrent.Striped
        public int p() {
            return this.d;
        }
    }

    @VisibleForTesting
    public static class i<L> extends PowerOfTwoStriped<L> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceQueue<L> f32395a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicReferenceArray<a<? extends L>> f6570a;
        public final Supplier<L> c;
        public final int d;

        public static final class a<L> extends WeakReference<L> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f32396a;

            public a(L l, int i, ReferenceQueue<L> referenceQueue) {
                super(l, referenceQueue);
                this.f32396a = i;
            }
        }

        public i(int i, Supplier<L> supplier) {
            super(i);
            this.f32395a = new ReferenceQueue<>();
            int i2 = super.c;
            int i3 = i2 == -1 ? Integer.MAX_VALUE : i2 + 1;
            this.d = i3;
            this.f6570a = new AtomicReferenceArray<>(i3);
            this.c = supplier;
        }

        @Override // com.google.common.util.concurrent.Striped
        public L g(int i) {
            if (this.d != Integer.MAX_VALUE) {
                com.google.common.base.i.C(i, p());
            }
            a<? extends L> aVar = this.f6570a.get(i);
            L l = aVar == null ? null : aVar.get();
            if (l != null) {
                return l;
            }
            L l2 = this.c.get();
            a aVar2 = new a(l2, i, this.f32395a);
            while (!at8.a(this.f6570a, i, aVar, aVar2)) {
                aVar = this.f6570a.get(i);
                L l3 = aVar == null ? null : aVar.get();
                if (l3 != null) {
                    return l3;
                }
            }
            r();
            return l2;
        }

        @Override // com.google.common.util.concurrent.Striped
        public int p() {
            return this.d;
        }

        public final void r() {
            while (true) {
                Reference<? extends L> referencePoll = this.f32395a.poll();
                if (referencePoll == null) {
                    return;
                }
                a aVar = (a) referencePoll;
                at8.a(this.f6570a, aVar.f32396a, aVar, null);
            }
        }
    }

    public static final class j extends ForwardingCondition {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f32397a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Condition f6571a;

        public j(Condition condition, l lVar) {
            this.f6571a = condition;
            this.f32397a = lVar;
        }

        @Override // com.google.common.util.concurrent.ForwardingCondition
        public Condition a() {
            return this.f6571a;
        }
    }

    public static final class k extends ForwardingLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f32398a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Lock f6572a;

        public k(Lock lock, l lVar) {
            this.f6572a = lock;
            this.f32398a = lVar;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock
        public Lock a() {
            return this.f6572a;
        }

        @Override // com.google.common.util.concurrent.ForwardingLock, java.util.concurrent.locks.Lock
        public Condition newCondition() {
            return new j(this.f6572a.newCondition(), this.f32398a);
        }
    }

    public static final class l implements ReadWriteLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReadWriteLock f32399a = new ReentrantReadWriteLock();

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock readLock() {
            return new k(this.f32399a.readLock(), this);
        }

        @Override // java.util.concurrent.locks.ReadWriteLock
        public Lock writeLock() {
            return new k(this.f32399a.writeLock(), this);
        }
    }

    public /* synthetic */ Striped(a aVar) {
        this();
    }

    public static int d(int i2) {
        return 1 << com.google.common.math.e.p(i2, RoundingMode.CEILING);
    }

    public static <L> Striped<L> e(int i2, Supplier<L> supplier) {
        return new g(i2, supplier, null);
    }

    public static <L> Striped<L> i(int i2, Supplier<L> supplier) {
        return i2 < 1024 ? new i(i2, supplier) : new h(i2, supplier);
    }

    public static Striped<Lock> j(int i2) {
        return i(i2, new b());
    }

    public static Striped<ReadWriteLock> k(int i2) {
        return i(i2, f6569b);
    }

    public static Striped<Semaphore> l(int i2, int i3) {
        return i(i2, new d(i3));
    }

    public static Striped<Lock> m(int i2) {
        return e(i2, new a());
    }

    public static Striped<ReadWriteLock> n(int i2) {
        return e(i2, f6568a);
    }

    public static Striped<Semaphore> o(int i2, int i3) {
        return e(i2, new c(i3));
    }

    public static int q(int i2) {
        int i3 = i2 ^ ((i2 >>> 20) ^ (i2 >>> 12));
        return (i3 >>> 4) ^ ((i3 >>> 7) ^ i3);
    }

    public Iterable<L> c(Iterable<? extends Object> iterable) {
        ArrayList arrayListR = Lists.r(iterable);
        if (arrayListR.isEmpty()) {
            return ImmutableList.of();
        }
        int[] iArr = new int[arrayListR.size()];
        for (int i2 = 0; i2 < arrayListR.size(); i2++) {
            iArr[i2] = h(arrayListR.get(i2));
        }
        Arrays.sort(iArr);
        int i3 = iArr[0];
        arrayListR.set(0, g(i3));
        for (int i4 = 1; i4 < arrayListR.size(); i4++) {
            int i5 = iArr[i4];
            if (i5 == i3) {
                arrayListR.set(i4, arrayListR.get(i4 - 1));
            } else {
                arrayListR.set(i4, g(i5));
                i3 = i5;
            }
        }
        return Collections.unmodifiableList(arrayListR);
    }

    public abstract L f(Object obj);

    public abstract L g(int i2);

    public abstract int h(Object obj);

    public abstract int p();

    public Striped() {
    }
}
