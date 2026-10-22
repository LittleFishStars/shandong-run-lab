package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.n.h;
import com.kwad.components.ad.reward.n.r;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait;
import com.kwad.components.ad.reward.widget.actionbar.ActionBarH5;
import com.kwad.components.core.t.x;
import com.kwad.components.core.video.m;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b {

    @Nullable
    private ValueAnimator fp;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private RewardActionBarControl sB;
    private KsLogoView wL;
    private ActionBarAppLandscape yM;
    private ActionBarAppPortrait yN;
    private ActionBarH5 yO;
    private boolean yQ;

    @Nullable
    private ViewGroup yR;

    @Nullable
    private ViewGroup yS;

    @Nullable
    private ViewGroup yT;
    private h yU;
    private boolean yV;
    private boolean yP = false;
    private final m wP = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            b.this.yV = true;
            if (!com.kwad.sdk.core.response.helper.a.cY(b.this.mAdInfo) || b.this.yT == null) {
                return;
            }
            b.this.yT.setVisibility(8);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
            super.onMediaPlayStart();
            b.this.yV = false;
            if (!com.kwad.sdk.core.response.helper.a.cY(b.this.mAdInfo) || b.this.yT == null) {
                return;
            }
            b.this.yT.setVisibility(0);
        }
    };
    private RewardActionBarControl.b yW = new RewardActionBarControl.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.4
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.b
        public final void a(boolean z, a aVar) {
            b.this.yQ = true;
            b.this.a(z, aVar);
        }
    };
    private g yX = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.5
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            b.this.yQ = false;
            b.this.N(false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z) {
        if (this.yP) {
            this.yP = false;
            this.wL.setVisibility(8);
            ViewGroup viewGroup = this.yR;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            ViewGroup viewGroup2 = this.yT;
            if (viewGroup2 != null) {
                viewGroup2.setVisibility(8);
            }
            if (!com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
                if (z) {
                    h(this.yO, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
                    return;
                } else {
                    this.yO.setVisibility(8);
                    return;
                }
            }
            if (this.uj.mScreenOrientation == 1) {
                if (z) {
                    jt();
                    return;
                } else {
                    ju();
                    return;
                }
            }
            if (z) {
                ActionBarAppPortrait actionBarAppPortrait = this.yN;
                if (actionBarAppPortrait != null) {
                    h(actionBarAppPortrait, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
                    return;
                }
                return;
            }
            ActionBarAppPortrait actionBarAppPortrait2 = this.yN;
            if (actionBarAppPortrait2 != null) {
                actionBarAppPortrait2.setVisibility(8);
            }
        }
    }

    private void br() {
        ValueAnimator valueAnimator = this.fp;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.fp.cancel();
        }
    }

    private void ds() {
        if (com.kwad.sdk.core.response.helper.a.cS(this.mAdInfo)) {
            this.yR = (ViewGroup) findViewById(R.id.ksad_reward_jinniu_root);
        }
        this.wL.bl(this.mAdTemplate);
        com.kwad.components.ad.reward.g gVar = this.uj;
        this.mApkDownloadHelper = gVar.mApkDownloadHelper;
        RewardActionBarControl rewardActionBarControl = gVar.sB;
        this.sB = rewardActionBarControl;
        rewardActionBarControl.a(this.yW);
        this.uj.b(this.yX);
    }

    private void jr() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar_landscape);
        if (viewStub != null) {
            this.yM = (ActionBarAppLandscape) viewStub.inflate();
        } else {
            this.yM = (ActionBarAppLandscape) findViewById(R.id.ksad_video_play_bar_app_landscape);
        }
    }

    private void js() {
        ViewStub viewStub = (ViewStub) findViewById(R.id.view_stub_action_bar);
        if (viewStub != null) {
            this.yN = (ActionBarAppPortrait) viewStub.inflate();
        } else {
            this.yN = (ActionBarAppPortrait) findViewById(R.id.ksad_video_play_bar_app_portrait);
        }
    }

    private void jt() {
        js();
        g(this.yN, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
    }

    private void ju() {
        ActionBarAppPortrait actionBarAppPortrait = this.yN;
        if (actionBarAppPortrait != null) {
            actionBarAppPortrait.setVisibility(8);
        }
    }

    public final void O(boolean z) {
        com.kwad.sdk.core.adlog.c.b bVarEc = new com.kwad.sdk.core.adlog.c.b().f(this.uj.mRootContainer.getTouchCoords()).ec(z ? 1 : 153);
        com.kwad.components.ad.reward.g gVar = this.uj;
        com.kwad.components.ad.reward.j.b.a(gVar.mAdTemplate, "native_id", (String) null, bVarEc, gVar.mReportExtData);
        this.uj.sy.dc();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.uj.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        this.uj.sz.a(this.wP);
        ds();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.wL = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
        this.yO = (ActionBarH5) findViewById(R.id.ksad_video_play_bar_h5);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.sB;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.b) null);
        }
        this.uj.sz.b(this.wP);
        this.uj.c(this.yX);
        br();
    }

    private void d(boolean z, a aVar) {
        this.yO.a(this.mAdTemplate, new ActionBarH5.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.10
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarH5.a
            public final void P(boolean z2) {
                b.this.O(z2);
            }
        });
        if (z) {
            g(this.yO, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.yO.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.yO, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void f(final View view, int i) {
        br();
        view.setVisibility(0);
        Interpolator interpolatorCreate = PathInterpolatorCompat.create(0.0f, 0.0f, 0.58f, 1.0f);
        ValueAnimator valueAnimatorC = x.c(view, i, 0);
        this.fp = valueAnimatorC;
        valueAnimatorC.setInterpolator(interpolatorCreate);
        this.fp.setDuration(500L);
        this.fp.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.11
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.fp.start();
    }

    @Deprecated
    private void g(final View view, int i) {
        br();
        view.setVisibility(0);
        ValueAnimator valueAnimatorB = x.b(view, 0, i);
        this.fp = valueAnimatorB;
        valueAnimatorB.setInterpolator(new DecelerateInterpolator(2.0f));
        this.fp.setDuration(500L);
        this.fp.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(0);
            }
        });
        this.fp.start();
    }

    private void h(final View view, int i) {
        br();
        view.setVisibility(0);
        ValueAnimator valueAnimatorB = x.b(view, i, 0);
        this.fp = valueAnimatorB;
        valueAnimatorB.setInterpolator(new DecelerateInterpolator(2.0f));
        this.fp.setDuration(300L);
        this.fp.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                view.setVisibility(8);
            }
        });
        this.fp.start();
    }

    private void b(boolean z, a aVar) {
        jr();
        this.yM.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppLandscape.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.8
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.a
            public final void P(boolean z2) {
                b.this.O(z2);
            }
        });
        if (z) {
            g(this.yM, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.yM.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.yM, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    private void c(boolean z, a aVar) {
        js();
        this.yN.a(this.mAdTemplate, this.mApkDownloadHelper, new ActionBarAppPortrait.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.9
            @Override // com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.a
            public final void P(boolean z2) {
                b.this.O(z2);
            }
        });
        if (z) {
            g(this.yN, com.kwad.sdk.c.a.a.a(getContext(), 90.0f));
        } else {
            this.yN.setVisibility(0);
        }
        RewardActionBarControl.a(aVar, this.yN, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_DEFAULT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, a aVar) {
        ViewGroup viewGroup;
        if (this.yP) {
            return;
        }
        this.yP = true;
        this.wL.setVisibility(com.kwad.sdk.core.response.helper.a.cY(this.mAdInfo) ? 8 : 0);
        getContext();
        final boolean z2 = !as.VM();
        if (com.kwad.sdk.core.response.helper.a.bj(this.mAdInfo)) {
            if (this.yU == null) {
                h hVar = new h() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.6
                    @Override // com.kwad.components.ad.reward.n.h
                    public final int jv() {
                        return z2 ? R.id.ksad_common_app_card_land_stub : super.jv();
                    }
                };
                this.yU = hVar;
                hVar.a(new h.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.b.7
                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jA() {
                        b.this.uj.a(1, b.this.getContext(), 84, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jB() {
                        b.this.uj.a(1, b.this.getContext(), 53, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jw() {
                        b.this.uj.a(1, b.this.getContext(), 29, 1);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jx() {
                        b.this.uj.a(1, b.this.getContext(), 30, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jy() {
                        b.this.uj.a(1, b.this.getContext(), 31, 2);
                    }

                    @Override // com.kwad.components.ad.reward.n.h.a
                    public final void jz() {
                        b.this.uj.a(1, b.this.getContext(), 32, 2);
                    }
                });
                this.yU.h((ViewGroup) getRootView());
                this.yU.b(r.a(this.mAdTemplate, this.mApkDownloadHelper));
            }
            this.yU.show();
            RewardActionBarControl.a(aVar, this.yU.ib(), RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
            return;
        }
        if (com.kwad.sdk.core.response.helper.a.co(this.mAdInfo) == 1 && (viewGroup = this.yR) != null) {
            viewGroup.setVisibility(0);
            RewardActionBarControl.a(aVar, this.yR, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_JINNIU);
            return;
        }
        if (com.kwad.sdk.core.response.helper.a.cY(this.mAdInfo)) {
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.ksad_reward_origin_live_root);
            this.yT = viewGroup2;
            if (viewGroup2 != null) {
                if (!this.yV) {
                    viewGroup2.setVisibility(0);
                }
                RewardActionBarControl.a(aVar, this.yT, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_ORIGIN_LIVE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.helper.a.cN(this.mAdTemplate)) {
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.ksad_reward_live_subscribe_root);
            this.yS = viewGroup3;
            if (viewGroup3 != null) {
                Resources resources = viewGroup3.getResources();
                f(this.yS, (int) (resources.getDimension(R.dimen.ksad_live_subscribe_card_full_height) + resources.getDimension(R.dimen.ksad_live_subscribe_card_margin)));
                RewardActionBarControl.a(aVar, this.yS, RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_LIVE_SUBSCRIBE);
                return;
            }
        }
        if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            if (this.uj.mScreenOrientation == 1) {
                b(z, aVar);
                return;
            } else {
                c(z, aVar);
                return;
            }
        }
        d(z, aVar);
    }
}
