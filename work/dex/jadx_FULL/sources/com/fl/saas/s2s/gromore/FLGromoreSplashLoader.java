package com.fl.saas.s2s.gromore;

import android.content.Context;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.fl.saas.base.interfaces.AdViewSpreadListener;
import com.fl.saas.base.interfaces.SpreadLoadListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdSpread;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLGromoreSplashLoader extends MediationCustomSplashLoader {
    private static final String TAG = CommConstant.getClassTag("FLGromore", FLGromoreSplashLoader.class);
    private boolean hasBackDisplay = false;
    private SpreadLoadListener.SpreadAd mSpreadAd;
    private YdSpread ydSpread;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$0(SpreadLoadListener.SpreadAd spreadAd) {
        LogcatUtil.d(TAG, "onADLoaded");
        this.mSpreadAd = spreadAd;
        if (!isClientBidding()) {
            callLoadSuccess();
            return;
        }
        double ecpm = this.ydSpread.getECPM();
        if (ecpm < AudioStats.AUDIO_AMPLITUDE_NONE) {
            ecpm = 0.0d;
        }
        callLoadSuccess(ecpm);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$1(ViewGroup viewGroup) {
        SpreadLoadListener.SpreadAd spreadAd = this.mSpreadAd;
        if (spreadAd == null || viewGroup == null) {
            return;
        }
        spreadAd.show(viewGroup);
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return this.mSpreadAd != null ? MediationConstant.AdIsReadyStatus.AD_IS_READY : MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        String aDNNetworkSlotId = mediationCustomServiceConfig.getADNNetworkSlotId();
        float f = 1.0f;
        try {
            float expressViewAcceptedHeight = adSlot.getExpressViewAcceptedHeight();
            float fPx2dip = DeviceUtil.px2dip(DeviceUtil.getMobileHeight());
            if (fPx2dip > 0.0f && expressViewAcceptedHeight > 0.0f) {
                float f2 = expressViewAcceptedHeight / fPx2dip;
                if (f2 >= 0.75d && f2 < 1.0f) {
                    f = f2;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        YdSpread ydSpreadBuild = new YdSpread.Builder(context).setKey(aDNNetworkSlotId).setScreenPercentage(f).setSpreadLoadListener(new SpreadLoadListener() { // from class: com.zj.adlib.nc3
            @Override // com.fl.saas.base.interfaces.SpreadLoadListener
            public final void onADLoaded(SpreadLoadListener.SpreadAd spreadAd) {
                this.f43492a.lambda$load$0(spreadAd);
            }
        }).setSpreadListener(new AdViewSpreadListener() { // from class: com.fl.saas.s2s.gromore.FLGromoreSplashLoader.1
            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdClick(String str) {
                FLGromoreSplashLoader.this.callSplashAdClicked();
            }

            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdClose() {
                FLGromoreSplashLoader.this.callSplashAdDismiss();
            }

            @Override // com.fl.saas.base.base.listener.InnerSpreadListener
            public void onAdDisplay() {
                if (FLGromoreSplashLoader.this.hasBackDisplay) {
                    return;
                }
                FLGromoreSplashLoader.this.hasBackDisplay = true;
                FLGromoreSplashLoader.this.callSplashAdShow();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                FLGromoreSplashLoader.this.callLoadFail(ydError.getCode(), ydError.getMsg());
            }
        }).build();
        this.ydSpread = ydSpreadBuild;
        ydSpreadBuild.requestSpread();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onDestroy() {
        super.onDestroy();
        YdSpread ydSpread = this.ydSpread;
        if (ydSpread != null) {
            ydSpread.destroy();
            this.ydSpread = null;
            this.mSpreadAd = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        super.receiveBidResult(z, d, i, map);
        try {
            YdSpread ydSpread = this.ydSpread;
            if (ydSpread != null) {
                ydSpread.biddingResultUpload(z, (int) d, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader
    public void showAd(final ViewGroup viewGroup) {
        LogcatUtil.d(TAG, "showAd");
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.oc3
            @Override // java.lang.Runnable
            public final void run() {
                this.f18610a.lambda$showAd$1(viewGroup);
            }
        });
    }
}
