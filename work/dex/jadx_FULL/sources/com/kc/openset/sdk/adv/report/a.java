package com.kc.openset.sdk.adv.report;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bean.e;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: com.kc.openset.sdk.adv.report.a$a, reason: collision with other inner class name */
    @Keep
    public class C1118a implements OSETHttpCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f39856a;
        final String b;
        final b c;
        final com.kc.openset.sdk.apiad.tools.c d;
        final com.kc.openset.sdk.adv.a.k e;

        static {
            OSETSDKProtected.interface11(4768);
        }

        public C1118a(String str, String str2, b bVar, com.kc.openset.sdk.apiad.tools.c cVar, com.kc.openset.sdk.adv.a.k kVar) {
            this.f39856a = str;
            this.b = str2;
            this.c = bVar;
            this.d = cVar;
            this.e = kVar;
        }

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onFailure(int i, String str);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onSuccess(int i, String str);
    }

    static {
        OSETSDKProtected.interface11(4769);
    }

    public static native com.kc.openset.sdk.adv.a.j a(int i, List<com.kc.openset.sdk.adv.a.j> list);

    private static native Object a(Map<String, Object> map, String str);

    private static native String a(String str);

    public static native String a(String str, Map<String, Object> map);

    public static native String a(Map<String, Object> map);

    private static native void a(int i, e eVar, com.kc.openset.sdk.apiad.tools.c cVar);

    private static native void a(b bVar, com.kc.openset.sdk.apiad.tools.c cVar);

    public static native void a(b bVar, String str, com.kc.openset.sdk.apiad.tools.c cVar, com.kc.openset.sdk.adv.a.k kVar);

    public static native void a(c cVar, b bVar, com.kc.openset.sdk.apiad.tools.c cVar2);

    private static native void a(Map<String, Object> map, Map<String, Object> map2, String... strArr);

    public static native void b(b bVar, com.kc.openset.sdk.apiad.tools.c cVar);
}
