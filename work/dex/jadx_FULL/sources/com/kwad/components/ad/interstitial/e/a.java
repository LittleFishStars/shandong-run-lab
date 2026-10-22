package com.kwad.components.ad.interstitial.e;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.kwad.components.ad.fullscreen.g;
import com.kwad.components.ad.interstitial.c;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.b implements com.kwad.components.core.internal.api.a, KsInterstitialAd {
    private final boolean mE;
    private g mF;
    private com.kwad.components.ad.interstitial.b mG;

    @NonNull
    private final c mH;

    public a(boolean z, @NonNull AdResultData adResultData) {
        super(adResultData);
        this.mE = z;
        if (z) {
            this.mF = new g(adResultData);
        } else {
            this.mG = new com.kwad.components.ad.interstitial.b(adResultData);
        }
        this.mH = new c();
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.mH.a(adInteractionListener);
        if (this.mE) {
            this.mF.setFullScreenVideoAdInteractionListener(this.mH);
        } else {
            this.mG.setAdInteractionListener(this.mH);
        }
    }

    @Override // com.kwad.sdk.api.KsInterstitialAd
    public final void showInterstitialAd(Activity activity, KsVideoPlayConfig ksVideoPlayConfig) {
        if (this.mE) {
            this.mF.showFullScreenVideoAd(activity, ksVideoPlayConfig);
        } else {
            this.mG.showInterstitialAd(activity, ksVideoPlayConfig);
        }
    }
}
