package com.kwad.components.core.page.splitLandingPage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.d;
import com.kwad.components.core.page.d.b;
import com.kwad.components.core.page.d.c;
import com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView;
import com.kwad.components.core.proxy.h;
import com.kwad.components.core.t.x;
import com.kwad.components.core.widget.FeedVideoView;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.utils.bi;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a extends h {
    private FeedVideoView adf;
    private LinearLayout adg;
    private SplitScrollWebView afv;
    private Presenter afw;
    private com.kwad.components.core.page.splitLandingPage.view.a afx;
    private b afy;
    private boolean afz;
    private AdTemplate mAdTemplate;
    private d mApkDownloadHelper;

    private void A(View view) {
        this.adg = (LinearLayout) view.findViewById(R.id.ksad_web_tip_bar);
        TextView textView = (TextView) view.findViewById(R.id.ksad_web_tip_bar_textview);
        ((ImageView) view.findViewById(R.id.ksad_web_tip_close_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.core.page.splitLandingPage.a.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                a.this.adg.setVisibility(8);
            }
        });
        AdInfo adInfoEO = e.eO(this.mAdTemplate);
        boolean zBF = com.kwad.sdk.core.response.helper.a.bF(adInfoEO);
        String strBB = com.kwad.sdk.core.response.helper.a.bB(adInfoEO);
        if (!zBF) {
            this.adg.setVisibility(8);
            return;
        }
        this.adg.setVisibility(0);
        textView.setText(strBB);
        textView.setSelected(true);
    }

    public static a aZ(AdTemplate adTemplate) {
        a aVar = new a();
        Bundle bundle = new Bundle();
        bundle.putString("key_photo", adTemplate.toJson().toString());
        bundle.putBoolean("key_report", adTemplate.mPvReported);
        aVar.setArguments(bundle);
        return aVar;
    }

    private void initView() {
        com.kwad.components.core.page.recycle.e eVar = new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null);
        this.afw.q(eVar);
        com.kwad.components.core.page.splitLandingPage.view.a aVar = new com.kwad.components.core.page.splitLandingPage.view.a(this.mContext, new com.kwad.components.core.page.splitLandingPage.a.a(eVar.adTemplate, eVar.QS));
        this.afx = aVar;
        aVar.a(new com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC1223a() { // from class: com.kwad.components.core.page.splitLandingPage.a.3
            @Override // com.kwad.components.core.page.splitLandingPage.view.a.InterfaceC1223a
            public final boolean uQ() {
                return a.this.uN();
            }
        });
        this.adf.post(new bi() { // from class: com.kwad.components.core.page.splitLandingPage.a.4
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                a.this.afv.setTranslationY(a.this.afv.getTranslationY() + a.this.adf.getHeight());
            }
        });
        this.afv.setSplitScrollWebViewListener(new SplitScrollWebView.a() { // from class: com.kwad.components.core.page.splitLandingPage.a.5
            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final void g(float f) {
                a.this.afv.setTranslationY(a.this.afv.getTranslationY() - f);
            }

            @Override // com.kwad.components.core.page.splitLandingPage.view.SplitScrollWebView.a
            public final boolean uR() {
                if (!a.this.afx.uS() && com.kwad.sdk.core.config.e.Jk() == 2) {
                    return false;
                }
                AnimatorSet animatorSet = new AnimatorSet();
                Animator animatorA = x.a(a.this.afv, (Interpolator) null, a.this.afv.getTranslationY(), 0.0f);
                if (com.kwad.sdk.core.config.e.Jk() == 2) {
                    if (a.this.adf.isComplete()) {
                        animatorSet.playTogether(animatorA);
                    } else {
                        animatorSet.playSequentially(animatorA, a.this.afx.aV(true));
                    }
                } else if (com.kwad.sdk.core.config.e.Jk() == 1) {
                    animatorSet.playTogether(animatorA);
                }
                animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.5.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public final void onAnimationEnd(Animator animator) {
                        super.onAnimationEnd(animator);
                        a.this.adf.uP();
                        if (com.kwad.sdk.core.config.e.Jk() != 2 || a.this.adf.isComplete()) {
                            return;
                        }
                        a.this.afx.uT();
                    }
                });
                animatorSet.start();
                return true;
            }
        });
    }

    private void l(ViewGroup viewGroup) {
        Presenter presenter = new Presenter();
        this.afw = presenter;
        presenter.N(viewGroup);
        c cVar = new c();
        cVar.N(this.afv);
        b bVar = new b();
        this.afy = bVar;
        bVar.N(this.adf);
        this.afw.a(cVar);
        this.afw.a(this.afy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean uN() {
        SplitScrollWebView splitScrollWebView = this.afv;
        if (splitScrollWebView == null || splitScrollWebView.getTranslationY() != 0.0f || this.afz) {
            return false;
        }
        this.afv.setDisableAnimation(false);
        this.afz = true;
        SplitScrollWebView splitScrollWebView2 = this.afv;
        Animator animatorA = x.a((View) splitScrollWebView2, (Interpolator) null, 0.0f, splitScrollWebView2.getTranslationY() + this.adf.getHeight());
        AnimatorSet animatorSet = new AnimatorSet();
        if (com.kwad.sdk.core.config.e.Jk() == 2 && this.afx.isVisible()) {
            this.afx.uP();
            animatorSet.playSequentially(this.afx.aV(false), animatorA);
        } else {
            animatorSet.play(animatorA);
        }
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.core.page.splitLandingPage.a.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                a.this.uO();
                a.this.adf.uT();
                a.a(a.this, false);
            }
        });
        animatorSet.start();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uO() {
        this.afy.oe();
        this.afy.N(this.adf);
        this.afy.q(new com.kwad.components.core.page.recycle.e(this.mAdTemplate, this.mApkDownloadHelper, null));
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.l.a.b
    public final boolean onBackPressed() {
        SplitScrollWebView splitScrollWebView = this.afv;
        if (splitScrollWebView != null && splitScrollWebView.canGoBack()) {
            this.afv.goBack();
            return true;
        }
        if (uN()) {
            return true;
        }
        FeedVideoView feedVideoView = this.adf;
        if (feedVideoView != null) {
            return feedVideoView.zU();
        }
        return false;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String string = getArguments().getString("key_photo");
        AdTemplate adTemplate = new AdTemplate();
        if (string != null) {
            try {
                adTemplate.parseJson(new JSONObject(string));
            } catch (JSONException e) {
                com.kwad.sdk.core.d.c.printStackTrace(e);
            }
        }
        this.mAdTemplate = adTemplate;
        adTemplate.mPvReported = getArguments().getBoolean("key_report", false);
        this.mAdTemplate.mAdWebVideoPageShowing = true;
    }

    @Override // com.kwad.components.core.proxy.h, com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onDestroy() {
        super.onDestroy();
        AdTemplate adTemplate = this.mAdTemplate;
        if (adTemplate != null) {
            adTemplate.mAdWebVideoPageShowing = false;
        }
    }

    @Override // com.kwad.sdk.api.core.fragment.KsFragment, com.kwad.sdk.api.core.fragment.AbstractIFragmentLifecycle, com.kwad.sdk.api.core.fragment.IFragmentLifecycle
    public final void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.adf = (FeedVideoView) findViewById(R.id.ksad_split_land_ad_feed_video);
        this.afv = (SplitScrollWebView) findViewById(R.id.ksad_video_webView);
        A(view);
        l(this.oC);
        initView();
    }

    @Override // com.kwad.components.core.proxy.h
    public final int rI() {
        return R.layout.ksad_split_land_page;
    }

    public final void setApkDownloadHelper(d dVar) {
        this.mApkDownloadHelper = dVar;
    }

    public final void uP() {
        this.adf.uP();
    }

    public static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.afz = false;
        return false;
    }
}
