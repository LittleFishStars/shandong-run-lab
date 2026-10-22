package com.kc.dw.core.ad.reward;

import com.kc.dw.core.loader.IAdLoadListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface RewardVideoAdListener extends IAdLoadListener<RewardVideoAd> {
    void onReward(Map<String, Object> map);

    void onVideoCached(RewardVideoAd rewardVideoAd);
}
