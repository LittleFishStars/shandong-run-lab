package com.kwad.components.ad.fullscreen.c;

import com.kwad.components.core.video.m;
import com.kwad.components.core.webview.tachikoma.c.r;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends com.kwad.components.ad.reward.presenter.b {
    private m kf = new m() { // from class: com.kwad.components.ad.fullscreen.c.a.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayCompleted() {
            super.onMediaPlayCompleted();
            a.this.uj.gW();
        }
    };
    private final com.kwad.components.ad.reward.e.m kg = new com.kwad.components.ad.reward.e.m() { // from class: com.kwad.components.ad.fullscreen.c.a.2
        @Override // com.kwad.components.ad.reward.e.m
        public final void a(r rVar) {
            if (rVar == null || rVar.type != 1) {
                return;
            }
            a.this.uj.sz.release();
            a.this.uj.gW();
        }
    };

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
