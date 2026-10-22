package com.kwad.sdk.api.core;

import android.content.Context;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.loader.Wrapper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@KsAdSdkDynamicApi
@Keep
public abstract class AbstrackKsSplashScreenAd implements KsSplashScreenAd {
    @Override // com.kwad.sdk.api.KsSplashScreenAd
    @Nullable
    @KsAdSdkDynamicApi
    public View getView(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        return getView2(Wrapper.wrapContextIfNeed(context), splashScreenAdInteractionListener);
    }

    @Nullable
    @KsAdSdkDynamicApi
    public abstract View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener);
}
