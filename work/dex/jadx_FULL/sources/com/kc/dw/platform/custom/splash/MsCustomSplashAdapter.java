package com.kc.dw.platform.custom.splash;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kc.dw.ad.interstitial.c;
import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.splash.SplashAdLoadListener;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.ad.splash.SplashInteractionListener;
import com.kc.dw.core.domain.SdkAdInfo;
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
import com.kc.dw.own.splash.OwnCustomSplashAd;
import com.kc.dw.own.splash.OwnSplashAdapter;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.custom.CustomFactory;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class MsCustomSplashAdapter extends BasePlatformLoader<SplashCommonAdLoader, SplashAdLoadListener> {
    private static final String TAG = "MsCustomSplashAdapter";
    private BaseAdSlot baseAdSlot;
    private MsCustomSplashAd customSplashAd;
    private volatile boolean isClosed;
    private boolean isRenderSuccess;
    private boolean isShowed;

    /* JADX INFO: renamed from: com.kc.dw.platform.custom.splash.MsCustomSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements CustomInitLoader.InitCallback {
        public final MsCustomSplashAdapter this$0;

        public AnonymousClass1(MsCustomSplashAdapter msCustomSplashAdapter) {
            this.this$0 = msCustomSplashAdapter;
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
            SdkHandler.runOnMainThread(new Runnable(this) { // from class: com.kc.dw.platform.custom.splash.MsCustomSplashAdapter.1.1
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
                            LogUtil.d(MsCustomSplashAdapter.TAG, "start req");
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
                        MsCustomSplashAdapter msCustomSplashAdapter = this.this$1.this$0;
                        msCustomSplashAdapter.loadCustomAd(msCustomSplashAdapter.getAdLoader().getContext(), this.this$1.this$0.getAdLoader().getAdSlot(), customInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void initBaseAdSlot() {
        if (this instanceof OwnSplashAdapter) {
            OwnSplashAdapter ownSplashAdapter = (OwnSplashAdapter) this;
            if (ownSplashAdapter.getBaseAdSlot() != null) {
                this.baseAdSlot = ownSplashAdapter.getBaseAdSlot();
            }
        }
    }

    public void callAdClicked() {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            c.a(getContext(), f.a(getSdkAdInfo().getClk(), this.customSplashAd));
        }
        initBaseAdSlot();
        ClickAdState clickAdState = new ClickAdState();
        BaseAdSlot baseAdSlot = this.baseAdSlot;
        int clkActType = baseAdSlot != null ? baseAdSlot.getClkActType() : -1;
        BaseAdSlot baseAdSlot2 = this.baseAdSlot;
        a.a(5, "e8", this, clickAdState.setData(clkActType, baseAdSlot2 != null ? baseAdSlot2.getClkPower() : -1));
        if (this.customSplashAd.getInteractionListener() != null) {
            this.customSplashAd.getInteractionListener().onAdClicked();
        }
    }

    public void callAdClosed() {
        MsCustomSplashAd msCustomSplashAd = this.customSplashAd;
        if (msCustomSplashAd == null || msCustomSplashAd.getInteractionListener() == null || this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.customSplashAd.getInteractionListener().onAdClosed();
        a.a(5, "click_close", this);
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    public void callAdExposure() {
        boolean zIsHasExposed;
        SdkAdInfo sdkAdInfo = getSdkAdInfo();
        if (sdkAdInfo != null) {
            try {
                if (sdkAdInfo.getAppendInfo() != null) {
                    zIsHasExposed = sdkAdInfo.getAppendInfo().isHasExposed();
                } else {
                    zIsHasExposed = false;
                }
            } catch (Exception unused) {
            }
        } else {
            zIsHasExposed = false;
        }
        if (zIsHasExposed) {
            return;
        }
        try {
            getSdkAdInfo().getAppendInfo().setHasExposed(true);
        } catch (Exception unused2) {
        }
        LogUtil.d(TAG, "send onAdExposure");
        if (!TextUtils.isEmpty(getSdkAdInfo().getImp())) {
            g0.a(getSdkAdInfo(), this.customSplashAd.getAdView());
            c.a(getContext(), g0.a(getSdkAdInfo().getImp()));
        }
        initBaseAdSlot();
        com.kc.dw.core.service.logrecord.util.c.d(this);
        a.a(5, "s7", this, new ShowAdState().setSuccess(b.a(this.baseAdSlot, getSdkAdInfo(), AdType.SPLASH.value()), b.a(this.baseAdSlot)));
        MsCustomSplashAd msCustomSplashAd = this.customSplashAd;
        if (msCustomSplashAd == null || msCustomSplashAd.getInteractionListener() == null) {
            return;
        }
        this.customSplashAd.getInteractionListener().onAdExposure();
    }

    public void callAdSkip() {
        MsCustomSplashAd msCustomSplashAd = this.customSplashAd;
        if (msCustomSplashAd == null || msCustomSplashAd.getInteractionListener() == null) {
            return;
        }
        ((SplashInteractionListener) this.customSplashAd.getInteractionListener()).onSkip();
        a.a(5, "click_skip", this);
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.customSplashAd.getInteractionListener().onAdClosed();
    }

    public void callAdTick(long j) {
        MsCustomSplashAd msCustomSplashAd = this.customSplashAd;
        if (msCustomSplashAd == null || msCustomSplashAd.getInteractionListener() == null) {
            return;
        }
        ((SplashInteractionListener) this.customSplashAd.getInteractionListener()).onTick(j);
    }

    public void callAdTimeOver() {
        MsCustomSplashAd msCustomSplashAd = this.customSplashAd;
        if (msCustomSplashAd == null || msCustomSplashAd.getInteractionListener() == null) {
            return;
        }
        ((SplashInteractionListener) this.customSplashAd.getInteractionListener()).onTimeOver();
        a.a(10, "time_over", this);
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.customSplashAd.getInteractionListener().onAdClosed();
    }

    public void callLoadedError(int i, String str) {
        if (getConCurrentListener() != null) {
            getConCurrentListener().onLoadedError(i, str);
        }
    }

    public void callLoadedSuccess() {
        this.customSplashAd = this instanceof OwnSplashAdapter ? new OwnCustomSplashAd(this, getPlatform(), ((OwnSplashAdapter) this).getSplashAd()) : new MsCustomSplashAd(this, getPlatform());
        try {
            if (getLoaderListener() instanceof SplashInteractionListener) {
                this.customSplashAd.setInteractionListener((SplashInteractionListener) getLoaderListener());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getConCurrentListener() != null) {
            getConCurrentListener().onLoadedSuccess(this.customSplashAd);
        }
    }

    public void callRenderError(int i, String str) {
        if (getConCurrentListener() != null) {
            getConCurrentListener().a(this.customSplashAd, i, str);
        }
        com.kc.dw.core.service.logrecord.util.c.b(this);
        a.a(5, "f5", this, i, str);
    }

    public void callRenderSuccess() {
        com.kc.dw.core.service.logrecord.util.c.b(this);
        a.a(5, "s5", this);
        this.isRenderSuccess = true;
        if (this.isShowed && !"SSD".equals(getPlatform())) {
            a.a(5, "e7", this);
        }
        if (getConCurrentListener() != null) {
            getConCurrentListener().onRenderSuccess(this.customSplashAd);
        }
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

    public abstract void showAd(ViewGroup viewGroup);
}
