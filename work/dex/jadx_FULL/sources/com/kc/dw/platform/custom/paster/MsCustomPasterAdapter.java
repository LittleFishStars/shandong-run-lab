package com.kc.dw.platform.custom.paster;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kc.dw.ad.interstitial.c;
import com.kc.dw.core.ad.BaseAdSlot;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.paster.PasterAdLoadListener;
import com.kc.dw.core.ad.paster.PasterCommonAdLoader;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.router.log.bean.ClickAdState;
import com.kc.dw.core.router.log.bean.ShowAdState;
import com.kc.dw.core.service.logrecord.a;
import com.kc.dw.core.service.logrecord.b;
import com.kc.dw.core.utils.SdkHandler;
import com.kc.dw.core.utils.f;
import com.kc.dw.core.utils.g0;
import com.kc.dw.core.utils.j;
import com.kc.dw.core.utils.z;
import com.kc.dw.own.paster.OwnCustomPasterAd;
import com.kc.dw.own.paster.OwnPasterAdapter;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.custom.CustomFactory;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.CustomInitLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class MsCustomPasterAdapter extends BasePlatformLoader<PasterCommonAdLoader, PasterAdLoadListener> {
    private BaseAdSlot baseAdSlot;
    private MsCustomPasterAd customPasterAd;

    /* JADX INFO: renamed from: com.kc.dw.platform.custom.paster.MsCustomPasterAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements CustomInitLoader.InitCallback {
        public final MsCustomPasterAdapter this$0;

        public AnonymousClass1(MsCustomPasterAdapter msCustomPasterAdapter) {
            this.this$0 = msCustomPasterAdapter;
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
            SdkHandler.runOnMainThread(new Runnable(this) { // from class: com.kc.dw.platform.custom.paster.MsCustomPasterAdapter.1.1
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
                        MsCustomPasterAdapter msCustomPasterAdapter = this.this$1.this$0;
                        msCustomPasterAdapter.loadCustomAd(msCustomPasterAdapter.getAdLoader().getContext(), this.this$1.this$0.getAdLoader().getAdSlot(), customInfo);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void initBaseAdSlot() {
        if (this instanceof OwnPasterAdapter) {
            OwnPasterAdapter ownPasterAdapter = (OwnPasterAdapter) this;
            if (ownPasterAdapter.getBaseAdSlot() != null) {
                this.baseAdSlot = ownPasterAdapter.getBaseAdSlot();
            }
        }
    }

    public void callAdClicked() {
        if (!TextUtils.isEmpty(getSdkAdInfo().getClk())) {
            c.a(getContext(), f.a(getSdkAdInfo().getClk(), this.customPasterAd));
        }
        initBaseAdSlot();
        ClickAdState clickAdState = new ClickAdState();
        BaseAdSlot baseAdSlot = this.baseAdSlot;
        int clkActType = baseAdSlot != null ? baseAdSlot.getClkActType() : -1;
        BaseAdSlot baseAdSlot2 = this.baseAdSlot;
        a.a(5, "e8", this, clickAdState.setData(clkActType, baseAdSlot2 != null ? baseAdSlot2.getClkPower() : -1));
        if (this.customPasterAd.getInteractionListener() != null) {
            this.customPasterAd.getInteractionListener().onAdClicked();
        }
    }

    public void callAdClosed() {
        MsCustomPasterAd msCustomPasterAd = this.customPasterAd;
        if (msCustomPasterAd != null && msCustomPasterAd.getInteractionListener() != null) {
            this.customPasterAd.getInteractionListener().onAdClosed();
        }
        a.a(5, "click_close", this);
    }

    public void callAdExposure() {
        if (!TextUtils.isEmpty(getSdkAdInfo().getImp())) {
            g0.a(getSdkAdInfo(), this.customPasterAd.getAdView());
            c.a(getContext(), g0.a(getSdkAdInfo().getImp()));
        }
        initBaseAdSlot();
        com.kc.dw.core.service.logrecord.util.c.d(this);
        a.a(5, "s7", this, new ShowAdState().setSuccess(b.a(this.baseAdSlot, getSdkAdInfo(), Integer.MAX_VALUE), b.a(this.baseAdSlot)));
        MsCustomPasterAd msCustomPasterAd = this.customPasterAd;
        if (msCustomPasterAd == null || msCustomPasterAd.getInteractionListener() == null) {
            return;
        }
        this.customPasterAd.getInteractionListener().onAdExposure();
    }

    public void callLoadedError(int i, String str) {
        if (getConCurrentListener() != null) {
            getConCurrentListener().onLoadedError(i, str);
        }
    }

    public void callLoadedSuccess() {
        this.customPasterAd = this instanceof OwnPasterAdapter ? new OwnCustomPasterAd(this, getPlatform(), ((OwnPasterAdapter) this).getPasterAd()) : new MsCustomPasterAd(this, getPlatform());
        try {
            if (getLoaderListener() instanceof InteractionListener) {
                this.customPasterAd.setInteractionListener((InteractionListener) getLoaderListener());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (getConCurrentListener() != null) {
            getConCurrentListener().onLoadedSuccess(this.customPasterAd);
        }
    }

    public void callRenderError(int i, String str) {
        com.kc.dw.core.service.logrecord.util.c.b(this);
        a.a(5, "f5", this, i, str);
        if (getConCurrentListener() != null) {
            getConCurrentListener().a(this.customPasterAd, i, str);
        }
    }

    public void callRenderSuccess() {
        if (getConCurrentListener() != null) {
            getConCurrentListener().onRenderSuccess(this.customPasterAd);
        }
        com.kc.dw.core.service.logrecord.util.c.b(this);
        a.a(5, "s5", this);
    }

    public void callVideoComplete() {
        if (getLoaderListener() instanceof PasterAdLoadListener) {
            ((PasterAdLoadListener) getLoaderListener()).onVideoComplete();
        }
    }

    public void callVideoLoaded() {
        if (getLoaderListener() instanceof PasterAdLoadListener) {
            ((PasterAdLoadListener) getLoaderListener()).onVideoLoaded();
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

    public void setEcpm(int i) {
        if (getSdkAdInfo() != null) {
            getSdkAdInfo().setEcpm(String.valueOf(i));
        }
    }

    public abstract void showAd(ViewGroup viewGroup);
}
