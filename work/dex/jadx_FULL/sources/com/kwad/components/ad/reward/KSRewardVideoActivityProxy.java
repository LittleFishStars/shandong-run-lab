package com.kwad.components.ad.reward;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.components.ad.reward.page.BackPressHandleResult;
import com.kwad.components.ad.reward.presenter.platdetail.actionbar.RewardActionBarControl;
import com.kwad.components.core.exception.KSAdPreCreateException;
import com.kwad.components.core.proxy.PageCreateStage;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.core.KsAdSdkDynamicImpl;
import com.kwad.sdk.api.proxy.app.KSRewardLandScapeVideoActivity;
import com.kwad.sdk.api.proxy.app.KsRewardVideoActivity;
import com.kwad.sdk.core.response.model.AdGlobalConfigInfo;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.LiveDetailReward;
import com.kwad.sdk.core.view.AdBaseFrameLayout;
import com.kwad.sdk.core.webview.KsAdWebView;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.af;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bx;
import com.kwad.sdk.utils.by;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsAdSdkDynamicImpl(KsRewardVideoActivity.class)
@Keep
public class KSRewardVideoActivityProxy extends com.kwad.components.core.n.b<g> implements g.b, n.a, com.kwad.components.core.t.c.b, OnAdLiveResumeInterceptor {
    public static final String KEY_AD_RESULT_CACHE_IDX = "key_ad_result_cache_idx";
    public static final String KEY_REWARD_TYPE = "key_template_reward_type";
    public static final String KEY_TEMPLATE = "key_template_json";
    public static final String KEY_VIDEO_PLAY_CONFIG = "key_video_play_config";
    public static final String KEY_VIDEO_PLAY_CONFIG_JSON = "key_video_play_config_json";
    private static final String TAG = "RewardVideo";
    private String listenerKey;
    private boolean mIsBackEnable;
    private com.kwad.components.ad.reward.model.c mModel;
    private boolean mPageDismissCalled;
    private long mPageEnterTime;
    private n mRewardPresenter;
    private AdBaseFrameLayout mRootContainer;
    private bx mTimerHelper;
    private boolean mReportedPageResume = false;
    private long mStartRenderTime = -1;
    private boolean mIsFinishVideoLookStep = false;
    private final com.kwad.components.ad.reward.e.l mRewardVerifyListener = new com.kwad.components.ad.reward.e.l() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.1
        @Override // com.kwad.components.ad.reward.e.l
        public final void onRewardVerify() {
            if (KSRewardVideoActivityProxy.this.mModel.iG() && ((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult && ((g) KSRewardVideoActivityProxy.this.mCallerContext).sY != 2) {
                KSRewardVideoActivityProxy.this.markOpenNsCompleted();
                KSRewardVideoActivityProxy.this.notifyRewardVerify();
                KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
            }
        }
    };
    private BroadcastReceiver mLiveBroadcastReceiver = new BroadcastReceiver() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.2
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            com.kwad.sdk.core.d.c.w("RewardVideo", "jky receive live broadcast:" + action);
            if ("REWARD_LIVE_ACTION_VERIFY".equals(action)) {
                if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener != null) {
                    KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.onRewardVerify();
                }
                if (KSRewardVideoActivityProxy.this.mCallerContext != null) {
                    LiveDetailReward liveDetailReward = new LiveDetailReward();
                    liveDetailReward.success = true;
                    ((g) KSRewardVideoActivityProxy.this.mCallerContext).a(liveDetailReward);
                    return;
                }
                return;
            }
            if ("REWARD_LIVE_ACTION_PROGRESS".equals(action)) {
                long longExtra = intent.getLongExtra("countDownSecond", 0L);
                double doubleExtra = intent.getDoubleExtra("hasRewardTime", AudioStats.AUDIO_AMPLITUDE_NONE);
                com.kwad.sdk.core.d.c.w("RewardVideo", "jky receive live broadcast progress:" + longExtra);
                if (KSRewardVideoActivityProxy.this.mCallerContext != null) {
                    LiveDetailReward liveDetailReward2 = new LiveDetailReward();
                    liveDetailReward2.success = false;
                    liveDetailReward2.countDownSecond = longExtra;
                    liveDetailReward2.hasRewardTime = doubleExtra;
                    ((g) KSRewardVideoActivityProxy.this.mCallerContext).a(liveDetailReward2);
                }
            }
        }
    };
    private com.kwad.components.ad.reward.e.i mAdOpenInteractionListener = new com.kwad.components.ad.reward.e.i() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.3
        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void dc() {
            super.dc();
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).jh = true;
            ((g) KSRewardVideoActivityProxy.this.mCallerContext).gZ();
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void i(boolean z) {
            if (KSRewardVideoActivityProxy.this.notifyPageDismiss(z)) {
                com.kwad.sdk.a.a.c.Hl().Ho();
                super.i(z);
            }
        }

        @Override // com.kwad.components.ad.reward.e.i, com.kwad.components.ad.reward.e.c, com.kwad.components.ad.reward.e.b
        public final void onRewardVerify() {
            if (!((g) KSRewardVideoActivityProxy.this.mCallerContext).mCheckExposureResult || ((g) KSRewardVideoActivityProxy.this.mCallerContext).sY == 2) {
                return;
            }
            KSRewardVideoActivityProxy.this.notifyRewardVerify();
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };
    private com.kwad.components.ad.reward.e.g mPlayEndPageListener = new com.kwad.components.ad.reward.e.a() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.4
        @Override // com.kwad.components.ad.reward.e.g
        public final void dd() {
            KSRewardVideoActivityProxy.this.mIsBackEnable = true;
        }
    };
    private com.kwad.components.ad.reward.e.d mAdRewardStepListener = new com.kwad.components.ad.reward.e.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.5
        @Override // com.kwad.components.ad.reward.e.d
        public final void gB() {
            KSRewardVideoActivityProxy.this.notifyRewardVerifyStepByStep();
        }
    };

    private bx getTimerHelper() {
        if (this.mTimerHelper == null) {
            bx bxVar = new bx();
            this.mTimerHelper = bxVar;
            bxVar.startTiming();
        }
        return this.mTimerHelper;
    }

    private String getUniqueId() {
        return this.listenerKey;
    }

    private void handleNotifyVerify(boolean z) {
        this.mAdOpenInteractionListener.setCallerContext((g) this.mCallerContext);
        ((g) this.mCallerContext).G(true);
        this.mModel.getAdTemplate().mRewardVerifyCalled = true;
        if (z || ((g) this.mCallerContext).sY == 0) {
            e.gK().P(this.mModel.getAdTemplate());
        }
        com.kwad.sdk.core.adlog.c.k(this.mModel.getAdTemplate(), isNeoScan());
        if (!((g) this.mCallerContext).mAdTemplate.converted) {
            com.kwad.components.ad.reward.c.a.ih().ii().ak(com.kwad.components.ad.reward.c.b.vh);
        }
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.8
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.in()) {
                    com.kwad.components.ad.reward.monitor.d.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), 0, -1, true);
                }
            }
        });
        if (com.kwad.sdk.core.response.helper.a.df(this.mModel.da())) {
            T t = this.mCallerContext;
            if (((g) t).mAdTemplate.converted || ((g) t).sP || ((g) t).hg()) {
                return;
            }
            g.a(getActivity(), (g) this.mCallerContext);
        }
    }

    private boolean isLaunchTaskCompleted() {
        T t = this.mCallerContext;
        return ((g) t).ti != null && ((g) t).ti.isCompleted();
    }

    private boolean isNeoScan() {
        return this.mModel.iL() != null && this.mModel.iL().neoPageType == 1;
    }

    public static void launch(Activity activity, AdResultData adResultData, @NonNull KsVideoPlayConfig ksVideoPlayConfig, KsRewardVideoAd.RewardAdInteractionListener rewardAdInteractionListener, com.kwad.components.core.j.d dVar, int i) {
        Intent intent;
        AdTemplate adTemplateR = com.kwad.sdk.core.response.helper.c.r(adResultData);
        com.kwad.components.ad.reward.monitor.d.i(true, adTemplateR);
        AdGlobalConfigInfo adGlobalConfigInfo = adResultData.adGlobalConfigInfo;
        com.kwad.sdk.utils.o.fq(adTemplateR);
        if (adGlobalConfigInfo != null && adGlobalConfigInfo.neoPageType == 1) {
            ksVideoPlayConfig.setShowLandscape(false);
        }
        if (ksVideoPlayConfig.isShowLandscape()) {
            com.kwad.sdk.service.c.putComponentProxy(KSRewardLandScapeVideoActivity.class, KSRewardLandScapeVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KSRewardLandScapeVideoActivity.class);
        } else {
            com.kwad.sdk.service.c.putComponentProxy(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
            intent = new Intent(activity, (Class<?>) KsRewardVideoActivity.class);
        }
        intent.putExtra("key_ad_result_cache_idx", com.kwad.components.core.c.f.oU().l(adResultData));
        intent.putExtra("key_video_play_config", ksVideoPlayConfig);
        intent.putExtra("key_video_play_config_json", com.kwad.components.core.internal.api.e.a(ksVideoPlayConfig));
        intent.putExtra(KEY_REWARD_TYPE, i);
        String uniqueId = adTemplateR.getUniqueId();
        com.kwad.components.ad.reward.e.f.a(uniqueId, rewardAdInteractionListener, dVar);
        com.kwad.components.ad.reward.e.f.P(uniqueId);
        try {
            activity.startActivity(intent);
            com.kwad.sdk.a.a.c.Hl().bB(true);
            com.kwad.components.ad.reward.monitor.d.c(true, adTemplateR, PageCreateStage.END_LAUNCH.getStage());
        } catch (Throwable th) {
            com.kwad.components.ad.reward.monitor.d.a(true, adTemplateR, PageCreateStage.ERROR_START_ACTIVITY.getStage(), th.getMessage());
            ServiceProvider.reportSdkCaughtException(new KSAdPreCreateException("ksad_pre_create_exception_error_start_activity", th));
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markOpenNsCompleted() {
        T t = this.mCallerContext;
        if (((g) t).tj != null) {
            ((g) t).tj.markOpenNsCompleted();
        }
    }

    private boolean needHandledOnResume() {
        return ((g) this.mCallerContext).hh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean notifyPageDismiss(boolean z) {
        com.kwad.components.ad.reward.model.c cVar;
        if (this.mPageDismissCalled || this.mCallerContext == 0 || (cVar = this.mModel) == null) {
            return false;
        }
        this.mPageDismissCalled = true;
        if (!com.kwad.sdk.core.response.helper.a.cZ(cVar.da()) || !((g) this.mCallerContext).hf()) {
            com.kwad.sdk.core.adlog.c.q(this.mModel.getAdTemplate(), (int) Math.ceil(getTimerHelper().getTime() / 1000.0f));
        }
        if (z) {
            if (this.mModel.iL() == null || this.mModel.iL().neoPageType != 1) {
                com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 1, getTimerHelper().getTime(), ((g) this.mCallerContext).mReportExtData);
            }
        } else if (this.mModel.iL() == null || this.mModel.iL().neoPageType != 1) {
            com.kwad.sdk.core.adlog.c.a(this.mModel.getAdTemplate(), 6, getTimerHelper().getTime(), this.mModel.iK());
        }
        return true;
    }

    private void notifyRewardStep(final int i, final int i2) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || com.kwad.sdk.core.response.helper.e.eZ(cVar.getAdTemplate()) || ((g) this.mCallerContext).sV.contains(Integer.valueOf(i2))) {
            return;
        }
        ((g) this.mCallerContext).sV.add(Integer.valueOf(i2));
        o.a(i, i2, (g) this.mCallerContext, this.mModel);
        by.runOnUiThread(new bi() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.7
            @Override // com.kwad.sdk.utils.bi
            public final void doTask() {
                try {
                    if (KSRewardVideoActivityProxy.this.mAdOpenInteractionListener.i(i, i2)) {
                        com.kwad.components.ad.reward.monitor.d.a(KSRewardVideoActivityProxy.this.mModel.getAdTemplate(), i, i2, false);
                    }
                } catch (Throwable th) {
                    com.kwad.sdk.core.d.c.printStackTraceOnly(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerify() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null || !((g) this.mCallerContext).mCheckExposureResult || com.kwad.sdk.core.response.helper.e.eZ(cVar.getAdTemplate()) || ((g) this.mCallerContext).hi()) {
            return;
        }
        boolean z = false;
        if (this.mModel.iF()) {
            T t = this.mCallerContext;
            if (((g) t).ti != null && ((g) t).ti.isCompleted()) {
                z = true;
            }
            if (z) {
                handleNotifyVerify(true);
                return;
            }
            return;
        }
        if (!this.mModel.iG()) {
            handleNotifyVerify(false);
            return;
        }
        T t2 = this.mCallerContext;
        if (((g) t2).tj != null && ((g) t2).tj.isCompleted()) {
            z = true;
        }
        if (z) {
            handleNotifyVerify(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRewardVerifyStepByStep() {
        if (this.mModel.iF()) {
            notifyRewardStep(2, 0);
            if (isLaunchTaskCompleted()) {
                notifyRewardStep(2, 2);
                return;
            }
            return;
        }
        if (!this.mModel.iG()) {
            if (this.mIsFinishVideoLookStep) {
                return;
            }
            this.mIsFinishVideoLookStep = true;
            notifyRewardStep(0, 0);
            return;
        }
        T t = this.mCallerContext;
        boolean z = ((g) t).tj != null && ((g) t).tj.isCompleted();
        notifyRewardStep(1, 0);
        if (z) {
            notifyRewardStep(1, 1);
        }
    }

    @InvokeBy(invokerClass = com.kwad.sdk.service.c.class, methodId = "initComponentProxyForInvoker")
    public static void register() {
        com.kwad.sdk.service.c.putComponentProxy(KsRewardVideoActivity.class, KSRewardVideoActivityProxy.class);
    }

    private void registerLiveBroadcastReceiver() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("REWARD_LIVE_ACTION_VERIFY");
        intentFilter.addAction("REWARD_LIVE_ACTION_PROGRESS");
        af.dj(getActivity()).a(this.mLiveBroadcastReceiver, intentFilter);
    }

    private void reportSubPageCreate(String str) {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        com.kwad.components.ad.reward.monitor.d.c(true, cVar != null ? cVar.getAdTemplate() : null, str);
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean checkIntentData(@Nullable Intent intent) {
        com.kwad.components.ad.reward.model.c cVarA = com.kwad.components.ad.reward.model.c.a(intent);
        this.mModel = cVarA;
        return cVarA != null;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void finish() {
        super.finish();
        this.mAdOpenInteractionListener.i(false);
    }

    @Override // com.kwad.components.core.proxy.f
    public int getLayoutId() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        return (cVar == null || !cVar.jM) ? R.layout.ksad_activity_reward_video_legacy : R.layout.ksad_activity_reward_neo;
    }

    @Override // com.kwad.components.core.proxy.f
    public String getPageName() {
        return "KSRewardLandScapeVideoActivityProxy";
    }

    @Override // com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor
    public boolean handledAdLiveOnResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.proxy.f
    public void initData() {
        this.listenerKey = this.mModel.getAdTemplate().getUniqueId();
        this.mAdOpenInteractionListener.setAdTemplate(this.mModel.getAdTemplate());
        this.mAdOpenInteractionListener.S(getUniqueId());
        this.mPageEnterTime = SystemClock.elapsedRealtime();
        com.kwad.components.ad.reward.monitor.d.a(true, this.mModel.getAdTemplate(), this.mPageEnterTime, this.mModel.iL());
        com.kwad.components.ad.reward.monitor.d.g(true, this.mModel.getAdTemplate());
        com.kwad.components.core.t.c.wG().a(this);
        b.gw().a(this.mRewardVerifyListener);
    }

    @Override // com.kwad.components.core.proxy.f
    public void initView() {
        this.mRootContainer = (AdBaseFrameLayout) findViewById(R.id.ksad_root_container);
    }

    @Override // com.kwad.components.ad.reward.g.b
    public boolean interceptPlayCardResume() {
        return needHandledOnResume();
    }

    @Override // com.kwad.components.core.proxy.f
    public boolean needAdaptionScreen() {
        return true;
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f
    public void onActivityCreate() {
        super.onActivityCreate();
        com.kwad.sdk.commercial.convert.c.ch(this.mModel.getAdTemplate());
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onBackPressed() {
        n nVar = this.mRewardPresenter;
        if (nVar == null) {
            super.onBackPressed();
            return;
        }
        BackPressHandleResult backPressHandleResultHJ = nVar.hJ();
        if (backPressHandleResultHJ.equals(BackPressHandleResult.HANDLED)) {
            return;
        }
        if (backPressHandleResultHJ.equals(BackPressHandleResult.HANDLED_CLOSE)) {
            super.onBackPressed();
            this.mAdOpenInteractionListener.i(false);
        } else if (this.mIsBackEnable) {
            this.mAdOpenInteractionListener.i(false);
            super.onBackPressed();
        }
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        registerLiveBroadcastReceiver();
    }

    @Override // com.kwad.components.core.proxy.f
    public void onCreateCaughtException(Throwable th) {
        super.onCreateCaughtException(th);
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        com.kwad.components.ad.reward.monitor.c.b(true, cVar != null ? cVar.getAdTemplate() : null);
    }

    @Override // com.kwad.components.core.n.b
    public Presenter onCreatePresenter() {
        com.kwad.components.ad.reward.model.c cVar = this.mModel;
        if (cVar == null) {
            return null;
        }
        n nVar = new n(this, this.mContext, this.mRootContainer, cVar, (g) this.mCallerContext);
        this.mRewardPresenter = nVar;
        nVar.a(this);
        return this.mRewardPresenter;
    }

    @Override // com.kwad.components.core.proxy.f, com.kwad.components.core.proxy.a.c
    public void onCreateStageChange(PageCreateStage pageCreateStage) {
        super.onCreateStageChange(pageCreateStage);
        com.kwad.sdk.core.d.c.d("RewardVideo", "onCreateStageChange: " + pageCreateStage.getStage());
        reportSubPageCreate(pageCreateStage.getStage());
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onDestroy() {
        try {
            b.gw().b(this.mRewardVerifyListener);
            super.onDestroy();
            this.mAdOpenInteractionListener.i(false);
            if (this.mCallerContext != 0) {
                i.hE().I(String.valueOf(((g) this.mCallerContext).mAdTemplate));
                com.kwad.components.ad.reward.e.f.R(getUniqueId());
            }
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                String strM = com.kwad.sdk.core.response.helper.a.M(cVar.da());
                if (!TextUtils.isEmpty(strM)) {
                    com.kwad.sdk.core.videocache.c.a.cm(this.mContext.getApplicationContext()).fA(strM);
                }
                com.kwad.components.core.g.a.a(com.kwad.sdk.commercial.e.bA(this.mModel.getAdTemplate()));
            }
            com.kwad.components.core.t.c.wG().b(this);
            if (this.mLiveBroadcastReceiver != null) {
                af.dj(getActivity()).unregisterReceiver(this.mLiveBroadcastReceiver);
                this.mLiveBroadcastReceiver = null;
            }
            this.listenerKey = null;
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.core.t.c.b
    public void onPageClose() {
        finish();
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onPause() {
        super.onPause();
        T t = this.mCallerContext;
        if (t != 0) {
            ((g) t).mPageEnterTime = -1L;
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
        reportSubPageCreate(PageCreateStage.END_CHILD_ON_PRE_CREATE.getStage());
    }

    @Override // com.kwad.sdk.api.proxy.IActivityProxy
    public void onPreDestroy() {
        super.onPreDestroy();
        com.kwad.components.core.webview.tachikoma.e.c.zG().zH();
    }

    @Override // com.kwad.components.core.n.b, com.kwad.components.core.proxy.f, com.kwad.sdk.api.proxy.IActivityProxy
    public void onResume() {
        try {
            super.onResume();
            com.kwad.components.ad.reward.model.c cVar = this.mModel;
            if (cVar != null) {
                AdTemplate adTemplate = cVar.getAdTemplate();
                com.kwad.sdk.core.local.a.LY();
                com.kwad.sdk.core.local.a.cG(adTemplate);
            }
            if (!this.mReportedPageResume) {
                com.kwad.components.ad.reward.monitor.d.f(true, this.mModel.getAdTemplate());
                this.mReportedPageResume = true;
            }
            com.kwad.components.ad.reward.c.a.ih().R(this.mContext);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.components.ad.reward.n.a
    public void onUnbind() {
        this.mIsBackEnable = false;
        ((g) this.mCallerContext).G(false);
        ((g) this.mCallerContext).sT = false;
    }

    @Override // com.kwad.components.core.n.b
    public g onCreateCallerContext() {
        AdResultData adResultDataIH = this.mModel.iH();
        AdTemplate adTemplate = this.mModel.getAdTemplate();
        AdInfo adInfoDa = this.mModel.da();
        final g gVar = new g(this);
        gVar.mPageEnterTime = this.mPageEnterTime;
        gVar.sx = this.mModel.iJ() == 2;
        gVar.sy = this.mAdOpenInteractionListener;
        gVar.mAdRewardStepListener = this.mAdRewardStepListener;
        gVar.mScreenOrientation = this.mModel.getScreenOrientation();
        gVar.mVideoPlayConfig = this.mModel.iI();
        gVar.mReportExtData = this.mModel.iK();
        gVar.mRootContainer = this.mRootContainer;
        gVar.mStartRenderTime = this.mStartRenderTime;
        gVar.a(adResultDataIH);
        gVar.tt = com.kwad.sdk.core.response.helper.b.eI(adInfoDa) ? LoadStrategy.FULL_TK : LoadStrategy.MULTI;
        gVar.a(this);
        if (com.kwad.sdk.core.response.helper.a.aL(adInfoDa)) {
            gVar.mApkDownloadHelper = new com.kwad.components.core.e.d.d(adTemplate, this.mModel.iK());
        }
        gVar.sB = new RewardActionBarControl(gVar, this.mContext, adTemplate);
        gVar.b(this.mPlayEndPageListener);
        if (com.kwad.sdk.core.response.helper.b.dk(adTemplate)) {
            j jVar = new j(gVar, this.mModel.iK(), null);
            gVar.sC = jVar;
            jVar.a(new com.kwad.components.ad.reward.c.d() { // from class: com.kwad.components.ad.reward.KSRewardVideoActivityProxy.6
                @Override // com.kwad.components.ad.reward.c.d
                public final void a(com.kwad.components.ad.reward.c.b bVar) {
                    gVar.b(bVar);
                }
            });
        }
        if (com.kwad.sdk.core.response.helper.a.ay(adInfoDa)) {
            gVar.sD = new com.kwad.components.ad.l.a().ai(true);
        }
        gVar.sO = true;
        if (com.kwad.sdk.core.response.helper.a.bQ(adInfoDa)) {
            gVar.sA = new com.kwad.components.core.playable.a((KsAdWebView) findViewById(R.id.ksad_playable_webview));
        }
        gVar.tm = 0L;
        if (this.mModel.da() != null) {
            gVar.tm = com.kwad.sdk.core.response.helper.a.bQ(this.mModel.da()) ? com.kwad.sdk.core.response.helper.a.ax(this.mModel.da()) : com.kwad.sdk.core.response.helper.a.aq(this.mModel.da());
        }
        gVar.mTimerHelper = getTimerHelper();
        gVar.sz = new com.kwad.components.ad.reward.m.e(gVar);
        gVar.jM = this.mModel.jM;
        return gVar;
    }
}
