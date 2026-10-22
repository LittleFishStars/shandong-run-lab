package com.kwad.components.ad.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.sdk.mvp.a {

    @NonNull
    public SceneImpl mAdScene;
    public com.kwad.components.core.e.d.d mApkDownloadHelper;

    @Override // com.kwad.sdk.mvp.a
    public final void release() {
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
