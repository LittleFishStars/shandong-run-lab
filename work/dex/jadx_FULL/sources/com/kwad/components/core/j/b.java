package com.kwad.components.core.j;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
final class b implements KsInnerAd {
    private final int aaV;

    @NonNull
    private final AdTemplate mAdTemplate;

    public b(@NonNull AdTemplate adTemplate, int i) {
        this.mAdTemplate = adTemplate;
        this.aaV = i;
    }

    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInnerAd
    public final int getType() {
        return this.aaV;
    }
}
