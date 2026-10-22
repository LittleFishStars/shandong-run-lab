package com.kwad.components.ad.nativead.c;

import android.app.Activity;
import android.content.Context;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.nativead.b;
import com.kwad.components.core.e.d.d;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.b.o;
import com.kwad.components.core.webview.tachikoma.b.p;
import com.kwad.components.core.webview.tachikoma.c.n;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.i;
import com.kwad.components.core.webview.tachikoma.j;
import com.kwad.sdk.R;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.j.c;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.widget.KSFrameLayout;
import com.kwad.sdk.widget.g;
import com.kwad.sdk.wrapper.m;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends KSFrameLayout {
    private c fF;
    private com.kwad.components.core.widget.a.c fx;
    private i go;

    @Nullable
    private KSFrameLayout gp;
    private az iY;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private d mApkDownloadHelper;
    private Context mContext;
    private b.c pl;
    private b.e pm;
    private com.kwad.components.ad.nativead.d.a qC;
    private ViewTreeObserver qD;
    private ViewTreeObserver.OnGlobalLayoutListener qE;
    private ae.d qF;
    private int qG;
    private int qH;
    private boolean qI;
    private boolean qJ;
    private boolean qK;
    private boolean qL;

    public a(@NonNull Context context) {
        super(context);
        this.qG = 0;
        this.qH = 0;
        this.qI = false;
        B(context);
    }

    private void B(Context context) {
        this.mContext = context;
        m.inflate(context, R.layout.ksad_native_tk_card_layout, this);
        this.gp = (KSFrameLayout) findViewById(R.id.ksad_native_tk_container);
        int iA = e.a(com.kwad.sdk.core.config.c.aPy);
        this.go = new i(context, iA, iA);
        final WeakReference weakReference = new WeakReference(m.getActivityFromContext(context));
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.nativead.c.a.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || !activity2.equals(activity)) {
                    return;
                }
                com.kwad.sdk.core.c.b.LW();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                a.this.release();
            }
        });
    }

    private void bR() {
        i iVar = this.go;
        if (iVar != null) {
            iVar.a(m.getActivityFromContext(this.mContext), this.mAdResultData, new j() { // from class: com.kwad.components.ad.nativead.c.a.4
                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(TKRenderFailReason tKRenderFailReason) {
                    if (a.this.gp != null) {
                        a.this.gp.setVisibility(8);
                    }
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
                public final void aE() {
                    if (a.this.gp != null) {
                        a.this.gp.setVisibility(0);
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void aF() {
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void aG() {
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
                    return a.this.gp;
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final String getTKReaderScene() {
                    return "tk_native_interact_card";
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final String getTkTemplateId() {
                    return com.kwad.sdk.core.response.helper.b.du(a.this.mAdTemplate).templateId;
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final g getTouchCoordsView() {
                    return null;
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
                    tVar.c(new ax(new ax.b() { // from class: com.kwad.components.ad.nativead.c.a.4.1
                        @Override // com.kwad.components.core.webview.jshandler.ax.b
                        public final void a(com.kwad.components.core.webview.tachikoma.f.d dVar, AdMatrixInfo.ShakeInfo shakeInfo, AdMatrixInfo.RotateInfo rotateInfo) {
                            a.this.a(dVar, shakeInfo);
                            a.this.a(dVar, rotateInfo);
                        }

                        @Override // com.kwad.components.core.webview.jshandler.ax.b
                        public final void b(com.kwad.components.core.webview.tachikoma.f.d dVar, AdMatrixInfo.ShakeInfo shakeInfo) {
                            a.this.a(dVar, shakeInfo);
                        }

                        @Override // com.kwad.components.core.webview.jshandler.ax.b
                        public final void b(com.kwad.components.core.webview.tachikoma.f.d dVar, AdMatrixInfo.RotateInfo rotateInfo) {
                            a.this.a(dVar, rotateInfo);
                        }
                    }));
                    tVar.c(new z(bVar, a.this.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) a.this.go, true));
                    tVar.c(new com.kwad.components.core.webview.jshandler.j(new com.kwad.components.core.webview.jshandler.p() { // from class: com.kwad.components.ad.nativead.c.a.4.2
                        @Override // com.kwad.components.core.webview.jshandler.p
                        public final void a(com.kwad.components.core.webview.jshandler.j jVar, String str) {
                            if (str.equals("getConvertCount")) {
                                jVar.cd(a.this.mAdInfo.convertCount);
                            }
                        }
                    }));
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
                    if (a.this.qC != null) {
                        a.this.qC.l(new FrameLayout(a.this.mContext));
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(ae.a aVar) {
                    if (a.this.gp != null) {
                        aVar.width = com.kwad.sdk.c.a.a.px2dip(a.this.mContext, a.this.gp.getWidth());
                        aVar.height = com.kwad.sdk.c.a.a.px2dip(a.this.mContext, a.this.gp.getHeight());
                    }
                    if (aVar instanceof ae.b) {
                        a.this.qF = ((ae.b) aVar).aqp;
                    }
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(WebCloseStatus webCloseStatus) {
                    a.this.release();
                }

                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(az azVar) {
                    a.this.iY = azVar;
                }

                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                /* JADX WARN: Code duplicated, block: B:23:0x0049  */
                @Override // com.kwad.components.core.webview.tachikoma.j
                public final void a(com.kwad.components.core.webview.jshandler.a.C1235a c1235a) {
                    byte b;
                    if (a.this.qC == null || c1235a == null) {
                        return;
                    }
                    switch (c1235a.aps) {
                        case "adShowCallback":
                            b = 1;
                            break;
                        case "adDownloadConfirmTipShow":
                            b = 2;
                            break;
                        case "adDownloadConfirmTipDismiss":
                            b = 3;
                            break;
                        case "handleDownloadDialog":
                            b = 4;
                            break;
                        case "adClickCallback":
                            b = 0;
                            break;
                        default:
                            b = -1;
                            break;
                    }
                    if (b == 0) {
                        a.this.qC.l(new FrameLayout(a.this.mContext));
                        return;
                    }
                    if (b == 1) {
                        a.this.qC.fy();
                    } else if (b == 2) {
                        a.this.qC.onDownloadTipsDialogShow();
                    } else {
                        if (b != 3) {
                            return;
                        }
                        a.this.qC.onDownloadTipsDialogDismiss();
                    }
                }
            });
        }
    }

    private void fQ() {
        if (this.fx == null) {
            this.fx = new com.kwad.components.ad.nativead.g(this.gp);
        }
        if (this.fF == null) {
            this.fF = new c() { // from class: com.kwad.components.ad.nativead.c.a.2
                @Override // com.kwad.sdk.core.j.c
                public final void bA() {
                    if (a.this.iY != null) {
                        a.this.iY.yC();
                    }
                }

                @Override // com.kwad.sdk.core.j.c
                public final void bz() {
                    if (a.this.iY != null) {
                        if (!a.this.qI) {
                            a.this.iY.yx();
                            a.this.iY.yy();
                            a.a(a.this, true);
                        }
                        a.this.iY.yB();
                    }
                }
            };
        }
        this.fx.a(this.fF);
        this.fx.Aa();
        this.qE = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.kwad.components.ad.nativead.c.a.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                if (a.this.gp == null) {
                    return;
                }
                int iPx2dip = com.kwad.sdk.c.a.a.px2dip(a.this.mContext, a.this.gp.getWidth());
                int iPx2dip2 = com.kwad.sdk.c.a.a.px2dip(a.this.mContext, a.this.gp.getHeight());
                if (iPx2dip == a.this.qG && iPx2dip2 == a.this.qH) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("NativeTKView", "监听器1 - 尺寸: " + iPx2dip + "x" + iPx2dip2 + " old: " + a.this.qG + "x" + a.this.qH);
                a.this.qG = iPx2dip;
                a.this.qH = iPx2dip2;
                if (a.this.qF != null) {
                    a.this.qF.u(iPx2dip, iPx2dip2);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean fx() {
        int i = this.mAdInfo.status;
        return i == 2 || i == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        try {
            az azVar = this.iY;
            if (azVar != null) {
                azVar.yz();
                this.iY.yA();
                this.iY = null;
            }
            com.kwad.components.core.widget.a.c cVar = this.fx;
            if (cVar != null) {
                cVar.b(this.fF);
                this.fx.Ab();
            }
            i iVar = this.go;
            if (iVar != null) {
                iVar.kV();
            }
            ViewTreeObserver viewTreeObserver = this.qD;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.qD.removeOnGlobalLayoutListener(this.qE);
                }
                this.qD = null;
            }
            if (this.pm != null) {
                b.ft().a(this.pm);
            }
            if (this.pl != null) {
                b.ft().a(this.pl);
            }
            KSFrameLayout kSFrameLayout = this.gp;
            if (kSFrameLayout != null) {
                kSFrameLayout.removeAllViews();
                this.gp.setVisibility(8);
                this.gp = null;
            }
            this.qJ = true;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
        KSFrameLayout kSFrameLayout = this.gp;
        if (kSFrameLayout == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = kSFrameLayout.getViewTreeObserver();
        this.qD = viewTreeObserver;
        viewTreeObserver.addOnGlobalLayoutListener(this.qE);
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
        ViewTreeObserver viewTreeObserver = this.qD;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.qD.removeOnGlobalLayoutListener(this.qE);
            }
            this.qD = null;
        }
    }

    public final boolean fR() {
        return this.qJ;
    }

    public final boolean fS() {
        return this.qK;
    }

    public final boolean fT() {
        return this.qL;
    }

    public final void setAdInteractionListener(com.kwad.components.ad.nativead.d.a aVar) {
        this.qC = aVar;
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.qI = true;
        return true;
    }

    public final void a(@NonNull AdResultData adResultData, d dVar) {
        this.mAdResultData = adResultData;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        this.mAdTemplate = adTemplateR;
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(adTemplateR);
        this.mApkDownloadHelper = dVar;
        fQ();
        bR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.components.core.webview.tachikoma.f.d dVar, AdMatrixInfo.ShakeInfo shakeInfo) {
        if (shakeInfo == null) {
            return;
        }
        float f = shakeInfo.acceleration;
        if (f <= 0.0f) {
            return;
        }
        this.pm = new b.e() { // from class: com.kwad.components.ad.nativead.c.a.5
            @Override // com.kwad.components.ad.nativead.b.e
            public final boolean b(double d) {
                if (!cb.r(a.this.gp, (int) (e.Kd() * 100.0f)) || a.this.fx() || !b.ce()) {
                    return false;
                }
                dVar.u(2, Double.toString(d));
                return true;
            }
        };
        b.ft().a(com.kwad.sdk.core.response.helper.b.dz(this.mAdTemplate) || com.kwad.sdk.core.response.helper.a.am(this.mAdInfo), f, this.gp, this.pm, com.kwad.sdk.core.response.helper.b.dK(this.mAdInfo));
        this.qK = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.components.core.webview.tachikoma.f.d dVar, AdMatrixInfo.RotateInfo rotateInfo) {
        if (rotateInfo == null) {
            return;
        }
        this.pl = new b.c() { // from class: com.kwad.components.ad.nativead.c.a.6
            @Override // com.kwad.components.ad.nativead.b.c
            public final boolean u(String str) {
                if (!cb.r(a.this.gp, (int) (e.Kd() * 100.0f)) || a.this.fx() || !b.ce()) {
                    return false;
                }
                dVar.u(1, str);
                return true;
            }
        };
        b.ft().a(rotateInfo, this.mContext, this.pl);
        this.qL = true;
    }
}
