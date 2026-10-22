package com.kc.openset.ad;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class OSETHttpUtils$$ExternalSyntheticLambda0 implements ThreadUtils.UICallBack {
    public final OSETHttpUtils f$0;
    public final AdType f$1;
    public final String f$2;
    public final OSETHttpUtils.ICallBack f$3;
    public final String f$4;

    static {
        OSETSDKProtected.interface11(3717);
    }

    public /* synthetic */ OSETHttpUtils$$ExternalSyntheticLambda0(OSETHttpUtils oSETHttpUtils, AdType adType, String str, OSETHttpUtils.ICallBack iCallBack, String str2) {
        this.f$0 = oSETHttpUtils;
        this.f$1 = adType;
        this.f$2 = str;
        this.f$3 = iCallBack;
        this.f$4 = str2;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
