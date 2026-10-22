package com.kwad.components.ad.draw.presenter;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.core.t.x;
import com.kwad.components.core.video.l;
import com.kwad.components.core.video.m;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.ad.draw.b.a implements View.OnClickListener {
    private ViewGroup ee;
    private TextView ef;
    private TextView eg;
    private TextView eh;
    private DrawDownloadProgressBar ei;
    private ValueAnimator ej;
    private int ek;
    private int el;
    private int em;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    @Nullable
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private KsLogoView mLogoView;
    private l mVideoPlayStateListener = new m() { // from class: com.kwad.components.ad.draw.presenter.c.1
        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayProgress(long j, long j2) {
            if (j2 >= c.this.em * 1000) {
                c.this.dQ.dV.ba();
            } else if (j2 >= c.this.el * 1000) {
                c.this.aX();
            } else if (j2 >= c.this.ek * 1000) {
                c.this.aV();
            }
        }

        @Override // com.kwad.components.core.video.m, com.kwad.components.core.video.i
        public final void onMediaPlayStart() {
        }
    };
    private KsAppDownloadListener en = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.presenter.c.2
        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFailed() {
            c.this.eh.setText(com.kwad.sdk.core.response.helper.a.aK(c.this.mAdInfo));
            c.this.ei.e(com.kwad.sdk.core.response.helper.a.aK(c.this.mAdInfo), c.this.ei.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onDownloadFinished() {
            c.this.eh.setText(com.kwad.sdk.core.response.helper.a.cK(c.this.mAdTemplate));
            c.this.ei.e(com.kwad.sdk.core.response.helper.a.cK(c.this.mAdTemplate), c.this.ei.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onIdle() {
            c.this.eh.setText(com.kwad.sdk.core.response.helper.a.aK(c.this.mAdInfo));
            c.this.ei.e(com.kwad.sdk.core.response.helper.a.aK(c.this.mAdInfo), c.this.ei.getMax());
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onInstalled() {
            c.this.eh.setText(com.kwad.sdk.core.response.helper.a.af(c.this.mAdInfo));
            c.this.ei.e(com.kwad.sdk.core.response.helper.a.af(c.this.mAdInfo), c.this.ei.getMax());
        }

        @Override // com.kwad.sdk.core.download.a.a
        public final void onPaused(int i) {
            super.onPaused(i);
            c.this.eh.setText(com.kwad.sdk.core.response.helper.a.Nx());
            c.this.ei.e(com.kwad.sdk.core.response.helper.a.Nx(), i);
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public final void onProgressUpdate(int i) {
            c.this.eh.setText(i + "%");
            c.this.ei.e(i + "%", i);
        }
    };

    private void aU() {
        this.ek = com.kwad.sdk.core.response.helper.a.bx(this.mAdInfo);
        this.el = com.kwad.sdk.core.response.helper.a.by(this.mAdInfo);
        this.em = com.kwad.sdk.core.response.helper.a.bz(this.mAdInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV() {
        if (this.eh.getVisibility() == 0 || this.ei.getVisibility() == 0) {
            return;
        }
        this.eh.setOnClickListener(this);
        this.eh.setVisibility(0);
        TextView textView = this.eh;
        ValueAnimator valueAnimatorB = x.b(textView, 0, com.kwad.sdk.c.a.a.a(textView.getContext(), 44.0f));
        this.ej = valueAnimatorB;
        valueAnimatorB.setInterpolator(new DecelerateInterpolator(2.0f));
        this.ej.setDuration(300L);
        this.ej.start();
    }

    private void aW() {
        ValueAnimator valueAnimator = this.ej;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.ej.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aX() {
        if (this.ei.getVisibility() == 0) {
            return;
        }
        this.ei.setOnClickListener(this);
        this.ei.setVisibility(0);
        this.eh.setVisibility(8);
    }

    @Override // com.kwad.components.ad.draw.b.a, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        super.ay();
        AdTemplate adTemplate = this.dQ.mAdTemplate;
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eO(adTemplate);
        this.mApkDownloadHelper = this.dQ.mApkDownloadHelper;
        aU();
        this.mLogoView.bl(this.mAdTemplate);
        this.eh.setText(com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo));
        this.eh.setVisibility(8);
        this.ei.e(com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo), this.ei.getMax());
        this.ei.setVisibility(8);
        this.ee.setVisibility(0);
        this.ee.setOnClickListener(this);
        if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            this.ef.setText(com.kwad.sdk.core.response.helper.a.aB(this.mAdInfo));
            this.ef.setVisibility(0);
            com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
            if (dVar != null) {
                dVar.b(this.en);
            }
        } else {
            this.ef.setVisibility(8);
        }
        this.eg.setText(com.kwad.sdk.core.response.helper.a.aA(this.mAdInfo));
        this.dQ.dS.b(this.mVideoPlayStateListener);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.ee) {
            aX();
            a(false, 2);
        } else if (view == this.eh) {
            aX();
            a(true, 1);
        } else if (view == this.ei) {
            a(true, 1);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        this.ee = (ViewGroup) findViewById(R.id.ksad_ad_normal_container);
        this.ef = (TextView) findViewById(R.id.ksad_ad_normal_title);
        this.eg = (TextView) findViewById(R.id.ksad_ad_normal_des);
        this.mLogoView = (KsLogoView) findViewById(R.id.ksad_ad_normal_logo);
        this.eh = (TextView) findViewById(R.id.ksad_ad_normal_convert_btn);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_ad_light_convert_btn);
        this.ei = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        KsAppDownloadListener ksAppDownloadListener;
        super.onUnbind();
        aW();
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar != null && (ksAppDownloadListener = this.en) != null) {
            dVar.c(ksAppDownloadListener);
        }
        this.dQ.dS.a(this.mVideoPlayStateListener);
    }

    private void a(boolean z, int i) {
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(this.ee.getContext()).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).aN(i).as(z).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.draw.presenter.c.3
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                com.kwad.sdk.core.adlog.c.a(c.this.mAdTemplate, 1, c.this.dQ.mRootContainer.getTouchCoords());
                if (c.this.dQ.dB != null) {
                    c.this.dQ.dB.onAdClicked();
                }
            }
        }));
    }
}
