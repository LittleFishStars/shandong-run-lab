package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.zj.adlib.b90;
import com.zj.adlib.z09;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements PendingResult.StatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PendingResult f31296a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ PendingResultUtil.ResultConverter f5680a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zas f5681a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ z09 f5682a;

    public c(PendingResult pendingResult, z09 z09Var, PendingResultUtil.ResultConverter resultConverter, zas zasVar) {
        this.f31296a = pendingResult;
        this.f5682a = z09Var;
        this.f5680a = resultConverter;
        this.f5681a = zasVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        if (!status.isSuccess()) {
            this.f5682a.b(b90.a(status));
        } else {
            this.f5682a.setResult(this.f5680a.a(this.f31296a.d(0L, TimeUnit.MILLISECONDS)));
        }
    }
}
