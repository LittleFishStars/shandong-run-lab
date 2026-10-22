package com.fl.saas.base.custom.rewardvideo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface CustomRewardVideoEventListener {
    void onReward();

    void onRewardedVideoAdClosed();

    void onRewardedVideoAdPlayClicked();

    void onRewardedVideoAdPlayEnd();

    void onRewardedVideoAdPlayFailed(String str, String str2);

    void onRewardedVideoAdPlayStart();
}
