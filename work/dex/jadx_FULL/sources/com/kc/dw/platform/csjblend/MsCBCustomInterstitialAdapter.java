package com.kc.dw.platform.csjblend;

import android.app.Activity;
import android.content.Context;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.kc.dw.activity.a;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.interstitial.InterstitialAd;
import com.kc.dw.core.ad.interstitial.InterstitialAdEventLoader;
import com.kc.dw.core.ad.interstitial.InterstitialAdLoadListener;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCBCustomInterstitialAdapter extends MediationCustomInterstitialLoader {
    private static final String TAG = "MsCBCCustomInterstitial";
    private InterstitialAd interstitialAd;

    /* JADX INFO: renamed from: com.kc.dw.platform.csjblend.MsCBCustomInterstitialAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements InterstitialAdLoadListener {
        public final MsCBCustomInterstitialAdapter this$0;

        public AnonymousClass1(MsCBCustomInterstitialAdapter msCBCustomInterstitialAdapter) {
            this.this$0 = msCBCustomInterstitialAdapter;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(InterstitialAd interstitialAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadFail(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(InterstitialAd interstitialAd) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(InterstitialAd interstitialAd) {
            double d;
            try {
                this.this$0.interstitialAd = interstitialAd;
                if (interstitialAd != null) {
                    interstitialAd.setInteractionListener(new InteractionListener(this) { // from class: com.kc.dw.platform.csjblend.MsCBCustomInterstitialAdapter.1.1
                        public final AnonymousClass1 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            this.this$1.this$0.callInterstitialAdClick();
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            this.this$1.this$0.interstitialAd = null;
                            this.this$1.this$0.callInterstitialClosed();
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            this.this$1.this$0.callInterstitialShow();
                        }
                    });
                    if (!this.this$0.isClientBidding()) {
                        this.this$0.callLoadSuccess();
                        return;
                    }
                    if (interstitialAd.getData() != null) {
                        try {
                            d = Double.parseDouble(interstitialAd.getData().getEcpm());
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                            d = AudioStats.AUDIO_AMPLITUDE_NONE;
                        }
                    } else {
                        d = AudioStats.AUDIO_AMPLITUDE_NONE;
                    }
                    this.this$0.callLoadSuccess(d);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public boolean isClientBidding() {
        return getBiddingType() == 1;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, MediationCustomServiceConfig mediationCustomServiceConfig) {
        StringBuilder sbA = a.a("开始加载gromore自定义平台插屏，pid=");
        sbA.append(mediationCustomServiceConfig.getADNNetworkSlotId());
        LogUtil.d(TAG, sbA.toString());
        new InterstitialAdEventLoader((Activity) context, new SsdAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).setIsClickToClose(false).build(), new AnonymousClass1(this)).loadAd();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader
    public void showAd(Activity activity) {
        InterstitialAd interstitialAd = this.interstitialAd;
        if (interstitialAd != null) {
            interstitialAd.showAd(activity);
        }
    }
}
