package com.kwad.sdk.core.request.model;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.bf;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class d extends com.kwad.sdk.core.response.a.a {
    public String aXo;
    public String aXp;
    public int aXq;
    public int operatorType;

    public static d Nt() {
        d dVar = new d();
        try {
            Context contextUd = ServiceProvider.Ud();
            dVar.aXo = bf.dQ(contextUd);
            dVar.aXp = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).Fy();
            dVar.aXq = aq.dB(contextUd);
            dVar.operatorType = aq.e(contextUd, bf.dT(contextUd), be.useNetworkStateDisable());
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return dVar;
    }

    public static d Nu() {
        d dVar = new d();
        dVar.aXq = aq.dB(ServiceProvider.getContext());
        return dVar;
    }
}
