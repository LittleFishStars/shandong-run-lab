package com.kwad.components.ad.splashscreen.presenter.playcard;

import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.g;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.helper.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends com.kwad.components.ad.splashscreen.presenter.a.c implements g, com.kwad.sdk.core.j.c {
    f JZ = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.2
        @Override // com.kwad.components.ad.splashscreen.f
        public final void lY() {
            d.this.dm.setVisibility(8);
            if (d.this.f15075do != null) {
                d.this.f15075do.yz();
                d.this.f15075do.yA();
            }
        }
    };
    private m KD;
    private FrameLayout dm;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private az f15075do;

    @NonNull
    private m nM() {
        m mVar = new m();
        this.KD = mVar;
        return mVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        if (this.HC.bY) {
            return;
        }
        az azVar = this.f15075do;
        if (azVar != null) {
            azVar.yx();
            this.f15075do.yy();
        }
        this.dm.setVisibility(0);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void aw(int i) {
        m mVar = this.KD;
        if (mVar != null) {
            mVar.ci(i);
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        h hVar = this.HC;
        com.kwad.components.ad.splashscreen.monitor.b.b(hVar.mAdTemplate, hVar.GO);
        this.HC.GP.a(this);
        this.HC.a(this);
        this.HC.a(this.JZ);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        az azVar;
        if (this.HC.bY || (azVar = this.f15075do) == null) {
            return;
        }
        azVar.yC();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        az azVar;
        if (this.HC.bY || (azVar = this.f15075do) == null) {
            return;
        }
        azVar.yB();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.dm;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_splash";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.em(this.HC.mAdTemplate);
    }

    @Override // com.kwad.components.ad.splashscreen.g
    public final void mc() {
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c
    public final int nL() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.HC;
        return (int) (com.kwad.sdk.core.response.helper.b.dT(e.eO(hVar.mAdTemplate)) - (jElapsedRealtime - hVar.GW));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dm = (FrameLayout) findViewById(R.id.splash_tk_play_card_view);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        az azVar = this.f15075do;
        if (azVar != null) {
            azVar.yz();
            this.f15075do.yA();
        }
        super.onUnbind();
        this.HC.GP.b(this);
        this.HC.b(this.JZ);
        this.HC.b(this);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.f15075do;
        if (azVar != null) {
            azVar.yz();
            this.f15075do.yA();
        }
        this.dm.setVisibility(8);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.HC.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.HC.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.f15075do = azVar;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(a(bVar));
        tVar.c(nM());
    }

    @NonNull
    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, this.HC.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.1
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    d.this.HC.mRootContainer.post(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.playcard.d.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.this.HC.ab();
                        }
                    });
                }
            }
        });
    }
}
