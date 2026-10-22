package com.kwad.components.offline.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.adInnerEc.IAdInnerEcOfflineCompo;
import com.kwad.components.offline.api.core.soloader.SoLoadListener;
import com.kwad.library.solder.lib.a.e;
import com.kwad.library.solder.lib.c.b;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.aj;
import com.zj.adlib.v74;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private static final AtomicBoolean awO = new AtomicBoolean(false);
    private static final String awP = aj.format("lib%s.so", "aegon");
    private static final String awQ = aj.format("lib%s.so", "AemonPlayer");
    private static final String awR = aj.format("lib%s.so", "cjson");
    private static final String awS = aj.format("lib%s.so", "cpu-info");
    private static final String awT = aj.format("lib%s.so", "cpu-monitor");
    private static final String awU = aj.format("lib%s.so", "godzilla");
    private static final String awV = aj.format("lib%s.so", "hodor");
    private static final String awW = aj.format("lib%s.so", "kpwebrtc");
    private static final String awX = aj.format("lib%s.so", "ksp2p");
    private static final String awY = aj.format("lib%s.so", "kwaiplayer_dva");
    private static final String awZ = aj.format("lib%s.so", "magtsdk");
    private static final String axa = aj.format("lib%s.so", "native-filters");
    private static final String axb = aj.format("lib%s.so", "RtcMediaTransport");
    private static final String axc = aj.format("lib%s.so", "slp2p");
    private static final String axd = aj.format("lib%s.so", "snow");
    private static final String axe = aj.format("lib%s.so", "xyvodsdk");
    private static final String axf = aj.format("lib%s.so", "gifimage");
    private static final String axg = aj.format("lib%s.so", v74.f45299a);
    private static final String axh = aj.format("lib%s.so", "mmkv");
    private static final String axi = aj.format("lib%s.so", "static-webp");
    private static final String axj = aj.format("lib%s.so", "c++_shared");
    private static final String axk = aj.format("lib%s.so", "ksse");
    private static final String axl = aj.format("lib%s.so", "kwsgmain");

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
            map.put(awP, "db684e5c8fd0e749d13583f702df0d17");
            map.put(awQ, "115b42443fa44dca2c81dd12bbada5bc");
            map.put(awR, "c776ddaa8d6e4bdc42051fa566df692d");
            map.put(awS, "cd610ff8f53feff53eff772480f0534b");
            map.put(awT, "1812b2b17d5b0e9153ebcdd85ed73a5c");
            map.put(awU, "8c560e11bec1ccdf178e4737b9ae2a81");
            map.put(awV, "a127cd07c0727a365098b9ff95b0ebdb");
            map.put(awW, "ed70abdb329f52256e4f8e5cd0b9f8ac");
            map.put(awX, "7e86a5b800f7799a2e8f3edd1e3a46fd");
            map.put(awY, "ff3eed56b0da912d7287196cd200637b");
            map.put(awZ, "651f41323daa61f6d7096691d7614ded");
            map.put(axa, "355cc1c5a90f79225116e5f1486876d6");
            map.put(axb, "5fcb2ca4dfeb0e4d0e5343e66edb7d0a");
            map.put(axc, "1be34a5640da785cb7a99a8e457a5370");
            map.put(axd, "c779f4622b43cea18d7d91c1b85dd0df");
            map.put(axe, "3e376cbc66cbc489f92c90518177ba5d");
            map.put(axf, "67aef3cf1b63f99176b2e6c7a419c962");
            map.put(axg, "4886944eb1b799bae7fa6465321a85d6");
            map.put(axh, "42524ab638b269f0cc3aefd8f4087e96");
            map.put(axi, "d9cfe52877b24f60ab826758ce88020d");
            map.put(axj, "5fb2bd6653d0f3e74745fb74d24b4047");
            map.put(axk, "6430d71e66d372f48aa2032fce7d26cc");
            map.put(axl, "21f950215f13f748bc8f8bed33601026");
            str = "https://p2-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adInnerEc/4.10.30.2/ks_so-adInnerEcSoArm64v8aRelease-4.10.30.2-4a9af8acf6-0.apk";
            str2 = "adInnerEc-v8a";
            str3 = "a700769b6913b295f574c95e16d21c07";
        } else {
            map.put(awP, "41fa3c05f100f88ac32bb097f07e93ba");
            map.put(awQ, "71380bbaaf229d6e12b68541b22fdadc");
            map.put(awR, "547873311402f6dfc28bd27f310ab680");
            map.put(awS, "e48777ac3caae5dbccf4c25469793732");
            map.put(awT, "d04a923cd7391845106aa007b1821b78");
            map.put(awU, "ca5a42e46c44e57c3275a519b7ca8874");
            map.put(awV, "db09ff30053b458b966d03475175caff");
            map.put(awW, "27457ffda99e662dde5e13b7c8b40938");
            map.put(awX, "722371b2d3caca321c6d0a3ec1b6b4ff");
            map.put(awY, "44e41fac26d1123dd8e8500c22cd4f1d");
            map.put(awZ, "6fc9e26478610245f6b2e39c9b763813");
            map.put(axa, "620de13329bc28f975ce26e2f8befada");
            map.put(axb, "cfc492113e7dd7b377dde2e94ad3675f");
            map.put(axc, "dafb194f4e5ab3a797aaf61933d8f05e");
            map.put(axd, "235d0c1e6759f9bf40eb20eb18c5d76d");
            map.put(axe, "2744330ddd8fcf3e83766adcaf04d23b");
            map.put(axf, "5c7b8a85dbfbee253ec04d07e75880c7");
            map.put(axg, "4ba340a75b0e883cdfead457ebfb5b69");
            map.put(axh, "245b72502250816158f1637413079189");
            map.put(axi, "ce708c75001ab2b97526b391163eb10e");
            map.put(axj, "bf209aecc73c55eb87318d5a64c76478");
            map.put(axk, "028f3cd812b77d1d789dce7f8d6b22f0");
            map.put(axl, "c7b223cacabb4726c9222c0708175450");
            str = "https://p2-lm.adkwai.com/udata/pkg/KS-Android-KSAdSDk/adInnerEc/4.10.30.2/ks_so-adInnerEcSoArmeabiv7aRelease-4.10.30.2-4a9af8acf6-0.apk";
            str2 = "adInnerEc-v7a";
            str3 = "2c94576d61b23eaa8b7e88bc7490eb50";
        }
        b bVar = new b();
        com.kwad.library.b.a aVarN = com.kwad.library.solder.a.a.n(context, IAdInnerEcOfflineCompo.PACKAGE_NAME);
        if (aVarN instanceof com.kwad.library.b.a) {
            bVar.aFA = aVarN.DG();
        }
        bVar.aFs = com.kwad.sdk.core.network.idc.a.Mo().eQ(str);
        bVar.enable = true;
        bVar.aFr = str2;
        bVar.version = "4.10.30.2";
        bVar.aFx = map;
        bVar.aFu = str3;
        bVar.aFv = true;
        com.kwad.library.solder.a.a.a(context, bVar, new com.kwad.library.solder.lib.ext.b.c() { // from class: com.kwad.components.offline.a.a.a.1
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
