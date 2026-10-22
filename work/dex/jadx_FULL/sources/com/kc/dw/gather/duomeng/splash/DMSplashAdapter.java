package com.kc.dw.gather.duomeng.splash;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.domob.sdk.common.config.DMAdConfig;
import com.domob.sdk.platform.DMAdSdk;
import com.domob.sdk.platform.interfaces.ad.DMSplashAdListener;
import com.domob.sdk.platform.interfaces.ad.DMTemplateAd;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.DimensionUtils;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DMSplashAdapter extends MsCustomSplashAdapter {
    private static final String TAG = "DMSplashAdapter";
    private DMTemplateAd ad;

    /* JADX INFO: renamed from: com.kc.dw.gather.duomeng.splash.DMSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements DMSplashAdListener {
        public final DMSplashAdapter this$0;

        public AnonymousClass1(DMSplashAdapter dMSplashAdapter) {
            this.this$0 = dMSplashAdapter;
        }

        public void onLoadFail(int i, String str) {
            this.this$0.callLoadedError(i, str);
        }

        public void onLoadSuccess(DMTemplateAd dMTemplateAd) {
            this.this$0.ad = dMTemplateAd;
            LogUtil.d(DMSplashAdapter.TAG, "onLoadSuccess: " + dMTemplateAd.getBidPrice());
            this.this$0.callLoadedSuccess();
            dMTemplateAd.startRender();
        }

        public void onRenderFail(int i, String str) {
            this.this$0.callRenderError(i, str);
        }

        public void onRenderSuccess(DMTemplateAd dMTemplateAd) {
            try {
                long bidPrice = dMTemplateAd.getBidPrice();
                if (this.this$0.getSdkAdInfo() != null) {
                    this.this$0.getSdkAdInfo().setEcpm(String.valueOf(bidPrice));
                }
                dMTemplateAd.setSplashAdListener(new DMTemplateAd.SplashAdListener(this) { // from class: com.kc.dw.gather.duomeng.splash.DMSplashAdapter.1.1
                    public final AnonymousClass1 this$1;

                    {
                        this.this$1 = this;
                    }

                    public void onAdClick() {
                        this.this$1.this$0.callAdClicked();
                    }

                    public void onAdClose() {
                        this.this$1.this$0.callAdClosed();
                    }

                    public void onAdShow() {
                        this.this$1.this$0.callAdExposure();
                    }
                });
                this.this$0.callRenderSuccess();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        try {
            DMAdConfig codeId = new DMAdConfig().setTemplateViewSize(DimensionUtils.px2dip(getContext(), getAdLoader().getAccept_ad_width().intValue()), DimensionUtils.px2dip(getContext(), getAdLoader().getAccept_ad_height().intValue())).setCodeId(ssdAdSlot.getPid());
            if (getContext() instanceof Activity) {
                DMAdSdk.getInstance().loadSplashAdTemplate((Activity) getContext(), codeId, new AnonymousClass1(this));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.splash.MsCustomSplashAdapter
    public void showAd(ViewGroup viewGroup) {
        DMTemplateAd dMTemplateAd = this.ad;
        if (dMTemplateAd != null) {
            dMTemplateAd.showSplashAd(viewGroup);
        }
    }
}
