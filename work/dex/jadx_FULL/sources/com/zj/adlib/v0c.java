package com.zj.adlib;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.n;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class v0c implements BaseGmsClient.ConnectionProgressReportCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Api f45266a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WeakReference f20152a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f20153a;

    public v0c(n nVar, Api api, boolean z) {
        this.f20152a = new WeakReference(nVar);
        this.f45266a = api;
        this.f20153a = z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void b(@NonNull ConnectionResult connectionResult) {
        Lock lock;
        n nVar = (n) this.f20152a.get();
        if (nVar == null) {
            return;
        }
        yw6.s(Looper.myLooper() == nVar.f5560a.f5595a.q(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        nVar.f5568a.lock();
        try {
            if (nVar.o(0)) {
                if (!connectionResult.isSuccess()) {
                    nVar.m(connectionResult, this.f45266a, this.f20153a);
                }
                if (nVar.p()) {
                    nVar.n();
                }
                lock = nVar.f5568a;
            } else {
                lock = nVar.f5568a;
            }
            lock.unlock();
        } catch (Throwable th) {
            nVar.f5568a.unlock();
            throw th;
        }
    }
}
