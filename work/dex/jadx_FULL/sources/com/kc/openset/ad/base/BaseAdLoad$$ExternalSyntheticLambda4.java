package com.kc.openset.ad.base;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bean.InitConfigBean;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class BaseAdLoad$$ExternalSyntheticLambda4 implements ThreadUtils.UICallBack {
    public final BaseAdLoad f$0;
    public final InitConfigBean f$1;
    public final String f$2;

    static {
        OSETSDKProtected.interface11(3743);
    }

    public /* synthetic */ BaseAdLoad$$ExternalSyntheticLambda4(BaseAdLoad baseAdLoad, InitConfigBean initConfigBean, String str) {
        this.f$0 = baseAdLoad;
        this.f$1 = initConfigBean;
        this.f$2 = str;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
