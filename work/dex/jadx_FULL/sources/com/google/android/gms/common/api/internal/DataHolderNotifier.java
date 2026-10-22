package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.data.DataHolder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class DataHolderNotifier<L> implements ListenerHolder.Notifier<L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataHolder f31224a;

    @KeepForSdk
    public DataHolderNotifier(@NonNull DataHolder dataHolder) {
        this.f31224a = dataHolder;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    @KeepForSdk
    public void a() {
        DataHolder dataHolder = this.f31224a;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    @KeepForSdk
    public final void b(@NonNull L l) {
        notifyListener(l, this.f31224a);
    }

    @KeepForSdk
    public abstract void notifyListener(@NonNull L l, @NonNull DataHolder dataHolder);
}
