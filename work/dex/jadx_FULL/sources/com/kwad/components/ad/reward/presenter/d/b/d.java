package com.kwad.components.ad.reward.presenter.d.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, c {
    private static final String[] As = {"未获得奖励", "已获得奖励1/2", "已获得全部奖励"};
    private ViewGroup Ao;
    private ImageView Ap;
    private ViewGroup Aq;
    private TextView Ar;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (g.T(d.this.uj.mAdTemplate)) {
                d.this.kd();
            }
        }
    };

    private void ds() {
        com.kwad.components.ad.reward.b.gw().a(this.mRewardVerifyListener);
        this.Ao.setVisibility(0);
        this.Aq.setVisibility(g.T(this.uj.mAdTemplate) ? 0 : 8);
    }

    private void kc() {
        ImageView imageView = this.Ap;
        if (imageView != null) {
            imageView.setVisibility(0);
            this.Ap.setOnClickListener(this);
        }
        ViewGroup viewGroup = this.Ao;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(this);
            this.Ao.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd() {
        this.Ar.setText(As[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.sdk.core.adlog.c.b bVarEc = new com.kwad.sdk.core.adlog.c.b().f(this.uj.mRootContainer.getTouchCoords()).ec(41);
        g gVar = this.uj;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, (String) null, (String) null, bVarEc, gVar.mReportExtData);
        this.uj.sy.dc();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        ds();
    }

    @Override // com.kwad.components.ad.reward.presenter.d.b.c
    public final void ka() {
        g gVar = this.uj;
        if (gVar.tb) {
            if (com.kwad.sdk.core.response.helper.a.ay(e.eO(gVar.mAdTemplate))) {
                this.Aq.setVisibility(8);
            }
        } else if (g.R(gVar.mAdTemplate) || g.S(this.uj.mAdTemplate)) {
            if (this.uj.hi()) {
                return;
            }
            this.Ar.setText(this.uj.sU ? As[1] : As[0]);
        } else if (this.uj.hi()) {
            kc();
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.Ap || view == this.Ao) {
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(view.getContext()).aJ(this.uj.mAdTemplate).b(this.uj.mApkDownloadHelper).as(false).aN(2).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.reward.presenter.d.b.d.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    d.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.Ao = (ViewGroup) findViewById(R.id.ksad_end_reward_icon_layout);
        this.Ap = (ImageView) findViewById(R.id.ksad_end_reward_icon);
        this.Aq = (ViewGroup) findViewById(R.id.ksad_detail_reward_deep_task_view_playend);
        this.Ar = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down_playend);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.gw().b(this.mRewardVerifyListener);
        this.Ao.setVisibility(8);
        this.Ap.setVisibility(8);
        this.Aq.setVisibility(8);
    }
}
