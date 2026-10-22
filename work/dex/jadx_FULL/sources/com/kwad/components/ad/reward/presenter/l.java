package com.kwad.components.ad.reward.presenter;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class l extends b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl sB;

    @Nullable
    private com.kwad.components.ad.reward.n.g wJ;
    private KsLogoView wL;

    @Nullable
    private com.kwad.components.ad.reward.n.l wM;
    private boolean wK = false;
    private com.kwad.components.core.video.m kf = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.l.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            l.this.iR();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iR() {
        if (this.wK) {
            return;
        }
        com.kwad.components.ad.reward.n.g gVar = this.wJ;
        if (gVar == null) {
            this.sB.Q(false);
        } else {
            gVar.a(new com.kwad.components.ad.reward.n.g.a() { // from class: com.kwad.components.ad.reward.presenter.l.2
                @Override // com.kwad.components.ad.reward.n.g.a
                public final void iS() {
                    l.this.sB.Q(true);
                }
            }, 500L);
        }
        this.wK = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ad.reward.g gVar = this.uj;
        this.sB = gVar.sB;
        gVar.sz.a(this.kf);
        AdTemplate adTemplate = this.uj.mAdTemplate;
        boolean z = com.kwad.sdk.core.response.helper.b.dU(adTemplate).displayWeakCard;
        this.uj.B(z);
        if (z) {
            if (this.wJ == null) {
                this.wJ = new com.kwad.components.ad.reward.n.g(this.uj);
            }
            this.wJ.h((AdBaseFrameLayout) findViewById(R.id.ksad_root_container));
            this.wJ.b(com.kwad.components.ad.reward.n.r.ah(adTemplate));
        }
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        if (com.kwad.sdk.core.response.helper.a.cN(adTemplate)) {
            if (this.wM == null) {
                this.wM = new com.kwad.components.ad.reward.n.l(this.uj);
            }
            this.wM.j(this.uj.mRootContainer);
            this.wM.b(com.kwad.components.ad.reward.n.r.ah(adTemplate));
            com.kwad.components.ad.reward.presenter.platdetail.actionbar.d.a(getContext(), adInfoEO, this.wL, R.dimen.ksad_live_subscribe_card_logo_margin_bottom, false);
        }
        this.uj.sB.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wL = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.sz.b(this.kf);
        this.uj.sB.b(this);
        com.kwad.components.ad.reward.n.l lVar = this.wM;
        if (lVar != null) {
            lVar.onUnbind();
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        com.kwad.components.ad.reward.n.l lVar = this.wM;
        if (lVar != null) {
            lVar.lF();
        }
    }
}
