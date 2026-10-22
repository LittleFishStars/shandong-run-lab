package com.kc.openset.sdk.adv.listener;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface ADVSPlashListener extends ADVBaseListener {
    void onAdClick();

    void onAdClosed();

    void onAdDetailViewClosed();

    void onAdPreloadFailure(int i, String str);

    void onAdPreloadSuccess();

    void onAdShow();

    void onAdShowFailure(String str, String str2);

    void onAdSkip();
}
