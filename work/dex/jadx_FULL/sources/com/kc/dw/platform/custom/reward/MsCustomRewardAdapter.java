package com.kc.dw.platform.custom.reward;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.kc.dw.ad.interstitial.c;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.reward.RewardAdLoadListener;
import com.kc.dw.core.ad.reward.RewardInteractionListener;
import com.kc.dw.core.ad.reward.RewardVideoCommonLoader;
import com.kc.dw.core.router.log.bean.ClickAdState;
import com.kc.dw.core.router.log.bean.ShowAdState;
import com.kc.dw.core.service.logrecord.a;
import com.kc.dw.core.service.logrecord.b;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.f;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.j;
import com.kc.dw.core.utils.z;
import com.kc.dw.own.reward.OwnCustomRewardAd;
import com.kc.dw.own.reward.OwnRewardAdapter;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.custom.CustomFactory;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class MsCustomRewardAdapter extends BasePlatformLoader<RewardVideoCommonLoader, RewardAdLoadListener> {
    private static final String TAG = "MsCustomRewardAdapter";
    private BaseAdSlot baseAdSlot;
    private MsCustomRewardAd customRewardAd;
    private boolean isRenderSuccess;
    private boolean isShowed;

    /* JADX INFO: renamed from: com.kc.dw.platform.custom.reward.MsCustomRewardAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements CustomInitLoader.InitCallback {
        public final MsCustomRewardAdapter this$0;

        public AnonymousClass1(MsCustomRewardAdapter msCustomRewardAdapter) {
            this.this$0 = msCustomRewardAdapter;
        }

        @Override // com.kc.dw.platform.custom.CustomInitLoader.InitCallback
        public void fail() {
            try {
                if (this.this$0.getConCurrentListener() != null) {
                    this.this$0.getConCurrentListener().onLoadedError(200001, "ADN init error");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.kc.dw.platform.custom.CustomInitLoader.InitCallback
        public void succ() {
            SdkHandler.runOnMainThread(new Runnable(this) { // from class: com.kc.dw.platform.custom.reward.MsCustomRewardAdapter.1.1
                public final AnonymousClass1 this$1;

                {
                    this.this$1 = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        CustomInfo customInfo = new CustomInfo();
                        if (this.this$1.this$0.getSdkAdInfo() != null && !"SSD".equals(this.this$1.this$0.getSdkAdInfo().getSdk())) {
                            a.a(5, "e2", this.this$1.this$0);
                            z.a(this.this$1.this$0.getAdLoader().getContext(), g0.a(this.this$1.this$0.getSdkAdInfo().getReq()), new j());
                            customInfo.setApp_id(this.this$1.this$0.getSdkAdInfo().getApp_id());
                            customInfo.setApp_key(this.this$1.this$0.getSdkAdInfo().getApp_key());
                            customInfo.setReqId(this.this$1.this$0.getSdkAdInfo().getReq_id());
                            customInfo.setPid(this.this$1.this$0.getSdkAdInfo().getPid());
                            if (this.this$1.this$0.getSdkAdInfo().getDrawing() == 1) {
                                customInfo.setExpress(false);
                            } else {
                                customInfo.setExpress(true);
                            }
                        }
                        MsCustomRewardAdapter msCustomRewardAdapter = this.this$1.this$0;
                        msCustomRewardAdapter.loadCustomAd(msCustomRewardAdapter.getAdLoader().getContext(), this.this$1.this$0.getAdLoader().getAdSlot(), customInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void initBaseAdSlot() {
        if (this instanceof OwnRewardAdapter) {
            OwnRewardAdapter ownRewardAdapter = (OwnRewardAdapter) this;
            if (ownRewardAdapter.getBaseAdSlot() != null) {
                this.baseAdSlot = ownRewardAdapter.getBaseAdSlot();
            }
        }
    }

    public void callAdClicked() {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            c.a(getContext(), f.a(getSdkAdInfo().getClk(), this.customRewardAd));
        }
        initBaseAdSlot();
        ClickAdState clickAdState = new ClickAdState();
        BaseAdSlot baseAdSlot = this.baseAdSlot;
        int clkActType = baseAdSlot != null ? baseAdSlot.getClkActType() : -1;
        BaseAdSlot baseAdSlot2 = this.baseAdSlot;
        a.a(5, "e8", this, clickAdState.setData(clkActType, baseAdSlot2 != null ? baseAdSlot2.getClkPower() : -1));
        if (this.customRewardAd.getInteractionListener() != null) {
            this.customRewardAd.getInteractionListener().onAdClicked();
        }
    }

    public void callAdClosed() {
        MsCustomRewardAd msCustomRewardAd = this.customRewardAd;
        if (msCustomRewardAd != null && msCustomRewardAd.getInteractionListener() != null) {
            this.customRewardAd.getInteractionListener().onAdClosed();
        }
        a.a(5, "click_close", this);
    }

    public void callAdExposure() {
        if (!TextUtils.isEmpty(getSdkAdInfo().getImp())) {
            c.a(getContext(), g0.a(getSdkAdInfo().getImp()));
        }
        initBaseAdSlot();
        com.kc.dw.core.service.logrecord.util.c.d(this);
        a.a(5, "s7", this, new ShowAdState().setSuccess(b.a(this.baseAdSlot, getSdkAdInfo(), AdType.REWARD.value()), b.a(this.baseAdSlot)));
        MsCustomRewardAd msCustomRewardAd = this.customRewardAd;
        if (msCustomRewardAd == null || msCustomRewardAd.getInteractionListener() == null) {
            return;
        }
        this.customRewardAd.getInteractionListener().onAdExposure();
    }

    public void callLoadedError(int i, String str) {
        if (getConCurrentListener() != null) {
            getConCurrentListener().onLoadedError(i, str);
        }
    }

    public void callLoadedSuccess() {
        this.customRewardAd = this instanceof OwnRewardAdapter ? new OwnCustomRewardAd(this, getPlatform(), ((OwnRewardAdapter) this).getRewardVideoAd()) : new MsCustomRewardAd(this, getPlatform());
        try {
            if (getLoaderListener() instanceof RewardInteractionListener) {
                this.customRewardAd.setInteractionListener((RewardInteractionListener) getLoaderListener());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getConCurrentListener() != null) {
            getConCurrentListener().onLoadedSuccess(this.customRewardAd);
        }
    }

    public void callRenderError(int i, String str) {
        com.kc.dw.core.service.logrecord.util.c.b(this);
        a.a(5, "f5", this, i, str);
        if (getConCurrentListener() != null) {
            getConCurrentListener().a(this.customRewardAd, i, str);
        }
    }

    public void callRenderSuccess() {
        com.kc.dw.core.service.logrecord.util.c.b(this);
        a.a(5, "s5", this);
        this.isRenderSuccess = true;
        if (this.isShowed && !"SSD".equals(getPlatform())) {
            a.a(5, "e7", this);
        }
        if (getConCurrentListener() != null) {
            getConCurrentListener().onRenderSuccess(this.customRewardAd);
        }
    }

    public void callReward(Map<String, Object> map) {
        MsCustomRewardAd msCustomRewardAd = this.customRewardAd;
        if (msCustomRewardAd != null && (msCustomRewardAd.getInteractionListener() instanceof RewardInteractionListener)) {
            ((RewardInteractionListener) this.customRewardAd.getInteractionListener()).onReward(map);
        }
        a.a(5, "reward_succ", this);
    }

    public void callSkippedVideo() {
        MsCustomRewardAd msCustomRewardAd = this.customRewardAd;
        if (msCustomRewardAd != null && msCustomRewardAd.getRewardAdMediaListener() != null) {
            this.customRewardAd.getRewardAdMediaListener().onSkippedVideo();
        }
        a.a(10, "click_skip", this);
    }

    public void callVideoCompleted() {
        MsCustomRewardAd msCustomRewardAd = this.customRewardAd;
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        this.customRewardAd.getRewardAdMediaListener().onVideoCompleted();
    }

    public void callVideoError() {
        MsCustomRewardAd msCustomRewardAd = this.customRewardAd;
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        this.customRewardAd.getRewardAdMediaListener().onVideoError();
    }

    public void callVideoLoaded() {
        MsCustomRewardAd msCustomRewardAd = this.customRewardAd;
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        this.customRewardAd.getRewardAdMediaListener().onVideoLoaded();
    }

    public void callVideoPause() {
        MsCustomRewardAd msCustomRewardAd = this.customRewardAd;
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        this.customRewardAd.getRewardAdMediaListener().onVideoPause();
    }

    public void callVideoResume() {
        MsCustomRewardAd msCustomRewardAd = this.customRewardAd;
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        this.customRewardAd.getRewardAdMediaListener().onVideoResume();
    }

    public void callVideoStart() {
        MsCustomRewardAd msCustomRewardAd = this.customRewardAd;
        if (msCustomRewardAd == null || msCustomRewardAd.getRewardAdMediaListener() == null) {
            return;
        }
        this.customRewardAd.getRewardAdMediaListener().onVideoStart();
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public String getPlatform() {
        CustomInitLoader initLoader;
        try {
            return (getSdkAdInfo() == null || TextUtils.isEmpty(getSdkAdInfo().getInitCls()) || (initLoader = CustomFactory.getInitLoader(getSdkAdInfo().getInitCls())) == null) ? "SSD" : initLoader.getPlatform();
        } catch (Exception e) {
            e.printStackTrace();
            return "SSD";
        }
    }

    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void loadAd() {
        initADN(new AnonymousClass1(this));
    }

    public abstract void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo);

    public void render() {
    }

    public void setAdShowStatus(boolean z) {
        this.isShowed = z;
        if (z && this.isRenderSuccess && !"SSD".equals(getPlatform())) {
            a.a(5, "e7", this);
        }
    }

    public void setEcpm(int i) {
        if (getSdkAdInfo() != null) {
            getSdkAdInfo().setEcpm(String.valueOf(i));
        }
    }

    public abstract void showAd(Activity activity);
}
