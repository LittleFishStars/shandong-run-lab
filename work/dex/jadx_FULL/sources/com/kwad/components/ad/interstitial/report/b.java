package com.kwad.components.ad.interstitial.report;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {

    public static class a {
        private static final b or = new b();
    }

    private static void a(boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.01d).Q("ad_sdk_interstitial_download_error", "status").b(BusinessType.AD_INTERSTITIAL).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.b.buT));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static b eX() {
        return a.or;
    }

    public final void B(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo().setDownloadType(adTemplate.getDownloadType()).setStatus(1).setAdTemplate(adTemplate));
    }

    public final void b(@NonNull AdTemplate adTemplate, String str) {
        AdInfo adInfoEO = e.eO(adTemplate);
        a(true, new InterstitialReportInfo().setCreativeId(com.kwad.sdk.core.response.helper.a.L(adInfoEO)).setVideoUrl(com.kwad.sdk.core.response.helper.a.M(adInfoEO)).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setVideoDuration(com.kwad.sdk.core.response.helper.a.N(adInfoEO) * 1000).setStatus(2).setErrorMsg(str).setAdTemplate(adTemplate));
    }
}
