package com.kc.openset.ad.base;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class h$$ExternalSyntheticLambda1 implements ThreadUtils.UICallBack {
    public final h f$0;
    public final int f$1;

    static {
        OSETSDKProtected.interface11(3826);
    }

    public /* synthetic */ h$$ExternalSyntheticLambda1(h hVar, int i) {
        this.f$0 = hVar;
        this.f$1 = i;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
