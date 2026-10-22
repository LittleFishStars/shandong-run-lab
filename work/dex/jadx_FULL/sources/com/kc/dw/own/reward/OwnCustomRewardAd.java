package com.kc.dw.own.reward;

import com.kc.dw.core.ad.reward.RewardVideoAd;
import com.kc.dw.core.utils.ResultBean;
import com.kc.dw.platform.custom.reward.MsCustomRewardAd;
import com.kc.dw.platform.custom.reward.MsCustomRewardAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class OwnCustomRewardAd extends MsCustomRewardAd {
    private final RewardVideoAd ad;

    public OwnCustomRewardAd(MsCustomRewardAdapter msCustomRewardAdapter, String str, RewardVideoAd rewardVideoAd) {
        super(msCustomRewardAdapter, str);
        this.ad = rewardVideoAd;
    }

    @Override // com.kc.dw.platform.custom.reward.MsCustomRewardAd, com.kc.dw.core.ad.reward.RewardVideoAd
    public void destroy() {
        RewardVideoAd rewardVideoAd = this.ad;
        if (rewardVideoAd != null) {
            rewardVideoAd.destroy();
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public ResultBean getData() {
        RewardVideoAd rewardVideoAd = this.ad;
        return rewardVideoAd != null ? rewardVideoAd.getData() : super.getData();
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.ad.IAd
    public boolean isAdValid() {
        RewardVideoAd rewardVideoAd = this.ad;
        if (rewardVideoAd != null) {
            return rewardVideoAd.isAdValid();
        }
        return true;
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendLossNotification(Map map) {
        RewardVideoAd rewardVideoAd = this.ad;
        if (rewardVideoAd != null) {
            rewardVideoAd.sendLossNotification(map);
        }
    }

    @Override // com.kc.dw.core.ad.a, com.kc.dw.core.s2s.ISBidding
    public void sendWinNotification(Map map) {
        RewardVideoAd rewardVideoAd = this.ad;
        if (rewardVideoAd != null) {
            rewardVideoAd.sendWinNotification(map);
        }
    }
}
