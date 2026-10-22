package com.kc.openset.util;

import android.os.Handler;
import android.os.Looper;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETNetworkRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ExecutorService f39963a;
    private static final Handler b;

    @Keep
    public @interface MethodType {
        public static final String GET = "GET";
        public static final String POST = "POST";
    }

    public static native /* synthetic */ void $r8$lambda$HimEUrkaBDGUg9LXxdu7iip_sVU(OSETHttpCallback oSETHttpCallback, boolean z, int i, String str);

    /* JADX INFO: renamed from: $r8$lambda$RGb-MwojAg3WEP94_77a7_ep-zI, reason: not valid java name */
    public static native /* synthetic */ void m1054$r8$lambda$RGbMwojAg3WEP94_77a7_epzI(OSETHttpCallback oSETHttpCallback, Exception exc);

    /* JADX INFO: renamed from: $r8$lambda$WnrEDv0JHhT-XL38_tpo5zdsQw4, reason: not valid java name */
    public static native /* synthetic */ void m1055$r8$lambda$WnrEDv0JHhTXL38_tpo5zdsQw4(String str, String str2, boolean z, Map map, String str3, OSETHttpCallback oSETHttpCallback);

    static {
        OSETSDKProtected.interface11(4981);
        f39963a = new ThreadPoolExecutor(4, 16, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(100), new ThreadPoolExecutor.AbortPolicy());
        b = new Handler(Looper.getMainLooper());
    }

    private static native String a(InputStream inputStream);

    private static native /* synthetic */ void a(OSETHttpCallback oSETHttpCallback, Exception exc);

    private static native /* synthetic */ void a(OSETHttpCallback oSETHttpCallback, boolean z, int i, String str);

    private static native void a(Runnable runnable);

    private static native void a(String str, String str2, Map<String, String> map, String str3, boolean z, OSETHttpCallback oSETHttpCallback);

    private static native /* synthetic */ void a(String str, String str2, boolean z, Map map, String str3, OSETHttpCallback oSETHttpCallback);

    public static native void a(String str, Map<String, String> map, OSETHttpCallback oSETHttpCallback);

    public static native void a(String str, Map<String, String> map, String str2, OSETHttpCallback oSETHttpCallback);
}
