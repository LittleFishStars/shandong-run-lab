package com.kc.openset.sdk.apiad;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public enum InteractType {
    UNKNOWN(0),
    APP_DOWNLOAD(1),
    DEEPLINK(2),
    LANDING_URL(3),
    MINI_PROGRAM(4),
    GDT_DOWNLOAD(5);

    private final int interactType;

    static {
        OSETSDKProtected.interface11(4772);
    }

    InteractType(int i) {
        this.interactType = i;
    }

    public static native InteractType valueOf(String str);

    public static native InteractType[] values();

    public native int getValue();
}
