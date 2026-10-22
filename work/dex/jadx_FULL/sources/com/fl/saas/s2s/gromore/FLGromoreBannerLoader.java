package com.fl.saas.s2s.gromore;

import android.content.Context;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.banner.MediationCustomBannerLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.fl.saas.base.interfaces.AdViewBannerListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdBanner;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLGromoreBannerLoader extends MediationCustomBannerLoader {
    private static final String TAG = CommConstant.getClassTag("FLGromore", FLGromoreBannerLoader.class);
    private View bannerView;
    private boolean hasBackDisplay = false;
    private YdBanner ydBanner;

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.banner.MediationCustomBannerLoader
    public View getAdView() {
        return this.bannerView;
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.banner.MediationCustomBannerLoader
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return this.bannerView != null ? MediationConstant.AdIsReadyStatus.AD_IS_READY : MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        String aDNNetworkSlotId = mediationCustomServiceConfig.getADNNetworkSlotId();
        float expressViewAcceptedWidth = adSlot.getExpressViewAcceptedWidth();
        float expressViewAcceptedHeight = adSlot.getExpressViewAcceptedHeight();
        YdBanner.Builder builder = new YdBanner.Builder(context);
        if (expressViewAcceptedWidth > 0.0f && expressViewAcceptedHeight > 0.0f) {
            builder.setExpressWidth((int) expressViewAcceptedWidth).setExpressHeight((int) expressViewAcceptedHeight);
        }
        YdBanner ydBannerBuild = builder.setKey(aDNNetworkSlotId).setBannerListener(new AdViewBannerListener() { // from class: com.fl.saas.s2s.gromore.FLGromoreBannerLoader.1
            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onAdClick(String str) {
                LogcatUtil.d(FLGromoreBannerLoader.TAG, "onAdClick");
                FLGromoreBannerLoader.this.callBannerAdClick();
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onAdExposure() {
                LogcatUtil.d(FLGromoreBannerLoader.TAG, "onAdExposure");
                if (FLGromoreBannerLoader.this.hasBackDisplay) {
                    return;
                }
                FLGromoreBannerLoader.this.hasBackDisplay = true;
                FLGromoreBannerLoader.this.callBannerAdShow();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d(FLGromoreBannerLoader.TAG, "error:" + ydError.toString());
                FLGromoreBannerLoader.this.callLoadFail(ydError.getCode(), ydError.getMsg());
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onClosed() {
                LogcatUtil.d(FLGromoreBannerLoader.TAG, "onClosed");
                FLGromoreBannerLoader.this.callBannerAdClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerBannerListener
            public void onReceived(View view) {
                LogcatUtil.d(FLGromoreBannerLoader.TAG, "onReceived");
                FLGromoreBannerLoader.this.bannerView = view;
                if (!FLGromoreBannerLoader.this.isClientBidding()) {
                    FLGromoreBannerLoader.this.callLoadSuccess();
                    return;
                }
                double ecpm = FLGromoreBannerLoader.this.ydBanner.getECPM();
                if (ecpm < AudioStats.AUDIO_AMPLITUDE_NONE) {
                    ecpm = 0.0d;
                }
                FLGromoreBannerLoader.this.callLoadSuccess(ecpm);
            }
        }).build();
        this.ydBanner = ydBannerBuild;
        ydBannerBuild.requestBanner();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onDestroy() {
        YdBanner ydBanner = this.ydBanner;
        if (ydBanner != null) {
            ydBanner.destroy();
            this.ydBanner = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        super.receiveBidResult(z, d, i, map);
        try {
            YdBanner ydBanner = this.ydBanner;
            if (ydBanner != null) {
                ydBanner.biddingResultUpload(z, (int) d, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
