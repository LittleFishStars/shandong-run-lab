package com.kc.dw.gather.bd.reward;

import android.app.Activity;
import android.content.Context;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.exception.b;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.reward.MsCustomRewardAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class BDRewardAdapter extends MsCustomRewardAdapter {
    private static final String TAG = "BDRewardAdapter";
    private RewardVideoAd mRewardVideoAd;

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        RewardVideoAd rewardVideoAd = new RewardVideoAd(context, customInfo.getPid(), new RewardVideoAd.RewardVideoAdListener(this) { // from class: com.kc.dw.gather.bd.reward.BDRewardAdapter.1
            public final BDRewardAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onAdClick() {
                LogUtil.d(BDRewardAdapter.TAG, "onAdClick");
                this.this$0.callAdClicked();
            }

            public void onAdClose(float f) {
                LogUtil.d(BDRewardAdapter.TAG, "onAdClose");
                this.this$0.callAdClosed();
            }

            public void onAdFailed(String str) {
                LogUtil.d(BDRewardAdapter.TAG, "BD onAdFailed:" + str);
                this.this$0.callLoadedError(b.i.intValue(), str);
            }

            public void onAdLoaded() {
                LogUtil.d(BDRewardAdapter.TAG, "onAdLoaded");
                try {
                    int i = Integer.parseInt(this.this$0.mRewardVideoAd.getECPMLevel());
                    if (i > 0) {
                        this.this$0.setEcpm(i);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.this$0.callLoadedSuccess();
                this.this$0.callRenderSuccess();
            }

            public void onAdShow() {
                LogUtil.d(BDRewardAdapter.TAG, "onAdShow");
                this.this$0.callAdExposure();
            }

            public void onAdSkip(float f) {
            }

            public void onRewardVerify(boolean z) {
                LogUtil.d(BDRewardAdapter.TAG, "onRewardVerify");
                HashMap map = new HashMap();
                map.put("rewardVerify", Boolean.valueOf(z));
                this.this$0.callReward(map);
            }

            public void onRewardVerify(boolean z, Map<String, Object> map) {
                LogUtil.d(BDRewardAdapter.TAG, "onRewardVerify");
                map.put("rewardVerify", Boolean.valueOf(z));
                this.this$0.callReward(map);
            }

            public void onVideoDownloadFailed() {
            }

            public void onVideoDownloadSuccess() {
            }

            public void playCompletion() {
            }
        }, false);
        this.mRewardVideoAd = rewardVideoAd;
        rewardVideoAd.load();
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        int i2 = 1;
        try {
            Class<?> cls = Class.forName("com.baidu.mobads.sdk.api.RewardVideoAd");
            if (z) {
                Method declaredMethod = cls.getDeclaredMethod("biddingSuccess", String.class);
                RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
                declaredMethod.invoke(rewardVideoAd, String.valueOf(s0.a(Integer.parseInt(rewardVideoAd.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
            } else {
                cls.getDeclaredMethod("biddingFail", String.class).invoke(this.mRewardVideoAd, "203");
            }
        } catch (Throwable unused) {
            try {
                if (z) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.put("ecpm", Integer.valueOf(s0.a(Integer.parseInt(this.mRewardVideoAd.getECPMLevel()), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    linkedHashMap.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap.put("bid_t", 1);
                    this.mRewardVideoAd.biddingSuccess(linkedHashMap, new BiddingListener(this) { // from class: com.kc.dw.gather.bd.reward.BDRewardAdapter.2
                        public final BDRewardAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                } else {
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    linkedHashMap2.put("ecpm", Integer.valueOf(i));
                    int iNextInt = new Random().nextInt(10);
                    if (iNextInt != 0) {
                        i2 = iNextInt;
                    }
                    linkedHashMap2.put("adn", Integer.valueOf(i2));
                    linkedHashMap2.put("ad_time", Long.valueOf(System.currentTimeMillis() / 1000));
                    linkedHashMap2.put("bid_t", 3);
                    linkedHashMap2.put(MediationConstant.KEY_REASON, "203");
                    this.mRewardVideoAd.biddingFail(linkedHashMap2, new BiddingListener(this) { // from class: com.kc.dw.gather.bd.reward.BDRewardAdapter.3
                        public final BDRewardAdapter this$0;

                        {
                            this.this$0 = this;
                        }

                        public void onBiddingResult(boolean z2, String str, HashMap<String, Object> map) {
                        }
                    });
                }
            } catch (Throwable unused2) {
            }
        }
    }

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void showAd(Activity activity) {
        RewardVideoAd rewardVideoAd = this.mRewardVideoAd;
        if (rewardVideoAd != null) {
            rewardVideoAd.show();
        }
    }
}
