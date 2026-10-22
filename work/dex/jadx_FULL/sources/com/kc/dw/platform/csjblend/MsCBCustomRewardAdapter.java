package com.kc.dw.platform.csjblend;

import android.app.Activity;
import android.content.Context;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem;
import com.kc.dw.activity.a;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.reward.RewardAdLoadListener;
import com.kc.dw.core.ad.reward.RewardInteractionListener;
import com.kc.dw.core.ad.reward.RewardVideoAd;
import com.kc.dw.core.ad.reward.RewardVideoEventLoader;
import com.kc.dw.core.utils.AdError;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class MsCBCustomRewardAdapter extends MediationCustomRewardVideoLoader {
    private static final String TAG = "MsCBCustomRewardAdapter";
    private RewardVideoAd rewardVideoAd;

    /* JADX INFO: renamed from: com.kc.dw.platform.csjblend.MsCBCustomRewardAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements RewardAdLoadListener {
        public final MsCBCustomRewardAdapter this$0;

        public AnonymousClass1(MsCBCustomRewardAdapter msCBCustomRewardAdapter) {
            this.this$0 = msCBCustomRewardAdapter;
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onAdFail(RewardVideoAd rewardVideoAd, AdError adError, int i) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadFail(AdError adError) {
            this.this$0.callLoadFail(adError.getCode(), adError.getMessage());
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onLoadSuccess(RewardVideoAd rewardVideoAd) {
        }

        @Override // com.kc.dw.core.ad.IAdEventListener
        public void onRenderSuccess(RewardVideoAd rewardVideoAd) {
            double d;
            try {
                this.this$0.rewardVideoAd = rewardVideoAd;
                if (this.this$0.rewardVideoAd != null) {
                    this.this$0.rewardVideoAd.setInteractionListener(new RewardInteractionListener(this) { // from class: com.kc.dw.platform.csjblend.MsCBCustomRewardAdapter.1.1
                        public final AnonymousClass1 this$1;

                        {
                            this.this$1 = this;
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClicked() {
                            this.this$1.this$0.callRewardVideoAdClick();
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdClosed() {
                            this.this$1.this$0.callRewardVideoAdClosed();
                        }

                        @Override // com.kc.dw.core.loader.InteractionListener
                        public void onAdExposure() {
                            this.this$1.this$0.callRewardVideoAdShow();
                        }

                        @Override // com.kc.dw.core.ad.reward.RewardInteractionListener
                        public void onReward(Map<String, Object> map) {
                            this.this$1.this$0.callRewardVideoRewardVerify(new MediationRewardItem(this) { // from class: com.kc.dw.platform.csjblend.MsCBCustomRewardAdapter.1.1.1
                                public final C10801 this$2;

                                {
                                    this.this$2 = this;
                                }

                                @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                                public float getAmount() {
                                    return 0.0f;
                                }

                                @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                                public Map<String, Object> getCustomData() {
                                    return null;
                                }

                                @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                                public String getRewardName() {
                                    return null;
                                }

                                @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                                public boolean rewardVerify() {
                                    return true;
                                }
                            });
                        }
                    });
                    if (!this.this$0.isClientBidding()) {
                        this.this$0.callLoadSuccess();
                        return;
                    }
                    if (this.this$0.rewardVideoAd.getData() != null) {
                        try {
                            d = Double.parseDouble(this.this$0.rewardVideoAd.getData().getEcpm());
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
        StringBuilder sbA = a.a("开始加载gromore自定义平台激励视频，pid=");
        sbA.append(mediationCustomServiceConfig.getADNNetworkSlotId());
        LogUtil.e(TAG, sbA.toString());
        new RewardVideoEventLoader(context, new SsdAdSlot.Builder().setPid(mediationCustomServiceConfig.getADNNetworkSlotId()).build(), new AnonymousClass1(this)).loadAd();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader
    public void showAd(Activity activity) {
        RewardVideoAd rewardVideoAd = this.rewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.showAd(activity);
        }
    }
}
