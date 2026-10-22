package com.kwad.components.ad.reward.presenter;

import android.view.ViewGroup;
import android.view.ViewStub;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e extends b {
    private AdInfo mAdInfo;

    public e(AdInfo adInfo, ViewGroup viewGroup) {
        this.mAdInfo = adInfo;
        if (com.kwad.components.ad.reward.a.b.j(adInfo)) {
            final com.kwad.components.ad.reward.b.c cVar = new com.kwad.components.ad.reward.b.c();
            a(cVar);
            ViewStub viewStub = (ViewStub) viewGroup.findViewById(R.id.ksad_reward_order_card);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.e(viewStub != null ? (ViewGroup) viewStub.inflate() : (ViewGroup) viewGroup.findViewById(R.id.ksad_reward_order_root), new com.kwad.components.ad.reward.n.n.a() { // from class: com.kwad.components.ad.reward.presenter.e.1
                @Override // com.kwad.components.ad.reward.n.n.a
                public final void iQ() {
                    cVar.showDialog();
                }
            }));
            return;
        }
        if (com.kwad.sdk.core.response.helper.a.cp(adInfo) == 1) {
            ViewStub viewStub2 = (ViewStub) viewGroup.findViewById(R.id.ksad_reward_jinniu_card);
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.d(viewStub2 != null ? (ViewGroup) viewStub2.inflate() : (ViewGroup) viewGroup.findViewById(R.id.ksad_reward_jinniu_root)));
        }
    }
}
