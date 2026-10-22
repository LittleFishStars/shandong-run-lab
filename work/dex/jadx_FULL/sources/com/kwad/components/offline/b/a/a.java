package com.kwad.components.offline.b.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adLive.IAdLiveOfflineCompo;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aj;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private static final AtomicBoolean awO = new AtomicBoolean(false);
    private static final String axs = aj.format("lib%s.so", "c++_shared");
    private static final String axt = aj.format("lib%s.so", "kwaiplayer");
    private static final String axu = aj.format("lib%s.so", "kste");
    private static final String awV = aj.format("lib%s.so", "hodor");
    private static final String awP = aj.format("lib%s.so", "aegon");

    public static void a(Context context, @NonNull final SoLoadListener soLoadListener) {
        String str;
        String str2;
        String str3;
        AtomicBoolean atomicBoolean = awO;
        if (atomicBoolean.get()) {
            return;
        }
        atomicBoolean.set(true);
        HashMap<String, String> map = new HashMap<>();
        if (AbiUtil.isArm64(context)) {
            map.put(axs, "dcd68cd059cb06a9596ba6839c2e8858");
            map.put(axt, "cf71bcc476b2b25e2e62b541275ad78c");
            map.put(axu, "ebb56fa9c5701350497e281c2446660f");
            map.put(awV, "a61edf93bc5abc7799c5444ccbaf140b");
            map.put(awP, "c256c0d7f79ad4d47db61cb8e8ab142a");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArm64v8aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v8a";
            str3 = "41a4213dcbf3ed262fc69daf7d4a29e5";
        } else {
            map.put(axs, "e3fdbf82716c2cb9b666a3880ab94003");
            map.put(axt, "2ba24f9d0a6e786af477ed1e2dad148b");
            map.put(axu, "71a9baa45905a6f0e527e5a2e06e8808");
            map.put(awV, "d997935a035d00a67dc46e26427b8bf9");
            map.put(awP, "bdac6eea0d25da98061c21234f3b20c5");
            str = "https://p1-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adLive/ks_so-adLiveArmeabiv7aRelease-3.3.44.2-e8fbb3a5f8-666.apk";
            str2 = "adLive-v7a";
            str3 = "ceddd5a3aae9148992bee153a29a25fb";
        }
        b bVar = new b();
        com.kwad.library.b.a aVarN = com.kwad.library.solder.a.a.n(context, IAdLiveOfflineCompo.PACKAGE_NAME);
        c.d("AdLiveSoLoadHelper", "adLiveOfflineCompoPlugin: " + aVarN);
        if (aVarN instanceof com.kwad.library.b.a) {
            bVar.aFA = aVarN.DG();
        }
        bVar.aFs = com.kwad.sdk.core.network.idc.a.Mo().eQ(str);
        bVar.enable = true;
        bVar.aFr = str2;
        bVar.version = "3.3.44.3";
        bVar.aFx = map;
        bVar.aFu = str3;
        bVar.aFv = true;
        com.kwad.library.solder.a.a.a(context, bVar, new com.kwad.library.solder.lib.ext.b.c() { // from class: com.kwad.components.offline.b.a.a.1
            private void Am() {
                soLoadListener.onLoaded();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            public final /* synthetic */ void a(e eVar, com.kwad.library.solder.lib.a.a aVar) {
                Am();
            }

            @Override // com.kwad.library.solder.lib.ext.b.C1264b, com.kwad.library.solder.lib.ext.b
            public final /* bridge */ /* synthetic */ void a(e eVar, PluginError pluginError) {
                a(pluginError);
            }

            private void a(PluginError pluginError) {
                soLoadListener.onFailed(pluginError.getCode(), pluginError);
            }
        });
    }
}
