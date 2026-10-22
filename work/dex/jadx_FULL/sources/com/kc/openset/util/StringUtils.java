package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class StringUtils {
    static {
        OSETSDKProtected.interface11(4985);
    }

    public static native boolean match(String str, String str2);

    public static native List<String> splitId(String str, String str2, String str3, String str4);
}
