package com.kwad.components.ad.interstitial;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    public static KsInterstitialAd f(@NonNull AdResultData adResultData) {
        int iFg = com.kwad.sdk.core.response.helper.e.fg(com.kwad.sdk.core.response.helper.c.r(adResultData));
        if (iFg != 1) {
            return iFg != 2 ? new b(adResultData) : new com.kwad.components.ad.interstitial.e.a(false, adResultData);
        }
        return new com.kwad.components.ad.interstitial.e.a(true, adResultData);
    }
}
