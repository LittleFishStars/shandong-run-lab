package com.kwad.components.ad.draw.a;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    public static void a(SceneImpl sceneImpl, String str) {
        try {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).b(BusinessType.AD_DRAW).Q("ad_sdk_draw_params_monitor", "method_name").A(b.aS().q(str).setPosId(sceneImpl.getPosId())));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(SceneImpl sceneImpl) {
        a(b.aS().D(1).E(sceneImpl.getAdNum()).setPosId(sceneImpl.getPosId()), false);
    }

    public static void c(SceneImpl sceneImpl, int i, long j) {
        a(b.aS().D(5).h(j).E(i).setPosId(sceneImpl.getPosId()), false);
    }

    public static void g(AdTemplate adTemplate, int i, int i2) {
        a(b.aS().D(9).G(i).H(i2).setAdTemplate(adTemplate), false);
    }

    public static void h(AdTemplate adTemplate, int i, int i2) {
        a(b.aS().D(10).G(i).H(i2).setAdTemplate(adTemplate), false);
    }

    public static void l(AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        a(b.aS().F(com.kwad.sdk.core.response.helper.a.bk(adInfoEO)).r(com.kwad.sdk.core.response.helper.a.M(adInfoEO)).I(adTemplate.adStyle).D(4).setAdTemplate(adTemplate), true);
    }

    public static void m(AdTemplate adTemplate) {
        a(b.aS().D(6).setAdTemplate(adTemplate), false);
    }

    public static void b(SceneImpl sceneImpl, int i, long j) {
        a(b.aS().D(2).j(j).E(i).setPosId(sceneImpl.getPosId()), false);
    }

    public static void c(SceneImpl sceneImpl) {
        b(a.aR().C(1).setPosId(sceneImpl.getPosId()), false);
    }

    public static void c(AdTemplate adTemplate, long j, String str) {
        a(b.aS().D(8).i(j).setAdTemplate(adTemplate).setErrorMsg(str), true);
    }

    public static void b(AdTemplate adTemplate, long j, int i, int i2, boolean z) {
        try {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 0.01d : 0.001d).b(BusinessType.AD_DRAW).Q("ad_sdk_draw_load", "status").A(b.aS().D(7).i(j).G(i).H(i2).setAdTemplate(adTemplate)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, int i, String str, long j) {
        try {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(0.01d).b(BusinessType.AD_DRAW).Q("ad_sdk_draw_load", "status").A(b.aS().D(3).j(j).E(0).setPosId(sceneImpl.getPosId()).setErrorCode(i).setErrorMsg(str)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(AdTemplate adTemplate, int i) {
        b(a.aR().C(4).B(i).setAdTemplate(adTemplate), false);
    }

    public static void a(SceneImpl sceneImpl, int i, String str) {
        b(a.aR().C(2).setErrorCode(i).setErrorMsg(str).setPosId(sceneImpl.getPosId()), true);
    }

    private static void b(com.kwad.sdk.commercial.c.a aVar, boolean z) {
        try {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.001d).b(BusinessType.AD_DRAW).Q("ad_sdk_draw_callback", "callback_type").A(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i) {
        b(a.aR().C(3).B(i).setAdTemplate(adTemplate), false);
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar, boolean z) {
        try {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.001d).b(BusinessType.AD_DRAW).Q("ad_sdk_draw_load", "status").A(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
