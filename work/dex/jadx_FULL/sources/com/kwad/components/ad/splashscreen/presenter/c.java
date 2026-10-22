package com.kwad.components.ad.splashscreen.presenter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.ad.splashscreen.local.SplashSkipViewModel;
import com.kwad.components.ad.splashscreen.widget.SkipView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.br;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.by;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends e implements com.kwad.sdk.core.j.c {
    private TextView Hu;
    private com.kwad.components.ad.splashscreen.widget.b Hv;
    private AdInfo.AdPreloadInfo Hw;
    private boolean Hx = false;
    private View Hy;
    private AdInfo wx;

    private SplashSkipViewModel mw() {
        SplashSkipViewModel splashSkipViewModel = new SplashSkipViewModel();
        AdInfo adInfo = this.wx;
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        int i = adSplashInfo.imageDisplaySecond;
        if (i <= 0) {
            i = 5;
        }
        int iMin = Math.min(adSplashInfo.videoDisplaySecond, com.kwad.sdk.core.response.helper.a.N(adInfo));
        if (com.kwad.sdk.core.response.helper.a.bi(this.wx)) {
            i = iMin;
        }
        splashSkipViewModel.skipSecond = i;
        return splashSkipViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mx() {
        com.kwad.components.ad.splashscreen.monitor.a.mt().ao(this.HC.mAdTemplate);
        this.HC.mo();
        JSONObject jSONObject = new JSONObject();
        com.kwad.components.ad.splashscreen.d.a aVar = this.HC.GN;
        if (aVar != null) {
            try {
                jSONObject.put("duration", aVar.getCurrentPosition());
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
        bx bxVar = this.HC.mTimerHelper;
        if (bxVar != null) {
            c1273a.duration = bxVar.getTime();
        }
        com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, new com.kwad.sdk.core.adlog.c.b().ed(1).el(22).b(c1273a), jSONObject);
    }

    private synchronized void mz() {
        if (!this.Hx && this.Hv != null) {
            if (com.kwad.sdk.core.response.helper.a.cK(this.wx) && com.kwad.sdk.core.response.helper.a.cL(this.wx)) {
                com.kwad.sdk.core.adlog.c.b(this.HC.mAdTemplate, 124, (JSONObject) null);
                this.Hx = true;
            }
        }
    }

    private void u(AdInfo adInfo) {
        findViewById(com.kwad.components.ad.splashscreen.e.c.A(adInfo) ? R.id.ksad_splash_right_top_root : R.id.ksad_splash_left_top_root).setVisibility(0);
    }

    private static boolean v(AdInfo adInfo) {
        return !com.kwad.sdk.core.response.helper.a.cI(adInfo);
    }

    private void w(AdInfo adInfo) {
        this.Hu = (TextView) findViewById(com.kwad.components.ad.splashscreen.e.c.A(adInfo) ? R.id.ksad_splash_preload_right_tips : R.id.ksad_splash_preload_left_tips);
        AdInfo.AdPreloadInfo adPreloadInfo = adInfo.adPreloadInfo;
        this.Hw = adPreloadInfo;
        if (adPreloadInfo == null || br.isNullString(adPreloadInfo.preloadTips)) {
            this.Hu.setVisibility(8);
        } else {
            this.Hu.setVisibility(0);
            this.Hu.setText(this.Hw.preloadTips);
        }
    }

    private void x(AdInfo adInfo) {
        this.Hy = findViewById(R.id.ksad_skip_view_area);
        if (!com.kwad.sdk.core.response.helper.a.cJ(adInfo) || adInfo.adSplashInfo.skipButtonPosition != 0) {
            this.Hy.setVisibility(8);
            return;
        }
        this.Hy.setVisibility(0);
        this.Hy.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.presenter.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.this.mx();
            }
        });
        this.Hy.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                ((View) c.this.Hv).post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.c.3.1
                    @Override // com.kwad.sdk.utils.bi
                    public final void doTask() {
                        int iAA = c.this.Hv.aA(35);
                        ViewGroup.LayoutParams layoutParams = c.this.Hy.getLayoutParams();
                        layoutParams.width = iAA + com.kwad.sdk.c.a.a.a(c.this.HC.mRootContainer.getContext(), 66.0f);
                        c.this.Hy.setLayoutParams(layoutParams);
                    }
                });
            }
        });
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    @SuppressLint({"SetTextI18n"})
    public final void ay() {
        super.ay();
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onBind");
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate);
        this.wx = adInfoEO;
        u(adInfoEO);
        w(this.wx);
        if (v(this.wx)) {
            this.Hv = (com.kwad.components.ad.splashscreen.widget.b) findViewById(com.kwad.components.ad.splashscreen.e.c.A(this.wx) ? R.id.ksad_splash_skip_right_view : R.id.ksad_splash_skip_left_view);
        } else {
            this.Hv = (com.kwad.components.ad.splashscreen.widget.b) findViewById(com.kwad.components.ad.splashscreen.e.c.A(this.wx) ? R.id.ksad_splash_circle_skip_right_view : R.id.ksad_splash_circle_skip_left_view);
        }
        this.Hv.a(mw(), this.wx);
        this.Hv.setOnViewListener(new SkipView.a() { // from class: com.kwad.components.ad.splashscreen.presenter.c.1
            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void ay(int i) {
                c.this.HC.ax(i);
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void mA() {
                c.this.mx();
            }

            @Override // com.kwad.components.ad.splashscreen.widget.SkipView.a
            public final void mB() {
                c.this.my();
            }
        });
        x(this.wx);
        this.HC.GP.a(this);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bA() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageInvisible");
        this.Hv.B(this.wx);
    }

    @Override // com.kwad.sdk.core.j.c
    public final void bz() {
        com.kwad.sdk.core.d.c.d("SkipAdPresenter", "onPageVisible");
        this.Hv.C(this.wx);
        mz();
    }

    public final void my() {
        this.HC.mRootContainer.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.c.5
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (com.kwad.components.core.e.c.b.pG()) {
                    c.this.HC.mRootContainer.postDelayed(this, 1000L);
                } else {
                    c.this.HC.mm();
                }
            }
        });
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.HC.GP.b(this);
        by.postOnUiThread(new Runnable() { // from class: com.kwad.components.ad.splashscreen.presenter.c.4
            @Override // java.lang.Runnable
            public final void run() {
                if (c.this.Hv != null) {
                    c.this.Hv.cw();
                }
            }
        });
    }
}
