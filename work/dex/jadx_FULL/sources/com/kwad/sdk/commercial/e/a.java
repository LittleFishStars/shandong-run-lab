package com.kwad.sdk.commercial.e;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void d(AdTemplate adTemplate, String str, String str2) {
        try {
            a(adTemplate, true, b.It().dB(6).dA(str).setErrorCode(100007).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void o(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.It().dB(1).dA(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void p(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.It().dB(2).dA(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void q(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.It().dB(3).dA(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void r(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.It().dB(4).dA(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void s(AdTemplate adTemplate, String str) {
        try {
            a(adTemplate, b.It().dB(5).dA(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        c.d(d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.01d).b(e.bA(adTemplate)).Q("ad_sdk_deeplink_performance", "status").A(aVar));
    }
}
