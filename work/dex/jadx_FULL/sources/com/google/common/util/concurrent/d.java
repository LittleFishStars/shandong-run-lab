package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
@CanIgnoreReturnValue
public final class d implements TimeLimiter {
    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T a(Callable<T> callable, long j, TimeUnit timeUnit) throws ExecutionException {
        com.google.common.base.i.E(callable);
        com.google.common.base.i.E(timeUnit);
        try {
            return callable.call();
        } catch (Error e) {
            throw new ExecutionError(e);
        } catch (RuntimeException e2) {
            throw new UncheckedExecutionException(e2);
        } catch (Exception e3) {
            throw new ExecutionException(e3);
        } catch (Throwable th) {
            throw new ExecutionException(th);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void b(Runnable runnable, long j, TimeUnit timeUnit) {
        c(runnable, j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public void c(Runnable runnable, long j, TimeUnit timeUnit) {
        com.google.common.base.i.E(runnable);
        com.google.common.base.i.E(timeUnit);
        try {
            runnable.run();
        } catch (Error e) {
            throw new ExecutionError(e);
        } catch (RuntimeException e2) {
            throw new UncheckedExecutionException(e2);
        } catch (Throwable th) {
            throw new UncheckedExecutionException(th);
        }
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    @ParametricNullness
    public <T> T d(Callable<T> callable, long j, TimeUnit timeUnit) throws ExecutionException {
        return (T) a(callable, j, timeUnit);
    }

    @Override // com.google.common.util.concurrent.TimeLimiter
    public <T> T e(T t, Class<T> cls, long j, TimeUnit timeUnit) {
        com.google.common.base.i.E(t);
        com.google.common.base.i.E(cls);
        com.google.common.base.i.E(timeUnit);
        return t;
    }
}
