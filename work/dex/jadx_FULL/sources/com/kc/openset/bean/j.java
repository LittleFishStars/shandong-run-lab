package com.kc.openset.bean;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.video.VideoContentBridge;
import com.kc.openset.ad.config.AdapterType;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? extends VideoContentBridge> f39723a;
    private final String b;
    private final AdapterType c;

    @Keep
    public static /* synthetic */ class a {
    }

    @Keep
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<? extends VideoContentBridge> f39724a;
        private String b;
        private AdapterType c;

        static {
            OSETSDKProtected.interface11(4325);
        }

        public static native /* synthetic */ Class a(b bVar);

        public static native /* synthetic */ String b(b bVar);

        public static native /* synthetic */ AdapterType c(b bVar);

        public native b a(AdapterType adapterType);

        public native b a(Class<? extends VideoContentBridge> cls);

        public native b a(String str);

        public native j a();
    }

    static {
        OSETSDKProtected.interface11(4326);
    }

    private j(b bVar) {
        this.f39723a = b.a(bVar);
        this.b = b.b(bVar);
        this.c = b.c(bVar);
    }

    public /* synthetic */ j(b bVar, a aVar) {
        this(bVar);
    }

    public native AdapterType a();

    public native String b();

    public native Class<? extends VideoContentBridge> c();
}
