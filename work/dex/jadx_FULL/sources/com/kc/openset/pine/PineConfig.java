package com.kc.openset.pine;

import android.os.Build;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class PineConfig {
    public static boolean antiChecks;
    public static boolean debug;
    public static boolean debuggable;
    public static boolean disableHiddenApiPolicy;
    public static boolean disableHiddenApiPolicyForPlatformDomain;
    public static boolean disableHooks;
    public static Pine.LibLoader libLoader;
    public static int sdkLevel;
    public static boolean useFastNative;

    static {
        OSETSDKProtected.interface11(4574);
        debug = true;
        disableHiddenApiPolicy = true;
        disableHiddenApiPolicyForPlatformDomain = true;
        libLoader = new Pine.LibLoader() { // from class: com.kc.openset.pine.PineConfig.1
            static {
                OSETSDKProtected.interface11(4573);
            }

            @Override // com.kc.openset.pine.Pine.LibLoader
            public native void loadLib();
        };
        int i = Build.VERSION.SDK_INT;
        sdkLevel = i;
        if (i == 34 && isAtLeastPreReleaseCodename(OSETSDKProtected.getString2(2060))) {
            sdkLevel = 35;
        }
    }

    private PineConfig() {
        throw new RuntimeException();
    }

    private static native boolean isAtLeastPreReleaseCodename(String str);
}
