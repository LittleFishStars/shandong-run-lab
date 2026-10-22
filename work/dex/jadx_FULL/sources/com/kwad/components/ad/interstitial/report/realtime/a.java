package com.kwad.components.ad.interstitial.report.realtime;

import com.baidu.mapapi.SDKInitializer;
import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a {

    /* JADX INFO: renamed from: com.kwad.components.ad.interstitial.report.realtime.a$a, reason: collision with other inner class name */
    public static class C1152a {
        private static final a ou = new a(0);
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    public static void J(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setRenderType(e.eO(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType);
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            c.d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_interstitial_data_check_monitor", "monitor_index").b(BusinessType.AD_INTERSTITIAL).A(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void K(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            c.d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_interstitial_service_call_monitor", "monitor_index").b(BusinessType.AD_INTERSTITIAL).A(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(com.kwad.sdk.core.network.e eVar) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setErrorCode(eVar.errorCode);
            c.d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_interstitial_data_result_monitor", SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE).b(BusinessType.AD_INTERSTITIAL).A(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, AdTemplate adTemplate) {
        try {
            AdInfo adInfoEO = e.eO(adTemplate);
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            interstitialRealTimeInfo.setMaterialUrl(com.kwad.sdk.core.response.helper.a.M(adInfoEO));
            c.d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_interstitial_resource_monitor", "monitor_index").b(BusinessType.AD_INTERSTITIAL).A(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static a fd() {
        return C1152a.ou;
    }

    private a() {
    }

    public static void a(String str, AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            c.d(d.In().m1062do(ILoggerReporter.Category.ERROR_LOG).g(1.0d).Q("ad_sdk_interstitial_render_result_monitor", "monitor_index").b(BusinessType.AD_INTERSTITIAL).A(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.buA));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
