package com.zj.adlib;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class m0c implements PendingResult.StatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f43196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ q0c f18113a;

    public m0c(q0c q0cVar, BasePendingResult basePendingResult) {
        this.f18113a = q0cVar;
        this.f43196a = basePendingResult;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        this.f18113a.f44098a.remove(this.f43196a);
    }
}
