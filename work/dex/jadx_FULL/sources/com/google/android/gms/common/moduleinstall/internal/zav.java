package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.zj.adlib.f19;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
final class zav extends IStatusCallback.Stub {
    final /* synthetic */ z09 zaa;

    public zav(i iVar, z09 z09Var) {
        this.zaa = z09Var;
    }

    @Override // com.google.android.gms.common.api.internal.IStatusCallback
    public final void onResult(Status status) {
        f19.d(status, Boolean.TRUE, this.zaa);
    }
}
