package com.kwad.components.offline.c.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adWaynePlayer.IAdWaynePlayerOfflineCompo;
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
    private static final String awP = aj.format("lib%s.so", "aegon");
    private static final String awR = aj.format("lib%s.so", "cjson");
    private static final String axA = aj.format("lib%s.so", "AemonPlayer");
    private static final String axB = aj.format("lib%s.so", "ffmpeg");
    private static final String awV = aj.format("lib%s.so", "hodor");
    private static final String axC = aj.format("lib%s.so", "kpwebrtc");
    private static final String axD = aj.format("lib%s.so", "ksaudioprocesslib-dl");
    private static final String axE = aj.format("lib%s.so", "ksaudioprocesslib");
    private static final String axF = aj.format("lib%s.so", "ksp2p");
    private static final String axG = aj.format("lib%s.so", "kwaiplayer_dva");
    private static final String axH = aj.format("lib%s.so", "RtcMediaTransport");
    private static final String axI = aj.format("lib%s.so", "slp2p");
    private static final String axJ = aj.format("lib%s.so", "xyvodsdk");
    private static final String axK = aj.format("lib%s.so", "cpu-infov1");
    private static final String axL = aj.format("lib%s.so", "yuv");

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
            map.put(awP, "333cc7399bdac5e0c5594b20fef820b9");
            map.put(awR, "c776ddaa8d6e4bdc42051fa566df692d");
            map.put(axA, "39366cae51a7cebda67a8a6cfc509e55");
            map.put(axs, "5fb2bd6653d0f3e74745fb74d24b4047");
            map.put(axB, "c5c427bd691e4b3948e3c50bbba9e759");
            map.put(awV, "8195262f0da1a21a997b98e958f49397");
            map.put(axC, "231f59d578548d008b04ab5023510621");
            map.put(axD, "ab8bc42a8460e95846de5436a8cef356");
            map.put(axE, "9f64c805ca3695e9b4c05bb293607c88");
            map.put(axF, "7e86a5b800f7799a2e8f3edd1e3a46fd");
            map.put(axG, "a1f4a38699090782e4793929370b0274");
            map.put(axH, "5fcb2ca4dfeb0e4d0e5343e66edb7d0a");
            map.put(axI, "1be34a5640da785cb7a99a8e457a5370");
            map.put(axJ, "3e376cbc66cbc489f92c90518177ba5d");
            map.put(axK, "c27a219c9d3f7aaec8617a34c4646075");
            map.put(axL, "4ec281a4abfdbb7119143fb26857e102");
            str = "https://p2-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adWaynePlayer/ks_so-adWaynePlayerArm64v8aRelease-3.3.76-e8fbb3a5f8-666.apk";
            str2 = "adWaynePlayer-v8a";
            str3 = "ef09635a47f800d04957d70650017b2d";
        } else {
            map.put(awP, "20fe1d4701c4cd5975ba148b94c36793");
            map.put(awR, "547873311402f6dfc28bd27f310ab680");
            map.put(axA, "1ddb288b9d26e6c93b1e5dc6594180e2");
            map.put(axs, "bf209aecc73c55eb87318d5a64c76478");
            map.put(axB, "8a3f3ac0cbd9b2819674788538768a8f");
            map.put(awV, "22a0687c583a3b0886e79e827a3b018e");
            map.put(axC, "e70414e3787126ad16ce663466c1beff");
            map.put(axD, "cc1342476e392378be4ea4b6f0621e86");
            map.put(axE, "09987f7cbe19016fc049929ee7306930");
            map.put(axF, "722371b2d3caca321c6d0a3ec1b6b4ff");
            map.put(axG, "677277694e40939f144ae464464f9407");
            map.put(axH, "cfc492113e7dd7b377dde2e94ad3675f");
            map.put(axI, "dafb194f4e5ab3a797aaf61933d8f05e");
            map.put(axJ, "2744330ddd8fcf3e83766adcaf04d23b");
            map.put(axK, "b7af666efe7df5f8cbeac671cd7b1353");
            map.put(axL, "e4887fcd52a2cebbd06c9d51a01cbee7");
            str = "https://p2-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adWaynePlayer/ks_so-adWaynePlayerArmeabiv7aRelease-3.3.76-e8fbb3a5f8-666.apk";
            str2 = "adWaynePlayer-v7a";
            str3 = "e54d58329c045aa8e9b0a08fceedb939";
        }
        b bVar = new b();
        com.kwad.library.b.a aVarN = com.kwad.library.solder.a.a.n(context, IAdWaynePlayerOfflineCompo.PACKAGE_NAME);
        c.d("AdWaynePlayerSoLoadHelper", "adWaynePlayerOfflineCompoPlugin: " + aVarN);
        if (aVarN instanceof com.kwad.library.b.a) {
            bVar.aFA = aVarN.DG();
        }
        bVar.aFs = com.kwad.sdk.core.network.idc.a.Mo().eQ(str);
        bVar.enable = true;
        bVar.aFr = str2;
        bVar.version = "3.3.76";
        bVar.aFx = map;
        bVar.aFu = str3;
        bVar.aFv = true;
        com.kwad.library.solder.a.a.a(context, bVar, new com.kwad.library.solder.lib.ext.b.c() { // from class: com.kwad.components.offline.c.a.a.1
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
