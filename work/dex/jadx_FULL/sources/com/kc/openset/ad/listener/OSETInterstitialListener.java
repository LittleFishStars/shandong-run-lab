package com.kc.openset.ad.listener;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface OSETInterstitialListener extends OSETBaseListener {
    void onClick();

    void onClose();

    void onShow();
}
