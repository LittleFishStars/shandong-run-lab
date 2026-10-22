package com.kwad.components.ad.fullscreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.j;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.FeedDownloadActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsFullScreenVideoActivity;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.o;
import java.io.Serializable;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsAdSdkDynamicImpl(FeedDownloadActivity.class)
@Keep
public class KsFullScreenVideoActivityProxy extends com.kwad.components.core.n.b<com.kwad.components.ad.reward.g> implements OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "FullScreenVideo";
    private static final HashMap<String, c> sHashMap = new HashMap<>();
    private AdInfo mAdInfo;
    private AdResultData mAdResultData;
    private AdTemplate mAdTemplate;
    private com.kwad.components.ad.fullscreen.c.b mFullScreenPresenter;
    private c mInteractionListener;
    private boolean mIsBackEnable;
    private boolean mPageDismissCalled;
    public long mPageEnterTime;
    private JSONObject mReportExtData;
    private AdBaseFrameLayout mRootContainer;
    public int mScreenOrientation;
    private bx mTimerHelper;
    private KsVideoPlayConfig mVideoPlayConfig;
    private b model;
    private long mStartRenderTime = -1;
    private boolean mReportedPageResume = false;
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            KsFullScreenVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private d mAdOpenInteractionListener = new d() { // from class: com.kwad.components.ad.fullscreen.KsFullScreenVideoActivityProxy.2
        @Override // com.kwad.components.ad.fullscreen.d, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void i(boolean z) {
            if (KsFullScreenVideoActivityProxy.this.notifyPageDismiss()) {
                super.i(z);
            }
        }
    };

    private static String getListenerKey(AdTemplate adTemplate) {
        return adTemplate == null ? "" : String.valueOf(com.kwad.sdk.core.response.helper.e.eO(adTemplate).adBaseInfo.creativeId);
    }

    private bx getTimerHelper() {
        if (this.mTimerHelper == null) {
            bx bxVar = new bx();
            this.mTimerHelper = bxVar;
            bxVar.startTiming();
        }
        return this.mTimerHelper;
    }

    private void initVideoPlayConfig(@NonNull KsVideoPlayConfig ksVideoPlayConfig) {
        if (TextUtils.isEmpty(ksVideoPlayConfig.getShowScene())) {
            return;
        }
        this.mReportExtData = null;
        JSONObject jSONObject = new JSONObject();
        this.mReportExtData = jSONObject;
        ac.putValue(jSONObject, "ext_showscene", ksVideoPlayConfig.getShowScene());
    }

    public static void launch(@NonNull Context context, @NonNull AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, c cVar) {
        Intent intent;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        com.kwad.components.ad.reward.monitor.d.i(false, adTemplateR);
        o.fq(adTemplateR);
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.c.putComponentProxy(KsFullScreenLandScapeVideoActivity.class, KsFullScreenLandScapeVideoActivityProxy.class);
            intent = new Intent(context, (Class<?>) KsFullScreenLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.c.putComponentProxy(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
            intent = new Intent(context, (Class<?>) FeedDownloadActivity.class);
        }
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.oU().l(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        sHashMap.put(getListenerKey(adTemplateR), cVar);
        try {
            context.startActivity(intent);
            com.kwad.sdk.a.a.c.Hl().bB(true);
            reportSubPageCreate(PageCreateStage.END_LAUNCH.getStage(), adTemplateR);
        } catch (Throwable th) {
            com.kwad.components.ad.reward.monitor.d.a(false, adTemplateR, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss() {
        if (this.mPageDismissCalled) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (this.mAdTemplate != null && this.mAdInfo != null) {
            long time = getTimerHelper().getTime();
            com.kwad.sdk.a.a.c.Hl().Ho();
            com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 6, time, this.mReportExtData);
            if (com.kwad.sdk.core.response.helper.a.cZ(this.mAdInfo) && !((com.kwad.components.ad.reward.g) this.mCallerContext).na) {
                com.kwad.sdk.core.adlog.c.q(this.model.getAdTemplate(), (int) Math.ceil(time / 1000.0f));
            }
        }
        return true;
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.c.putComponentProxy(KsFullScreenVideoActivity.class, KsFullScreenVideoActivityProxy.class);
        com.kwad.sdk.service.c.putComponentProxy(FeedDownloadActivity.class, KsFullScreenVideoActivityProxy.class);
    }

    private static void reportSubPageCreate(String str, AdTemplate adTemplate) {
        com.kwad.components.ad.reward.monitor.d.c(false, adTemplate, str);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        if (com.kwad.sdk.core.config.e.KC()) {
            this.mVideoPlayConfig = com.kwad.components.core.internal.api.e.b(getIntent().getStringExtra("key_video_play_config_json"), true);
        } else {
            Serializable serializableExtra = getIntent().getSerializableExtra("key_video_play_config");
            if (serializableExtra instanceof KsVideoPlayConfig) {
                this.mVideoPlayConfig = (KsVideoPlayConfig) serializableExtra;
            }
        }
        AdResultData adResultDataD = com.kwad.components.core.c.f.oU().d(getIntent().getIntExtra("key_ad_result_cache_idx", 0), true);
        this.mAdResultData = adResultDataD;
        if (adResultDataD == null) {
            return false;
        }
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultDataD);
        this.mAdTemplate = adTemplateR;
        this.model = new b(adTemplateR);
        this.mAdOpenInteractionListener.setAdTemplate(this.mAdTemplate);
        return (this.mVideoPlayConfig == null || this.mAdTemplate == null) ? false : true;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.i(false);
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        b bVar = this.model;
        return (bVar == null || !bVar.jM) ? R.layout.ksad_activity_fullscreen_video_legacy : R.layout.ksad_activity_fullscreen_tk;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "KsFullScreenVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return ((com.kwad.components.ad.reward.g) this.mCallerContext).gS();
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.mPageEnterTime = jElapsedRealtime;
        com.kwad.components.ad.reward.monitor.d.a(false, this.mAdTemplate, jElapsedRealtime);
        com.kwad.components.ad.reward.monitor.d.g(false, this.mAdTemplate);
        c cVar = sHashMap.get(getListenerKey(this.mAdTemplate));
        this.mInteractionListener = cVar;
        this.mAdOpenInteractionListener.a(cVar);
        this.mAdInfo = com.kwad.sdk.core.response.helper.e.eO(this.mAdTemplate);
        this.mScreenOrientation = this.mVideoPlayConfig.isShowLandscape() ? 1 : 0;
        this.mAdTemplate.mInitVoiceStatus = this.mVideoPlayConfig.isVideoSoundEnable() ? 2 : 1;
        initVideoPlayConfig(this.mVideoPlayConfig);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.convert.c.ch(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        com.kwad.components.ad.fullscreen.c.b bVar = this.mFullScreenPresenter;
        if ((bVar == null || !bVar.onBackPressed()) && this.mIsBackEnable) {
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.monitor.c.b(false, this.mAdTemplate);
    }

    @Override // com.kwad.components.core.n.b
    public Presenter onCreatePresenter() {
        getActivity();
        com.kwad.components.ad.fullscreen.c.b bVar = new com.kwad.components.ad.fullscreen.c.b(this, this.mRootContainer, this.model, (com.kwad.components.ad.reward.g) this.mCallerContext);
        this.mFullScreenPresenter = bVar;
        return bVar;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        reportSubPageCreate(pageCreateStage.getStage(), this.mAdTemplate);
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            super.onDestroy();
            this.mAdOpenInteractionListener.i(false);
            AdInfo adInfo = this.mAdInfo;
            if (adInfo != null) {
                String strM = com.kwad.sdk.core.response.helper.a.M(adInfo);
                if (!TextUtils.isEmpty(strM)) {
                    com.kwad.sdk.core.videocache.c.a.cm(this.mContext.getApplicationContext()).fA(strM);
                }
            }
            T t = this.mCallerContext;
            if (t != 0 && ((com.kwad.components.ad.reward.g) t).sz != null && ((com.kwad.components.ad.reward.g) t).sz.ls()) {
                ((com.kwad.components.ad.reward.g) this.mCallerContext).sz.lt().removeInterceptor(this);
            }
            sHashMap.remove(getListenerKey(this.mAdTemplate));
            this.mInteractionListener = null;
            com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.e.bA(this.mAdTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        try {
            super.onPause();
            getTimerHelper().Xf();
            T t = this.mCallerContext;
            if (t != 0) {
                ((com.kwad.components.ad.reward.g) t).mPageEnterTime = -1L;
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreCreate(@Nullable Bundle bundle) {
        this.mStartRenderTime = SystemClock.elapsedRealtime();
        super.onPreCreate(bundle);
        try {
            getIntent().removeExtra("key_template");
        } catch (Throwable unused) {
        }
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            getTimerHelper().Xe();
            if (this.mReportedPageResume) {
                return;
            }
            com.kwad.components.ad.reward.monitor.d.f(false, this.mAdTemplate);
            this.mReportedPageResume = true;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.n.b
    public com.kwad.components.ad.reward.g onCreateCallerContext() {
        com.kwad.components.ad.reward.g gVar = new com.kwad.components.ad.reward.g(this);
        gVar.a(this.mAdResultData);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.sx = false;
        gVar.sy = this.mAdOpenInteractionListener;
        gVar.mScreenOrientation = this.mScreenOrientation;
        gVar.mVideoPlayConfig = this.mVideoPlayConfig;
        gVar.mReportExtData = this.mReportExtData;
        gVar.mRootContainer = this.mRootContainer;
        gVar.mStartRenderTime = this.mStartRenderTime;
        if (com.kwad.sdk.core.response.helper.a.aL(this.mAdInfo)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.d(this.mAdTemplate, this.mReportExtData);
        }
        gVar.sB = new RewardActionBarControl(gVar, this.mContext, this.mAdTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.helper.b.dk(this.mAdTemplate)) {
            gVar.sC = new j(gVar, this.mReportExtData, null);
        }
        if (com.kwad.sdk.core.response.helper.a.bQ(this.mAdInfo)) {
            gVar.sA = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        gVar.sO = false;
        gVar.tm = com.kwad.sdk.core.response.helper.a.bQ(this.mAdInfo) ? com.kwad.sdk.core.response.helper.a.ax(this.mAdInfo) : com.kwad.sdk.core.response.helper.a.aq(this.mAdInfo);
        gVar.mTimerHelper = getTimerHelper();
        gVar.sz = new com.kwad.components.ad.reward.m.e(gVar);
        return gVar;
    }
}
