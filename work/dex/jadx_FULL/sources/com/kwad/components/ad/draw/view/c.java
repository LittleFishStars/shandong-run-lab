package com.kwad.components.ad.draw.view;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.json.annotation.KsJson;
import com.kwad.components.ad.draw.a.d;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsDrawAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.g;
import com.kwad.sdk.wrapper.m;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends KSFrameLayout {
    private KsDrawAd.AdInteractionListener dB;
    private boolean dF;
    private com.kwad.sdk.core.j.b dH;
    private boolean dR;
    private boolean fA;
    private final com.kwad.sdk.core.j.c fF;
    private long fX;
    private boolean fY;
    private boolean fZ;
    private com.kwad.components.core.widget.a.c fx;
    private boolean ga;
    private i go;
    private KSFrameLayout gp;
    private com.kwad.components.ad.draw.c.a gq;
    private boolean gr;
    private int gs;
    private boolean gt;
    private AdInfo mAdInfo;

    @NonNull
    private AdResultData mAdResultData;

    @NonNull
    private AdTemplate mAdTemplate;
    private Context mContext;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public boolean gv;
        public int status;
    }

    public c(@NonNull Context context) {
        super(context);
        this.fF = new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.draw.view.c.2
            @Override // com.kwad.sdk.core.j.c
            public final void bA() {
                c.this.setLifeStatue("pageInvisiable");
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                if (!c.this.mAdTemplate.mPvReported && c.this.dB != null && !c.this.mAdTemplate.mHasAdShow) {
                    c.this.dB.onAdShow();
                    d.g(c.this.mAdTemplate, 2, 2);
                    d.a(c.this.mAdTemplate, 2);
                    c.this.mAdTemplate.mHasAdShow = true;
                }
                if (!c.this.gt) {
                    c.this.setLifeStatue("showStart");
                    c.this.setLifeStatue("showEnd");
                    c.this.gt = true;
                }
                c.this.setLifeStatue("pageVisiable");
            }
        };
        B(context);
    }

    private void B(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_draw_tk_layout, this);
        this.gp = (KSFrameLayout) findViewById(R.id.ksad_draw_tk_container);
        int iA = e.a(com.kwad.sdk.core.config.c.aPx);
        this.go = new i(context, iA, iA);
        final WeakReference weakReference = new WeakReference(m.getActivityFromContext(context));
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.draw.view.c.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || !activity2.equals(activity)) {
                    return;
                }
                if (c.this.go != null) {
                    c.this.setLifeStatue("hideStart");
                    c.this.setLifeStatue("hideEnd");
                    c.this.gt = false;
                    c.this.go.kV();
                }
                com.kwad.sdk.core.c.b.LW();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    private void bR() {
        this.fx.a(this.dH);
        this.fx.a(this.fF);
        this.fx.Aa();
        if (this.go != null) {
            this.fX = SystemClock.elapsedRealtime();
            com.kwad.components.ad.draw.a.c.h(this.mAdTemplate);
            this.go.a(m.getActivityFromContext(this.mContext), this.mAdResultData, new j() { // from class: com.kwad.components.ad.draw.view.c.3
                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(az azVar) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(TKRenderFailReason tKRenderFailReason) {
                    if (c.this.gq != null) {
                        c.this.gq.aO();
                    }
                    c.this.gp.setVisibility(8);
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
                public final void a(WebCloseStatus webCloseStatus) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void aE() {
                    if (c.this.gq != null) {
                        c.this.gq.aN();
                    }
                    c.this.gp.setVisibility(0);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void aF() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void aG() {
                    c.this.bS();
                    c.this.bT();
                    c cVar = c.this;
                    cVar.L(cVar.gs);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void g(AdTemplate adTemplate) {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final String getRegisterViewKey() {
                    return "ksad-draw-card";
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final FrameLayout getTKContainer() {
                    return c.this.gp;
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final String getTKReaderScene() {
                    return "tk_draw_card";
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final String getTkTemplateId() {
                    return com.kwad.sdk.core.response.helper.b.ex(c.this.mAdTemplate);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final g getTouchCoordsView() {
                    return null;
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
                    if (c.this.dB != null) {
                        c.this.dB.onAdClicked();
                    }
                    if (c.this.dR) {
                        return;
                    }
                    c.b(c.this, true);
                    d.h(c.this.mAdTemplate, 2, 2);
                    d.b(c.this.mAdTemplate, 2);
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(ae.a aVar) {
                    aVar.width = com.kwad.sdk.c.a.a.px2dip(c.this.getContext(), c.this.gp.getWidth());
                    aVar.height = com.kwad.sdk.c.a.a.px2dip(c.this.getContext(), c.this.gp.getHeight());
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(com.kwad.components.core.webview.jshandler.a.C1235a c1235a) {
                    if (c.this.dB != null) {
                        String str = c1235a.aps;
                        str.hashCode();
                        if (str.equals("adShowCallback")) {
                            c.this.dB.onAdShow();
                            if (c.this.mAdTemplate == null || c.this.mAdTemplate.mHasAdShow) {
                                return;
                            }
                            d.g(c.this.mAdTemplate, 2, 2);
                            d.a(c.this.mAdTemplate, 2);
                            c.this.mAdTemplate.mHasAdShow = true;
                            return;
                        }
                        if (str.equals("adClickCallback")) {
                            c.this.dB.onAdClicked();
                            if (c.this.dR) {
                                return;
                            }
                            c.b(c.this, true);
                            d.h(c.this.mAdTemplate, 2, 2);
                            d.b(c.this.mAdTemplate, 2);
                        }
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bS() {
        i iVar = this.go;
        if (iVar != null) {
            iVar.a("setVideoPlayStatusCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.g() { // from class: com.kwad.components.ad.draw.view.c.4
                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void a(y yVar) {
                    if (c.this.dB != null) {
                        c.this.dB.onVideoPlayError();
                        com.kwad.components.ad.draw.a.c.b(c.this.mAdTemplate, SystemClock.elapsedRealtime() - c.this.fX, "video play error");
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bV() {
                    if (c.this.dB != null) {
                        c.this.dB.onVideoPlayResume();
                    }
                    if (c.this.fZ) {
                        return;
                    }
                    c.c(c.this, true);
                    com.kwad.components.ad.draw.a.c.j(c.this.mAdTemplate);
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bW() {
                    if (c.this.dB != null) {
                        c.this.dB.onVideoPlayPause();
                    }
                    if (c.this.fY) {
                        return;
                    }
                    c.d(c.this, true);
                    com.kwad.components.ad.draw.a.c.i(c.this.mAdTemplate);
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bX() {
                    if (c.this.dB != null) {
                        c.this.dB.onVideoPlayEnd();
                    }
                    if (c.this.ga) {
                        return;
                    }
                    c.e(c.this, true);
                    com.kwad.components.ad.draw.a.c.k(c.this.mAdTemplate);
                }

                @Override // com.kwad.components.core.webview.tachikoma.a.g
                public final void bY() {
                    if (c.this.dB != null) {
                        c.this.dB.onVideoPlayStart();
                        com.kwad.components.ad.draw.a.c.a(c.this.mAdTemplate, SystemClock.elapsedRealtime() - c.this.fX);
                        c.this.bT();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT() {
        if (this.go != null) {
            n nVar = new n();
            nVar.aut = bU();
            this.go.a("setVideoMuteStateListener", nVar.toJson().toString(), (com.kwad.sdk.components.m) null);
        }
    }

    private boolean bU() {
        return this.gr ? this.fA : com.kwad.sdk.core.response.helper.a.ci(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate));
    }

    public final void L(int i) {
        this.gs = i;
        if (this.go == null) {
            return;
        }
        a aVar = new a();
        aVar.status = this.gs;
        aVar.gv = this.dF;
        this.go.a("setVideoPlayerStatus", aVar.toJson().toString(), (com.kwad.sdk.components.m) null);
    }

    public final void bQ() {
        this.dF = true;
        L(0);
    }

    public final void setAdInteractionListener(KsDrawAd.AdInteractionListener adInteractionListener) {
        this.dB = adInteractionListener;
    }

    public final void setLifeStatue(String str) {
        i iVar = this.go;
        if (iVar != null) {
            iVar.a("setLifeStatus", str, (com.kwad.sdk.components.m) null);
        }
    }

    public final void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.dH = bVar;
    }

    public final void setTKLoadStateListener(com.kwad.components.ad.draw.c.a aVar) {
        this.gq = aVar;
    }

    public final void setVideoSound(boolean z) {
        this.fA = !z;
        this.gr = true;
        bT();
    }

    public static /* synthetic */ boolean b(c cVar, boolean z) {
        cVar.dR = true;
        return true;
    }

    public static /* synthetic */ boolean c(c cVar, boolean z) {
        cVar.fZ = true;
        return true;
    }

    public static /* synthetic */ boolean d(c cVar, boolean z) {
        cVar.fY = true;
        return true;
    }

    public static /* synthetic */ boolean e(c cVar, boolean z) {
        cVar.ga = true;
        return true;
    }

    public final void c(@NonNull AdResultData adResultData) {
        this.mAdResultData = adResultData;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        this.mAdTemplate = adTemplateR;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplateR);
        this.fx = new com.kwad.components.ad.draw.b(this.gp);
        bR();
    }
}
