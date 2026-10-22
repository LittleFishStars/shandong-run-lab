package com.kwad.sdk.commercial.a;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.commercial.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    public static void B(AdTemplate adTemplate) {
        a(adTemplate, b.Io().du(1).setAdTemplate(adTemplate));
    }

    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void bC(AdTemplate adTemplate) {
        a(adTemplate, b.Io().du(3).setAdTemplate(adTemplate));
    }

    public static void bD(AdTemplate adTemplate) {
        a(adTemplate, b.Io().du(4).setAdTemplate(adTemplate));
    }

    public static void bE(AdTemplate adTemplate) {
        a(adTemplate, b.Io().du(5).setAdTemplate(adTemplate));
    }

    public static void bF(AdTemplate adTemplate) {
        i(adTemplate, 100002, "");
    }

    public static void bG(AdTemplate adTemplate) {
        a(adTemplate, b.Io().du(7).dv(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate));
    }

    public static void bH(AdTemplate adTemplate) {
        int i = 1;
        b bVarDv = b.Io().du(8).dv(adTemplate.mInstallApkFormUser ? 1 : 2);
        if (!adTemplate.mInstallApkFromSDK) {
            i = adTemplate.mClickOpenAppStore ? 2 : 0;
        }
        a(adTemplate, bVarDv.dw(i).setAdTemplate(adTemplate));
    }

    public static void bI(AdTemplate adTemplate) {
        int i;
        b bVarDu = b.Io().du(10);
        if (adTemplate.mInstallApkFromSDK) {
            i = 1;
        } else {
            i = adTemplate.mClickOpenAppStore ? 2 : 0;
        }
        a(adTemplate, bVarDu.dw(i).setAdTemplate(adTemplate));
    }

    public static void i(AdTemplate adTemplate, int i, String str) {
        a(adTemplate, true, b.Io().du(6).setAdTemplate(adTemplate).setErrorCode(i).setErrorMsg(str));
    }

    public static void j(AdTemplate adTemplate, int i, String str) {
        a(adTemplate, true, b.Io().du(9).dv(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate).setErrorCode(100003).setErrorMsg(str));
    }

    public static void k(AdTemplate adTemplate, long j) {
        a(adTemplate, b.Io().du(2).ax(j).setAdTemplate(adTemplate));
    }

    private static void a(AdTemplate adTemplate, boolean z, com.kwad.sdk.commercial.c.a aVar) {
        try {
            c.d(d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.1d).b(e.bA(adTemplate)).Q("ad_sdk_download_performance", "status").A(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
