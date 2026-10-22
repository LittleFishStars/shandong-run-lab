package com.kc.dw.gather.ks.reward;

import android.app.Activity;
import android.content.Context;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.reward.MsCustomRewardAdapter;
import com.kwad.sdk.api.KsAdSDK;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsVideoPlayConfig;
import com.kwad.sdk.api.model.AdExposureFailedReason;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class KSRewardAdapter extends MsCustomRewardAdapter {
    private static final String TAG = "KSRewardAdapter";
    private boolean isMute;
    private KsRewardVideoAd ksRewardVideoAd;

    /* JADX INFO: renamed from: com.kc.dw.gather.ks.reward.KSRewardAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.RewardVideoAdListener {
        public final KSRewardAdapter this$0;

        public AnonymousClass1(KSRewardAdapter kSRewardAdapter) {
            this.this$0 = kSRewardAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onError(int i, String str) {
            this.this$0.callLoadedError(i, str);
        }

        public void onRequestResult(int i) {
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoAdLoad(List<KsRewardVideoAd> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            try {
                this.this$0.ksRewardVideoAd = list.get(0);
                try {
                    int ecpm = this.this$0.ksRewardVideoAd.getECPM();
                    if (ecpm > 0) {
                        this.this$0.setEcpm(ecpm);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.this$0.ksRewardVideoAd.setRewardAdInteractionListener(new KsRewardVideoAd.RewardAdInteractionListener(this) { // from class: com.kc.dw.gather.ks.reward.KSRewardAdapter.1.1
                    public final AnonymousClass1 this$1;

                    {
                        this.this$1 = this;
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onAdClicked() {
                        this.this$1.this$0.callAdClicked();
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onExtraRewardVerify(int i) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onPageDismiss() {
                        this.this$1.this$0.callAdClosed();
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onRewardStepVerify(int i, int i2) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify() {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(Map<String, Object> map) {
                        this.this$1.this$0.callReward(map);
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayEnd() {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayError(int i, int i2) {
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoPlayStart() {
                        this.this$1.this$0.callAdExposure();
                    }

                    @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
                    public void onVideoSkipToEnd(long j) {
                    }
                });
                this.this$0.callLoadedSuccess();
                this.this$0.callRenderSuccess();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public void onRewardVideoResult(List<KsRewardVideoAd> list) {
        }
    }

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        this.isMute = ssdAdSlot.getIsMute();
        KsAdSDK.getLoadManager().loadRewardVideoAd(new KsScene.Builder(Long.parseLong(customInfo.getPid())).build(), new AnonymousClass1(this));
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            KsRewardVideoAd ksRewardVideoAd = this.ksRewardVideoAd;
            if (ksRewardVideoAd != null) {
                if (z) {
                    ksRewardVideoAd.setBidEcpm(ksRewardVideoAd.getECPM(), s0.a(this.ksRewardVideoAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()));
                } else {
                    AdExposureFailedReason adExposureFailedReason = new AdExposureFailedReason();
                    adExposureFailedReason.setAdnType(3);
                    adExposureFailedReason.setWinEcpm(i);
                    this.ksRewardVideoAd.reportAdExposureFailed(2, adExposureFailedReason);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void showAd(Activity activity) {
        try {
            if (this.ksRewardVideoAd != null) {
                this.ksRewardVideoAd.showRewardVideoAd(activity, new KsVideoPlayConfig.Builder().videoSoundEnable(!this.isMute).build());
            }
        } catch (Exception e) {
            callRenderError(200002, "ks render err");
            e.printStackTrace();
        }
    }
}
