package com.aliyun.credentials.provider;

import com.aliyun.credentials.exception.CredentialException;
import com.aliyun.tea.utils.Validate;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RefreshCachedSupplier<T> implements AutoCloseable {
    private static final long REFRESH_BLOCKING_MAX_WAIT = 5000;
    private final AtomicBoolean asyncRefreshing;
    private final boolean asyncUpdateEnabled;
    private volatile RefreshResult<T> cachedValue;
    private final ExecutorService executor;
    private final Callable<RefreshResult<T>> refreshCallable;
    private final Lock refreshLock;

    public static final class Builder<T> {
        private boolean asyncUpdateEnabled;
        private final Callable<RefreshResult<T>> refreshCallable;

        public Builder<T> asyncUpdateEnabled(Boolean bool) {
            this.asyncUpdateEnabled = bool.booleanValue();
            return this;
        }

        public RefreshCachedSupplier<T> build() {
            return new RefreshCachedSupplier<>(this);
        }

        private Builder(Callable<RefreshResult<T>> callable) {
            this.refreshCallable = callable;
        }
    }

    private void asyncRefresh() {
        if (this.asyncRefreshing.compareAndSet(false, true)) {
            try {
                this.executor.submit(new Runnable() { // from class: com.aliyun.credentials.provider.RefreshCachedSupplier.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            RefreshCachedSupplier.this.refreshCache();
                        } finally {
                            RefreshCachedSupplier.this.asyncRefreshing.set(false);
                        }
                    }
                });
            } catch (RuntimeException e) {
                this.asyncRefreshing.set(false);
                throw e;
            }
        }
    }

    private void blockingRefresh() throws Exception {
        try {
            if (this.refreshLock.tryLock(5000L, TimeUnit.MILLISECONDS)) {
                try {
                    if (cacheIsStale()) {
                        refreshCache();
                    }
                } finally {
                    this.refreshLock.unlock();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted waiting to refresh the value.", e);
        } catch (Exception e2) {
            Thread.currentThread().interrupt();
            throw e2;
        }
    }

    public static <T> Builder<T> builder(Callable<RefreshResult<T>> callable) {
        return new Builder<>(callable);
    }

    private boolean cacheIsStale() {
        return new Date().getTime() >= this.cachedValue.staleTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshCache() {
        try {
            this.cachedValue = this.refreshCallable.call();
        } catch (CredentialException e) {
            throw e;
        } catch (Exception e2) {
            throw new CredentialException("Failed to refresh credentials.", e2);
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        this.executor.shutdown();
    }

    public T get() throws Exception {
        if (cacheIsStale()) {
            if (this.asyncUpdateEnabled) {
                asyncRefresh();
            } else {
                blockingRefresh();
            }
        }
        if (this.cachedValue != null) {
            return this.cachedValue.value();
        }
        return null;
    }

    private RefreshCachedSupplier(Builder<T> builder) {
        this.refreshLock = new ReentrantLock();
        this.asyncRefreshing = new AtomicBoolean(false);
        this.executor = new ThreadPoolExecutor(0, 1, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(1), Executors.defaultThreadFactory());
        this.cachedValue = RefreshResult.builder(null).staleTime(0L).build();
        this.refreshCallable = (Callable) Validate.notNull(((Builder) builder).refreshCallable, "Refresh Callable is null.", new Object[0]);
        this.asyncUpdateEnabled = ((Builder) builder).asyncUpdateEnabled;
    }
}
