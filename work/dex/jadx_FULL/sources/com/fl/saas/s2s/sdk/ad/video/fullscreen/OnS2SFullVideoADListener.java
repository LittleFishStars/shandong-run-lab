package com.fl.saas.s2s.sdk.ad.video.fullscreen;

import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface OnS2SFullVideoADListener {
    void onClick(String str);

    void onClose();

    void onComplete(double d);

    void onError(YdError ydError);

    void onFullVideoAdFailed(YdError ydError);

    void onLoad(S2SFullVideoADManager s2SFullVideoADManager);
}
