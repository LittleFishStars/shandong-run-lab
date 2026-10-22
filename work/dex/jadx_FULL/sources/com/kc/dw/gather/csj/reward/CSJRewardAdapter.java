package com.kc.dw.gather.csj.reward;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.reward.MsCustomRewardAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CSJRewardAdapter extends MsCustomRewardAdapter {
    private static final String TAG = "CSJRewardAdapter";
    private TTRewardVideoAd rewardVideoAd;

    /* JADX INFO: renamed from: com.kc.dw.gather.csj.reward.CSJRewardAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements TTAdNative.RewardVideoAdListener {
        public final CSJRewardAdapter this$0;

        public AnonymousClass1(CSJRewardAdapter cSJRewardAdapter) {
            this.this$0 = cSJRewardAdapter;
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onError(int i, String str) {
            this.this$0.callLoadedError(i, str);
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoAdLoad(TTRewardVideoAd tTRewardVideoAd) {
            try {
                LogUtil.d(CSJRewardAdapter.TAG, "CSJ onRewardVideoAdLoad");
                this.this$0.rewardVideoAd = tTRewardVideoAd;
                tTRewardVideoAd.setRewardAdInteractionListener(new TTRewardVideoAd.RewardAdInteractionListener(this) { // from class: com.kc.dw.gather.csj.reward.CSJRewardAdapter.1.1
                    public final AnonymousClass1 this$1;

                    {
                        this.this$1 = this;
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdClose() {
                        LogUtil.d(CSJRewardAdapter.TAG, "CSJ reward onAdClose");
                        this.this$1.this$0.callAdClosed();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdShow() {
                        LogUtil.d(CSJRewardAdapter.TAG, "CSJ reward exposure");
                        this.this$1.this$0.callAdExposure();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onAdVideoBarClick() {
                        this.this$1.this$0.callAdClicked();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardArrived(boolean z, int i, Bundle bundle) {
                        LogUtil.d(CSJRewardAdapter.TAG, "CSJ onRewardArrived");
                        HashMap map = new HashMap();
                        map.put("rewardVerify", Boolean.valueOf(z));
                        map.put(MediationConstant.KEY_REWARD_TYPE, Integer.valueOf(i));
                        map.put(MediationConstant.KEY_EXTRA_INFO, bundle);
                        this.this$1.this$0.callReward(map);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onRewardVerify(boolean z, int i, String str, int i2, String str2) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onSkippedVideo() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoComplete() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTRewardVideoAd.RewardAdInteractionListener
                    public void onVideoError() {
                    }
                });
                this.this$0.callLoadedSuccess();
                this.this$0.callRenderSuccess();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached() {
        }

        @Override // com.bytedance.sdk.openadsdk.TTAdNative.RewardVideoAdListener
        public void onRewardVideoCached(TTRewardVideoAd tTRewardVideoAd) {
        }
    }

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        TTAdSdk.getAdManager().createAdNative(context).loadRewardVideoAd(new AdSlot.Builder().setCodeId(customInfo.getPid()).setSupportDeepLink(true).build(), new AnonymousClass1(this));
    }

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void showAd(Activity activity) {
        TTRewardVideoAd tTRewardVideoAd = this.rewardVideoAd;
        if (tTRewardVideoAd != null) {
            tTRewardVideoAd.showRewardVideoAd(activity);
        }
    }
}
