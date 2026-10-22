package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.zj.adlib.p4c;
import com.zj.adlib.v0c;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class j extends zaav {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f31244a;
    public final /* synthetic */ n b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(n nVar, Map map) {
        super(nVar, null);
        this.b = nVar;
        this.f31244a = map;
    }

    @Override // com.google.android.gms.common.api.internal.zaav
    @GuardedBy("mLock")
    @WorkerThread
    public final void zaa() {
        p4c p4cVar = new p4c(this.b.f5564a);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.f31244a.keySet()) {
            if (!client.b() || ((v0c) this.f31244a.get(client)).f20153a) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int iB = -1;
        int i = 0;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i < size) {
                iB = p4cVar.b(this.b.f5556a, (Api.Client) arrayList.get(i));
                i++;
                if (iB != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i < size2) {
                iB = p4cVar.b(this.b.f5556a, (Api.Client) arrayList2.get(i));
                i++;
                if (iB == 0) {
                    break;
                }
            }
        }
        if (iB != 0) {
            ConnectionResult connectionResult = new ConnectionResult(iB, null);
            n nVar = this.b;
            nVar.f5560a.t(new h(this, nVar, connectionResult));
            return;
        }
        n nVar2 = this.b;
        if (nVar2.f5570b && nVar2.f5562a != null) {
            nVar2.f5562a.m();
        }
        for (Api.Client client2 : this.f31244a.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) this.f31244a.get(client2);
            if (!client2.b() || p4cVar.b(this.b.f5556a, client2) == 0) {
                client2.j(connectionProgressReportCallbacks);
            } else {
                n nVar3 = this.b;
                nVar3.f5560a.t(new i(this, nVar3, connectionProgressReportCallbacks));
            }
        }
    }
}
