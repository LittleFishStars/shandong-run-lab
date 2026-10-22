package com.zj.adlib;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ond implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ bpd f43790a;

    public /* synthetic */ ond(bpd bpdVar, kld kldVar) {
        this.f43790a = bpdVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f43790a.f15619a) {
                chd chdVar = (chd) message.obj;
                kjd kjdVar = (kjd) this.f43790a.f15619a.get(chdVar);
                if (kjdVar != null && kjdVar.i()) {
                    if (kjdVar.j()) {
                        kjdVar.g("GmsClientSupervisor");
                    }
                    this.f43790a.f15619a.remove(chdVar);
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.f43790a.f15619a) {
            chd chdVar2 = (chd) message.obj;
            kjd kjdVar2 = (kjd) this.f43790a.f15619a.get(chdVar2);
            if (kjdVar2 != null && kjdVar2.a() == 3) {
                Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(chdVar2), new Exception());
                ComponentName componentNameB = kjdVar2.b();
                if (componentNameB == null) {
                    componentNameB = chdVar2.b();
                }
                if (componentNameB == null) {
                    String strD = chdVar2.d();
                    yw6.l(strD);
                    componentNameB = new ComponentName(strD, "unknown");
                }
                kjdVar2.onServiceDisconnected(componentNameB);
            }
        }
        return true;
    }
}
