package com.google.android.gms.common.api.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.zj.adlib.q0c;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
abstract class zad extends zac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z09 f31264a;

    public zad(int i, z09 z09Var) {
        super(i);
        this.f31264a = z09Var;
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void a(@NonNull Status status) {
        this.f31264a.c(new ApiException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void b(@NonNull Exception exc) {
        this.f31264a.c(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void c(t tVar) throws DeadObjectException {
        try {
            zac(tVar);
        } catch (DeadObjectException e) {
            a(zai.e(e));
            throw e;
        } catch (RemoteException e2) {
            a(zai.e(e2));
        } catch (RuntimeException e3) {
            this.f31264a.c(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public void d(@NonNull q0c q0cVar, boolean z) {
    }

    public abstract void zac(t tVar) throws RemoteException;
}
