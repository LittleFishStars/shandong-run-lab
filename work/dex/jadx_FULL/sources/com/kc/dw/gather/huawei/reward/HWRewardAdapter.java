package com.kc.dw.gather.huawei.reward;

import android.app.Activity;
import android.content.Context;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.BiddingParam;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.reward.Reward;
import com.huawei.hms.ads.reward.RewardAd;
import com.huawei.hms.ads.reward.RewardAdLoadListener;
import com.huawei.hms.ads.reward.RewardAdStatusListener;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.reward.RewardVideoCommonLoader;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.reward.MsCustomRewardAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class HWRewardAdapter extends MsCustomRewardAdapter {
    private RewardAd rewardAd;

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        this.rewardAd = new RewardAd(((RewardVideoCommonLoader) this.adLoader).getContext(), this.sdkAdInfo.getPid());
        AdParam.Builder builder = new AdParam.Builder();
        if (this.sdkAdInfo.getIs_bidding() == 1) {
            try {
                builder.addBiddingParamMap(getSdkAdInfo().getPid(), new BiddingParam.Builder().setBidFloor(Float.valueOf(getSdkAdInfo().getPrice() / 100.0f)).setBidFloorCur("CNY").build());
            } catch (Exception e) {
                e.printStackTrace();
            }
            builder.setTMax(3000);
        }
        this.rewardAd.loadAd(builder.build(), new RewardAdLoadListener(this) { // from class: com.kc.dw.gather.huawei.reward.HWRewardAdapter.2
            public final HWRewardAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onRewardAdFailedToLoad(int i) {
                this.this$0.callLoadedError(i, "load error");
            }

            public void onRewardedLoaded() {
                try {
                    if (this.this$0.getSdkAdInfo() != null) {
                        this.this$0.getSdkAdInfo().setEcpm(String.valueOf((int) (this.this$0.rewardAd.getBiddingInfo().getPrice().floatValue() * 100.0f)));
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.this$0.callLoadedSuccess();
                this.this$0.callRenderSuccess();
            }
        });
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        BiddingInfo biddingInfo;
        try {
            RewardAd rewardAd = this.rewardAd;
            if (rewardAd != null && (biddingInfo = rewardAd.getBiddingInfo()) != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put("SECOND_PRICE", Float.valueOf((s0.a((int) (biddingInfo.getPrice().floatValue() * 100.0f), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice()) * 1.0f) / 100.0f));
                    map.put("AUCTION_CURRENCY", "CNY");
                    this.rewardAd.sendBiddingSuccess(map, new ReportUrlListener(this) { // from class: com.kc.dw.gather.huawei.reward.HWRewardAdapter.3
                        public final HWRewardAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void reportFailed(String str, int i2) {
                        }

                        public void reportSuccess() {
                        }
                    });
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("AUCTION_PRICE", Float.valueOf((i * 1.0f) / 100.0f));
                    map2.put("AUCTION_CURRENCY", "CNY");
                    map2.put("AUCTION_LOSS", 102);
                    map2.put("AUCTION_CP_ID", "100");
                    this.rewardAd.sendBiddingFailed(map2, new ReportUrlListener(this) { // from class: com.kc.dw.gather.huawei.reward.HWRewardAdapter.4
                        public final HWRewardAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void reportFailed(String str, int i2) {
                        }

                        public void reportSuccess() {
                        }
                    });
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void showAd(Activity activity) {
        RewardAd rewardAd = this.rewardAd;
        if (rewardAd == null || !rewardAd.isLoaded()) {
            return;
        }
        this.rewardAd.show(activity, new RewardAdStatusListener(this) { // from class: com.kc.dw.gather.huawei.reward.HWRewardAdapter.1
            public final HWRewardAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onRewardAdClosed() {
                this.this$0.callAdClosed();
            }

            public void onRewardAdFailedToShow(int i) {
                this.this$0.callAdExposure();
            }

            public void onRewardAdOpened() {
                this.this$0.callAdExposure();
            }

            public void onRewarded(Reward reward) {
                this.this$0.callReward(null);
            }
        });
    }
}
