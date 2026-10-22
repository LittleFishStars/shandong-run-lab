package com.kwad.components.ad.interstitial.f.a;

import android.app.Activity;
import android.app.Dialog;
import android.os.Vibrator;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.interstitial.f.c;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.bk;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.g;
import com.kwad.components.core.webview.tachikoma.b.n;
import com.kwad.components.core.webview.tachikoma.b.q;
import com.kwad.components.core.webview.tachikoma.c.l;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.components.core.webview.tachikoma.e;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.g.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.cb;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends a {
    private static long oe = 400;
    private FrameLayout dm;
    private d hu;
    private Vibrator hw;
    private az iY;

    @Nullable
    private com.kwad.components.ad.h.a.a.b od;
    private boolean og;
    private e oh;
    private boolean of = false;
    private final c.b nx = new c.b() { // from class: com.kwad.components.ad.interstitial.f.a.b.1
        @Override // com.kwad.components.ad.interstitial.f.c.b
        public final void c(long j, long j2) {
            com.kwad.components.ad.interstitial.report.a.eV().b(b.this.mN.mAdTemplate, j, j2);
            if (b.this.oh != null) {
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.auh = b.this.mN.mP ? 1 : 0;
                b.this.oh.b(aVar);
            }
        }
    };
    private com.kwad.sdk.core.j.c fF = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ad.interstitial.f.a.b.9
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bA() {
            if (b.this.iY != null) {
                b.this.iY.yC();
            }
            if (b.this.od != null) {
                b.this.od.gb();
            }
        }

        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bz() {
            if (b.this.iY != null && !b.this.of) {
                b.a(b.this, true);
                b.this.iY.yx();
                b.this.iY.yy();
            }
            if (b.this.iY != null) {
                b.this.iY.yB();
            }
            if (b.this.od != null) {
                b.this.od.gc();
            }
            if (!b.this.og) {
                b.this.mN.lx.getTimerHelper().startTiming();
            }
            if (b.this.og || b.this.mN.mR || b.this.mN.ls == null) {
                return;
            }
            b.this.mN.ls.onAdShow();
            com.kwad.components.ad.interstitial.report.c.eZ().c(b.this.mN.mAdTemplate, 3);
            b.b(b.this, true);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void cL() {
        if (getContext() != null) {
            this.hw = (Vibrator) getContext().getSystemService("vibrator");
        }
        float fDI = com.kwad.sdk.core.response.helper.b.dI(this.mN.mAdTemplate);
        boolean zDX = com.kwad.sdk.core.response.helper.b.dX(com.kwad.sdk.core.response.helper.e.eO(this.mN.mAdTemplate));
        boolean zDY = com.kwad.sdk.core.response.helper.b.dY(com.kwad.sdk.core.response.helper.e.eO(this.mN.mAdTemplate));
        if (this.hu == null) {
            d dVar = new d(zDX, fDI);
            this.hu = dVar;
            dVar.bG(zDY);
            this.hu.a(new com.kwad.sdk.core.g.b() { // from class: com.kwad.components.ad.interstitial.f.a.b.7
                @Override // com.kwad.sdk.core.g.b
                public final void a(double d) {
                    if (cb.r(b.this.getTKContainer(), 100)) {
                        b.this.d(d);
                    }
                    by.a(new bi() { // from class: com.kwad.components.ad.interstitial.f.a.b.7.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            b.this.hu.NJ();
                        }
                    }, null, 500L);
                }

                @Override // com.kwad.sdk.core.g.b
                public final void cj() {
                }
            });
        }
        this.hu.m(fDI);
        this.hu.cb(getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC() {
        c cVar = this.mN;
        if (cVar == null) {
            return;
        }
        com.kwad.components.ad.interstitial.d dVar = cVar.lx;
        if (dVar != null && a(dVar)) {
            this.mN.lx.dismiss();
        }
        try {
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.mN.ls;
            if (adInteractionListener != null) {
                adInteractionListener.onAdClosed();
            }
        } catch (Throwable th) {
            com.kwad.components.core.d.a.reportSdkCaughtException(th);
        }
    }

    private com.kwad.components.core.webview.tachikoma.c eK() {
        return new com.kwad.components.core.webview.tachikoma.c() { // from class: com.kwad.components.ad.interstitial.f.a.b.14
            @Override // com.kwad.components.core.webview.tachikoma.c, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.c cVar2 = new com.kwad.components.core.webview.tachikoma.c.c();
                cVar2.auj = com.kwad.components.ad.interstitial.d.a.dX();
                cVar.b(cVar2);
            }
        };
    }

    private e eL() {
        return new e() { // from class: com.kwad.components.ad.interstitial.f.a.b.15
            @Override // com.kwad.components.core.webview.tachikoma.e, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.webview.tachikoma.c.a aVar = new com.kwad.components.core.webview.tachikoma.c.a();
                aVar.auh = b.this.mN.mP ? 1 : 0;
                cVar.b(aVar);
            }
        };
    }

    private g eM() {
        l lVar = new l();
        lVar.auq = this.mN.nb;
        return new g(lVar);
    }

    private com.kwad.components.ad.h.a.a.a eN() {
        final com.kwad.components.ad.h.a.a.a aVar = new com.kwad.components.ad.h.a.a.a();
        this.mN.mW.add(new c.d() { // from class: com.kwad.components.ad.interstitial.f.a.b.16
            @Override // com.kwad.components.ad.interstitial.f.c.d
            public final void ei() {
                aVar.ga();
            }
        });
        return aVar;
    }

    private bk eO() {
        bk bkVar = new bk(getContext(), this.mN.mAdTemplate);
        bkVar.a(new bk.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.3
            @Override // com.kwad.components.core.webview.jshandler.bk.a
            public final boolean eT() {
                com.kwad.components.core.page.a.launch(b.this.getContext(), b.this.mN.mAdTemplate);
                b.this.mN.a(true, -1, null);
                by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.interstitial.f.a.b.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.this.eC();
                    }
                }, 0L);
                return false;
            }
        });
        return bkVar;
    }

    @NonNull
    private n eP() {
        return new n() { // from class: com.kwad.components.ad.interstitial.f.a.b.4
            @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull final com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                by.runOnUiThreadDelay(new bi() { // from class: com.kwad.components.ad.interstitial.f.a.b.4.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        com.kwad.components.core.webview.tachikoma.c.d dVar = new com.kwad.components.core.webview.tachikoma.c.d();
                        dVar.auk = aq.isWifiConnected(b.this.getContext()) || b.this.mN.ce.isDataFlowAutoStart() || b.y(b.this.mN.mAdTemplate);
                        cVar.b(dVar);
                    }
                }, 0L);
            }
        };
    }

    @NonNull
    private ak eQ() {
        return new ak(new ak.b() { // from class: com.kwad.components.ad.interstitial.f.a.b.5
            @Override // com.kwad.components.core.webview.jshandler.ak.b
            public final void a(final ak.a aVar) {
                if (b.this.mN.lx != null) {
                    b.this.mN.gp.post(new bi() { // from class: com.kwad.components.ad.interstitial.f.a.b.5.1
                        @Override // com.kwad.sdk.utils.bi
                        public final void doTask() {
                            if (aVar.type == 0 && !b.this.mN.mP && !b.this.mN.mQ && com.kwad.components.ad.interstitial.g.a.e(b.this.mN)) {
                                b.this.mN.mQ = true;
                                com.kwad.components.ad.interstitial.c.b.K(b.this.getContext());
                                return;
                            }
                            b.this.eS();
                            c cVar = b.this.mN;
                            ak.a aVar2 = aVar;
                            cVar.a(aVar2.type == 3, aVar2.aqL, null);
                            b.this.eC();
                        }
                    });
                }
            }
        });
    }

    private x eR() {
        return new x() { // from class: com.kwad.components.ad.interstitial.f.a.b.6
            @Override // com.kwad.components.core.webview.jshandler.x
            public final void b(y yVar) {
                super.b(yVar);
                if (b.this.mN.mR || b.this.mN.ls == null) {
                    return;
                }
                b.this.mN.ls.onVideoPlayStart();
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void c(y yVar) {
                super.c(yVar);
                if (b.this.mN.mR || b.this.mN.ls == null) {
                    return;
                }
                b.this.mN.ls.onVideoPlayEnd();
            }

            @Override // com.kwad.components.core.webview.jshandler.x
            public final void d(y yVar) {
                super.d(yVar);
                b.this.mN.mAdTemplate.setmCurPlayTime(yVar.rq);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eS() {
        az azVar = this.iY;
        if (azVar != null) {
            azVar.yz();
            this.iY.yA();
        }
        com.kwad.components.ad.h.a.a.b bVar = this.od;
        if (bVar != null) {
            bVar.gb();
        }
    }

    private com.kwad.components.core.webview.jshandler.aq.a getOpenNewPageListener() {
        return new com.kwad.components.core.webview.jshandler.aq.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.8
            @Override // com.kwad.components.core.webview.jshandler.aq.a
            public final void a(com.kwad.components.core.webview.a.b bVar) {
                AdWebViewActivityProxy.launch(b.this.getContext(), new AdWebViewActivityProxy.a.C1220a().aY(bVar.title).aZ(bVar.url).aQ(true).q(b.this.mN.mAdResultData).ua());
            }
        };
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aE() {
        com.kwad.components.ad.interstitial.report.c.eZ().F(this.mN.mAdTemplate);
        com.kwad.components.core.webview.tachikoma.f.g gVar = this.mN.mU;
        if (gVar != null) {
            gVar.a(getTkTemplateId(), 0L, 0L, 0L);
        }
        if (this.iY != null && this.mN.lq.ah()) {
            this.of = true;
            this.iY.yx();
            this.iY.yy();
        }
        this.mN.lq.a(this.fF);
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aF() {
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void aG() {
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getRegisterViewKey() {
        return null;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final FrameLayout getTKContainer() {
        return this.dm;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTKReaderScene() {
        return "tk_interstitial";
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final String getTkTemplateId() {
        return com.kwad.sdk.core.response.helper.b.ep(this.mN.mAdTemplate);
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.ksad_tk_view);
        this.dm = frameLayout;
        frameLayout.setVisibility(0);
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.of = false;
        this.og = false;
        by.b(getContext(), this.hw);
        d dVar = this.hu;
        if (dVar != null) {
            dVar.cc(getContext());
        }
        com.kwad.components.ad.interstitial.g.b bVar = this.mN.lq;
        if (bVar != null) {
            bVar.b(this.fF);
        }
        this.mN.b(this.nx);
    }

    public static /* synthetic */ boolean b(b bVar, boolean z) {
        bVar.og = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(double d) {
        this.mN.a(new c.C1150c(getContext()).m(true).c(d).W(2).a(this.mN.gp.getTouchCoords()).X(157));
        by.vibrate(getContext(), this.hw, oe);
    }

    public static boolean y(@NonNull AdTemplate adTemplate) {
        File fileCO = com.kwad.sdk.core.diskcache.b.a.Lx().cO(com.kwad.sdk.core.response.helper.a.M(com.kwad.sdk.core.response.helper.e.eO(adTemplate)));
        return fileCO != null && fileCO.exists();
    }

    public static /* synthetic */ boolean a(b bVar, boolean z) {
        bVar.of = true;
        return true;
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(TKRenderFailReason tKRenderFailReason) {
        this.dm.setVisibility(8);
        com.kwad.components.core.webview.tachikoma.f.g gVar = this.mN.mU;
        if (gVar != null) {
            getTkTemplateId();
            gVar.x(getTKReaderScene());
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
        super.a(tVar, bVar);
        com.kwad.components.ad.h.a.a.b bVarM = com.kwad.components.ad.h.a.a.b.M(this.mN.mAdTemplate);
        this.od = bVarM;
        if (bVarM != null) {
            bVarM.a(new com.kwad.components.ad.h.a.a.b.InterfaceC1144b() { // from class: com.kwad.components.ad.interstitial.f.a.b.10
                @Override // com.kwad.components.ad.h.a.a.b.InterfaceC1144b
                public final void ab(int i) {
                    if (i == com.kwad.components.ad.h.a.a.b.rg) {
                        b.this.mN.c(b.this.getContext(), b.this.mN.mAdTemplate);
                        b.this.mN.a(true, -1, null);
                    }
                    b.this.eC();
                }
            });
            tVar.c(this.od);
            this.od.az();
        }
        tVar.c(eQ());
        tVar.c(new com.kwad.components.core.webview.jshandler.aq(getOpenNewPageListener()));
        if (com.kwad.sdk.core.response.helper.b.dW(com.kwad.sdk.core.response.helper.e.eO(this.mN.mAdTemplate))) {
            tVar.c(new bb(new bb.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.11
                @Override // com.kwad.components.core.webview.jshandler.bb.a
                public final void cR() {
                    b.this.cL();
                }
            }));
        }
        tVar.c(eP());
        tVar.c(eO());
        tVar.c(eM());
        tVar.c(a(bVar));
        tVar.c(eR());
        tVar.c(eN());
        tVar.c(new q() { // from class: com.kwad.components.ad.interstitial.f.a.b.12
            @Override // com.kwad.components.core.webview.tachikoma.b.q, com.kwad.sdk.core.webview.c.a
            public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                super.a(str, cVar);
                com.kwad.components.core.t.n.i(b.this.getContext(), b.this.mN.mAdTemplate);
            }
        });
        this.oh = eL();
        this.mN.a(this.nx);
        tVar.c(this.oh);
        tVar.c(new com.kwad.components.core.webview.tachikoma.b(new com.kwad.components.core.webview.tachikoma.b.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.13
            @Override // com.kwad.components.core.webview.tachikoma.b.a
            public final void eU() {
                com.kwad.components.ad.interstitial.d.a.L(b.this.getContext());
            }
        }));
        tVar.c(eK());
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(az azVar) {
        super.a(azVar);
        this.iY = azVar;
    }

    @NonNull
    private z a(com.kwad.sdk.core.webview.b bVar) {
        return new z(bVar, this.mN.mApkDownloadHelper, new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.interstitial.f.a.b.2
            @Override // com.kwad.sdk.core.webview.d.a.a
            public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
                if (aVar != null) {
                    com.kwad.components.ad.interstitial.report.a.eV().a(b.this.mN.mAdTemplate, aVar.bdh, aVar.nm);
                    b.this.mN.mP = true;
                    b.this.mN.c(aVar.bdh, aVar.nm);
                    if (b.this.mN.lx == null || !com.kwad.components.ad.interstitial.d.b.x(b.this.mN.mAdTemplate)) {
                        return;
                    }
                    b.this.mN.a(false, -1, b.this.mN.cB);
                    b.this.mN.lx.dismiss();
                    b.this.mN.ac();
                }
            }
        });
    }

    @Override // com.kwad.components.core.webview.tachikoma.j
    public final void a(ae.a aVar) {
        float height;
        float width;
        float fBB = com.kwad.sdk.c.a.a.bB(getContext());
        FrameLayout frameLayout = this.dm;
        if (frameLayout != null) {
            height = frameLayout.getHeight();
            width = this.dm.getWidth();
        } else {
            height = 0.0f;
            width = 0.0f;
        }
        if (height != 0.0f && width != 0.0f) {
            aVar.width = (int) ((width / fBB) + 0.5f);
            aVar.height = (int) ((height / fBB) + 0.5f);
        } else {
            aVar.width = (int) ((bt.getScreenWidth(getContext()) / fBB) + 0.5f);
            aVar.height = (int) ((bt.getScreenHeight(getContext()) / fBB) + 0.5f);
        }
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(u uVar) {
        super.a(uVar);
        KsInterstitialAd.AdInteractionListener adInteractionListener = this.mN.ls;
        if (adInteractionListener != null) {
            adInteractionListener.onSkippedAd();
        }
        c.a aVar = this.mN.mS;
        if (aVar != null) {
            aVar.a(-1L, -1L, false);
        }
    }

    private static boolean a(Dialog dialog) {
        Activity ownerActivity = dialog.getOwnerActivity();
        return (ownerActivity == null || ownerActivity.isFinishing()) ? false : true;
    }

    @Override // com.kwad.components.ad.interstitial.f.a.a, com.kwad.components.core.webview.tachikoma.j
    public final void a(WebCloseStatus webCloseStatus) {
        this.mN.a(webCloseStatus.closeType == 2, -1, null);
        eC();
    }
}
