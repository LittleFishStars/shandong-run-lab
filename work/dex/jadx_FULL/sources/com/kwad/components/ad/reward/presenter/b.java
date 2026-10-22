package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class b extends Presenter {
    public AdTemplate mAdTemplate;
    public com.kwad.components.ad.reward.g uj;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        com.kwad.components.ad.reward.g gVar = (com.kwad.components.ad.reward.g) SB();
        this.uj = gVar;
        this.mAdTemplate = gVar.mAdTemplate;
    }

    public final void iM() {
        this.uj.iM();
    }

    public final boolean iN() {
        return com.kwad.sdk.core.response.helper.a.bj(com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate));
    }
}
