package com.kc.openset.config;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public enum ChannelType {
    DEFAULT(-1),
    BAIDU(1),
    TENCENT(2),
    OPPO(3),
    VIVO(4),
    HUAWEI(5),
    XIAOMI(6),
    JINLI(7),
    STORE360(8),
    ALI(9),
    MEIZU(10),
    OTHER(12);

    private int value;

    static {
        OSETSDKProtected.interface11(4391);
    }

    ChannelType(int i) {
        this.value = i;
    }

    public static native ChannelType valueOf(String str);

    public static native ChannelType[] values();

    public native int getValue();
}
