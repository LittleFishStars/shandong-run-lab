package com.kwad.components.ad.reward.presenter;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h extends b implements com.kwad.sdk.app.a {
    private AdInfo mAdInfo;

    @Override // com.kwad.sdk.app.a
    public final void V(String str) {
        if (TextUtils.equals(com.kwad.sdk.core.response.helper.a.aE(this.mAdInfo), str)) {
            AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate);
            if (com.kwad.sdk.core.response.helper.a.aU(adInfoEO) && com.kwad.sdk.core.response.helper.a.aT(adInfoEO) == 1) {
                return;
            }
            com.kwad.components.ad.reward.e.b bVar = this.uj.sy;
            if (bVar != null) {
                bVar.onRewardVerify();
            }
            this.uj.sz.pause();
            this.uj.gW();
        }
    }

    @Override // com.kwad.sdk.app.a
    public final void W(String str) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate);
        com.kwad.sdk.app.b.HO().a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.sdk.app.b.HO().b(this);
    }
}
