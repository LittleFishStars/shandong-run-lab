package com.kc.dw.gather.ks.intertitial;

import android.app.Activity;
import android.content.Context;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class KSIntertitialAdapter extends MsCustomInterstitialAdapter {
    private static final String TAG = "KSIntertitialAdapter";
    private KsInterstitialAd ksInterstitialAd;

    /* JADX INFO: renamed from: com.kc.dw.gather.ks.intertitial.KSIntertitialAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.InterstitialAdListener {
        public final KSIntertitialAdapter this$0;

        public AnonymousClass1(KSIntertitialAdapter kSIntertitialAdapter) {
            this.this$0 = kSIntertitialAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onError(int i, String str) {
            LogUtil.d(KSIntertitialAdapter.TAG, "onError,code=" + i + ",msg=" + str);
            this.this$0.callLoadedError(i, str);
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onInterstitialAdLoad(List<KsInterstitialAd> list) {
            LogUtil.d(KSIntertitialAdapter.TAG, "KS onInterstitialAdLoad");
            if (list != null && !list.isEmpty()) {
                this.this$0.ksInterstitialAd = list.get(0);
                if (this.this$0.ksInterstitialAd != null) {
                    try {
                        int ecpm = list.get(0).getECPM();
                        if (ecpm > 0) {
                            this.this$0.setEcpm(ecpm);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    this.this$0.ksInterstitialAd.setAdInteractionListener(new KsInterstitialAd.AdInteractionListener(this) { // from class: com.kc.dw.gather.ks.intertitial.KSIntertitialAdapter.1.1
                        public final AnonymousClass1 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onAdClicked() {
                            LogUtil.d(KSIntertitialAdapter.TAG, "KS onAdClicked");
                            this.this$1.this$0.callAdClicked();
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onAdClosed() {
                            LogUtil.d(KSIntertitialAdapter.TAG, "KS onAdClosed");
                            this.this$1.this$0.callAdClosed();
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onAdShow() {
                            LogUtil.d(KSIntertitialAdapter.TAG, "KS onAdShow");
                            this.this$1.this$0.callAdExposure();
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onPageDismiss() {
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onSkippedAd() {
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onVideoPlayEnd() {
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onVideoPlayError(int i, int i2) {
                        }

                        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
                        public void onVideoPlayStart() {
                        }
                    });
                }
            }
            this.this$0.callLoadedSuccess();
            this.this$0.callRenderSuccess();
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public void onRequestResult(int i) {
        }
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        KsAdSDK.getLoadManager().loadInterstitialAd(new KsScene.Builder(Long.parseLong(customInfo.getPid())).build(), new AnonymousClass1(this));
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            KsInterstitialAd ksInterstitialAd = this.ksInterstitialAd;
            if (ksInterstitialAd != null) {
                if (z) {
                    ksInterstitialAd.setBidEcpm(ksInterstitialAd.getECPM(), s0.a(this.ksInterstitialAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                } else {
                    AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                    adExposureFailedReason.setAdnType(3);
                    adExposureFailedReason.setWinEcpm(i);
                    this.ksInterstitialAd.reportAdExposureFailed(2, adExposureFailedReason);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter
    public void showAd(Activity activity) {
        try {
            if (this.ksInterstitialAd != null) {
                this.ksInterstitialAd.showInterstitialAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(false).build());
            }
        } catch (Exception e) {
            callRenderError(200002, "ks render err");
            e.printStackTrace();
        }
    }
}
