package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.zj.adlib.o2c;
import com.zj.adlib.q0c;
import com.zj.adlib.z09;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a0 extends zad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ListenerHolder.a f31234a;

    public a0(ListenerHolder.a aVar, z09 z09Var) {
        super(4, z09Var);
        this.f31234a = aVar;
    }

    @Override // com.google.android.gms.common.api.internal.zad, com.google.android.gms.common.api.internal.zai
    public final /* bridge */ /* synthetic */ void d(@NonNull q0c q0cVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean f(t tVar) {
        o2c o2cVar = (o2c) tVar.v().get(this.f31234a);
        return o2cVar != null && o2cVar.f43653a.e();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    @Nullable
    public final Feature[] g(t tVar) {
        o2c o2cVar = (o2c) tVar.v().get(this.f31234a);
        if (o2cVar == null) {
            return null;
        }
        return o2cVar.f43653a.c();
    }

    @Override // com.google.android.gms.common.api.internal.zad
    public final void zac(t tVar) throws RemoteException {
        o2c o2cVar = (o2c) tVar.v().remove(this.f31234a);
        if (o2cVar == null) {
            ((zad) this).f31264a.d(Boolean.FALSE);
        } else {
            o2cVar.f18544a.unregisterListener(tVar.t(), ((zad) this).f31264a);
            o2cVar.f43653a.a();
        }
    }
}
