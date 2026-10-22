package com.kwad.components.ad.interstitial;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.c implements com.kwad.components.ad.b.f {
    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.b.f.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }

    @Override // com.kwad.components.ad.b.f
    public final void loadInterstitialAd(@NonNull final KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        a(new com.kwad.sdk.g.a<Boolean>() { // from class: com.kwad.components.ad.interstitial.a.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Boolean bool) {
                if (bool.booleanValue()) {
                    f.loadInterstitialAd(ksScene, interstitialAdListener);
                    return;
                }
                KsLoadManager.InterstitialAdListener interstitialAdListener2 = interstitialAdListener;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aTn;
                interstitialAdListener2.onError(eVar.errorCode, eVar.msg);
            }
        });
    }
}
