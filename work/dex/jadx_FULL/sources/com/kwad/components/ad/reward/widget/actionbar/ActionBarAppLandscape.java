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
public class ActionBarAppLandscape extends LinearLayout implements d {
    private AppScoreView FL;
    private TextProgressBar FM;
    private View FN;
    private a FO;
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

    public ActionBarAppLandscape(Context context) {
        this(context, null);
    }

    private KsAppDownloadListener getAppDownloadListener() {
        if (this.en == null) {
            this.en = new com.kwad.sdk.core.download.a.a() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.1
                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFailed() {
                    ActionBarAppLandscape.this.FM.e(com.kwad.sdk.core.response.helper.a.aK(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.FN.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onDownloadFinished() {
                    ActionBarAppLandscape.this.FM.e(com.kwad.sdk.core.response.helper.a.cK(ActionBarAppLandscape.this.mAdTemplate), 0);
                    ActionBarAppLandscape.this.FN.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onIdle() {
                    ActionBarAppLandscape.this.FM.e(com.kwad.sdk.core.response.helper.a.aK(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.FN.setVisibility(0);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onInstalled() {
                    ActionBarAppLandscape.this.FM.e(com.kwad.sdk.core.response.helper.a.af(ActionBarAppLandscape.this.mAdInfo), 0);
                    ActionBarAppLandscape.this.FN.setVisibility(0);
                }

                @Override // com.kwad.sdk.core.download.a.a
                public final void onPaused(int i) {
                    ActionBarAppLandscape.this.FM.e(com.kwad.sdk.core.response.helper.a.eG(i), i);
                    ActionBarAppLandscape.this.FN.setVisibility(8);
                }

                @Override // com.kwad.sdk.api.KsAppDownloadListener
                public final void onProgressUpdate(int i) {
                    ActionBarAppLandscape.this.FM.e(com.kwad.sdk.core.response.helper.a.eF(i), i);
                    ActionBarAppLandscape.this.FN.setVisibility(8);
                }
            };
        }
        return this.en;
    }

    private void initView() {
        m.inflate(getContext(), R.layout.ksad_video_actionbar_app_landscape, this);
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
        float fAG = com.kwad.sdk.core.response.helper.a.aG(this.mAdInfo);
        boolean z = fAG >= 3.0f;
        if (z) {
            this.FL.setScore(fAG);
            this.FL.setVisibility(0);
        }
        String strAF = com.kwad.sdk.core.response.helper.a.aF(this.mAdInfo);
        boolean zIsEmpty = true ^ TextUtils.isEmpty(strAF);
        if (zIsEmpty) {
            this.gS.setText(strAF);
            this.gS.setVisibility(0);
        }
        if (zIsEmpty || z) {
            this.ia.setVisibility(8);
            return;
        }
        this.ia.setText(com.kwad.sdk.core.response.helper.a.aA(this.mAdInfo));
        this.FL.setVisibility(8);
        this.gS.setVisibility(8);
        this.ia.setVisibility(0);
    }

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void d(View view, final boolean z) {
        com.kwad.components.core.e.d.a.a(new com.kwad.components.core.e.d.a.C1201a(view.getContext()).aJ(this.mAdTemplate).b(this.mApkDownloadHelper).as(view == this.FM).aN(view == this.FN ? 1 : 2).a(new com.kwad.components.core.e.d.a.b() { // from class: com.kwad.components.ad.reward.widget.actionbar.ActionBarAppLandscape.2
            @Override // com.kwad.components.core.e.d.a.b
            public final void onAdClicked() {
                if (ActionBarAppLandscape.this.FO != null) {
                    ActionBarAppLandscape.this.FO.P(z);
                }
            }
        }));
    }

    public final void a(@NonNull AdTemplate adTemplate, @Nullable com.kwad.components.core.e.d.d dVar, a aVar) {
        this.mAdTemplate = adTemplate;
        AdInfo adInfoEO = e.eO(adTemplate);
        this.mAdInfo = adInfoEO;
        this.FO = aVar;
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

    public ActionBarAppLandscape(Context context, @Nullable AttributeSet attributeSet, int i) {
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
