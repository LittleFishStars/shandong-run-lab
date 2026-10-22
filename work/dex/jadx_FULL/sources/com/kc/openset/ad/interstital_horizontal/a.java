package com.kc.openset.ad.interstital_horizontal;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.BaseAdCache;
import com.kc.openset.ad.base.BaseAd;
import com.kc.openset.ad.listener.OSETInterstitialAdLoadListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class a extends BaseAd<a> {
    static {
        OSETSDKProtected.interface11(3863);
    }

    @Override // com.kc.openset.ad.base.BaseAd
    public native BaseAdCache createAdCache();

    @Override // com.kc.openset.ad.base.BaseAd
    public native BaseAdCache getSingleCacheObj();

    public native void loadAd(OSETInterstitialAdLoadListener oSETInterstitialAdLoadListener);

    public native void loadS2SAd(String str, OSETInterstitialAdLoadListener oSETInterstitialAdLoadListener);
}
