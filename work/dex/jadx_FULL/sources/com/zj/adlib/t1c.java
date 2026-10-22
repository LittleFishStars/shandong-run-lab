package com.zj.adlib;

import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class t1c implements BaseGmsClient.SignOutCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f44829a;

    public t1c(t tVar) {
        this.f44829a = tVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void a() {
        this.f44829a.f5605a.f5521a.post(new s1c(this));
    }
}
