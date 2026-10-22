package com.kc.dw.own.intertitial;

import com.kc.dw.core.ad.interstitial.InterstitialAd;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAd;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnCustomInterstitialAd extends MsCustomInterstitialAd {
    private InterstitialAd ad;

    public OwnCustomInterstitialAd(MsCustomInterstitialAdapter msCustomInterstitialAdapter, String str, InterstitialAd interstitialAd) {
        super(msCustomInterstitialAdapter, str);
        this.ad = interstitialAd;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        InterstitialAd interstitialAd = this.ad;
        return interstitialAd != null ? interstitialAd.getData() : super.getData();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        InterstitialAd interstitialAd = this.ad;
        if (interstitialAd != null) {
            return interstitialAd.isAdValid();
        }
        return true;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        InterstitialAd interstitialAd = this.ad;
        if (interstitialAd != null) {
            interstitialAd.sendLossNotification(map);
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        InterstitialAd interstitialAd = this.ad;
        if (interstitialAd != null) {
            interstitialAd.sendWinNotification(map);
        }
    }
}
