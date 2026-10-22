package com.google.android.gms.common.api;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Result;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class ResultCallbacks<R extends Result> implements ResultCallback<R> {
    @Override // com.google.android.gms.common.api.ResultCallback
    @KeepForSdk
    public final void a(@NonNull R r) {
        Status status = r.getStatus();
        if (status.isSuccess()) {
            c(r);
            return;
        }
        b(status);
        if (r instanceof Releasable) {
            try {
                ((Releasable) r).release();
            } catch (RuntimeException e) {
                Log.w("ResultCallbacks", "Unable to release ".concat(String.valueOf(r)), e);
            }
        }
    }

    public abstract void b(@NonNull Status status);

    public abstract void c(@NonNull R r);
}
