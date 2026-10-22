package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
public final class CombinedFuture<V> extends AggregateFuture<Object, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @CheckForNull
    public CombinedFuture<V>.CombinedFutureInterruptibleTask<?> f32363a;

    public final class AsyncCallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<ListenableFuture<V>> {
        private final AsyncCallable<V> callable;

        public AsyncCallableInterruptibleTask(AsyncCallable<V> asyncCallable, Executor executor) {
            super(executor);
            this.callable = (AsyncCallable) com.google.common.base.i.E(asyncCallable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public ListenableFuture<V> runInterruptibly() throws Exception {
            return (ListenableFuture) com.google.common.base.i.V(this.callable.call(), "AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", this.callable);
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(ListenableFuture<V> listenableFuture) {
            CombinedFuture.this.setFuture(listenableFuture);
        }
    }

    public final class CallableInterruptibleTask extends CombinedFuture<V>.CombinedFutureInterruptibleTask<V> {
        private final Callable<V> callable;

        public CallableInterruptibleTask(Callable<V> callable, Executor executor) {
            super(executor);
            this.callable = (Callable) com.google.common.base.i.E(callable);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        @ParametricNullness
        public V runInterruptibly() throws Exception {
            return this.callable.call();
        }

        @Override // com.google.common.util.concurrent.CombinedFuture.CombinedFutureInterruptibleTask
        public void setValue(@ParametricNullness V v) {
            CombinedFuture.this.set(v);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public String toPendingString() {
            return this.callable.toString();
        }
    }

    public abstract class CombinedFutureInterruptibleTask<T> extends InterruptibleTask<T> {
        private final Executor listenerExecutor;

        public CombinedFutureInterruptibleTask(Executor executor) {
            this.listenerExecutor = (Executor) com.google.common.base.i.E(executor);
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptiblyFailure(Throwable th) {
            CombinedFuture.this.f32363a = null;
            if (th instanceof ExecutionException) {
                CombinedFuture.this.setException(((ExecutionException) th).getCause());
            } else if (th instanceof CancellationException) {
                CombinedFuture.this.cancel(false);
            } else {
                CombinedFuture.this.setException(th);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final void afterRanInterruptiblySuccess(@ParametricNullness T t) {
            CombinedFuture.this.f32363a = null;
            setValue(t);
        }

        public final void execute() {
            try {
                this.listenerExecutor.execute(this);
            } catch (RejectedExecutionException e) {
                CombinedFuture.this.setException(e);
            }
        }

        @Override // com.google.common.util.concurrent.InterruptibleTask
        public final boolean isDone() {
            return CombinedFuture.this.isDone();
        }

        public abstract void setValue(@ParametricNullness T t);
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z, Executor executor, AsyncCallable<V> asyncCallable) {
        super(immutableCollection, z, false);
        this.f32363a = new AsyncCallableInterruptibleTask(asyncCallable, executor);
        Q();
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void L(int i, @CheckForNull Object obj) {
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void O() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.f32363a;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.execute();
        }
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public void T(AggregateFuture.ReleaseResourcesReason releaseResourcesReason) {
        super.T(releaseResourcesReason);
        if (releaseResourcesReason == AggregateFuture.ReleaseResourcesReason.OUTPUT_FUTURE_DONE) {
            this.f32363a = null;
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    public void interruptTask() {
        CombinedFuture<V>.CombinedFutureInterruptibleTask<?> combinedFutureInterruptibleTask = this.f32363a;
        if (combinedFutureInterruptibleTask != null) {
            combinedFutureInterruptibleTask.interruptTask();
        }
    }

    public CombinedFuture(ImmutableCollection<? extends ListenableFuture<?>> immutableCollection, boolean z, Executor executor, Callable<V> callable) {
        super(immutableCollection, z, false);
        this.f32363a = new CallableInterruptibleTask(callable, executor);
        Q();
    }
}
