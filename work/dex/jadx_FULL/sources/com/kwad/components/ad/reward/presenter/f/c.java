package com.kwad.components.ad.reward.presenter.f;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class c extends f {
    @Override // com.kwad.components.ad.reward.presenter.f.f, com.kwad.components.core.webview.tachikoma.j
    public String getTKReaderScene() {
        return "tk_image_video";
    }

    @Override // com.kwad.components.ad.reward.presenter.f.f, com.kwad.components.core.webview.tachikoma.j
    public String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.ej(this.uj.mAdTemplate);
    }
}
