package com.kc.dw.gather.gdt.reward;

import android.app.Activity;
import android.content.Context;
import com.kc.dw.core.ad.SsdAdSlot;
import com.kc.dw.core.ad.reward.RewardVideoCommonLoader;
import com.kc.dw.core.s2s.ISBidding;
import com.kc.dw.core.utils.LogUtil;
import com.kc.dw.core.utils.s0;
import com.kc.dw.platform.custom.CustomInfo;
import com.kc.dw.platform.custom.reward.MsCustomRewardAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.rewardvideo.RewardVideoAD;
import com.qq.e.ads.rewardvideo.RewardVideoADListener;
import com.qq.e.comm.util.AdError;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class GDTRewardAdapter extends MsCustomRewardAdapter {
    private static final String TAG = "GDTRewardAdapter";
    private RewardVideoAD rewardVideoAd;

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void loadCustomAd(Context context, SsdAdSlot ssdAdSlot, CustomInfo customInfo) {
        RewardVideoAD rewardVideoAD = new RewardVideoAD(((RewardVideoCommonLoader) this.adLoader).getContext(), customInfo.getPid(), new RewardVideoADListener(this) { // from class: com.kc.dw.gather.gdt.reward.GDTRewardAdapter.1
            public final GDTRewardAdapter this$0;

            {
                this.this$0 = this;
            }

            public void onADClick() {
                LogUtil.d(GDTRewardAdapter.TAG, "GDT onADClick");
                this.this$0.callAdClicked();
            }

            public void onADClose() {
                LogUtil.d(GDTRewardAdapter.TAG, "GDT onADClose");
                this.this$0.callAdClosed();
            }

            public void onADExpose() {
                LogUtil.d(GDTRewardAdapter.TAG, "GDT onADExpose");
                this.this$0.callAdExposure();
            }

            public void onADLoad() {
                LogUtil.d(GDTRewardAdapter.TAG, "GDT onADLoad");
                try {
                    int ecpm = this.this$0.rewardVideoAd.getECPM();
                    if (ecpm > 0) {
                        this.this$0.setEcpm(ecpm);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.this$0.callLoadedSuccess();
            }

            public void onADShow() {
            }

            public void onError(AdError adError) {
                try {
                    LogUtil.d(GDTRewardAdapter.TAG, "GDT onError code=" + adError.getErrorCode() + ",msg=" + adError.getErrorMsg());
                    this.this$0.callLoadedError(adError.getErrorCode(), adError.getErrorMsg());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onReward(Map<String, Object> map) {
                LogUtil.d(GDTRewardAdapter.TAG, "GDT onReward");
                this.this$0.callReward(map);
            }

            public void onVideoCached() {
            }

            public void onVideoComplete() {
            }
        }, !ssdAdSlot.getIsMute());
        this.rewardVideoAd = rewardVideoAD;
        rewardVideoAD.loadAD();
    }

    @Override // com.kc.dw.platform.BasePlatformLoader
    public void sendGdtWinResult(boolean z, int i) {
        try {
            if (this.rewardVideoAd != null) {
                if (z) {
                    HashMap map = new HashMap();
                    map.put(ISBidding.EXPECT_COST_PRICE, Integer.valueOf(this.rewardVideoAd.getECPM()));
                    map.put("highestLossPrice", Integer.valueOf(s0.a(this.rewardVideoAd.getECPM(), i, this.sdkAdInfo.getAt_rate(), this.sdkAdInfo.getPrice())));
                    this.rewardVideoAd.sendWinNotification(map);
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("winPrice", Integer.valueOf(i));
                    map2.put("lossReason", 1);
                    map2.put("adnId", "2");
                    this.rewardVideoAd.sendLossNotification(map2);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAdapter
    public void showAd(Activity activity) {
        RewardVideoAD rewardVideoAD = this.rewardVideoAd;
        if (rewardVideoAD != null) {
            rewardVideoAD.showAD(activity);
        }
    }
}
