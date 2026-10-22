package com.kc.openset.pine.manager.tobid;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ToBidHookUtils {
    static {
        OSETSDKProtected.interface11(4643);
    }

    public static native <K, V> V computeIfAbsentCompat(Map<K, V> map, K k, ToBidSplashHook.Supplier<V> supplier);
}
