package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class OSETNetworkRequest$$ExternalSyntheticLambda2 implements Runnable {
    public final String f$0;
    public final String f$1;
    public final boolean f$2;
    public final Map f$3;
    public final String f$4;
    public final OSETHttpCallback f$5;

    static {
        OSETSDKProtected.interface11(4979);
    }

    public /* synthetic */ OSETNetworkRequest$$ExternalSyntheticLambda2(String str, String str2, boolean z, Map map, String str3, OSETHttpCallback oSETHttpCallback) {
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = z;
        this.f$3 = map;
        this.f$4 = str3;
        this.f$5 = oSETHttpCallback;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
