package com.kc.dw.platform.custom.fullscreen;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.kc.dw.ad.interstitial.c;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.fullscreenvideo.FullScreenAdLoadListener;
import com.kc.dw.core.ad.fullscreenvideo.FullScreenVideoCommonAdLoader;
import com.kc.dw.core.loader.InteractionListener;
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
import com.kc.dw.own.fullscreen.OwnCustomFullScreenAd;
import com.kc.dw.own.fullscreen.OwnFullscreenAdapter;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.custom.CustomFactory;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class MsCustomFullScreenAdapter extends BasePlatformLoader<FullScreenVideoCommonAdLoader, FullScreenAdLoadListener> {
    private static final String TAG = "MsCustomFullScreenAdapt";
    private BaseAdSlot baseAdSlot;
    private MsCustomFullScreenAd customFullScreenAd;
    private boolean isRenderSuccess;
    private boolean isShowed;

    /* JADX INFO: renamed from: com.kc.dw.platform.custom.fullscreen.MsCustomFullScreenAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements CustomInitLoader.InitCallback {
        public final MsCustomFullScreenAdapter this$0;

        public AnonymousClass1(MsCustomFullScreenAdapter msCustomFullScreenAdapter) {
            this.this$0 = msCustomFullScreenAdapter;
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
            SdkHandler.runOnMainThread(new Runnable(this) { // from class: com.kc.dw.platform.custom.fullscreen.MsCustomFullScreenAdapter.1.1
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
                        MsCustomFullScreenAdapter msCustomFullScreenAdapter = this.this$1.this$0;
                        msCustomFullScreenAdapter.loadCustomAd(msCustomFullScreenAdapter.getAdLoader().getContext(), this.this$1.this$0.getAdLoader().getAdSlot(), customInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void initBaseAdSlot() {
        if (this instanceof OwnFullscreenAdapter) {
            OwnFullscreenAdapter ownFullscreenAdapter = (OwnFullscreenAdapter) this;
            if (ownFullscreenAdapter.getBaseAdSlot() != null) {
                this.baseAdSlot = ownFullscreenAdapter.getBaseAdSlot();
            }
        }
    }

    public void callAdClicked() {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            c.a(getContext(), f.a(getSdkAdInfo().getClk(), this.customFullScreenAd));
        }
        initBaseAdSlot();
        ClickAdState clickAdState = new ClickAdState();
        BaseAdSlot baseAdSlot = this.baseAdSlot;
        int clkActType = baseAdSlot != null ? baseAdSlot.getClkActType() : -1;
        BaseAdSlot baseAdSlot2 = this.baseAdSlot;
        a.a(5, "e8", this, clickAdState.setData(clkActType, baseAdSlot2 != null ? baseAdSlot2.getClkPower() : -1));
        if (this.customFullScreenAd.getInteractionListener() != null) {
            this.customFullScreenAd.getInteractionListener().onAdClicked();
        }
    }

    public void callAdClosed() {
        MsCustomFullScreenAd msCustomFullScreenAd = this.customFullScreenAd;
        if (msCustomFullScreenAd != null && msCustomFullScreenAd.getInteractionListener() != null) {
            this.customFullScreenAd.getInteractionListener().onAdClosed();
        }
        a.a(5, "click_close", this);
    }

    public void callAdExposure() {
        if (!TextUtils.isEmpty(getSdkAdInfo().getImp())) {
            c.a(getContext(), g0.a(getSdkAdInfo().getImp()));
        }
        initBaseAdSlot();
        com.kc.dw.core.service.logrecord.util.c.d(this);
        a.a(5, "s7", this, new ShowAdState().setSuccess(b.a(this.baseAdSlot, getSdkAdInfo(), Integer.MAX_VALUE), b.a(this.baseAdSlot)));
        MsCustomFullScreenAd msCustomFullScreenAd = this.customFullScreenAd;
        if (msCustomFullScreenAd == null || msCustomFullScreenAd.getInteractionListener() == null) {
            return;
        }
        this.customFullScreenAd.getInteractionListener().onAdExposure();
    }

    public void callLoadedError(int i, String str) {
        if (getConCurrentListener() != null) {
            getConCurrentListener().onLoadedError(i, str);
        }
    }

    public void callLoadedSuccess() {
        this.customFullScreenAd = this instanceof OwnFullscreenAdapter ? new OwnCustomFullScreenAd(this, getPlatform(), ((OwnFullscreenAdapter) this).getAd()) : new MsCustomFullScreenAd(this, getPlatform());
        try {
            if (getLoaderListener() instanceof InteractionListener) {
                this.customFullScreenAd.setInteractionListener((InteractionListener) getLoaderListener());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getConCurrentListener() != null) {
            getConCurrentListener().onLoadedSuccess(this.customFullScreenAd);
        }
    }

    public void callRenderError(int i, String str) {
        com.kc.dw.core.service.logrecord.util.c.b(this);
        a.a(5, "f5", this, i, str);
        if (getConCurrentListener() != null) {
            getConCurrentListener().a(this.customFullScreenAd, i, str);
        }
    }

    public void callRenderSuccess() {
        com.kc.dw.core.service.logrecord.util.c.b(this);
        a.a(5, "s5", this);
        if (getConCurrentListener() != null) {
            getConCurrentListener().onRenderSuccess(this.customFullScreenAd);
        }
        this.isRenderSuccess = true;
        if (!this.isShowed || "SSD".equals(getPlatform())) {
            return;
        }
        a.a(5, "e7", this);
    }

    public void callSkippedVideo() {
        MsCustomFullScreenAd msCustomFullScreenAd = this.customFullScreenAd;
        if (msCustomFullScreenAd == null || msCustomFullScreenAd.getMediaListener() == null) {
            return;
        }
        this.customFullScreenAd.getMediaListener().onSkippedVideo();
    }

    public void callVideoCompleted() {
        MsCustomFullScreenAd msCustomFullScreenAd = this.customFullScreenAd;
        if (msCustomFullScreenAd == null || msCustomFullScreenAd.getMediaListener() == null) {
            return;
        }
        this.customFullScreenAd.getMediaListener().onVideoCompleted();
    }

    public void callVideoError() {
        MsCustomFullScreenAd msCustomFullScreenAd = this.customFullScreenAd;
        if (msCustomFullScreenAd == null || msCustomFullScreenAd.getMediaListener() == null) {
            return;
        }
        this.customFullScreenAd.getMediaListener().onVideoError();
    }

    public void callVideoLoaded() {
        MsCustomFullScreenAd msCustomFullScreenAd = this.customFullScreenAd;
        if (msCustomFullScreenAd == null || msCustomFullScreenAd.getMediaListener() == null) {
            return;
        }
        this.customFullScreenAd.getMediaListener().onVideoLoaded();
    }

    public void callVideoPause() {
        MsCustomFullScreenAd msCustomFullScreenAd = this.customFullScreenAd;
        if (msCustomFullScreenAd == null || msCustomFullScreenAd.getMediaListener() == null) {
            return;
        }
        this.customFullScreenAd.getMediaListener().onVideoPause();
    }

    public void callVideoResume() {
        MsCustomFullScreenAd msCustomFullScreenAd = this.customFullScreenAd;
        if (msCustomFullScreenAd == null || msCustomFullScreenAd.getMediaListener() == null) {
            return;
        }
        this.customFullScreenAd.getMediaListener().onVideoResume();
    }

    public void callVideoStart() {
        MsCustomFullScreenAd msCustomFullScreenAd = this.customFullScreenAd;
        if (msCustomFullScreenAd == null || msCustomFullScreenAd.getMediaListener() == null) {
            return;
        }
        this.customFullScreenAd.getMediaListener().onVideoStart();
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

    public void onVideoCompleted(MsCustomFullScreenAd msCustomFullScreenAd) {
        if (msCustomFullScreenAd == null || msCustomFullScreenAd.getMediaListener() == null) {
            return;
        }
        msCustomFullScreenAd.getMediaListener().onVideoCompleted();
    }

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
