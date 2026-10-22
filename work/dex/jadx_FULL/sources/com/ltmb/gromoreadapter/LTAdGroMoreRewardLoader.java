package com.ltmb.gromoreadapter;

import android.app.Activity;
import android.content.Context;
import androidx.camera.video.AudioStats;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomServiceConfig;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem;
import com.ltmb.ltsdk.core.LTAdSdk;
import com.ltmb.ltsdk.core.load.rewardvideo.LTAdRewardVideoEventListener;
import com.ltmb.ltsdk.core.load.rewardvideo.LTAdRewardVideoLoadListener;
import com.ltmb.ltsdk.core.load.rewardvideo.LTRewardVideoAd;
import com.ltmb.ltsdk.core.load.slot.LTAdSlot;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class LTAdGroMoreRewardLoader extends MediationCustomRewardVideoLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LTRewardVideoAd f40275a;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ MediationConstant.AdIsReadyStatus lambda$isReadyCondition$1() throws Exception {
        LTRewardVideoAd lTRewardVideoAd = this.f40275a;
        return (lTRewardVideoAd == null || lTRewardVideoAd.isExpired() || this.f40275a.isDestroy()) ? MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY : MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$load$0(MediationCustomServiceConfig mediationCustomServiceConfig) {
        LTAdSdk.getInstance().getLTAdRewardVideoLoader(new LTAdSlot.Builder().setAdId(mediationCustomServiceConfig.getADNNetworkSlotId()).setAdCount(1).build(), new LTAdRewardVideoLoadListener() { // from class: com.ltmb.gromoreadapter.LTAdGroMoreRewardLoader.1
            public void onAdLoadFailed(int i, String str) {
                LTAdGroMoreRewardLoader.this.callLoadFail(i, str);
            }

            public void onLoaded(LTRewardVideoAd lTRewardVideoAd) {
                LTAdGroMoreRewardLoader.this.f40275a = lTRewardVideoAd;
                LTAdGroMoreRewardLoader.this.setListener();
                int ecpm = (int) lTRewardVideoAd.getEcpm();
                if (ecpm <= 0) {
                    LTAdGroMoreRewardLoader.this.callLoadSuccess();
                } else {
                    LTAdGroMoreRewardLoader.this.callLoadSuccess(ecpm);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListener() {
        LTRewardVideoAd lTRewardVideoAd = this.f40275a;
        if (lTRewardVideoAd != null) {
            lTRewardVideoAd.setLTAdEventListener(new LTAdRewardVideoEventListener() { // from class: com.ltmb.gromoreadapter.LTAdGroMoreRewardLoader.2
                public void onAdClicked() {
                    LTAdGroMoreRewardLoader.this.callRewardVideoAdClick();
                }

                public void onAdRenderFail(int i, String str) {
                    LTAdGroMoreRewardLoader.this.callLoadFail(i, str);
                }

                public void onAdShow() {
                    LTAdGroMoreRewardLoader.this.callRewardVideoAdShow();
                }

                public void onClosed() {
                    LTAdGroMoreRewardLoader.this.callRewardVideoAdClosed();
                }

                public void onRewardVerify(final boolean z, final Map<String, Object> map) {
                    LTAdGroMoreRewardLoader.this.callRewardVideoRewardVerify(new MediationRewardItem(this) { // from class: com.ltmb.gromoreadapter.LTAdGroMoreRewardLoader.2.1
                        @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                        public float getAmount() {
                            return 0.0f;
                        }

                        @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                        public Map<String, Object> getCustomData() {
                            return map;
                        }

                        @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                        public String getRewardName() {
                            return "";
                        }

                        @Override // com.bytedance.sdk.openadsdk.mediation.custom.MediationRewardItem
                        public boolean rewardVerify() {
                            return z;
                        }
                    });
                }

                public void onSkip() {
                    LTAdGroMoreRewardLoader.this.callRewardVideoSkippedVideo();
                }
            });
        }
    }

    public boolean isClientBidding() {
        LTRewardVideoAd lTRewardVideoAd = this.f40275a;
        return lTRewardVideoAd != null && lTRewardVideoAd.getEcpm() > AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        try {
            MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) ThreadUtils.runOnThreadPool(new Callable() { // from class: com.zj.adlib.lu4
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f43150a.lambda$isReadyCondition$1();
                }
            }).get(100L, TimeUnit.MILLISECONDS);
            return adIsReadyStatus != null ? adIsReadyStatus : MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        } catch (Exception e) {
            e.printStackTrace();
            return MediationConstant.AdIsReadyStatus.AD_IS_NOT_READY;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void load(Context context, AdSlot adSlot, final MediationCustomServiceConfig mediationCustomServiceConfig) {
        ThreadUtils.runOnUIThread(new Runnable() { // from class: com.zj.adlib.mu4
            @Override // java.lang.Runnable
            public final void run() {
                this.f18305a.lambda$load$0(mediationCustomServiceConfig);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onDestroy() {
        LTRewardVideoAd lTRewardVideoAd = this.f40275a;
        if (lTRewardVideoAd != null) {
            lTRewardVideoAd.destroy();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.MediationCustomAdBaseLoader
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
        super.receiveBidResult(z, d, i, map);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.bridge.custom.reward.MediationCustomRewardVideoLoader
    public void showAd(Activity activity) {
        LTRewardVideoAd lTRewardVideoAd = this.f40275a;
        if (lTRewardVideoAd != null) {
            lTRewardVideoAd.showAd(activity);
        }
    }
}
