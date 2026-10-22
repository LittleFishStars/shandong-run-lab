package com.kc.openset.ad.base;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class BaseAdLoad$$ExternalSyntheticLambda5 implements ThreadUtils.UICallBack {
    public final BaseAdLoad f$0;
    public final com.kc.openset.ad.d f$1;

    static {
        OSETSDKProtected.interface11(3744);
    }

    public /* synthetic */ BaseAdLoad$$ExternalSyntheticLambda5(BaseAdLoad baseAdLoad, com.kc.openset.ad.d dVar) {
        this.f$0 = baseAdLoad;
        this.f$1 = dVar;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
