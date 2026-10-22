package com.kc.openset.bean;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public enum Orientation {
    HORIZONTAL,
    VERTICAL;

    static {
        OSETSDKProtected.interface11(4300);
    }

    public static native Orientation valueOf(String str);

    public static native Orientation[] values();
}
