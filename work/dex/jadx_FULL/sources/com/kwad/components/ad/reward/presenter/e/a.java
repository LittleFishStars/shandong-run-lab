package com.kwad.components.ad.reward.presenter.e;

import android.widget.FrameLayout;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.f.g;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.response.helper.b;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends g implements com.kwad.components.ad.reward.k.a {
    private AdMatrixInfo.PreLandingPageTKInfo Au;
    private az Av;
    private boolean rL = false;
    private com.kwad.components.ad.reward.e.g Aw = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.e.a.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            c.d("TKPreFormPresenter", "handleToSkip PlayEndPageListener onPlayEndPageShow: " + a.this.uj.sT);
            if (a.this.uj.sT) {
                return;
            }
            a.this.ke();
        }
    };

    private void U(final boolean z) {
        c.d("TKPreFormPresenter", "switchPreForm: " + z);
        this.Ba.post(new bi() { // from class: com.kwad.components.ad.reward.presenter.e.a.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                a.this.Ba.setVisibility(z ? 0 : 4);
                a.this.Ba.setClickable(z);
                if (a.this.Av != null) {
                    if (z) {
                        a.this.Av.yx();
                        a.this.Av.yy();
                    } else {
                        a.this.Av.yz();
                        a.this.Av.yA();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ke() {
        if (!this.rL || this.Au == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip handleToPlayEnd isPlayEndShow: " + this.Au.isPlayEndShow());
        if (this.Au.isPlayEndShow()) {
            U(true);
        }
    }

    private void kf() {
        if (!this.rL || this.Au == null) {
            return;
        }
        c.d("TKPreFormPresenter", "handleToSkip mPreLandingPageData isSkipShow: " + this.Au.isSkipShow());
        if (this.Au.isSkipShow()) {
            U(true);
        }
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        super.aE();
        c.d("TKPreFormPresenter", "onTkLoadSuccess");
        this.rL = true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.Au = b.ec(this.uj.mAdTemplate);
        this.uj.b(this.Aw);
        this.uj.a((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_pre_landing_page";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return b.ev(this.uj.mAdTemplate);
    }

    public final BackPressHandleResult hJ() {
        KSFrameLayout kSFrameLayout;
        if (this.AI == null || (kSFrameLayout = this.Ba) == null) {
            return BackPressHandleResult.NOT_HANDLED;
        }
        return kSFrameLayout.getVisibility() == 0 ? this.AI.hJ() : BackPressHandleResult.NOT_HANDLED;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final int jj() {
        return R.id.ksad_pre_form_card;
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void kg() {
        c.d("TKPreFormPresenter", "onPlayComplete: ");
        ke();
    }

    @Override // com.kwad.components.ad.reward.k.a
    public final void kh() {
        c.d("TKPreFormPresenter", "onSkipClick: ");
        kf();
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.c(this.Aw);
        this.uj.b((com.kwad.components.ad.reward.k.a) this);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.g
    public final void a(FrameLayout frameLayout) {
        frameLayout.setVisibility(4);
        frameLayout.setClickable(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        aVar.width = (int) ((bt.getScreenWidth(getContext()) / fBB) + 0.5f);
        aVar.height = (int) ((bt.getScreenHeight(getContext()) / fBB) + 0.5f);
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.Av = azVar;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        super.a(tKRenderFailReason);
        this.rL = false;
        c.d("TKPreFormPresenter", "onTkLoadFailed");
        U(false);
    }
}
