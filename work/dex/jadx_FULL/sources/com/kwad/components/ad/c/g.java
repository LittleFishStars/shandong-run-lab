package com.kwad.components.ad.c;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.t.t;
import com.kwad.sdk.api.KsBannerAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class g {
    public static KsScene cf;

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static List<AdTemplate> a(SceneImpl sceneImpl, List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList();
        if (list.isEmpty()) {
            return arrayList;
        }
        for (AdTemplate adTemplate : list) {
            if (adTemplate != null) {
                if (adTemplate.mAdScene == null) {
                    adTemplate.mAdScene = sceneImpl;
                }
                AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
                if (1 == com.kwad.sdk.core.response.helper.a.bk(adInfoEO)) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.helper.a.bj(adInfoEO)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }

    public static void loadBannerAd(KsScene ksScene, @NonNull final KsLoadManager.BannerAdListener bannerAdListener) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!o.Gs().Fx()) {
            com.kwad.sdk.core.d.c.e("KsAdBannerLoadManager", "loadBannerAd please init sdk first");
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.c.g.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    bannerAdListener.onError(com.kwad.sdk.core.network.e.aTe.errorCode, com.kwad.sdk.core.network.e.aTe.msg + "sdk not init");
                }
            });
            return;
        }
        ksScene.setAdNum(com.kwad.sdk.core.config.e.KF());
        cf = ksScene;
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.convert.e.d(sceneImplCovert);
        com.kwad.components.ad.c.c.c.a(sceneImplCovert, 1);
        boolean zB = t.wU().b(sceneImplCovert, "loadBannerAd");
        sceneImplCovert.setAdStyle(5);
        KsAdLoadManager.O().a(new com.kwad.components.core.request.model.a.C1230a().e(new ImpInfo(sceneImplCovert)).aZ(zB).a(new j() { // from class: com.kwad.components.ad.c.g.3
            @Override // com.kwad.components.core.request.j
            @WorkerThread
            public final void ak() {
            }
        }).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.c.g.2
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                List<AdTemplate> listA = g.a(sceneImplCovert, adResultData.getAdTemplateList());
                if (listA.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adResultData.testErrorMsg);
                    l.at("bannerAd_", "onBannerAdCacheFailed");
                    return;
                }
                com.kwad.components.ad.c.c.c.a(sceneImplCovert, adResultData.getAdTemplateList().size(), SystemClock.elapsedRealtime() - jElapsedRealtime, 0);
                for (AdTemplate adTemplate : listA) {
                    if (adTemplate != null && adTemplate.adStyle != 5) {
                        com.kwad.components.ad.c.c.c.f(adTemplate);
                    }
                }
                AdVideoPreCacheConfig adVideoPreCacheConfigObtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.Ga());
                final AdTemplate adTemplate2 = (AdTemplate) listA.get(0);
                com.kwad.sdk.commercial.convert.e.b(sceneImplCovert, listA.size());
                final h hVar = new h(adResultData);
                com.kwad.sdk.core.config.e.KB();
                AdTemplate adTemplate3 = hVar.getAdTemplate();
                if (com.kwad.sdk.core.response.helper.a.bj(com.kwad.sdk.core.response.helper.e.eO(adTemplate3))) {
                    g.a(adTemplate2, bannerAdListener, hVar, jElapsedRealtime);
                } else {
                    com.kwad.components.ad.c.a.a.a(adTemplate3, adVideoPreCacheConfigObtainVideoPreCacheConfig, new com.kwad.components.ad.c.a.b() { // from class: com.kwad.components.ad.c.g.2.2
                        @Override // com.kwad.components.ad.c.a.b
                        public final void ai() {
                            com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                            AdTemplate adTemplate4 = adTemplate2;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            g.a(adTemplate4, bannerAdListener, hVar, jElapsedRealtime);
                        }

                        @Override // com.kwad.components.ad.c.a.b
                        public final void aj() {
                            AdTemplate adTemplate4 = adTemplate2;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            g.a(adTemplate4, bannerAdListener, hVar, jElapsedRealtime);
                        }
                    });
                }
                com.kwad.sdk.core.d.c.d("KsAdBannerLoadManager", "loadFullScreenVideoAd after cache");
                com.kwad.components.ad.c.c.c.a(sceneImplCovert, listA.size(), SystemClock.elapsedRealtime() - jElapsedRealtime);
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                if (i != com.kwad.sdk.core.network.e.aTe.errorCode) {
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aSZ;
                }
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.c.g.2.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        bannerAdListener.onError(i, str);
                        com.kwad.components.ad.c.c.c.a(sceneImplCovert, i, str, SystemClock.elapsedRealtime() - jElapsedRealtime, 0);
                        com.kwad.components.ad.c.c.c.d(i, str);
                    }
                });
            }
        }).wd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final KsLoadManager.BannerAdListener bannerAdListener, final KsBannerAd ksBannerAd, final long j) {
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.c.g.4
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                l.at("bannerAd_", "onBannerAdCacheSuccess");
                try {
                    com.kwad.sdk.commercial.convert.d.a(com.kwad.sdk.core.response.helper.e.eI(adTemplate), SystemClock.elapsedRealtime() - j, 2);
                    com.kwad.components.ad.c.c.c.aw();
                } catch (Throwable th) {
                    ServiceProvider.reportSdkCaughtException(th);
                }
                bannerAdListener.onBannerAdLoad(ksBannerAd);
            }
        });
    }
}
