package com.kwad.components.ad.reward.presenter.f;

import com.kwad.components.core.webview.jshandler.az;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class e implements com.kwad.components.ad.reward.g.a {
    private boolean AX;
    private boolean AY;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private az f15071do;

    private void ku() {
        az azVar = this.f15071do;
        if (azVar == null || !this.AY) {
            return;
        }
        if (this.AX) {
            azVar.yB();
            return;
        }
        azVar.yx();
        this.f15071do.yy();
        this.AX = true;
    }

    public final void A(com.kwad.components.ad.reward.g gVar) {
        gVar.a(this);
    }

    public final void B(com.kwad.components.ad.reward.g gVar) {
        az azVar = this.f15071do;
        if (azVar != null) {
            azVar.yz();
            this.f15071do.yA();
        }
        gVar.b(this);
    }

    public final void aE() {
        ku();
    }

    public final void b(az azVar) {
        this.f15071do = azVar;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hp() {
        this.AY = true;
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hq() {
        this.AY = true;
        ku();
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hr() {
        this.AY = false;
        az azVar = this.f15071do;
        if (azVar != null) {
            azVar.yC();
        }
    }

    @Override // com.kwad.components.ad.reward.g.a
    public final void hs() {
        this.AY = false;
    }

    public final void kv() {
        az azVar = this.f15071do;
        if (azVar != null) {
            azVar.yz();
            this.f15071do.yA();
        }
    }
}
