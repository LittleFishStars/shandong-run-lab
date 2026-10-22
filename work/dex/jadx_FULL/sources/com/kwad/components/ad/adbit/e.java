package com.kwad.components.ad.adbit;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.request.model.ImpInfo;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.utils.bi;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e {
    private static <T extends com.kwad.components.core.request.a> T a(com.kwad.sdk.g.c<T> cVar) {
        return cVar.get();
    }

    public static boolean c(@NonNull final com.kwad.components.core.request.model.a aVar) {
        String bidResponseV2 = aVar.abn.adScene.getBidResponseV2();
        if (!TextUtils.isEmpty(bidResponseV2)) {
            a(bidResponseV2, aVar);
            return true;
        }
        com.kwad.sdk.components.d.f(DevelopMangerComponents.class);
        final String bidResponse = aVar.abn.adScene.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            return false;
        }
        GlobalThreadPools.Od().submit(new bi() { // from class: com.kwad.components.ad.adbit.e.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                try {
                    aVar.bi("server_bid_one");
                    com.kwad.components.core.request.model.a aVar2 = aVar;
                    com.kwad.sdk.commercial.convert.e.c(aVar2.abn.adScene, aVar2.wc());
                    JSONObject jSONObject = new JSONObject(bidResponse);
                    AdBitResultData adBitResultData = new AdBitResultData(aVar.abn.adScene);
                    adBitResultData.parseJson(jSONObject);
                    adBitResultData.setAdTemplateList(e.b(adBitResultData));
                    adBitResultData.setAdSource("server_bid_one");
                    if (adBitResultData.isAdResultDataEmpty()) {
                        com.kwad.components.core.request.model.a.a(aVar, adBitResultData, true);
                        return;
                    }
                    AdTemplate adTemplate = adBitResultData.getAdTemplateList().get(0);
                    int adStyle = aVar.abn.adScene.getAdStyle();
                    if (adStyle == 10000 || e.a(adStyle, adTemplate)) {
                        com.kwad.components.core.request.model.a.a(aVar, adBitResultData, true);
                        return;
                    }
                    com.kwad.components.core.request.model.a aVar3 = aVar;
                    com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aTi;
                    com.kwad.components.core.request.model.a.a(aVar3, eVar.errorCode, eVar.msg, true);
                } catch (Exception e) {
                    com.kwad.components.core.request.model.a aVar4 = aVar;
                    com.kwad.sdk.core.network.e eVar2 = com.kwad.sdk.core.network.e.aTd;
                    com.kwad.components.core.request.model.a.a(aVar4, eVar2.errorCode, eVar2.msg, true);
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                }
            }
        });
        return true;
    }

    public static String getBidRequestTokenV2(KsScene ksScene) {
        final com.kwad.components.core.request.model.a aVarWd = new com.kwad.components.core.request.model.a.C1230a().e(new ImpInfo(SceneImpl.covert(ksScene))).a(new com.kwad.components.core.request.d()).wd();
        com.kwad.components.ad.a.a aVar = (com.kwad.components.ad.a.a) a(new com.kwad.sdk.g.c<com.kwad.components.ad.a.a>() { // from class: com.kwad.components.ad.adbit.e.2
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.c
            /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ad.a.a get() {
                return new com.kwad.components.ad.a.a(aVarWd);
            }
        });
        return new a(aVar.getBody(), aVar.getHeader()).Q();
    }

    public static String a(SceneImpl sceneImpl) {
        final com.kwad.components.core.request.model.a aVarWd = new com.kwad.components.core.request.model.a.C1230a().e(new ImpInfo(SceneImpl.covert(sceneImpl))).a(new com.kwad.components.core.request.d()).wd();
        b bVar = (b) a(new com.kwad.sdk.g.c<b>() { // from class: com.kwad.components.ad.adbit.e.1
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.c
            /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
            public b get() {
                return new b(aVarWd);
            }
        });
        return new a(bVar.getBody(), bVar.getHeader()).Q();
    }

    public static List<AdTemplate> b(AdBitResultData adBitResultData) {
        AdTemplate adTemplateA;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j = adBid.creativeId;
                if (j > 0 && (adTemplateA = a(adBitResultData, j)) != null) {
                    adTemplateA.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(adTemplateA);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(int i, AdTemplate adTemplate) {
        int i2 = adTemplate.adStyle;
        if (i == 23) {
            return i2 == 13 || i2 == 23;
        }
        return i == i2;
    }

    private static void a(String str, @NonNull com.kwad.components.core.request.model.a aVar) {
        try {
            aVar.bi("server_bid_two");
            com.kwad.sdk.commercial.convert.e.c(aVar.abn.adScene, aVar.wc());
            JSONObject jSONObject = new JSONObject(str);
            AdBitResultData adBitResultData = new AdBitResultData(aVar.abn.adScene);
            adBitResultData.parseJson(jSONObject);
            List<String> listA = a(adBitResultData);
            if (listA.isEmpty()) {
                com.kwad.components.core.request.model.a.a(aVar, com.kwad.sdk.core.network.e.aTe.errorCode, TextUtils.isEmpty(adBitResultData.testErrorMsg) ? com.kwad.sdk.core.network.e.aTe.msg : adBitResultData.testErrorMsg, false);
            } else {
                a(listA, adBitResultData, aVar);
            }
        } catch (Exception e) {
            com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aTd;
            com.kwad.components.core.request.model.a.a(aVar, eVar.errorCode, eVar.msg, false);
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }

    private static void a(final List<String> list, final AdBitResultData adBitResultData, final com.kwad.components.core.request.model.a aVar) {
        new l<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.e.4
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.ad.a.b createRequest() {
                return new com.kwad.components.ad.a.b(adBitResultData.adxId, list);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.l
            @NonNull
            /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
            public AdBitResultData parseData(String str) {
                JSONObject jSONObject = new JSONObject(str);
                AdBitResultData adBitResultData2 = new AdBitResultData(aVar.abn.adScene);
                adBitResultData2.parseJson(jSONObject);
                return adBitResultData2;
            }
        }.request(new o<com.kwad.components.ad.a.b, AdBitResultData>() { // from class: com.kwad.components.ad.adbit.e.5
            private void b(int i, String str) {
                com.kwad.components.core.request.model.a.a(aVar, i, str, false);
            }

            private void c(@NonNull AdBitResultData adBitResultData2) {
                adBitResultData2.setAdTemplateList(e.a(adBitResultData, adBitResultData2));
                adBitResultData2.setAdSource("server_bid_two");
                if (adBitResultData2.isAdResultDataEmpty()) {
                    com.kwad.components.core.request.model.a.a(aVar, adBitResultData2, false);
                    return;
                }
                AdTemplate adTemplate = adBitResultData2.getAdTemplateList().get(0);
                int i = aVar.abn.adScene.adStyle;
                if (i == 10000 || e.a(i, adTemplate)) {
                    com.kwad.components.core.request.model.a.a(aVar, adBitResultData2, false);
                    return;
                }
                com.kwad.components.core.request.model.a aVar2 = aVar;
                com.kwad.sdk.core.network.e eVar = com.kwad.sdk.core.network.e.aTi;
                com.kwad.components.core.request.model.a.a(aVar2, eVar.errorCode, eVar.msg, false);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onError(@NonNull f fVar, int i, String str) {
                b(i, str);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull f fVar, @NonNull BaseResultData baseResultData) {
                c((AdBitResultData) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<AdTemplate> a(AdBitResultData adBitResultData, AdBitResultData adBitResultData2) {
        AdTemplate adTemplateA;
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0) {
                long j = adBid.creativeId;
                if (j > 0 && (adTemplateA = a(adBitResultData2, j)) != null) {
                    adTemplateA.mBidEcpm = adBid.bidEcpm;
                    arrayList.add(adTemplateA);
                }
            }
        }
        return arrayList;
    }

    private static List<String> a(AdBitResultData adBitResultData) {
        ArrayList arrayList = new ArrayList();
        for (AdBid adBid : adBitResultData.adBidList) {
            if (adBid != null && adBid.bidEcpm > 0 && adBid.creativeId > 0) {
                arrayList.add(adBid.materialId);
            }
        }
        return arrayList;
    }

    @Nullable
    private static AdTemplate a(AdBitResultData adBitResultData, long j) {
        for (AdTemplate adTemplate : adBitResultData.getAdTemplateList()) {
            if (adTemplate != null && j == com.kwad.sdk.core.response.helper.e.eY(adTemplate)) {
                return adTemplate;
            }
        }
        return null;
    }
}
