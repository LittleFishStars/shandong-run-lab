package com.kc.dw.platform.ad_adapter.splash;

import com.kc.dw.core.ad.IAdEventListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface SsdSplashOwnListener extends IAdEventListener<k> {
    void onAdSkip(k kVar);

    void onAdTick(long j);

    void onAdTimeOver(k kVar);
}
