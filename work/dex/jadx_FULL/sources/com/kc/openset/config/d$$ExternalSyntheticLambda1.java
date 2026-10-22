package com.kc.openset.config;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.util.ThreadUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class d$$ExternalSyntheticLambda1 implements ThreadUtils.ThreadCallBack {
    public final d f$0;
    public final com.kc.openset.bean.c f$1;

    static {
        OSETSDKProtected.interface11(4403);
    }

    public /* synthetic */ d$$ExternalSyntheticLambda1(d dVar, com.kc.openset.bean.c cVar) {
        this.f$0 = dVar;
        this.f$1 = cVar;
    }

    @Override // com.kc.openset.util.ThreadUtils.ThreadCallBack
    public final native void onThread();
}
