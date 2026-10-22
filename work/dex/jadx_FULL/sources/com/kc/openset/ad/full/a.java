package com.kc.openset.ad.full;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.BaseAdCache;
import com.kc.openset.ad.base.Base;
import com.kc.openset.ad.base.BaseAd;
import com.kc.openset.ad.listener.OSETFullAdLoadListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class a<T extends Base> extends BaseAd<T> {
    static {
        OSETSDKProtected.interface11(3859);
    }

    @Override // com.kc.openset.ad.base.BaseAd
    public native BaseAdCache createAdCache();

    @Override // com.kc.openset.ad.base.BaseAd
    public native BaseAdCache getSingleCacheObj();

    public native void loadAd(OSETFullAdLoadListener oSETFullAdLoadListener);

    public native void loadS2SAd(String str, OSETFullAdLoadListener oSETFullAdLoadListener);
}
