package com.kwad.components.ad.reward.page;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.ad.reward.h;
import com.kwad.components.ad.reward.j.b;
import com.kwad.components.ad.reward.model.RewardCallBackRespInfo;
import com.kwad.components.ad.reward.monitor.d;
import com.kwad.components.ad.reward.widget.HandSlideView;
import com.kwad.components.ad.reward.widget.RewardPreviewTopBarView;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.core.proxy.f;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.AdWebViewActivity;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.network.l;
import com.kwad.sdk.core.network.o;
import com.kwad.sdk.core.response.helper.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.by;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsAdSdkDynamicImpl(AdWebViewActivity.class)
@Keep
public class AdRewardPreviewActivityProxy extends f implements HandSlideView.a {
    private static final String KEY_URL = "key_langingpage_url";
    private static final String TAG = "AdRewardPreviewActivityProxy";
    public static KsRewardVideoAd.RewardAdInteractionListener mInteractionListener;
    private AdTemplate mAdTemplate;
    private KsAdWebView mAdWebView;
    public h mCloseDialog;
    private int mCount;
    private com.kwad.components.core.t.h mCountdownHelper;
    private long mCurrentDuration;
    private View mHandSlideContainer;

    @Nullable
    private HandSlideView mHandSlideView;
    private long mLastDown;
    protected KsLogoView mLogoView;
    private int mSkipCount;
    private long mStartPlayTime;
    private bx mTimerHelper;
    private RewardPreviewTopBarView mTopBarView;
    private String mUrl;
    private AdBaseFrameLayout mWebContainer;
    private boolean mHadAdClicked = false;
    private boolean mCheckExposureResult = true;
    private long mPageEnterTime = 0;
    private boolean mReportedPageShow = false;

    public static class a {
        public static void a(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, long j) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onVideoSkipToEnd(j);
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        }

