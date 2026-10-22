package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class x extends TaskApiCall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TaskApiCall.a f31258a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(TaskApiCall.a aVar, Feature[] featureArr, boolean z, int i) {
        super(featureArr, z, i);
        this.f31258a = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final void doExecute(Api.AnyClient anyClient, z09 z09Var) throws RemoteException {
        this.f31258a.f5514a.accept(anyClient, z09Var);
    }
}
