package com.kwad.components.ad.draw.view.playcard;

import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.draw.view.DrawDownloadProgressBar;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.e.d.d;
import com.kwad.components.core.t.x;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class DrawCardApp extends FrameLayout implements View.OnClickListener {
    private KsAppDownloadListener en;
    private ViewGroup gA;
    private AppScoreView gB;
    private TextView gC;
    private TextView gD;
    private KsLogoView gE;
    private DrawDownloadProgressBar gF;
    private ValueAnimator gG;
    private a gw;
    private ImageView gx;
    private ImageView gy;
    private TextView gz;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private d mApkDownloadHelper;
    private int mHeight;

    public interface a {
        void bg();

        void bh();
    }

    public DrawCardApp(Context context) {
        super(context);
        B(context);
    }

    private void B(Context context) {
        m.inflate(context, R.layout.ksad_draw_card_app, this);
        this.gx = (ImageView) findViewById(R.id.ksad_card_app_close);
        this.gy = (ImageView) findViewById(R.id.ksad_card_app_icon);
        this.gz = (TextView) findViewById(R.id.ksad_card_app_name);
        this.gA = (ViewGroup) findViewById(R.id.ksad_card_app_score_container);
        this.gB = (AppScoreView) findViewById(R.id.ksad_card_app_score);
        this.gC = (TextView) findViewById(R.id.ksad_card_app_download_count);
        this.gD = (TextView) findViewById(R.id.ksad_card_app_desc);
        this.gE = (KsLogoView) findViewById(R.id.ksad_card_logo);
        DrawDownloadProgressBar drawDownloadProgressBar = (DrawDownloadProgressBar) findViewById(R.id.ksad_card_app_download_btn);
        this.gF = drawDownloadProgressBar;
        drawDownloadProgressBar.setTextSize(16);
        this.mHeight = com.kwad.sdk.c.a.a.a(context, 156.0f);
    }

    private void br() {
        ValueAnimator valueAnimator = this.gG;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.gG.cancel();
        }
    }

    private void ca() {
        d(this.mHeight, 0);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.en == null) {
            this.en = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    DrawCardApp.this.gF.e(com.kwad.sdk.core.response.helper.a.aK(DrawCardApp.this.mAdInfo), DrawCardApp.this.gF.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    DrawCardApp.this.gF.e(com.kwad.sdk.core.response.helper.a.cK(DrawCardApp.this.mAdTemplate), DrawCardApp.this.gF.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    DrawCardApp.this.gF.e(com.kwad.sdk.core.response.helper.a.aK(DrawCardApp.this.mAdInfo), DrawCardApp.this.gF.getMax());
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    DrawCardApp.this.gF.e(com.kwad.sdk.core.response.helper.a.af(DrawCardApp.this.mAdInfo), DrawCardApp.this.gF.getMax());
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    super.onPaused(i);
                    DrawCardApp.this.gF.e(com.kwad.sdk.core.response.helper.a.Nx(), i);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    DrawCardApp.this.gF.e(i + "%", i);
                }
            };
        }
        return this.en;
    }

    public final void bZ() {
        d(0, this.mHeight);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view != this.gx) {
            com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(getContext()).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).as(view == this.gF).aN(view == this.gF ? 1 : 2).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.draw.view.playcard.DrawCardApp.2
                @Override // com.kwad.components.core.e.d.a.b
                public final void onAdClicked() {
                    if (DrawCardApp.this.gw != null) {
                        DrawCardApp.this.gw.bh();
                    }
                }
            }));
            return;
        }
        ca();
        a aVar = this.gw;
        if (aVar != null) {
            aVar.bg();
        }
    }

    public final void release() {
        br();
        this.mApkDownloadHelper = null;
    }

    private void d(int i, int i2) {
        br();
        ValueAnimator valueAnimatorB = x.b(this, i, i2);
        this.gG = valueAnimatorB;
        valueAnimatorB.setInterpolator(new DecelerateInterpolator(2.0f));
        this.gG.setDuration(300L);
        this.gG.start();
    }

    public final void a(@NonNull AdTemplate adTemplate, a aVar) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.eO(adTemplate);
        this.gw = aVar;
        this.mApkDownloadHelper = new d(this.mAdTemplate, getAppDownloadListener());
        KSImageLoader.loadAppIcon(this.gy, com.kwad.sdk.core.response.helper.a.cv(this.mAdInfo), adTemplate, 11);
        this.gz.setText(com.kwad.sdk.core.response.helper.a.aB(this.mAdInfo));
        String strAF = com.kwad.sdk.core.response.helper.a.aF(this.mAdInfo);
        float fAG = com.kwad.sdk.core.response.helper.a.aG(this.mAdInfo);
        boolean z = fAG >= 3.0f;
        if (z) {
            this.gB.setScore(fAG);
            this.gB.setVisibility(0);
        }
        boolean z2 = !TextUtils.isEmpty(strAF);
        if (z2) {
            this.gC.setText(strAF);
            this.gC.setVisibility(0);
        }
        if (z || z2) {
            this.gA.setVisibility(0);
        } else {
            this.gA.setVisibility(8);
        }
        this.gE.bl(this.mAdTemplate);
        this.gD.setText(com.kwad.sdk.core.response.helper.a.aA(this.mAdInfo));
        this.gx.setOnClickListener(this);
        this.gF.setOnClickListener(this);
        setOnClickListener(this);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        B(context);
    }

    public DrawCardApp(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        B(context);
    }
}
