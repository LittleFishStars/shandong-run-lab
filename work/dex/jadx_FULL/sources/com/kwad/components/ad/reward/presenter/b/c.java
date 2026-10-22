package com.kwad.components.ad.reward.presenter.b;

import android.view.View;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.n.o;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.ad.reward.presenter.b implements com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private RewardActionBarControl sB;
    private m wP = new m() { // from class: com.kwad.components.ad.reward.presenter.b.c.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            if (c.this.uj != null && c.this.uj.mAdTemplate != null && c.this.uj.mAdTemplate.mLiveDetailRewardFromAdLive != null) {
                c.this.uj.mAdTemplate.mLiveDetailRewardFromAdLive.hasRewardTime = j2 / 1000;
            }
            c.this.iR();
        }
    };

    @Nullable
    private o yl;

    /* JADX INFO: Access modifiers changed from: private */
    public void iR() {
        this.sB.Q(false);
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        g gVar = this.uj;
        this.sB = gVar.sB;
        gVar.sz.a(this.wP);
        AdTemplate adTemplate = this.uj.mAdTemplate;
        AdInfo adInfoEO = e.eO(adTemplate);
        if (com.kwad.sdk.core.response.helper.a.cY(adInfoEO)) {
            if (this.yl == null) {
                this.yl = new o(this.uj);
            }
            this.yl.b(this.uj.mRootContainer, com.kwad.sdk.core.response.helper.a.bl(adInfoEO));
            this.yl.b(r.ah(adTemplate));
            findViewById(R.id.ksad_reward_origin_live_root).setVisibility(8);
        }
        this.uj.sB.a(this);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.sz.b(this.wP);
        this.uj.sB.b(this);
        o oVar = this.yl;
        if (oVar != null) {
            oVar.onUnbind();
        }
    }
}
