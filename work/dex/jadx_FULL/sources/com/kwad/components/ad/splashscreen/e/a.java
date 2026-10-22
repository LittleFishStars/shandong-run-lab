package com.kwad.components.ad.splashscreen.e;

import android.text.TextUtils;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class a extends com.kwad.sdk.core.download.a.a {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eO(adTemplate);
    }

    private void j(int i, int i2) {
        String strA = com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, i, i2);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        k(i, strA);
    }

    public abstract void k(int i, String str);

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        j(7, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        j(8, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        j(0, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        j(12, 0);
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i) {
        j(4, i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        j(2, i);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
