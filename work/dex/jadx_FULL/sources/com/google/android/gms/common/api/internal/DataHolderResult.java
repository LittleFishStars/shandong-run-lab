package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class DataHolderResult implements Result, Releasable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    @KeepForSdk
    public final Status f31225a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    @KeepForSdk
    public final DataHolder f5505a;

    @KeepForSdk
    public DataHolderResult(@NonNull DataHolder dataHolder) {
        this(dataHolder, new Status(dataHolder.getStatusCode()));
    }

    @KeepForSdk
    public DataHolderResult(@NonNull DataHolder dataHolder, @NonNull Status status) {
        this.f31225a = status;
        this.f5505a = dataHolder;
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    @KeepForSdk
    public Status getStatus() {
        return this.f31225a;
    }

    @Override // com.google.android.gms.common.api.Releasable
    @KeepForSdk
    public void release() {
        DataHolder dataHolder = this.f5505a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
