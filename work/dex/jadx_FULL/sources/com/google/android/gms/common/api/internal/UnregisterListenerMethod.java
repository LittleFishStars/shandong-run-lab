package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class UnregisterListenerMethod<A extends Api.AnyClient, L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListenerHolder.a f31232a;

    @KeepForSdk
    public UnregisterListenerMethod(@NonNull ListenerHolder.a<L> aVar) {
        this.f31232a = aVar;
    }

    @NonNull
    @KeepForSdk
    public ListenerHolder.a<L> a() {
        return this.f31232a;
    }

    @KeepForSdk
    public abstract void unregisterListener(@NonNull A a2, @NonNull z09<Boolean> z09Var) throws RemoteException;
}
