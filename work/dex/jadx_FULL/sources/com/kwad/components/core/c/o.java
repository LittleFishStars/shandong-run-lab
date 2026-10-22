package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class o implements c {
    public static void a(final com.kwad.components.core.request.model.a aVar, @NonNull k kVar) {
        new com.kwad.components.core.o.a(aVar.abn) { // from class: com.kwad.components.core.c.o.1
            @Override // com.kwad.components.core.o.a, com.kwad.sdk.core.network.l
            @NonNull
            /* JADX INFO: renamed from: aj, reason: merged with bridge method [inline-methods] */
            public final AdResultData parseData(String str) {
                AdResultData adResultDataCreateFromResponseJson = AdResultData.createFromResponseJson(str, aVar.abn.adScene);
                adResultDataCreateFromResponseJson.setAdSource("network");
                return adResultDataCreateFromResponseJson;
            }

            @Override // com.kwad.components.core.o.a, com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: pe */
            public final com.kwad.components.core.request.a createRequest() {
                if (aVar.getAdStyle() == 4) {
                    com.kwad.components.ad.b.i iVar = (com.kwad.components.ad.b.i) com.kwad.sdk.components.d.f(com.kwad.components.ad.b.i.class);
                    aVar.ajM = iVar.W();
                }
                return new com.kwad.components.core.request.a(aVar);
            }
        }.request(kVar);
    }

    @Override // com.kwad.components.core.c.c
    public final void d(com.kwad.components.core.request.model.a aVar) {
        a(aVar, new k(aVar));
    }

    @Override // com.kwad.components.core.c.c
    public final String getName() {
        return "StrategyNetworkOnlyFetcher";
    }
}
