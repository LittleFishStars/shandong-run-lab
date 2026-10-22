package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Result;
import com.zj.adlib.t2c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class ResultTransform<R extends Result, S extends Result> {
    @NonNull
    public final PendingResult<S> a(@NonNull Status status) {
        return new t2c(status);
    }

    @NonNull
    public Status b(@NonNull Status status) {
        return status;
    }

    @Nullable
    @WorkerThread
    public abstract PendingResult<S> c(@NonNull R r);
}
