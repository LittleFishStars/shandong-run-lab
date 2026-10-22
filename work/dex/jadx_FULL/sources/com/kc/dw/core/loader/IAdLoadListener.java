package com.kc.dw.core.loader;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IAdLoadListener<T> {
    void onAdClosed();

    void onAdError();

    void onAdExposure();

    void onAdLoaded(T t);

    void onAdPlatformError(AdPlatformError adPlatformError);

    void onAdReady(T t);

    void onAdRenderFail(String str, int i);
}
