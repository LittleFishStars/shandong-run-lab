package com.kc.cw.ad;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface RewardVideoAdListener {
    void onRewardVideoAdClicked();

    void onRewardVideoAdClosed();

    void onRewardVideoAdComplete();

    void onRewardVideoAdFailedToLoad(int i);

    void onRewardVideoAdLoaded();

    void onRewardVideoAdShown();

    void onRewardVideoCached(boolean z);

    void onRewarded(RewardItem rewardItem);
}
