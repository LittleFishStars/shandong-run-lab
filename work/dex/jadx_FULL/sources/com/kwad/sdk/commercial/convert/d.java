package com.kwad.sdk.commercial.convert;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class d {
    private static void B(final com.kwad.sdk.commercial.c.a aVar) {
        GlobalThreadPools.Oi().execute(new bi() { // from class: com.kwad.sdk.commercial.convert.d.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                try {
                    com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.001d).b(BusinessType.OTHER).Q("ad_sdk_link_time", "status").A(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
            }
        });
    }

    public static void a(int i, long j, int i2) {
        B(AdLinkMonitorMsg.obtain().setAdStyle(i).setDurationTime(j).setStatus(1).setMaterialLoadType(i2));
    }

    public static void b(int i, int i2, long j) {
        B(AdLinkMonitorMsg.obtain().setAdStyle(i).setDurationTime(j).setStatus(4).setRenderType(i2));
    }

    public static void e(int i, long j) {
        B(AdLinkMonitorMsg.obtain().setAdStyle(i).setDurationTime(j).setStatus(2));
    }

    public static void f(int i, long j) {
        B(AdLinkMonitorMsg.obtain().setAdStyle(i).setDurationTime(j).setStatus(3));
    }
}
