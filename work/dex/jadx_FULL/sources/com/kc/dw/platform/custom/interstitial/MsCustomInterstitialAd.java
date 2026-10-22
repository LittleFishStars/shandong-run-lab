package com.kc.dw.platform.custom.interstitial;

import android.app.Activity;
import com.kc.dw.core.ad.interstitial.InterstitialAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCustomInterstitialAd extends InterstitialAd {
    private MsCustomInterstitialAdapter adWrapper;

    public MsCustomInterstitialAd(MsCustomInterstitialAdapter msCustomInterstitialAdapter, String str) {
        super(msCustomInterstitialAdapter, str);
        this.adWrapper = msCustomInterstitialAdapter;
    }

    @Override // com.kc.dw.core.ad.a
    public HashMap<String, Object> getExtraMap() {
        MsCustomInterstitialAdapter msCustomInterstitialAdapter = this.adWrapper;
        if (msCustomInterstitialAdapter != null) {
            return msCustomInterstitialAdapter.getExtraMap();
        }
        return null;
    }

    @Override // com.kc.dw.core.ad.interstitial.InterstitialAd, com.kc.dw.core.ad.interstitial.IInterstitialAd
    public void render() {
        MsCustomInterstitialAdapter msCustomInterstitialAdapter;
        if (!isMSPlatform() || isAutoRender() || (msCustomInterstitialAdapter = this.adWrapper) == null) {
            return;
        }
        msCustomInterstitialAdapter.render();
    }

    @Override // com.kc.dw.core.ad.interstitial.InterstitialAd
    public void showAd(Activity activity) {
        super.showAd(activity);
        MsCustomInterstitialAdapter msCustomInterstitialAdapter = this.adWrapper;
        if (msCustomInterstitialAdapter != null) {
            msCustomInterstitialAdapter.setAdShowStatus(true);
            this.adWrapper.showAd(activity);
        }
    }
}
