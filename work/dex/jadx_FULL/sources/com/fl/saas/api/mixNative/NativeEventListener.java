package com.fl.saas.api.mixNative;

import com.fl.saas.config.exception.YdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface NativeEventListener {
    void onAdClicked(NativeAdView nativeAdView);

    void onAdClose(NativeAdView nativeAdView);

    void onAdFailed(NativeAdView nativeAdView, YdError ydError);

    void onAdImpressed(NativeAdView nativeAdView);

    void onAdVideoEnd(NativeAdView nativeAdView);

    void onAdVideoProgress(NativeAdView nativeAdView, long j);

    void onAdVideoStart(NativeAdView nativeAdView);
}
