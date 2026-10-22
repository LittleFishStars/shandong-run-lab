package com.kc.dw.platform.custom.draw;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kc.dw.ad.interstitial.c;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.draw.DrawAdLoadListener;
import com.kc.dw.core.ad.draw.DrawCommonAdLoader;
import com.kc.dw.core.ad.draw.DrawInteractionListener;
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
import com.kc.dw.own.draw.OwnCustomDrawAd;
import com.kc.dw.own.draw.OwnDrawAdapter;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.custom.CustomFactory;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class MsCustomDrawAdapter extends BasePlatformLoader<DrawCommonAdLoader, DrawAdLoadListener> {
    private static final String TAG = "MsCustomDrawAdapter";
    private BaseAdSlot baseAdSlot;
    private MsCustomDrawAd customDrawAd;
    private boolean isRenderSuccess;
    private boolean isShowed;

    /* JADX INFO: renamed from: com.kc.dw.platform.custom.draw.MsCustomDrawAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements CustomInitLoader.InitCallback {
        public final MsCustomDrawAdapter this$0;

        public AnonymousClass1(MsCustomDrawAdapter msCustomDrawAdapter) {
            this.this$0 = msCustomDrawAdapter;
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
            SdkHandler.runOnMainThread(new Runnable(this) { // from class: com.kc.dw.platform.custom.draw.MsCustomDrawAdapter.1.1
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
                        MsCustomDrawAdapter msCustomDrawAdapter = this.this$1.this$0;
                        msCustomDrawAdapter.loadCustomAd(msCustomDrawAdapter.getAdLoader().getContext(), this.this$1.this$0.getAdLoader().getAdSlot(), customInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void initBaseAdSlot() {
        if (this instanceof OwnDrawAdapter) {
            OwnDrawAdapter ownDrawAdapter = (OwnDrawAdapter) this;
            if (ownDrawAdapter.getBaseAdSlot() != null) {
                this.baseAdSlot = ownDrawAdapter.getBaseAdSlot();
            }
        }
    }

    public void callAdClicked() {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            LogUtil.d(TAG, "send onAdClicked");
            c.a(getContext(), f.a(getSdkAdInfo().getClk(), this.customDrawAd));
        }
        initBaseAdSlot();
        ClickAdState clickAdState = new ClickAdState();
        BaseAdSlot baseAdSlot = this.baseAdSlot;
        int clkActType = baseAdSlot != null ? baseAdSlot.getClkActType() : -1;
        BaseAdSlot baseAdSlot2 = this.baseAdSlot;
        a.a(5, "e8", this, clickAdState.setData(clkActType, baseAdSlot2 != null ? baseAdSlot2.getClkPower() : -1));
        if (this.customDrawAd.getInteractionListener() != null) {
            this.customDrawAd.getInteractionListener().onAdClicked();
        }
    }

    public void callAdClosed() {
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd != null && msCustomDrawAd.getInteractionListener() != null) {
            this.customDrawAd.getInteractionListener().onAdClosed();
        }
        a.a(10, "click_close", this);
    }

    public void callAdExposure() {
        g0.a(getSdkAdInfo(), this.customDrawAd.getAdView());
        if (!TextUtils.isEmpty(getSdkAdInfo().getImp())) {
            c.a(getContext(), g0.a(getSdkAdInfo().getImp()));
        }
        initBaseAdSlot();
        com.kc.dw.core.service.logrecord.util.c.d(this);
        a.a(5, "s7", this, new ShowAdState().setSuccess(b.a(this.baseAdSlot, getSdkAdInfo(), Integer.MAX_VALUE), b.a(this.baseAdSlot)));
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd == null || msCustomDrawAd.getInteractionListener() == null) {
            return;
        }
        this.customDrawAd.getInteractionListener().onAdExposure();
    }

    public void callLoadedError(int i, String str) {
        if (getConCurrentListener() != null) {
            getConCurrentListener().onLoadedError(i, str);
        }
    }

    public void callLoadedSuccess() {
        this.customDrawAd = this instanceof OwnDrawAdapter ? new OwnCustomDrawAd(this, getPlatform(), ((OwnDrawAdapter) this).getAd()) : new MsCustomDrawAd(this, getPlatform());
        try {
            if (getLoaderListener() instanceof DrawInteractionListener) {
                this.customDrawAd.setInteractionListener((DrawInteractionListener) getLoaderListener());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getConCurrentListener() != null) {
            getConCurrentListener().onLoadedSuccess(this.customDrawAd);
        }
    }

    public void callRenderError(int i, String str) {
        if (getConCurrentListener() != null) {
            getConCurrentListener().a(this.customDrawAd, i, str);
        }
        com.kc.dw.core.service.logrecord.util.c.b(this);
        a.a(5, "f5", this, i, str);
    }

    public void callRenderSuccess() {
        if (getConCurrentListener() != null) {
            getConCurrentListener().onRenderSuccess(this.customDrawAd);
        }
        com.kc.dw.core.service.logrecord.util.c.b(this);
        a.a(5, "s5", this);
        this.isRenderSuccess = true;
        if (!this.isShowed || "SSD".equals(getPlatform())) {
            return;
        }
        a.a(5, "e7", this);
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

    public void onClickRetry() {
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        this.customDrawAd.getDrawVideoListener().onClickRetry();
    }

    public void onPauseBtnClick() {
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        this.customDrawAd.getDrawVideoListener().pauseBtnClick();
    }

    public void onPlayError() {
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        this.customDrawAd.getDrawVideoListener().playError();
    }

    public void onProgressUpdate(long j, long j2) {
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        this.customDrawAd.getDrawVideoListener().onProgressUpdate(j, j2);
    }

    public void onVideoCompleted() {
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        this.customDrawAd.getDrawVideoListener().playCompletion();
    }

    public void onVideoError(int i, String str) {
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        this.customDrawAd.getDrawVideoListener().onVideoError(i, str);
    }

    public void onVideoLoaded() {
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        this.customDrawAd.getDrawVideoListener().onVideoLoad();
    }

    public void onVideoPause() {
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        this.customDrawAd.getDrawVideoListener().playPause();
    }

    public void onVideoResume() {
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        this.customDrawAd.getDrawVideoListener().playResume();
    }

    public void onVideoStart() {
        MsCustomDrawAd msCustomDrawAd = this.customDrawAd;
        if (msCustomDrawAd == null || msCustomDrawAd.getDrawVideoListener() == null) {
            return;
        }
        this.customDrawAd.getDrawVideoListener().playRenderingStart();
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
        if (getSdkAdInfo() == null || !"bidding".equals(getSdkAdInfo().getOtype())) {
            return;
        }
        getSdkAdInfo().setEcpm(String.valueOf(i));
    }

    public abstract void showAd(ViewGroup viewGroup);
}
