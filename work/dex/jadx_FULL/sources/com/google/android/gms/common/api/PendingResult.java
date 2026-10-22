package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class PendingResult<R extends Result> {

    @KeepForSdk
    public interface StatusListener {
        @KeepForSdk
        void a(@NonNull Status status);
    }

    @KeepForSdk
    public void b(@NonNull StatusListener statusListener) {
        throw new UnsupportedOperationException();
    }

    @NonNull
    public abstract R c();

    @NonNull
    public abstract R d(long j, @NonNull TimeUnit timeUnit);

    public abstract void e();

    public abstract boolean f();

    public abstract void g(@NonNull ResultCallback<? super R> resultCallback);

    public abstract void h(@NonNull ResultCallback<? super R> resultCallback, long j, @NonNull TimeUnit timeUnit);

    @NonNull
    public <S extends Result> TransformedResult<S> i(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        throw new UnsupportedOperationException();
    }
}
