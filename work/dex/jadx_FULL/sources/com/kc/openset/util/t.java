package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.BaseHttpClientBridge;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile t f39982a;
    private BaseHttpClientBridge b;

    static {
        OSETSDKProtected.interface11(5038);
    }

    private t() {
        b();
    }

    public static native t a();

    private native void a(Map<String, String> map);

    private native void b();

    private native boolean c();

    public native void a(String str, Map<String, String> map, OSETHttpCallback oSETHttpCallback);

    public native void a(String str, Map<String, String> map, String str2, OSETHttpCallback oSETHttpCallback);
}
