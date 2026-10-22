package com.kc.openset.util;

import android.app.Application;
import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Application f39974a;
    private static volatile Context b;

    static {
        OSETSDKProtected.interface11(5015);
    }

    public static native Application a();

    public static native void a(Application application);

    public static native Context b();

    private static native void c();
}
