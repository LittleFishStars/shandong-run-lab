package com.kc.openset.verify;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public enum ServiceVerifyType {
    INIT(OSETSDKProtected.getString2(2169)),
    CHECK(OSETSDKProtected.getString2(3495));

    private final String value;

    static {
        OSETSDKProtected.interface11(5046);
    }

    ServiceVerifyType(String str) {
        this.value = str;
    }

    public static native ServiceVerifyType valueOf(String str);

    public static native ServiceVerifyType[] values();

    public native String getValue();
}
