package com.kwad.components.ad.reward;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class o {
    public static void a(int i, int i2, g gVar, com.kwad.components.ad.reward.model.c cVar) {
        if (i == 0) {
            com.kwad.sdk.core.adlog.c.p(cVar.getAdTemplate(), 1);
            return;
        }
        if (i == 1) {
            if (i2 == 0) {
                if (gVar.tj.lh()) {
                    com.kwad.sdk.core.adlog.c.p(cVar.getAdTemplate(), 1);
                    return;
                }
                return;
            } else if (gVar.tj.lh()) {
                com.kwad.sdk.core.adlog.c.p(cVar.getAdTemplate(), 5);
                return;
            } else {
                com.kwad.sdk.core.adlog.c.p(cVar.getAdTemplate(), 4);
                return;
            }
        }
        if (i != 2) {
            return;
        }
        if (i2 == 0) {
            if (gVar.ti.lh()) {
                com.kwad.sdk.core.adlog.c.p(cVar.getAdTemplate(), 1);
            }
        } else if (gVar.ti.lh()) {
            com.kwad.sdk.core.adlog.c.p(cVar.getAdTemplate(), 3);
        } else {
            com.kwad.sdk.core.adlog.c.p(cVar.getAdTemplate(), 2);
        }
    }
}
