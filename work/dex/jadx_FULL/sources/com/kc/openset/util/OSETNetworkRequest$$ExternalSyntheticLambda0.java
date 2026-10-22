package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class OSETNetworkRequest$$ExternalSyntheticLambda0 implements Runnable {
    public final OSETHttpCallback f$0;
    public final boolean f$1;
    public final int f$2;
    public final String f$3;

    static {
        OSETSDKProtected.interface11(4977);
    }

    public /* synthetic */ OSETNetworkRequest$$ExternalSyntheticLambda0(OSETHttpCallback oSETHttpCallback, boolean z, int i, String str) {
        this.f$0 = oSETHttpCallback;
        this.f$1 = z;
        this.f$2 = i;
        this.f$3 = str;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
