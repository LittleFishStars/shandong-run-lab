package com.fl.saas.s2s.gromore;

import android.app.Activity;
import android.content.Context;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.fl.saas.base.interfaces.AdViewInterstitialListener;
import com.fl.saas.common.util.CommConstant;
import com.fl.saas.config.exception.YdError;
import com.fl.saas.config.utils.DeviceUtil;
import com.fl.saas.config.utils.LogcatUtil;
import com.fl.saas.ydsdk.YdInterstitial;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FLGromoreInterstitialLoader extends MediationCustomInterstitialLoader {
    private static final String TAG = CommConstant.getClassTag("FLGromore", FLGromoreInterstitialLoader.class);
    private boolean hasBackDisplay = false;
    private YdInterstitial ydInterstitial;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAd$0(Activity activity) {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.show(activity);
        }
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        return (ydInterstitial == null || !ydInterstitial.isReady()) ? MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        YdInterstitial ydInterstitialBuild = new YdInterstitial.Builder(context).setKey(mediationCustomServiceConfig.getADNNetworkSlotId()).setInterstitialListener(new AdViewInterstitialListener() { // from class: com.fl.saas.s2s.gromore.FLGromoreInterstitialLoader.1
            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClick(String str) {
                LogcatUtil.d(FLGromoreInterstitialLoader.TAG, "ydInterstitial onAdClick");
                FLGromoreInterstitialLoader.this.callInterstitialAdClick();
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdClosed() {
                LogcatUtil.d(FLGromoreInterstitialLoader.TAG, "ydInterstitial onAdClosed");
                FLGromoreInterstitialLoader.this.callInterstitialClosed();
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdDisplay() {
                LogcatUtil.d(FLGromoreInterstitialLoader.TAG, "ydInterstitial onAdDisplay");
                if (FLGromoreInterstitialLoader.this.hasBackDisplay) {
                    return;
                }
                FLGromoreInterstitialLoader.this.hasBackDisplay = true;
                FLGromoreInterstitialLoader.this.callInterstitialShow();
            }

            @Override // com.fl.saas.base.interfaces.AdViewListener
            public void onAdFailed(YdError ydError) {
                LogcatUtil.d(FLGromoreInterstitialLoader.TAG, "ydInterstitial onAdFailed:" + ydError.toString());
                FLGromoreInterstitialLoader.this.callLoadFail(ydError.getCode(), ydError.getMsg());
            }

            @Override // com.fl.saas.base.base.listener.InnerInterstitialListener
            public void onAdReady() {
                LogcatUtil.d(FLGromoreInterstitialLoader.TAG, "ydInterstitial onAdReady");
                if (!FLGromoreInterstitialLoader.this.isClientBidding()) {
                    FLGromoreInterstitialLoader.this.callLoadSuccess();
                    return;
                }
                double ecpm = FLGromoreInterstitialLoader.this.ydInterstitial.getECPM();
                if (ecpm < AudioStats.AUDIO_AMPLITUDE_NONE) {
                    ecpm = 0.0d;
                }
                FLGromoreInterstitialLoader.this.callLoadSuccess(ecpm);
            }
        }).build();
        this.ydInterstitial = ydInterstitialBuild;
        ydInterstitialBuild.requestInterstitial();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onDestroy() {
        YdInterstitial ydInterstitial = this.ydInterstitial;
        if (ydInterstitial != null) {
            ydInterstitial.destroy();
            this.ydInterstitial = null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        super.receiveBidResult(z, d, i, map);
        try {
            YdInterstitial ydInterstitial = this.ydInterstitial;
            if (ydInterstitial != null) {
                ydInterstitial.biddingResultUpload(z, (int) d, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader
    public void showAd(final Activity activity) {
        DeviceUtil.postUI(new Runnable() { // from class: com.zj.adlib.lc3
            @Override // java.lang.Runnable
            public final void run() {
                this.f17920a.lambda$showAd$0(activity);
            }
        });
    }
}
