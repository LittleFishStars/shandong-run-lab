package com.kc.dw.core.ad.paster;

import com.kc.dw.core.loader.IAdLoadListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface PasterAdListener extends IAdLoadListener<PasterAd> {
    void onVideoComplete();

    void onVideoError();

    void onVideoLoaded();
}
