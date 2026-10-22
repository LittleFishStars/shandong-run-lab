package com.kc.openset;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Keep
public class VideoContentConfigData implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f39589a;
    private final int b;
    private final int c;
    public boolean d;

    @Keep
    public static /* synthetic */ class a {
    }

    @Keep
    public static final class b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f39590a;
        private int b;
        private int c;
        private boolean d;

        static {
            OSETSDKProtected.interface11(3679);
        }

        public static native /* synthetic */ String a(b bVar);

        public static native /* synthetic */ int b(b bVar);

        public static native /* synthetic */ int c(b bVar);

        public static native /* synthetic */ boolean d(b bVar);

        public native b a(int i);

        public native b a(String str);

        public native b a(boolean z);

        public native VideoContentConfigData a();

        public native b b(int i);
    }

    static {
        OSETSDKProtected.interface11(3680);
    }

    private VideoContentConfigData(b bVar) {
    }

    public /* synthetic */ VideoContentConfigData(b bVar, a aVar) {
        this(bVar);
    }

    public native int a();

    public native int b();

    public native String c();

    public native boolean d();
}
