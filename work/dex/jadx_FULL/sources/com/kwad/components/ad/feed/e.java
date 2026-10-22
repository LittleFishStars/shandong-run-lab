package com.kwad.components.ad.feed;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.kwad.components.ad.KsAdLoadManager;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.components.core.t.t;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.api.KsFeedAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.o;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {

    /* JADX INFO: renamed from: com.kwad.components.ad.feed.e$2, reason: invalid class name */
    public class AnonymousClass2 extends com.kwad.components.core.request.d {
        final /* synthetic */ SceneImpl cg;
        final /* synthetic */ long ch;
        final /* synthetic */ KsLoadManager.FeedAdListener gZ;
        final /* synthetic */ boolean hE;
        final /* synthetic */ long hF;

        public AnonymousClass2(KsLoadManager.FeedAdListener feedAdListener, SceneImpl sceneImpl, boolean z, long j, long j2) {
            this.gZ = feedAdListener;
            this.cg = sceneImpl;
            this.hE = z;
            this.hF = j;
            this.ch = j2;
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
        public final void b(@NonNull AdResultData adResultData) {
            final ArrayList arrayList = new ArrayList();
            List<AdTemplate> adTemplateList = adResultData.getAdTemplateList();
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + adTemplateList.size());
            if (adTemplateList.isEmpty()) {
                com.kwad.components.ad.feed.monitor.b.cn();
            }
            String str = null;
            for (AdTemplate adTemplate : adTemplateList) {
                if (adTemplate != null) {
                    AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
                    if (FeedType.checkTypeValid(adTemplate)) {
                        adTemplate.mAdScene = this.cg;
                        if (!TextUtils.isEmpty(com.kwad.sdk.core.response.helper.a.M(adInfoEO))) {
                            Pair<Integer, String> pairQ = com.kwad.components.ad.feed.monitor.a.q(adTemplate);
                            com.kwad.components.ad.feed.monitor.b.g(((Integer) pairQ.first).intValue(), (String) pairQ.second);
                        }
                        arrayList.add(new c(com.kwad.sdk.core.response.helper.c.a(adResultData, adTemplate), this.hE));
                    } else {
                        str = String.format("(模板不匹配materialType:%s_feedType:%s)", Integer.valueOf(com.kwad.sdk.core.response.helper.a.bk(adInfoEO)), FeedType.fromInt(adTemplate.type, adTemplate.defaultType));
                        com.kwad.components.ad.feed.monitor.b.b(com.kwad.sdk.core.response.helper.a.bk(adInfoEO), adTemplate.type, adTemplate);
                    }
                }
            }
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onSuccess:" + arrayList.size());
            com.kwad.components.ad.feed.monitor.b.N(arrayList.size());
            if (!arrayList.isEmpty()) {
                com.kwad.sdk.commercial.convert.e.b(this.cg, arrayList.size());
                if (!com.kwad.sdk.core.config.e.Jn() || (o.Gs().Fu() && !(o.Gs().Fu() && com.kwad.sdk.core.config.e.Jo() == 1))) {
                    by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.feed.e.2.3
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            final int size = arrayList.size();
                            final int[] iArr = {0};
                            for (final KsFeedAd ksFeedAd : arrayList) {
                                final c cVar = (c) ksFeedAd;
                                com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd " + ksFeedAd);
                                final int i = com.kwad.sdk.core.response.helper.b.dD(cVar.getAdTemplate()) ? 3 : 2;
                                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                                cVar.a(new c.a() { // from class: com.kwad.components.ad.feed.e.2.3.1
                                    @Override // com.kwad.components.ad.feed.c.a
                                    public final void e(int i2, String str2) {
                                        com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "ksFeedAd onLoadFinished" + cVar);
                                        com.kwad.components.ad.feed.monitor.b.a(((c) ksFeedAd).getAdTemplate(), i2, i, SystemClock.elapsedRealtime() - jElapsedRealtime, str2);
                                        int[] iArr2 = iArr;
                                        int i3 = iArr2[0] + 1;
                                        iArr2[0] = i3;
                                        int i4 = size;
                                        if (i3 == i4) {
                                            com.kwad.components.ad.feed.monitor.b.a(i4, SystemClock.elapsedRealtime() - AnonymousClass2.this.hF);
                                            KsAdLoadManager.O().b(arrayList);
                                            try {
                                                com.kwad.sdk.commercial.convert.d.a(AnonymousClass2.this.cg.adStyle, SystemClock.elapsedRealtime() - AnonymousClass2.this.ch, 1);
                                            } catch (Throwable th) {
                                                ServiceProvider.reportSdkCaughtException(th);
                                            }
                                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                            AnonymousClass2.this.gZ.onFeedAdLoad(arrayList);
                                            com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.cg.getPosId(), (List<KsFeedAd>) arrayList);
                                        }
                                    }
                                });
                            }
                        }
                    });
                    return;
                } else {
                    by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.feed.e.2.2
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            com.kwad.components.ad.feed.monitor.b.a(arrayList.size(), SystemClock.elapsedRealtime() - AnonymousClass2.this.hF);
                            KsAdLoadManager.O().b(arrayList);
                            try {
                                com.kwad.sdk.commercial.convert.d.a(AnonymousClass2.this.cg.adStyle, SystemClock.elapsedRealtime() - AnonymousClass2.this.ch, 1);
                            } catch (Throwable th) {
                                ServiceProvider.reportSdkCaughtException(th);
                            }
                            AnonymousClass2.this.gZ.onFeedAdLoad(arrayList);
                            com.kwad.components.ad.feed.monitor.b.a(AnonymousClass2.this.cg.getPosId(), (List<KsFeedAd>) arrayList);
                        }
                    });
                    return;
                }
            }
            com.kwad.components.ad.feed.monitor.b.f(com.kwad.sdk.core.network.e.aTe.errorCode, com.kwad.sdk.core.network.e.aTe.msg + str);
            onError(com.kwad.sdk.core.network.e.aTe.errorCode, com.kwad.sdk.core.network.e.aTe.msg + str);
            com.kwad.sdk.core.d.c.d("KsAdFeedLoadManager", "loadFeedAd onError");
        }

        @Override // com.kwad.components.core.request.d, com.kwad.components.core.request.l
        public final void onError(final int i, final String str) {
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.feed.e.2.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    AnonymousClass2.this.gZ.onError(i, str);
                }
            });
            com.kwad.components.ad.feed.monitor.b.f(i, str);
            if (i == com.kwad.sdk.core.network.e.aSZ.errorCode || i == com.kwad.sdk.core.network.e.aTe.errorCode) {
                return;
            }
            com.kwad.components.ad.feed.monitor.b.h(i, str);
        }
    }

    public static void a(KsScene ksScene, @NonNull final KsLoadManager.FeedAdListener feedAdListener, boolean z) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (!o.Gs().Fx()) {
            com.kwad.sdk.core.d.c.e("KsAdFeedLoadManager", "loadConfigFeedAd please init sdk first");
            by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.feed.e.1
                @Override // com.kwad.sdk.utils.bi
                public final void doTask() {
                    feedAdListener.onError(com.kwad.sdk.core.network.e.aTe.errorCode, com.kwad.sdk.core.network.e.aTe.msg + "sdk not init");
                }
            });
            return;
        }
        SceneImpl sceneImplCovert = SceneImpl.covert(ksScene);
        com.kwad.sdk.commercial.convert.e.d(sceneImplCovert);
        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
        com.kwad.components.ad.feed.monitor.b.M(sceneImplCovert.getAdNum());
        boolean zB = t.wU().b(sceneImplCovert, "loadConfigFeedAd");
        sceneImplCovert.setAdStyle(1);
        KsAdLoadManager.O().a(new com.kwad.components.core.request.model.a.C1230a().e(new ImpInfo(sceneImplCovert)).aZ(zB).a(new AnonymousClass2(feedAdListener, sceneImplCovert, z, jElapsedRealtime2, jElapsedRealtime)).wd());
    }
}
