package com.kwad.components.ad.reward.g;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.ad.reward.KsRewardVideoAdControl;
import com.kwad.components.ad.reward.monitor.d;
import com.kwad.components.core.request.j;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.t.t;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.convert.e;
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
public final class b {
    public static void a(KsScene ksScene, @NonNull final c cVar) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        e.d(sceneImplCovert);
        d.a(true, sceneImplCovert.getPosId());
        boolean zB = t.wU().b(sceneImplCovert, "loadRewardVideoAd");
        sceneImplCovert.setAdStyle(2);
        KsAdLoadManager.O().a(new com.kwad.components.core.request.model.a.C1230a().e(new ImpInfo(sceneImplCovert)).aZ(zB).a(new j() { // from class: com.kwad.components.ad.reward.g.b.2
            @Override // com.kwad.components.core.request.j
            @WorkerThread
            public final void ak() {
                d.b(true, sceneImplCovert.posId);
            }
        }).a(new com.kwad.components.core.request.e() { // from class: com.kwad.components.ad.reward.g.b.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                d.a(true, i, str, sceneImplCovert.getPosId());
                if (i != com.kwad.sdk.core.network.e.aTe.errorCode && i != com.kwad.sdk.core.network.e.aSZ.errorCode) {
                    com.kwad.components.ad.reward.monitor.c.c(true, i);
                }
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.g.b.1.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        cVar.onError(i, str);
                    }
                });
            }

            public static /* synthetic */ boolean a(AnonymousClass1 anonymousClass1, boolean z) {
                anonymousClass1.ajG = true;
                return true;
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.c
            public final void a(@NonNull AdResultData adResultData, boolean z) {
                d.c(true, sceneImplCovert.posId);
                List listA = b.a(sceneImplCovert, adResultData.getProceedTemplateList());
                if (listA.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adResultData.testErrorMsg);
                    l.at("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                AdVideoPreCacheConfig adVideoPreCacheConfigObtainVideoPreCacheConfig = AdResultData.obtainVideoPreCacheConfig(adResultData, com.kwad.sdk.core.config.e.Ga());
                final ArrayList<KsRewardVideoAd> arrayList = new ArrayList();
                final AdTemplate adTemplate = (AdTemplate) listA.get(0);
                arrayList.add(new KsRewardVideoAdControl(adResultData));
                com.kwad.components.ad.reward.monitor.e.a(adTemplate, z, adVideoPreCacheConfigObtainVideoPreCacheConfig);
                d.a(true, (AdTemplate) listA.get(0), listA.size(), jElapsedRealtime);
                e.b(sceneImplCovert, listA.size());
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.g.b.1.2
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        try {
                            KsAdLoadManager.O().b(arrayList);
                            try {
                                com.kwad.sdk.commercial.convert.d.a(sceneImplCovert.adStyle, SystemClock.elapsedRealtime() - jElapsedRealtime, 1);
                            } catch (Throwable th) {
                                ServiceProvider.reportSdkCaughtException(th);
                            }
                            cVar.b(adTemplate, arrayList);
                        } catch (Throwable unused) {
                        }
                        try {
                            ab.callMethod(cVar, "onRequestResult", Integer.valueOf(arrayList.size()));
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
                ArrayList arrayList2 = new ArrayList();
                d.d(true, adTemplate);
                final boolean zKB = com.kwad.sdk.core.config.e.KB();
                boolean z2 = false;
                for (final KsRewardVideoAd ksRewardVideoAd : arrayList) {
                    AdTemplate adTemplate2 = ((KsRewardVideoAdControl) ksRewardVideoAd).getAdTemplate();
                    AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate2);
                    if (!adTemplate2.isNativeRewardPreview && !com.kwad.sdk.core.response.helper.a.cY(adInfoEO) && !com.kwad.sdk.core.response.helper.a.bj(adInfoEO)) {
                        final ArrayList arrayList3 = arrayList2;
                        com.kwad.components.ad.d.b.a(adTemplate2, true, adVideoPreCacheConfigObtainVideoPreCacheConfig, new com.kwad.components.ad.d.a() { // from class: com.kwad.components.ad.reward.g.b.1.3
                            @Override // com.kwad.components.ad.d.a
                            public final void ai() {
                                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd startCacheVideo onCacheTargetSuccess");
                                arrayList3.add(ksRewardVideoAd);
                                AdTemplate adTemplate3 = adTemplate;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                b.a(adTemplate3, cVar, arrayList3, jElapsedRealtime);
                                AnonymousClass1.a(AnonymousClass1.this, true);
                            }

                            @Override // com.kwad.components.ad.d.a
                            public final void aj() {
                                if (!zKB || AnonymousClass1.this.ajG) {
                                    return;
                                }
                                AdTemplate adTemplate3 = adTemplate;
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                b.a(adTemplate3, cVar, arrayList, jElapsedRealtime);
                            }
                        });
                        listA = listA;
                        arrayList2 = arrayList2;
                    } else {
                        arrayList2.add(ksRewardVideoAd);
                        b.a(adTemplate, cVar, arrayList2, jElapsedRealtime);
                        arrayList2 = arrayList2;
                        z2 = true;
                        listA = listA;
                    }
                }
                ArrayList arrayList4 = arrayList2;
                List list = listA;
                com.kwad.sdk.core.d.c.d("KsAdRewardLoadManager", "loadRewardVideoAd after cache");
                if (!zKB && !z2 && arrayList4.isEmpty()) {
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aTf;
                    onError(eVar.errorCode, eVar.msg);
                    l.at("rewardAd_", "onRewardVideoAdCacheFailed");
                    return;
                }
                d.c(true, (AdTemplate) list.get(0), list.size(), jElapsedRealtime);
            }
        }).wd());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final AdTemplate adTemplate, final c cVar, final List<KsRewardVideoAd> list, final long j) {
        by.postOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.g.b.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                l.at("rewardAd_", "onRewardVideoAdCacheSuccess");
                cVar.b(adTemplate, list, j);
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
                int iBk = com.kwad.sdk.core.response.helper.a.bk(adInfoEO);
                if (adTemplate.isNativeRewardPreview) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.helper.a.cY(adInfoEO)) {
                    arrayList.add(adTemplate);
                } else if (1 == iBk && !TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.M(adInfoEO))) {
                    arrayList.add(adTemplate);
                } else if (com.kwad.sdk.core.response.helper.a.bj(adInfoEO)) {
                    arrayList.add(adTemplate);
                }
            }
        }
        return arrayList;
    }
}
