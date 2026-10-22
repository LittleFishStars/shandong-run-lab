package com.kwad.sdk;

import androidx.annotation.NonNull;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public final class h {
    private static AdHttpProxy aFY;

    @NonNull
    public static AdHttpProxy EG() {
        AdHttpProxy adHttpProxy = aFY;
        if (adHttpProxy != null) {
            return adHttpProxy;
        }
        if (com.kwad.framework.a.a.pe.booleanValue()) {
            return EH();
        }
        try {
            if (com.kwad.sdk.core.network.a.c.Mm() != null) {
                aFY = new com.kwad.sdk.core.network.c.b();
            } else {
                aFY = new com.kwad.sdk.core.network.c.a();
            }
        } catch (Throwable unused) {
            aFY = new com.kwad.sdk.core.network.c.a();
        }
        return aFY;
    }

    private static AdHttpProxy EH() {
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        return new Random().nextInt(5) != 0 ? new com.kwad.sdk.core.network.c.b() : new com.kwad.sdk.core.network.c.a();
    }
}
