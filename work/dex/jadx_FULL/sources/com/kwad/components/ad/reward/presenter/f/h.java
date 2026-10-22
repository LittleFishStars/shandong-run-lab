package com.kwad.components.ad.reward.presenter.f;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.j;
import com.kwad.components.ad.reward.e.n;
import com.kwad.components.ad.reward.e.o;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h extends g implements j, com.kwad.components.ad.reward.presenter.platdetail.actionbar.a {
    private boolean AX;
    private boolean AY;

    @Nullable
    private View Bb;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private az f15072do;
    private boolean Bc = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            h.this.Ba.setVisibility(8);
        }
    };
    private com.kwad.components.ad.reward.g.a Bd = new com.kwad.components.ad.reward.g.a() { // from class: com.kwad.components.ad.reward.presenter.f.h.2
        @Override // com.kwad.components.ad.reward.g.a
        public final void hp() {
            h.this.AY = true;
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void hq() {
            h.this.AY = true;
            h.this.ku();
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void hr() {
            h.this.AY = false;
            if (h.this.f15072do != null) {
                h.this.f15072do.yC();
            }
        }

        @Override // com.kwad.components.ad.reward.g.a
        public final void hs() {
            h.this.AY = false;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ku() {
        az azVar = this.f15072do;
        if (azVar == null || !this.AY) {
            return;
        }
        if (this.AX) {
            azVar.yB();
            return;
        }
        azVar.yx();
        this.f15072do.yy();
        this.AX = true;
    }

    private com.kwad.components.core.webview.tachikoma.b.e.b kx() {
        return new com.kwad.components.core.webview.tachikoma.b.e.b() { // from class: com.kwad.components.ad.reward.presenter.f.h.3
            @Override // com.kwad.components.core.webview.tachikoma.b.e.b
            public final int ky() {
                o oVar = h.this.uj.tg;
                if (oVar != null) {
                    return com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), oVar.dx());
                }
                if (h.this.Bb == null) {
                    return 0;
                }
                ViewGroup.LayoutParams layoutParams = h.this.Bb.getLayoutParams();
                return layoutParams instanceof ViewGroup.MarginLayoutParams ? com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.Bb.getHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : com.kwad.sdk.c.a.a.px2dip(h.this.getContext(), h.this.Bb.getHeight());
            }
        };
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable n nVar) {
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        super.aE();
        ku();
        this.Bc = true;
        this.Ba.setVisibility(0);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.a(this.Bd);
        this.uj.sB.a(this);
        this.uj.b(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gs().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
        if (this.Bc) {
            this.Ba.setVisibility(0);
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dr() {
        if (this.Bc) {
            this.Ba.setVisibility(8);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_top_floor_bar";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.ef(this.uj.mAdTemplate);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int jj() {
        return R.id.ksad_js_topfloor;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        az azVar = this.f15072do;
        if (azVar != null) {
            azVar.yz();
            this.f15072do.yA();
        }
        super.onUnbind();
        this.uj.b(this.Bd);
        this.uj.sB.b(this);
        this.uj.c(this.mPlayEndPageListener);
        com.kwad.components.ad.reward.a.gs().b(this);
        this.uj.a((com.kwad.components.core.webview.tachikoma.f.a) null);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.f15072do;
        if (azVar != null) {
            azVar.yz();
            this.f15072do.yA();
        }
        this.Bc = false;
        this.Ba.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / fBB) + 0.5f);
        aVar.height = (int) ((screenHeight / fBB) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new com.kwad.components.core.webview.tachikoma.b.e(kx()));
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.f15072do = azVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.a
    public final void a(RewardActionBarControl.ShowActionBarResult showActionBarResult, View view) {
        this.Bb = view;
    }
}
