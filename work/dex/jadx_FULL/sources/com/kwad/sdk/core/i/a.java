package com.kwad.sdk.core.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static c aZb;
    private static c aZc;

    public static c k(boolean z, boolean z2) {
        c cVar;
        com.kwad.sdk.core.d.c.d("KSUserAgentManager", "obtainUAGetter useKwaiUA: " + z + ", unionUAMark: " + z2);
        if (z) {
            if (aZb == null) {
                aZb = new b();
            }
            cVar = aZb;
        } else {
            if (aZc == null) {
                aZc = new d();
            }
            cVar = aZc;
        }
        cVar.bJ(z2);
        com.kwad.sdk.core.d.c.d("KSUserAgentManager", "obtainUAGetter result: " + cVar);
        return cVar;
    }
}
