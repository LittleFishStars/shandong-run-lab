package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.zabz;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z5c implements zabz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f46190a;

    public /* synthetic */ z5c(d dVar, w5c w5cVar) {
        this.f46190a = dVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void a(int i, boolean z) {
        Lock lock;
        this.f46190a.f5550a.lock();
        try {
            d dVar = this.f46190a;
            if (dVar.f5551a) {
                dVar.f5551a = false;
                d.A(this.f46190a, i, z);
                lock = this.f46190a.f5550a;
            } else {
                dVar.f5551a = true;
                this.f46190a.f5547a.onConnectionSuspended(i);
                lock = this.f46190a.f5550a;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.f46190a.f5550a.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void b(@Nullable Bundle bundle) {
        this.f46190a.f5550a.lock();
        try {
            this.f46190a.b = ConnectionResult.RESULT_SUCCESS;
            d.C(this.f46190a);
        } finally {
            this.f46190a.f5550a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void c(@NonNull ConnectionResult connectionResult) {
        this.f46190a.f5550a.lock();
        try {
            this.f46190a.b = connectionResult;
            d.C(this.f46190a);
        } finally {
            this.f46190a.f5550a.unlock();
        }
    }
}
