package com.kc.dw.platform.ad_adapter.paster;

import com.kc.dw.core.ad.IAdEventListener;
import com.kc.dw.core.ad.paster.PasterAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface SsdPasterOwnListener extends IAdEventListener<PasterAd> {
    void onVideoComplete();

    void onVideoLoaded();
}
