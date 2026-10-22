package com.kwad.components.ad.reward.n;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class r {

    @Nullable
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    private r() {
    }

    public static r a(AdTemplate adTemplate, com.kwad.components.core.e.d.d dVar) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        rVar.setApkDownloadHelper(dVar);
        return rVar;
    }

    public static r ah(AdTemplate adTemplate) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        return rVar;
    }

    private void setAdTemplate(@Nullable AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    private void setApkDownloadHelper(@Nullable com.kwad.components.core.e.d.d dVar) {
        this.mApkDownloadHelper = dVar;
    }

    @Nullable
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Nullable
    public final com.kwad.components.core.e.d.d iv() {
        return this.mApkDownloadHelper;
    }
}
