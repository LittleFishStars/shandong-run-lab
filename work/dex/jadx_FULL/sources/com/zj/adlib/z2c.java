package com.zj.adlib;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z2c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Result f46173a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ i3c f20960a;

    public z2c(i3c i3cVar, Result result) {
        this.f20960a = i3cVar;
        this.f46173a = result;
    }

    @Override // java.lang.Runnable
    @WorkerThread
    public final void run() {
        GoogleApiClient googleApiClient;
        try {
            try {
                ThreadLocal threadLocal = BasePendingResult.f5492a;
                threadLocal.set(Boolean.TRUE);
                PendingResult pendingResultC = ((ResultTransform) yw6.l(this.f20960a.f17129a)).c(this.f46173a);
                i3c i3cVar = this.f20960a;
                i3cVar.f17131a.sendMessage(i3cVar.f17131a.obtainMessage(0, pendingResultC));
                threadLocal.set(Boolean.FALSE);
                i3c i3cVar2 = this.f20960a;
                i3c.q(this.f46173a);
                googleApiClient = (GoogleApiClient) this.f20960a.f17134a.get();
                if (googleApiClient == null) {
                    return;
                }
            } catch (RuntimeException e) {
                i3c i3cVar3 = this.f20960a;
                i3cVar3.f17131a.sendMessage(i3cVar3.f17131a.obtainMessage(1, e));
                BasePendingResult.f5492a.set(Boolean.FALSE);
                i3c i3cVar4 = this.f20960a;
                i3c.q(this.f46173a);
                googleApiClient = (GoogleApiClient) this.f20960a.f17134a.get();
                if (googleApiClient == null) {
                    return;
                }
            }
            googleApiClient.F(this.f20960a);
        } catch (Throwable th) {
            BasePendingResult.f5492a.set(Boolean.FALSE);
            i3c i3cVar5 = this.f20960a;
            i3c.q(this.f46173a);
            GoogleApiClient googleApiClient2 = (GoogleApiClient) this.f20960a.f17134a.get();
            if (googleApiClient2 != null) {
                googleApiClient2.F(this.f20960a);
            }
            throw th;
        }
    }
}
