package com.kwad.components.ad.reward.presenter;

import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class r extends b implements com.kwad.components.ad.reward.e.g, com.kwad.components.ad.reward.e.j, as.b {
    private com.kwad.components.core.webview.tachikoma.f.g kn;
    private float wW;
    private boolean xl;

    @Nullable
    private a xm;

    @Nullable
    private q xn;

    @Nullable
    private o xo;
    private p xp;
    private int xq;
    private boolean xr;
    private boolean xs;
    private boolean xt;

    public class a extends com.kwad.components.core.video.m {
        private long videoDuration;
        private long xv;

        private a() {
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            super.onMediaPlayProgress(j, j2);
            this.xv = j2;
            this.videoDuration = j;
            if (r.this.uj.gS()) {
                return;
            }
            r.this.b(j, j2, false);
        }

        public /* synthetic */ a(r rVar, byte b) {
            this();
        }
    }

    public r(AdTemplate adTemplate, boolean z, boolean z2) {
        this.xq = 0;
        this.xr = false;
        this.xs = z;
        this.xt = z2;
        if (com.kwad.sdk.core.response.helper.a.bQ(com.kwad.sdk.core.response.helper.e.eO(adTemplate))) {
            p pVar = new p();
            this.xp = pVar;
            a(pVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j, long j2, boolean z) {
        q qVar;
        if (jc() && j2 >= 10000 && ((float) j2) >= ((float) j) * this.wW) {
            if (!com.kwad.components.ad.reward.a.b.hT()) {
                o oVar = this.xo;
                if (oVar != null) {
                    oVar.J(!z);
                    this.xq = 2;
                    return;
                }
                return;
            }
            if (this.xr || (qVar = this.xn) == null) {
                return;
            }
            qVar.iX();
            this.xq = 1;
            this.xr = true;
        }
    }

    private com.kwad.components.core.webview.tachikoma.f.g dn() {
        if (this.kn == null) {
            this.kn = new com.kwad.components.core.webview.tachikoma.f.g() { // from class: com.kwad.components.ad.reward.presenter.r.2
                @Override // com.kwad.components.core.webview.tachikoma.f.b
                public final void x(String str) {
                    r.this.jb();
                }
            };
        }
        return this.kn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jb() {
        if (this.xt) {
            q qVar = new q(this);
            this.xn = qVar;
            a((Presenter) qVar, true);
        }
        if (this.xs) {
            o oVar = new o(this);
            this.xo = oVar;
            a((Presenter) oVar, true);
        }
    }

    private boolean jc() {
        return this.xl;
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.uj.mAdTemplate);
        if (com.kwad.sdk.core.response.helper.a.bQ(adInfoEO)) {
            if (this.uj.sP) {
                com.kwad.components.core.webview.tachikoma.e.c.zG().a(dn());
            } else {
                by.runOnUiThreadDelay(new bi() { // from class: com.kwad.components.ad.reward.presenter.r.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        r.this.jb();
                    }
                }, 100L);
            }
        } else if (!com.kwad.sdk.core.response.helper.a.bU(adInfoEO)) {
            com.kwad.components.core.p.a.vL().be(this.uj.mAdTemplate);
        }
        this.uj.b(this);
        com.kwad.components.core.playable.a aVar = this.uj.sA;
        if (aVar != null) {
            aVar.a(this);
        }
        boolean zHS = com.kwad.components.ad.reward.a.b.hS();
        this.wW = com.kwad.components.ad.reward.a.b.hR();
        if (zHS) {
            a aVar2 = new a(this, (byte) 0);
            this.xm = aVar2;
            com.kwad.components.ad.reward.m.e eVar = this.uj.sz;
            if (eVar != null) {
                eVar.a(aVar2);
            }
        }
        com.kwad.components.ad.reward.a.gs().a(this);
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final void dd() {
        RewardActionBarControl.ShowActionBarResult showActionBarResultJD = this.uj.sB.jD();
        if (showActionBarResultJD != null) {
            showActionBarResultJD.equals(RewardActionBarControl.ShowActionBarResult.SHOW_NATIVE_PLAYABLE_PORTRAIT);
        }
        if (this.xp == null || this.uj.hc()) {
            return;
        }
        if (jc()) {
            this.xp.e(PlayableSource.PLAY_FINISHED_NORMAL);
        } else {
            this.xp.iW();
        }
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dq() {
        this.uj.A(false);
        a aVar = this.xm;
        if (aVar == null || this.xq != 2) {
            return;
        }
        b(aVar.videoDuration, this.xm.xv, true);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void dr() {
    }

    @Override // com.kwad.components.ad.reward.e.g
    public final int getPriority() {
        return 0;
    }

    public final boolean onBackPressed() {
        boolean zHg = this.uj.hg();
        if (!this.uj.gS() || zHg) {
            return false;
        }
        com.kwad.components.ad.reward.a.gs().gt();
        this.uj.A(false);
        return true;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        com.kwad.components.ad.reward.m.e eVar;
        super.onUnbind();
        this.uj.c(this);
        com.kwad.components.core.playable.a aVar = this.uj.sA;
        if (aVar != null) {
            aVar.b(this);
        }
        a aVar2 = this.xm;
        if (aVar2 != null && (eVar = this.uj.sz) != null) {
            eVar.b(aVar2);
        }
        com.kwad.components.ad.reward.a.gs().b(this);
        com.kwad.components.core.webview.tachikoma.e.c.zG().b(this.kn);
    }

    @Override // com.kwad.components.core.webview.jshandler.as.b
    public final void a(as.a aVar) {
        a aVar2;
        boolean zIsSuccess = aVar.isSuccess();
        this.xl = zIsSuccess;
        if (!zIsSuccess || (aVar2 = this.xm) == null) {
            return;
        }
        b(aVar2.videoDuration, this.xm.xv, false);
    }

    @Override // com.kwad.components.ad.reward.e.j
    public final void a(PlayableSource playableSource, @Nullable com.kwad.components.ad.reward.e.n nVar) {
        o oVar;
        q qVar;
        this.uj.A(true);
        int i = this.xq;
        if (i == 1 && (qVar = this.xn) != null) {
            qVar.iY();
        } else {
            if (i != 2 || (oVar = this.xo) == null) {
                return;
            }
            oVar.hide();
        }
    }

    public r(AdTemplate adTemplate) {
        this(adTemplate, true, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(com.kwad.components.ad.reward.e.g gVar) {
        return getPriority() - gVar.getPriority();
    }
}
