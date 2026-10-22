package com.kwad.components.ad.c;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h implements d, KsBannerAd {
    private final KsAdVideoPlayConfig ce = new KSAdVideoPlayConfigImpl();

    @NonNull
    private AdResultData mAdResultData;

    @NonNull
    private AdTemplate mAdTemplate;

    public h(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.helper.c.r(adResultData);
    }

    @Override // com.kwad.components.ad.c.d
    public final void b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final int getECPM() {
        return com.kwad.sdk.core.response.helper.a.aX(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final int getInteractionType() {
        return com.kwad.sdk.core.response.helper.a.aW(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final int getMaterialType() {
        return com.kwad.sdk.core.response.helper.a.bk(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public final Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.JP()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final View getView(Context context, KsBannerAd.BannerAdInteractionListener bannerAdInteractionListener, KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        i iVar = null;
        if (context == null || !o.Gs().Fx()) {
            return null;
        }
        try {
            com.kwad.components.ad.c.c.c.ax();
            com.kwad.sdk.commercial.convert.c.cg(this.mAdTemplate);
            i iVar2 = new i(context, this.mAdResultData, ksAdVideoPlayConfig);
            try {
                iVar2.setBannerAdListener(bannerAdInteractionListener);
                iVar2.setBannerUpdateAdResultDataListener(this);
                com.kwad.sdk.commercial.convert.d.f(com.kwad.sdk.core.response.helper.e.eI(this.mAdTemplate), SystemClock.elapsedRealtime() - jElapsedRealtime);
                return iVar2;
            } catch (Throwable th) {
                th = th;
                iVar = iVar2;
                ServiceProvider.reportSdkCaughtException(th);
                return iVar;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final boolean supportPushAd() {
        return false;
    }

    @Override // com.kwad.sdk.api.KsBannerAd
    public final void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(adTemplate, j2);
    }
}
