package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.core.AbstrackKsSplashScreenAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicApi;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.kwad.sdk.api.model.KSAdInfoData;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class KsSplashScreenAdControl extends AbstrackKsSplashScreenAd implements com.kwad.components.core.internal.api.a {
    private KsScene Gz;
    private com.kwad.components.core.internal.api.c bz = new com.kwad.components.core.internal.api.c();
    private com.kwad.sdk.core.j.b dH = new com.kwad.sdk.core.j.b() { // from class: com.kwad.components.ad.splashscreen.KsSplashScreenAdControl.1
        @Override // com.kwad.sdk.core.j.b
        public final void aP() {
            KsSplashScreenAdControl.this.bz.h(KsSplashScreenAdControl.this);
        }

        @Override // com.kwad.sdk.core.j.b
        public final void aQ() {
            KsSplashScreenAdControl.this.bz.i(KsSplashScreenAdControl.this);
        }
    };

    @NonNull
    private final AdResultData mAdResultData;

    @NonNull
    private final AdTemplate mAdTemplate;

    public KsSplashScreenAdControl(@NonNull KsScene ksScene, @NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        this.Gz = ksScene;
        this.mAdTemplate = adResultData.getAdTemplateList().get(0);
        com.kwad.components.ad.i.b.gd().a(this);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void b(com.kwad.components.core.internal.api.b bVar) {
        this.bz.b(bVar);
    }

    @Override // com.kwad.components.core.internal.api.a
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getECPM() {
        return com.kwad.sdk.core.response.helper.a.aX(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
    }

    @NonNull
    @KsAdSdkDynamicApi
    @Keep
    public KsFragment getFragment2(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        com.kwad.sdk.commercial.convert.c.cg(this.mAdTemplate);
        com.kwad.components.ad.splashscreen.a.a aVar = (com.kwad.components.ad.splashscreen.a.a) com.kwad.sdk.components.d.f(com.kwad.components.ad.splashscreen.a.a.class);
        if (aVar != null) {
            return aVar.a(this.mAdResultData, this.dH, splashScreenAdInteractionListener);
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getInteractionType() {
        return com.kwad.sdk.core.response.helper.a.aW(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public KSAdInfoData getKSAdInfoData() {
        if (com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPU)) {
            return com.kwad.sdk.core.response.helper.a.dr(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
        }
        return null;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public int getMaterialType() {
        return com.kwad.sdk.core.response.helper.a.bk(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
    }

    @Override // com.kwad.sdk.api.BaseKSAd
    public Map<String, Object> getMediaExtraInfo() {
        HashMap map = new HashMap();
        if (com.kwad.sdk.core.config.e.JP()) {
            map.put("llsid", Long.valueOf(this.mAdTemplate.llsid));
        }
        return map;
    }

    @Override // com.kwad.sdk.api.core.AbstrackKsSplashScreenAd
    @Nullable
    public View getView2(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) throws Throwable {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (context == null || !o.Gs().Fx()) {
            return null;
        }
        com.kwad.sdk.commercial.convert.c.cg(this.mAdTemplate);
        c cVarA = c.a(context, this.mAdResultData, true, this.dH, splashScreenAdInteractionListener);
        try {
            com.kwad.sdk.commercial.convert.d.f(com.kwad.sdk.core.response.helper.e.eI(this.mAdTemplate), SystemClock.elapsedRealtime() - jElapsedRealtime);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        return cVarA;
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isAdEnable() {
        if (SplashPreloadManager.lZ().h(this.mAdResultData)) {
            return true;
        }
        SplashPreloadManager.lZ();
        return SplashPreloadManager.i(this.mAdResultData);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public boolean isVideo() {
        return com.kwad.sdk.core.response.helper.a.bi(com.kwad.sdk.core.response.helper.e.eO(this.mAdResultData.getAdTemplateList().get(0)));
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void reportAdExposureFailed(int i, AdExposureFailedReason adExposureFailedReason) {
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, i, adExposureFailedReason);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(int i) {
        setBidEcpm(i, -1L);
    }

    @Keep
    public boolean showSplashMiniWindowIfNeeded(Context context, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener, Rect rect) {
        return false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final boolean supportPushAd() {
        return false;
    }

    @Override // com.kwad.components.core.internal.api.a
    public final void a(com.kwad.components.core.internal.api.b bVar) {
        this.bz.a(bVar);
    }

    @Override // com.kwad.sdk.api.KsSplashScreenAd
    public void setBidEcpm(long j, long j2) {
        AdTemplate adTemplate = this.mAdTemplate;
        adTemplate.mBidEcpm = j;
        com.kwad.sdk.core.adlog.c.m(adTemplate, j2);
    }
}
