package com.kc.openset.ad.config;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public enum DataType {
    NORMAL,
    BIDDING,
    FP;

    static {
        OSETSDKProtected.interface11(3849);
    }

    public static native DataType valueOf(String str);

    public static native DataType[] values();
}
