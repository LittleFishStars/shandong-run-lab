package com.kc.openset.advertisers.hl;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class NativeMaterialExtractor {

    @Keep
    public static class Result {
        public List<String> clk;
        public List<String> imp;
        public String url;

        static {
            OSETSDKProtected.interface11(4284);
        }

        public native String toString();
    }

    static {
        OSETSDKProtected.interface11(4285);
    }

    private static native String extractStringFromField(Object obj, String str);

    private static native List<String> extractStringListFromField(Object obj, String str);

    private static native List<String> extractTopLevelDomains(Object obj);

    public static native Result findNativeMaterialFields(Object obj);

    private static native Result findNativeMaterialFields(Object obj, Set<Object> set);

    private static native boolean shouldSkipClass(Class<?> cls);
}
