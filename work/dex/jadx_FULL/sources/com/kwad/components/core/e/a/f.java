package com.kwad.components.core.e.a;

import android.app.Activity;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends Presenter implements j, com.kwad.sdk.core.j.c {
    private com.kwad.components.core.widget.a.c PZ;
    private a Qj;
    private az fk;
    private i go;
    private AdTemplate mAdTemplate;

    private void am(boolean z) {
        if (!z) {
            this.Qj.ac();
        }
        by.runOnUiThread(new bi() { // from class: com.kwad.components.core.e.a.f.2
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                f.this.Qj.Qa.pt();
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(com.kwad.components.core.webview.jshandler.a.C1235a c1235a) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(p pVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(n nVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onTkLoadSuccess");
        this.Qj.aa();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aF() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aG() {
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        a aVar = (a) SB();
        this.Qj = aVar;
        this.mAdTemplate = aVar.mAdTemplate;
        this.PZ = aVar.PZ;
        this.go = new i(getContext()) { // from class: com.kwad.components.core.e.a.f.1
            @Override // com.kwad.components.core.webview.tachikoma.i
            public final boolean pz() {
                return true;
            }
        };
        this.go.a((Activity) null, com.kwad.sdk.core.response.helper.c.ez(this.mAdTemplate), this);
        this.PZ.a(this);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onPageInvisible");
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yC();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onPageVisible");
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yB();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void g(AdTemplate adTemplate) {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.Qj.PY;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_installed_activate";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.cQ(this.mAdTemplate).installedActivateInfo.templateId;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final com.kwad.sdk.widget.g getTouchCoordsView() {
        return this.Qj.PY;
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.go.kV();
        this.PZ.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onTkLoadFailed");
        am(true);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
        com.kwad.sdk.core.d.c.d("InstalledActivatePresenter", "onAdClicked");
        am(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        float screenHeight = com.kwad.sdk.c.a.a.getScreenHeight(getContext());
        aVar.width = (int) ((com.kwad.sdk.c.a.a.getScreenWidth(getContext()) / fBB) + 0.5f);
        aVar.height = (int) ((screenHeight / fBB) + 0.5f);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        am(false);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        this.fk = azVar;
        this.Qj.fk = azVar;
    }
}
