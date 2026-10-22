package com.kc.openset.ad.config;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public enum AdapterType {
    ADAPTER_TYPE_SPLASH,
    ADAPTER_TYPE_BANNER,
    ADAPTER_TYPE_INTERSTITIAL,
    ADAPTER_TYPE_FULL_VIDEO,
    ADAPTER_TYPE_REWARD,
    ADAPTER_TYPE_NATIVE,
    ADAPTER_TYPE_NATIVE_VIEW,
    ADAPTER_TYPE_DRAW_NATIVE,
    ADAPTER_TYPE_INTERSTITIAL_HORIZONTAL,
    ADAPTER_TYPE_VIDEO_CONTENT_RECOMMEND,
    ADAPTER_TYPE_VIDEO_CONTENT_POPULAR,
    ADAPTER_TYPE_VIDEO_CONTENT_DISCOVER,
    ADAPTER_TYPE_VIDEO_CONTENT_TUBE;

    static {
        OSETSDKProtected.interface11(3848);
    }

    public static native AdapterType valueOf(String str);

    public static native AdapterType[] values();
}
