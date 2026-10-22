package com.kwad.components.ad.c.c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {
    public static void a(SceneImpl sceneImpl, int i) {
        a(b.av().v(1).w(sceneImpl.getAdNum()).A(i).setPosId(sceneImpl.getPosId()), false);
    }

    public static void aw() {
        b(a.au().s(1), false);
    }

    public static void ax() {
        a((com.kwad.sdk.commercial.c.a) b.av().v(6), false);
    }

    public static void b(AdTemplate adTemplate, int i, int i2) {
        b(a.au().s(4).t(i).u(i2).setAdTemplate(adTemplate), false);
    }

    public static void c(AdTemplate adTemplate, int i, int i2) {
        AdInfo adInfoEO = e.eO(adTemplate);
        a(b.av().v(10).y(1).z(i2).x(com.kwad.sdk.core.response.helper.a.bk(adInfoEO)).p(com.kwad.sdk.core.response.helper.a.bh(adInfoEO)).setAdTemplate(adTemplate), false);
    }

    public static void d(int i, String str) {
        b(a.au().s(2).setErrorMsg(str).setErrorCode(i), true);
    }

    public static void e(AdTemplate adTemplate, int i, int i2) {
        AdInfo adInfoEO = e.eO(adTemplate);
        a(b.av().v(11).y(1).x(com.kwad.sdk.core.response.helper.a.bk(adInfoEO)).p(com.kwad.sdk.core.response.helper.a.bh(adInfoEO)).z(i2).setAdTemplate(adTemplate), false);
    }

    public static void f(AdTemplate adTemplate) {
        AdInfo adInfoEO = e.eO(adTemplate);
        a(b.av().x(com.kwad.sdk.core.response.helper.a.bk(adInfoEO)).p(com.kwad.sdk.core.response.helper.a.M(adInfoEO)).v(4).setAdTemplate(adTemplate), true);
    }

    public static void d(AdTemplate adTemplate, int i, int i2) {
        b(a.au().s(5).t(1).u(i2).setAdTemplate(adTemplate), false);
    }

    public static void a(SceneImpl sceneImpl, int i, long j, int i2) {
        a(b.av().v(2).g(j).A(i2).w(i).setPosId(sceneImpl.getPosId()), false);
    }

    private static void b(com.kwad.sdk.commercial.c.a aVar, boolean z) {
        try {
            com.kwad.sdk.commercial.c.d(d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.001d).b(BusinessType.OTHER).Q("ad_sdk_banner_callback", "callback_type").A(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void f(AdTemplate adTemplate, int i, int i2) {
        b(a.au().s(6).t(1).u(i2).setAdTemplate(adTemplate), false);
    }

    public static void a(SceneImpl sceneImpl, int i, String str, long j, int i2) {
        try {
            com.kwad.sdk.commercial.c.d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(0.01d).b(BusinessType.OTHER).Q("ad_sdk_banner_load", "status").A(b.av().v(3).g(j).A(i2).w(0).setPosId(sceneImpl.getPosId()).setErrorCode(i).setErrorMsg(str)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, int i, long j) {
        a(b.av().v(5).e(j).w(i).setPosId(sceneImpl.getPosId()), false);
    }

    public static void a(AdTemplate adTemplate, long j, int i, int i2, boolean z) {
        try {
            AdInfo adInfoEO = e.eO(adTemplate);
            com.kwad.sdk.commercial.c.d(d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 0.01d : 0.001d).b(BusinessType.AD_BANNER).Q("ad_sdk_banner_load", "status").A(b.av().v(7).f(j).x(com.kwad.sdk.core.response.helper.a.bk(adInfoEO)).p(com.kwad.sdk.core.response.helper.a.bh(adInfoEO)).y(i).z(i2).setAdTemplate(adTemplate)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i, int i2) {
        b(a.au().s(3).t(i).u(i2).setAdTemplate(adTemplate), false);
    }

    public static void a(AdTemplate adTemplate, long j, String str) {
        AdInfo adInfoEO = e.eO(adTemplate);
        a(b.av().v(8).f(j).x(com.kwad.sdk.core.response.helper.a.bk(adInfoEO)).p(com.kwad.sdk.core.response.helper.a.bh(adInfoEO)).setAdTemplate(adTemplate).setErrorMsg(str), true);
    }

    public static void a(AdTemplate adTemplate, long j, int i, int i2) {
        AdInfo adInfoEO = e.eO(adTemplate);
        a(b.av().v(9).x(com.kwad.sdk.core.response.helper.a.bk(adInfoEO)).f(j).p(com.kwad.sdk.core.response.helper.a.bh(adInfoEO)).y(i).z(i2).setAdTemplate(adTemplate), false);
    }

    private static void a(com.kwad.sdk.commercial.c.a aVar, boolean z) {
        try {
            com.kwad.sdk.commercial.c.d(d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.001d).b(BusinessType.OTHER).Q("ad_sdk_banner_load", "status").A(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
