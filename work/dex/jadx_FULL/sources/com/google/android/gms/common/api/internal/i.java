package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class i extends zabg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BaseGmsClient.ConnectionProgressReportCallbacks f31243a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, zabf zabfVar, BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        super(zabfVar);
        this.f31243a = connectionProgressReportCallbacks;
    }

    @Override // com.google.android.gms.common.api.internal.zabg
    @GuardedBy("mLock")
    public final void zaa() {
        this.f31243a.b(new ConnectionResult(16, null));
    }
}
