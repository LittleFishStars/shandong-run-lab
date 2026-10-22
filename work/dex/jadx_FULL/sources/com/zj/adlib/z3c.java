package com.zj.adlib;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.StatusExceptionMapper;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.t;
import com.google.android.gms.common.api.internal.zai;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z3c extends com.google.android.gms.common.api.internal.zac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StatusExceptionMapper f46182a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TaskApiCall f20976a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final z09 f20977a;

    public z3c(int i, TaskApiCall taskApiCall, z09 z09Var, StatusExceptionMapper statusExceptionMapper) {
        super(i);
        this.f20977a = z09Var;
        this.f20976a = taskApiCall;
        this.f46182a = statusExceptionMapper;
        if (i == 2 && taskApiCall.b()) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void a(@NonNull Status status) {
        this.f20977a.c(this.f46182a.getException(status));
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void b(@NonNull Exception exc) {
        this.f20977a.c(exc);
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void c(t tVar) throws DeadObjectException {
        try {
            this.f20976a.doExecute(tVar.t(), this.f20977a);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            a(zai.e(e2));
        } catch (RuntimeException e3) {
            this.f20977a.c(e3);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zai
    public final void d(@NonNull q0c q0cVar, boolean z) {
        q0cVar.d(this.f20977a, z);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean f(t tVar) {
        return this.f20976a.b();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    @Nullable
    public final Feature[] g(t tVar) {
        return this.f20976a.d();
    }
}
