package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class i {
    public static boolean z(com.kwad.components.ad.reward.g gVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = gVar.mAdTemplate;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if ((com.kwad.sdk.core.response.helper.a.bQ(adInfoEO) && (aVar = gVar.sA) != null && aVar.vz()) || com.kwad.components.ad.reward.a.b.l(adInfoEO) || adTemplate.mXiaomiAppStoreDetailViewOpen) {
            return false;
        }
        if (com.kwad.components.ad.reward.a.b.hX()) {
            return true;
        }
        return com.kwad.sdk.core.response.helper.a.aL(adInfoEO) && com.kwad.sdk.core.response.helper.a.az(adInfoEO);
    }
}
