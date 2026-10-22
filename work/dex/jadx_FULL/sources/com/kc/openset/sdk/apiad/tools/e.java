package com.kc.openset.sdk.apiad.tools;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f39921a;
    private final LinkedHashMap<String, HashMap<String, Object>> b = new LinkedHashMap<>();

    static {
        OSETSDKProtected.interface11(4888);
    }

    private e() {
    }

    public static native e a();

    public native HashMap<String, Object> a(String str);

    public native void a(String str, HashMap<String, Object> map);
}
