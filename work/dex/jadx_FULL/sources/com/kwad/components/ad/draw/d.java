package com.kwad.components.ad.draw;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.t.t;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.commercial.convert.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d {
    public static void loadDrawAd(KsScene ksScene, @NonNull final KsLoadManager.DrawAdListener drawAdListener) {
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        final SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        if (sceneImplCovert.getAdNum() <= 0) {
            com.kwad.components.ad.draw.a.d.a(sceneImplCovert, "ad_num");
        }
        boolean zB = t.wU().b(sceneImplCovert, "loadDrawAd");
        sceneImplCovert.setAdStyle(6);
        com.kwad.components.ad.draw.a.d.b(sceneImplCovert);
        e.d(sceneImplCovert);
        final long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        KsAdLoadManager.O().a(new com.kwad.components.core.request.model.a.C1230a().e(new ImpInfo(sceneImplCovert)).aZ(zB).a(new com.kwad.components.core.request.d() { // from class: com.kwad.components.ad.draw.d.1
            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void b(@NonNull AdResultData adResultData) {
                com.kwad.components.ad.draw.a.d.b(sceneImplCovert, adResultData.getAdTemplateList().size(), SystemClock.elapsedRealtime() - jElapsedRealtime2);
                final ArrayList arrayList = new ArrayList();
                for (AdTemplate adTemplate : adResultData.getAdTemplateList()) {
                    if (adTemplate != null) {
                        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
                        if (adTemplate.adStyle != 6) {
                            com.kwad.components.ad.draw.a.d.l(adTemplate);
                        }
                        if (com.kwad.sdk.core.response.helper.a.cY(adInfoEO) || !TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.M(adInfoEO))) {
                            arrayList.add(new c(com.kwad.sdk.core.response.helper.c.a(adResultData, adTemplate)));
                        } else {
                            com.kwad.components.ad.draw.a.d.l(adTemplate);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    onError(com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg + "(无视频资源)" : adResultData.testErrorMsg);
                } else {
                    by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.draw.d.1.2
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            KsAdLoadManager.O().b(arrayList);
                            try {
                                com.kwad.sdk.commercial.convert.d.a(sceneImplCovert.adStyle, SystemClock.elapsedRealtime() - jElapsedRealtime, 1);
                            } catch (Throwable th) {
                                ServiceProvider.reportSdkCaughtException(th);
                            }
                            drawAdListener.onDrawAdLoad(arrayList);
                            com.kwad.components.ad.draw.a.d.c(sceneImplCovert, arrayList.size(), SystemClock.elapsedRealtime() - jElapsedRealtime2);
                            com.kwad.components.ad.draw.a.d.c(sceneImplCovert);
                        }
                    });
                }
                e.b(sceneImplCovert, arrayList.size());
            }

            @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
            public final void onError(final int i, final String str) {
                com.kwad.components.ad.draw.a.d.a(sceneImplCovert, i, str, SystemClock.elapsedRealtime() - jElapsedRealtime2);
                com.kwad.components.ad.draw.a.d.a(sceneImplCovert, i, str);
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.draw.d.1.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        drawAdListener.onError(i, str);
                    }
                });
            }
        }).wd());
    }
}
