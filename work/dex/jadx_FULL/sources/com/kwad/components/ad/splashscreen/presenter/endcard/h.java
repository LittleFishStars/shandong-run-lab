package com.kwad.components.ad.splashscreen.presenter.endcard;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bx;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class h extends com.kwad.components.ad.splashscreen.presenter.a.c implements com.kwad.sdk.core.j.c {
    private FrameLayout dm;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private az f15074do;

    private void az(int i) {
        com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
        bx bxVar = this.HC.mTimerHelper;
        if (bxVar != null) {
            c1273a.duration = bxVar.getTime();
        }
        com.kwad.sdk.core.adlog.c.b bVarB = new com.kwad.sdk.core.adlog.c.b().el(6).b(c1273a);
        if (i == 2) {
            bVarB.ed(14);
        } else {
            bVarB.ed(1);
        }
        com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, bVarB, (JSONObject) null);
    }

    private void nD() {
        try {
            this.HC.mRootContainer.findViewById(R.id.splash_play_card_view).setVisibility(8);
        } catch (NullPointerException e) {
            com.kwad.sdk.core.d.c.printStackTrace(e);
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        az azVar = this.f15074do;
        if (azVar != null) {
            azVar.yx();
            this.f15074do.yy();
        }
        nD();
        this.dm.setVisibility(0);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        this.HC.GP.a(this);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        az azVar = this.f15074do;
        if (azVar != null) {
            azVar.yC();
        }
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        az azVar = this.f15074do;
        if (azVar != null) {
            azVar.yB();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.dm;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash_end_card";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.en(this.HC.mAdTemplate);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dm = (FrameLayout) findViewById(R.id.splash_end_card_view);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        az azVar = this.f15074do;
        if (azVar != null) {
            azVar.yz();
            this.f15074do.yA();
        }
        super.onUnbind();
        this.HC.GP.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.f15074do;
        if (azVar != null) {
            azVar.yz();
            this.f15074do.yA();
        }
        nD();
        this.dm.setVisibility(8);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        super.a(webCloseStatus);
        az(webCloseStatus.closeType);
        if (webCloseStatus.closeType == 2) {
            this.HC.ms();
        } else {
            com.kwad.components.ad.splashscreen.monitor.a.mt().ao(this.HC.mAdTemplate);
            this.HC.mo();
        }
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.HC.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.HC.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.f15074do = azVar;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(a(bVar));
    }

    @NonNull
    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, this.HC.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.h.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    h.this.HC.mRootContainer.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.endcard.h.1.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            h.this.HC.ab();
                        }
                    });
                }
            }
        });
    }
}
