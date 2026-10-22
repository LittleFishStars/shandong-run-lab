package com.kwad.components.ad.reward.widget.actionbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.widget.AppScoreView;
import com.kwad.components.core.page.widget.TextProgressBar;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.response.helper.SlideConvertHelper;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.widget.d;
import com.kwad.sdk.widget.h;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class ActionBarAppPortrait extends LinearLayout implements d {
    private AppScoreView FL;
    private TextProgressBar FM;
    private View FN;
    private a FQ;
    private KsAppDownloadListener en;
    private TextView ev;
    private ImageView gQ;
    private TextView gS;
    private TextView ia;
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;

    public interface a {
        void P(boolean z);
    }

    public ActionBarAppPortrait(Context context) {
        this(context, null);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.en == null) {
            this.en = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppPortrait.this.FM.e(com.kwad.sdk.core.response.helper.a.aK(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.FN.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppPortrait.this.FM.e(com.kwad.sdk.core.response.helper.a.cK(ActionBarAppPortrait.this.mAdTemplate), 0);
                    ActionBarAppPortrait.this.FN.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppPortrait.this.FM.e(com.kwad.sdk.core.response.helper.a.aK(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.FN.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppPortrait.this.FM.e(com.kwad.sdk.core.response.helper.a.af(ActionBarAppPortrait.this.mAdInfo), 0);
                    ActionBarAppPortrait.this.FN.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    ActionBarAppPortrait.this.FM.e(com.kwad.sdk.core.response.helper.a.eG(i), i);
                    ActionBarAppPortrait.this.FN.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppPortrait.this.FM.e(com.kwad.sdk.core.response.helper.a.eF(i), i);
                    ActionBarAppPortrait.this.FN.setVisibility(8);
                }
            };
        }
        return this.en;
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_video_actionbar_app_portrait, this);
        this.gQ = (ImageView) findViewById(R.id.ksad_app_icon);
        this.ev = (TextView) findViewById(R.id.ksad_app_title);
        this.ia = (TextView) findViewById(R.id.ksad_app_desc);
        this.FL = (AppScoreView) findViewById(R.id.ksad_app_score);
        this.gS = (TextView) findViewById(R.id.ksad_app_download_count);
        TextProgressBar textProgressBar = (TextProgressBar) findViewById(R.id.ksad_app_download_btn);
        this.FM = textProgressBar;
        textProgressBar.setTextDimen(com.kwad.sdk.c.a.a.a(getContext(), 16.0f));
        this.FM.setTextColor(-1);
        this.FN = findViewById(R.id.ksad_download_bar_cover);
    }

    private void lM() {
        String strAF = com.kwad.sdk.core.response.helper.a.aF(this.mAdInfo);
        boolean z = !TextUtils.isEmpty(strAF);
        float fAG = com.kwad.sdk.core.response.helper.a.aG(this.mAdInfo);
        boolean z2 = fAG >= 3.0f;
        if (z && z2) {
            ((LinearLayout.LayoutParams) this.ev.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            ((LinearLayout.LayoutParams) this.FL.getLayoutParams()).bottomMargin = com.kwad.sdk.c.a.a.a(getContext(), 1.0f);
            this.gS.setText(strAF);
            this.gS.setVisibility(0);
            this.FL.setVisibility(0);
            this.FL.setScore(fAG);
            this.ia.setVisibility(8);
            return;
        }
        if (z) {
            this.gS.setText(strAF);
            this.gS.setVisibility(0);
            this.FL.setVisibility(8);
            this.ia.setVisibility(8);
            return;
        }
        if (z2) {
            this.gS.setVisibility(8);
            this.FL.setScore(fAG);
            this.FL.setVisibility(0);
            this.ia.setVisibility(8);
            return;
        }
        this.ia.setText(com.kwad.sdk.core.response.helper.a.aA(this.mAdInfo));
        this.gS.setVisibility(8);
        this.FL.setVisibility(8);
        this.ia.setVisibility(0);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void d(View view, final boolean z) {
        int i = view == this.FN ? 1 : 2;
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(view.getContext()).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).aL(1).aM(i).as(view == this.FM).aN(i).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppPortrait.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppPortrait.this.FQ != null) {
                    ActionBarAppPortrait.this.FQ.P(z);
                }
            }
        }));
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.d dVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEO = e.eO(adTemplate);
        this.mAdInfo = adInfoEO;
        this.FQ = aVar;
        this.mApkDownloadHelper = dVar;
        KSImageLoader.loadAppIcon(this.gQ, com.kwad.sdk.core.response.helper.a.cv(adInfoEO), adTemplate, 12);
        this.ev.setText(com.kwad.sdk.core.response.helper.a.cs(this.mAdInfo));
        lM();
        this.FM.e(com.kwad.sdk.core.response.helper.a.aK(this.mAdInfo), 0);
        com.kwad.components.core.e.d.d dVar2 = this.mApkDownloadHelper;
        if (dVar2 != null) {
            dVar2.b(getAppDownloadListener());
        }
        setClickable(true);
        new h(this, this);
        new h(this.FN, this);
    }

    public ActionBarAppPortrait(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView();
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        d(view, true);
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view, float f, float f2, float f3, float f4) {
        if (SlideConvertHelper.a(this.mAdTemplate, f, f2, f3, f4)) {
            d(view, false);
        }
    }
}
