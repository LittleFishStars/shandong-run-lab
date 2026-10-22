package com.kc.openset.sdk.apiad.tools;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public enum APIRewardAdEvent {
    SHOW,
    CLICK,
    SKIP,
    REWARD,
    VIDEO_END,
    VIDEO_ERROR,
    CLOSE;

    static {
        OSETSDKProtected.interface11(4866);
    }

    public static native APIRewardAdEvent valueOf(String str);

    public static native APIRewardAdEvent[] values();
}
