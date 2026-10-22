package com.google.android.gms.common.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.tasks.Task;
import com.zj.adlib.ig7;
import com.zj.adlib.y4c;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public class PendingResultUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zas f31290a = new y4c();

    @KeepForSdk
    public interface ResultConverter<R extends Result, T> {
        @Nullable
        @KeepForSdk
        T a(@NonNull R r);
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result, T extends ig7<R>> Task<T> a(@NonNull PendingResult<R> pendingResult, @NonNull T t) {
        return b(pendingResult, new d(t));
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result, T> Task<T> b(@NonNull PendingResult<R> pendingResult, @NonNull ResultConverter<R, T> resultConverter) {
        zas zasVar = f31290a;
        z09 z09Var = new z09();
        pendingResult.b(new c(pendingResult, z09Var, resultConverter, zasVar));
        return z09Var.a();
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> Task<Void> c(@NonNull PendingResult<R> pendingResult) {
        return b(pendingResult, new e());
    }
}
