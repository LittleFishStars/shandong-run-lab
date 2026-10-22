package com.kwad.components.ad.fullscreen;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.t.t;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.AdVideoPreCacheConfig;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f {
    public static void a(KsScene ksScene, @NonNull final e eVar) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.convert.e.d(sceneImplCovert);
        com.kwad.components.ad.reward.monitor.d.a(false, sceneImplCovert.getPosId());
        boolean zB = t.wU().b(sceneImplCovert, "loadFullScreenVideoAd");
        sceneImplCovert.setAdStyle(3);
        KsAdLoadManager.O().a(new com.kwad.components.core.request.model.a.C1230a().e(new ImpInfo(sceneImplCovert)).aZ(zB).a(new j() { // from class: com.kwad.components.ad.fullscreen.f.2
            @Override // com.kwad.components.core.request.j
            @WorkerThread
            public final void ak() {
                com.kwad.components.ad.reward.monitor.d.b(false, sceneImplCovert.posId);
            }
        }).a(new com.kwad.components.core.request.e() { // from class: com.kwad.components.ad.fullscreen.f.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.reward.monitor.d.a(false, i, str, sceneImplCovert.getPosId());
                if (i != com.kwad.sdk.core.network.e.aTe.errorCode && i != com.kwad.sdk.core.network.e.aSZ.errorCode) {
                    com.kwad.components.ad.reward.monitor.c.c(false, i);
                }
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.fullscreen.f.1.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        eVar.onError(i, str);
                    }
                });
            }

            public static /* synthetic */ boolean a(AnonymousClass1 anonymousClass1, boolean z) {
                anonymousClass1.ajG = true;
                return true;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                com.kwad.components.ad.reward.monitor.d.c(false, sceneImplCovert.posId);
                List<AdTemplate> listA = f.a(sceneImplCovert, adResultData.getAdTemplateList());
                String str = "onFullScreenVideoAdCacheFailed";
                if (listA.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adResultData.testErrorMsg);
                    l.at("fullAd_", "onFullScreenVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig adVideoPreCacheConfigObtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.Ga());
                final ArrayList<KsFullScreenVideoAd> arrayList = new ArrayList();
                for (AdTemplate adTemplate : listA) {
                    arrayList.add(new g(com.kwad.sdk.core.response.helper.c.a(adResultData, adTemplate)));
                    com.kwad.components.ad.reward.monitor.e.a(adTemplate, z, adVideoPreCacheConfigObtainVideoPreCacheConfig);
                }
                final AdTemplate adTemplate2 = (AdTemplate) listA.get(0);
                com.kwad.components.ad.reward.monitor.d.a(false, adTemplate2, listA.size(), jElapsedRealtime);
                com.kwad.sdk.commercial.convert.e.b(sceneImplCovert, listA.size());
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.fullscreen.f.1.2
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        try {
                            try {
                                com.kwad.sdk.commercial.convert.d.a(sceneImplCovert.adStyle, SystemClock.elapsedRealtime() - jElapsedRealtime, 1);
                            } catch (Throwable th) {
                                ServiceProvider.reportSdkCaughtException(th);
                            }
                            eVar.a(adTemplate2, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            ab.callMethod(eVar, "onRequestResult", Integer.valueOf(arrayList.size()));
                        } catch (Throwable unused2) {
                        }
                    }
                });
                try {
                    if (com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class) != null) {
                        com.kwad.sdk.components.d.f(com.kwad.components.core.offline.a.d.a.class);
                        listA.get(0);
                        com.kwad.sdk.core.response.helper.e.eO((AdTemplate) listA.get(0));
                    }
                } catch (Exception unused) {
                }
                final ArrayList arrayList2 = new ArrayList();
                com.kwad.components.ad.reward.monitor.d.d(false, adTemplate2);
                final boolean zKB = com.kwad.sdk.core.config.e.KB();
                for (final KsFullScreenVideoAd ksFullScreenVideoAd : arrayList) {
                    AdTemplate adTemplate3 = ((g) ksFullScreenVideoAd).getAdTemplate();
                    AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate3);
                    if (!com.kwad.sdk.core.response.helper.a.bj(adInfoEO) && !com.kwad.sdk.core.response.helper.a.cY(adInfoEO)) {
                        com.kwad.components.ad.d.b.a(adTemplate3, false, adVideoPreCacheConfigObtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.fullscreen.f.1.3
                            @Override // com.kwad.components.ad.d.a
                            public final void ai() {
                                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList2.add(ksFullScreenVideoAd);
                                AnonymousClass1.a(AnonymousClass1.this, true);
                                AdTemplate adTemplate4 = adTemplate2;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                f.a(adTemplate4, eVar, arrayList2, jElapsedRealtime);
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void aj() {
                                if (!zKB || AnonymousClass1.this.ajG) {
                                    return;
                                }
                                AdTemplate adTemplate4 = adTemplate2;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                f.a(adTemplate4, eVar, arrayList, jElapsedRealtime);
                            }
                        });
                    } else {
                        arrayList2.add(ksFullScreenVideoAd);
                        this.ajG = true;
                        f.a(adTemplate2, eVar, arrayList2, jElapsedRealtime);
                    }
                    listA = listA;
                    str = str;
                }
                List list = listA;
                String str2 = str;
                com.kwad.sdk.core.d.c.d("KsAdFullScreenLoadManager", "loadFullScreenVideoAd after cache");
                if (!zKB && arrayList2.isEmpty()) {
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aTf;
                    onError(eVar2.errorCode, eVar2.msg);
                    l.at("fullAd_", str2);
                    return;
                }
                com.kwad.components.ad.reward.monitor.d.c(false, (AdTemplate) list.get(0), list.size(), jElapsedRealtime);
            }
        }).wd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final e eVar, final List<KsFullScreenVideoAd> list, final long j) {
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.fullscreen.f.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                l.at("fullAd_", "onFullScreenVideoAdCacheFailed");
                KsAdLoadManager.O().b(list);
                eVar.a(adTemplate, list, j);
            }
        });
    }

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
                if (1 == com.kwad.sdk.core.response.helper.a.bk(adInfoEO) && !TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.M(adInfoEO))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.helper.a.bj(adInfoEO)) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.helper.a.cY(adInfoEO)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
