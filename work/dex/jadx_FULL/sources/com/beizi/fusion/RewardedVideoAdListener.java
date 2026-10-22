package com.beizi.fusion;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface RewardedVideoAdListener extends i3 {
    void onRewarded();

    void onRewardedVideoAdClosed();

    void onRewardedVideoAdFailedToLoad(int i);

    void onRewardedVideoAdLoaded();

    void onRewardedVideoAdShown();

    void onRewardedVideoCacheSuccess();

    void onRewardedVideoClick();

    void onRewardedVideoComplete();

    void onRewardedVideoPlayError();
}
