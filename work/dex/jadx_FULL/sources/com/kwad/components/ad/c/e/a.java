package com.kwad.components.ad.c.e;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.convert.d;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends c {
    private boolean cA;
    private FrameLayout dm;
    private boolean dn;

    /* JADX INFO: renamed from: do, reason: not valid java name */
    private az f15068do;
    private o dp;
    private Context mContext;

    public a(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        com.kwad.components.ad.c.b bVar = this.cS;
        if (bVar.bY) {
            return;
        }
        try {
            if (bVar.bU > 0) {
                d.b(e.eI(bVar.mAdTemplate), 2, SystemClock.elapsedRealtime() - this.cS.bU);
            }
            com.kwad.components.ad.c.c.c.a(this.cS.mAdTemplate, SystemClock.elapsedRealtime() - this.cS.bU, 2, 2, false);
            com.kwad.components.ad.c.c.c.a(this.cS.mAdTemplate, 2, 2);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        az azVar = this.f15068do;
        if (azVar != null) {
            azVar.yB();
            this.f15068do.yx();
            this.f15068do.yy();
        }
        this.dm.setVisibility(0);
    }

    @Override // com.kwad.components.ad.c.e.c, com.kwad.components.ad.c.d.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
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
        return com.kwad.sdk.core.response.helper.b.cQ(this.cS.mAdTemplate).bannerTKInfo.templateId;
    }

    @Override // com.kwad.components.ad.c.d.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.banner_full_tk_card_view);
        this.dm = frameLayout;
        b((ViewGroup) frameLayout.getParent());
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onDestroy() {
        super.onDestroy();
    }

    @Override // com.kwad.components.ad.c.e.c, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        az azVar = this.f15068do;
        if (azVar != null) {
            azVar.yz();
            this.f15068do.yA();
        }
        super.onUnbind();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z) {
        if (!z) {
            com.kwad.components.core.t.a.aO(this.mContext).bd(false);
            return false;
        }
        if (com.kwad.sdk.core.config.e.Kh()) {
            if (!this.cA) {
                this.cA = com.kwad.components.core.t.a.aO(this.mContext).bd(true);
            }
            return this.cA;
        }
        if (com.kwad.components.core.t.a.aO(this.mContext).wE()) {
            return !com.kwad.components.core.t.a.aO(this.mContext).wD();
        }
        return com.kwad.components.core.t.a.aO(this.mContext).bd(false);
    }

    private void b(ViewGroup viewGroup) {
        if (com.kwad.sdk.core.config.e.Kg() || com.kwad.sdk.core.config.e.Kf() < 0.0f) {
            return;
        }
        com.kwad.components.core.widget.a aVar = new com.kwad.components.core.widget.a(viewGroup.getContext(), viewGroup);
        viewGroup.addView(aVar);
        aVar.setViewCallback(new com.kwad.components.core.widget.a.InterfaceC1245a() { // from class: com.kwad.components.ad.c.e.a.1
            @Override // com.kwad.components.core.widget.a.InterfaceC1245a
            public final void aD() {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewFirstInVisible");
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC1245a
            public final void ae() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC1245a
            public final void af() {
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC1245a
            public final void b(View view) {
                com.kwad.sdk.core.d.c.e("BannerFullTKCardPresenter ", "onViewVisible");
            }

            @Override // com.kwad.components.core.widget.a.InterfaceC1245a
            public final void onWindowFocusChanged(boolean z) {
                if (a.this.f15068do != null) {
                    if (!z) {
                        a aVar2 = a.this;
                        aVar2.f(aVar2.cS.mAdTemplate.mIsAudioEnable);
                        a.this.f15068do.yC();
                        return;
                    }
                    a.this.f15068do.yB();
                    n nVar = new n();
                    if (a.this.dn) {
                        a aVar3 = a.this;
                        nVar.aut = !aVar3.f(aVar3.cS.mAdTemplate.mIsAudioEnable);
                    } else {
                        nVar.aut = false;
                    }
                    a.this.dp.c(nVar);
                }
            }
        });
        aVar.zM();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        az azVar = this.f15068do;
        if (azVar != null) {
            azVar.yz();
            this.f15068do.yA();
        }
        this.dm.setVisibility(8);
        com.kwad.components.ad.c.b bVar = this.cS;
        bVar.bY = true;
        bVar.bR.ad();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        aVar.width = com.kwad.sdk.c.a.a.px2dip(getContext(), this.cS.bQ.getWidth());
        aVar.height = com.kwad.sdk.c.a.a.px2dip(getContext(), this.cS.bQ.getHeight());
    }

    @Override // com.kwad.components.ad.c.e.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.f15068do = azVar;
    }

    @Override // com.kwad.components.ad.c.e.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        tVar.c(a(bVar));
    }

    @NonNull
    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, (com.kwad.components.core.e.d.d) null, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.c.e.a.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    a.this.cS.bQ.post(new bi() { // from class: com.kwad.components.ad.c.e.a.2.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            a.this.cS.ab();
                            com.kwad.components.ad.c.c.c.d(a.this.cS.mAdTemplate, 1, com.kwad.components.ad.c.b.a(a.this.cS.mAdTemplate) ? 2 : 1);
                        }
                    });
                }
            }
        });
    }

    @Override // com.kwad.components.ad.c.e.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.f15068do.yA();
        this.cS.bQ.removeAllViews();
        onDestroy();
        this.cS.ac();
        AdTemplate adTemplate = this.cS.mAdTemplate;
        com.kwad.components.ad.c.c.c.f(adTemplate, 1, com.kwad.components.ad.c.b.a(adTemplate) ? 2 : 1);
    }

    @Override // com.kwad.components.ad.c.e.c, com.kwad.components.core.webview.tachikoma.j
    public final void a(o oVar) {
        this.dp = oVar;
        oVar.a(new o.a() { // from class: com.kwad.components.ad.c.e.a.3
            @Override // com.kwad.components.core.webview.tachikoma.b.o.a
            public final boolean isMuted() {
                boolean z;
                try {
                    if (com.kwad.sdk.core.config.e.Kh() || !com.kwad.components.core.t.a.aO(a.this.cS.mContext).wD()) {
                        if (!(a.this.cS.bS instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) a.this.cS.bS).getVideoSoundValue() == 0) {
                            z = !com.kwad.sdk.core.response.helper.a.ce(e.eO(a.this.cS.mAdTemplate));
                        } else {
                            z = !a.this.cS.bS.isVideoSoundEnable();
                        }
                    }
                    if (a.this.cS.mAdTemplate != null) {
                        a.this.cS.mAdTemplate.mIsAudioEnable = z ? false : true;
                    }
                    a.this.dn = z;
                    return z;
                } catch (Throwable unused) {
                    return true;
                }
            }
        });
    }
}
