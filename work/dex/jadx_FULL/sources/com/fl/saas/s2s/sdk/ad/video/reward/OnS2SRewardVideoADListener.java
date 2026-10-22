package com.fl.saas.s2s.sdk.ad.video.reward;

import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface OnS2SRewardVideoADListener {
    void onClick(String str);

    void onClose();

    void onComplete(double d);

    void onError(YdError ydError);

    void onLoad(S2SRewardVideoADManager s2SRewardVideoADManager);

    void onReward(double d);

    void onRewardVideoAdFailed(YdError ydError);

    void onSkip();
}
