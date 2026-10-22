package com.kwad.components.ad.interstitial;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.t.t;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f {
    public static void loadInterstitialAd(@NonNull KsScene ksScene, @NonNull final KsLoadManager.InterstitialAdListener interstitialAdListener) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!o.Gs().Fx()) {
            com.kwad.sdk.core.d.c.e("KsAdInterstitialLoadManager", "loadInterstitialAd please init sdk first");
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.interstitial.f.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    interstitialAdListener.onError(com.kwad.sdk.core.network.e.aTe.errorCode, com.kwad.sdk.core.network.e.aTe.msg + "sdk not init");
                }
            });
            return;
        }
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.convert.e.d(sceneImplCovert);
        boolean zB = t.wU().b(sceneImplCovert, "loadInterstitialAd");
        final long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        sceneImplCovert.setAdStyle(23);
        com.kwad.components.ad.interstitial.report.c.eZ().p(sceneImplCovert.getPosId());
        KsAdLoadManager.O().a(new com.kwad.components.core.request.model.a.C1230a().e(new ImpInfo(sceneImplCovert)).aZ(zB).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.interstitial.f.2
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                final List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
                if (adTemplateList.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adResultData.testErrorMsg);
                    l.at("insertAd_", "onInterstitialAdCacheFailed");
                    return;
                }
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.interstitial.f.2.2
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        try {
                            interstitialAdListener.onRequestResult(adTemplateList.size());
                        } catch (Throwable th) {
                            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class) != null) {
                        com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class);
                        adTemplateList.get(0);
                        com.kwad.sdk.core.response.helper.e.eO(adTemplateList.get(0));
                    }
                } catch (Exception unused) {
                }
                com.kwad.components.ad.interstitial.report.c.eZ().a(adTemplateList.get(0), z);
                com.kwad.sdk.commercial.convert.e.b(sceneImplCovert, adTemplateList.size());
                SystemClock.elapsedRealtime();
                final ArrayList arrayList = new ArrayList();
                if (com.kwad.sdk.core.response.helper.c.u(adResultData)) {
                    ArrayList arrayList2 = new ArrayList();
                    for (AdTemplate adTemplate : adTemplateList) {
                        if (adTemplate != null) {
                            if (adTemplate.mAdScene == null) {
                                adTemplate.mAdScene = sceneImplCovert;
                            }
                            String strM = com.kwad.sdk.core.response.helper.a.M(com.kwad.sdk.core.response.helper.e.eO(adTemplate));
                            if (!com.kwad.sdk.core.response.helper.b.dJ(adTemplate)) {
                                com.kwad.components.ad.interstitial.report.realtime.a.fd();
                                com.kwad.components.ad.interstitial.report.realtime.a.J(adTemplate);
                            }
                            if (TextUtils.isEmpty(strM)) {
                                arrayList2.add(adTemplate);
                            } else {
                                boolean zW = com.kwad.components.ad.interstitial.a.a.w(adTemplate);
                                if (com.kwad.sdk.core.config.e.Jp() || zW) {
                                    arrayList2.add(adTemplate);
                                }
                            }
                        }
                    }
                    adResultData.setAdTemplateList(arrayList2);
                    arrayList.add(e.f(adResultData));
                } else {
                    for (AdTemplate adTemplate2 : adTemplateList) {
                        if (adTemplate2 != null) {
                            if (adTemplate2.mAdScene == null) {
                                adTemplate2.mAdScene = sceneImplCovert;
                            }
                            String strM2 = com.kwad.sdk.core.response.helper.a.M(com.kwad.sdk.core.response.helper.e.eO(adTemplate2));
                            if (!com.kwad.sdk.core.response.helper.b.dJ(adTemplate2)) {
                                com.kwad.components.ad.interstitial.report.realtime.a.fd();
                                com.kwad.components.ad.interstitial.report.realtime.a.J(adTemplate2);
                            }
                            AdResultData adResultDataA = com.kwad.sdk.core.response.helper.c.a(adResultData, adTemplate2);
                            if (TextUtils.isEmpty(strM2)) {
                                arrayList.add(e.f(adResultDataA));
                            } else {
                                boolean zW2 = com.kwad.components.ad.interstitial.a.a.w(adTemplate2);
                                if (com.kwad.sdk.core.config.e.Jp() || zW2) {
                                    arrayList.add(e.f(adResultDataA));
                                }
                            }
                        }
                    }
                }
                if (arrayList.size() != 0) {
                    com.kwad.components.ad.interstitial.report.c.eZ().b(adTemplateList.get(0), z);
                    by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.interstitial.f.2.3
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            KsAdLoadManager.O().b(arrayList);
                            l.at("insertAd_", "onInterstitialAdCacheSuccess");
                            try {
                                com.kwad.sdk.commercial.convert.d.a(sceneImplCovert.adStyle, SystemClock.elapsedRealtime() - jElapsedRealtime, 2);
                            } catch (Throwable th) {
                                ServiceProvider.reportSdkCaughtException(th);
                            }
                            interstitialAdListener.onInterstitialAdLoad(arrayList);
                        }
                    });
                } else {
                    onError(com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adResultData.testErrorMsg);
                    com.kwad.components.ad.interstitial.report.realtime.a.fd();
                    com.kwad.components.ad.interstitial.report.realtime.a.a(com.kwad.sdk.core.network.e.aTe);
                    l.at("insertAd_", "onInterstitialAdCacheFailed");
                }
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.interstitial.report.c.eZ().a(i, str, sceneImplCovert.getPosId());
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.interstitial.f.2.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        interstitialAdListener.onError(i, str);
                    }
                });
            }
        }).wd());
    }
}
