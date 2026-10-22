package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class w extends UnregisterListenerMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c.a f31257a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(c.a aVar, ListenerHolder.a aVar2) {
        super(aVar2);
        this.f31257a = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final void unregisterListener(Api.AnyClient anyClient, z09<Boolean> z09Var) throws RemoteException {
        this.f31257a.b.accept(anyClient, z09Var);
    }
}
