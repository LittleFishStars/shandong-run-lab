package com.zj.adlib;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b4c<R extends Result> extends BasePendingResult<R> {
    public final Result b;

    public b4c(GoogleApiClient googleApiClient, Result result) {
        super(googleApiClient);
        this.b = result;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final R createFailedResult(Status status) {
        return (R) this.b;
    }
}
