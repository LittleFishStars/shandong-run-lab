package com.kc.openset.ad.config;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public enum AdType {
    AD_TYPE_NO(-1),
    AD_TYPE_SPLASH(0),
    AD_TYPE_BANNER(1),
    AD_TYPE_INTERSTITIAL(2),
    AD_TYPE_FULL_VIDEO(3),
    AD_TYPE_REWARD(4),
    AD_TYPE_NATIVE(5),
    AD_TYPE_DRAW_NATIVE(6),
    AD_TYPE_SUSPEND(7),
    AD_INTERSTITIAL_TYPE_HORIZONTAL(8),
    AD_TYPE_NATIVE_VIEW(9),
    AD_TYPE_VIDEO_CONTENT_RECOMMEND(20),
    AD_TYPE_VIDEO_CONTENT_POPULAR(21),
    AD_TYPE_VIDEO_CONTENT_DISCOVER(22),
    AD_TYPE_VIDEO_CONTENT_TUBE(23);

    int code;

    static {
        OSETSDKProtected.interface11(3847);
    }

    AdType(int i) {
        this.code = i;
    }

    public static native AdType valueOf(String str);

    public static native AdType[] values();

    public native int getValue();
}
