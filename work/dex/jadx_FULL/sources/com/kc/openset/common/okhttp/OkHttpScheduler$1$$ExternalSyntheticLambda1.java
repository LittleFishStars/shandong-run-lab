package com.kc.openset.common.okhttp;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final /* synthetic */ class OkHttpScheduler$1$$ExternalSyntheticLambda1 implements Runnable {
    public final OSETHttpCallback f$0;
    public final int f$1;
    public final String f$2;

    static {
        OSETSDKProtected.interface11(4382);
    }

    public /* synthetic */ OkHttpScheduler$1$$ExternalSyntheticLambda1(OSETHttpCallback oSETHttpCallback, int i, String str) {
        this.f$0 = oSETHttpCallback;
        this.f$1 = i;
        this.f$2 = str;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
