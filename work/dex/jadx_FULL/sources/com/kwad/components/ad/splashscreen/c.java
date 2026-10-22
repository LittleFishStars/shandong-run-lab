package com.kwad.components.ad.splashscreen;

import android.content.Context;
import android.content.DialogInterface;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.kwad.components.ad.splashscreen.presenter.j;
import com.kwad.components.ad.splashscreen.presenter.k;
import com.kwad.components.ad.splashscreen.presenter.s;
import com.kwad.components.core.video.DetailVideoView;
import com.kwad.components.offline.api.tk.model.StyleTemplate;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdMatrixInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.o;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.wrapper.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c extends com.kwad.components.core.n.d<h> implements DialogInterface.OnDismissListener, DialogInterface.OnShowListener {
    private KsSplashScreenAd.SplashScreenAdInteractionListener GB;
    private com.kwad.components.ad.splashscreen.e.d GC;
    private com.kwad.sdk.core.j.b dH;
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.d mApkDownloadHelper;
    private DetailVideoView mDetailVideoView;
    private boolean mPageDismissCalled;
    private AdBaseFrameLayout mRootContainer;
    private long mStartRenderTime;
    private KsVideoPlayConfig mVideoPlayConfig;

    private c(Context context, AdResultData adResultData) {
        super(context);
        this.mStartRenderTime = -1L;
        this.mAdResultData = adResultData;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        this.mAdTemplate = adTemplateR;
        this.mAdScene = adTemplateR.mAdScene;
        tp();
    }

    private static Presenter ai(AdTemplate adTemplate) {
        AdInfo adInfoEO = com.kwad.sdk.core.response.helper.e.eO(adTemplate);
        Presenter presenter = new Presenter();
        a(presenter, adInfoEO);
        if (h.aj(adTemplate)) {
            presenter.a(new com.kwad.components.ad.splashscreen.presenter.playcard.a());
        } else {
            presenter.a(new j());
        }
        return presenter;
    }

    private int getSplashLayoutId() {
        return R.layout.ksad_splash_screen_layout;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.n.d
    /* JADX INFO: renamed from: lU, reason: merged with bridge method [inline-methods] */
    public h an() {
        com.kwad.components.ad.splashscreen.e.d dVar = new com.kwad.components.ad.splashscreen.e.d(this.oC, com.kwad.sdk.core.response.helper.a.cN(this.mAdInfo));
        this.GC = dVar;
        dVar.a(this.dH);
        this.GC.Aa();
        if (this.mVideoPlayConfig == null) {
            this.mVideoPlayConfig = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        }
        h hVar = new h();
        hVar.a(this.mAdResultData);
        hVar.setSplashScreenAdListener(this.GB);
        hVar.mRootContainer = this.mRootContainer;
        hVar.mAdScene = this.mAdScene;
        hVar.mVideoPlayConfig = this.mVideoPlayConfig;
        hVar.GP = this.GC;
        hVar.mApkDownloadHelper = this.mApkDownloadHelper;
        hVar.GO = c(this.mAdTemplate);
        hVar.mTimerHelper = new bx();
        hVar.mStartRenderTime = this.mStartRenderTime;
        if (com.kwad.sdk.core.response.helper.a.bi(this.mAdInfo)) {
            com.kwad.components.ad.splashscreen.d.a aVar = new com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mDetailVideoView, this.mVideoPlayConfig);
            hVar.GN = aVar;
            hVar.GP.a(aVar);
        }
        hVar.GP.a(a(hVar));
        return hVar;
    }

    private void lV() {
        com.kwad.sdk.a.a.c.Hl().Ho();
        if (this.mPageDismissCalled) {
            return;
        }
        this.mPageDismissCalled = true;
    }

    public static boolean o(@NonNull AdInfo adInfo) {
        AdInfo.AdSplashInfo adSplashInfo = adInfo.adSplashInfo;
        return adSplashInfo != null && adSplashInfo.fullScreenClickSwitch == 1;
    }

    @Override // com.kwad.components.core.n.d, com.kwad.sdk.widget.KSFrameLayout
    public final void ae() {
        this.mStartRenderTime = SystemClock.elapsedRealtime();
        super.ae();
        post(new bi() { // from class: com.kwad.components.ad.splashscreen.c.3
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                AdTemplate adTemplate = c.this.mAdTemplate;
                AdInfo unused = c.this.mAdInfo;
                if (h.aj(adTemplate) || ((h) c.this.abm).GN == null) {
                    return;
                }
                ((h) c.this.abm).GN.nQ();
            }
        });
    }

    @Override // com.kwad.components.core.n.d, com.kwad.sdk.widget.KSFrameLayout
    public final void af() {
        boolean z;
        super.af();
        boolean z2 = false;
        try {
            z = getRootView() != null && getRootView().getVisibility() == 0;
            try {
                if (getRootView() != null && getRootView().getParent() != null && (getRootView().getParent() instanceof View) && ((View) getRootView().getParent()).getVisibility() == 0) {
                    z2 = true;
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            z = false;
        }
        com.kwad.components.ad.splashscreen.monitor.b.mv();
        com.kwad.components.ad.splashscreen.monitor.b.a(this.mAdTemplate, o.Gs().GW(), z, z2);
        com.kwad.components.core.e.d.d dVar = this.mApkDownloadHelper;
        if (dVar != null) {
            dVar.setOnDismissListener(null);
            this.mApkDownloadHelper.setOnShowListener(null);
        }
        this.GC.Ab();
        lV();
        com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.e.bA(this.mAdTemplate));
    }

    @Override // com.kwad.components.core.n.d
    public final boolean al() {
        return true;
    }

    @Override // com.kwad.components.core.n.d
    public final int getLayoutId() {
        return getSplashLayoutId();
    }

    @Override // com.kwad.components.core.n.d
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        KsVideoPlayConfig ksVideoPlayConfigBuild = new KsVideoPlayConfig.Builder().videoSoundEnable(this.mAdInfo.adSplashInfo.mute != 1).build();
        this.mVideoPlayConfig = ksVideoPlayConfigBuild;
        this.mAdTemplate.mInitVoiceStatus = ksVideoPlayConfigBuild.isVideoSoundEnable() ? 2 : 1;
        com.kwad.components.core.e.d.d dVar = new com.kwad.components.core.e.d.d(this.mAdTemplate);
        this.mApkDownloadHelper = dVar;
        dVar.setOnDismissListener(this);
        this.mApkDownloadHelper.setOnShowListener(this);
    }

    @Override // com.kwad.components.core.n.d
    @NonNull
    public final Presenter onCreatePresenter() {
        getContext();
        return ai(this.mAdTemplate);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        boolean zPI = dialogInterface instanceof com.kwad.components.core.e.c.b ? ((com.kwad.components.core.e.c.b) dialogInterface).pI() : false;
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
            if (splashScreenAdInteractionListener != null) {
                if (zPI) {
                    splashScreenAdInteractionListener.onDownloadTipsDialogDismiss();
                } else {
                    splashScreenAdInteractionListener.onDownloadTipsDialogCancel();
                }
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        try {
            KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener = this.GB;
            if (splashScreenAdInteractionListener != null) {
                splashScreenAdInteractionListener.onDownloadTipsDialogShow();
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    @Override // android.view.View
    public final void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
    }

    public final void setPageExitListener(com.kwad.sdk.core.j.b bVar) {
        this.dH = bVar;
    }

    public final void setSplashScreenAdListener(KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) {
        this.GB = splashScreenAdInteractionListener;
        T t = this.abm;
        if (t != 0) {
            ((h) t).setSplashScreenAdListener(splashScreenAdInteractionListener);
        }
    }

    public static c a(Context context, @NonNull AdResultData adResultData, boolean z, com.kwad.sdk.core.j.b bVar, KsSplashScreenAd.SplashScreenAdInteractionListener splashScreenAdInteractionListener) throws Throwable {
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        c cVar = null;
        try {
            adTemplateR.showStartTime = SystemClock.elapsedRealtime();
            com.kwad.components.ad.splashscreen.monitor.b.mv();
            com.kwad.components.ad.splashscreen.monitor.b.ap(adTemplateR);
            com.kwad.components.ad.splashscreen.monitor.b.mv();
            com.kwad.components.ad.splashscreen.monitor.b.a(adTemplateR, o.Gs().GW(), z);
            c cVar2 = new c(m.wrapContextIfNeed(context), adResultData);
            try {
                cVar2.setPageExitListener(bVar);
                cVar2.setSplashScreenAdListener(splashScreenAdInteractionListener);
                return cVar2;
            } catch (Throwable th) {
                th = th;
                cVar = cVar2;
                com.kwad.components.ad.splashscreen.monitor.b.mv();
                com.kwad.components.ad.splashscreen.monitor.b.a(adTemplateR, th.toString(), z);
                if (!o.Gs().Fu()) {
                    throw th;
                }
                com.kwad.components.core.d.a.reportSdkCaughtException(th);
                return cVar;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static StyleTemplate c(AdTemplate adTemplate) {
        AdMatrixInfo.MatrixTemplate matrixTemplateT = com.kwad.sdk.core.response.helper.b.t(adTemplate, com.kwad.sdk.core.response.helper.b.em(adTemplate));
        StyleTemplate styleTemplate = new StyleTemplate();
        if (matrixTemplateT != null) {
            styleTemplate.templateId = matrixTemplateT.templateId;
            styleTemplate.templateMd5 = matrixTemplateT.templateMd5;
            styleTemplate.templateUrl = matrixTemplateT.templateUrl;
            styleTemplate.templateVersionCode = (int) matrixTemplateT.templateVersionCode;
        }
        return styleTemplate;
    }

    private com.kwad.sdk.core.j.c a(final h hVar) {
        return new com.kwad.sdk.core.j.c() { // from class: com.kwad.components.ad.splashscreen.c.1
            @Override // com.kwad.sdk.core.j.c
            public final void bA() {
                bx bxVar = hVar.mTimerHelper;
                if (bxVar != null) {
                    bxVar.Xf();
                }
            }

            @Override // com.kwad.sdk.core.j.c
            public final void bz() {
                bx bxVar = hVar.mTimerHelper;
                if (bxVar != null) {
                    bxVar.Xe();
                }
            }
        };
    }

    @Override // com.kwad.components.core.n.d
    public final void a(@NonNull ViewGroup viewGroup) {
        this.mRootContainer = (AdBaseFrameLayout) this.oC.findViewById(R.id.ksad_splash_root_container);
        DetailVideoView detailVideoView = (DetailVideoView) this.oC.findViewById(R.id.ksad_splash_video_player);
        this.mDetailVideoView = detailVideoView;
        detailVideoView.setAd(true);
        this.mDetailVideoView.setVisibility(8);
        this.mRootContainer.findViewById(R.id.splash_play_card_view).setOnClickListener(new View.OnClickListener() { // from class: com.kwad.components.ad.splashscreen.c.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (com.kwad.sdk.c.a.a.HW() || !c.o(c.this.mAdInfo) || c.this.abm == null) {
                    return;
                }
                ((h) c.this.abm).c(1, view.getContext(), 53, 3);
            }
        });
    }

    private static void a(Presenter presenter, AdInfo adInfo) {
        presenter.a(new k());
        presenter.a(new s());
        if (h.s(adInfo)) {
            presenter.a(new com.kwad.components.ad.splashscreen.presenter.endcard.f());
        }
    }
}
