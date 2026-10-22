package com.kwad.components.ad.splashscreen.presenter;

import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.utils.bi;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class b extends e {
    private KsLogoView mLogoView;

    /* JADX INFO: Access modifiers changed from: private */
    public void k(ViewGroup viewGroup) {
        if (!com.kwad.components.ad.splashscreen.e.c.A(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate))) {
            if (com.kwad.components.ad.splashscreen.e.c.a(getContext(), this.HC.mRootContainer.getWidth(), this.HC.mRootContainer.getHeight())) {
                com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_splash_logo_container), -1, 16, 16, -1);
            }
            if (com.kwad.sdk.core.response.helper.a.dv(com.kwad.sdk.core.response.helper.e.eO(this.HC.mAdTemplate))) {
                com.kwad.components.ad.splashscreen.e.c.a(findViewById(R.id.ksad_splash_logo_container), -1, 34, 16, -1);
                return;
            }
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        layoutParams.gravity = 51;
        viewGroup.setLayoutParams(layoutParams);
        DisplayMetrics displayMetrics = viewGroup.getContext().getResources().getDisplayMetrics();
        if (((double) displayMetrics.heightPixels) / ((double) displayMetrics.widthPixels) > 1.7777777910232544d) {
            ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams.leftMargin = com.kwad.sdk.c.a.a.a(viewGroup.getContext(), 12.0f);
                marginLayoutParams.topMargin = com.kwad.sdk.c.a.a.a(viewGroup.getContext(), 12.0f);
            }
        }
    }

    @Override // com.kwad.components.ad.splashscreen.presenter.e, com.kwad.sdk.mvp.Presenter
    public final void ay() {
        AdInfo.AdSplashInfo adSplashInfo;
        super.ay();
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.ksad_splash_logo_container);
        this.mLogoView = ksLogoView;
        ksLogoView.post(new bi() { // from class: com.kwad.components.ad.splashscreen.presenter.b.1
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                b bVar = b.this;
                bVar.k(bVar.mLogoView);
            }
        });
        if (this.HC.mAdTemplate.adInfoList.isEmpty() || (adSplashInfo = this.HC.mAdTemplate.adInfoList.get(0).adSplashInfo) == null) {
            return;
        }
        if (adSplashInfo.logoPosition == 0) {
            this.mLogoView.setVisibility(8);
        } else {
            this.mLogoView.setVisibility(0);
            this.mLogoView.bl(this.HC.mAdTemplate);
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }
}
