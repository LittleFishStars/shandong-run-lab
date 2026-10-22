package com.kc.dw.core.ad.interstitial;

import android.app.Activity;
import com.kc.dw.core.ad.a;
import com.kc.dw.core.loader.b;
import com.kc.dw.core.utils.s1;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class InterstitialAd extends a implements IInterstitialAd, Serializable {
    private b adWrapper;

    public InterstitialAd(b bVar, String str) {
        super(bVar, str);
        this.adWrapper = bVar;
    }

    @Override // com.kc.dw.core.ad.interstitial.IInterstitialAd
    public void render() {
    }

    public void showAd(Activity activity) {
        com.kc.dw.core.service.logrecord.a.a(5, "e6", this.adWrapper);
        b bVar = this.adWrapper;
        if (bVar == null || bVar.getSdkAdInfo() == null) {
            return;
        }
        s1.b(this.adWrapper.getSdkAdInfo().getEventUrl());
    }
}
