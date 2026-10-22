package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class k extends zaav {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f31245a;
    public final /* synthetic */ n b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(n nVar, ArrayList arrayList) {
        super(nVar, null);
        this.b = nVar;
        this.f31245a = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.zaav
    @WorkerThread
    public final void zaa() {
        n nVar = this.b;
        nVar.f5560a.f5595a.f5591b = n.y(nVar);
        ArrayList arrayList = this.f31245a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Api.Client client = (Api.Client) arrayList.get(i);
            n nVar2 = this.b;
            client.e(nVar2.f5561a, nVar2.f5560a.f5595a.f5591b);
        }
    }
}
