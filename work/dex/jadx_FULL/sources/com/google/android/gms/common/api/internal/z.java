package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.zj.adlib.o2c;
import com.zj.adlib.q0c;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class z extends zad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o2c f31260a;

    public z(o2c o2cVar, z09 z09Var) {
        super(3, z09Var);
        this.f31260a = o2cVar;
    }

    @Override // com.google.android.gms.common.api.internal.zad, com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void d(@NonNull q0c q0cVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean f(t tVar) {
        return this.f31260a.f43653a.e();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    @Nullable
    public final Feature[] g(t tVar) {
        return this.f31260a.f43653a.c();
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void zac(t tVar) throws RemoteException {
        this.f31260a.f43653a.registerListener(tVar.t(), ((zad) this).f31264a);
        ListenerHolder.a aVarB = this.f31260a.f43653a.b();
        if (aVarB != null) {
            tVar.v().put(aVarB, this.f31260a);
        }
    }
}
