package com.kc.openset.common.okhttp;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class OkHttpScheduler$1$$ExternalSyntheticLambda3 implements Runnable {
    public final OSETHttpCallback f$0;
    public final Exception f$1;

    static {
        OSETSDKProtected.interface11(4384);
    }

    public /* synthetic */ OkHttpScheduler$1$$ExternalSyntheticLambda3(OSETHttpCallback oSETHttpCallback, Exception exc) {
        this.f$0 = oSETHttpCallback;
        this.f$1 = exc;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
