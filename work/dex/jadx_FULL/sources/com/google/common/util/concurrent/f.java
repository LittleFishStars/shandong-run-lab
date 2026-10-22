package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.internal.InternalFutureFailureAccess;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.zj.adlib.fd4;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class f extends GwtFuturesCatchingSpecialization {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Future f32413a;

        public a(Future future) {
            this.f32413a = future;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f32413a.cancel(false);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [O] */
    public class b<O> implements Future<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function f32414a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Future f6581a;

        public b(Future future, Function function) {
            this.f6581a = future;
            this.f32414a = function;
        }

        public final O a(I i) throws ExecutionException {
            try {
                return (O) this.f32414a.apply(i);
            } catch (Throwable th) {
                throw new ExecutionException(th);
            }
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return this.f6581a.cancel(z);
        }

        @Override // java.util.concurrent.Future
        public O get() throws ExecutionException, InterruptedException {
            return a(this.f6581a.get());
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f6581a.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f6581a.isDone();
        }

        @Override // java.util.concurrent.Future
        public O get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
            return a(this.f6581a.get(j, timeUnit));
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImmutableList f32415a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ g f6582a;

        public c(g gVar, ImmutableList immutableList, int i) {
            this.f6582a = gVar;
            this.f32415a = immutableList;
            this.K = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6582a.f(this.f32415a, this.K);
        }
    }

    public static final class d<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FutureCallback<? super V> f32416a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Future<V> f6583a;

        public d(Future<V> future, FutureCallback<? super V> futureCallback) {
            this.f6583a = future;
            this.f32416a = futureCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thA;
            Future<V> future = this.f6583a;
            if ((future instanceof InternalFutureFailureAccess) && (thA = fd4.a((InternalFutureFailureAccess) future)) != null) {
                this.f32416a.onFailure(thA);
                return;
            }
            try {
                this.f32416a.onSuccess(f.h(this.f6583a));
            } catch (Error e) {
                e = e;
                this.f32416a.onFailure(e);
            } catch (RuntimeException e2) {
                e = e2;
                this.f32416a.onFailure(e);
            } catch (ExecutionException e3) {
                this.f32416a.onFailure(e3.getCause());
            }
        }

        public String toString() {
            return com.google.common.base.e.c(this).s(this.f32416a).toString();
        }
    }

    @Beta
    @GwtCompatible
    @CanIgnoreReturnValue
    public static final class e<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableList<ListenableFuture<? extends V>> f32417a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f6584a;

        public class a implements Callable<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f32418a;

            public a(e eVar, Runnable runnable) {
                this.f32418a = runnable;
            }

            @Override // java.util.concurrent.Callable
            @CheckForNull
            public Void call() throws Exception {
                this.f32418a.run();
                return null;
            }
        }

        public /* synthetic */ e(boolean z, ImmutableList immutableList, a aVar) {
            this(z, immutableList);
        }

        public <C> ListenableFuture<C> a(AsyncCallable<C> asyncCallable, Executor executor) {
            return new CombinedFuture(this.f32417a, this.f6584a, executor, asyncCallable);
        }

        public ListenableFuture<?> b(Runnable runnable, Executor executor) {
            return call(new a(this, runnable), executor);
        }

        @CanIgnoreReturnValue
        public <C> ListenableFuture<C> call(Callable<C> callable, Executor executor) {
            return new CombinedFuture(this.f32417a, this.f6584a, executor, callable);
        }

        public e(boolean z, ImmutableList<ListenableFuture<? extends V>> immutableList) {
            this.f6584a = z;
            this.f32417a = immutableList;
        }
    }

    /* JADX INFO: renamed from: com.google.common.util.concurrent.f$f, reason: collision with other inner class name */
    public static final class C0760f<T> extends AbstractFuture<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public g<T> f32419a;

        public /* synthetic */ C0760f(g gVar, a aVar) {
            this(gVar);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.f32419a = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public boolean cancel(boolean z) {
            g<T> gVar = this.f32419a;
            if (!super.cancel(z)) {
                return false;
            }
            Objects.requireNonNull(gVar);
            gVar.g(z);
            return true;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        @CheckForNull
        public String pendingToString() {
            g<T> gVar = this.f32419a;
            if (gVar == null) {
                return null;
            }
            int length = gVar.f6587a.length;
            int i = gVar.f6585a.get();
            StringBuilder sb = new StringBuilder(49);
            sb.append("inputCount=[");
            sb.append(length);
            sb.append("], remaining=[");
            sb.append(i);
            sb.append("]");
            return sb.toString();
        }

        public C0760f(g<T> gVar) {
            this.f32419a = gVar;
        }
    }

    public static final class g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile int f32420a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicInteger f6585a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f6586a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ListenableFuture<? extends T>[] f6587a;
        public boolean b;

        public /* synthetic */ g(ListenableFuture[] listenableFutureArr, a aVar) {
            this(listenableFutureArr);
        }

        public final void e() {
            if (this.f6585a.decrementAndGet() == 0 && this.f6586a) {
                for (ListenableFuture<? extends T> listenableFuture : this.f6587a) {
                    if (listenableFuture != null) {
                        listenableFuture.cancel(this.b);
                    }
                }
            }
        }

        public final void f(ImmutableList<AbstractFuture<T>> immutableList, int i) {
            ListenableFuture<? extends T> listenableFuture = this.f6587a[i];
            Objects.requireNonNull(listenableFuture);
            ListenableFuture<? extends T> listenableFuture2 = listenableFuture;
            this.f6587a[i] = null;
            for (int i2 = this.f32420a; i2 < immutableList.size(); i2++) {
                if (immutableList.get(i2).setFuture(listenableFuture2)) {
                    e();
                    this.f32420a = i2 + 1;
                    return;
                }
            }
            this.f32420a = immutableList.size();
        }

        public final void g(boolean z) {
            this.f6586a = true;
            if (!z) {
                this.b = false;
            }
            e();
        }

        public g(ListenableFuture<? extends T>[] listenableFutureArr) {
            this.f6586a = false;
            this.b = true;
            this.f32420a = 0;
            this.f6587a = listenableFutureArr;
            this.f6585a = new AtomicInteger(listenableFutureArr.length);
        }
    }

    public static final class h<V> extends AbstractFuture.TrustedFuture<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @CheckForNull
        public ListenableFuture<V> f32421a;

        public h(ListenableFuture<V> listenableFuture) {
            this.f32421a = listenableFuture;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        public void afterDone() {
            this.f32421a = null;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture
        @CheckForNull
        public String pendingToString() {
            ListenableFuture<V> listenableFuture = this.f32421a;
            if (listenableFuture == null) {
                return null;
            }
            String strValueOf = String.valueOf(listenableFuture);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 11);
            sb.append("delegate=[");
            sb.append(strValueOf);
            sb.append("]");
            return sb.toString();
        }

        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<V> listenableFuture = this.f32421a;
            if (listenableFuture != null) {
                setFuture(listenableFuture);
            }
        }
    }

    @SafeVarargs
    @Beta
    public static <V> e<V> A(ListenableFuture<? extends V>... listenableFutureArr) {
        return new e<>(false, ImmutableList.copyOf(listenableFutureArr), null);
    }

    @Beta
    public static <V> e<V> B(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new e<>(true, ImmutableList.copyOf(iterable), null);
    }

    @SafeVarargs
    @Beta
    public static <V> e<V> C(ListenableFuture<? extends V>... listenableFutureArr) {
        return new e<>(true, ImmutableList.copyOf(listenableFutureArr), null);
    }

    @Beta
    @GwtIncompatible
    public static <V> ListenableFuture<V> D(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return listenableFuture.isDone() ? listenableFuture : TimeoutFuture.L(listenableFuture, j, timeUnit, scheduledExecutorService);
    }

    public static void E(Throwable th) {
        if (!(th instanceof Error)) {
            throw new UncheckedExecutionException(th);
        }
        throw new ExecutionError((Error) th);
    }

    public static <V> void a(ListenableFuture<V> listenableFuture, FutureCallback<? super V> futureCallback, Executor executor) {
        com.google.common.base.i.E(futureCallback);
        listenableFuture.addListener(new d(listenableFuture, futureCallback), executor);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> b(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.a(ImmutableList.copyOf(iterable), true);
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> c(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.a(ImmutableList.copyOf(listenableFutureArr), true);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> d(ListenableFuture<? extends V> listenableFuture, Class<X> cls, Function<? super X, ? extends V> function, Executor executor) {
        return AbstractCatchingFuture.I(listenableFuture, cls, function, executor);
    }

    @Partially.GwtIncompatible("AVAILABLE but requires exceptionType to be Throwable.class")
    @Beta
    public static <V, X extends Throwable> ListenableFuture<V> e(ListenableFuture<? extends V> listenableFuture, Class<X> cls, AsyncFunction<? super X, ? extends V> asyncFunction, Executor executor) {
        return AbstractCatchingFuture.J(listenableFuture, cls, asyncFunction, executor);
    }

    @Beta
    @GwtIncompatible
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V, X extends Exception> V f(Future<V> future, Class<X> cls) throws Exception {
        return (V) FuturesGetChecked.d(future, cls);
    }

    @Beta
    @GwtIncompatible
    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V, X extends Exception> V g(Future<V> future, Class<X> cls, long j, TimeUnit timeUnit) throws Exception {
        return (V) FuturesGetChecked.e(future, cls, j, timeUnit);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V> V h(Future<V> future) throws ExecutionException {
        com.google.common.base.i.x0(future.isDone(), "Future was expected to be done: %s", future);
        return (V) s.f(future);
    }

    @CanIgnoreReturnValue
    @ParametricNullness
    public static <V> V i(Future<V> future) {
        com.google.common.base.i.E(future);
        try {
            return (V) s.f(future);
        } catch (ExecutionException e2) {
            E(e2.getCause());
            throw new AssertionError();
        }
    }

    public static <T> ListenableFuture<? extends T>[] j(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        return (ListenableFuture[]) (iterable instanceof Collection ? (Collection) iterable : ImmutableList.copyOf(iterable)).toArray(new ListenableFuture[0]);
    }

    public static <V> ListenableFuture<V> k() {
        return new com.google.common.util.concurrent.g.a();
    }

    public static <V> ListenableFuture<V> l(Throwable th) {
        com.google.common.base.i.E(th);
        return new com.google.common.util.concurrent.g.b(th);
    }

    public static <V> ListenableFuture<V> m(@ParametricNullness V v) {
        return v == null ? (ListenableFuture<V>) com.google.common.util.concurrent.g.f32422a : new com.google.common.util.concurrent.g(v);
    }

    public static ListenableFuture<Void> n() {
        return com.google.common.util.concurrent.g.f32422a;
    }

    @Beta
    public static <T> ImmutableList<ListenableFuture<T>> o(Iterable<? extends ListenableFuture<? extends T>> iterable) {
        ListenableFuture[] listenableFutureArrJ = j(iterable);
        a aVar = null;
        g gVar = new g(listenableFutureArrJ, aVar);
        ImmutableList.a aVarBuilderWithExpectedSize = ImmutableList.builderWithExpectedSize(listenableFutureArrJ.length);
        for (int i = 0; i < listenableFutureArrJ.length; i++) {
            aVarBuilderWithExpectedSize.a(new C0760f(gVar, aVar));
        }
        ImmutableList<ListenableFuture<T>> immutableListE = aVarBuilderWithExpectedSize.e();
        for (int i2 = 0; i2 < listenableFutureArrJ.length; i2++) {
            listenableFutureArrJ[i2].addListener(new c(gVar, immutableListE, i2), j.c());
        }
        return immutableListE;
    }

    @Beta
    @GwtIncompatible
    public static <I, O> Future<O> p(Future<I> future, Function<? super I, ? extends O> function) {
        com.google.common.base.i.E(future);
        com.google.common.base.i.E(function);
        return new b(future, function);
    }

    @Beta
    public static <V> ListenableFuture<V> q(ListenableFuture<V> listenableFuture) {
        if (listenableFuture.isDone()) {
            return listenableFuture;
        }
        h hVar = new h(listenableFuture);
        listenableFuture.addListener(hVar, j.c());
        return hVar;
    }

    @Beta
    @GwtIncompatible
    public static <O> ListenableFuture<O> r(AsyncCallable<O> asyncCallable, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TrustedListenableFutureTask trustedListenableFutureTaskI = TrustedListenableFutureTask.I(asyncCallable);
        trustedListenableFutureTaskI.addListener(new a(scheduledExecutorService.schedule(trustedListenableFutureTaskI, j, timeUnit)), j.c());
        return trustedListenableFutureTaskI;
    }

    @Beta
    public static ListenableFuture<Void> s(Runnable runnable, Executor executor) {
        TrustedListenableFutureTask trustedListenableFutureTaskJ = TrustedListenableFutureTask.J(runnable, null);
        executor.execute(trustedListenableFutureTaskJ);
        return trustedListenableFutureTaskJ;
    }

    @Beta
    public static <O> ListenableFuture<O> t(Callable<O> callable, Executor executor) {
        TrustedListenableFutureTask trustedListenableFutureTaskK = TrustedListenableFutureTask.K(callable);
        executor.execute(trustedListenableFutureTaskK);
        return trustedListenableFutureTaskK;
    }

    @Beta
    public static <O> ListenableFuture<O> u(AsyncCallable<O> asyncCallable, Executor executor) {
        TrustedListenableFutureTask trustedListenableFutureTaskI = TrustedListenableFutureTask.I(asyncCallable);
        executor.execute(trustedListenableFutureTaskI);
        return trustedListenableFutureTaskI;
    }

    @Beta
    public static <V> ListenableFuture<List<V>> v(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new CollectionFuture.a(ImmutableList.copyOf(iterable), false);
    }

    @SafeVarargs
    @Beta
    public static <V> ListenableFuture<List<V>> w(ListenableFuture<? extends V>... listenableFutureArr) {
        return new CollectionFuture.a(ImmutableList.copyOf(listenableFutureArr), false);
    }

    @Beta
    public static <I, O> ListenableFuture<O> x(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function, Executor executor) {
        return AbstractTransformFuture.I(listenableFuture, function, executor);
    }

    @Beta
    public static <I, O> ListenableFuture<O> y(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        return AbstractTransformFuture.J(listenableFuture, asyncFunction, executor);
    }

    @Beta
    public static <V> e<V> z(Iterable<? extends ListenableFuture<? extends V>> iterable) {
        return new e<>(false, ImmutableList.copyOf(iterable), null);
    }
}
