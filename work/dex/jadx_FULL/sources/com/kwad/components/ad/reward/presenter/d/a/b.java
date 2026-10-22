package com.kwad.components.ad.reward.presenter.d.a;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.l;
import com.kwad.components.ad.reward.g;
import com.kwad.components.ad.reward.monitor.d;
import com.kwad.components.ad.reward.n.k;
import com.kwad.components.ad.reward.widget.tailframe.TailFrameView;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements as.b {
    private boolean Aa;
    private k Ab;
    private Drawable Ae;

    @Nullable
    private com.kwad.components.ad.l.b dW;
    private AdInfo mAdInfo;
    private DetailVideoView mDetailVideoView;
    private TailFrameView zY;
    private volatile boolean zZ;
    private boolean xl = false;
    private int Ac = Integer.MIN_VALUE;
    private int Ad = Integer.MIN_VALUE;
    private final l mRewardVerifyListener = new l() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            b.this.jT();
            if (b.this.zY == null || !g.T(b.this.mAdTemplate)) {
                return;
            }
            b.this.zY.lw();
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.2
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            if ((!e.fb(b.this.mAdTemplate) && b.this.xl && !b.this.uj.hc()) || b.this.uj.tb || b.this.uj.th) {
                return;
            }
            b.this.Aa = true;
            if (b.this.dW != null && b.this.dW.bc()) {
                b.this.Aa = false;
            }
            b.this.uj.ts = true ^ b.this.Aa;
            if (b.this.Aa) {
                if (b.this.uj.sC != null) {
                    d.a(b.this.uj.mAdTemplate, b.this.uj.sO, "end_card", com.kwad.sdk.core.response.helper.b.dj(b.this.mAdTemplate), System.currentTimeMillis() - b.this.uj.sC.getLoadTime(), 1);
                }
                b.this.bt();
            }
        }

        @Override // com.kwad.components.ad.reward.e.a, com.kwad.components.ad.reward.e.g
        public final int getPriority() {
            return -1;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void M(boolean z) {
        com.kwad.components.ad.reward.j.b.a(this.mAdTemplate, "native_id", (String) null, new com.kwad.sdk.core.adlog.c.b().f(this.uj.mRootContainer.getTouchCoords()).ec(z ? 2 : 153), this.uj.mReportExtData);
        this.uj.sy.dc();
    }

    private void an(int i) {
        ViewGroup.LayoutParams layoutParams = this.mDetailVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            this.mDetailVideoView.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt() {
        jT();
        this.zY.a(new com.kwad.components.ad.reward.widget.tailframe.b() { // from class: com.kwad.components.ad.reward.presenter.d.a.b.3
            @Override // com.kwad.components.ad.reward.widget.tailframe.b
            public final void P(boolean z) {
                b.this.M(z);
            }
        });
        this.zY.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jT() {
        if (this.zZ) {
            return;
        }
        jU();
    }

    private void jU() {
        com.kwad.sdk.core.d.c.d("RewardPlayEndNativeCardPresenter", "initTailView");
        this.zY.a(getContext(), this.uj.mScreenOrientation == 0, jW());
        this.zZ = true;
    }

    private void jV() {
        if (this.Aa) {
            jT();
            this.zY.destroy();
            this.zY.setVisibility(8);
            this.Ab.hide();
        }
    }

    private boolean jW() {
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBd = com.kwad.sdk.core.response.helper.a.bd(this.mAdInfo);
        return materialFeatureBd.height > materialFeatureBd.width;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.playable.a aVar = this.uj.sA;
        if (aVar != null) {
            aVar.a(this);
        }
        this.mAdInfo = e.eO(this.mAdTemplate);
        g gVar = this.uj;
        this.dW = gVar.sC;
        gVar.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.b.gw().a(this.mRewardVerifyListener);
        this.zY.setCallerContext(this.uj);
        ViewStub viewStub = (ViewStub) findViewById(R.id.ksad_playend_native_jinniu);
        if (viewStub != null) {
            this.Ab = new k(this.uj, viewStub);
        } else {
            this.Ab = new k(this.uj, (ViewGroup) findViewById(R.id.ksad_reward_jinniu_end_card_root));
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.zY = (TailFrameView) findViewById(R.id.ksad_video_tail_frame);
        DetailVideoView detailVideoView = (DetailVideoView) findViewById(R.id.ksad_video_player);
        this.mDetailVideoView = detailVideoView;
        if (detailVideoView.getLayoutTransition() != null) {
            this.mDetailVideoView.getLayoutTransition().enableTransitionType(4);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        com.kwad.components.core.playable.a aVar = this.uj.sA;
        if (aVar != null) {
            aVar.b(this);
        }
        com.kwad.components.ad.reward.b.gw().b(this.mRewardVerifyListener);
        jV();
        this.uj.c(this.mPlayEndPageListener);
        DetailVideoView detailVideoView = this.mDetailVideoView;
        if (detailVideoView != null) {
            int i = this.Ad;
            if (i != Integer.MIN_VALUE) {
                detailVideoView.updateTextureViewGravity(i);
            }
            com.kwad.sdk.core.d.c.d("RewardPlayEndNativeCardPresenter", "onUnbind:  videoOriginalWidth :" + this.Ac);
            int i2 = this.Ac;
            if (i2 != Integer.MIN_VALUE) {
                an(i2);
            }
            Drawable drawable = this.Ae;
            if (drawable != null) {
                this.mDetailVideoView.setBackground(drawable);
            }
        }
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        this.xl = aVar.isSuccess();
    }
}
