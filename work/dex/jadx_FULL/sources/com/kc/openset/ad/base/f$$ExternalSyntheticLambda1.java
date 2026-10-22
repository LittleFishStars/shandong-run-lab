package com.kc.openset.ad.base;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class f$$ExternalSyntheticLambda1 implements ThreadUtils.UICallBack {
    public final f f$0;
    public final String f$1;
    public final String f$2;

    static {
        OSETSDKProtected.interface11(3813);
    }

    public /* synthetic */ f$$ExternalSyntheticLambda1(f fVar, String str, String str2) {
        this.f$0 = fVar;
        this.f$1 = str;
        this.f$2 = str2;
    }

    @Override // com.kc.openset.util.ThreadUtils.UICallBack
    public final native void onUIThread();
}
