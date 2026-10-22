package com.kc.openset.ad;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.listener.AdLoadCacheListener;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class a$$ExternalSyntheticLambda0 implements ThreadUtils.UICallBack {
    public final a f$0;
    public final AdLoadCacheListener f$1;
    public final e f$2;
    public final String f$3;

    static {
        OSETSDKProtected.interface11(3727);
    }

    public /* synthetic */ a$$ExternalSyntheticLambda0(a aVar, AdLoadCacheListener adLoadCacheListener, e eVar, String str) {
        this.f$0 = aVar;
        this.f$1 = adLoadCacheListener;
        this.f$2 = eVar;
        this.f$3 = str;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