        public static void c(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                rewardAdInteractionListener.onRewardVerify();
                try {
                    rewardAdInteractionListener.onRewardStepVerify(0, 0);
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        }

        public static void d(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onVideoPlayEnd();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        }

        public static void e(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onPageDismiss();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        }

        public static void f(KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
            if (rewardAdInteractionListener != null) {
                try {
                    rewardAdInteractionListener.onAdClicked();
                } catch (Throwable th) {
                    c.printStackTraceOnly(th);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkRequest(final int i) {
        new l<com.kwad.components.core.request.f, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.6
            @NonNull
            private static RewardCallBackRespInfo K(String str) {
                JSONObject jSONObject = new JSONObject(str);
                RewardCallBackRespInfo rewardCallBackRespInfo = new RewardCallBackRespInfo();
                rewardCallBackRespInfo.parseJson(jSONObject);
                return rewardCallBackRespInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            /* JADX INFO: renamed from: hH, reason: merged with bridge method [inline-methods] */
            public com.kwad.components.core.request.f createRequest() {
                return new com.kwad.components.core.request.f(i, AdRewardPreviewActivityProxy.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BaseResultData parseData(String str) {
                return K(str);
            }
        }.request(exposureRequest());
    }

    private void closeHandSlideMask() {
        HandSlideView handSlideView = this.mHandSlideView;
        if (handSlideView != null) {
            handSlideView.destroy();
            this.mHandSlideView = null;
        }
        View view = this.mHandSlideContainer;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    private o<com.kwad.components.core.request.f, RewardCallBackRespInfo> exposureRequest() {
        return new o<com.kwad.components.core.request.f, RewardCallBackRespInfo>() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.7
            private void a(@NonNull RewardCallBackRespInfo rewardCallBackRespInfo) {
                AdRewardPreviewActivityProxy.this.mCheckExposureResult = rewardCallBackRespInfo.result == 1;
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* bridge */ /* synthetic */ void onStartRequest(@NonNull com.kwad.sdk.core.network.f fVar) {
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((RewardCallBackRespInfo) baseResultData);
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onError(@NonNull com.kwad.components.core.request.f fVar, int i, String str) {
                super.onError(fVar, i, str);
                AdRewardPreviewActivityProxy.this.mCheckExposureResult = false;
            }
        };
    }

    private KsAdWebView.e getWebErrorListener() {
        return new KsAdWebView.e() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.4
            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageFinished() {
                d.b(true, AdRewardPreviewActivityProxy.this.mAdTemplate, AdRewardPreviewActivityProxy.this.mPageEnterTime);
                d.Y(AdRewardPreviewActivityProxy.this.mAdTemplate);
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onPageStart() {
                d.X(AdRewardPreviewActivityProxy.this.mAdTemplate);
                if (!AdRewardPreviewActivityProxy.this.mAdTemplate.mPvReported) {
                    AdRewardPreviewActivityProxy.this.checkExposure();
                }
                if (!AdRewardPreviewActivityProxy.this.mHadAdClicked) {
                    AdRewardPreviewActivityProxy.this.showHandSlideMask();
                }
                com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
                c1273a.aLl = "award_view";
                b.a(true, AdRewardPreviewActivityProxy.this.mAdTemplate, null, new com.kwad.sdk.core.adlog.c.b().b(c1273a));
            }

            @Override // com.kwad.sdk.core.webview.KsAdWebView.e
            public final void onReceivedHttpError(int i, String str, String str2) {
                d.c(AdRewardPreviewActivityProxy.this.mAdTemplate, i, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleAdClick() {
        this.mHadAdClicked = true;
        com.kwad.sdk.core.adlog.a.C1273a c1273a = new com.kwad.sdk.core.adlog.a.C1273a();
        c1273a.aLl = "award_view";
        b.a(this.mAdTemplate, (String) null, "nativePreview", new com.kwad.sdk.core.adlog.c.b().ec(72).b(c1273a).f(this.mWebContainer.getTouchCoords()), (JSONObject) null);
        closeHandSlideMask();
        a.f(mInteractionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCountdownEnd() {
        if (this.mCheckExposureResult) {
            a.c(mInteractionListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleEndClose() {
        a.d(mInteractionListener);
        com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 1, getTimerHelper().getTime(), (JSONObject) null);
        finish();
    }

    public static void launch(Activity activity, AdResultData adResultData, AdTemplate adTemplate, String str, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener) {
        d.i(true, adTemplate);
        mInteractionListener = rewardAdInteractionListener;
        com.kwad.sdk.service.c.putComponentProxy(AdWebViewActivity.class, AdRewardPreviewActivityProxy.class);
        Intent intent = new Intent(activity, (Class<?>) AdWebViewActivity.class);
        intent.putExtra(KEY_URL, str);
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.oU().l(adResultData));
        try {
            activity.startActivity(intent);
        } catch (Exception e) {
            ServiceProvider.reportSdkCaughtException(e);
            d.a(true, adTemplate, PageCreateStage.ERROR_START_ACTIVITY.getStage(), e.getMessage());
        }
        d.c(true, adTemplate, PageCreateStage.END_LAUNCH.getStage());
    }

    private void reportSubPageCreate(String str) {
        d.c(true, this.mAdTemplate, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showCloseDialog() {
        h hVar = this.mCloseDialog;
        if (hVar == null || !hVar.isShowing()) {
            int iCeil = (int) Math.ceil(this.mCurrentDuration / 1000.0f);
            this.mCloseDialog = h.a(getActivity(), this.mAdTemplate, h.g("还差" + iCeil + "秒就可以获取奖励", iCeil), new h.b() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.8
                @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
                public final void H(boolean z) {
                    a.a(AdRewardPreviewActivityProxy.mInteractionListener, System.currentTimeMillis() - AdRewardPreviewActivityProxy.this.mStartPlayTime);
                    com.kwad.sdk.core.adlog.c.a(AdRewardPreviewActivityProxy.this.mAdTemplate, 1, AdRewardPreviewActivityProxy.this.getTimerHelper().getTime(), (JSONObject) null);
                    AdRewardPreviewActivityProxy.this.finish();
                }

                @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
                public final void hm() {
                    if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                        AdRewardPreviewActivityProxy.this.mCountdownHelper.pause();
                    }
                }

                @Override // com.kwad.components.ad.reward.h.b, com.kwad.components.core.webview.tachikoma.f.c
                public final void hv() {
                    if (AdRewardPreviewActivityProxy.this.mCountdownHelper != null) {
                        AdRewardPreviewActivityProxy.this.mCountdownHelper.resume();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showHandSlideMask() {
        HandSlideView handSlideView = this.mHandSlideView;
        if (handSlideView == null || handSlideView.isStarted()) {
            return;
        }
        this.mHandSlideContainer.setVisibility(0);
        this.mHandSlideView.a(this);
    }

    public void checkExposure() {
        long j = e.eO(this.mAdTemplate).adRewardInfo.callBackStrategyInfo.impressionCheckMs;
        if (j <= 0 || com.kwad.sdk.core.response.helper.a.ak(e.eO(this.mAdTemplate)) <= 5000) {
            return;
        }
        by.runOnUiThreadDelay(new Runnable() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.5
            @Override // java.lang.Runnable
            public final void run() {
                AdRewardPreviewActivityProxy.this.checkRequest(1);
            }
        }, j);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        if (intent != null) {
            try {
                if (intent.hasExtra("key_ad_result_cache_idx")) {
                    this.mAdTemplate = com.kwad.components.core.c.f.oU().d(intent.getIntExtra("key_ad_result_cache_idx", 0), true).getFirstAdTemplate();
                }
            } catch (Throwable th) {
                c.printStackTrace(th);
            }
        }
        return this.mAdTemplate != null;
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        return R.layout.ksad_activity_reward_preview;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return TAG;
    }

    public bx getTimerHelper() {
        if (this.mTimerHelper == null) {
            this.mTimerHelper = new bx();
        }
        return this.mTimerHelper;
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.mUrl = getIntent().getStringExtra(KEY_URL);
        AdInfo adInfoEO = e.eO(this.mAdTemplate);
        int i = adInfoEO.adStyleInfo.adBrowseInfo.adBrowseDuration;
        int iAi = com.kwad.sdk.core.response.helper.a.ai(adInfoEO);
        this.mCount = i;
        this.mSkipCount = Math.min(iAi, i);
        this.mStartPlayTime = System.currentTimeMillis();
        KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener = mInteractionListener;
        if (rewardAdInteractionListener != null) {
            try {
                rewardAdInteractionListener.onVideoPlayStart();
            } catch (Throwable th) {
                c.printStackTraceOnly(th);
            }
        }
    }

    @Override // com.kwad.components.core.proxy.f
    @SuppressLint({"SetTextI18n"})
    public void initView() {
        KsAdWebView ksAdWebView = (KsAdWebView) findViewById(R.id.ksad_video_webview);
        this.mAdWebView = ksAdWebView;
        this.mAdWebView.setClientConfig(ksAdWebView.getClientConfig().fo(this.mAdTemplate).bR(true).bV(true).bP(true).b(getWebErrorListener()));
        this.mAdWebView.onActivityCreate();
        this.mWebContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_preview_webview_container);
        KsLogoView ksLogoView = (KsLogoView) findViewById(R.id.ksad_reward_preview_logo);
        this.mLogoView = ksLogoView;
        ksLogoView.bl(this.mAdTemplate);
        this.mHandSlideContainer = findViewById(R.id.ksad_reward_preview_hand_slide_container);
        AdInfo adInfoEO = e.eO(this.mAdTemplate);
        if (this.mUrl != null) {
            com.kwad.components.core.e.d.d dVar = new com.kwad.components.core.e.d.d(this.mAdTemplate);
            if (com.kwad.sdk.core.response.helper.a.aL(adInfoEO) && com.kwad.sdk.core.config.e.JI() && aq.isWifiConnected(getActivity())) {
                dVar.v(new com.kwad.components.core.e.d.a.C1201a(getActivity()).as(false).at(false).aJ(this.mAdTemplate).av(false));
            }
        }
        this.mAdWebView.loadUrl(!TextUtils.isEmpty(this.mUrl) ? this.mUrl : com.kwad.sdk.core.response.helper.a.aY(e.eO(this.mAdTemplate)));
        getTimerHelper().startTiming();
        this.mWebContainer.a(new View.OnTouchListener() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == 0) {
                    AdRewardPreviewActivityProxy.this.mLastDown = SystemClock.elapsedRealtime();
                    return false;
                }
                if (motionEvent.getAction() != 1) {
                    return false;
                }
                long jElapsedRealtime = SystemClock.elapsedRealtime() - AdRewardPreviewActivityProxy.this.mLastDown;
                if (AdRewardPreviewActivityProxy.this.mLastDown > 0 && jElapsedRealtime > 60 && jElapsedRealtime < 500) {
                    AdRewardPreviewActivityProxy.this.handleAdClick();
                }
                AdRewardPreviewActivityProxy.this.mLastDown = 0L;
                return false;
            }
        });
        this.mHandSlideView = (HandSlideView) findViewById(R.id.ksad_reward_preview_hand_slide);
        com.kwad.components.core.t.h hVar = new com.kwad.components.core.t.h(((long) this.mCount) * 1000);
        this.mCountdownHelper = hVar;
        hVar.a(new com.kwad.components.core.t.h.a() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.2
            @Override // com.kwad.components.core.t.h.a
            public final void onProgress(long j, long j2) {
                c.d(AdRewardPreviewActivityProxy.TAG, "onProgress currentDuration: " + j + " , totalDuration: " + j2);
                AdRewardPreviewActivityProxy.this.mCurrentDuration = j;
                AdRewardPreviewActivityProxy.this.mTopBarView.v(j);
            }
        });
        this.mCountdownHelper.start();
        RewardPreviewTopBarView rewardPreviewTopBarView = (RewardPreviewTopBarView) findViewById(R.id.ksad_reward_preview_topbar);
        this.mTopBarView = rewardPreviewTopBarView;
        rewardPreviewTopBarView.setTotalCountDuration(this.mCount * 1000);
        this.mTopBarView.setRewardTips(com.kwad.sdk.core.response.helper.a.cn(adInfoEO));
        this.mTopBarView.setCloseBtnDelayShowDuration(this.mSkipCount * 1000);
        this.mTopBarView.setTopBarListener(new RewardPreviewTopBarView.a() { // from class: com.kwad.components.ad.reward.page.AdRewardPreviewActivityProxy.3
            @Override // com.kwad.components.ad.reward.widget.RewardPreviewTopBarView.a
            public final void H(boolean z) {
                if (z) {
                    AdRewardPreviewActivityProxy.this.handleEndClose();
                } else {
                    AdRewardPreviewActivityProxy.this.showCloseDialog();
                }
            }

            @Override // com.kwad.components.ad.reward.widget.RewardPreviewTopBarView.a
            public final void I(boolean z) {
                if (z) {
                    return;
                }
                AdRewardPreviewActivityProxy.this.handleCountdownEnd();
            }
        });
    }

    @Override // com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.convert.c.ch(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        try {
            KsAdWebView ksAdWebView = this.mAdWebView;
            if (ksAdWebView != null && ksAdWebView.canGoBack()) {
                this.mAdWebView.goBack();
                com.kwad.sdk.core.adlog.c.cv(this.mAdTemplate);
                return;
            }
            RewardPreviewTopBarView rewardPreviewTopBarView = this.mTopBarView;
            if (!(rewardPreviewTopBarView != null && rewardPreviewTopBarView.lJ())) {
                showCloseDialog();
                return;
            }
            super.onBackPressed();
            a.d(mInteractionListener);
            com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, 11, getTimerHelper().getTime(), (JSONObject) null);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        try {
            super.onCreate(bundle);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.mPageEnterTime = jElapsedRealtime;
            d.a(true, this.mAdTemplate, jElapsedRealtime);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.proxy.f
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.monitor.c.b(true, this.mAdTemplate);
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        reportSubPageCreate(pageCreateStage.getStage());
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        a.e(mInteractionListener);
        mInteractionListener = null;
        KsAdWebView ksAdWebView = this.mAdWebView;
        if (ksAdWebView != null) {
            ksAdWebView.onActivityDestroy();
            this.mAdWebView = null;
        }
        com.kwad.components.core.t.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.stop();
        }
        super.onDestroy();
    }

    @Override // com.kwad.components.ad.reward.widget.HandSlideView.a
    public void onHandSlideLoopEnd() {
        closeHandSlideMask();
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
        getTimerHelper().Xf();
        com.kwad.components.core.t.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.pause();
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        super.onResume();
        getTimerHelper().Xe();
        com.kwad.components.core.t.h hVar = this.mCountdownHelper;
        if (hVar != null) {
            hVar.resume();
        }
        if (this.mReportedPageShow) {
            return;
        }
        d.f(true, this.mAdTemplate);
        this.mReportedPageShow = true;
    }
}
