package com.kwad.components.ad.splashscreen.presenter.a;

import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.f;
import com.kwad.components.ad.splashscreen.h;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.j;
import com.kwad.components.core.webview.jshandler.p;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.m;
import com.kwad.components.core.webview.tachikoma.b.u;
import com.kwad.sdk.R;
import com.kwad.sdk.components.t;
import com.kwad.sdk.utils.bi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends c implements com.kwad.sdk.core.j.c {
    private m KD;
    private FrameLayout dm;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private az f15073do;
    private boolean KG = false;
    f JZ = new f() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.4
        @Override // com.kwad.components.ad.splashscreen.f
        public final void lY() {
            a.this.dm.postDelayed(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.4.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.dm.setVisibility(8);
                }
            }, 500L);
            if (a.this.f15073do != null) {
                a.this.f15073do.yz();
                a.this.f15073do.yA();
            }
        }
    };

    @NonNull
    private m nM() {
        m mVar = new m();
        this.KD = mVar;
        return mVar;
    }

    private void nN() {
        com.kwad.components.ad.splashscreen.d.a aVar = this.HC.GN;
        if (aVar != null) {
            aVar.nQ();
        }
    }

    @NonNull
    private u nO() {
        u uVar = new u();
        uVar.a(new u.a() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3
            @Override // com.kwad.components.core.webview.tachikoma.b.u.a
            public final void a(final u.b bVar) {
                int i = bVar.status;
                if (i == 1) {
                    a.this.HC.mRootContainer.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            if (com.kwad.components.core.e.c.b.pG()) {
                                a.this.HC.mRootContainer.postDelayed(this, 1000L);
                            } else {
                                a.this.HC.mm();
                            }
                        }
                    });
                    return;
                }
                if (i == 2) {
                    a.this.HC.mRootContainer.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.2
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            com.kwad.components.ad.splashscreen.monitor.a.mt().ao(a.this.HC.mAdTemplate);
                            a.this.HC.mo();
                        }
                    });
                } else if (i == 3) {
                    a.this.HC.mRootContainer.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.3
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            a.this.HC.md();
                        }
                    });
                } else if (i == 4) {
                    a.this.HC.mRootContainer.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.3.4
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            h hVar = a.this.HC;
                            u.b bVar2 = bVar;
                            hVar.c(bVar2.errorCode, bVar2.errorMsg);
                        }
                    });
                }
            }
        });
        return uVar;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        az azVar;
        if (this.HC.bY) {
            return;
        }
        az azVar2 = this.f15073do;
        if (azVar2 != null) {
            azVar2.yx();
            this.f15073do.yy();
        }
        if (this.KG && (azVar = this.f15073do) != null) {
            azVar.yB();
        }
        this.dm.setVisibility(0);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        h hVar = this.HC;
        com.kwad.components.ad.splashscreen.monitor.b.b(hVar.mAdTemplate, hVar.GO);
        this.HC.GP.a(this);
        this.HC.a(this.JZ);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        az azVar;
        if (this.HC.bY || (azVar = this.f15073do) == null) {
            return;
        }
        azVar.yC();
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        if (this.HC.bY) {
            return;
        }
        az azVar = this.f15073do;
        if (azVar != null) {
            azVar.yB();
        } else {
            this.KG = true;
        }
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
        return com.kwad.sdk.core.response.helper.b.cQ(this.HC.mAdTemplate).splashPlayCardTKInfo.templateId;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c
    public final int nL() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        h hVar = this.HC;
        return (int) (com.kwad.sdk.core.response.helper.b.dX(hVar.mAdTemplate) - (jElapsedRealtime - hVar.GW));
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.dm = (FrameLayout) findViewById(R.id.splash_full_tk_play_card_view);
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        az azVar = this.f15073do;
        if (azVar != null) {
            azVar.yz();
            this.f15073do.yA();
        }
        super.onUnbind();
        this.HC.GP.b(this);
        this.HC.b(this.JZ);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.f15073do;
        if (azVar != null) {
            azVar.yz();
            this.f15073do.yA();
        }
        this.dm.setVisibility(8);
        nN();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.HC.mRootContainer.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.HC.mRootContainer.getHeight());
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.f15073do = azVar;
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.a.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(a(bVar));
        tVar.c(nM());
        tVar.c(nO());
        tVar.c(new j(new p() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.1
            @Override // com.kwad.components.core.webview.jshandler.p
            public final void a(j jVar, String str) {
                if (TextUtils.equals(str, "getSplashShowStartTime")) {
                    jVar.V(a.this.HC.mAdTemplate.showTime);
                }
            }
        }));
    }

    @NonNull
    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, this.HC.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.HC.mRootContainer.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.a.a.2.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            a.this.HC.ab();
                        }
                    });
                }
            }
        });
    }
}
