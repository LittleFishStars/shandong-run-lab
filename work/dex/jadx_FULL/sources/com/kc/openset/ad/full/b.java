package com.kc.openset.ad.full;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.BaseAdCache;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.config.AdapterType;
import com.kc.openset.ad.d;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class b extends BaseAdCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f39648a;

    static {
        OSETSDKProtected.interface11(3860);
    }

    public static native b a();

    @Override // com.kc.openset.ad.BaseAdCache
    public native void callBackLoadSuccess(d dVar, d dVar2);

    @Override // com.kc.openset.ad.BaseAdCache
    public native AdType getAdType();

    @Override // com.kc.openset.ad.BaseAdCache
    public native AdapterType getAdapterType();
}
