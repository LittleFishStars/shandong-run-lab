package com.kwad.components.ad.splashscreen.c;

import android.content.Context;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.splashscreen.a.a {
    @Override // com.kwad.components.ad.splashscreen.a.a
    public final KsFragment a(AdResultData adResultData, com.kwad.sdk.core.j.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        return b.b(adResultData, bVar, splashScreenAdInteractionListener);
    }

    @Override // com.kwad.sdk.components.b
    public final Class getComponentsType() {
        return com.kwad.components.ad.splashscreen.a.a.class;
    }

    @Override // com.kwad.sdk.components.b
    public final void init(Context context) {
    }
}
