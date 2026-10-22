package com.zj.adlib;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.d;
import com.google.android.gms.common.api.internal.zabz;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class u5c implements zabz {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f45067a;

    public /* synthetic */ u5c(d dVar, t5c t5cVar) {
        this.f45067a = dVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void a(int i, boolean z) {
        Lock lock;
        this.f45067a.f5550a.lock();
        try {
            d dVar = this.f45067a;
            if (dVar.f5551a || dVar.b == null || !dVar.b.isSuccess()) {
                this.f45067a.f5551a = false;
                d.A(this.f45067a, i, z);
                lock = this.f45067a.f5550a;
            } else {
                this.f45067a.f5551a = true;
                this.f45067a.f5552b.onConnectionSuspended(i);
                lock = this.f45067a.f5550a;
            }
            lock.unlock();
        } catch (Throwable th) {
            this.f45067a.f5550a.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void b(@Nullable Bundle bundle) {
        this.f45067a.f5550a.lock();
        try {
            d.B(this.f45067a, bundle);
            this.f45067a.f5544a = ConnectionResult.RESULT_SUCCESS;
            d.C(this.f45067a);
        } finally {
            this.f45067a.f5550a.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabz
    public final void c(@NonNull ConnectionResult connectionResult) {
        this.f45067a.f5550a.lock();
        try {
            this.f45067a.f5544a = connectionResult;
            d.C(this.f45067a);
        } finally {
            this.f45067a.f5550a.unlock();
        }
    }
}
