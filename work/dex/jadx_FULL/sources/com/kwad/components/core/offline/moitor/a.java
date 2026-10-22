package com.kwad.components.core.offline.moitor;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {
    private static void a(b bVar) {
        a(bVar, false);
    }

    public static void b(String str, long j, int i) {
        try {
            a(new b().aS(str).L(j).bs(i).K(2L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j) {
        try {
            a(new b().aS(str).L(j).K(1L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(String str, long j) {
        try {
            a(new b().aS(str).L(j).K(6L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(b bVar, boolean z) {
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.01d).Q("ad_sdk_offline_component_monitor", "load_status").A(bVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
    }

    public static void c(String str, long j, String str2) {
        try {
            a(new b().aS(str).L(j).aU(str2).K(4L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, long j, String str2) {
        try {
            a(new b().aS(str).L(j).aU(str2).K(3L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, int i, String str2, String str3) {
        try {
            a(new b().aS(str).L(j).setErrorCode(i).aU(str3).aT(str2).K(7L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j, int i) {
        try {
            a(new b().aS(str).K(8L).bs(i).L(j));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, String str2) {
        try {
            a(new b().aS(str).aU(str2).L(j).K(5L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
