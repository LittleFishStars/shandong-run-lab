package com.kc.openset.config;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class d$a$$ExternalSyntheticLambda0 implements DelayPreLoadUtils.DelayPreLoadListener {
    public final d.a f$0;
    public final com.kc.openset.bean.c f$1;

    static {
        OSETSDKProtected.interface11(4404);
    }

    public /* synthetic */ d$a$$ExternalSyntheticLambda0(d.a aVar, com.kc.openset.bean.c cVar) {
        this.f$0 = aVar;
        this.f$1 = cVar;
    }

    @Override // com.kc.openset.config.DelayPreLoadUtils.DelayPreLoadListener
    public final native void doLoad();
}
