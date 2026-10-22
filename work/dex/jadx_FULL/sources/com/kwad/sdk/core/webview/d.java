package com.kwad.sdk.core.webview;

import com.kwad.sdk.core.track.AdTrackLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    private long bch;
    private long bci;
    private boolean bcj;
    private boolean bck;

    public static void d(com.kwad.sdk.core.webview.a.c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), aVar.qa());
        }
    }

    public final void a(com.kwad.sdk.core.webview.a.c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.a aVarQa = aVar.qa();
            com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
            c1273a.a(aVar.getAdTemplate(), null, null, null);
            AdTrackLog adTrackLog = c1273a.aLF;
            if (adTrackLog != null) {
                adTrackLog.setKsUaPattern(aVar.PF());
                c1273a.aLF.setUnionMark(aVar.PG());
            }
            aVarQa.a(c1273a);
            com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVarQa);
        }
        if (aVar != null) {
            this.bch = System.currentTimeMillis();
            this.bci = System.currentTimeMillis();
        }
    }

    public final void b(com.kwad.sdk.core.webview.a.c.a aVar) {
        if (aVar != null) {
            com.kwad.sdk.core.adlog.c.l(aVar.getAdTemplate(), System.currentTimeMillis() - this.bch);
        }
    }

    public final void c(com.kwad.sdk.core.webview.a.c.a aVar) {
        if (aVar == null || this.bcj) {
            return;
        }
        this.bcj = true;
        long jCurrentTimeMillis = 0;
        if (this.bch > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.bch;
            this.bch = -1L;
        }
        com.kwad.sdk.core.adlog.c.a(aVar.getAdTemplate(), aVar.qa(), jCurrentTimeMillis);
    }

    public final void e(com.kwad.sdk.core.webview.a.c.a aVar) {
        if (aVar == null || this.bck) {
            return;
        }
        this.bck = true;
        long jCurrentTimeMillis = 0;
        if (this.bci > 0) {
            jCurrentTimeMillis = System.currentTimeMillis() - this.bci;
            this.bci = -1L;
        }
        com.kwad.sdk.core.adlog.c.b(aVar.getAdTemplate(), aVar.qa(), jCurrentTimeMillis);
    }
}
