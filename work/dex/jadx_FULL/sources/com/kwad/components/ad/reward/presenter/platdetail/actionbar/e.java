package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.ad.reward.n.n;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.core.t.m;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e extends com.kwad.components.ad.reward.presenter.b implements RewardActionBarControl.c {
    private ViewGroup mRootContainer;
    private KsLogoView wL;
    private n zn;
    private int zo;
    private FrameLayout.LayoutParams zp;
    private n.a zq;

    public e(ViewGroup viewGroup, n.a aVar) {
        this.mRootContainer = viewGroup;
        this.zq = aVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.sB.a(this);
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate);
        this.zo = this.wL.getVisibility();
        this.zp = d.a(getContext(), adInfoEO, this.wL, R.dimen.ksad_reward_order_logo_margin_bottom, !this.uj.sz.ls());
        n nVar = new n(this.mRootContainer, new com.kwad.components.ad.reward.n.a(getContext(), this.uj) { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.e.1
            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void jE() {
                e.this.uj.a(1, e.this.getContext(), 10, 2);
            }

            @Override // com.kwad.components.ad.reward.n.a, com.kwad.components.ad.reward.n.b
            public final void jF() {
                e.this.uj.a(1, e.this.getContext(), 10, 2);
            }
        });
        this.zn = nVar;
        nVar.a(this.zq);
        this.zn.b(r.ah(this.uj.mAdTemplate));
        m.a(new com.kwad.components.core.widget.e(), this.zn.ib());
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.c
    public final void e(a aVar) {
        this.mRootContainer.setVisibility(0);
        RewardActionBarControl.a(aVar, this.mRootContainer, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORDER);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wL = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.wL.setVisibility(this.zo);
        FrameLayout.LayoutParams layoutParams = this.zp;
        if (layoutParams != null) {
            this.wL.setLayoutParams(layoutParams);
        }
    }
}
