package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h extends zabg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConnectionResult f31242a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ j f5554a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(j jVar, zabf zabfVar, ConnectionResult connectionResult) {
        super(zabfVar);
        this.f5554a = jVar;
        this.f31242a = connectionResult;
    }

    @Override // com.google.android.gms.common.api.internal.zabg
    @GuardedBy("mLock")
    public final void zaa() {
        this.f5554a.b.l(this.f31242a);
    }
}
