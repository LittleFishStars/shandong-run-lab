package com.kc.openset.pine.manager.tobid;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ToBidUtils {
    private static final String NETWORK_REGEX = OSETSDKProtected.getString2(2360);
    private static final String PLACEMENT_ID_REGEX = OSETSDKProtected.getString2(2361);

    static {
        OSETSDKProtected.interface11(4673);
    }

    public static native String getNetwork(String str);

    public static native String getPatternInfo(String str, String str2);

    public static native String getPlacementId(String str);
}
