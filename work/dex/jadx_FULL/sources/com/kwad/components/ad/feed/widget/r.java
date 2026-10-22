package com.kwad.components.ad.feed.widget;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.ax;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bb;
import com.kwad.components.core.webview.jshandler.x;
import com.kwad.components.core.webview.jshandler.z;
import com.kwad.components.core.webview.tachikoma.TKRenderFailReason;
import com.kwad.components.core.webview.tachikoma.c.u;
import com.kwad.components.core.webview.tachikoma.c.y;
import com.kwad.components.model.FeedType;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.commercial.model.WebCloseStatus;
import com.kwad.sdk.components.t;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.FeedSlideConf;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.by;
import com.kwad.sdk.utils.cb;
import com.kwad.sdk.widget.KSFrameLayout;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class r extends com.kwad.components.core.widget.b<AdResultData, AdTemplate> implements com.kwad.sdk.widget.d {
    private KsAdVideoPlayConfig ce;
    private com.kwad.components.core.webview.tachikoma.b.o dp;
    private com.kwad.components.core.l.a.b fU;
    private com.kwad.components.core.webview.tachikoma.i go;
    private com.kwad.components.ad.feed.d.b hC;
    private com.kwad.components.ad.feed.d.InterfaceC1137d hD;
    private long hP;
    private float hQ;
    private float hR;
    private KSFrameLayout jB;
    private az jC;
    private com.kwad.sdk.core.webview.c.c jD;
    private a jE;
    private FrameLayout.LayoutParams jF;
    private com.kwad.components.core.widget.b jg;
    private boolean jh;
    private com.kwad.components.core.widget.b.a jr;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private int mHeight;
    private boolean mIsNative;
    private int mWidth;

    public interface a {
        void e(int i, String str);
    }

    public r(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bT() {
        com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
        nVar.aut = getMuteStatus();
        this.go.a("setVideoMuteStateListener", nVar.toJson().toString(), (com.kwad.sdk.components.m) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL() {
        float fDy = com.kwad.sdk.core.response.helper.b.dy(this.mAdTemplate);
        if (this.hD == null) {
            this.hD = new com.kwad.components.ad.feed.d.InterfaceC1137d() { // from class: com.kwad.components.ad.feed.widget.r.11
                @Override // com.kwad.components.ad.feed.d.InterfaceC1137d
                public final boolean b(final double d) {
                    if (!cb.r(r.this.jB, (int) (com.kwad.sdk.core.config.e.Kd() * 100.0f)) || !r.this.fx() || !com.kwad.components.ad.feed.d.ce()) {
                        return false;
                    }
                    com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(r.this.getContext()).aJ(r.this.mAdTemplate).b(r.this.mApkDownloadHelper).aN(2).as(false).au(false).aM(157).aL(5).aw(true).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.feed.widget.r.11.1
                        @Override // com.kwad.components.core.e.d.a.b
                        public final void onAdClicked() {
                            com.kwad.sdk.core.d.c.d("TKFeedView", "convertEnable End" + com.kwad.sdk.core.response.helper.e.eY(r.this.mAdTemplate));
                            com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                            bVar.j(d);
                            bVar.ec(157);
                            r.this.c(bVar);
                        }
                    }));
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.helper.b.dI(this.mAdInfo), fDy, this.mContext, this.hD, com.kwad.sdk.core.response.helper.b.dJ(this.mAdInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cM() {
        if (this.jh) {
            return;
        }
        this.jh = true;
        com.kwad.components.ad.feed.monitor.b.a(this.mAdTemplate, 3, getStayTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT() {
        if (this.jB != null) {
            this.jF = new FrameLayout.LayoutParams(this.jB.getLayoutParams());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU() {
        this.go.a("setVideoPlayStatusCallback", (String) null, new com.kwad.components.core.webview.tachikoma.a.g() { // from class: com.kwad.components.ad.feed.widget.r.6
            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void a(y yVar) {
                com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.helper.a.M(r.this.mAdInfo), yVar.errorReason, SystemClock.elapsedRealtime() - r.this.hP);
                com.kwad.components.core.p.a.vL().m(r.this.mAdTemplate, yVar.errorCode, yVar.zw());
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bV() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bW() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bX() {
                com.kwad.components.core.l.a.tm().c(r.this.fU);
            }

            @Override // com.kwad.components.core.webview.tachikoma.a.g
            public final void bY() {
                if (com.kwad.components.core.t.a.aO(r.this.mContext).wD() && r.this.go != null) {
                    com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
                    nVar.aut = r.this.getMuteStatus();
                    r.this.go.a("setVideoMuteStateListener", nVar.toJson().toString(), (com.kwad.sdk.components.m) null);
                }
                com.kwad.components.core.l.a.tm().a(r.this.getCurrentVoiceItem());
                com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.helper.a.M(r.this.mAdInfo), null, SystemClock.elapsedRealtime() - r.this.hP);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cV() {
        if (this.jD == null) {
            return;
        }
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.feed.widget.r.7
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.c.d dVar = new com.kwad.components.core.webview.tachikoma.c.d();
                boolean zIsNetworkConnected = aq.isNetworkConnected(r.this.mContext);
                boolean zIsWifiConnected = aq.isWifiConnected(r.this.mContext);
                if (r.this.ce instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) r.this.ce;
                    dVar.auk = r.this.a(zIsNetworkConnected, zIsWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                } else {
                    dVar.auk = r.this.b(zIsNetworkConnected, zIsWifiConnected);
                }
                r.this.jD.b(dVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cW() {
        com.kwad.components.core.webview.tachikoma.i iVar = this.go;
        if (iVar == null || iVar.zl() == null) {
            return;
        }
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.feed.widget.r.8
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                com.kwad.components.core.webview.tachikoma.c.d dVar = new com.kwad.components.core.webview.tachikoma.c.d();
                boolean zIsNetworkConnected = aq.isNetworkConnected(r.this.mContext);
                boolean zIsWifiConnected = aq.isWifiConnected(r.this.mContext);
                if (r.this.ce instanceof KSAdVideoPlayConfigImpl) {
                    KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl = (KSAdVideoPlayConfigImpl) r.this.ce;
                    dVar.auk = r.this.a(zIsNetworkConnected, zIsWifiConnected, kSAdVideoPlayConfigImpl, kSAdVideoPlayConfigImpl.getVideoAutoPlayType());
                } else {
                    dVar.auk = r.this.b(zIsNetworkConnected, zIsWifiConnected);
                }
                if (r.this.go != null) {
                    r.this.go.a("setVideoAutoPlayListener", dVar.toJson().toString(), (com.kwad.sdk.components.m) null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cX() {
        if (this.jg == null) {
            this.mIsNative = true;
            int iBk = com.kwad.sdk.core.response.helper.a.bk(this.mAdInfo);
            Context context = this.mContext;
            R r = this.mAdTemplate;
            com.kwad.components.core.widget.b bVarA = com.kwad.components.ad.feed.b.a(context, FeedType.fromInt(r.type, r.defaultType), iBk);
            this.jg = bVarA;
            if (bVarA != null) {
                int iA = com.kwad.sdk.c.a.a.a(this.mContext, 16.0f);
                FrameLayout.LayoutParams layoutParams = this.jF;
                if (layoutParams != null) {
                    this.jB.setLayoutParams(layoutParams);
                }
                this.jg.setMargin(iA);
                this.jB.removeAllViews();
                this.jg.setInnerAdInteractionListener(this.jr);
                this.jB.addView(this.jg);
                a aVar = this.jE;
                if (aVar != null) {
                    aVar.e(1, "");
                }
                this.jg.d(this.mAdResultData);
                com.kwad.components.core.widget.b bVar = this.jg;
                if (bVar instanceof c) {
                    ((c) bVar).b(this.ce);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cY() {
        AdMatrixInfo.RotateInfo rotateInfoDM = com.kwad.sdk.core.response.helper.b.dM(this.mAdTemplate);
        if (this.hC == null) {
            this.hC = new com.kwad.components.ad.feed.d.b() { // from class: com.kwad.components.ad.feed.widget.r.12
                @Override // com.kwad.components.ad.feed.d.b
                public final boolean u(String str) {
                    if (!cb.r(r.this.jB, (int) (com.kwad.sdk.core.config.e.Kd() * 100.0f)) || !r.this.fx() || !com.kwad.components.ad.feed.d.ce()) {
                        return false;
                    }
                    r.this.go.a("setSensorParams", new com.kwad.components.core.webview.tachikoma.c.i(1, str).toJson().toString(), (com.kwad.sdk.components.m) null);
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(rotateInfoDM, this.mContext, this.hC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cZ() {
        float fDy = com.kwad.sdk.core.response.helper.b.dy(this.mAdTemplate);
        if (this.hD == null) {
            this.hD = new com.kwad.components.ad.feed.d.InterfaceC1137d() { // from class: com.kwad.components.ad.feed.widget.r.2
                @Override // com.kwad.components.ad.feed.d.InterfaceC1137d
                public final boolean b(double d) {
                    if (!cb.r(r.this.jB, (int) (com.kwad.sdk.core.config.e.Kd() * 100.0f)) || !r.this.fx() || !com.kwad.components.ad.feed.d.ce()) {
                        return false;
                    }
                    r.this.go.a("setSensorParams", new com.kwad.components.core.webview.tachikoma.c.i(2, Double.toString(d)).toJson().toString(), (com.kwad.sdk.components.m) null);
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.helper.b.dI(this.mAdInfo), fDy, this.mContext, this.hD, com.kwad.sdk.core.response.helper.b.dJ(this.mAdInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.kwad.components.core.l.a.b getCurrentVoiceItem() {
        if (this.fU == null) {
            this.fU = new com.kwad.components.core.l.a.b(new com.kwad.components.core.l.a.c() { // from class: com.kwad.components.ad.feed.widget.r.10
                @Override // com.kwad.components.core.l.a.c
                public final void bL() {
                }
            });
        }
        return this.fU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:12:0x0024  */
    /* JADX WARN: Code duplicated, block: B:20:0x0043  */
    /* JADX WARN: Code duplicated, block: B:21:0x0044 A[PHI: r1
      0x0044: PHI (r1v3 boolean) = (r1v0 boolean), (r1v1 boolean), (r1v0 boolean), (r1v0 boolean) binds: [B:18:0x0040, B:20:0x0043, B:10:0x0021, B:5:0x0011] A[DONT_GENERATE, DONT_INLINE]] */
    public boolean getMuteStatus() {
        KsAdVideoPlayConfig ksAdVideoPlayConfig;
        boolean z;
        boolean z2 = true;
        if (!com.kwad.sdk.core.config.e.hO() && com.kwad.components.core.t.a.aO(this.mContext).wD()) {
            z = z2;
        } else if (this.fU != null) {
            com.kwad.components.core.l.a.tm();
            if (com.kwad.components.core.l.a.b(this.fU)) {
                ksAdVideoPlayConfig = this.ce;
                if ((ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) || ((KSAdVideoPlayConfigImpl) ksAdVideoPlayConfig).getVideoSoundValue() == 0) {
                    if (com.kwad.sdk.core.response.helper.a.ch(this.mAdInfo)) {
                        z2 = false;
                    }
                    z = z2;
                } else {
                    z = !this.ce.isVideoSoundEnable();
                }
            } else {
                z = z2;
            }
        } else {
            ksAdVideoPlayConfig = this.ce;
            if (ksAdVideoPlayConfig instanceof KSAdVideoPlayConfigImpl) {
            }
            if (com.kwad.sdk.core.response.helper.a.ch(this.mAdInfo)) {
                z2 = false;
            }
            z = z2;
        }
        R r = this.mAdTemplate;
        if (r != 0) {
            r.mIsAudioEnable = !z;
        }
        return z;
    }

    private void init(Context context) {
        int iA = com.kwad.sdk.core.config.e.a(com.kwad.sdk.core.config.c.aPw);
        final WeakReference weakReference = new WeakReference(com.kwad.sdk.wrapper.m.getActivityFromContext(context));
        this.go = new com.kwad.components.core.webview.tachikoma.i(context, iA, iA);
        com.kwad.sdk.core.c.b.LW();
        com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.components.ad.feed.widget.r.1
            @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
            /* JADX INFO: renamed from: onActivityDestroyed */
            public final void b(@NonNull Activity activity) {
                Activity activity2 = (Activity) weakReference.get();
                if (activity2 == null || !activity2.equals(activity)) {
                    return;
                }
                r.this.onRelease();
                com.kwad.sdk.core.c.b.LW();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRelease() {
        com.kwad.components.core.webview.tachikoma.i iVar = this.go;
        if (iVar != null) {
            iVar.kV();
        }
        az azVar = this.jC;
        if (azVar != null) {
            azVar.onDestroy();
        }
        com.kwad.components.ad.feed.d.InterfaceC1137d interfaceC1137d = this.hD;
        if (interfaceC1137d != null) {
            com.kwad.components.ad.feed.d.a(interfaceC1137d);
        }
        com.kwad.components.ad.feed.d.b bVar = this.hC;
        if (bVar != null) {
            com.kwad.components.ad.feed.d.a(bVar);
        }
        com.kwad.components.ad.feed.d.D(this.mContext);
        com.kwad.components.ad.feed.d.E(this.mContext);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bA() {
        super.bA();
        az azVar = this.jC;
        if (azVar != null) {
            azVar.yC();
            com.kwad.components.core.l.a.tm().c(this.fU);
        }
        setLifeStatue("pageInvisiable");
    }

    @Override // com.kwad.components.core.widget.b
    public final void bC() {
        this.jB = (KSFrameLayout) findViewById(R.id.ksad_container);
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.core.j.c
    public final void bz() {
        super.bz();
        com.kwad.components.core.l.a.tm().a(getCurrentVoiceItem());
        az azVar = this.jC;
        if (azVar != null) {
            azVar.yB();
        }
        setLifeStatue("pageVisiable");
    }

    @Override // com.kwad.components.core.widget.b
    public final int getLayoutId() {
        return R.layout.ksad_feed_tkview;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (!com.kwad.sdk.core.config.e.Ki() || !com.kwad.sdk.core.response.helper.d.eD(this.mAdTemplate)) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        FeedSlideConf feedSlideConfCR = com.kwad.sdk.core.response.helper.b.cR(this.mAdTemplate);
        if (feedSlideConfCR == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        b(motionEvent);
        if ((action == 2 || action == 3) && this.jB != null && !this.mIsNative && Math.abs(motionEvent.getX() - this.hQ) > 0.0f) {
            this.jB.requestDisallowInterceptTouchEvent(true);
            double dAbs = Math.abs(motionEvent.getX() - this.hQ);
            double dAbs2 = Math.abs(motionEvent.getY() - this.hR);
            if (Math.tan(feedSlideConfCR.maxRange) * dAbs < dAbs2 || Math.tan(feedSlideConfCR.minRange) * dAbs < dAbs2) {
                this.jB.requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void setLifeStatue(String str) {
        com.kwad.components.core.webview.tachikoma.i iVar = this.go;
        if (iVar != null) {
            iVar.a("setLifeStatus", str, (com.kwad.sdk.components.m) null);
        }
    }

    public final void setTKLoadListener(a aVar) {
        a aVar2 = this.jE;
        if (aVar2 != null) {
            aVar2.e(this.mIsNative ? 1 : 3, "");
        }
        this.jE = aVar;
    }

    public final void setVideoPlayConfig(KsAdVideoPlayConfig ksAdVideoPlayConfig) {
        this.ce = ksAdVideoPlayConfig;
        cV();
        cW();
    }

    public final void setWidth(int i) {
        if (i <= 0) {
            i = getContext().getResources().getDisplayMetrics().widthPixels;
        }
        this.mWidth = i;
    }

    private r(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, null, 0);
    }

    @Override // com.kwad.components.core.widget.b
    public final void aa() {
        if (this.mAdTemplate.mPvReported || this.mAdTemplate.mHasAdShow) {
            return;
        }
        az azVar = this.jC;
        if (azVar != null) {
            azVar.yx();
            this.jC.yy();
            com.kwad.components.ad.feed.monitor.b.i(this.mAdTemplate, 3, 3);
        }
        if (this.go.zl() != null) {
            setLifeStatue("showStart");
            setLifeStatue("showEnd");
            com.kwad.components.ad.feed.monitor.b.i(this.mAdTemplate, 3, 3);
        }
        com.kwad.components.core.widget.b.a aVar = this.avs;
        if (aVar != null) {
            aVar.onAdShow();
            this.mAdTemplate.mHasAdShow = true;
        }
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        super.ae();
    }

    @Override // com.kwad.components.core.widget.b, com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        super.af();
    }

    @Override // com.kwad.components.core.widget.b
    public final void d(@NonNull AdResultData adResultData) {
        super.d(adResultData);
        com.kwad.components.core.e.d.d dVar = new com.kwad.components.core.e.d.d(this.mAdTemplate);
        this.mApkDownloadHelper = dVar;
        dVar.setOnShowListener(this);
        this.mApkDownloadHelper.setOnDismissListener(this);
        this.hP = SystemClock.elapsedRealtime();
        if (com.kwad.sdk.core.response.helper.b.dB(this.mAdTemplate) > AudioStats.AUDIO_AMPLITUDE_NONE) {
            this.mHeight = (int) (((double) this.mWidth) * com.kwad.sdk.core.response.helper.b.dB(this.mAdTemplate));
        } else {
            this.mHeight = this.jB.getHeight();
        }
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.go.a(com.kwad.sdk.wrapper.m.getActivityFromContext(this.mContext), adResultData, new com.kwad.components.core.webview.tachikoma.j() { // from class: com.kwad.components.ad.feed.widget.r.5
            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(TKRenderFailReason tKRenderFailReason) {
                r.this.cX();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.p pVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.c.n nVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(u uVar) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void aE() {
                if (r.this.jE != null) {
                    r.this.jE.e(3, "");
                }
                com.kwad.sdk.core.d.c.d("TKFeedView", "TK load success, cost time: " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void aF() {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void aG() {
                r.this.go.a("setSensorMotionType", (String) null, new com.kwad.sdk.components.m() { // from class: com.kwad.components.ad.feed.widget.r.5.7
                    @Override // com.kwad.sdk.components.m
                    public final Object call(@Nullable Object... objArr) {
                        if (objArr != null && objArr.length != 0) {
                            try {
                                Object obj = objArr[0];
                                if (obj instanceof Integer) {
                                    int iIntValue = ((Integer) obj).intValue();
                                    if (iIntValue == 1) {
                                        r.this.cY();
                                    } else if (iIntValue == 2) {
                                        r.this.cZ();
                                    } else if (iIntValue == 3) {
                                        r.this.cY();
                                        r.this.cZ();
                                    }
                                }
                            } catch (Throwable unused) {
                            }
                        }
                        return null;
                    }
                });
                r.this.cW();
                r.this.cU();
                r.this.bT();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void g(AdTemplate adTemplate) {
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getRegisterViewKey() {
                return "ksad-feed-card";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final FrameLayout getTKContainer() {
                r.this.cT();
                return r.this.jB;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTKReaderScene() {
                return "tk_feed_tk_card";
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final String getTkTemplateId() {
                return com.kwad.sdk.core.response.helper.b.ew(r.this.mAdTemplate);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final com.kwad.sdk.widget.g getTouchCoordsView() {
                return null;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(t tVar, com.kwad.sdk.core.webview.b bVar) {
                if (r.this.go.yV()) {
                    return;
                }
                tVar.c(new com.kwad.components.core.webview.tachikoma.b.n() { // from class: com.kwad.components.ad.feed.widget.r.5.1
                    @Override // com.kwad.components.core.webview.tachikoma.b.w, com.kwad.sdk.core.webview.c.a
                    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
                        super.a(str, cVar);
                        r.this.jD = cVar;
                        r.this.cV();
                    }
                });
                tVar.c(new x() { // from class: com.kwad.components.ad.feed.widget.r.5.2
                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void a(y yVar) {
                        super.a(yVar);
                        com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 2, 1, com.kwad.sdk.core.response.helper.a.M(r.this.mAdInfo), yVar.errorReason, SystemClock.elapsedRealtime() - r.this.hP);
                        com.kwad.components.core.p.a.vL().m(r.this.mAdTemplate, yVar.errorCode, yVar.zw());
                    }

                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void b(y yVar) {
                        super.b(yVar);
                        if (com.kwad.components.core.t.a.aO(r.this.mContext).wD() && r.this.dp != null) {
                            com.kwad.components.core.webview.tachikoma.c.n nVar = new com.kwad.components.core.webview.tachikoma.c.n();
                            nVar.aut = true;
                            r.this.dp.c(nVar);
                        }
                        com.kwad.components.core.l.a.tm().a(r.this.getCurrentVoiceItem());
                        com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 1, 1, com.kwad.sdk.core.response.helper.a.M(r.this.mAdInfo), null, SystemClock.elapsedRealtime() - r.this.hP);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.x
                    public final void c(y yVar) {
                        super.c(yVar);
                        com.kwad.components.core.l.a.tm().c(r.this.fU);
                    }
                });
                bb bbVar = new bb(new bb.a() { // from class: com.kwad.components.ad.feed.widget.r.5.3
                    @Override // com.kwad.components.core.webview.jshandler.bb.a
                    public final void cR() {
                        r.this.cL();
                    }
                });
                ax axVar = new ax(new ax.a() { // from class: com.kwad.components.ad.feed.widget.r.5.4
                    @Override // com.kwad.components.core.webview.jshandler.ax.a
                    public final void c(com.kwad.components.core.webview.tachikoma.f.d dVar2) {
                        r.this.a(dVar2);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.ax.a
                    public final void d(com.kwad.components.core.webview.tachikoma.f.d dVar2) {
                        r.this.b(dVar2);
                    }

                    @Override // com.kwad.components.core.webview.jshandler.ax.a
                    public final void e(com.kwad.components.core.webview.tachikoma.f.d dVar2) {
                        r.this.a(dVar2);
                        r.this.b(dVar2);
                    }
                });
                tVar.c(bbVar);
                tVar.c(axVar);
                tVar.c(new z(bVar, r.this.mApkDownloadHelper, (com.kwad.sdk.core.webview.d.a.a) r.this.go, true));
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(@Nullable com.kwad.sdk.core.webview.d.b.a aVar) {
                if (r.this.avs != null) {
                    r.this.avs.onAdClicked();
                }
                r.this.cM();
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(ae.a aVar) {
                aVar.width = com.kwad.sdk.c.a.a.px2dip(r.this.mContext, r.this.mWidth);
                aVar.height = com.kwad.sdk.c.a.a.px2dip(r.this.mContext, r.this.mHeight);
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.tachikoma.b.o oVar) {
                r.this.dp = oVar;
                r.this.dp.a(new com.kwad.components.core.webview.tachikoma.b.o.a() { // from class: com.kwad.components.ad.feed.widget.r.5.5
                    @Override // com.kwad.components.core.webview.tachikoma.b.o.a
                    public final boolean isMuted() {
                        return r.this.getMuteStatus();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(WebCloseStatus webCloseStatus) {
                if (r.this.jC != null) {
                    r.this.jC.yz();
                    r.this.jC.yA();
                }
                r.this.setLifeStatue("hideStart");
                r.this.setLifeStatue("hideEnd");
                by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.feed.widget.r.5.6
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        r.this.zO();
                    }
                });
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(az azVar) {
                r.this.jC = azVar;
            }

            @Override // com.kwad.components.core.webview.tachikoma.j
            public final void a(com.kwad.components.core.webview.jshandler.a.C1235a c1235a) {
                if (r.this.avs != null) {
                    String str = c1235a.aps;
                    str.hashCode();
                    switch (str) {
                        case "adShowCallback":
                            r.this.avs.onAdShow();
                            break;
                        case "adDownloadConfirmTipCancel":
                        case "adDownloadConfirmTipDismiss":
                            r.this.avs.onDownloadTipsDialogDismiss();
                            break;
                        case "adCloseCallback":
                            r.this.avs.onDislikeClicked();
                            break;
                        case "adDownloadConfirmTipShow":
                            r.this.avs.onDownloadTipsDialogShow();
                            break;
                        case "adClickCallback":
                            r.this.avs.onAdClicked();
                            break;
                    }
                }
            }
        });
    }

    private r(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.mWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        this.mIsNative = false;
        this.jr = new com.kwad.components.core.widget.b.a() { // from class: com.kwad.components.ad.feed.widget.r.9
            @Override // com.kwad.components.core.widget.b.a
            public final void onAdClicked() {
                if (r.this.avs != null) {
                    r.this.avs.onAdClicked();
                }
                com.kwad.components.ad.feed.monitor.b.a(r.this.mAdTemplate, 1, r.this.getStayTime());
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onAdShow() {
                if (r.this.mIsNative) {
                    if (r.this.avs != null) {
                        r.this.avs.onAdShow();
                    }
                    com.kwad.sdk.core.adlog.c.b bVar = new com.kwad.sdk.core.adlog.c.b();
                    com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
                    FeedType feedTypeFromInt = FeedType.fromInt(r.this.mAdTemplate.type, r.this.mAdTemplate.defaultType);
                    if (feedTypeFromInt == FeedType.FEED_TYPE_TEXT_NEW) {
                        feedTypeFromInt = FeedType.FEED_TYPE_TEXT_BELOW;
                    }
                    c1273a.templateId = String.valueOf(feedTypeFromInt.getType());
                    c1273a.aLh = String.valueOf(feedTypeFromInt.getFeedDefaultType() == null ? 0 : feedTypeFromInt.getFeedDefaultType().getDefaultType());
                    bVar.b(c1273a);
                    bVar.z(r.this.getHeight(), r.this.mWidth);
                    com.kwad.components.core.t.b.wF().a(r.this.mAdTemplate, null, bVar);
                    com.kwad.components.ad.feed.monitor.b.i(r.this.mAdTemplate, 1, 3);
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDislikeClicked() {
                if (r.this.avs != null) {
                    r.this.avs.onDislikeClicked();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogDismiss() {
                if (r.this.avs != null) {
                    r.this.avs.onDownloadTipsDialogDismiss();
                }
            }

            @Override // com.kwad.components.core.widget.b.a
            public final void onDownloadTipsDialogShow() {
                if (r.this.avs != null) {
                    r.this.avs.onDownloadTipsDialogShow();
                }
            }
        };
        init(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(boolean z, boolean z2) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        if (com.kwad.sdk.core.response.helper.a.cj(adInfoEO)) {
            return z;
        }
        if (com.kwad.sdk.core.response.helper.a.ck(adInfoEO)) {
            return z2;
        }
        if (com.kwad.sdk.core.response.helper.a.cl(adInfoEO)) {
            return false;
        }
        return com.kwad.sdk.core.config.e.JW() ? z : z2;
    }

    private void b(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.hQ = motionEvent.getX();
            this.hR = motionEvent.getY();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(boolean z, boolean z2, KSAdVideoPlayConfigImpl kSAdVideoPlayConfigImpl, int i) {
        if (i == 1) {
            return z;
        }
        if (i == 2) {
            return z2;
        }
        if (i == 3) {
            return false;
        }
        if (kSAdVideoPlayConfigImpl.getDataFlowAutoStartValue() != 0) {
            return kSAdVideoPlayConfigImpl.isDataFlowAutoStart() ? z : z2;
        }
        return b(z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.kwad.components.core.webview.tachikoma.f.d dVar) {
        AdMatrixInfo.RotateInfo rotateInfoDM = com.kwad.sdk.core.response.helper.b.dM(this.mAdTemplate);
        if (this.hC == null) {
            this.hC = new com.kwad.components.ad.feed.d.b() { // from class: com.kwad.components.ad.feed.widget.r.4
                @Override // com.kwad.components.ad.feed.d.b
                public final boolean u(String str) {
                    if (!cb.r(r.this.jB, (int) (com.kwad.sdk.core.config.e.Kd() * 100.0f)) || !r.this.fx() || !com.kwad.components.ad.feed.d.ce()) {
                        return false;
                    }
                    dVar.u(1, str);
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(rotateInfoDM, this.mContext, this.hC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.kwad.components.core.webview.tachikoma.f.d dVar) {
        float fDy = com.kwad.sdk.core.response.helper.b.dy(this.mAdTemplate);
        if (this.hD == null) {
            this.hD = new com.kwad.components.ad.feed.d.InterfaceC1137d() { // from class: com.kwad.components.ad.feed.widget.r.3
                @Override // com.kwad.components.ad.feed.d.InterfaceC1137d
                public final boolean b(double d) {
                    if (!cb.r(r.this.jB, (int) (com.kwad.sdk.core.config.e.Kd() * 100.0f)) || !r.this.fx() || !com.kwad.components.ad.feed.d.ce()) {
                        return false;
                    }
                    dVar.u(2, Double.toString(d));
                    return true;
                }
            };
        }
        com.kwad.components.ad.feed.d.a(com.kwad.sdk.core.response.helper.b.dI(this.mAdInfo), fDy, this.mContext, this.hD, com.kwad.sdk.core.response.helper.b.dJ(this.mAdInfo));
    }
}
