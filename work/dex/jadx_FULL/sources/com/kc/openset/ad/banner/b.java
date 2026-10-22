package com.kc.openset.ad.banner;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.BaseAdCache;
import com.kc.openset.ad.base.Base;
import com.kc.openset.ad.base.BaseAd;
import com.kc.openset.ad.listener.OSETBannerAdLoadListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class b<T extends Base> extends BaseAd<T> {
    static {
        OSETSDKProtected.interface11(3734);
    }

    @Override // com.kc.openset.ad.base.BaseAd
    public native BaseAdCache createAdCache();

    @Override // com.kc.openset.ad.base.BaseAd
    public native BaseAdCache getSingleCacheObj();

    public native void loadAd(OSETBannerAdLoadListener oSETBannerAdLoadListener);

    public native void loadS2SAd(String str, OSETBannerAdLoadListener oSETBannerAdLoadListener);
}
