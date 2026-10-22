package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class PriceUtils {
    private static final int PRICE_RANGE = 10;
    private static final String TAG = OSETSDKProtected.getString2(3253);

    static {
        OSETSDKProtected.interface11(4982);
    }

    public static native double calNewPrice(double d, double d2);
}
