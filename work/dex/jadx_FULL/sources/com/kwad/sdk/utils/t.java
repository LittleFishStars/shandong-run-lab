package com.kwad.sdk.utils;

import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class t {
    private static boolean boQ;
    private static boolean boR;

    public static boolean UG() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(2L)) & boQ;
    }

    public static boolean UH() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(4L)) & boQ;
    }

    public static boolean UI() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(2048L)) & boQ;
    }

    public static boolean UJ() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).FG() && boQ;
    }

    public static boolean UK() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(16L)) & boQ;
    }

    public static boolean UL() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(4096L)) & boQ;
    }

    public static boolean UM() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(1L)) & boQ;
    }

    public static boolean UN() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(128L)) & boQ;
    }

    public static boolean UO() {
        return (!((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ao(128L)) & boQ;
    }

    public static synchronized void ct(boolean z) {
        if (boR) {
            return;
        }
        boR = true;
        boQ = true;
        GlobalThreadPools.Oi().execute(new bi() { // from class: com.kwad.sdk.utils.t.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                ((com.kwad.sdk.service.a.b) ServiceProvider.get(com.kwad.sdk.service.a.b.class)).Fq();
            }
        });
    }
}
