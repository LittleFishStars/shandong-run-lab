package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.sdk.components.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class a extends d {
    private o Az;

    @Override // com.kwad.components.ad.reward.presenter.f.d
    public final boolean ki() {
        return true;
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.Az = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.reward.presenter.f.a.1
            @Override // com.kwad.components.core.webview.tachikoma.b.o.a
            public final boolean isMuted() {
                return !a.this.uj.mVideoPlayConfig.isVideoSoundEnable() || (!com.kwad.sdk.core.config.e.hO() && com.kwad.components.core.t.a.aO(a.this.getContext()).wD());
            }
        });
    }

    @Override // com.kwad.components.ad.reward.presenter.f.d, com.kwad.components.core.webview.tachikoma.j
    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(new x() { // from class: com.kwad.components.ad.reward.presenter.f.a.2
            @Override // com.kwad.components.core.webview.jshandler.x
            public final void a(y yVar) {
                super.a(yVar);
                long jZw = yVar.zw();
                a.this.uj.sy.onVideoPlayError(yVar.errorCode, (int) jZw);
                com.kwad.components.ad.reward.monitor.d.a(a.this.uj.sO, a.this.uj.mAdTemplate, a.this.uj.tn, yVar.errorCode, jZw);
                com.kwad.components.ad.reward.monitor.c.c(a.this.uj.sO, a.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void b(y yVar) {
                super.b(yVar);
                a.this.uj.sy.onVideoPlayStart();
                com.kwad.components.ad.reward.monitor.d.b(a.this.uj.sO, a.this.uj.mAdTemplate, a.this.uj.mPageEnterTime);
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void c(y yVar) {
                super.c(yVar);
                a.this.uj.sy.onVideoPlayEnd();
                a.this.uj.mAdTemplate.setmCurPlayTime(-1L);
                com.kwad.components.ad.reward.presenter.f.u(a.this.uj);
                if (yVar.zs()) {
                    com.kwad.components.ad.reward.g unused = a.this.uj;
                    com.kwad.components.ad.reward.g.a(a.this.uj.sG, new com.kwad.sdk.g.a<com.kwad.components.ad.reward.k.a>() { // from class: com.kwad.components.ad.reward.presenter.f.a.2.1
                        /* JADX INFO: Access modifiers changed from: private */
                        @Override // com.kwad.sdk.g.a
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public void accept(com.kwad.components.ad.reward.k.a aVar) {
                            com.kwad.components.ad.reward.g unused2 = a.this.uj;
                            aVar.kg();
                        }
                    });
                }
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void d(y yVar) {
                super.d(yVar);
                a.this.uj.mAdTemplate.setmCurPlayTime(yVar.rq);
            }
        });
    }

    public void a(ae.a aVar) {
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / fBB) + 0.5f);
        aVar.height = (int) ((screenHeight / fBB) + 0.5f);
    }
}
