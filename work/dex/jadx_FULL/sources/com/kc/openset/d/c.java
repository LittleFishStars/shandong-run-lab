package com.kc.openset.d;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.Closeable;
import java.io.File;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Charset f39761a;
    static final Charset b;

    static {
        OSETSDKProtected.interface11(4418);
        f39761a = Charset.forName(OSETSDKProtected.getString2(1684));
        b = Charset.forName(OSETSDKProtected.getString2(84));
    }

    public static native void a(Closeable closeable);

    public static native void a(File file);
}
