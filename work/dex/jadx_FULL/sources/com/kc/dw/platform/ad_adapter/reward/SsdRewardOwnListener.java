package com.kc.dw.platform.ad_adapter.reward;

import com.kc.dw.core.ad.IAdEventListener;
import com.kc.dw.core.ad.reward.RewardVideoAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface SsdRewardOwnListener extends IAdEventListener<RewardVideoAd> {
    void onVideoLoaded(RewardVideoAd rewardVideoAd);
}
