package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.security.SecureRandom;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile f0 f39971a;
    private final SecureRandom b = new SecureRandom();

    static {
        OSETSDKProtected.interface11(5007);
    }

    private f0() {
    }

    public static native f0 a();

    public native boolean a(double d);
}
