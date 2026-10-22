package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class OSETNetworkRequest$$ExternalSyntheticLambda1 implements Runnable {
    public final OSETHttpCallback f$0;
    public final Exception f$1;

    static {
        OSETSDKProtected.interface11(4978);
    }

    public /* synthetic */ OSETNetworkRequest$$ExternalSyntheticLambda1(OSETHttpCallback oSETHttpCallback, Exception exc) {
        this.f$0 = oSETHttpCallback;
        this.f$1 = exc;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
