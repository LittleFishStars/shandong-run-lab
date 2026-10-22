package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class NetWorkUtils {

    @Keep
    public enum NetworkType {
        NETWORK_ETHERNET,
        NETWORK_WIFI,
        NETWORK_5G,
        NETWORK_4G,
        NETWORK_3G,
        NETWORK_2G,
        NETWORK_UNKNOWN,
        NETWORK_NO;

        static {
            OSETSDKProtected.interface11(4939);
        }

        public static native NetworkType valueOf(String str);

        public static native NetworkType[] values();
    }

    static {
        OSETSDKProtected.interface11(4940);
    }

    public static native String a(boolean z);
}
