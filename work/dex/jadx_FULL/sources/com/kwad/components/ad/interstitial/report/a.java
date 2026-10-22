package com.kwad.components.ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.report.a$a, reason: collision with other inner class name */
    public static class C1151a {
        private static final a oq = new a();
    }

    private static void a(String str, com.kwad.sdk.commercial.c.a aVar) {
        if (o.Gs().Fx()) {
            try {
                com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).Q("ad_sdk_interstitial_callback", str).b(BusinessType.AD_INTERSTITIAL).A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static a eV() {
        return C1151a.oq;
    }

    public final void A(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(3L).setAdTemplate(adTemplate));
    }

    public final void b(AdTemplate adTemplate, long j, long j2) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(2L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }

    public final void z(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(1L).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, long j, long j2) {
        a("action_type", new InterstitialReportInfo().setActionType(1L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, double d) {
        a("action_type", new InterstitialReportInfo().setActionType(2L).setVisiblePercent(d).setAdTemplate(adTemplate));
    }
}
