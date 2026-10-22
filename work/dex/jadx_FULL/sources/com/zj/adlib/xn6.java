package com.zj.adlib;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xn6 {
    @NonNull
    public static PendingResult<Status> a() {
        dr8 dr8Var = new dr8(Looper.getMainLooper());
        dr8Var.e();
        return dr8Var;
    }

    @NonNull
    public static <R extends Result> PendingResult<R> b(@NonNull R r) {
        yw6.m(r, "Result must not be null");
        yw6.b(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        y3c y3cVar = new y3c(r);
        y3cVar.e();
        return y3cVar;
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> PendingResult<R> c(@NonNull R r, @NonNull GoogleApiClient googleApiClient) {
        yw6.m(r, "Result must not be null");
        yw6.b(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        b4c b4cVar = new b4c(googleApiClient, r);
        b4cVar.setResult(r);
        return b4cVar;
    }

    @NonNull
    public static <R extends Result> OptionalPendingResult<R> d(@NonNull R r) {
        yw6.m(r, "Result must not be null");
        g4c g4cVar = new g4c(null);
        g4cVar.setResult(r);
        return new ld6(g4cVar);
    }

    @NonNull
    @KeepForSdk
    public static <R extends Result> OptionalPendingResult<R> e(@NonNull R r, @NonNull GoogleApiClient googleApiClient) {
        yw6.m(r, "Result must not be null");
        g4c g4cVar = new g4c(googleApiClient);
        g4cVar.setResult(r);
        return new ld6(g4cVar);
    }

    @NonNull
    public static PendingResult<Status> f(@NonNull Status status) {
        yw6.m(status, "Result must not be null");
        dr8 dr8Var = new dr8(Looper.getMainLooper());
        dr8Var.setResult(status);
        return dr8Var;
    }

    @NonNull
    @KeepForSdk
    public static PendingResult<Status> g(@NonNull Status status, @NonNull GoogleApiClient googleApiClient) {
        yw6.m(status, "Result must not be null");
        dr8 dr8Var = new dr8(googleApiClient);
        dr8Var.setResult(status);
        return dr8Var;
    }
}
