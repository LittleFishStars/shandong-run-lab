package com.kwad.sdk.core.b.a;

import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.interstitial.report.InterstitialReportInfo;
import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class dc {
    @InvokeBy(invokerClass = hl.class, methodId = "registerHolder")
    public static void LS() {
        hl.LT().put(InterstitialReportInfo.class, new he());
        hl.LT().put(com.kwad.components.ad.h.a.a.b.a.class, new nj());
        hl.LT().put(InterstitialRealTimeInfo.class, new hd());
        hl.LT().put(com.kwad.components.ad.interstitial.c.b.class, new hc());
        hl.LT().put(com.kwad.components.ad.interstitial.c.a.class, new gz());
        hl.LT().put(com.kwad.components.ad.interstitial.d.a.class, new ha());
    }
}
