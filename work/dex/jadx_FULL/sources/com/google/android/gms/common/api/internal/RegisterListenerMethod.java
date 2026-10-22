package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@KeepForSdk
public abstract class RegisterListenerMethod<A extends Api.AnyClient, L> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f31229a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ListenerHolder f5509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5510a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Feature[] f5511a;

    @KeepForSdk
    public RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder) {
        this(listenerHolder, null, false, 0);
    }

    @KeepForSdk
    public RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder, @Nullable Feature[] featureArr, boolean z, int i) {
        this.f5509a = listenerHolder;
        this.f5511a = featureArr;
        this.f5510a = z;
        this.f31229a = i;
    }

    @KeepForSdk
    public void a() {
        this.f5509a.a();
    }

    @Nullable
    @KeepForSdk
    public ListenerHolder.a<L> b() {
        return this.f5509a.b();
    }

    @Nullable
    @KeepForSdk
    public Feature[] c() {
        return this.f5511a;
    }

    public final int d() {
        return this.f31229a;
    }

    public final boolean e() {
        return this.f5510a;
    }

    @KeepForSdk
    public abstract void registerListener(@NonNull A a2, @NonNull z09<Void> z09Var) throws RemoteException;

    @KeepForSdk
    public RegisterListenerMethod(@NonNull ListenerHolder<L> listenerHolder, @NonNull Feature[] featureArr, boolean z) {
        this(listenerHolder, featureArr, z, 0);
    }
}
