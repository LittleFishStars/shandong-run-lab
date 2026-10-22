package com.kwad.sdk.kgeo;

import android.content.Context;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.be;
import com.kwad.sdk.utils.t;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class c {
    private static final AtomicBoolean sHasInit = new AtomicBoolean(false);

    public interface a {
        void onSuccess(String str);

        void rc();
    }

    public static void a(final Context context, final a aVar) {
        if (be.useMacAddressDisable()) {
            aVar.rc();
            return;
        }
        if (!t.UH()) {
            aVar.rc();
            return;
        }
        AtomicBoolean atomicBoolean = sHasInit;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        boolean zIsArm64 = AbiUtil.isArm64(context);
        com.kwad.library.solder.lib.c.b bVar = new com.kwad.library.solder.lib.c.b();
        bVar.version = "1.0.3";
        bVar.aFr = zIsArm64 ? "kmc-v8a" : "kmc-v7a";
        bVar.aFs = com.kwad.sdk.core.network.idc.a.Mo().eQ(zIsArm64 ? "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac64" : "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/kmac/ks_kmac32");
        bVar.aFu = zIsArm64 ? "db9a8da62a0354ec5710ec03e2743f07" : "2440a8221230913d4287c6b1e02b49f1";
        bVar.enable = true;
        com.kwad.library.solder.a.a.a(context, bVar, new com.kwad.library.solder.lib.ext.b.c() { // from class: com.kwad.sdk.kgeo.c.1
            private void Am() {
                com.kwad.sdk.core.d.c.d("KGeoSoHelper", "onPostLoad");
                try {
                    System.loadLibrary("ipneigh-android");
                    aVar.onSuccess(com.kwai.library.ipneigh.c.eV(context).bvn);
                } catch (Throwable unused) {
                    com.kwad.sdk.core.d.c.d("KGeoSoHelper", "loadLibrary fail");
                    aVar.rc();
                }
            }

            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar2) {
                Am();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                com.kwad.sdk.core.d.c.d("KGeoSoHelper", "onFail error:" + pluginError.getMessage());
                aVar.rc();
            }
        });
    }
}
