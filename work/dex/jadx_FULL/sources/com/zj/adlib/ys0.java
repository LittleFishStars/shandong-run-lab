package com.zj.adlib;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ys0 implements Result {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Status f46105a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PendingResult[] f20923a;

    public ys0(Status status, PendingResult[] pendingResultArr) {
        this.f46105a = status;
        this.f20923a = pendingResultArr;
    }

    @NonNull
    public <R extends Result> R a(@NonNull zs0<R> zs0Var) {
        yw6.b(zs0Var.f46330a < this.f20923a.length, "The result token does not belong to this batch");
        return (R) this.f20923a[zs0Var.f46330a].d(0L, TimeUnit.MILLISECONDS);
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    public Status getStatus() {
        return this.f46105a;
    }
}
