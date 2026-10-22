package com.kwad.components.ad.reward.presenter.platdetail.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.k;
import com.kwad.components.ad.reward.n.p;
import com.kwad.components.core.innerEc.live.base.f;
import com.kwad.components.core.video.m;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.LiveDetailReward;
import com.kwad.sdk.utils.cc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b implements View.OnClickListener, cc.a {
    private static final String[] zz = {"%ss后获得奖励1", "已获得奖励1/2", "已获得全部奖励"};
    private cc ca;
    private TextView kv;
    private boolean kx;
    private long ky;
    private AdInfo mAdInfo;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private TextView zv;
    private ImageView zw;
    private View zx;
    private boolean zy = false;
    private boolean zA = false;
    private boolean zB = false;
    private long zC = 0;
    private boolean zD = false;
    private f zE = new f() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.1
        @Override // com.kwad.components.core.innerEc.live.base.f
        public final void b(LiveDetailReward liveDetailReward) {
            a.this.zD = liveDetailReward.success;
            long j = (long) (liveDetailReward.hasRewardTime * 1000.0d);
            a aVar = a.this;
            aVar.zC = j - aVar.ky;
            a.this.R((int) liveDetailReward.countDownSecond);
        }
    };
    private final m kf = new m() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.h
        public final void onLivePlayEnd() {
            super.onLivePlayEnd();
            if (a.this.kx) {
                return;
            }
            a.this.ca.sendEmptyMessageDelayed(1, 500L);
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            long jH = g.h(a.this.mAdInfo);
            a.this.ky = j2;
            a.this.a(jH, j2);
        }
    };
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.3
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            a.b(a.this, true);
            a.this.zv.setText(a.zz[2]);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void R(int i) {
        AdTemplate adTemplate;
        LiveDetailReward liveDetailReward;
        this.uj.tk = i;
        if (!g.T(this.mAdTemplate)) {
            this.kv.setText(String.valueOf(i));
        } else if (!this.zA) {
            this.zv.setText(String.format(zz[0], Integer.valueOf(i)));
        }
        g gVar = this.uj;
        if (gVar == null || (adTemplate = gVar.mAdTemplate) == null || (liveDetailReward = adTemplate.mLiveDetailRewardFromAdLive) == null) {
            return;
        }
        liveDetailReward.countDownSecond = i;
    }

    private void ds() {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        this.mAdInfo = adInfoEO;
        this.mApkDownloadHelper = this.uj.mApkDownloadHelper;
        com.kwad.sdk.core.response.helper.a.O(adInfoEO);
        long jH = g.h(this.mAdInfo) / 1000;
        if (g.T(this.mAdTemplate)) {
            this.zx.setVisibility(0);
            this.zx.setOnClickListener(this);
            this.zv.setText(String.format(zz[0], Long.valueOf(jH)));
            this.kv.setVisibility(8);
        } else {
            this.zx.setVisibility(8);
            this.kv.setText(String.valueOf(jH));
            this.kv.setVisibility(0);
            this.kv.setAlpha(1.0f);
        }
        com.kwad.components.ad.reward.b.gw().a(this.mRewardVerifyListener);
        this.uj.sz.a(this.kf);
    }

    private void jH() {
        if (this.zy) {
            return;
        }
        this.zy = true;
        this.zw.setAlpha(0.0f);
        this.zw.setVisibility(0);
        this.zw.setOnClickListener(this);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                a.this.kv.setVisibility(8);
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.kv.setAlpha(1.0f - fFloatValue);
                a.this.zw.setAlpha(fFloatValue);
            }
        });
        valueAnimatorOfFloat.start();
    }

    private void jI() {
        com.kwad.components.ad.reward.e.d dVar = this.uj.mAdRewardStepListener;
        if (dVar != null) {
            dVar.gB();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyAdClick() {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", "playTopBar-style1", new com.kwad.sdk.core.adlog.c.b().f(this.uj.mRootContainer.getTouchCoords()).ec(41), this.uj.mReportExtData);
        this.uj.sy.dc();
    }

    private void notifyRewardVerify() {
        AdTemplate adTemplate;
        LiveDetailReward liveDetailReward;
        this.uj.sy.onRewardVerify();
        g gVar = this.uj;
        if (gVar == null || (adTemplate = gVar.mAdTemplate) == null || (liveDetailReward = adTemplate.mLiveDetailRewardFromAdLive) == null) {
            return;
        }
        liveDetailReward.success = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.ca = new cc(this);
        this.uj.a(this.zE);
        ds();
        if (this.uj.sz.ls()) {
            R((int) (com.kwad.sdk.core.response.helper.a.ak(this.mAdInfo) / 1000.0f));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.zw || view == this.zx) {
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(view.getContext()).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).aN(2).D(this.uj.sz.getPlayDuration()).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.a.a.6
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    a.this.notifyAdClick();
                }
            }));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kv = (TextView) findViewById(R.id.ksad_video_count_down);
        this.zw = (ImageView) findViewById(R.id.ksad_detail_reward_icon);
        this.zv = (TextView) findViewById(R.id.ksad_reward_deep_task_count_down);
        this.zx = findViewById(R.id.ksad_detail_reward_deep_task_view);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.ad.reward.b.gw().b(this.mRewardVerifyListener);
        this.uj.sz.b(this.kf);
        this.zw.setVisibility(8);
        this.zx.setVisibility(8);
        this.zy = false;
        this.zA = false;
        this.kx = false;
        this.uj.b(this.zE);
    }

    public static /* synthetic */ boolean b(a aVar, boolean z) {
        aVar.zA = true;
        return true;
    }

    public final void a(long j, long j2) {
        int iAQ;
        if (com.kwad.sdk.core.response.helper.a.aU(this.mAdInfo) && com.kwad.components.core.r.a.wm().wn() == 0) {
            iAQ = com.kwad.sdk.core.response.helper.a.aS(this.mAdInfo);
        } else {
            iAQ = com.kwad.sdk.core.response.helper.a.aQ(this.mAdInfo);
        }
        g gVar = this.uj;
        long j3 = iAQ * (gVar.sR ? 1000 : 0);
        com.kwad.components.ad.reward.m.b(gVar, j2, j, j3);
        if (!this.zB) {
            this.zB = k.a(this.uj, j2, j, j3);
        }
        a(j2, j, j3);
    }

    private void a(long j, long j2, long j3) {
        com.kwad.components.ad.reward.l.a.a aVar;
        com.kwad.components.ad.reward.l.b.a aVar2;
        if (!this.zD) {
            long j4 = this.zC;
            if (j + j4 < (j2 - 800) - j3) {
                int iFloor = (int) Math.floor(((j2 - j) - j4) / 1000.0f);
                int i = iFloor > 0 ? iFloor : 1;
                R(i);
                p pVar = this.uj.ta;
                if (pVar != null) {
                    pVar.at(i);
                    return;
                }
                return;
            }
        }
        this.uj.sU = true;
        if (g.T(this.mAdTemplate)) {
            if (g.R(this.mAdTemplate) && (aVar2 = this.uj.ti) != null) {
                if (!aVar2.lh()) {
                    this.uj.ti.lg();
                }
            } else if (g.S(this.mAdTemplate) && (aVar = this.uj.tj) != null && !aVar.lh()) {
                this.uj.tj.lg();
            }
            if (this.zA) {
                return;
            }
            this.zv.setText(zz[1]);
            jI();
            return;
        }
        notifyRewardVerify();
        jH();
        p pVar2 = this.uj.ta;
        if (pVar2 != null) {
            pVar2.at(0);
        }
    }

    @Override // com.kwad.sdk.utils.cc.a
    public final void a(Message message) {
        if (message.what == 1) {
            if (!this.uj.hh() && !this.uj.hg()) {
                this.ky += 500;
                a(com.kwad.sdk.core.response.helper.a.ak(this.mAdInfo), this.ky);
                this.ca.sendEmptyMessageDelayed(1, 500L);
                return;
            }
            this.ca.sendEmptyMessageDelayed(1, 500L);
        }
    }
}
