package com.kc.openset.ad._native;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class OSETNative extends a<OSETNative> {
    private static volatile OSETNative INSTANCE;

    static {
        OSETSDKProtected.interface11(3722);
    }

    private OSETNative() {
    }

    public static native OSETNative getInstance();
}
