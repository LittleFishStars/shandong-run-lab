package com.kc.cw.ad;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface InterstitialAdListener {
    void onAdCacheLoaded(boolean z);

    void onAdClicked();

    void onAdClosed();

    void onAdFailedToLoad(int i);

    void onAdLoaded();

    void onAdShown();
}
