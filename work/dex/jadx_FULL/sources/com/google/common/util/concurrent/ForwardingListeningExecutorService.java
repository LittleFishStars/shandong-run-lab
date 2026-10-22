package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@CanIgnoreReturnValue
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class ForwardingListeningExecutorService extends ForwardingExecutorService implements ListeningExecutorService {
    @Override // com.google.common.util.concurrent.ForwardingExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: E */
    public <T> ListenableFuture<T> submit(Runnable runnable, @ParametricNullness T t) {
        return delegate().submit(runnable, t);
    }

    @Override // com.google.common.util.concurrent.ForwardingExecutorService, com.google.common.collect.ForwardingObject
    public abstract ListeningExecutorService delegate();

    @Override // com.google.common.util.concurrent.ForwardingExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: h */
    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        return delegate().submit(callable);
    }

    @Override // com.google.common.util.concurrent.ForwardingExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: j */
    public ListenableFuture<?> submit(Runnable runnable) {
        return delegate().submit(runnable);
    }
}
