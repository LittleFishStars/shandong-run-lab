package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
public final class o<V> extends AbstractFuture.TrustedFuture<V> {
    public static <V> o<V> A() {
        return new o<>();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture.TrustedFuture, com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
    public /* bridge */ /* synthetic */ void addListener(Runnable runnable, Executor executor) {
        super.addListener(runnable, executor);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture.TrustedFuture, com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    @CanIgnoreReturnValue
    public /* bridge */ /* synthetic */ boolean cancel(boolean z) {
        return super.cancel(z);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture.TrustedFuture, com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    @CanIgnoreReturnValue
    @ParametricNullness
    public /* bridge */ /* synthetic */ Object get() throws ExecutionException, InterruptedException {
        return super.get();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture.TrustedFuture, com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
    public /* bridge */ /* synthetic */ boolean isCancelled() {
        return super.isCancelled();
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean set(@ParametricNullness V v) {
        return super.set(v);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    @CanIgnoreReturnValue
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }
}
