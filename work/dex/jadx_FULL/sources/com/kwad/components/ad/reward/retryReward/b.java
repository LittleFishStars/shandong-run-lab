package com.kwad.components.ad.reward.retryReward;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b {
    public static void a(f fVar) {
        a(fVar.mAdTemplate, c.kE().c(fVar).aq(1), false);
    }

    public static void ac(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        a(adTemplate, c.kE().ae(adTemplate).aq(4), false);
    }

    public static void ad(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        a(adTemplate, c.kE().ae(adTemplate).aq(3), false);
    }

    public static void b(f fVar) {
        if (fVar == null) {
            return;
        }
        a(fVar.mAdTemplate, c.kE().c(fVar).aq(2), false);
    }

    public static void i(int i, String str) {
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.1d).b(BusinessType.AD_REWARD).Q("ad_sdk_reward_retry_task_performance", "status").A(c.kE().aq(7).setErrorMsg(str).setErrorCode(i)));
    }

    public static void kC() {
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).b(BusinessType.AD_REWARD).Q("ad_sdk_reward_retry_task_performance", "status").A(c.kE().aq(5)));
    }

    public static void kD() {
        com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).b(BusinessType.AD_REWARD).Q("ad_sdk_reward_retry_task_performance", "status").A(c.kE().aq(6)));
    }

    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar, boolean z) {
        try {
            com.kwad.sdk.commercial.c.d(com.kwad.sdk.commercial.d.In().m1062do(ILoggerReporter.Category.APM_LOG).g(0.01d).b(com.kwad.sdk.commercial.e.bA(adTemplate)).Q("ad_sdk_reward_retry_task_performance", "status").A(aVar));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
