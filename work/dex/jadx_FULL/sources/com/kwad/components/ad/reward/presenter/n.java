package com.kwad.components.ad.reward.presenter;

import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class n extends b {
    private com.kwad.components.core.video.m kf = new com.kwad.components.core.video.m() { // from class: com.kwad.components.ad.reward.presenter.n.2
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            try {
                super.onMediaPlayCompleted();
                n.this.iT();
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    };
    private final com.kwad.components.ad.reward.e.m kg = new com.kwad.components.ad.reward.e.m() { // from class: com.kwad.components.ad.reward.presenter.n.3
        @Override // com.kwad.components.ad.reward.e.m
        public final void a(com.kwad.components.core.webview.tachikoma.c.r rVar) {
            if (rVar == null || rVar.type != 1) {
                return;
            }
            n.this.uj.sz.release();
            n.this.uj.gW();
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void iT() {
        com.kwad.components.ad.reward.g gVar = this.uj;
        if (com.kwad.components.core.t.n.e(gVar.mAdTemplate, gVar.sT)) {
            com.kwad.components.ad.reward.g gVar2 = this.uj;
            com.kwad.components.core.t.n.i(gVar2.mContext, gVar2.mAdTemplate);
        }
        if (!i.z(this.uj)) {
            com.kwad.components.ad.reward.g gVar3 = this.uj;
            if (!com.kwad.components.core.t.n.e(gVar3.mAdTemplate, gVar3.sT)) {
                this.uj.gW();
                return;
            }
        }
        by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.presenter.n.1
            @Override // java.lang.Runnable
            public final void run() {
                n.this.uj.gW();
            }
        }, 200L);
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.uj.sz.a(this.kf);
        com.kwad.components.ad.reward.c.gz().a(this.kg);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.uj.sz.b(this.kf);
        com.kwad.components.ad.reward.c.gz().b(this.kg);
    }
}
