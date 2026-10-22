package com.kc.openset.ad.base;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class BaseAdLoad$$ExternalSyntheticLambda1 implements ThreadUtils.UICallBack {
    public final BaseAdLoad f$0;
    public final String f$1;
    public final String f$2;

    static {
        OSETSDKProtected.interface11(3740);
    }

    public /* synthetic */ BaseAdLoad$$ExternalSyntheticLambda1(BaseAdLoad baseAdLoad, String str, String str2) {
        this.f$0 = baseAdLoad;
        this.f$1 = str;
        this.f$2 = str2;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
