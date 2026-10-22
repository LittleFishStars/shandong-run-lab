package com.kc.cw.ad;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface NativeAdListener {
    void onAdFailed(int i);

    void onAdLoaded(NativeAdResponse nativeAdResponse);
}
