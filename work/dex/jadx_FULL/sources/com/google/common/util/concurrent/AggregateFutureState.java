package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.ReflectionSupport;
import com.zj.adlib.fr;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicHelper f32328a;
    public static final Logger b = Logger.getLogger(AggregateFutureState.class.getName());
    public volatile int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @CheckForNull
    public volatile Set<Throwable> f6501a = null;

    public static abstract class AtomicHelper {
        public AtomicHelper() {
        }

        public abstract void a(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2);

        public abstract int b(AggregateFutureState<?> aggregateFutureState);
    }

    public static final class b extends AtomicHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicIntegerFieldUpdater<AggregateFutureState<?>> f32329a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicReferenceFieldUpdater<AggregateFutureState<?>, Set<Throwable>> f6502a;

        public b(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f6502a = atomicReferenceFieldUpdater;
            this.f32329a = atomicIntegerFieldUpdater;
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void a(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            fr.a(this.f6502a, aggregateFutureState, set, set2);
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int b(AggregateFutureState<?> aggregateFutureState) {
            return this.f32329a.decrementAndGet(aggregateFutureState);
        }
    }

    public static final class c extends AtomicHelper {
        public c() {
            super();
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public void a(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (aggregateFutureState.f6501a == set) {
                    aggregateFutureState.f6501a = set2;
                }
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFutureState.AtomicHelper
        public int b(AggregateFutureState<?> aggregateFutureState) {
            int iC;
            synchronized (aggregateFutureState) {
                iC = AggregateFutureState.C(aggregateFutureState);
            }
            return iC;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        AtomicHelper cVar;
        Throwable th = null;
        Object[] objArr = 0;
        try {
            cVar = new b(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "a"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "K"));
        } catch (Throwable th2) {
            cVar = new c();
            th = th2;
        }
        f32328a = cVar;
        if (th != null) {
            b.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    public AggregateFutureState(int i) {
        this.K = i;
    }

    public static /* synthetic */ int C(AggregateFutureState aggregateFutureState) {
        int i = aggregateFutureState.K - 1;
        aggregateFutureState.K = i;
        return i;
    }

    public abstract void D(Set<Throwable> set);

    public final void E() {
        this.f6501a = null;
    }

    public final int F() {
        return f32328a.b(this);
    }

    public final Set<Throwable> G() {
        Set<Throwable> set = this.f6501a;
        if (set != null) {
            return set;
        }
        Set<Throwable> setP = Sets.p();
        D(setP);
        f32328a.a(this, null, setP);
        Set<Throwable> set2 = this.f6501a;
        Objects.requireNonNull(set2);
        return set2;
    }
}
