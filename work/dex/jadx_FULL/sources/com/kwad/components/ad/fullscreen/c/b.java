package com.kwad.components.ad.fullscreen.c;

import android.os.SystemClock;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.RewardRenderResult;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.d;
import com.kwad.components.ad.reward.presenter.e;
import com.kwad.components.ad.reward.presenter.f.h;
import com.kwad.components.ad.reward.presenter.j;
import com.kwad.components.ad.reward.presenter.k;
import com.kwad.components.ad.reward.presenter.l;
import com.kwad.components.ad.reward.presenter.m;
import com.kwad.components.ad.reward.presenter.r;
import com.kwad.components.ad.reward.presenter.v;
import com.kwad.components.core.e.e.f;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.as;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends com.kwad.components.ad.reward.presenter.b implements g, f {
    private com.kwad.components.ad.fullscreen.b ki;
    private com.kwad.components.core.n.b kj;

    @Nullable
    private r kk;
    private FrameLayout kl;
    private com.kwad.components.ad.reward.presenter.f.b km;
    private com.kwad.components.core.webview.tachikoma.f.g kn;

    @Nullable
    private com.kwad.components.ad.reward.presenter.e.a ko;
    private com.kwad.components.ad.reward.presenter.f.f kp;
    private boolean kq = false;
    private ViewGroup mRootContainer;

    public b(com.kwad.components.core.n.b bVar, ViewGroup viewGroup, com.kwad.components.ad.fullscreen.b bVar2, com.kwad.components.ad.reward.g gVar) {
        this.kj = bVar;
        this.ki = bVar2;
        this.mRootContainer = viewGroup;
        this.uj = gVar;
        dh();
    }

    private void dh() {
        if (this.ki == null) {
            return;
        }
        dm();
        AdInfo adInfoDa = this.ki.da();
        boolean zDj = com.kwad.sdk.core.response.helper.a.dj(adInfoDa);
        boolean zEM = com.kwad.sdk.core.response.helper.b.eM(adInfoDa);
        if (zDj) {
            this.uj.a(RewardRenderResult.LIVE_TK);
            com.kwad.components.core.webview.tachikoma.e.c.zG().a(dn());
            dj();
        } else if (zEM) {
            com.kwad.components.core.webview.tachikoma.e.c.zG().a(dn());
            this.uj.a(RewardRenderResult.TK_IMAGE);
            dk();
        } else if (!a(this.uj)) {
            this.uj.a(RewardRenderResult.DEFAULT);
            di();
        } else {
            this.uj.a(RewardRenderResult.FULLSCREEN_TK);
            dl();
            com.kwad.components.core.webview.tachikoma.e.c.zG().a(dn());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di() {
        com.kwad.components.core.webview.tachikoma.e.c.zG().b(this.kn);
        com.kwad.components.core.e.e.g.qK().a(this);
        AdTemplate adTemplate = this.ki.getAdTemplate();
        AdInfo adInfoDa = this.ki.da();
        boolean z = this.ki.db() && !as.isOrientationPortrait();
        if (this.ki.jM) {
            a(this);
        }
        a(new v(), true);
        if (com.kwad.sdk.core.response.helper.a.aV(adInfoDa)) {
            a(new d(), true);
        }
        a(new m(), true);
        a(new com.kwad.components.ad.reward.presenter.platdetail.c(), true);
        if (com.kwad.sdk.core.response.helper.b.dN(adInfoDa)) {
            a(new h(), true);
        }
        if (!z) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.actionbar.c(), true);
        }
        a(new com.kwad.components.ad.reward.presenter.c.a(), true);
        if (com.kwad.sdk.core.response.helper.b.ea(adTemplate)) {
            a(new com.kwad.components.ad.fullscreen.c.a.f(), true);
        }
        if (com.kwad.sdk.core.response.helper.a.bj(adInfoDa)) {
            a(new com.kwad.components.ad.reward.presenter.platdetail.b(), true);
        }
        a(new l(), true);
        if (com.kwad.sdk.core.response.helper.a.cY(adInfoDa)) {
            a(new com.kwad.components.ad.reward.presenter.b.c(), true);
            a(new com.kwad.components.ad.reward.presenter.b.b(), true);
            a(new k(), true);
            a(new com.kwad.components.ad.reward.presenter.b.a(), true);
        }
        r rVar = new r(adTemplate, false, false);
        this.kk = rVar;
        a((Presenter) rVar, true);
        a(new c(), true);
        a(new a(), true);
        a(new com.kwad.components.ad.reward.presenter.d.b(adTemplate, false), true);
        a(new e(adInfoDa, this.mRootContainer), true);
        a(new j(), true);
        try {
            com.kwad.components.ad.reward.g gVar = this.uj;
            if (gVar.mStartRenderTime > 0) {
                com.kwad.sdk.commercial.convert.d.b(com.kwad.sdk.core.response.helper.e.eI(gVar.mAdTemplate), 1, SystemClock.elapsedRealtime() - this.uj.mStartRenderTime);
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private void dj() {
        com.kwad.components.ad.fullscreen.c.c.c cVar = new com.kwad.components.ad.fullscreen.c.c.c();
        this.km = cVar;
        a(cVar);
    }

    private void dk() {
        com.kwad.components.ad.fullscreen.c.c.a aVar = new com.kwad.components.ad.fullscreen.c.c.a();
        this.kp = aVar;
        a(aVar);
    }

    private void dl() {
        a((Presenter) new com.kwad.components.ad.fullscreen.c.c.b(), true);
    }

    private void dm() {
        AdInfo adInfoDa = this.ki.da();
        if (!this.ki.jM) {
            a(this);
        }
        if (com.kwad.sdk.core.response.helper.b.eJ(adInfoDa) && as.isOrientationPortrait()) {
            com.kwad.components.ad.reward.presenter.e.a aVar = new com.kwad.components.ad.reward.presenter.e.a();
            this.ko = aVar;
            a((Presenter) aVar, true);
        }
    }

    private com.kwad.components.core.webview.tachikoma.f.g dn() {
        if (this.kn == null) {
            this.kn = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.fullscreen.c.b.1
                @Override // com.kwad.components.core.webview.tachikoma.f.g
                public final void a(String str, long j, long j2, long j3) {
                    try {
                        if (b.this.uj.mStartRenderTime > 0) {
                            com.kwad.sdk.commercial.convert.d.b(com.kwad.sdk.core.response.helper.e.eI(b.this.uj.mAdTemplate), 2, SystemClock.elapsedRealtime() - b.this.uj.mStartRenderTime);
                        }
                    } catch (Throwable th) {
                        ServiceProvider.reportSdkCaughtException(th);
                    }
                    b.this.uj.na = true;
                }

                @Override // com.kwad.components.core.webview.tachikoma.f.b
                public final void x(String str) {
                    if ("tk_fullscreen".equals(str) || "tk_live_video".equals(str)) {
                        b bVar = b.this;
                        bVar.a(bVar);
                        com.kwad.components.ad.reward.g.a(b.this.getContext(), b.this.uj, b.this.m1056do());
                        b.this.di();
                        return;
                    }
                    if ("tk_image_video".equals(str)) {
                        b bVar2 = b.this;
                        bVar2.a(bVar2);
                        b.this.uj.a(RewardRenderResult.DEFAULT);
                        b.this.di();
                    }
                }
            };
        }
        return this.kn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: do, reason: not valid java name */
    public FrameLayout m1056do() {
        if (this.kl == null) {
            this.kl = (FrameLayout) this.mRootContainer.findViewById(R.id.ksad_reward_play_layout);
        }
        return this.kl;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.b(this);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void dd() {
        this.uj.D(true);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void dismiss() {
        this.uj.E(false);
        this.uj.gP();
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public final boolean onBackPressed() {
        r rVar = this.kk;
        if (rVar != null && rVar.onBackPressed()) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.e.a aVar = this.ko;
        if (aVar != null && aVar.hJ() == BackPressHandleResult.HANDLED) {
            return true;
        }
        com.kwad.components.ad.reward.presenter.f.b bVar = this.km;
        return bVar != null && bVar.hJ() == BackPressHandleResult.HANDLED;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.kl = (FrameLayout) this.mRootContainer.findViewById(R.id.ksad_reward_play_layout);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.c(this);
        com.kwad.components.core.e.e.g.qK().b(this);
        com.kwad.components.core.webview.tachikoma.e.c.zG().b(this.kn);
    }

    @Override // com.kwad.components.core.e.e.f
    public final void show() {
        this.uj.gQ();
        this.uj.E(true);
    }

    private static boolean a(com.kwad.components.ad.reward.g gVar) {
        if (!com.kwad.sdk.core.config.e.JM()) {
            com.kwad.components.ad.reward.monitor.c.a(gVar.mAdTemplate, TKRenderFailReason.SWITCH_CLOSE);
            return false;
        }
        if (com.kwad.sdk.core.response.helper.a.bj(com.kwad.sdk.core.response.helper.e.eO(gVar.mAdTemplate))) {
            return false;
        }
        AdMatrixInfo.FullScreenInfo fullScreenInfoDV = com.kwad.sdk.core.response.helper.b.dV(gVar.mAdTemplate);
        if (fullScreenInfoDV != null && fullScreenInfoDV.renderType == 1) {
            return true;
        }
        com.kwad.components.ad.reward.monitor.c.a(gVar.mAdTemplate, TKRenderFailReason.TK_FILE_LOAD_ERROR);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(b bVar) {
        if (this.kq) {
            return;
        }
        bVar.a((Presenter) new com.kwad.components.ad.reward.presenter.a(this.uj), true);
        this.kq = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
