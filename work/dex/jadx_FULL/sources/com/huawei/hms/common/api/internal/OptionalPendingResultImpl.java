package com.huawei.hms.common.api.internal;

import android.os.Looper;
import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;
import com.huawei.hms.support.api.client.ResultCallback;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Deprecated
public final class OptionalPendingResultImpl<R extends Result> extends OptionalPendingResult<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PendingResult<R> f37481a;

    public OptionalPendingResultImpl(PendingResult<R> pendingResult) {
        this.f37481a = pendingResult;
    }

    public final void addStatusListener() {
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await() {
        return (R) this.f37481a.await();
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void cancel() {
    }

    @Override // com.huawei.hms.common.api.OptionalPendingResult
    public final R get() {
        throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final boolean isCanceled() {
        return false;
    }

    @Override // com.huawei.hms.common.api.OptionalPendingResult
    public final boolean isDone() {
        return false;
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(ResultCallback<R> resultCallback) {
        this.f37481a.setResultCallback(resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final R await(long j, TimeUnit timeUnit) {
        return (R) this.f37481a.await(j, timeUnit);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public void setResultCallback(Looper looper, ResultCallback<R> resultCallback) {
        this.f37481a.setResultCallback(looper, resultCallback);
    }

    @Override // com.huawei.hms.support.api.client.PendingResult
    public final void setResultCallback(ResultCallback<R> resultCallback, long j, TimeUnit timeUnit) {
        setResultCallback(resultCallback);
    }
}
