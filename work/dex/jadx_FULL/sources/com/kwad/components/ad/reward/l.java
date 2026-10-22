package com.kwad.components.ad.reward;

import android.content.Context;
import com.kwad.components.core.page.DownloadLandPageActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class l {
    public static void j(g gVar) {
        com.kwad.components.core.playable.a aVar;
        AdTemplate adTemplate = gVar.mAdTemplate;
        Context context = gVar.mContext;
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if ((com.kwad.sdk.core.response.helper.a.bQ(adInfoEO) && (aVar = gVar.sA) != null && aVar.vz()) || com.kwad.components.ad.reward.a.b.l(adInfoEO) || adTemplate.mXiaomiAppStoreDetailViewOpen || !com.kwad.sdk.core.response.helper.a.aL(adInfoEO) || !com.kwad.sdk.core.response.helper.a.az(adInfoEO) || adTemplate.hasEnterAdWebViewLandPageActivity) {
            return;
        }
        gVar.mAdTemplate.hasEnterAdWebViewLandPageActivity = true;
        DownloadLandPageActivity.launch(context, adTemplate, true);
    }
}
