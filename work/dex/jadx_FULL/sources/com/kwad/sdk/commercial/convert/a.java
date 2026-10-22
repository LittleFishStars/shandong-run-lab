package com.kwad.sdk.commercial.convert;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.001d).b(com.kwad.sdk.commercial.e.bA(adTemplate)).Q("ad_convert_method_call", "method_name").A(aVar));
    }

    public static void bK(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("adClick"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bL(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("startH5Page"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bM(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("dplinkStart"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bN(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("smallAppSuccess"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bO(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("appstoreStart"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bP(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("disableClick"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bQ(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toVideoH5Web"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bR(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toDownload"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bS(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toOpenApp"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bT(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toInstallApp"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bU(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toDownloadDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bV(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toDownloadThirdDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bW(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toDownloadPage"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bX(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toDownloadPause"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bY(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toDownloadResume"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bZ(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toDownloadNoNet"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void ca(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toDoNoting"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void cb(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toOpenAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void cc(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toOpenDeeplinkDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void cd(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toH5PageDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void ce(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toMiddlePageDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void cf(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.Iq().dt("toSmallAppDialog"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void h(AdTemplate adTemplate, boolean z) {
        try {
            a(adTemplate, b.Iq().dt("adUserClick").bC(z));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
