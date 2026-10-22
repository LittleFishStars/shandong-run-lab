package com.kwad.components.ad.interstitial.f;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.kwad.components.core.widget.KsAutoCloseView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.widget.KSFrameLayout;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends b {
    public static float nt = 1.3333334f;
    private static float nu = 0.749f;
    private static float nv = 0.8f;
    private static float nw = 1.0f;
    private com.kwad.sdk.core.video.videoview.a cB;
    private com.kwad.components.core.widget.a.c fx;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private KsAutoCloseView mK;
    private c mN;
    private boolean nr;
    private KSFrameLayout ns;
    private c.b nx;
    private com.kwad.sdk.core.j.d ny = new com.kwad.sdk.core.j.d() { // from class: com.kwad.components.ad.interstitial.f.d.5
        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bA() {
            d.this.mK.setCountDownPaused(true);
        }

        @Override // com.kwad.sdk.core.j.d, com.kwad.sdk.core.j.c
        public final void bz() {
            if (!d.this.mAdTemplate.mPvReported && !d.this.mN.mR && d.this.mN.ls != null) {
                d.this.mN.ls.onAdShow();
                d.this.mN.lx.getTimerHelper().startTiming();
                com.kwad.components.ad.interstitial.report.c.eZ().c(d.this.mN.mAdTemplate, 1);
            }
            com.kwad.sdk.core.adlog.c.b bVarEo = new com.kwad.sdk.core.adlog.c.b().eo(d.this.mN.nb);
            if (!d.this.mAdTemplate.mPvReported) {
                com.kwad.components.ad.interstitial.report.c.eZ().H(d.this.mAdTemplate);
            }
            com.kwad.components.core.t.b.wF().a(d.this.mAdTemplate, null, bVarEo);
            d.this.mK.setCountDownPaused(false);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams Y(int i) {
        int i2 = (int) (i * nu);
        return new ViewGroup.LayoutParams((int) (i2 / 0.749f), i2);
    }

    private c.b ek() {
        c.b bVar = new c.b() { // from class: com.kwad.components.ad.interstitial.f.d.4
            @Override // com.kwad.components.ad.interstitial.f.c.b
            public final void c(long j, long j2) {
                com.kwad.components.ad.interstitial.report.a.eV().b(d.this.mAdTemplate, j, j2);
            }
        };
        this.nx = bVar;
        return bVar;
    }

    private void el() {
        final com.kwad.components.ad.interstitial.h.d dVar = this.mN.mO;
        dVar.setAdTemplate(this.mAdTemplate);
        if (com.kwad.sdk.core.response.helper.a.bj(this.mAdInfo)) {
            dVar.c(com.kwad.sdk.core.response.helper.a.ba(this.mAdInfo).materialUrl, this.mAdTemplate);
            dVar.d(true, true);
            dVar.u(false);
        } else {
            dVar.u(true);
            String url = com.kwad.sdk.core.response.helper.a.bA(this.mAdInfo).getUrl();
            if (TextUtils.isEmpty(url)) {
                dVar.d(false, false);
            } else {
                dVar.c(url, this.mAdTemplate);
                dVar.d(true, false);
            }
            com.kwad.sdk.core.video.videoview.a aVar = this.mN.cB;
            this.cB = aVar;
            if (aVar.getParent() != null) {
                ((ViewGroup) this.cB.getParent()).removeView(this.cB);
            }
            if (com.kwad.sdk.core.response.helper.a.bi(this.mAdInfo)) {
                dVar.a(com.kwad.sdk.core.response.helper.a.bb(this.mAdInfo).height / com.kwad.sdk.core.response.helper.a.bb(this.mAdInfo).width, this.cB);
            }
            dVar.v(this.mN.ce.isVideoSoundEnable());
            final int iN = com.kwad.sdk.core.response.helper.a.N(this.mAdInfo);
            this.mN.a(new com.kwad.components.core.video.a.c() { // from class: com.kwad.components.ad.interstitial.f.d.6
                @Override // com.kwad.components.core.video.a.c
                public final void as() {
                    dVar.d(false, false);
                }

                @Override // com.kwad.components.core.video.a.c
                public final void at() {
                    d.this.cB.setVisibility(8);
                    if (d.this.mN.M(d.this.getContext())) {
                        return;
                    }
                    dVar.fo();
                }

                @Override // com.kwad.components.core.video.a.c
                @SuppressLint({"SetTextI18n"})
                public final void d(long j) {
                    int i = iN - ((int) (j / 1000));
                    if (i >= 0) {
                        dVar.C(String.valueOf(i));
                    } else {
                        dVar.fm();
                    }
                }

                @Override // com.kwad.components.core.video.a.c
                public final void onVideoPlayStart() {
                    dVar.u(true);
                }
            });
            dVar.a(this.mAdTemplate, this.mAdInfo);
            dVar.u(true);
            this.mN.mW.add(new c.d() { // from class: com.kwad.components.ad.interstitial.f.d.7
                @Override // com.kwad.components.ad.interstitial.f.c.d
                public final void ei() {
                    dVar.fp();
                    d.this.cB.setVisibility(0);
                }
            });
        }
        this.mN.a(getContext(), this.mAdInfo, this.mAdTemplate, dVar.getBlurBgView());
        String strQ = com.kwad.sdk.core.response.helper.a.Q(this.mAdInfo);
        if (TextUtils.isEmpty(strQ)) {
            strQ = com.kwad.sdk.core.response.helper.a.aa(this.mAdInfo);
        }
        KSImageLoader.loadImage(dVar.getTailFrameView(), strQ, this.mAdTemplate);
        if (!c(this.mAdInfo)) {
            this.mK.bq(false);
        } else {
            this.mK.bq(true);
            em();
        }
    }

    private void em() {
        AdInfo adInfo = this.mAdInfo;
        int iMin = adInfo.adInsertScreenInfo.autoCloseTime;
        if (com.kwad.sdk.core.response.helper.a.bi(adInfo)) {
            iMin = Math.min(iMin, com.kwad.sdk.core.response.helper.a.N(this.mAdInfo));
            this.mN.mO.fm();
            this.mN.mO.fn();
        }
        this.mK.au(iMin);
        com.kwad.sdk.core.adlog.c.b(this.mAdTemplate, 165, (JSONObject) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(boolean z) {
        c cVar = this.mN;
        if (!cVar.mR && !z && !cVar.mP && !cVar.mQ && com.kwad.components.ad.interstitial.g.a.e(cVar)) {
            this.mN.mQ = true;
            com.kwad.components.ad.interstitial.c.b.K(getContext());
            return;
        }
        this.mN.a(z, -1, this.cB);
        this.mN.lx.dismiss();
        com.kwad.sdk.core.video.videoview.a aVar = this.cB;
        if (aVar != null) {
            aVar.release();
        }
        this.mN.ac();
    }

    @Override // com.kwad.components.ad.interstitial.f.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        c cVar = (c) SB();
        this.mN = cVar;
        this.mAdTemplate = cVar.mAdTemplate;
        com.kwad.components.ad.interstitial.report.c.eZ().G(this.mN.mAdTemplate);
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.mN.mAdTemplate);
        this.mAdInfo = adInfoEO;
        AdInfo.AdMaterialInfo.MaterialFeature materialFeatureBd = com.kwad.sdk.core.response.helper.a.bd(adInfoEO);
        int i = materialFeatureBd.width;
        if (i > 0) {
            nt = materialFeatureBd.height / i;
        }
        this.mN.gp.setBackgroundColor(Color.parseColor("#99000000"));
        this.mN.mO.setVisibility(0);
        this.mN.mO.L(this.mAdTemplate);
        this.mN.a(ek());
        el();
        this.mN.mO.setViewListener(new com.kwad.components.ad.interstitial.h.e() { // from class: com.kwad.components.ad.interstitial.f.d.2
            @Override // com.kwad.components.ad.interstitial.h.e
            public final void a(KSFrameLayout kSFrameLayout) {
                d.this.ns = kSFrameLayout;
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eA() {
                d.this.e(3, 17);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eB() {
                d.this.e(3, 35);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eo() {
                d.this.o(false);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ep() {
                d.this.e(3, d.this.mN.mO.fq() ? 53 : 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eq() {
                d.this.e(1, 39);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void er() {
                d.this.e(1, 29);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void es() {
                d.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void et() {
                d.this.e(3, 85);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void eu() {
                d.this.e(2, 53);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ev() {
                d.this.e(2, 30);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ew() {
                d.this.e(2, 31);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ex() {
                d.this.e(2, 32);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ey() {
                d.this.e(3, 15);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void ez() {
                d.this.e(3, 16);
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void p(boolean z) {
                if (d.this.cB != null) {
                    d.this.cB.setVideoSoundEnable(z);
                }
            }

            @Override // com.kwad.components.ad.interstitial.h.e
            public final void q(boolean z) {
                d.this.nr = z;
            }
        });
        com.kwad.components.core.widget.a.c cVar2 = new com.kwad.components.core.widget.a.c(this.mN.mO, 100);
        this.fx = cVar2;
        cVar2.a(this.ny);
        this.fx.Aa();
        final boolean zBc = com.kwad.sdk.core.response.helper.a.bc(this.mAdInfo);
        getContext();
        final boolean zVM = as.VM();
        this.mN.mO.setRatio(c(zVM, zBc));
        final ViewGroup viewGroup = (ViewGroup) findViewById(R.id.ksad_interstitial_native);
        viewGroup.setVisibility(0);
        viewGroup.post(new bi() { // from class: com.kwad.components.ad.interstitial.f.d.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                ViewGroup.LayoutParams layoutParamsA = zVM ? d.a(d.this.getRootView().getWidth(), zBc) : d.Y(d.this.getRootView().getHeight());
                ViewParent parent = d.this.mN.mO.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(d.this.mN.mO);
                }
                viewGroup.addView(d.this.mN.mO);
                d.this.mN.mO.f(layoutParamsA.width, layoutParamsA.height);
                viewGroup.requestLayout();
                viewGroup.post(new bi() { // from class: com.kwad.components.ad.interstitial.f.d.3.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        if (d.this.cB != null) {
                            d.this.cB.requestLayout();
                        }
                    }
                });
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        KsAutoCloseView ksAutoCloseView = (KsAutoCloseView) findViewById(R.id.ksad_interstitial_auto_close);
        this.mK = ksAutoCloseView;
        ksAutoCloseView.setViewListener(new KsAutoCloseView.a() { // from class: com.kwad.components.ad.interstitial.f.d.1
            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void en() {
                d.this.o(true);
            }

            @Override // com.kwad.components.core.widget.KsAutoCloseView.a
            public final void eo() {
                d.this.o(false);
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.mN.b(this.nx);
        com.kwad.components.core.widget.a.c cVar = this.fx;
        if (cVar != null) {
            cVar.b(this.ny);
            this.fx.Ab();
        }
    }

    private static float c(boolean z, boolean z2) {
        if (z && z2) {
            return nt;
        }
        return 0.749f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i, int i2) {
        if (this.mN.a(new c.C1150c(getContext()).l(this.nr).a(this.ns.getTouchCoords()).W(i).X(i2)) && com.kwad.components.ad.interstitial.d.b.x(this.mAdTemplate)) {
            c cVar = this.mN;
            if (cVar.lx != null) {
                cVar.a(false, -1, cVar.cB);
                this.mN.lx.dismiss();
                this.mN.ac();
            }
        }
    }

    private static boolean c(AdInfo adInfo) {
        return adInfo.adInsertScreenInfo.autoCloseTime > 0 && !com.kwad.sdk.core.response.helper.a.bQ(adInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ViewGroup.LayoutParams a(int i, boolean z) {
        float f;
        if (z) {
            f = nv;
        } else {
            f = nw;
        }
        int i2 = (int) (i * f);
        return new ViewGroup.LayoutParams(i2, (int) (i2 * (z ? nt : 0.749f)));
    }
}
