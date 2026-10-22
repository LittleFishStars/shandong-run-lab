package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.zj.adlib.q0c;
import com.zj.adlib.yw6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class y extends zai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseImplementation.ApiMethodImpl f31259a;

    public y(int i, BaseImplementation.ApiMethodImpl apiMethodImpl) {
        super(i);
        this.f31259a = (BaseImplementation.ApiMethodImpl) yw6.m(apiMethodImpl, "Null methods are not runnable.");
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void a(@NonNull Status status) {
        try {
            this.f31259a.a(status);
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void b(@NonNull Exception exc) {
        try {
            this.f31259a.a(new Status(10, exc.getClass().getSimpleName() + ": " + exc.getLocalizedMessage()));
        } catch (IllegalStateException e) {
            Log.w("ApiCallRunner", "Exception reporting failure", e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void c(t tVar) throws DeadObjectException {
        try {
            this.f31259a.u(tVar.t());
        } catch (RuntimeException e) {
            b(e);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void d(@NonNull q0c q0cVar, boolean z) {
        q0cVar.c(this.f31259a, z);
    }
}
