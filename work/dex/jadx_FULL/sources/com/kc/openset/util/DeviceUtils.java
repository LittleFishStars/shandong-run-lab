package com.kc.openset.util;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final class DeviceUtils {
    static {
        OSETSDKProtected.interface11(4932);
    }

    private DeviceUtils() {
        throw new UnsupportedOperationException(OSETSDKProtected.getString2(3079));
    }

    public static native String a();

    public static native String a(Context context);

    public static native String a(String str, Context context);

    public static native boolean a(String str);

    public static native int b(String str, Context context);

    public static native String b();

    public static native String b(Context context);

    public static native int c(Context context);

    public static native String c();

    public static native String c(String str, Context context);

    public static native int d();

    public static native String d(Context context);

    public static native String e();
}
