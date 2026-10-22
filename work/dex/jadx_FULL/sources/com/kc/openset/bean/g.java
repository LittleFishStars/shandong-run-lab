package com.kc.openset.bean;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.AdBridge;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.ad.config.AdapterType;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? extends AdBridge> f39717a;
    private final String b;
    private final AdapterType c;
    private final AdType d;

    @Keep
    public static /* synthetic */ class a {
    }

    @Keep
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<? extends AdBridge> f39718a;
        private String b;
        private AdapterType c;
        private AdType d = AdType.AD_TYPE_NO;

        static {
            OSETSDKProtected.interface11(4317);
        }

        public static native /* synthetic */ Class a(b bVar);

        public static native /* synthetic */ String b(b bVar);

        public static native /* synthetic */ AdapterType c(b bVar);

        public static native /* synthetic */ AdType d(b bVar);

        public native b a(AdType adType);

        public native b a(AdapterType adapterType);

        public native b a(Class<? extends AdBridge> cls);

        public native b a(String str);

        public native g a();
    }

    static {
        OSETSDKProtected.interface11(4318);
    }

    private g(b bVar) {
        this.f39717a = b.a(bVar);
        this.b = b.b(bVar);
        this.c = b.c(bVar);
        this.d = b.d(bVar);
    }

    public /* synthetic */ g(b bVar, a aVar) {
        this(bVar);
    }

    public native AdapterType a();

    public native String b();

    public native Class<? extends AdBridge> c();

    public native AdType d();
}
