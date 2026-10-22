package com.kwad.components.core.offline.moitor;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.service.ServiceProvider;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c {
    private static void a(d dVar, boolean z) {
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).g(z ? 1.0d : 0.01d).Q("ad_sdk_offline_component_update", "load_status").A(dVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
    }

    public static void b(String str, long j, int i, String str2, String str3) {
        try {
            a(new d().aV(str).N(j).setErrorCode(i).aX(str2).aW(str3).M(2L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(String str, long j, String str2) {
        try {
            a(new d().aV(str).aX(str2).N(j).M(1L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j, long j2, String str2) {
        try {
            a(new d().aV(str).N(j).O(j2).aX(str2).M(3L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
