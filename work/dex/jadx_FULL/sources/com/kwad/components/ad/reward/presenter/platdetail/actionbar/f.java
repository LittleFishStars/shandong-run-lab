package com.kwad.components.ad.reward.presenter.platdetail.actionbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.SystemClock;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.e.g;
import com.kwad.components.ad.reward.k.q;
import com.kwad.components.core.playable.PlayableSource;
import com.kwad.components.core.t.x;
import com.kwad.components.core.webview.jshandler.ac;
import com.kwad.components.core.webview.jshandler.ae;
import com.kwad.components.core.webview.jshandler.af;
import com.kwad.components.core.webview.jshandler.ai;
import com.kwad.components.core.webview.jshandler.ak;
import com.kwad.components.core.webview.jshandler.al;
import com.kwad.components.core.webview.jshandler.am;
import com.kwad.components.core.webview.jshandler.as;
import com.kwad.components.core.webview.jshandler.az;
import com.kwad.components.core.webview.jshandler.bc;
import com.kwad.components.core.webview.jshandler.n;
import com.kwad.components.core.webview.jshandler.o;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class f extends com.kwad.components.ad.reward.presenter.b {

    @Nullable
    private KsAdWebView ff;
    private al.a fg;
    private com.kwad.components.core.webview.a fh;
    private com.kwad.sdk.core.webview.b fi;
    private az fk;
    private ValueAnimator fp;
    private ValueAnimator fq;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private String mUrl;
    private RewardActionBarControl sB;
    private KsLogoView wL;
    private boolean zs;
    private long zt;
    private int fj = -1;
    private RewardActionBarControl.d za = new RewardActionBarControl.d() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.1
        @Override // com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl.d
        public final boolean f(a aVar) {
            f fVar = f.this;
            fVar.zs = fVar.f(aVar);
            return f.this.zs;
        }
    };
    private g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.2
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            f.this.release();
        }
    };
    private com.kwad.sdk.core.webview.d.a.a fl = new com.kwad.sdk.core.webview.d.a.a() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.3
        @Override // com.kwad.sdk.core.webview.d.a.a
        public final void a(com.kwad.sdk.core.webview.d.b.a aVar) {
            f.this.uj.sy.dc();
        }
    };
    private al.b fm = new al.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.5
        @Override // com.kwad.components.core.webview.jshandler.al.b
        public final void a(al.a aVar) {
            f.this.fg = aVar;
            f.this.ff.setTranslationY(aVar.height + aVar.bottomMargin);
        }
    };
    private ak.b fn = new ak.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.6
        @Override // com.kwad.components.core.webview.jshandler.ak.b
        public final void a(ak.a aVar) {
            f.this.zs = false;
            f.this.bp();
        }
    };
    private as.b fo = new as.b() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.7
        @Override // com.kwad.components.core.webview.jshandler.as.b
        public final void a(as.a aVar) {
            f.this.fj = aVar.status;
            long jElapsedRealtime = SystemClock.elapsedRealtime() - f.this.zt;
            com.kwad.sdk.core.d.c.i("RewardActionBarWeb", "load time:" + jElapsedRealtime + ", pageStatus: " + f.this.fj);
            if (f.this.fj == 1) {
                com.kwad.components.core.p.a.vL().i(f.this.uj.mAdTemplate, jElapsedRealtime);
            } else {
                com.kwad.components.ad.reward.monitor.d.a(f.this.uj.mAdTemplate, f.this.uj.sO, "play_card", com.kwad.sdk.core.response.helper.b.cV(f.this.uj.mAdTemplate), System.currentTimeMillis() - f.this.ff.getLoadTime(), 3);
            }
            if (f.this.uj.gY()) {
                return;
            }
            f.this.sB.jC();
        }
    };

    private void ab(AdTemplate adTemplate) {
        KsLogoView ksLogoView;
        if (!com.kwad.sdk.core.response.helper.a.cS(com.kwad.sdk.core.response.helper.e.eO(adTemplate)) || com.kwad.sdk.utils.as.isOrientationPortrait() || (ksLogoView = this.wL) == null) {
            return;
        }
        ksLogoView.setVisibility(0);
    }

    private void bi() {
        com.kwad.sdk.core.webview.b bVar = new com.kwad.sdk.core.webview.b();
        this.fi = bVar;
        bVar.setAdTemplate(this.uj.mAdTemplate);
        com.kwad.sdk.core.webview.b bVar2 = this.fi;
        com.kwad.components.ad.reward.g gVar = this.uj;
        bVar2.mScreenOrientation = gVar.mScreenOrientation;
        AdBaseFrameLayout adBaseFrameLayout = gVar.mRootContainer;
        bVar2.bbV = adBaseFrameLayout;
        bVar2.adW = adBaseFrameLayout;
        bVar2.ade = this.ff;
    }

    private void bj() {
        this.fj = -1;
        bk();
        this.ff.setBackgroundColor(0);
        this.ff.getBackground().setAlpha(0);
        this.ff.setVisibility(4);
        this.ff.setClientConfig(this.ff.getClientConfig().fo(this.uj.mAdTemplate).b(jG()));
        this.zt = SystemClock.elapsedRealtime();
        this.mUrl = com.kwad.sdk.core.response.helper.b.cV(this.uj.mAdTemplate);
        com.kwad.sdk.core.d.c.d("RewardActionBarWeb", "startPreloadWebView url: " + this.mUrl);
        com.kwad.components.ad.reward.g gVar = this.uj;
        com.kwad.components.ad.reward.monitor.d.a(gVar.mAdTemplate, gVar.sO, "play_card", this.mUrl);
        this.ff.loadUrl(this.mUrl);
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface", "JavascriptInterface"})
    private void bk() {
        bl();
        com.kwad.components.core.webview.a aVar = new com.kwad.components.core.webview.a(this.ff);
        this.fh = aVar;
        a(aVar);
        this.ff.addJavascriptInterface(this.fh, "KwaiAd");
    }

    private void bl() {
        com.kwad.components.core.webview.a aVar = this.fh;
        if (aVar != null) {
            aVar.destroy();
            this.fh = null;
        }
    }

    private void bo() {
        ab(this.uj.mAdTemplate);
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yx();
        }
        this.ff.setVisibility(0);
        az azVar2 = this.fk;
        if (azVar2 != null) {
            azVar2.yy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bp() {
        if (this.ff.getVisibility() != 0) {
            return;
        }
        if (this.fg == null) {
            bq();
            return;
        }
        br();
        KsAdWebView ksAdWebView = this.ff;
        al.a aVar = this.fg;
        ValueAnimator valueAnimatorC = x.c(ksAdWebView, 0, aVar.height + aVar.bottomMargin);
        this.fq = valueAnimatorC;
        valueAnimatorC.setInterpolator(new DecelerateInterpolator(2.0f));
        this.fq.setDuration(300L);
        this.fq.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.9
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                f.this.ff.setVisibility(4);
                if (f.this.fk != null) {
                    f.this.fk.yA();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.fk != null) {
                    f.this.fk.yz();
                }
            }
        });
        this.fq.start();
    }

    private void bq() {
        if (this.ff.getVisibility() != 0) {
            return;
        }
        az azVar = this.fk;
        if (azVar != null) {
            azVar.yz();
        }
        this.ff.setVisibility(4);
        az azVar2 = this.fk;
        if (azVar2 != null) {
            azVar2.yA();
        }
    }

    private void br() {
        ValueAnimator valueAnimator = this.fp;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.fp.cancel();
        }
        ValueAnimator valueAnimator2 = this.fq;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
            this.fq.cancel();
        }
    }

    private void bs() {
        String str;
        int i = this.fj;
        if (i == -1) {
            str = com.alipay.sdk.m.o.b.r0;
        } else {
            str = i != 1 ? "h5error" : "others";
        }
        com.kwad.sdk.core.d.c.w("RewardActionBarWeb", "show webCard fail, reason: " + str);
    }

    private void ds() {
        if (this.ff == null || !com.kwad.sdk.core.response.helper.b.cX(this.uj.mAdTemplate)) {
            return;
        }
        this.mApkDownloadHelper = this.uj.mApkDownloadHelper;
        bi();
        bj();
        this.uj.b(this.mPlayEndPageListener);
    }

    private KsAdWebView.e jG() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                com.kwad.components.ad.reward.monitor.d.a(f.this.uj.mAdTemplate, f.this.uj.sO, "play_card", f.this.mUrl, System.currentTimeMillis() - f.this.ff.getLoadTime());
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                com.kwad.components.ad.reward.monitor.d.a(f.this.uj.mAdTemplate, f.this.uj.sO, "play_card", com.kwad.sdk.core.response.helper.b.cV(f.this.uj.mAdTemplate), System.currentTimeMillis() - f.this.ff.getLoadTime(), 2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        this.fj = -1;
        KsAdWebView ksAdWebView = this.ff;
        if (ksAdWebView != null) {
            ksAdWebView.setVisibility(8);
        }
        bl();
    }

    @Override // com.kwad.components.ad.reward.presenter.b, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        com.kwad.components.ad.reward.g gVar = this.uj;
        com.kwad.components.ad.reward.monitor.d.a(gVar.mAdTemplate, gVar.sO, "play_card");
        RewardActionBarControl rewardActionBarControl = this.uj.sB;
        this.sB = rewardActionBarControl;
        rewardActionBarControl.a(this.za);
        ds();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ff = (KsAdWebView) findViewById(R.id.ksad_play_web_card_webView);
        this.wL = (KsLogoView) findViewById(R.id.ksad_ad_label_play_bar);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        RewardActionBarControl rewardActionBarControl = this.sB;
        if (rewardActionBarControl != null) {
            rewardActionBarControl.a((RewardActionBarControl.d) null);
        }
        this.uj.c(this.mPlayEndPageListener);
        br();
        release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(a aVar) {
        KsAdWebView ksAdWebView = this.ff;
        if (ksAdWebView == null) {
            return false;
        }
        if (ksAdWebView.getVisibility() == 0) {
            return true;
        }
        if (this.fj == 1) {
            g(aVar);
            return true;
        }
        bs();
        return false;
    }

    private void g(final a aVar) {
        if (this.fg == null) {
            bo();
            return;
        }
        ab(this.uj.mAdTemplate);
        br();
        this.ff.setVisibility(0);
        KsAdWebView ksAdWebView = this.ff;
        al.a aVar2 = this.fg;
        ValueAnimator valueAnimatorC = x.c(ksAdWebView, aVar2.height + aVar2.bottomMargin, 0);
        this.fp = valueAnimatorC;
        valueAnimatorC.setInterpolator(new DecelerateInterpolator(2.0f));
        this.fp.setDuration(500L);
        this.fp.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.reward.presenter.platdetail.actionbar.f.8
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (f.this.fk != null) {
                    f.this.fk.yy();
                }
                a aVar3 = aVar;
                if (aVar3 != null) {
                    aVar3.a(RewardActionBarControl.ShowActionBarResult.SHOW_H5_SUCCESS, f.this.ff);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                if (f.this.fk != null) {
                    f.this.fk.yx();
                }
            }
        });
        this.fp.start();
    }

    private void a(com.kwad.components.core.webview.a aVar) {
        aVar.a(new ac(this.fi, this.mApkDownloadHelper, this.fl, (byte) 0));
        aVar.a(new com.kwad.components.core.webview.tachikoma.b.f());
        aVar.a(new q(this.fi, this.mApkDownloadHelper, this.uj, -1L, this.fl, null));
        aVar.a(new af(this.fi));
        aVar.a(new ai(this.fi));
        aVar.a(new ae(this.fi));
        aVar.a(new al(this.fi, this.fm));
        aVar.a(new as(this.fo, com.kwad.sdk.core.response.helper.b.cV(this.uj.mAdTemplate)));
        az azVar = new az();
        this.fk = azVar;
        aVar.a(azVar);
        aVar.a(new bc(this.fi, this.mApkDownloadHelper));
        aVar.a(new ak(this.fn));
        aVar.a(new am(this.fi));
        aVar.b(new o(this.fi));
        aVar.b(new n(this.fi));
        aVar.a(new com.kwad.components.ad.reward.i.b(getContext(), this.uj.mAdTemplate, PlayableSource.ACTIONBAR_CLICK));
    }
}
