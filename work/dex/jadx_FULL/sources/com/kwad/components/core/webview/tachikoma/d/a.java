package com.kwad.components.core.webview.tachikoma.d;

import androidx.annotation.Nullable;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class a extends Presenter implements j {
    protected b auC;
    protected i go;

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void a(u uVar) {
    }

    public void a(b bVar) {
    }

    public void a(WebCloseStatus webCloseStatus) {
        e eVar = this.auC.asx;
        if (eVar != null) {
            eVar.dismiss();
        }
    }

    public void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    public void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public void aF() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        b bVar = (b) SB();
        this.auC = bVar;
        a(bVar);
        if (this.go == null) {
            this.go = jk();
        }
        StyleTemplate styleTemplate = this.auC.akN;
        if (styleTemplate != null) {
            this.go.a(styleTemplate);
        }
        i iVar = this.go;
        b bVar2 = this.auC;
        iVar.a(bVar2.mActivity, bVar2.mAdResultData, this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public g getTouchCoordsView() {
        return this.auC.auD;
    }

    public i jk() {
        return new i(this.auC.Cj, getContext());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.go.kV();
        this.go = null;
    }
}
