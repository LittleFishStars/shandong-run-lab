package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class AppTypeUtils {

    @Keep
    public enum AppType {
        COCOS(OSETSDKProtected.getString2(3040)),
        RN(OSETSDKProtected.getString2(1342)),
        FLUTTER(OSETSDKProtected.getString2(3043)),
        UNITY(OSETSDKProtected.getString2(3045)),
        Android(OSETSDKProtected.getString2(1690));

        String value;

        static {
            OSETSDKProtected.interface11(4919);
        }

        AppType(String str) {
            this.value = str;
        }

        public static native AppType valueOf(String str);

        public static native AppType[] values();
    }

    static {
        OSETSDKProtected.interface11(4920);
    }

    public static native String a();

    private static native boolean b();

    private static native boolean c();

    private static native boolean d();

    private static native boolean e();
}
