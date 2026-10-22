package com.zj.adlib;

import android.os.Looper;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class y3c<R extends Result> extends BasePendingResult<R> {
    public final Result b;

    public y3c(Result result) {
        super(Looper.getMainLooper());
        this.b = result;
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final R createFailedResult(Status status) {
        if (status.getStatusCode() == this.b.getStatus().getStatusCode()) {
            return (R) this.b;
        }
        throw new UnsupportedOperationException("Creating failed results is not supported");
    }
}
