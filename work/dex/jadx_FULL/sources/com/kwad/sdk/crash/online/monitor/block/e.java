package com.kwad.sdk.crash.online.monitor.block;

import com.kwad.sdk.service.ServiceProvider;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e {
    private static com.kwad.sdk.crash.online.monitor.a.a bfi;

    public static com.kwad.sdk.crash.online.monitor.a.a Qy() {
        return bfi;
    }

    public static boolean Qz() {
        com.kwad.sdk.crash.online.monitor.a.a aVar = bfi;
        return aVar != null && aVar.QC();
    }

    public static void d(com.kwad.sdk.crash.online.monitor.a.a aVar) {
        if (aVar == null) {
            return;
        }
        try {
            if (aVar.QF()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "allFuncDisable");
                return;
            }
            if (!a.Qw()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "!hasBlockMonitor");
                return;
            }
            a.a(aVar);
            bfi = aVar;
            boolean zBZ = a.bZ(true);
            com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "hasTenBlockHook:" + zBZ);
            if (aVar.aJV < new Random().nextFloat()) {
                return;
            }
            b.a(aVar);
            if (aVar.QD() && zBZ) {
                c.b(aVar);
            }
            if (aVar.QE()) {
                com.kwad.sdk.core.d.c.d("perfMonitor.BlockManager", "hasOtherBlockMonitor:" + a.ca(false));
            }
        } catch (Throwable th) {
            try {
                ServiceProvider.reportSdkCaughtException(th);
            } catch (Exception unused) {
            }
        }
    }
}
