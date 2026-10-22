package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public final class ld6<R extends Result> extends OptionalPendingResult<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BasePendingResult f43044a;

    public ld6(@NonNull PendingResult pendingResult) {
        this.f43044a = (BasePendingResult) pendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void b(@NonNull PendingResult.StatusListener statusListener) {
        this.f43044a.b(statusListener);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final R c() {
        return (R) this.f43044a.c();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final R d(long j, @NonNull TimeUnit timeUnit) {
        return (R) this.f43044a.d(j, timeUnit);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void e() {
        this.f43044a.e();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final boolean f() {
        return this.f43044a.f();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void g(@NonNull ResultCallback<? super R> resultCallback) {
        this.f43044a.g(resultCallback);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void h(@NonNull ResultCallback<? super R> resultCallback, long j, @NonNull TimeUnit timeUnit) {
        this.f43044a.h(resultCallback, j, timeUnit);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final <S extends Result> TransformedResult<S> i(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        return this.f43044a.i(resultTransform);
    }

    @Override // com.google.android.gms.common.api.OptionalPendingResult
    @NonNull
    public final R j() {
        if (!this.f43044a.k()) {
            throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
        }
        return (R) this.f43044a.d(0L, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.common.api.OptionalPendingResult
    public final boolean k() {
        return this.f43044a.k();
    }
}
