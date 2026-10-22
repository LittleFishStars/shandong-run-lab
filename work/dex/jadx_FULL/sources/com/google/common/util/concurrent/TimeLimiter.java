package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
@DoNotMock("Use FakeTimeLimiter")
public interface TimeLimiter {
    @CanIgnoreReturnValue
    <T> T a(Callable<T> callable, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException;

    void b(Runnable runnable, long j, TimeUnit timeUnit) throws TimeoutException;

    void c(Runnable runnable, long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException;

    @CanIgnoreReturnValue
    <T> T d(Callable<T> callable, long j, TimeUnit timeUnit) throws ExecutionException, TimeoutException;

    <T> T e(T t, Class<T> cls, long j, TimeUnit timeUnit);
}
