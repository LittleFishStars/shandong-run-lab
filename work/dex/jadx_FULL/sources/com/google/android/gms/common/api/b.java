package com.google.android.gms.common.api;

import com.zj.adlib.ys0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b implements PendingResult.StatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f31220a;

    public b(a aVar) {
        this.f31220a = aVar;
    }

    @Override // com.google.android.gms.common.api.PendingResult.StatusListener
    public final void a(Status status) {
        synchronized (this.f31220a.f5486b) {
            if (this.f31220a.f()) {
                return;
            }
            if (status.isCanceled()) {
                this.f31220a.f = true;
            } else if (!status.isSuccess()) {
                this.f31220a.e = true;
            }
            this.f31220a.b--;
            a aVar = this.f31220a;
            if (aVar.b == 0) {
                if (aVar.f) {
                    super/*com.google.android.gms.common.api.internal.BasePendingResult*/.e();
                } else {
                    Status status2 = aVar.e ? new Status(13) : Status.RESULT_SUCCESS;
                    a aVar2 = this.f31220a;
                    aVar2.setResult(new ys0(status2, aVar2.f31218a));
                }
            }
        }
    }
}
