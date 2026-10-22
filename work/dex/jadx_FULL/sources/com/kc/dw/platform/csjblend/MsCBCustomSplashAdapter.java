package com.kc.dw.platform.csjblend;

import android.content.Context;
import android.view.ViewGroup;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.kc.dw.activity.a;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.splash.ISplashAd;
import com.kc.dw.core.ad.splash.SplashAdEventLoader;
import com.kc.dw.core.ad.splash.SplashAdLoadListener;
import com.kc.dw.core.ad.splash.SplashInteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCBCustomSplashAdapter extends MediationCustomSplashLoader {
    private static final String TAG = "MsCBCustomSplashAdapter";
    private ISplashAd iSplashAd;

    /* JADX INFO: renamed from: com.kc.dw.platform.csjblend.MsCBCustomSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements SplashAdLoadListener {
        public final MsCBCustomSplashAdapter this$0;

        public AnonymousClass1(MsCBCustomSplashAdapter msCBCustomSplashAdapter) {
            this.this$0 = msCBCustomSplashAdapter;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(ISplashAd iSplashAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadFail(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(ISplashAd iSplashAd) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(ISplashAd iSplashAd) {
            double d;
            try {
                this.this$0.iSplashAd = iSplashAd;
                if (this.this$0.iSplashAd != null) {
                    this.this$0.iSplashAd.setInteractionListener(new SplashInteractionListener(this) { // from class: com.kc.dw.platform.csjblend.MsCBCustomSplashAdapter.1.1
                        public final AnonymousClass1 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            this.this$1.this$0.callSplashAdClicked();
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            this.this$1.this$0.callSplashAdDismiss();
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            this.this$1.this$0.callSplashAdShow();
                        }

                        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
                        public void onSkip() {
                            this.this$1.this$0.callSplashAdSkip();
                        }

                        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
                        public void onTick(long j) {
                        }

                        @Override // com.kc.dw.core.ad.splash.SplashInteractionListener
                        public void onTimeOver() {
                        }
                    });
                    if (!this.this$0.isClientBidding()) {
                        this.this$0.callLoadSuccess();
                        return;
                    }
                    if (this.this$0.iSplashAd.getData() != null) {
                        try {
                            d = Double.parseDouble(this.this$0.iSplashAd.getData().getEcpm());
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
        StringBuilder sbA = a.a("开始加载gromore自定义平台开屏，pid=");
        sbA.append(mediationCustomServiceConfig.getADNNetworkSlotId());
        LogUtil.e(TAG, sbA.toString());
        new SplashAdEventLoader(context, new SsdAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).setFetchCount(1).build(), new AnonymousClass1(this), 5000).loadAd();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.splash.MediationCustomSplashLoader
    public void showAd(ViewGroup viewGroup) {
        ISplashAd iSplashAd = this.iSplashAd;
        if (iSplashAd != null) {
            iSplashAd.showAd(viewGroup);
        }
    }
}
