package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class PendingResultFacade<A extends Result, B extends Result> extends PendingResult<B> {
    @Override // com.google.android.gms.common.api.PendingResult
    public final void b(@NonNull PendingResult.StatusListener statusListener) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final B c() {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final B d(long j, @NonNull TimeUnit timeUnit) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void e() {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final boolean f() {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void g(@NonNull ResultCallback<? super B> resultCallback) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void h(@NonNull ResultCallback<? super B> resultCallback, long j, @NonNull TimeUnit timeUnit) {
        throw null;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @NonNull
    public final <S extends Result> TransformedResult<S> i(@NonNull ResultTransform<? super B, ? extends S> resultTransform) {
        throw null;
    }
}
