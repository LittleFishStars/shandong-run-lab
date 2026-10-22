package com.kc.dw.platform.ad_adapter.interstitial;

import com.kc.dw.ad.interstitial.g;
import com.kc.dw.core.ad.interstitial.InterstitialAdListener;
import com.kc.dw.core.safe.j;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class c extends j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f39480a;
    public final g b;

    public c(b bVar, a aVar, g gVar) {
        this.f39480a = aVar;
        this.b = gVar;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        a aVar = this.f39480a;
        g gVar = this.b;
        InterstitialAdListener interstitialAdListener = aVar.f39478a;
        if (interstitialAdListener != null) {
            SsdInterstitialAdAdapter ssdInterstitialAdAdapter = new SsdInterstitialAdAdapter(gVar, interstitialAdListener);
            ssdInterstitialAdAdapter.setInterstitialAd(gVar);
            ssdInterstitialAdAdapter.setAdView(gVar.getAdView());
            aVar.f39478a.onAdLoaded(ssdInterstitialAdAdapter);
        }
    }
}
