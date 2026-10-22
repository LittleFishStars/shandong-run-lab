package com.kc.openset.util.notch;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f39980a;
    private final INotchScreen b = b();

    static {
        OSETSDKProtected.interface11(5029);
        f39980a = new a();
    }

    private a() {
    }

    public static native a a();

    private native INotchScreen b();

    public native void a(Activity activity);
}
