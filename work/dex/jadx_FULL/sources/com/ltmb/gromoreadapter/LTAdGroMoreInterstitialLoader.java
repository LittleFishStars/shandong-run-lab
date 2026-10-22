package com.ltmb.gromoreadapter;

import android.app.Activity;
import android.content.Context;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.interstitial.LTAdInterstitialEventListener;
import com.ltmb.ltsdk.core.load.interstitial.LTAdInterstitialLoadListener;
import com.ltmb.ltsdk.core.load.interstitial.LTInterstitialAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class LTAdGroMoreInterstitialLoader extends MediationCustomInterstitialLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LTInterstitialAd f40272a;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$0(MediationCustomServiceConfig mediationCustomServiceConfig) {
        LTAdSdk.getInstance().getLTAdInterstitialLoader(new LTAdSlot.Builder().setAdId(mediationCustomServiceConfig.getADNNetworkSlotId()).setAdCount(1).setRequestAdSize(1080, 450).build(), new LTAdInterstitialLoadListener() { // from class: com.ltmb.gromoreadapter.LTAdGroMoreInterstitialLoader.2
            public void onAdLoadFailed(int i, String str) {
                LTAdGroMoreInterstitialLoader.this.callLoadFail(i, str);
            }

            public void onLoaded(LTInterstitialAd lTInterstitialAd) {
                LTAdGroMoreInterstitialLoader.this.f40272a = lTInterstitialAd;
                if (lTInterstitialAd == null) {
                    LTAdGroMoreInterstitialLoader.this.callLoadFail(0, "广告为空");
                } else if (lTInterstitialAd.getEcpm() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    LTAdGroMoreInterstitialLoader.this.callLoadSuccess(lTInterstitialAd.getEcpm());
                } else {
                    LTAdGroMoreInterstitialLoader.this.callLoadSuccess();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, final MediationCustomServiceConfig mediationCustomServiceConfig) {
        ThreadUtils.runOnThreadPool(new Runnable() { // from class: com.zj.adlib.ku4
            @Override // java.lang.Runnable
            public final void run() {
                this.f17791a.lambda$load$0(mediationCustomServiceConfig);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.interstitial.MediationCustomInterstitialLoader
    public void showAd(Activity activity) {
        LTInterstitialAd lTInterstitialAd = this.f40272a;
        if (lTInterstitialAd == null || !lTInterstitialAd.isReady()) {
            return;
        }
        this.f40272a.setLTAdEventListener(new LTAdInterstitialEventListener() { // from class: com.ltmb.gromoreadapter.LTAdGroMoreInterstitialLoader.1
            public void onAdClicked() {
                LTAdGroMoreInterstitialLoader.this.callInterstitialAdClick();
            }

            public void onAdRenderFail(int i, String str) {
                LTAdGroMoreInterstitialLoader.this.callInterstitialClosed();
            }

            public void onAdShow() {
                LTAdGroMoreInterstitialLoader.this.callInterstitialShow();
            }

            public void onClosed() {
                LTAdGroMoreInterstitialLoader.this.callInterstitialClosed();
            }
        });
        this.f40272a.showAd(activity);
    }
}
