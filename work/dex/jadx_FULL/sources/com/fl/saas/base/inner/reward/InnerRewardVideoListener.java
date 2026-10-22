package com.fl.saas.base.inner.reward;

import com.fl.saas.api.mixNative.NativeAd;
import com.fl.saas.common.saas.bean.AdSource;
import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface InnerRewardVideoListener {
    AdSource getRewardVideoAdSource();

    NativeAd getRewardVideoNativeAd();

    void onClick();

    void onClose();

    void onError(YdError ydError);

    void onReward();

    void onShow();

    void onVideoComplete();
}
