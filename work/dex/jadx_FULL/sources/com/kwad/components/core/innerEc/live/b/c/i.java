package com.kwad.components.core.innerEc.live.b.c;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class i extends com.kwad.components.core.innerEc.live.b.a.a {
    private com.kwad.components.core.innerEc.live.config.b UF;
    private com.kwad.components.core.innerEc.live.end.a UG;
    private boolean WW;
    private final com.kwad.components.core.innerEc.live.end.c Wb = new com.kwad.components.core.innerEc.live.end.c() { // from class: com.kwad.components.core.innerEc.live.b.c.i.1
        @Override // com.kwad.components.core.innerEc.live.end.c
        public final void sg() {
        }
    };

    private void rE() {
        this.UF.rE();
    }

    private void sA() {
        if (this.WW) {
            return;
        }
        com.kwad.components.core.innerEc.live.end.a aVar = this.UG;
        if (aVar == null || !aVar.sD()) {
            this.WW = true;
            rE();
        }
    }

    @Override // com.kwad.components.core.innerEc.live.b.a.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.core.innerEc.live.b.a.b bVar = this.Ub;
        com.kwad.components.core.innerEc.live.config.b bVar2 = bVar.UF;
        this.UF = bVar2;
        bVar2.a(bVar);
        com.kwad.components.core.innerEc.live.end.a aVar = this.Ub.UG;
        this.UG = aVar;
        aVar.a(this.Wb);
        sA();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.UG.b(this.Wb);
    }
}
