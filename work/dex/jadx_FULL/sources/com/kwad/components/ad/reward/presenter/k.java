package com.kwad.components.ad.reward.presenter;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class k extends b {
    private final AdLiveCallerContextListener wG = new AdLiveCallerContextListener() { // from class: com.kwad.components.ad.reward.presenter.k.1
        @Override // com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener
        public final boolean isCloseDialogShowing() {
            return com.kwad.components.ad.reward.g.b(k.this.uj);
        }
    };
    private final com.kwad.components.core.n.a.a wH = new com.kwad.components.core.n.a.b() { // from class: com.kwad.components.ad.reward.presenter.k.2
        @Override // com.kwad.components.core.n.a.b, com.kwad.components.core.n.a.a
        public final void c(com.kwad.components.core.proxy.f fVar) {
            super.c(fVar);
            if (k.this.uj.sz.ls()) {
                k.this.uj.sz.lt().onResume();
                if (com.kwad.components.core.t.a.aO(k.this.uj.mContext).wD()) {
                    k.this.uj.e(false, false);
                }
            }
        }

        @Override // com.kwad.components.core.n.a.b, com.kwad.components.core.n.a.a
        public final void d(com.kwad.components.core.proxy.f fVar) {
            super.d(fVar);
            if (k.this.uj.sz.ls()) {
                k.this.uj.sz.lt().onPause();
            }
        }
    };

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        if (this.uj.sz.ls()) {
            this.uj.sz.lt().registerAdLiveCallerContextListener(this.wG);
            this.uj.abk.add(this.wH);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
        if (this.uj.sz.ls()) {
            this.uj.sz.lt().unRegisterAdLiveCallerContextListener(this.wG);
            this.uj.abk.remove(this.wH);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
    }
}
