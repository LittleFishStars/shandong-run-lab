package com.kwad.components.ad.interstitial;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.components.core.e.a.h;
import com.kwad.components.core.proxy.g;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bx;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class d extends g {
    private com.kwad.components.ad.interstitial.h.a lo;
    private boolean lp;
    private com.kwad.components.ad.interstitial.g.b lq;

    @NonNull
    private final KsAdVideoPlayConfig lr;
    private KsInterstitialAd.AdInteractionListener ls;
    private final com.kwad.components.core.widget.g lt;
    private final AdResultData mAdResultData;
    private final AdTemplate mAdTemplate;
    public long mStartRenderTime;
    private bx mTimerHelper;

    public d(@NonNull Activity activity, @NonNull AdResultData adResultData, KsVideoPlayConfig ksVideoPlayConfig, KsInterstitialAd.AdInteractionListener adInteractionListener) {
        super(activity);
        this.mStartRenderTime = -1L;
        this.lt = new com.kwad.components.core.widget.g() { // from class: com.kwad.components.ad.interstitial.d.1
            @Override // com.kwad.components.core.widget.g
            public final void k(boolean z) {
                if (d.this.lp) {
                    Activity activity2 = d.this.mActivity;
                    com.kwad.sdk.core.c.b.LW();
                    if (activity2 == com.kwad.sdk.core.c.b.getCurrentActivity()) {
                        com.kwad.sdk.core.adlog.c.m(d.this.mAdTemplate, z ? 2 : 1);
                        d.this.dE();
                    }
                }
            }
        };
        this.mStartRenderTime = SystemClock.elapsedRealtime();
        this.ls = adInteractionListener;
        this.lr = new KsAdVideoPlayConfig.Builder().videoSoundEnable(ksVideoPlayConfig != null && ksVideoPlayConfig.isVideoSoundEnable()).dataFlowAutoStart(com.kwad.components.ad.interstitial.b.b.dO()).build();
        this.mAdResultData = adResultData;
        this.mAdTemplate = com.kwad.sdk.core.response.helper.c.r(adResultData);
    }

    private static boolean dD() {
        return com.kwad.sdk.core.config.e.La();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dE() {
        if (dD()) {
            this.lo = new com.kwad.components.ad.interstitial.aggregate.c(this.mContext);
        } else if (e(this.mAdResultData)) {
            this.lo = new com.kwad.components.ad.interstitial.aggregate.b(this.mContext);
        } else {
            this.lo = new com.kwad.components.ad.interstitial.h.c(this.mContext);
        }
        this.lo.a(this.mAdResultData, this, this.lr, this.ls, 0);
        this.DY.removeAllViews();
        this.DY.addView(this.lo);
        dF();
    }

    private void dF() {
        com.kwad.components.ad.interstitial.g.b bVar = new com.kwad.components.ad.interstitial.g.b(this.lo, 100);
        this.lq = bVar;
        bVar.a(new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.interstitial.d.2
            @Override // com.kwad.sdk.core.j.c
            public final void bA() {
                d.this.getTimerHelper().Xf();
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                d.this.getTimerHelper().Xe();
            }
        });
        this.lq.Aa();
    }

    private static boolean e(AdResultData adResultData) {
        return com.kwad.sdk.core.response.helper.c.u(adResultData);
    }

    @Override // com.kwad.components.core.proxy.g
    public final float dB() {
        return 0.0f;
    }

    @Override // com.kwad.components.core.proxy.g
    public final ViewGroup dC() {
        com.kwad.components.core.widget.f fVar = new com.kwad.components.core.widget.f(this.mContext);
        fVar.setOrientationChangeListener(this.lt);
        return fVar;
    }

    @Override // com.kwad.components.core.proxy.g, android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        try {
            super.dismiss();
            com.kwad.sdk.a.a.c.Hl().Ho();
            KsInterstitialAd.AdInteractionListener adInteractionListener = this.ls;
            if (adInteractionListener != null) {
                adInteractionListener.onPageDismiss();
            }
            com.kwad.components.ad.interstitial.h.a aVar = this.lo;
            if ((aVar instanceof com.kwad.components.ad.interstitial.h.c) && !((com.kwad.components.ad.interstitial.h.c) aVar).fk() && com.kwad.sdk.core.response.helper.a.cZ(com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate))) {
                com.kwad.sdk.core.adlog.c.q(this.mAdTemplate, (int) Math.ceil(getTimerHelper().getTime() / 1000.0f));
            }
            h.pB();
            com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.e.bA(this.mAdTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.g
    public final void g(View view) {
        h.a(getWindow());
        dE();
        com.kwad.components.ad.interstitial.report.c.eZ().E(this.mAdTemplate);
        com.kwad.sdk.commercial.convert.c.ch(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.g
    public final int getLayoutId() {
        return 0;
    }

    public final bx getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bx();
        }
        return this.mTimerHelper;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        if (com.kwad.components.ad.interstitial.b.b.dS()) {
            super.onBackPressed();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.kwad.components.ad.interstitial.g.b bVar = this.lq;
        if (bVar != null) {
            bVar.release();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.lp = z;
        com.kwad.components.ad.interstitial.h.a aVar = this.lo;
        if (aVar != null) {
            if (z) {
                aVar.dH();
            } else {
                aVar.dI();
            }
        }
    }

    public final void setAdInteractionListener(KsInterstitialAd.AdInteractionListener adInteractionListener) {
        this.ls = adInteractionListener;
        com.kwad.components.ad.interstitial.h.a aVar = this.lo;
        if (aVar != null) {
            aVar.setAdInteractionListener(adInteractionListener);
        }
    }
}
